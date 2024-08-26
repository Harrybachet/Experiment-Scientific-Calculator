import java.lang.Math;

public class ScientificOperations {
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double squareRoot(double value) throws MathOperationException {
        if (value < 0) {
            throw new MathOperationException("Cannot take square root of a negative number");
        }
        return Math.sqrt(value);
    }

    public double factorial(int n) throws MathOperationException {
        if (n < 0) {
            throw new MathOperationException("Factorial of a negative number is undefined");
        }
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double log(double value) throws MathOperationException {
        if (value <= 0) {
            throw new MathOperationException("Logarithm of a non-positive number is undefined");
        }
        return Math.log(value);
    }

    public double sin(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public double cos(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public double tan(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
}
