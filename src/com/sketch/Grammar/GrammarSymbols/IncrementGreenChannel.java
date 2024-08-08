package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class IncrementGreenChannel extends GrammarSymbol {
    private GrammarTurtle turtle;

    public IncrementGreenChannel(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.rgbColor = turtle.rgbColor.add(0, turtle.colorDelta, 0);
    }
}
