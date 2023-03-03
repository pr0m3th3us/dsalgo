package common;

import java.util.stream.IntStream;

public class ArrayParser {
}

class MyString implements CharSequence {
    private final String string;
    MyString(String string) {
        this.string = string;
    }
    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int index) {
        return string.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return string.subSequence(start, end);
    }

    @Override
    public IntStream chars() {
        return string.chars();
    }

    @Override
    public IntStream codePoints() {
        return string.codePoints();
    }
}

