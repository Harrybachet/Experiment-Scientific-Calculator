import java.util.ArrayList;
import java.util.List;

public class HistoryLog {
    private List<String> history;

    public HistoryLog() {
        history = new ArrayList<>();
    }

    public void addRecord(String record) {
        history.add(record);
    }

    public List<String> getHistory() {
        return history;
    }
}
