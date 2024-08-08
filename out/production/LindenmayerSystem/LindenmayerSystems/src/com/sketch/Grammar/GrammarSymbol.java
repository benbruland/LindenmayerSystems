package com.sketch.Grammar;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Utility.WeightedBag;
import com.sketch.Utility.WeightedItem;

public abstract class GrammarSymbol {

    char symbol;
    public WeightedBag<StringBuilder> expansions;
    protected final GrammarTurtle turtle;

    public abstract void exec();

    public GrammarSymbol(char symbol, GrammarTurtle turtle) {
        this.turtle = turtle;
        this.expansions = new WeightedBag<>();
        this.symbol = symbol;
    }

    public StringBuilder getExpansion() {
        return expansions.draw();
    }

    public void addExpansion(StringBuilder expansion, double weight) {
        this.expansions.add(new WeightedItem<StringBuilder>(expansion, weight));
    }

    public boolean isNonTerminal() {
        return this.expansions.isEmpty();
    }
}

