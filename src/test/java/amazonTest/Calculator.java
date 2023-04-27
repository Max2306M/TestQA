package amazonTest;


public class Calculator {
    public static byte sqrt(byte num) {
        return (byte) Math.sqrt(num);
    }

    public static short sqrt(short num) {
        return (short) Math.sqrt(num);
    }

    public static int sqrt(int num) {
        return (int) Math.sqrt(num);
    }

    public static double sqrt(double num) {
        return Math.sqrt(num);
    }

    public static float sqrt(float num) {
        return (float) Math.sqrt(num);
    }

    class Parent {
        public void printMessage() {
            System.out.println("This is a message from the Parent class");
        }
    }

    class Child extends Parent {
        @Override
        public void printMessage() {
            System.out.println("This is a message from the Child class");
        }
    }

    interface Shape {
        double area();

        double perimeter();
    }

    interface Drawable {
        void draw();

        void erase();
    }

    class Rectangle implements Shape, Drawable {
        private double width, height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }

        @Override
        public double perimeter() {
            return 2 * (width + height);
        }

        @Override
        public void draw() {
            System.out.println("Drawing a rectangle...");
        }

        @Override
        public void erase() {
            System.out.println("Erasing a rectangle...");
        }
    }

    class Main {
        public void main(String[] args) {
            Rectangle rectangle = new Rectangle(5, 10);
            System.out.println("Rectangle area: " + rectangle.area());
            System.out.println("Rectangle perimeter: " + rectangle.perimeter());
            rectangle.draw();
            rectangle.erase();
        }
    }
}

