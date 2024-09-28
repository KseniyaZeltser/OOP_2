public class word {
    public static String getMiddleChars(String str) {
        int middle = str.length() / 2;
        return str.substring(middle - 1, middle + 1);
    }
    public static void main(String[] args) {
        System.out.println(getMiddleChars("string"));   // ri
        System.out.println(getMiddleChars("code"));     // od
        System.out.println(getMiddleChars("Practice")); // ct
    }
}
