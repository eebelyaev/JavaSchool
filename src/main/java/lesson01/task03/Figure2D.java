package lesson01.task03;

public abstract class Figure2D {
    abstract public double getSquare();

    abstract public double getPerimeter();
}

class Square extends Figure2D {
    private double lengthSide;

    public Square(double lengthSide) {
        this.lengthSide = lengthSide;
    }

    public double getSquare() {
        return lengthSide * lengthSide;
    }

    public double getPerimeter() {
        return 4 * lengthSide;
    }
}

class Circle extends Figure2D {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getSquare() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
