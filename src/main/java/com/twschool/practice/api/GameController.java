package com.twschool.practice.api;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {
    @PostMapping  ("/games/guess-number")
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody){
        GuessRepository guessRepostory=new GuessRepository();
        GuessNumberGame guessNumberGame=guessRepostory.find();
        GuessService guessService=new GuessService(guessNumberGame);
        String result=guessService.guess(requestBody.get("number"));
        Map<String, String> responseBody=new HashMap<String, String>();
        responseBody.put("input",requestBody.get("number"));
        responseBody.put("result",result);
        return  responseBody;
    }
}
