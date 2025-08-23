package ru.honsage.practice;

import org.springframework.stereotype.Component;

@Component("jazzMusic")
public class JazzMusic implements Music{
    @Override
    public String getSong() {
        return "Jazz";
    }
}
