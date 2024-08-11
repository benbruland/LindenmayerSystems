package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class IncrementColorChangeRate extends GrammarSymbol {

    public IncrementColorChangeRate(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    @Override
    public void exec() {
        turtle.incrementColorChangeRate();
    }
}
