package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class IncreaseColorDelta extends GrammarSymbol {

    private GrammarTurtle turtle;

    public IncreaseColorDelta(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.colorDelta += 5.0;
    }
}
