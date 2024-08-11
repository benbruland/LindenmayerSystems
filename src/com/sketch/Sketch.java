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
        symbolsToExecutePerFrame = 10000; // Symbols per frame
        GrammarSettings settings = GrammarSettingsLoader.loadGrammarFromConfigFile();
        initialDrawState = settings.initialDrawingState;
        settings.initialDrawingState.setX(displayWidth/2);
        settings.initialDrawingState.setY(displayHeight);

        turtle = new GrammarTurtle(this, TurtleState.Builder.BuildCopy(initialDrawState));
        Grammar turtleGrammar = GrammarFactory.createGrammarFromOperations(settings, turtle);
        turtle.setGrammar(turtleGrammar);
        background(0,0,0);

    }

    public void dispatchTurtleWithSettings() {
        instructionIndex = 0;
        GrammarSettings settings = GrammarSettingsLoader.loadGrammarFromConfigFile();
        turtle = new GrammarTurtle(this, TurtleState.Builder.BuildCopy(settings.initialDrawingState));
        turtle.setGrammar(GrammarFactory.createGrammarFromOperations(settings, turtle));
        turtle.setPosition(mouseX, mouseY);
        turtle.getGrammar().accumulateGrammar(settings.maxDepth);
        turtle.setSketchParams(initialDrawState);
        initialDrawState = settings.initialDrawingState;
        symbolsToExecutePerFrame = settings.symbolsDrawnPerFrame;
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
        dispatchTurtleWithSettings();
    }

    public void keyPressed() {
        if (key == 'R') {
            turtle.setGrammar(null);
            instructionIndex = 0;
            background(0);
        }
    }
}
