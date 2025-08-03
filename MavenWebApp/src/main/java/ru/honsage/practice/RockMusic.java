package ru.honsage.practice;

public class RockMusic implements Music {
    public void init() {
        System.out.println("Rock loaded");
    }

    public void destroy() {
        System.out.println("Rock shutdown");
    }

    @Override
    public String getSong() {
        return "Rock";
    }
}
