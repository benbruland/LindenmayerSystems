package com.sketch.Drawing.Utility;

public class WeightedItem<T> {
    T value;
    double weight;

    public WeightedItem(T item, double weight) {
        this.value = item;
        this.weight = weight;
    }
}
