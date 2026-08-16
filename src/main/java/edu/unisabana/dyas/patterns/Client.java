package edu.unisabana.dyas.patterns;

import edu.unisabana.dyas.patterns.adapters.AudioPlayerAdapter;
import edu.unisabana.dyas.patterns.utils.AudioPlayer;

public class Client {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayerAdapter();

        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.stop();

        audioPlayer.play("vlc", "pelicula.vlc");
        audioPlayer.stop();

        audioPlayer.play("flac", "album.flac");
        audioPlayer.stop();

        audioPlayer.play("aac", "cancion.aac");
        audioPlayer.stop();

        audioPlayer.play("wav", "sonido.wav");
        audioPlayer.stop();
    }
}