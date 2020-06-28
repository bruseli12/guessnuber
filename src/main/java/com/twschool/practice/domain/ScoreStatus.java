package com.twschool.practice.domain;

public class ScoreStatus {
    private  int continuewintimes;
    private int score;

    public ScoreStatus(int continuewintimes, int score) {
        this.continuewintimes=continuewintimes;
        this.score=score;
    }

    public int getContinuewintimes() {
        return continuewintimes;
    }

    public void setContinuewintimes(int continuewintimes) {
        this.continuewintimes = continuewintimes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void decrease3score(){
        this.score-=3;
    }
    public void increase3score(){
        this.score+=3;
    }
    public void increase2score(){
        this.score+=2;
    }

    public void addContinuewintimes() {
        this.continuewintimes++;
    }

    public void setContinuewintimes0() {
        this.continuewintimes=0;
    }

}
