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
        settings.initialDrawingState.setX(displayWidth/2);
        settings.initialDrawingState.setY(displayHeight);

        tortle = new GrammarTurtle(this,  null, settings.initialDrawingState);
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
