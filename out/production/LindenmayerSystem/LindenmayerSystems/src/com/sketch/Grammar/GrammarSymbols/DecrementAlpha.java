package com.sketch.Grammar.GrammarSymbols;
import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class DecrementAlpha extends GrammarSymbol {
    private GrammarTurtle turtle;

    public DecrementAlpha(char symbol, GrammarTurtle turtle) {
        super(symbol, turtle);
    }

    public void exec() {
        turtle.decrementAlpha();
    }
}
