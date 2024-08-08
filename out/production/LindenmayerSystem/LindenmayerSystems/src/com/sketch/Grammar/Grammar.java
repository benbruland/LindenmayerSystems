package com.sketch.Grammar;

import com.sketch.Drawing.GrammarTurtle;

import java.util.HashMap;

public class Grammar {
    private StringBuilder accumulatedGrammar;
    private StringBuilder axiom;

    private GrammarTurtle turtle;
    private HashMap<Character, GrammarSymbol> grammarCharacters;

    private int grammarSize = 0;

    public Grammar(StringBuilder axiom, GrammarTurtle turtle) {
        this.axiom = axiom;
        this.accumulatedGrammar = axiom;
        this.grammarCharacters = new HashMap<>();
        this.turtle = turtle;
    }

    // Map the grammarSymbol object to its character form
    public void addSymbol(GrammarSymbol symbol) {
        if (!grammarCharacters.containsKey(symbol.symbol)) {
            grammarCharacters.put(symbol.symbol, symbol);
        }
    }

    public void accumulateGrammar(int numTimes) {
        for (int i = 0; i < numTimes; i++) {
            this.evaluateReplacements();
        }
        this.grammarSize = this.accumulatedGrammar.length();
    }

    public int getLength() {
        return this.grammarSize;
    }

    public void execGrammar(int instructionIndex) {
        grammarCharacters.get(accumulatedGrammar.charAt(instructionIndex)).exec();
    }

    public void clearAccumulatedGrammar() {
        this.accumulatedGrammar = new StringBuilder(this.axiom);
    }

    private void evaluateReplacements() {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < accumulatedGrammar.length(); i++) {
            Character currentChar = accumulatedGrammar.charAt(i);
            if (grammarCharacters.containsKey(currentChar) && grammarCharacters.get(currentChar).isNonTerminal()) {
                String expansion = grammarCharacters.get(currentChar).getExpansion();
                temp.append(expansion);
            }
        }
        accumulatedGrammar = temp;
    }
}
