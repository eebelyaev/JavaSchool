package lesson01.task03;

public class FiguresMain {

    public static void main(String[] args) {
        Square square = new Square(5);
        printPerimeterForFigure(square);

        Circle circle = new Circle(5);
        printPerimeterForFigure(circle);

        /*
        String name = circle.getClass().getName();
        String[] sArr = name.split("/.");
        System.out.println(name + " : " + sArr.length);
         */
    }

    private static void printPerimeterForFigure(Figure2D figure) {
        System.out.println("Периметр фигуры " + figure.getClass().getSimpleName() + " = " + figure.getPerimeter());
    }
}
