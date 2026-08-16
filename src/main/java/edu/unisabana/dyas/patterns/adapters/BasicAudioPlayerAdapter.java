package edu.unisabana.dyas.patterns.adapters;
import edu.unisabana.dyas.patterns.utils.BasicAudioPlayer;

public class BasicAudioPlayerAdapter implements FormatAwareAudioPlayer {

    private final BasicAudioPlayer basicAudioPlayer;

    public BasicAudioPlayerAdapter() {
        this.basicAudioPlayer = new BasicAudioPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        basicAudioPlayer.reproducirWav(fileName);
    }

    @Override
    public void stop() {
        basicAudioPlayer.detener();
    }

    @Override
    public boolean supports(String audioType) {
        return "wav".equalsIgnoreCase(audioType);
    }
}
