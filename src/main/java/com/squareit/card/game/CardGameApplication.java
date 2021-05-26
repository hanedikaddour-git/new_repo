package com.squareit.card.game;

import com.squareit.card.game.model.Card;
import com.squareit.card.game.service.GameService;
import com.squareit.card.game.service.GameServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardGameApplication {

    public static void main(String[] args) {

        SpringApplication.run(CardGameApplication.class, args);
        GameService gameService = new GameServiceImpl();
        Card[] gameCard = gameService.initGame();
        Card[] handCard = gameService.randomCard(gameCard);
        gameService.sortCard(handCard);
    }

}

