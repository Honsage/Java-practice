package ru.honsage.practice;

public class PhonkMusic implements Music {
    private PhonkMusic() {}

    public static PhonkMusic getPhonkMusic() {
        return new PhonkMusic();
    }

    @Override
    public String getSong() {
        return "Phonk";
    }
}
