package com.twschool.practice.api;

import com.twschool.practice.domain.GuessNumberGame;

public class GuessService {
    private GuessNumberGame guessNumberGame;

    public  GuessService(GuessNumberGame guessNumberGame){
        this.guessNumberGame=guessNumberGame;
    }
    public String guess(String userNmber) {

        return  guessNumberGame.guess(userNmber);
    }
}
