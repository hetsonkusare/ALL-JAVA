// *****************************************************************************************
// P.1 – Display "Hello World"
// *****************************************************************************************

class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}



// *****************************************************************************************
// P.2 – Check whether a number is palindrome or not
// *****************************************************************************************

import java.util.Scanner;

class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num;
        int reversed = 0;

        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }

        if (original == reversed)
            System.out.println("It is palindrome number");
        else
            System.out.println("It is not palindrome number");
    }
}



// *****************************************************************************************
// P.3 – Check Armstrong Number
// *****************************************************************************************

class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num;
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit * digit;
            num /= 10;
        }

        if (sum == original)
            System.out.println("Armstrong number");
        else
            System.out.println("not Armstrong number");
    }
}



// *****************************************************************************************
// P.4 – Find Minimum of Three Numbers using Conditional Operator
// *****************************************************************************************

class MinOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.print("Enter third number: ");
        int c = sc.nextInt();

        int min = (a < b) ? ((a < c) ? a : c)
                          : ((b < c) ? b : c);

        System.out.println("Minimum number = " + min);
    }
}



// *****************************************************************************************
// P.5 – Count number of vowels and consonants in a line
// *****************************************************************************************

class VowelConsonantCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a line: ");
        String line = sc.nextLine().toLowerCase();

        int vowels = 0, consonants = 0;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("Number of vowels = " + vowels);
        System.out.println("Number of consonants = " + consonants);
    }
}



// *****************************************************************************************
// P.6 – Student File Manager using FileInputStream & FileOutputStream
// *****************************************************************************************

import java.io.*;

class Student {
    int roll;
    String name;
    double marks;

    Student(int roll, String name, double marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return roll + "," + name + "," + marks;
    }
}

class StudentManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter student roll no: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter student name: ");
            String name = sc.nextLine();

            System.out.println("Enter student marks: ");
            double marks = sc.nextDouble();

            Student s = new Student(roll, name, marks);

            FileOutputStream fos = new FileOutputStream("student.txt");
            fos.write(s.toString().getBytes());
            fos.close();

            System.out.println("\nStudent information saved.\n");

            FileInputStream fis = new FileInputStream("student.txt");
            int ch;
            StringBuilder data = new StringBuilder();

            while ((ch = fis.read()) != -1) {
                data.append((char) ch);
            }
            fis.close();

            System.out.println("Reading from file:");
            System.out.println(data.toString());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



// *****************************************************************************************
// P.7 – Demonstrate Static Block executes before main()
// *****************************************************************************************

class StaticBlockDemo {
    static {
        System.out.println("This is the static block. It executes before main() method.");
    }

    public static void main(String[] args) {
        System.out.println("This is the main() method.");
    }
}



// *****************************************************************************************
// P.8 – Demonstrate Wrapper Classes of all Primitive Data Types
// *****************************************************************************************

class WrapperDemo {
    public static void main(String[] args) {

        byte b = 10;
        Byte bw = Byte.valueOf(b);
        System.out.println("Byte Wrapper: " + bw);

        short s = 200;
        Short sw = Short.valueOf(s);
        System.out.println("Short Wrapper: " + sw);

        int i = 500;
        Integer iw = Integer.valueOf(i);
        System.out.println("Integer Wrapper: " + iw);

        long l = 99999L;
        Long lw = Long.valueOf(l);
        System.out.println("Long Wrapper: " + lw);

        float f = 5.75f;
        Float fw = Float.valueOf(f);
        System.out.println("Float Wrapper: " + fw);

        double d = 123.456;
        Double dw = Double.valueOf(d);
        System.out.println("Double Wrapper: " + dw);

        char c = 'A';
        Character cw = Character.valueOf(c);
        System.out.println("Character Wrapper: " + cw);

        boolean flag = true;
        Boolean boolw = Boolean.valueOf(flag);
        System.out.println("Boolean Wrapper: " + boolw);
    }
}



// *****************************************************************************************
// P.9 – Demonstrate Final Keyword
// *****************************************************************************************

class FinalDemo {
    final int speedLimit = 60;

    void display() {
        System.out.println("Speed Limit = " + speedLimit);
    }
}

class FinalKeywordExample {
    public static void main(String[] args) {
        FinalDemo obj = new FinalDemo();

        System.out.println("Accessing final field using object: " + obj.speedLimit);

        obj.display();

        // obj.speedLimit = 100; // ERROR – cannot assign to final variable.
    }
}



// *****************************************************************************************
// P.10 – Abstract Class Shape with Triangle, Rectangle, Circle
// *****************************************************************************************

abstract class Shape {
    abstract void area();
}

class Triangle extends Shape {
    double base, height;

    Triangle(double b, double h) {
        base = b;
        height = h;
    }

    void area() {
        System.out.println("Area of Triangle = " + (0.5 * base * height));
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    void area() {
        System.out.println("Area of Rectangle = " + (length * width));
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }

    void area() {
        System.out.println("Area of Circle = " + (3.14159 * radius * radius));
    }
}

class ShapeDemo {
    public static void main(String[] args) {

        Shape s;

        s = new Triangle(10, 5);
        s.area();

        s = new Rectangle(7, 4);
        s.area();

        s = new Circle(3.5);
        s.area();
    }
}

