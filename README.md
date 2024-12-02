import shapes.Circle;
import shapes.Point;
import shapes.Rectangle;
import shapes.Triangle;
import colors.Color;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(1.0, 2.0, Color.RED);
        point.draw();

        Circle circle = new Circle(new Point(0, 0), 5, Color.BLUE);
        circle.draw();

        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(4, 3), Color.GREEN);
        rectangle.draw();

        Triangle triangle = new Triangle(new Point(0,0), new Point(3, 0), new Point(0, 4), Color.YELLOW);
        triangle.draw();
    }
}

package colors;

public enum Color {

    TRANSPARENT,

    RED,

    GREEN,

    BLUE,

    PURPLE,

    WHITE,

    BLACK,

    YELLOW,

    BROWN
}

package shapes;

import colors.Color;

public abstract class Shape {
    private Color color = Color.TRANSPARENT;

    public Shape() {}

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getArea() {
        return 0.0;
    }

    public double getPerimeter() {
        return 0.0;
    }

    public void move(double moveX, double moveY) {
        System.out.println("Moving shape by (" + moveX + ", " + moveY + ")");
    }

    public void draw() {
        System.out.println("Shape: " + this.getClass().getSimpleName() +
                ", Color: " + color);
    }
}


package shapes;

import colors.Color;

public class Point extends shapes.Shape {
    private double x;
    private double y;
    private Color color = Color.TRANSPARENT;

    // Конструктор без параметров
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
        this.color = Color.TRANSPARENT;
    }

    // Конструктор с параметрами типа double
    public Point(double x, double y, Color color) {
        super(color);
        this.x = x;
        this.y = y;
    }

    // Перегруженный конструктор с целыми числами
    public Point(int x, int y) {
        super(Color.TRANSPARENT); // По умолчанию цвет - прозрачный
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public void draw() {
        System.out.println("Shape: Point: (" + x + ", " + y + "), Color: " + getColor());

    }


    public void move(double moveX, double moveY) {
        this.x += moveX;
        this.y += moveY;
    }

    public double getArea() { return 0.0; }

    public double getPerimeter() { return 0.0; }
}

package shapes;

import colors.Color;

public class Circle extends shapes.Shape {
    private Point point;
    private double radius;

    public Circle() {}

    public Circle(Point point, double radius, Color color) {
        super(color);
        this.point = point;
        this.radius = radius;
        validate();
    }

    private void validate() {
        if (radius <= 0) {
            System.out.println("Radius cannot be less than or equal to zero");
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        validate();
    }


    public double getArea() {
        return Math.PI * radius * radius;
    }


    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void draw() {
        System.out.println("Shape: Circle, Color: " + getColor() +
                ", Center: (" + point.getX() + ", " + point.getY() + "), Radius: " + radius);
        System.out.println("Perimeter:"+getPerimeter()+",Area:"+getArea());
    }
}

package shapes;

import colors.Color;

public class Rectangle extends shapes.Shape {
    private Point a;
    private Point c;

    public Rectangle(Point a, Point c, Color color) {
        super(color);
        this.a = a;
        this.c = c;
        validate();
    }

    private void validate() {
        if (a.getX() == c.getX() || a.getY() == c.getY()) {
            System.out.println("Points cannot lie on the same line.");
        }
    }


    public double getArea() {
        return Math.abs((c.getX() - a.getX()) * (c.getY() - a.getY()));
    }


    public double getPerimeter() {
        return 2 * (Math.abs(c.getX() - a.getX()) + Math.abs(c.getY() - a.getY()));
    }


    public void draw() {
        super.draw();
        System.out.println("Rectangle defined by points A: (" + a.getX() + ", " + a.getY() + "), C: (" + c.getX() + ", " + c.getY() + ")");
        System.out.println("Perimeter:"+getPerimeter()+",Area:"+getArea());
    }
}

package shapes;

import colors.Color;

public class Triangle extends shapes.Shape {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c, Color color) {
        super(color);
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double getArea() {
        return Math.abs((a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY())) / 2.0);
    }


    public double getPerimeter() {
        return distance(a, b) + distance(b, c) + distance(c, a);
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }


    public void draw() {
        super.draw();
        System.out.println("Triangle defined by points A: (" + a.getX() + ", " + a.getY() + "),B: (" + b.getX() + "," + b.getY() + ") C: (" + c.getX() + ", " + c.getY() + ")");
        System.out.println("Perimeter:"+getPerimeter()+",Area:"+getArea());
    }
}

