package com.sketch.Grammar;

import java.util.HashMap;

public class Grammar {
    private StringBuilder accumulatedGrammar;
    private StringBuilder axiom;
    private HashMap<Character, GrammarSymbol> grammarCharacters;

    public Grammar(StringBuilder axiom, HashMap<Character, GrammarSymbol> grammarActionMap) {
        this.axiom = axiom;
        this.grammarCharacters = grammarActionMap;
    }

    public void accumulateGrammar(int numTimes) {
        for (int i = 0; i < numTimes; i++) {
            this.evaluateReplacements();
        }
    }

    public void clearAccumulatedGrammar() {
        this.accumulatedGrammar = new StringBuilder("");
    }

    private void evaluateReplacements() {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < accumulatedGrammar.length(); i++) {
            Character currentChar = accumulatedGrammar.charAt(i);
            if (grammarCharacters.containsKey(currentChar) && grammarCharacters.get(currentChar).isNonTerminal()) {
                StringBuilder expansion = grammarCharacters.get(currentChar).getExpansion();
                temp.append(expansion);
            }
        }

        accumulatedGrammar = temp;
    }
}
