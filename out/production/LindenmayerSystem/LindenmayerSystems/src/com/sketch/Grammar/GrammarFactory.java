package com.sketch.Grammar;

import com.sketch.Drawing.GrammarTurtle;
import com.sketch.Drawing.Utility.GrammarOperation;
import com.sketch.Drawing.Utility.GrammarSettings;
import com.sketch.Drawing.Utility.WeightedItem;
import com.sketch.Grammar.GrammarSymbols.*;

import java.util.ArrayList;

public class GrammarFactory {
    private static GrammarSymbol createSymbolForOperation(GrammarOperation op, GrammarTurtle turtle) {
        char opSymbol = op.operationSymbol.charAt(0);
        GrammarSymbol newSymbol;
        switch (op.operationName.toLowerCase()) {
            case "closepolygon":
                newSymbol = new ClosePolygon(opSymbol, turtle);
                break;
            case "decreasecolordelta":
                newSymbol = new DecreaseColorDelta(opSymbol, turtle);
                break;
            case "decrementalpha":
                newSymbol = new DecrementAlpha(opSymbol, turtle);
                break;
            case "decrementbluechannel":
                newSymbol = new DecrementBlueChannel(opSymbol, turtle);
                break;
            case "decrementdrawweight":
                newSymbol = new DecrementDrawWeight(opSymbol, turtle);
                break;
            case "decrementgreenchannel":
                newSymbol = new DecrementGreenChannel(opSymbol, turtle);
                break;
            case "decrementredchannel":
                newSymbol = new DecrementRedChannel(opSymbol, turtle);
                break;
            case "decrementturningangle":
                newSymbol = new DecrementTurningAngle(opSymbol, turtle);
                break;
            case "dividelinelength":
                newSymbol = new DivideLineLength(opSymbol, turtle);
                break;
            case "drawdot":
                newSymbol = new DrawDot(opSymbol, turtle);
                break;
            case "flipheading":
                newSymbol = new FlipHeading(opSymbol, turtle);
                break;
            case "forward":
                newSymbol = new Forward(opSymbol, turtle);
                break;
            case "forwardwithoutline":
                newSymbol = new ForwardWithoutLine(opSymbol, turtle);
                break;
            case "increasecolordelta":
                newSymbol = new IncreaseColorDelta(opSymbol, turtle);
                break;
            case "incrementbluechannel":
                newSymbol = new IncrementBlueChannel(opSymbol, turtle);
                break;
            case "incrementdrawweight":
                newSymbol = new IncrementDrawWeight(opSymbol, turtle);
                break;
            case "incrementgreenchannel":
                newSymbol = new IncrementGreenChannel(opSymbol, turtle);
                break;
            case "incrementredchannel":
                newSymbol = new IncrementRedChannel(opSymbol, turtle);
                break;
            case "incrementturningangle":
                newSymbol = new IncrementTurningAngle(opSymbol, turtle);
                break;
            case "invertturningsign":
                newSymbol = new InvertTurningSign(opSymbol, turtle);
                break;
            case "left":
                newSymbol = new Left(opSymbol, turtle);
                break;
            case "multiplylinelength":
                newSymbol = new MultiplyLineLength(opSymbol, turtle);
                break;
            case "openpolygon":
                newSymbol = new OpenPolygon(opSymbol, turtle);
                break;
            case "popstate":
                newSymbol = new PopState(opSymbol, turtle);
                break;
            case "pushstate":
                newSymbol = new PushState(opSymbol, turtle);
                break;
            case "right":
                newSymbol = new Right(opSymbol, turtle);
                break;
            default:
                return null;
        }

        for (WeightedItem expansion : op.operationExpansionWeights) {
            newSymbol.addExpansion(expansion);
        }

        return newSymbol;
    }

    public static Grammar createGrammarFromOperations(GrammarSettings settings, GrammarTurtle turtle) {
        Grammar newGrammar = new Grammar(new StringBuilder(settings.axiom), turtle);

        for (GrammarOperation op : settings.grammarOperations) {
            GrammarSymbol symbol = createSymbolForOperation(op, turtle);
            newGrammar.addSymbol(symbol);
        }

        return newGrammar;
    }
}
