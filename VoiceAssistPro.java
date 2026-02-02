public class VoiceAssistPro {
    public static void main(String[] args) {
        System.out.println("Astra v2.0 - Intelligent Voice Assistant");        
        try {
            DatabaseManager.init();
            CommandRegistry.initCommands();            
            javax.swing.SwingUtilities.invokeLater(MainFrame::new);
            new Thread(VoiceManager::startListening, "VoiceThread").start();      
        } catch (Exception e) {
            System.err.println("Failed to start: " + e.getMessage());
        }
    }
}
