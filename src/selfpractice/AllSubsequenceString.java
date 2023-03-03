package selfpractice;

public class AllSubsequenceString {

    public static void main(String[] args) {
        subseq("123", "");
    }
    
    static void subseq(String input, String subseq) {
        if (input.length() == 0) {
            if (subseq.length() != 0) {
                System.out.println(subseq);
            }
            return;
        }

        subseq(input.substring(1), subseq + input.charAt(0));
        subseq(input.substring(1), subseq);
    }
}
