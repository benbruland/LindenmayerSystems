package com.sketch.Grammar.GrammarSymbols;
import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;


public class Forward extends GrammarSymbol  {
    private GrammarTurtle turtle;

    public Forward(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    public void exec() {
        turtle.forward(true);
    }
}

