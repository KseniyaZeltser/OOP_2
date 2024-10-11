public class word {
    public static String getMiddle(String str) {
        int middle = str.length() / 2;
        return str.substring(middle - 1, middle + 1);
    }
    public static void main(String[] args) {
        System.out.println(getMiddle("string"));   // ri
        System.out.println(getMiddle("code"));     // od
        System.out.println(getMiddle("Practice")); // ct
    }
}
