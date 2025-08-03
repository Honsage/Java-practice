package ru.honsage.practice;

public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Classic " /*+ this.hashCode()*/;
    }
}
