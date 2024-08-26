import java.util.Stack;

public class Calculator {
    private BasicOperations basicOps;
    private ScientificOperations sciOps;
    private Memory memory;
    private HistoryLog history;

    public Calculator() {
        this.basicOps = new BasicOperations();
        this.sciOps = new ScientificOperations();
        this.memory = new Memory();
        this.history = new HistoryLog();
    }

    public double calculate(String expression) throws InvalidInputException, MathOperationException {
        try {
            double result = evaluateExpression(expression);
            history.addRecord(expression + " = " + result);
            return result;
        } catch (ArithmeticException e) {
            throw new MathOperationException("Math error: " + e.getMessage());
        } catch (Exception e) {
            throw new InvalidInputException("Invalid input: " + e.getMessage());
        }
    }

    private double evaluateExpression(String expression) throws MathOperationException, InvalidInputException {
        // Here we use a simple expression evaluator.
        // For a real implementation, consider using libraries or writing a parser.

        String[] tokens = expression.split(" ");
        Stack<Double> values = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    values.push(basicOps.add(values.pop(), values.pop()));
                    break;
                case "-":
                    double subtractor = values.pop();
                    values.push(basicOps.subtract(values.pop(), subtractor));
                    break;
                case "*":
                    values.push(basicOps.multiply(values.pop(), values.pop()));
                    break;
                case "/":
                    double divisor = values.pop();
                    values.push(basicOps.divide(values.pop(), divisor));
                    break;
                case "^":
                    double exponent = values.pop();
                    values.push(sciOps.power(values.pop(), exponent));
                    break;
                case "sqrt":
                    values.push(sciOps.squareRoot(values.pop()));
                    break;
                case "log":
                    values.push(sciOps.log(values.pop()));
                    break;
                default:
                    values.push(Double.parseDouble(token));
                    break;
            }
        }
        return values.pop();
    }

    public Memory getMemory() {
        return memory;
    }

    public HistoryLog getHistory() {
        return history;
    }
}
