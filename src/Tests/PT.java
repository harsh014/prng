/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.math.BigInteger;

/**
 *
 * @author harsh014
 */
public class PT {

//    defining all variables
    private final BigInteger E;
    private String B;
    private int c00 = 0, c01 = 0, c10 = 0, c11 = 0, i, k;
    private final int m = 2;
    private float PS0, PS1, PS2;

//        constructor
    public PT(String ch) {
        E = new BigInteger(ch);
    }

//        test
    public String test() {
        B = E.toString();
        k = B.length() / m;

//            loop to check sequence for smaller sequences
        for (i = 0; i < B.length() - 1; i += 2) {
            if (B.charAt(i) == '0' && B.charAt(i + 1) == '0') {
                c00++;
            }
            if (B.charAt(i) == '0' && B.charAt(i + 1) == '1') {
                c01++;
            }
            if (B.charAt(i) == '1' && B.charAt(i + 1) == '0') {
                c10++;
            }
            if (B.charAt(i) == '1' && B.charAt(i + 1) == '1') {
                c11++;
            }
        }

//            calculating statistic variable
        PS0 = (c00 * c00) + (c01 * c01) + (c10 * c10) + (c11 * c11);
        PS1 = 4 * PS0;
        PS2 = ((float) PS1 / k) - k;

//        checking of statistic variable
        if (PS2 < 14.0671) {
            return "Random";
        } else {
            return "Not Random";
        }
    }
}
