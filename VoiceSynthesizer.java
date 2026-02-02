import com.sun.speech.freetts.*;

public class VoiceSynthesizer {
    private Voice voice;
    public VoiceSynthesizer() {
        voice = VoiceManager.getInstance().getVoice("kevin16");
        voice.allocate();
    }
    public void speak(String text) {
        voice.speak(text);
    }
}
