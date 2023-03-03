package common;

public class InputReaderBuilder {
    public static InputReader defaultReader() {
        return new InputReader();
    }
    public InputReader build() {
        return new InputReader();
    }
    
    public InputReaderBuilder withSeparator() {
        return this;
    }
}
