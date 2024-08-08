package com.sketch;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Drawing.TurtleState;
import com.sketch.Grammar.GrammarSymbol;
import com.sketch.Utility.GrammarSettings;
import com.sketch.Utility.GrammarSettingsLoader;
import processing.core.PApplet;

public class Sketch extends PApplet {

    GrammarTurtle tortle;
    public void setup() {
        System.out.println(System.getProperty("user.dir"));
        GrammarSettings settings = GrammarSettingsLoader.loadGrammarFromConfigFile();
        TurtleState initialState = new TurtleState.
                Builder()
                .setAlpha(255)
                .setAngleIncrement(5.0f)
                .setHeading(0)
                .setRed(255)
                .setBlue(140)
                .setGreen(140)
                .setLineLength(250)
                .setLineLengthScalar(0.85f)
                .setTurningAngle(20)
                .setY(displayHeight)
                .setX(displayWidth/2)
                .setLineWidth(25)
                .setColorChangeRate(20)
                .setColorChangeRateAcceleration(0.5f)
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
