package ch06;

public class ReverseString {

    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'});
    }

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            var temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        System.out.println(s);
    }
}
