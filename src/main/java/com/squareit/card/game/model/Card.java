package com.squareit.card.game.model;

import com.squareit.card.game.enumeration.CardColors;

/**
 * A class to define card
 */
public class Card {
    /**
     * row field
     */
    private String row;
    /**
     * color field
     */
    private CardColors color;

    /**
     * Constructor with parameter
     *
     * @param row
     * @param color
     */

    public Card(String row, CardColors color) {
        this.row = row;
        this.color = color;
    }

    public CardColors getColor() {
        return color;
    }


    public String getRow() {
        return row;
    }

}
