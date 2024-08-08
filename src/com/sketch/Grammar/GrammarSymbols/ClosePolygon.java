package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class ClosePolygon extends GrammarSymbol {
    private GrammarTurtle turtle;

    public ClosePolygon(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    public void exec() {
        turtle.closePolygon();
    }
}
