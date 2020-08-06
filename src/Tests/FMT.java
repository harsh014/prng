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
public class FMT {

//    defining all variables
    private int n = 0, Sn = 0;
    private double Sobs, P_value;
    private BigInteger E, E1;

//        constructor
    public FMT(String ch) {
        E = new BigInteger(ch);
    }

    public String test() {
        //    Finding length of input and finding value of Sn
        //    For every '1' in the input, a '1' is added to Sn
        //    For every '0' in the input, a '-1' is added to Sn
        do {
            E1 = E.mod(BigInteger.TEN);
            n++;
            if (E1.equals(BigInteger.ONE)) {
                Sn += 1;
            } else if (E1.equals(BigInteger.ZERO)) {
                Sn -= 1;
            }
            E = E.divide(BigInteger.TEN);
        } while (E != BigInteger.ZERO);

        //    Finding value of Sobs
        Sobs = Math.abs(Sn) / Math.sqrt(n);

        //    Finding value of P-value
        P_value = erfc(Sobs / Math.sqrt(2));

        //    Checking P-value for randomness
        if (P_value < 0.01) {
            return "Not Ramdom";
        } else {
            return "Random";
        }
    }
}
