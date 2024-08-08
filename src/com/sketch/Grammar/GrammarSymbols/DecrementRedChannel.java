package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class DecrementRedChannel extends GrammarSymbol {
    private GrammarTurtle turtle;

    public DecrementRedChannel(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.rgbColor = turtle.rgbColor.sub(turtle.colorDelta, 0, 0);
    }
}
