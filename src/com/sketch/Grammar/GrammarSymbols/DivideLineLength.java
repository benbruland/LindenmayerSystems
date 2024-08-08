package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class DivideLineLength extends GrammarSymbol {
    private GrammarTurtle turtle;

    public DivideLineLength(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.lineLength /= turtle.scaleFactor;
    }
}
