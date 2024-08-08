package com.sketch;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Drawing.TurtleState;
import com.sketch.Drawing.Utility.GrammarSettings;
import com.sketch.Drawing.Utility.GrammarSettingsLoader;
import com.sketch.Grammar.Grammar;
import com.sketch.Grammar.GrammarFactory;
import processing.core.PApplet;

public class Sketch extends PApplet {
    int instructionIndex = 0;
    int symbolsToExecutePerFrame = 0;

    TurtleState initialDrawState;
    GrammarTurtle turtle;
    public void setup() {

        instructionIndex = 0;
        symbolsToExecutePerFrame = 1000; // Symbols per frame
        GrammarSettings settings = GrammarSettingsLoader.loadGrammarFromConfigFile();
        initialDrawState = settings.initialDrawingState;
        settings.initialDrawingState.setX(displayWidth/2);
        settings.initialDrawingState.setY(displayHeight);

        turtle = new GrammarTurtle(this,  settings.initialDrawingState);
        Grammar turtleGrammar = GrammarFactory.createGrammarFromOperations(settings, turtle);
        turtle.setGrammar(turtleGrammar);
        background(0,0,0);
    }

    public void settings() {
        size(displayWidth, displayHeight);
        smooth(8);
    }

    public void draw() {
        if (turtle.getGrammar() != null && turtle.getGrammar().getLength() > 0) {
            int postDrawInstructionIndex = instructionIndex + symbolsToExecutePerFrame;
            while (instructionIndex < turtle.getGrammar().getLength() && instructionIndex < postDrawInstructionIndex) {
                turtle.drawGrammar(instructionIndex);
                instructionIndex++;
            }
        }
    }

    public void mousePressed() {
        instructionIndex = 0;
        if (turtle.getGrammar() != null) {
            turtle.getGrammar().clearAccumulatedGrammar();
            turtle.getGrammar().accumulateGrammar(16);
            System.out.println(turtle.getGrammar().getLength());
        }
        initialDrawState.setX(mouseX);
        initialDrawState.setY(mouseY);
        turtle.setState(initialDrawState);
    }
}
