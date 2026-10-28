import java.util.Objects;

class Fraction {
    private int num;
    private int den;

    // Constructor
    public Fraction(int num, int den) {

        if (den == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }

        // Make denominator positive
        if (den < 0) {
            num = -num;
            den = -den;
        }

        // Find GCD
        int g = gcd(Math.abs(num), den);

        // Reduce fraction
        this.num = num / g;
        this.den = den / g;
    }

    // GCD method
    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // toString()
    @Override
    public String toString() {
        return num + "/" + den;
    }

    // equals()
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Fraction))
            return false;

        Fraction f = (Fraction) obj;

        return num == f.num && den == f.den;
    }

    // hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }
}


// Driver class
public class FractionDriver {

    public static void main(String[] args) {

        // Create equivalent fractions
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 6);

        // Print fractions
        System.out.println("Fraction 1: " + f1);
        System.out.println("Fraction 2: " + f2);
        System.out.println("Fraction 3: " + f3);

        // Check equality
        System.out.println("f1 equals f2: " + f1.equals(f2));
        System.out.println("f2 equals f3: " + f2.equals(f3));
        System.out.println("f1 equals f3: " + f1.equals(f3));
    }
}