package com.squareit.card.game.enumeration;

/**
 * Enumeration for card values
 */
public enum CardValues {
    AS("As"), DEUX("2"), TROIS("3"), QUATRE("4"), CINQ("5"), SIX("6"),
    SEPT("7"), HUIT("8"), NEUF("9"), DIX("10"), VALET("VALET"), DAME("DAME"), ROI("ROI");


    private String label;

    CardValues(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
