package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class OpenPolygon extends GrammarSymbol {


    public OpenPolygon(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    public void exec() {
        turtle.openPolygon();
    }
}
