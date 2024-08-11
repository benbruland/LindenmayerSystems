package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class DecrementColorChangeRate extends GrammarSymbol {

    public DecrementColorChangeRate(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    @Override
    public void exec() {
        turtle.decrementColorChangeRate();
    }
}
