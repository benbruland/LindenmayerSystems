package com.sketch.Drawing.Utility;

import java.util.ArrayList;

public class WeightedBag<T> {

    private ArrayList<WeightedItem<T>> bagResidents;
    private ArrayList<Double> weights;

    public WeightedBag(ArrayList<WeightedItem<T>> options) {
        bagResidents = new ArrayList<>();
        weights = new ArrayList<>();

        for (WeightedItem item : options) {
            this.add(item);
        }
    }

    public WeightedBag() {
        bagResidents = new ArrayList<>();
        weights = new ArrayList<>();
    }

    public void add(WeightedItem<T> item) {
        double previousWeight = 0;

        if (weights.size() > 0) {
            previousWeight = weights.get(weights.size() - 1);
        }

        this.weights.add(item.weight + previousWeight);
        this.bagResidents.add(item);
    }

    public boolean isEmpty() {
        return this.bagResidents.isEmpty();
    }

    public T draw() {

        T drawnValue = null;
        double randomChoice = Math.random() * this.weights.get(weights.size() - 1);

        for (int i = 0; i < weights.size(); i++) {
            if (weights.get(i) > randomChoice) {
                drawnValue = bagResidents.get(i).value;
                break;
            }
        }

        return drawnValue;
    }
}
