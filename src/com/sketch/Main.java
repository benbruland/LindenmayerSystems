package com.sketch;
import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        String[] processingArgs = { "Sketch" };
        Sketch mySketch = new Sketch();

        PApplet.runSketch(processingArgs, mySketch);
    }
}