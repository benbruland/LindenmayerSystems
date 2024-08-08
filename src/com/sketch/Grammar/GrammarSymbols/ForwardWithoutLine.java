package com.sketch.Grammar.GrammarSymbols;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Grammar.GrammarSymbol;

public class ForwardWithoutLine extends GrammarSymbol {
    private GrammarTurtle turtle;

    public ForwardWithoutLine(GrammarTurtle turtle) {
        this.turtle = turtle;
    }

    public void exec() {
        float newX = turtle.turtleX + cos(radians(turtle.heading)) * random(0.7 * turtle.lineLength, turtle.lineLength);
        float newY = turtle.turtleY + sin(radians(turtle.heading)) * random(0.7 * turtle.lineLength, turtle.lineLength);
        ScreenCell cell = cellMap.getCell(turtle.getX(), turtle.getY());
        cell.incDensity();

        if (turtle.polygonIsOpen) {
            vertex(turtle.turtleX, turtle.turtleY);
            vertex(newX, newY);
        }

        turtle.turtleX = newX;
        turtle.turtleY = newY;
        stroke(turtle.rgbColor.x, turtle.rgbColor.y, turtle.rgbColor.z, turtle.alpha - cell.getDensity());
        fill(turtle.rgbColor.x, turtle.rgbColor.y, turtle.rgbColor.z, turtle.alpha - cell.getDensity());
    }
}
