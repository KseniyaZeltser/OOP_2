public class Main {
    public static void main(String[] args) {
        // Создание объектов
        Phone phone1 = new Phone("123456789", "iPhone", 150);
        Phone phone2 = new Phone("987654321", "Samsung", 180);
        Phone phone3 = new Phone("555666777", "Nokia");

        // Вывод информации
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        // Вызов методов
        phone1.receiveCall("Алексей");
        System.out.println("Номер телефона: " + phone1.getNumber());
        phone2.receiveCall("Мария", "987654321");
        phone3.sendMessage("111111111", "222222222", "333333333");

    Reader reader = new Reader("abc","1","c","2","e");
    reader.takeBook(5);
}}
public class Phone {
    private String number;
    private String model;
    private double weight;

    // Конструктор без параметров
    public Phone() {}

    // Конструктор с двумя параметрами
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    // Конструктор с тремя параметрами
    public Phone(String number, String model, double weight) {
        this(number, model); // Вызов конструктора с двумя параметрами
        this.weight = weight;
    }

    // Методы для получения значений переменных
    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }

    // Метод receiveCall
    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    // Перегруженный метод receiveCall
    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + " с номера " + callerNumber);
    }

    // Метод sendMessage с переменным количеством аргументов
    public void sendMessage(String... numbers) {
        System.out.println("Отправка сообщения на номера:");
        for (String num : numbers) {
            System.out.println(num);
        }
    }


    public String toString() {
        return "Phone{number='" + number + "', model='" + model + "', weight=" + weight + "}";
    }
}
import java.util.Date;

public class Reader {
    private String fullName;
    private String ticketNumber;
    private String faculty;
    private String birthDate;
    private String phone;

    // Конструктор
    public Reader(String fullName, String ticketNumber, String faculty, String birthDate, String phone) {
        this.fullName = fullName;
        this.ticketNumber = ticketNumber;
        this.faculty = faculty;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    // Методы takeBook и returnBook
    public void takeBook(int bookCount) {
        System.out.println(fullName + " взял " + bookCount + " книг(и)");
    }

    public void takeBook(String... bookNames) {
        System.out.println(fullName + " взял книги: " + String.join(", ", bookNames));
    }

    public void returnBook(int bookCount) {
        System.out.println(fullName + " вернул " + bookCount + " книг(и)");
    }

    public void returnBook(String... bookNames) {
        System.out.println(fullName + " вернул книги: " + String.join(", ", bookNames));
    }

    public String toString() {
        return "Reader{" + "fullName='" + fullName + "', ticketNumber='" + ticketNumber + "', faculty='" + faculty +
                "', birthDate='" + birthDate + "', phone='" + phone + "'}";
    }
}

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return title + " (" + author + ")";
    }
}
public class Library {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Иванов И.И.", "12345", "Физика", "01.01.1990", "123-456-789");
        Reader reader2 = new Reader("Петров П.П.", "67890", "Математика", "05.05.1992", "987-654-321");

        Book book1 = new Book("Приключения", "Александр Дюма");
        Book book2 = new Book("Словарь", "Владимир Даль");
        Book book3 = new Book("Энциклопедия", "Британника");

        // Вызов методов
        reader1.takeBook(3);
        reader1.takeBook("Приключения", "Словарь", "Энциклопедия");
        reader2.returnBook(2);
        reader2.returnBook("Приключения", "Энциклопедия");

        System.out.println(reader1);
        System.out.println(reader2);
    }
}


