package com.squareit.card.game.service;

import com.squareit.card.game.enumeration.CardColors;
import com.squareit.card.game.enumeration.CardValues;
import com.squareit.card.game.model.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * A class for game service implementation
 */
public class GameServiceImpl implements GameService {


    private static final int NB_CARDS = 52;
    private static final Random rand = new Random();
    private static final Logger LOGGER = LoggerFactory.getLogger(GameServiceImpl.class);

    /**
     * init game: create the 52 (13*4) possibility of  card (cardValue,cardColor)
     *
     * @return created card game array
     */
    @Override
    public Card[] initGame() {
        Card[] game = new Card[NB_CARDS];
        int i = 0;
        for (CardColors c : CardColors.values()) {
            for (CardValues v : CardValues.values()) {
                game[i++] = new Card(v.getLabel(), c);
            }
        }
        LOGGER.info("Game card array");
        return game;
    }


    /**
     * Order  cards game in the order of colors and values
     * sort by selection
     *
     * @param gameArrayToSort
     */
    @Override
    public Card[] sortCard(Card[] gameArrayToSort) {
        if (gameArrayToSort.length != 0) {
            for (int i = 0; i < gameArrayToSort.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < gameArrayToSort.length; j++)
                    if (compareTo(gameArrayToSort[min], gameArrayToSort[j]) < 0)
                        min = j;

                if (i != min)
                    exchangeCard(gameArrayToSort, i, min);
            }

            LOGGER.info("Game hand after sorting");
            Arrays.stream(gameArrayToSort).forEach(game -> System.out.println("(" +
                    game.getColor() + "," + game.getRow() + ")"));
        }
        return gameArrayToSort;
    }

    /**
     * Exchange cards randomly
     *
     * @param cards
     * @param i
     * @param j
     */
    private void exchangeCard(Card[] cards, int i, int j) {
        Card tempCard = cards[i];
        cards[i] = cards[j];
        cards[j] = tempCard;
    }

    private int compareTo(Card c, Card c1) {

        return c1.getColor() == c.getColor() ? c1.getRow().compareTo(c.getRow()) : c1.getColor().ordinal() - c.getColor().ordinal();
    }

    /**
     * random card
     */
    public Card[] randomCard(Card[] cards) {
        Card[] handCard;
        IntStream.range(0, NB_CARDS).forEach(i -> exchangeCard(cards,
                rand.nextInt(NB_CARDS),
                rand.nextInt(NB_CARDS)));
        LOGGER.info(" random hand card array");
        handCard = Arrays.copyOfRange(cards, 0, 10);
        Arrays.stream(handCard).forEach(game -> System.out.println("(" +
                game.getColor() + "," + game.getRow() + ")"));
        return handCard;
    }
}
