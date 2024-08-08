package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class Left extends GrammarSymbol {

    public Left(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    public void exec() {
        turtle.turnLeft();
    }
}
