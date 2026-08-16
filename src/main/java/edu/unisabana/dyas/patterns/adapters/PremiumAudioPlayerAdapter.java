package edu.unisabana.dyas.patterns.adapters;
import edu.unisabana.dyas.patterns.utils.PremiumAudioPlayer;

public class PremiumAudioPlayerAdapter implements FormatAwareAudioPlayer {

    /*
     * Volumen por defecto: 50%.
     * Justificación: como AudioPlayer.play(...) no permite especificar volumen,
     * usamos un valor medio, ni silencioso ni ensordecedor, seguro para
     * cualquier dispositivo/entorno cuando el llamador no indica preferencia.
     */
    private static final int DEFAULT_VOLUME = 50;

    private final PremiumAudioPlayer premiumAudioPlayer;

    public PremiumAudioPlayerAdapter() {
        this.premiumAudioPlayer = new PremiumAudioPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (!supports(audioType)) {
            throw new IllegalArgumentException(
                "PremiumAudioPlayerAdapter no soporta el tipo: " + audioType);
        }
        premiumAudioPlayer.playAudio(audioType.toLowerCase(), fileName, DEFAULT_VOLUME);
    }

    @Override
    public void stop() {
        premiumAudioPlayer.halt();
    }

    @Override
    public boolean supports(String audioType) {
        return "flac".equalsIgnoreCase(audioType) || "aac".equalsIgnoreCase(audioType);
    }
}