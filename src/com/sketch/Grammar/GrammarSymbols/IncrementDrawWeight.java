package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class IncrementDrawWeight extends GrammarSymbol {
    private GrammarTurtle turtle;

    public IncrementDrawWeight(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.drawWeight += turtle.drawWeightIncrement;
        strokeWeight(turtle.drawWeight);
    }
}
