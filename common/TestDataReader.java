package common;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public interface TestDataReader<T> {

    TestDataReader<T> commaSeparated();

    TestDataReader<T> spaceSeparated();

    TestDataReader<T> squareBracketsEnclosed();

    TestDataReader<T> bracesEnclosed();

    TestDataReader<T> notEnclosed();

    T read();

}

abstract class TestInputFileReader<T> implements TestDataReader<T> {

    private final Scanner scanner;
    private String separator;
    private String opener;
    private String closer;

    protected TestInputFileReader() {
        try {
            scanner = new Scanner(new File("./common/test-input"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TestDataReader<T> commaSeparated() {
        separator = ",";
        return this;
    }

    @Override
    public TestDataReader<T> spaceSeparated() {
        separator = " ";
        return this;
    }

    @Override
    public TestDataReader<T> squareBracketsEnclosed() {
        opener = "[";
        closer = "]";
        return null;
    }

    @Override
    public TestDataReader<T> bracesEnclosed() {
        opener = "{";
        closer = "}";
        return null;
    }

    @Override
    public TestDataReader<T> notEnclosed() {
        opener = null;
        closer = null;
        return this;
    }


    @Override
    public T read() {
        if (!scanner.hasNextLine()) reportTestFileDataIssue("no data");
        String line = sanitize(scanner.nextLine());
        String[] splits = Stream.of(line.split(separator == null ? "" : separator)).map(String::trim).toArray(String[]::new);
        T result = readValues(splits);
        scanner.close();
        return result;
    }

    protected abstract T readValues(String[] splits);

    protected void reportTestFileDataIssue(String data) {
        throw new IllegalArgumentException("test-input file doesn't have data or has invalid data:" + data);
    }

    private String sanitize(String text) {
        if (text == null) reportTestFileDataIssue(null);
        assert text != null;
        text = text.trim();
        if (text.equals("")) reportTestFileDataIssue("empty");
        if (opener != null && text.startsWith(opener))   text = StringUtils.stripStart(text, opener);
        if (closer != null && text.endsWith(closer))     text = StringUtils.stripEnd(text, closer);
        return text;
    }

}

class IntegerReader extends TestInputFileReader<Integer> {

    @Override
    protected Integer readValues(String[] splits) {
        return Integer.parseInt(splits[0]);
    }
}

class IntegerArrayReader extends TestInputFileReader<int[]> {
    @Override
    protected int[] readValues(String[] splits) {
        return Arrays.stream(splits).mapToInt(Integer::parseInt).toArray();
    }
}
class StringArrayReader extends TestInputFileReader<String[]> {
    @Override
    protected String[] readValues(String[] splits) {
        return splits;
    }
}

class StringListReader extends TestInputFileReader<List<String>> {
    @Override
    protected List<String> readValues(String[] splits) {
        return Arrays.asList(splits);
    }
}

class StringReader extends TestInputFileReader<String> {

    @Override
    protected String readValues(String[] splits) {
        return splits[0];
    }
}

class BinaryTreeReader extends TestInputFileReader<TreeNode> {
    private int order = 0; //0 - inorder, 1 - preorder, 2 - postorder

    public TestInputFileReader<TreeNode> inOrder() {
        order = 0;
        return this;
    }

    public TestInputFileReader<TreeNode> preOrder() {
        order = 1;
        return this;
    }

    public TestInputFileReader<TreeNode> postOrder() {
        order = 2;
        return this;
    }

    @Override
    protected TreeNode readValues(String[] splits) {
        return null;
    }

}
