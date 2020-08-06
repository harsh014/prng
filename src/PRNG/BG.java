/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRNG;

/**
 *
 * @author harsh014
 */
public class BG {

    private int n, X0, level, temp;
    private int[] X = new int[201];
    private Boolean[] B = new Boolean[201];
    private boolean B0;
    private String ret = "";

    public BG(int a, int b, int c, int d) {
        n = a;
        level = b;
        PNG png = new PNG(c, d, 1);
        png.init();
        temp = png.e[0][0] * png.e[1][0];
    }

    public String gen() {

        if (level == 1) {
            X0 = (temp * temp * temp) / n;
        }
//            else if (level == 2) {
//            X0 = temp * temp * temp / n;
//        }

        X[0] = X0;
        B0 = (X0 % 2 != 0);
        B[0] = B0;

        for (int i = 1; i < 100; i++) {
            X[i] = (X[i - 1] * X[i - 1] * X[i - 1] * (n / 2) * i) / n;
            B[i] = (X[i] % 2) != 0;
        }

        for (int i = 0; i < 100; i++) {
            if (B[i]) {
                ret = ret.concat("1");
            } else if (!B[i]) {
                ret = ret.concat("0");
            }
        }

        return ret;
    }
}
