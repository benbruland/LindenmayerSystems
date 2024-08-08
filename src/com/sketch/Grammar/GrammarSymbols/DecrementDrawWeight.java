package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class DecrementDrawWeight extends GrammarSymbol {
    private GrammarTurtle turtle;

    public DecrementDrawWeight(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        turtle.drawWeight -= turtle.drawWeightIncrement;
        turtle.drawWeight = max(turtle.drawWeight, 1.);
        strokeWeight(turtle.drawWeight);
    }
}
