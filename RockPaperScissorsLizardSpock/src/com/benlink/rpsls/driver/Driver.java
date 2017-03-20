package com.benlink.rpsls.driver;

import com.benlink.rpsls.enums.Rpsls;

public class Driver {

    public static void main(String[] args) {
       Rpsls a = Rpsls.SCISSORS;
       Rpsls b = Rpsls.ROCK;
       
       System.out.println(a.getName() + " vs " + b.getName() + " = " + Rpsls.compareTo(a, b));
    }

}
