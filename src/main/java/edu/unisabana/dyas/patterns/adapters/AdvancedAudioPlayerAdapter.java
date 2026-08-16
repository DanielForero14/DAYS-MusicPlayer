package edu.unisabana.dyas.patterns.adapters;
import edu.unisabana.dyas.patterns.utils.AdvancedAudioPlayer;

public class AdvancedAudioPlayerAdapter implements FormatAwareAudioPlayer {

    private final AdvancedAudioPlayer advancedAudioPlayer;

    public AdvancedAudioPlayerAdapter() {
        this.advancedAudioPlayer = new AdvancedAudioPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("mp4".equalsIgnoreCase(audioType)) {
            advancedAudioPlayer.playMp4(fileName);
        } else if ("vlc".equalsIgnoreCase(audioType)) {
            advancedAudioPlayer.playVlc(fileName);
        } else {
            throw new IllegalArgumentException(
                "AdvancedAudioPlayerAdapter no soporta el tipo: " + audioType);
        }
    }

    @Override
    public void stop() {
        advancedAudioPlayer.stop();
    }

    @Override
    public boolean supports(String audioType) {
        return "mp4".equalsIgnoreCase(audioType) || "vlc".equalsIgnoreCase(audioType);
    }
}