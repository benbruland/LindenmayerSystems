package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class IncrementBlueChannel extends GrammarSymbol {
    private GrammarTurtle turtle;

    public IncrementBlueChannel(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.rgbColor = turtle.rgbColor.add(0, 0, turtle.colorDelta);
    }
}
