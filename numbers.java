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
