package com.twschool.practice.api;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;

public class GuessRepository {
    public   static GuessNumberGame guessNumberGame=new GuessNumberGame(new AnswerGenerator());
    public GuessNumberGame find(){
        return guessNumberGame;
    }
}
