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

    public GrammarTurtle(Sketch sketch, Grammar grammar, TurtleState initialState) {
        this.state = initialState;
        this.grammar = grammar;
        this.sketch = sketch;
        this.states = new Stack<>();
        SetSketchParams(initialState);
    }

    public void pushState() {
        states.push(this.state);
    }

    public void popState() {
        if (!states.empty()) {
            TurtleState newState = states.pop();
            SetSketchParams(newState);
        }
    }
    public void SetSketchParams(TurtleState state) {
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
        rotate(this.state.getTurningAngle());
    }

    public void forward() {
        float newX = this.state.getX() + cos(state.getHeading()) * state.getLineLength();
        float newY = this.state.getY() + sin(state.getHeading()) * state.getLineLength();

        sketch.line(this.state.getX(), this.state.getY(), newX, newY);

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

    }
}
