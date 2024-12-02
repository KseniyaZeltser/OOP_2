

/**
 * Класс Vector представляет вектор в трехмерном пространстве.
 * Он предоставляет методы для вычисления скалярного и векторного произведений,
 * длины вектора и таких операций, как сложение, вычитание,
 * и умножение на скаляр.
 */
public class Vector {

    private double x;
    private double y;
    private double z;

    /**
     * Конструктор по умолчанию, который инициализирует вектор значением (0, 0, 0).
     */
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * Конструктор с параметрами для инициализации вектора.
     * @param x - Координата x вектора.
     * @param y-координата y вектора.
     * @param z-координата z вектора.
     */
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getters
    /**
     * Возвращает x-координату вектора.
     * @return возвращает x-координату вектора.
     */
    public double getX() {
        return x;
    }

    /**
     * Возвращает y-координату вектора.
     * @return возвращает y-координату вектора.
     */
    public double getY() {
        return y;
    }

    /**
     * Возвращает z-координату вектора.
     * @return возвращает z-координату вектора.
     */
    public double getZ() {
        return z;
    }

    // Setters
    /**
     * Задает координату x вектора.
     * @param x Задает координату x для вектора.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Задает координату y вектора.
     * @param y Задает координату y для вектора.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Задает координату z вектора.
     * @param z Задает координату z для вектора.
     */
    public void setZ(double z) {
        this.z = z;
    }

    // Methods for vector operations

    /**
     * Вычисляет длину вектора.
     * @return возвращает длину вектора.
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Вычисляет скалярное произведение этого вектора и другого вектора.
     * @param v для другого вектора.
     * @return возвращает скалярное произведение двух векторов.
     */
    public double scalarProduct(Vector v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    /**
     * Вычисляет векторное произведение этого вектора и другого вектора.
     * @param v для другого вектора.
     * @return возвращает новый вектор, представляющий векторное произведение.
     */
    public Vector vectorProduct(Vector v) {
        double newX = this.y * v.z - this.z * v.y;
        double newY = this.z * v.x - this.x * v.z;
        double newZ = this.x * v.y - this.y * v.x;
        return new Vector(newX, newY, newZ);
    }

    /**
     * Умножает вектор на число.
     * @param scalar - число.
     * @return возвращает новый вектор, который представляет собой этот вектор, умноженный на скаляр.
     */
    public Vector multiplyByScalar(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    /**
     * Добавляет этот вектор к другому вектору.
     * @param v для другого вектора.
     * @return возвращает новый вектор, являющийся суммой двух векторов.
     */
    public Vector add(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    /**
     * Вычитает другой вектор из этого вектора.
     * @param v для другого вектора.
     * @return возвращает новый вектор, являющийся разницей между двумя векторами.
     */
    public Vector subtract(Vector v) {
        return new Vector(this.x - v.x, this.y - v.y, this.z - v.z);
    }

}



package clothing;

public abstract class Clothes {
    protected Size size;
    protected double price;
    protected String color;

    public Clothes(Size size, double price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }
}
package clothing;

public class TShirt extends Clothes implements MenClothing, WomenClothing {
    public TShirt(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressMan() {
        System.out.println("Мужская футболка:  " + size.getDescription() + ", евро размер " + size.getEuroSize() + ", цена " + price + ", цвет " + color);
    }

    public void dressWoman() {
        System.out.println("Женская футболка:  " + size.getDescription() + ", евро размер " + size.getEuroSize() + ", цена " + price + ", цвет " + color);
    }
}
package clothing;

public class Pants extends Clothes implements MenClothing, WomenClothing {
    public Pants(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressMan() {
        System.out.println("Мужские брюки: размер " + size.getDescription() + ", евро размер " + size.getEuroSize() + ", цена " + price + ", цвет " + color);
    }

    public void dressWoman() {
        System.out.println("Женские брюки: размер " + size.getDescription() + ", евро размер " + size.getEuroSize() + ", цена " + price + ", цвет " + color);
    }
}

package clothing;

public class Skirt extends Clothes implements WomenClothing {
    public Skirt(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressWoman() {
        System.out.println("Юбка: размер " + size.getDescription() + ", евро размер " + size.getEuroSize() + ", цена " + price + ", цвет " + color);
    }
}
package clothing;

public class Tie extends Clothes implements MenClothing {
    public Tie(Size size, double price, String color) {
        super(size, price, color);
    }

    public void dressMan() {
        System.out.println("Галстук: размер " + size.getDescription() + ", евро размер " + size.getEuroSize() + ", цена " + price + ", цвет " + color);
    }
}
package clothing;

public class Atelier {
    public void dressMan(Clothes[] clothes) {
        for (Clothes c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing) c).dressMan();
            }
        }
    }

    public void dressWoman(Clothes[] clothes) {
        for (Clothes c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).dressWoman();
            }
        }
    }
}
package clothing;

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new TShirt(Size.M, 500, "Синий"),
                new Pants(Size.L, 1200, "Чёрный"),
                new Skirt(Size.S, 700, "Красный"),
                new Tie(Size.XS, 300, "Зелёный")
        };

        Atelier atelier = new Atelier();
        System.out.println("Одежда для мужчин:");
        atelier.dressMan(clothes);

        System.out.println("\nОдежда для женщин:");
        atelier.dressWoman(clothes);
    }
}




