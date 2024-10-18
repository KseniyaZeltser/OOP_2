public class string2 {



    public static int countLatinWords(String sentence) {
        String[] words = sentence.split(" "); // разбиваем строку на слова
        int count = 0;

        for (String word : words) {
            if (isLatinWord(word)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isLatinWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String sentence = "One two three раз два три one1 two2 123";
        int latinWordsCount = countLatinWords(sentence);
        System.out.println("Количество слов, содержащих только латинские буквы: " + latinWordsCount);
    }
}
