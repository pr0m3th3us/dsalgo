package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class InputReader implements AutoCloseable {
    private static final File TEST_INPUT = new File("./src/common/test-input");

    private Scanner scanner;

    /* package */ InputReader() {
        
    }

    public static InputReader open() {
        InputReader reader = new InputReader();
        try {
            reader.scanner = new Scanner(TEST_INPUT);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return reader;
    }

    public static IntegerReader intReader() {
        return new IntegerReader();
    }

    public static IntegerArrayReader intArrayReader() {
        return new IntegerArrayReader();
    }

    public static StringArrayReader stringArrayReader() {
        return new StringArrayReader();
    }

    public static StringListReader stringListReader() {
        return new StringListReader();
    }

    public static StringReader stringReader() {
        return new StringReader();
    }

    public static BinaryTreeReader binaryTreeReader() {
        return new BinaryTreeReader();
    }


    @Override
    public void close() {
        this.scanner.close();
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public ArrayList<Integer> nextIntArraylist() {
        return nextIntArraylist(",");
    }

    public ArrayList<Integer> nextIntArraylist(String separator) {
        String[] splits = sanitize(scanner.nextLine()).split(separator);
        return toIntArrayList(parseNSizeIntArray(splits.length, splits));
    }

    // public statics
    public static ArrayList<Integer> readIntArraylist() {
        return readIntArraylist(",");
    }

    public static ArrayList<Integer> readIntArraylist(String separator) {
        return toIntArrayList(readIntArrayOnce(separator));
    }
    
    public static int[] readIntArray() {
        return readIntArray(",");
    }

    public static int[] readIntArray(String separator) {
        return readIntArrayOnce(separator);
    }

    public static int[] readIntArray(int n) {
        return readIntArray(n, ",");
    }

    public static int[] readIntArray(int n, String separator) {
        return readIntArrayOnce(n, separator);
    }

    public static Integer readInt() {
        return scanFile(Scanner::nextInt);
    }

    public static String[] readStringArray(int n) {
        return scanFile(sc -> {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sanitize(sc.nextLine());
            }
            return arr;
        });
    }

    public static ArrayList<String> readStringArrayList() {
        return readStringArrayList(",", "\"");
    }

    public static ArrayList<String> readStringArrayList(String separator, String tags) {
        return scanFile(sc -> {
            ArrayList<String> ret = new ArrayList<>();
            for(String s : sanitize(sc.nextLine()).split(separator)) {
                ret.add(StringUtils.substringBetween(s, tags).trim());
            }
            return ret;
        });
    }

    public static ListNode readIntList() {
        return readIntList(",");
    }

    public static ListNode readIntList(String separator) {
        return scanFile(sc -> {
            String[] splits = sanitize(sc.nextLine()).split(separator);
            return LinkedListUtils.parseAsIntList(splits);
        });
    }

    //private statics
    private static <T> T scanFile(Function<Scanner, T> function) {
        RuntimeException rte = null;
        T result = null;
        try (Scanner sc = new Scanner(TEST_INPUT)) {
            result = function.apply(sc);
        } catch (Exception e) {
            rte = new RuntimeException(e);
        }
        if (rte != null) throw rte;
        return result;
    }

    private static int[] readIntArrayOnce(int n, String separator) {
        return scanFile(sc -> {
            var splits = sanitize(sc.nextLine()).split(separator);
            return parseNSizeIntArray(n, splits);
        });
    }

    private static int[] readIntArrayOnce(String separator) {
        return scanFile(sc -> {
            String[] splits = sanitize(sc.nextLine()).split(separator);
            return parseNSizeIntArray(splits.length, splits);
        });
    }

    private static String sanitize(String text) {
        if (text == null) return "";
        text = text.trim();
        if (text.startsWith("("))   text = StringUtils.stripStart(text, "(");
        if (text.startsWith("["))   text = StringUtils.stripStart(text, "[");
        if (text.endsWith(")"))     text = StringUtils.stripEnd(text, ")");
        if (text.endsWith("]"))     text = StringUtils.stripEnd(text, "]");
        return text;
    }

    private static int[] parseNSizeIntArray(int n, String[] splits) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = Integer.parseInt(splits[i].trim());
        }
        return ret;
    }

    private static ArrayList<Integer> toIntArrayList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
    }
}
