package com.sketch.Drawing;

import com.sketch.Grammar.Grammar;
import com.sketch.Sketch;

import java.util.Stack;

import static processing.core.PApplet.*;

public class GrammarTurtle {
    private TurtleState state;
    private Sketch sketch;
    private Stack<TurtleState> states;
    private Grammar grammar;

    public GrammarTurtle(Sketch sketch, TurtleState initialState) {
        this.state = initialState;
        this.sketch = sketch;
        this.states = new Stack<>();
        setSketchParams(initialState);
    }

    public void drawGrammar(int instructionIndex) {
        grammar.execGrammar(instructionIndex);
    }

    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
    }

    public void setState(TurtleState state) {
        this.states = new Stack<>();
        this.state = state;
    }

    public Grammar getGrammar() {
        return this.grammar;
    }

    public void pushState() {
        states.push(TurtleState.Builder.BuildCopy(this.state));
    }

    public void popState() {
        if (!states.empty()) {
            TurtleState newState = states.pop();
            this.state = newState;
            setSketchParams(newState);
        }
    }

    public void setSketchParams(TurtleState state) {
        sketch.stroke(state.getRed(), state.getBlue(), state.getGreen(), state.getAlpha());
        sketch.strokeWeight(state.getLineWidth());
        sketch.fill(state.getRed(), state.getBlue(), state.getGreen(), state.getAlpha());

        if (this.state.isPolygonIsOpen() != state.isPolygonIsOpen() && state.isPolygonIsOpen()) {
            sketch.beginShape();
        }

        if (this.state.isPolygonIsOpen() != state.isPolygonIsOpen() && !state.isPolygonIsOpen()) {
            sketch.endShape();
        }

    }

    public void rotate(float degreesOfRotation) {
        this.state.setHeading(this.state.getHeading() + degreesOfRotation);
    }

    public void turnRight() {
        rotate(this.state.getTurningAngle());
    }

    public void turnLeft() {
        rotate(-this.state.getTurningAngle());
    }

    public void forward(boolean withLine) {
        float newX = this.state.getX() + cos(radians(this.state.getHeading())) * this.state.getLineLength(); ////random(turtle.lineLength * 0.4, turtle.lineLength * 1.5);
        float newY = this.state.getY() + sin(radians(this.state.getHeading())) * this.state.getLineLength(); //random(turtle.lineLength * 0.4, turtle.lineLength * 1.5);

        if (withLine) {
            sketch.line(this.state.getX(), this.state.getY(), newX, newY);
        }

        if (this.state.isPolygonIsOpen()) {
            this.sketch.vertex(newX, newY);
        }

        this.state.setX(newX);
        this.state.setY(newY);
    }

    public void setPosition(float x, float y) {
        this.state.setX(x);
        this.state.setY(y);
    }
    public void setRed(float red) {
        this.state.setRed(red);
    }

    public void setBlue(float blue) {
        this.state.setBlue(blue);
    }

    public void setGreen(float green) {
        this.state.setGreen(green);
    }


    public void openPolygon() {
        if (!this.state.isPolygonIsOpen()) {
            sketch.beginShape();
            this.state.setPolygonIsOpen(true);
        }
    }

    public void closePolygon() {
        if (this.state.isPolygonIsOpen()) {
            this.state.setPolygonIsOpen(false);
            sketch.endShape();
        }
    }


    public void setAlpha(float alpha) {
        if (alpha > 255) {
            alpha = 255;
        }

        if (alpha < 0) {
            alpha = 0;
        }

        this.state.setAlpha(alpha);
    }

    public void adjustAlpha(float amount) {
        setAlpha(this.state.getAlpha() + amount);
    }

    public void decrementAlpha() {
        adjustAlpha(this.state.getAlphaIncrement());
    }

    public void incrementAlpha() {
        adjustAlpha(-this.state.getAlphaIncrement());
    }

    public void multiplyLineLength() {
        this.state.setLineLength(this.state.getLineLength() * this.state.getLineLengthScalar());
    }

    public void divideLineLength() {
        this.state.setLineLength(this.state.getLineLength() / this.state.getLineLengthScalar());
    }

    public void invertTurningSign() {
        this.state.setTurningSign(-1.0f * this.state.getTurningSign());
    }

    public void incrementTurningAngle() {
        this.state.setTurningAngle(this.state.getTurningAngle() + this.state.getAngleIncrement());
    }

    public void decrementTurningAngle() {
        this.state.setTurningAngle(this.state.getTurningAngle() - this.state.getAngleIncrement());
    }

    public void incrementRed() {
        this.state.setRed(this.state.getRed() + this.state.getColorChangeRate());
    }
    public void incrementBlue() {
        this.state.setRed(this.state.getBlue() + this.state.getColorChangeRate());
    }

    public void incrementGreen() {
        this.state.setRed(this.state.getGreen() + this.state.getColorChangeRate());
    }

    public void decrementRed() {
        this.state.setRed(this.state.getRed() - this.state.getColorChangeRate());
    }

    public void deccrementBlue() {
        this.state.setRed(this.state.getBlue() - this.state.getColorChangeRate());
    }

    public void decrementGreen() {
        this.state.setRed(this.state.getGreen() - this.state.getColorChangeRate());
    }

    public void incrementLineWidth() {
        this.state.setLineWidth(this.state.getLineWidth() + this.state.getLineWidthIncrement());
    }

    public void decrementLineWidth() {
        float newWidth = max(this.state.getLineWidth() - this.state.getLineWidthIncrement(), 0.01f);
        this.state.setLineWidth(newWidth);
    }

    public void increaseColorChangeRate() {
        this.state.setColorRateAcceleration(this.state.getColorChangeRate() + this.state.getColorRateAcceleration());
    }

    public void decreaseColorChangeRate() {
        this.state.setColorRateAcceleration(this.state.getColorChangeRate() - this.state.getColorRateAcceleration());
    }

    public void drawDot() {
        sketch.circle(this.state.getX(), this.state.getY(), this.state.getLineWidth());
    }
}
