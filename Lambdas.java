import java.util.ArrayList;
import java.util.Random;
import java.util.function.*;

interface Calculator {
    public int calculator(int a, int b);
}

class Lambdas {

    public static void main(String args[]) {

        Random random = new Random(); // Random number generate
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            num.add(random.nextInt(6));
        }
        // Use of Lambda function
        Consumer<Integer> func = (n) -> {
            System.out.println(n);
        };
        num.forEach(func);

        // Demo2
        System.out.println("Multiplication :" + performOperation((a, b) -> a * b, 5, 10));
        System.out.println("Addition :" + performOperation((a, b) -> a + b, 5, 10));
        System.out.println("Remainder :" + performOperation((a, b) -> a % b, 21, 10));

        // Demo3
        // Use of BinaryOperator
        BinaryOperator<Integer> multi = (x, y) -> x * y;
        System.out.println("After Binary Operation:" + multi.apply(5, 7));

        // User Of UnaryOperator
        UnaryOperator<Integer> incr = (a) -> ++a;
        System.out.println("After Unary Operation: " + incr.apply(5));

        // Use Of Consumer Interface
        Consumer<String> c = (a) -> System.out.println(a.toLowerCase());
        c.accept("LAMBDA EXAMPLE");

        // Use Of supplier Interface
        Supplier<Integer> s = () -> 10;
        System.out.println(s.get());
        Supplier<String> ss = () -> "Supplier Demo";
        System.out.println(ss.get());

        // Use of Predicate : Return True or False
        Predicate<String> p = (t) -> t.length() > 8;
        System.out.println(p.test("Summer Internship"));
        System.out.println(p.test("Java"));

        Predicate<String> j = (i) -> i.equalsIgnoreCase("Java");
        System.out.println(j.test("Java's Tutorial"));
        System.out.println(j.test("Java"));

    }

    // Creating a method which takes a lambda expression as a parameter
    public static int performOperation(Calculator c, int a, int b) {
        return c.calculator(a, b);
    }
}