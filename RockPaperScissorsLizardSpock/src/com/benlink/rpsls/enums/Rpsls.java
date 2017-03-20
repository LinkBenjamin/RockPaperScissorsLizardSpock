package com.benlink.rpsls.enums;

import java.awt.Color;

public enum Rpsls {
    ROCK("Rock", Color.ORANGE),
    PAPER("Paper", Color.YELLOW),
    SCISSORS("Scissors", Color.MAGENTA),
    LIZARD("Lizard", Color.GREEN),
    SPOCK("Spock", Color.BLUE);
    
    private final String name;
    private final Color color;
    
    private Rpsls(String newName, Color newColor){
        this.name = newName;
        this.color = newColor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * CompareTo
     * 
     * @param a
     * @param b
     * @return
     */
    public static int compareTo(Rpsls a, Rpsls b){
        //if a beats b, return 1
        //if a ties b, return 0
        //if b beats a, return -1
        int returnValue = 0;
        
        if(a == b) return returnValue;
        
        switch(a){
            case ROCK:
                if(b == LIZARD || b == SCISSORS){
                    returnValue = 1;
                } else {
                    returnValue = -1;
                }
                break;
            case PAPER:
                if(b == SPOCK || b == ROCK){
                    returnValue = 1;
                } else {
                    returnValue = -1;
                }
                break;
            case SCISSORS:
                if(b == PAPER || b == LIZARD){
                    returnValue = 1;
                } else {
                    returnValue = -1;
                }
                break;
            case LIZARD:
                if(b == SPOCK || b == PAPER){
                    returnValue = 1;
                } else {
                    returnValue = -1;
                }
                break;
            case SPOCK:
                if(b == SCISSORS || b == ROCK){
                    returnValue = 1;
                } else {
                    returnValue = -1;
                }
                break;
        }
        return returnValue;
    }
}
