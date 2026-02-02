import java.time.LocalTime;

public class VoiceManager {
    private static final SpeechRecognizer recognizer = new SpeechRecognizer();
    private static final VoiceSynthesizer speaker = new VoiceSynthesizer();
    private static boolean listening = true;
    public static void startListening() {
        while (listening) {
            String command = recognizer.listen();
            if (command != null && command.toLowerCase().contains("astra")) {
                processCommand(command.toLowerCase());
            }
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }   
    private static void processCommand(String cmd) {
        if (cmd.contains("time")) {
            String time = LocalTime.now().toString().substring(0, 5);
            speaker.speak("The time is " + time);
            DatabaseManager.logCommand(cmd, true);
        } else if (cmd.contains("notepad")) {
            try {
                Runtime.getRuntime().exec("notepad");
                speaker.speak("Opening Notepad");
            } catch (Exception e) {
                speaker.speak("Could not open Notepad");
            }
            DatabaseManager.logCommand(cmd, true);
        } else if (cmd.contains("weather")) {
            String weather = WeatherService.getWeather();
            speaker.speak(weather);
            DatabaseManager.logCommand(cmd, true);
        } else {
            speaker.speak("Command not recognized");
            DatabaseManager.logCommand(cmd, false);
        }
    }
}
