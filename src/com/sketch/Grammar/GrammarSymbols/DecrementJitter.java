package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class DecrementJitter extends GrammarSymbol {

    public DecrementJitter(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    public void exec() {
        turtle.decrementLengthJitter();
    }
}
