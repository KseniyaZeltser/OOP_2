public class string1 {

    public static String findMinDistinctCharsWord(String input) {
        String[] words = input.split("\\s+"); // разбиваем строку на слова
        String minWord = null;
        int minDistinctChars = Integer.MAX_VALUE;

        for (String word : words) {
            int distinctChars = countDistinctCharacters(word);
            if (distinctChars < minDistinctChars) {
                minDistinctChars = distinctChars;
                minWord = word;
            }
        }

        return minWord;
    }

    public static int countDistinctCharacters(String word) {
        boolean[] seen = new boolean[256]; // ASCII символы
        int count = 0;

        for (char c : word.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String input = "fffff ab f 1234 jkjk";
        String minDistinctWord = findMinDistinctCharsWord(input);
        System.out.println("Слово с минимальным числом различных символов: " + minDistinctWord);
    }

}

