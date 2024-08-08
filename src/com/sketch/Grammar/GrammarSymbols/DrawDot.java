package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class DrawDot extends GrammarSymbol {
    private GrammarTurtle turtle;

    public DrawDot(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        circle(turtle.turtleX, turtle.turtleY, turtle.drawWeight);

    }
}
