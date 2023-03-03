package interviewbit.timecomplexity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import common.InputReader;

public class PangramCheck {

    public static void main(String[] args) {
        System.out.println(solve(InputReader.readStringArrayList()));
    }

    private static int solve(ArrayList<String> A) {
        final Set<Character> ALPHABET = new HashSet<>();
        for(String str : A) {
            for (char c : str.toLowerCase().toCharArray()) {
                ALPHABET.add(c);
            }
        }
        return ALPHABET.size() == 26 ? 1 : 0;
    }
    
}
