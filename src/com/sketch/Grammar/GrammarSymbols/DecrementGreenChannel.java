package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class DecrementGreenChannel extends GrammarSymbol {
    private GrammarTurtle turtle;

    public DecrementGreenChannel(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.rgbColor = turtle.rgbColor.sub(0, turtle.colorDelta, 0);
    }
}
