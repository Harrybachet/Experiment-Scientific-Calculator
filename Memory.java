public class Memory {
    private double storedValue;

    public Memory() {
        this.storedValue = 0.0;
    }

    public void addToMemory(double value) {
        storedValue += value;
    }

    public void subtractFromMemory(double value) {
        storedValue -= value;
    }

    public double recallMemory() {
        return storedValue;
    }

    public void clearMemory() {
        storedValue = 0.0;
    }
}
