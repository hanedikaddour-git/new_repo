package com.squareit.card.game.service;

import com.squareit.card.game.enumeration.CardColors;
import com.squareit.card.game.enumeration.CardValues;
import com.squareit.card.game.model.Card;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class GameServiceImplTest {

    @Test
    void initGame_WhenCalled_WillCreateAnArrayOfCard() {
        //Given
        GameService gameService = new GameServiceImpl();
        //When
        Card[] cardArray = gameService.initGame();
        //Then
        Assertions.assertThat(cardArray).isNotEmpty();
        Assertions.assertThat(cardArray.length).isEqualTo(52);
    }

    @Test
    void sortCard_WhenEmptyCardArray_WillNotSortAnArrayOfCard() {
        //Given
        GameService gameService = new GameServiceImpl();
        Card[] cards = new Card[0];
        //When
        Card[] cardArray = gameService.sortCard(cards);
        //Then
        Assertions.assertThat(cardArray).isEmpty();
    }

    @Test
    void sortCard_WhenFullCardArray_WillSortAnArrayOfCard() {
        //Given
        GameService gameService = new GameServiceImpl();
        Card[] cards = buildCardArray();
        //When
        Card[] cardArray = gameService.sortCard(cards);
        //Then
        Assertions.assertThat(cardArray).isNotEmpty();
        Assertions.assertThat(cardArray.length).isEqualTo(4);
        Assertions.assertThat(cardArray[0].getColor()).isEqualTo(CardColors.DIAMONDS);
        Assertions.assertThat(cardArray[0].getRow()).isEqualTo(CardValues.SIX.getLabel());
        Assertions.assertThat(cardArray[1].getColor()).isEqualTo(CardColors.HEART);
        Assertions.assertThat(cardArray[1].getRow()).isEqualTo(CardValues.TROIS.getLabel());
        Assertions.assertThat(cardArray[2].getColor()).isEqualTo(CardColors.SPADES);
        Assertions.assertThat(cardArray[2].getRow()).isEqualTo(CardValues.QUATRE.getLabel());
        Assertions.assertThat(cardArray[3].getColor()).isEqualTo(CardColors.SPADES);
        Assertions.assertThat(cardArray[3].getRow()).isEqualTo(CardValues.SIX.getLabel());
    }

    private Card[] buildCardArray() {
        return new Card[]{new Card(CardValues.SIX.getLabel(), CardColors.SPADES),
                new Card(CardValues.SIX.getLabel(), CardColors.DIAMONDS),
                new Card(CardValues.QUATRE.getLabel(), CardColors.SPADES),
                new Card(CardValues.TROIS.getLabel(), CardColors.HEART)
        };
    }

}
