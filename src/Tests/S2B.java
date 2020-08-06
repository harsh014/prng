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
public class S2B {

//    defining of all variables
    private final BigInteger E;
    private int c0 = 0, c1 = 0, c00 = 0, c01 = 0, c10 = 0, c11 = 0, len;
    private String E_str;
    private float x0, x1, x2;

//        constructor
    public S2B(String ch) {
        E = new BigInteger(ch);
    }

//        test
    public String test() {
        E_str = E.toString();
        len = E_str.length();

//            loop to check sequences for 1-bit sequences
        for (int i = 0; i < len; i++) {
            if (E_str.charAt(i) == '1') {
                c1++;
            }
            if (E_str.charAt(i) == '0') {
                c0++;
            }
        }

//            loop to check sequences for 2-bit sequences
        for (int i = 0; i < len - 1; i++) {
            if (E_str.charAt(i) == '0' && E_str.charAt(i + 1) == '0') {
                c00++;
            }
            if (E_str.charAt(i) == '0' && E_str.charAt(i + 1) == '1') {
                c01++;
            }
            if (E_str.charAt(i) == '1' && E_str.charAt(i + 1) == '0') {
                c10++;
            }
            if (E_str.charAt(i) == '1' && E_str.charAt(i + 1) == '1') {
                c11++;
            }
        }

//            calculating statistic variable
        x0 = (float) (Math.sqrt(c00) + Math.sqrt(c01) + Math.sqrt(c10) + Math.sqrt(c11));
        x1 = (float) (Math.sqrt(c0) + Math.sqrt(c1));
        x2 = (4 * x0 / (len - 1)) - (2 * x1 / len) + 1;

//            checking statistic variable
        if (x2 < 5.9915) {
            return "Random";
        } else {
            return "Not Random";
        }
    }
}
