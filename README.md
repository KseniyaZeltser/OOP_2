public class numbers {
    // вычисление суммы цифр числа
    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 300; i++) {
            if (i % 4 == 0 && i % 6 != 0 && sumOfDigits(i) < 10) {
                System.out.println(i);
            }
        }
    }
}

public class word {
    public static String Middle(String str) {
        int middle = str.length() / 2;
        return str.substring(middle - 1, middle + 1);
    }
    public static void main(String[] args) {
        System.out.println(Middle("string"));
        System.out.println(Middle("code"));
        System.out.println(Middle("Practice"));
    }
}


public class string1 {

    public static String findMinDistinctCharsWord(String input) {
        String[] words = input.split(" "); // разбиваем строку на слова
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


public class string2 {



    public static int countLatinWords(String sentence) {
        String[] words = sentence.split(" ");
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

            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {// ASCII
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
