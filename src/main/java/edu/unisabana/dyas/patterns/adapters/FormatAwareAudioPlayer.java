package edu.unisabana.dyas.patterns.adapters;
import edu.unisabana.dyas.patterns.utils.AudioPlayer;

// Extiende AudioPlayer (no la modifica) para que los adaptadores concretos
// puedan declarar qué tipos de audio saben manejar.
public interface FormatAwareAudioPlayer extends AudioPlayer {
    boolean supports(String audioType);
}