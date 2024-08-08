package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class NoOp extends GrammarSymbol {

    public NoOp(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    @Override
    public void exec() {
        return;
    }
}
