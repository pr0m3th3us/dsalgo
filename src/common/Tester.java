package common;

import java.util.List;

public class Tester {
    public static void main(String[] args) {
        int[] intArray = InputReader
            .intArrayReader()
            .commaSeparated()
            .squareBracketsEnclosed()
            .read();
        System.out.println(intArray);

        String[] stringArray = InputReader
                .stringArrayReader()
                .spaceSeparated()
                .bracesEnclosed()
                .read();

        List<String> list = InputReader
                .stringListReader()
                .spaceSeparated()
                .notEnclosed()
                .read();

        TreeNode root = InputReader
                .binaryTreeReader()
                .read();

        String string = InputReader
                .stringReader()
                .read();
    }
}
