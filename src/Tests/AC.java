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
public class AC {

//    defining all variables
    private int AS;
    private float t, ACX;
    private String c;
    private final BigInteger E;

//    constructor
    public AC(String ch) {
        E = new BigInteger(ch);
        AS = 0;
    }

//    test function
    public String test(int temp) {

//        convert sequence to string
        c = E.toString();

//        loop to XOR the sequence bits
        for (int i = 0; i < (c.length() - temp - 1); i++) {
            AS += (c.charAt(i) ^ c.charAt(i + temp));
        }

//        formula to find statistic ACX
        t = AS - ((c.length() - temp) / 2);
        t *= 2;
        ACX = t / (float) Math.sqrt(c.length() - temp);

//        test for ACX
        if (ACX < 1.96) {
            return "Random";
        } else {
            return "Not Random";
        }
    }
}
