package ru.honsage.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();

        Music music = context.getBean("jazzMusic", JazzMusic.class);
        System.out.println(music.getSong());

        System.out.println(musicPlayer.getName() + " " + musicPlayer.getVolume());
        context.close();
    }
}
