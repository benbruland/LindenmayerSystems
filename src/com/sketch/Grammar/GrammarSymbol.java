package com.sketch.Grammar;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Drawing.Utility.WeightedBag;
import com.sketch.Drawing.Utility.WeightedItem;

public abstract class GrammarSymbol {

    char symbol;
    public WeightedBag<String> expansions;
    protected GrammarTurtle turtle;

    public abstract void exec();

    public GrammarSymbol(char symbol, GrammarTurtle turtle) {
        this.turtle = turtle;
        this.expansions = new WeightedBag<>();
        this.symbol = symbol;
    }

    public String getExpansion() {
        return expansions.draw();
    }

    public void addExpansion(WeightedItem<String> expansion) {
        this.expansions.add(expansion);
    }

    public boolean isNonTerminal() {
        return this.expansions != null && !this.expansions.isEmpty();
    }
}

