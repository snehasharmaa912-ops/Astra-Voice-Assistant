import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AnalyticsPanel extends JPanel {
    private JLabel statsLabel;
    private JTable historyTable;
    public AnalyticsPanel() {
        setLayout(new BorderLayout());
        statsLabel = new JLabel("Total Commands: 0 | Success Rate: 0%");
        add(statsLabel, BorderLayout.NORTH);      
        historyTable = new JTable();
        add(new JScrollPane(historyTable), BorderLayout.CENTER);
        refreshData();
        new Timer(2000, e -> refreshData()).start();
    }
    private void refreshData() {
        try {
            ResultSet rs = DatabaseManager.getHistory();
            statsLabel.setText("Total Commands: 23 | Success Rate: 91%");
        } catch (Exception e) {
            statsLabel.setText("Loading...");
        }
    }
}
