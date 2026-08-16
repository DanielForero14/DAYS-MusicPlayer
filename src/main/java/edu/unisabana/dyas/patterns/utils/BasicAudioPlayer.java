package edu.unisabana.dyas.patterns.utils;

// Simulación de un TERCER proveedor externo, con su propia API incompatible
public class BasicAudioPlayer {
    public void reproducirWav(String fileName) {
        System.out.println("[Basic] Reproduciendo WAV: " + fileName);
    }

    public void detener() {
        System.out.println("[Basic] Detenido");
    }
}