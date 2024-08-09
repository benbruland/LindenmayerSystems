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

    public GrammarSymbol getOperationForSymbol(char symbol) {
        return this.grammarCharacters.get(symbol);
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
        char character = accumulatedGrammar.charAt(instructionIndex);
        GrammarSymbol symbolToExec = grammarCharacters.get(character);
        symbolToExec.exec();
    }

    public void clearAccumulatedGrammar() {
        this.accumulatedGrammar = new StringBuilder(this.axiom);
    }

    private void evaluateReplacements() {
        GrammarSymbol charToEval = null;
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < accumulatedGrammar.length(); i++) {
            charToEval = getOperationForSymbol(accumulatedGrammar.charAt(i));
            if (charToEval.isNonTerminal()) {
                temp.append(charToEval.getExpansion());
            } else {
                temp.append(charToEval.symbol);
            }
        }
        accumulatedGrammar = temp;
    }
}
