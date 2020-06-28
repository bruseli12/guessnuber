package com.twschool.practice.domain;

import java.util.HashMap;
import java.util.Map;

public class GameScore {

    public static Map userSocre = new HashMap<String, ScoreStatus>();

    public static void calcscore(String username, GameStatus gameStatus) {
        System.out.println("status" +gameStatus);
        if (gameStatus.equals(GameStatus.FAILED)) {
            ScoreStatus scoreStatus = (ScoreStatus) getScoreStatus(username);
            scoreStatus.decrease3score();
            scoreStatus.setContinuewintimes0();
        }

        if (gameStatus.equals(GameStatus.SUCCEED)) {
            System.out.println("status" +gameStatus);
            ScoreStatus scoreStatus = (ScoreStatus) getScoreStatus(username);
            int times = scoreStatus.getContinuewintimes();
            scoreStatus.increase3score();
            if ((times + 1) % 3 == 0)
                scoreStatus.increase2score();
            if ((times + 1) % 5 == 0)
                scoreStatus.increase3score();
            scoreStatus.addContinuewintimes();
        }

    }

    public static ScoreStatus getScoreStatus(String username) {
        if (userSocre.containsKey(username))
            return (ScoreStatus) userSocre.get(username);
        userSocre.put(username, new ScoreStatus(0, 0));
        return (ScoreStatus) userSocre.get(username);
    }

    public static int getScore(String username) {
        return ((ScoreStatus) userSocre.get(username)).getScore();
    }
}
