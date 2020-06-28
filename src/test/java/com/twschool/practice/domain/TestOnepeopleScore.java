package com.twschool.practice.domain;

import com.twschool.practice.api.GuessRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TestOnepeopleScore {

    @Autowired
    private MockMvc mockMvc;

    private GuessNumberGame guessNumberGame;


    @Before
    public void setUp() throws Exception {
        GameAnswer gameAnswer = new GameAnswer("1 2 3 4");

        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        Mockito.when(answerGenerator.generateAnswer()).thenReturn(gameAnswer);
        guessNumberGame = new GuessNumberGame(answerGenerator);
    }
    @Test
    public void should_return_3_when_succeed_1_times_given_number_1234() throws  Exception{

        GuessRepository.guessNumberGame=guessNumberGame;

        this.mockMvc.perform(MockMvcRequestBuilders.post("/games/guess-number").contentType(APPLICATION_JSON).content("{\"number\":\"1 2 3 4\",\"username\":\"lihuadeng\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.number").value("1 2 3 4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("lihuadeng"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.score").value(3));
    }
}
