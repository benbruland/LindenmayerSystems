package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class FlipHeading extends GrammarSymbol {
    private GrammarTurtle turtle;

    public FlipHeading(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.rotate(180);
    }

}
