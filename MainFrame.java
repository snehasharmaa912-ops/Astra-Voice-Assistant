import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Astra - Intelligent Voice Assistant");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Analytics", new AnalyticsPanel());
        tabs.add("Commands", createCommandsPanel());
        add(tabs);
        setVisible(true);
    }
    
    private JPanel createCommandsPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(new JButton("Astra, what time is it?"));
        panel.add(new JButton("Astra, open notepad"));
        panel.add(new JButton("Astra, weather"));
        panel.add(new JButton("Stop Listening"));
        return panel;
    }
}
