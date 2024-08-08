package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class DecrementBlueChannel extends GrammarSymbol {
    private GrammarTurtle turtle;

    public DecrementBlueChannel(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.rgbColor = turtle.rgbColor.sub(0, 0, turtle.colorDelta);
    }
}
