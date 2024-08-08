package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class MultiplyLineLength extends GrammarSymbol {

    public MultiplyLineLength(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    public void exec() {
        turtle.multiplyLineLength();
    }
}
