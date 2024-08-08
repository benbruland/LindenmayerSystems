package com.sketch;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Drawing.TurtleState;
import processing.core.PApplet;

public class Sketch extends PApplet {

    GrammarTurtle tortle;
    public void setup() {
        TurtleState initialState = new TurtleState.
                Builder()
                .setAlpha(255)
                .setAngleIncrement(5.0f)
                .setHeading(270)
                .setRed(255)
                .setBlue(140)
                .setGreen(140)
                .setLineLength(250)
                .setLineLengthScalar(0.85f)
                .setTurningAngle(30)
                .setY(displayHeight)
                .setX(displayWidth/2)
                .setLineWidth(250)
                .setColorChangeRate(20)
                .build();
        tortle = new GrammarTurtle(this,  null, initialState);
        background(0,0,0);
    }

    public void settings() {
        size(displayWidth, displayHeight);
        smooth(8);
    }

    public void draw() {

    }

    public void mousePressed() {
        tortle.setPosition(mouseX, mouseY);
        tortle.forward(true);
        tortle.turnRight();
        tortle.forward(true);
        tortle.incrementBlue();
    }
}
