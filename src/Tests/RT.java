/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.math.BigInteger;
import static org.apache.commons.math3.special.Erf.erfc;

/**
 *
 * @author harsh014
 */
public class RT {

//    defining all variables
    private int n = 0, no_1 = 0;
    private double Vn_obs = 0, P_value = 0.0, pi;
    private BigInteger E, E1;
    private final BigInteger E_copy;

//        constructor
    public RT(String ch) {
        E = new BigInteger(ch);
        E_copy = E;
    }

//        test
    public String test() {

//            loop to find length of sequence
        do {
            E1 = E.mod(BigInteger.TEN);
            n++;
            if (E1.equals(BigInteger.ONE)) {
                no_1 += 1;
            }
            E = E.divide(BigInteger.TEN);
        } while (E != BigInteger.ZERO);

        //    Finding the value of pi
        pi = (double) no_1 / n;

        String test = String.valueOf(E_copy);
        if (Math.abs(pi - 0.5) < (2 / Math.sqrt(n))) {
            //    Finding number of non-similar bits
            for (int i = 0; i < n - 2; i++) {
                if (test.charAt(i) != test.charAt(i + 1)) {
                    Vn_obs += 1;
                }
            }
            Vn_obs += 1;

            //    Finding value of P_value        
            P_value = erfc(Math.abs(Vn_obs - (2 * n * pi * (1 - pi))) / (2 * Math.sqrt(2 * n) * pi * (1 - pi)));
        }
        if (P_value < 0.01) {
            return "Not Random";
        } else {
            return "Random";
        }
    }
}
