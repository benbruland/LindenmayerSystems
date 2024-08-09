package com.sketch.Drawing;

public class TurtleState {

    private float lineWidth;
    private float lineLength;
    private float lineLengthScalar;
    private float turningAngle;
    private float angleIncrement;
    private float heading;
    private float colorChangeRate;
    private float red;
    private float green;
    private float blue;
    private float x;
    private float y;
    private boolean polygonIsOpen;
    private float turningSign = 1.0f;
    private float alpha;

    private float colorRateAcceleration;

    private float alphaIncrement;

    private float lineWidthIncrement;

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public float getLineLength() {
        return lineLength;
    }

    public void setLineLength(float lineLength) {
        this.lineLength = lineLength;
    }

    public float getLineLengthScalar() {
        return lineLengthScalar;
    }

    public void setLineLengthScalar(float lineLengthScalar) {
        this.lineLengthScalar = lineLengthScalar;
    }

    public float getTurningAngle() {
        return turningAngle * turningSign;
    }

    public void setTurningAngle(float turningAngle) {
        this.turningAngle = turningAngle;
    }

    public float getAngleIncrement() {
        return angleIncrement;
    }

    public void setAngleIncrement(float angleIncrement) {
        this.angleIncrement = angleIncrement;
    }

    public float getHeading() {
        return heading;
    }

    public void setHeading(float heading) {
        this.heading = heading;
    }

    public float getColorChangeRate() {
        return colorChangeRate;
    }

    public void setColorChangeRate(float colorChangeRate) {
        this.colorChangeRate = colorChangeRate;
    }

    public float getRed() {
        return red;
    }

    public void setRed(float red) {
        this.red = red;
    }

    public float getGreen() {
        return green;
    }

    public void setGreen(float green) {
        this.green = green;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isPolygonIsOpen() {
        return polygonIsOpen;
    }

    public void setPolygonIsOpen(boolean polygonIsOpen) {
        this.polygonIsOpen = polygonIsOpen;
    }

    public float getTurningSign() {
        return turningSign;
    }

    public void setTurningSign(float turningSign) {
        this.turningSign = turningSign;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getAlphaIncrement() {
        return alphaIncrement;
    }

    public void setAlphaIncrement(float alphaIncrement) {
        this.alphaIncrement = alphaIncrement;
    }

    public float getLineWidthIncrement() {
        return lineWidthIncrement;
    }

    public void setDrawWeightIncrement(float lineWidthIncrement) {
        this.lineWidthIncrement = lineWidthIncrement;
    }

    public float getColorRateAcceleration() {
        return colorRateAcceleration;
    }

    public void setColorRateAcceleration(float colorRateAcceleration) {
        this.colorRateAcceleration = colorRateAcceleration;
    }

    public void setLineWidthIncrement(float lineWidthIncrement) {
        this.lineWidthIncrement = lineWidthIncrement;
    }

    public float getLineLengthIncrement() {
        return lineLengthIncrement;
    }

    public void setLineLengthIncrement(float lineLengthIncrement) {
        this.lineLengthIncrement = lineLengthIncrement;
    }

    private float lineLengthIncrement;

    // Private constructor to prevent direct instantiation
    private TurtleState(Builder builder) {
        this.lineWidth = builder.lineWidth;
        this.lineLength = builder.lineLength;
        this.lineLengthScalar = builder.lineLengthScalar;
        this.turningAngle = builder.turningAngle;
        this.angleIncrement = builder.angleIncrement;
        this.heading = builder.heading;
        this.colorChangeRate = builder.colorChangeRate;
        this.red = builder.red;
        this.green = builder.green;
        this.blue = builder.blue;
        this.x = builder.x;
        this.y = builder.y;
        this.turningSign = builder.turningSign;
        this.alpha = builder.alpha;
        this.alphaIncrement = builder.alphaIncrement;
        this.lineWidthIncrement = builder.lineWidthIncrement;
        this.lineLengthIncrement = builder.lineLengthIncrement;
        this.polygonIsOpen = builder.polygonIsOpen;
        this.colorRateAcceleration = builder.colorChangeRateAcceleration;
    }

    public static class Builder {
        private float lineWidth;
        private float lineLength;
        private float lineLengthScalar;
        private float turningAngle;
        private float angleIncrement;
        private float heading;
        private float colorChangeRate;
        private float red;
        private float green;
        private float blue ;
        private float x;
        private float y;
        private float turningSign;
        private float alpha;
        private float colorChangeRateAcceleration;
        private float alphaIncrement;
        private float lineWidthIncrement;
        private float lineLengthIncrement;

        private float colorRateAcceleration;

        private boolean polygonIsOpen;


        public Builder setLineWidth(float lineWidth) {
            this.lineWidth = lineWidth;
            return this;
        }

        public Builder setColorChangeRateAcceleration(float rate) {
            this.colorChangeRateAcceleration = rate;
            return this;
        }

        public Builder setLineLength(float lineLength) {
            this.lineLength = lineLength;
            return this;
        }

        public Builder setLineLengthScalar(float lineLengthScalar) {
            this.lineLengthScalar = lineLengthScalar;
            return this;
        }

        public Builder setTurningAngle(float turningAngle) {
            this.turningAngle = turningAngle;
            return this;
        }

        public Builder setAngleIncrement(float angleIncrement) {
            this.angleIncrement = angleIncrement;
            return this;
        }

        public Builder setHeading(float heading) {
            this.heading = heading;
            return this;
        }

        public Builder setColorChangeRate(float colorChangeRate) {
            this.colorChangeRate = colorChangeRate;
            return this;
        }

        public Builder setRed(float red) {
            this.red = red;
            return this;
        }

        public Builder setGreen(float green) {
            this.green = green;
            return this;
        }

        public Builder setBlue(float blue) {
            this.blue = blue;
            return this;
        }

        public Builder setX(float x) {
            this.x = x;
            return this;
        }

        public Builder setY(float y) {
            this.y = y;
            return this;
        }

        public Builder setTurningSign(float turningSign) {
            this.turningSign = turningSign;
            return this;
        }

        public Builder setAlpha(float alpha) {
            this.alpha = alpha;
            return this;
        }

        public Builder setAlphaIncrement(float alphaIncrement) {
            this.alphaIncrement = alphaIncrement;
            return this;
        }

        public Builder setDrawWeightIncrement(float lineWidthIncrement) {
            this.lineWidthIncrement = lineWidthIncrement;
            return this;
        }

        public Builder setLineLengthIncrement(float lineLengthIncrement) {
            this.lineLengthIncrement = lineLengthIncrement;
            return this;
        }

        public TurtleState build() {
            return new TurtleState(this);
        }

        public static TurtleState BuildCopy(TurtleState state) {
            Builder copyBuilder = new Builder();
            copyBuilder.lineWidth = state.lineWidth;
            copyBuilder.lineLength = state.lineLength;
            copyBuilder.lineLengthScalar = state.lineLengthScalar;
            copyBuilder.turningAngle = state.turningAngle;
            copyBuilder.angleIncrement = state.angleIncrement;
            copyBuilder.heading = state.heading;
            copyBuilder.colorChangeRate = state.colorChangeRate;
            copyBuilder.red = state.red;
            copyBuilder.green = state.green;
            copyBuilder.blue = state.blue;
            copyBuilder.x = state.x;
            copyBuilder.y = state.y;
            copyBuilder.polygonIsOpen = state.polygonIsOpen;
            copyBuilder.turningSign = state.turningSign;
            copyBuilder.alpha = state.alpha;
            copyBuilder.colorRateAcceleration = state.colorRateAcceleration;
            copyBuilder.alphaIncrement = state.alphaIncrement;
            copyBuilder.lineWidthIncrement = state.lineWidthIncrement;

            return copyBuilder.build();
        }
    }
}
