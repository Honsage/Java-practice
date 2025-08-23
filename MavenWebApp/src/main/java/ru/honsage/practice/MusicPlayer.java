package ru.honsage.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicPlayer {
    private List<Music> musicList;
    @Value("Player")
    private String name;
    @Value("75")
    private int volume;

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    @Autowired
    public MusicPlayer(JazzMusic music) {
        this.musicList = List.of(music);
    }

    public void playMusic() {
        for (Music music : this.musicList) {
            System.out.println("Playing " + music.getSong());
        }
    }

    public void setMusic(Music music) {
        this.musicList.add(music);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
