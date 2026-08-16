package edu.unisabana.dyas.patterns.adapters;
import edu.unisabana.dyas.patterns.utils.AudioPlayer;

import java.util.ArrayList;
import java.util.List;

// Punto único de entrada: implementa AudioPlayer y reparte internamente
// la petición al adaptador correcto según el tipo de audio.
public class AudioPlayerAdapter implements AudioPlayer {

    private final List<FormatAwareAudioPlayer> adapters = new ArrayList<>();
    private FormatAwareAudioPlayer activeAdapter;

    public AudioPlayerAdapter() {
        adapters.add(new AdvancedAudioPlayerAdapter());
        adapters.add(new PremiumAudioPlayerAdapter());
        adapters.add(new BasicAudioPlayerAdapter());
        // Para soportar un TERCER proveedor en el futuro:
        // 1) Crear su clase XxxAdapter implementando FormatAwareAudioPlayer.
        // 2) Añadir aquí: adapters.add(new XxxAdapter());
        // No hace falta tocar Client.java ni los adaptadores existentes.
    }

    @Override
    public void play(String audioType, String fileName) {
        for (FormatAwareAudioPlayer adapter : adapters) {
            if (adapter.supports(audioType)) {
                adapter.play(audioType, fileName);
                activeAdapter = adapter;
                return;
            }
        }
        throw new IllegalArgumentException("Tipo de audio no soportado: " + audioType);
    }

    @Override
    public void stop() {
        if (activeAdapter != null) {
            activeAdapter.stop();
        }
    }
}
