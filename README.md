Lindenmayer System Evaluator, implementation done in Java using the processing library core.

Relies on GSON, processing core

GrammarConfig.json holds initial renderer state parameters. 
These parameters (grammar, renderer state) are reloaded prior to rendering after a mouse click from `./resources/grammarConfig.json`

The 'NoOp' operation is used to define non-terminal characters which expand into replacements sequences without affecting the rendered fractal directly themselves.

Shift + R clears the render window and resets the rendering state.
