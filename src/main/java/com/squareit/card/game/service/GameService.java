package com.squareit.card.game.service;

import com.squareit.card.game.model.Card;

/**
 * An interface for game service
 */
public interface GameService {
    Card[] initGame();

    Card[] sortCard(Card[] gameArrayToSort);

    Card[] randomCard(Card[] cards);
}
