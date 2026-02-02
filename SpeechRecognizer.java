import edu.cmu.sphinx.api.*;

public class SpeechRecognizer {
    private LiveSpeechRecognizer recognizer;
    public SpeechRecognizer() {
        try {
            Configuration config = new Configuration();
            config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            recognizer = new LiveSpeechRecognizer(config);
        } catch (Exception e) {
            System.err.println("Speech setup failed: " + e.getMessage());
        }
    }
    public String listen() {
        try {
            recognizer.startRecognition(true);
            SpeechResult result = recognizer.getResult();
            recognizer.stopRecognition();
            return result.getHypothesis();
        } catch (Exception e) {
            return null;
        }
    }
}
