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
public class PNG {

    private final int[][] a = new int[3][3];
    private final int[][] b = new int[3][3];
    private int[][] c = new int[3][3];
    private final int[][] d = new int[3][1];
    public int[][] e = new int[3][1];
    private int[][] r = new int[40][20];
    private int[][] alpha = new int[200][20];
    private int x, y, z, i, j, k, p = 4, n = -4, b1 = 0, b2 = 0, level;
    private int val, num, sum = 0, basesum, count1 = 0, nn = 0;
    private int count, incre = 0, ab, tempo = 0;

    private long[] pq = new long[100];
    private long[] pp;
    public long[] pp_copy = new long[100];

    private String resultdata, Val;

    public PNG(int x, int y, int level) {

        this.x = x;
        this.y = y;
        this.level = level;

        if (x > y) {
            this.x = y;
            this.y = x;
        } else {
            this.x = x;
            this.y = y;
        }

        if (level == 1) {
            b1 = 0;
            b2 = 0;
        } else if (level == 2) {
            b1 = 0;
            b2 = 1;
        }

        for (i = 0; i < 40; i++) {
            for (j = 0; j < 20; j++) {
                r[i][j] = 0;
            }
        }

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 20; j++) {
                alpha[i][j] = 0;
            }
        }

        for (int m = 0; m < 100; m++) {
            pq[m] = 0;
        }

//        values of alpha
        alpha[2][0] = 1;
        alpha[2][1] = 3;
        alpha[2][2] = 21;
        alpha[2][3] = 23;
        alpha[2][4] = 41;
        alpha[2][5] = 9;
        alpha[2][6] = 27;
        alpha[2][7] = 63;
        alpha[2][8] = 81;
        alpha[2][9] = 29;
        alpha[2][10] = 47;
        alpha[2][11] = 83;
        alpha[2][12] = 69;
        alpha[2][13] = 87;
        alpha[2][14] = 89;

        alpha[3][0] = 11;
        alpha[3][1] = 13;
        alpha[3][2] = 31;
        alpha[3][3] = 17;
        alpha[3][4] = 53;
        alpha[3][5] = 71;
        alpha[3][6] = 19;
        alpha[3][7] = 37;
        alpha[3][8] = 73;
        alpha[3][9] = 91;
        alpha[3][10] = 59;
        alpha[3][11] = 77;
        alpha[3][12] = 79;
        alpha[3][13] = 97;

        alpha[4][0] = 1;
        alpha[4][1] = 3;
        alpha[4][2] = 21;
        alpha[4][3] = 7;
        alpha[4][4] = 43;
        alpha[4][5] = 61;
        alpha[4][6] = 9;
        alpha[4][7] = 27;
        alpha[4][8] = 63;
        alpha[4][9] = 81;
        alpha[4][10] = 49;
        alpha[4][11] = 67;
        alpha[4][12] = 69;
        alpha[4][13] = 87;

        alpha[5][0] = 11;
        alpha[5][1] = 33;
        alpha[5][2] = 51;
        alpha[5][3] = 17;
        alpha[5][4] = 53;
        alpha[5][5] = 71;
        alpha[5][6] = 39;
        alpha[5][7] = 57;
        alpha[5][8] = 93;
        alpha[5][9] = 59;
        alpha[5][10] = 77;
        alpha[5][11] = 99;

        alpha[6][0] = 1;
        alpha[6][1] = 23;
        alpha[6][2] = 41;
        alpha[6][3] = 7;
        alpha[6][4] = 43;
        alpha[6][5] = 61;
        alpha[6][6] = 29;
        alpha[6][7] = 47;
        alpha[6][8] = 83;
        alpha[6][9] = 49;
        alpha[6][10] = 67;
        alpha[6][11] = 89;

        alpha[7][0] = 13;
        alpha[7][1] = 31;
        alpha[7][2] = 33;
        alpha[7][3] = 51;
        alpha[7][4] = 19;
        alpha[7][5] = 37;
        alpha[7][6] = 73;
        alpha[7][7] = 91;
        alpha[7][8] = 39;
        alpha[7][9] = 57;
        alpha[7][10] = 93;
        alpha[7][11] = 79;
        alpha[7][12] = 97;

        alpha[8][0] = 3;
        alpha[8][1] = 21;
        alpha[8][2] = 5;
        alpha[8][3] = 23;
        alpha[8][4] = 41;
        alpha[8][5] = 9;
        alpha[8][6] = 27;
        alpha[8][7] = 63;
        alpha[8][8] = 81;
        alpha[8][9] = 29;
        alpha[8][10] = 47;
        alpha[8][11] = 83;
        alpha[8][12] = 69;
        alpha[8][13] = 87;

        alpha[9][0] = 11;
        alpha[9][1] = 13;
        alpha[9][2] = 31;
        alpha[9][3] = 17;
        alpha[9][4] = 53;
        alpha[9][5] = 71;
        alpha[9][6] = 19;
        alpha[9][7] = 37;
        alpha[9][8] = 73;
        alpha[9][9] = 91;
        alpha[9][10] = 59;
        alpha[9][11] = 77;

        alpha[10][0] = 1;
        alpha[10][1] = 3;
        alpha[10][2] = 21;
        alpha[10][3] = 7;
        alpha[10][4] = 43;
        alpha[10][5] = 61;
        alpha[10][6] = 9;
        alpha[10][7] = 27;
        alpha[10][8] = 63;
        alpha[10][9] = 81;
        alpha[10][10] = 49;
        alpha[10][11] = 67;

        alpha[11][0] = 11;
        alpha[11][1] = 33;
        alpha[11][2] = 51;
        alpha[11][3] = 17;
        alpha[11][4] = 53;
        alpha[11][5] = 71;
        alpha[11][6] = 39;
        alpha[11][7] = 57;
        alpha[11][8] = 93;
        alpha[11][9] = 99;

        alpha[12][0] = 1;
        alpha[12][1] = 23;
        alpha[12][2] = 41;
        alpha[12][3] = 7;
        alpha[12][4] = 43;
        alpha[12][5] = 61;
        alpha[12][6] = 29;
        alpha[12][7] = 47;
        alpha[12][8] = 83;
        alpha[12][9] = 89;

        alpha[13][0] = 13;
        alpha[13][1] = 31;
        alpha[13][2] = 33;
        alpha[13][3] = 51;
        alpha[13][4] = 19;
        alpha[13][5] = 37;
        alpha[13][6] = 73;
        alpha[13][7] = 91;
        alpha[13][8] = 79;
        alpha[13][9] = 97;
        alpha[13][10] = 99;

        alpha[14][0] = 3;
        alpha[14][1] = 21;
        alpha[14][2] = 23;
        alpha[14][3] = 41;
        alpha[14][4] = 9;
        alpha[14][5] = 27;
        alpha[14][6] = 63;
        alpha[14][7] = 81;
        alpha[14][8] = 69;
        alpha[14][9] = 87;
        alpha[14][10] = 89;

        alpha[15][0] = 11;
        alpha[15][1] = 13;
        alpha[15][2] = 31;
        alpha[15][3] = 17;
        alpha[15][4] = 53;
        alpha[15][5] = 71;
        alpha[15][6] = 59;
        alpha[15][7] = 77;
        alpha[15][8] = 79;
        alpha[15][9] = 97;

        alpha[16][0] = 1;
        alpha[16][1] = 3;
        alpha[16][2] = 21;
        alpha[16][3] = 7;
        alpha[16][4] = 43;
        alpha[16][5] = 61;
        alpha[16][6] = 49;
        alpha[16][7] = 67;
        alpha[16][8] = 69;
        alpha[16][9] = 87;

        alpha[17][0] = 11;
        alpha[17][1] = 33;
        alpha[17][2] = 51;
        alpha[17][3] = 39;
        alpha[17][4] = 57;
        alpha[17][5] = 93;
        alpha[17][6] = 59;
        alpha[17][7] = 77;

        alpha[18][0] = 1;
        alpha[18][1] = 23;
        alpha[18][2] = 41;
        alpha[18][3] = 29;
        alpha[18][4] = 47;
        alpha[18][5] = 83;
        alpha[18][6] = 49;
        alpha[18][7] = 67;

        alpha[19][0] = 13;
        alpha[19][1] = 31;
        alpha[19][2] = 19;
        alpha[19][3] = 37;
        alpha[19][4] = 73;
        alpha[19][5] = 91;
        alpha[19][6] = 39;
        alpha[19][7] = 57;
        alpha[19][8] = 93;
        alpha[19][9] = 99;

        alpha[20][0] = 3;
        alpha[20][1] = 21;
        alpha[20][2] = 9;
        alpha[20][3] = 27;
        alpha[20][4] = 63;
        alpha[20][5] = 81;
        alpha[20][6] = 29;
        alpha[20][7] = 47;
        alpha[20][8] = 83;
        alpha[20][9] = 89;

        alpha[21][0] = 11;
        alpha[21][1] = 7;
        alpha[21][2] = 43;
        alpha[21][3] = 61;
        alpha[21][4] = 19;
        alpha[21][5] = 37;
        alpha[21][6] = 73;
        alpha[21][7] = 91;
        alpha[21][8] = 79;
        alpha[21][9] = 97;

        alpha[22][0] = 1;
        alpha[22][1] = 7;
        alpha[22][2] = 43;
        alpha[22][3] = 61;
        alpha[22][4] = 9;
        alpha[22][5] = 27;
        alpha[22][6] = 63;
        alpha[22][7] = 81;
        alpha[22][8] = 69;
        alpha[22][9] = 87;

        alpha[23][0] = 33;
        alpha[23][1] = 51;
        alpha[23][2] = 17;
        alpha[23][3] = 53;
        alpha[23][4] = 71;
        alpha[23][5] = 59;
        alpha[23][6] = 77;
        alpha[23][7] = 99;

        alpha[24][0] = 23;
        alpha[24][1] = 41;
        alpha[24][2] = 7;
        alpha[24][3] = 43;
        alpha[24][4] = 61;
        alpha[24][5] = 49;
        alpha[24][6] = 67;
        alpha[24][7] = 89;

        alpha[25][0] = 13;
        alpha[25][1] = 31;
        alpha[25][2] = 33;
        alpha[25][3] = 51;
        alpha[25][4] = 39;
        alpha[25][5] = 57;
        alpha[25][6] = 93;
        alpha[25][7] = 79;
        alpha[25][8] = 97;
        alpha[25][9] = 99;

        alpha[26][0] = 3;
        alpha[26][1] = 21;
        alpha[26][2] = 23;
        alpha[26][3] = 41;
        alpha[26][4] = 29;
        alpha[26][5] = 47;
        alpha[26][6] = 83;
        alpha[26][7] = 69;
        alpha[26][8] = 87;
        alpha[26][9] = 89;

        alpha[27][0] = 11;
        alpha[27][1] = 13;
        alpha[27][2] = 31;
        alpha[27][3] = 19;
        alpha[27][4] = 37;
        alpha[27][5] = 73;
        alpha[27][6] = 91;
        alpha[27][7] = 59;
        alpha[27][8] = 77;
        alpha[27][9] = 79;
        alpha[27][10] = 97;

        alpha[28][0] = 1;
        alpha[28][1] = 3;
        alpha[28][2] = 21;
        alpha[28][3] = 9;
        alpha[28][4] = 27;
        alpha[28][5] = 63;
        alpha[28][6] = 81;
        alpha[28][7] = 49;
        alpha[28][8] = 67;
        alpha[28][9] = 69;
        alpha[28][10] = 87;

        alpha[29][0] = 11;
        alpha[29][1] = 17;
        alpha[29][2] = 53;
        alpha[29][3] = 71;
        alpha[29][4] = 39;
        alpha[29][5] = 57;
        alpha[29][6] = 93;
        alpha[29][7] = 59;
        alpha[29][8] = 77;
        alpha[29][9] = 99;

        alpha[30][0] = 1;
        alpha[30][1] = 7;
        alpha[30][2] = 43;
        alpha[30][3] = 61;
        alpha[30][4] = 29;
        alpha[30][5] = 47;
        alpha[30][6] = 83;
        alpha[30][7] = 49;
        alpha[30][8] = 67;
        alpha[30][9] = 89;

        alpha[31][0] = 33;
        alpha[31][1] = 51;
        alpha[31][2] = 19;
        alpha[31][3] = 37;
        alpha[31][4] = 73;
        alpha[31][5] = 91;
        alpha[31][6] = 39;
        alpha[31][7] = 57;
        alpha[31][8] = 93;
        alpha[31][9] = 79;
        alpha[31][10] = 97;

        alpha[32][0] = 23;
        alpha[32][1] = 41;
        alpha[32][2] = 7;
        alpha[32][3] = 43;
        alpha[32][4] = 61;
        alpha[32][5] = 29;
        alpha[32][6] = 47;
        alpha[32][7] = 83;

        alpha[33][0] = 13;
        alpha[33][1] = 31;
        alpha[33][2] = 17;
        alpha[33][3] = 53;
        alpha[33][4] = 71;
        alpha[33][5] = 19;
        alpha[33][6] = 37;
        alpha[33][7] = 73;
        alpha[33][8] = 91;
        alpha[33][9] = 59;
        alpha[33][10] = 77;

        alpha[34][0] = 3;
        alpha[34][1] = 21;
        alpha[34][2] = 7;
        alpha[34][3] = 43;
        alpha[34][4] = 61;
        alpha[34][5] = 9;
        alpha[34][6] = 27;
        alpha[34][7] = 63;
        alpha[34][8] = 81;
        alpha[34][9] = 49;
        alpha[34][10] = 67;

        alpha[35][0] = 11;
        alpha[35][1] = 33;
        alpha[35][2] = 51;
        alpha[35][3] = 17;
        alpha[35][4] = 53;
        alpha[35][5] = 71;
        alpha[35][6] = 39;
        alpha[35][7] = 57;
        alpha[35][8] = 93;
        alpha[35][9] = 99;

        alpha[36][0] = 1;
        alpha[36][1] = 23;
        alpha[36][2] = 41;
        alpha[36][3] = 7;
        alpha[36][4] = 43;
        alpha[36][5] = 61;
        alpha[36][6] = 29;
        alpha[36][7] = 47;
        alpha[36][8] = 83;
        alpha[36][9] = 89;

        alpha[37][0] = 13;
        alpha[37][1] = 31;
        alpha[37][2] = 33;
        alpha[37][3] = 51;
        alpha[37][4] = 19;
        alpha[37][5] = 37;
        alpha[37][6] = 73;
        alpha[37][7] = 91;
        alpha[37][8] = 79;
        alpha[37][9] = 97;

        alpha[38][0] = 3;
        alpha[38][1] = 21;
        alpha[38][2] = 23;
        alpha[38][3] = 41;
        alpha[38][4] = 9;
        alpha[38][5] = 27;
        alpha[38][6] = 63;
        alpha[38][7] = 81;
        alpha[38][8] = 69;
        alpha[38][9] = 87;

        alpha[39][0] = 11;
        alpha[39][1] = 13;
        alpha[39][2] = 31;
        alpha[39][3] = 17;
        alpha[39][4] = 53;
        alpha[39][5] = 71;
        alpha[39][6] = 59;
        alpha[39][7] = 77;

        alpha[40][0] = 1;
        alpha[40][1] = 3;
        alpha[40][2] = 21;
        alpha[40][3] = 7;
        alpha[40][4] = 43;
        alpha[40][5] = 61;
        alpha[40][6] = 49;
        alpha[40][7] = 67;

        alpha[41][0] = 11;
        alpha[41][1] = 33;
        alpha[41][2] = 51;
        alpha[41][3] = 39;
        alpha[41][4] = 57;
        alpha[41][5] = 93;
        alpha[41][6] = 99;

        alpha[42][0] = 1;
        alpha[42][1] = 23;
        alpha[42][2] = 41;
        alpha[42][3] = 29;
        alpha[42][4] = 47;
        alpha[42][5] = 83;
        alpha[42][6] = 89;

        alpha[43][0] = 13;
        alpha[43][1] = 31;
        alpha[43][2] = 19;
        alpha[43][3] = 37;
        alpha[43][4] = 73;
        alpha[43][5] = 91;
        alpha[43][6] = 79;
        alpha[43][7] = 97;
        alpha[43][8] = 99;

        alpha[44][0] = 3;
        alpha[44][1] = 21;
        alpha[44][2] = 9;
        alpha[44][3] = 27;
        alpha[44][4] = 63;
        alpha[44][5] = 81;
        alpha[44][6] = 69;
        alpha[44][7] = 87;
        alpha[44][8] = 89;

        alpha[45][0] = 11;
        alpha[45][1] = 17;
        alpha[45][2] = 53;
        alpha[45][3] = 71;
        alpha[45][4] = 59;
        alpha[45][5] = 77;
        alpha[45][6] = 79;
        alpha[45][7] = 97;

        alpha[46][0] = 1;
        alpha[46][1] = 7;
        alpha[46][2] = 43;
        alpha[46][3] = 61;
        alpha[46][4] = 49;
        alpha[46][5] = 67;
        alpha[46][6] = 69;
        alpha[46][7] = 87;

        alpha[47][0] = 33;
        alpha[47][1] = 51;
        alpha[47][2] = 39;
        alpha[47][3] = 57;
        alpha[47][4] = 93;
        alpha[47][5] = 59;
        alpha[47][6] = 77;

        alpha[48][0] = 23;
        alpha[48][1] = 41;
        alpha[48][2] = 29;
        alpha[48][3] = 47;
        alpha[48][4] = 83;
        alpha[48][5] = 49;
        alpha[48][6] = 67;

        alpha[49][0] = 13;
        alpha[49][1] = 31;
        alpha[49][2] = 19;
        alpha[49][3] = 37;
        alpha[49][4] = 73;
        alpha[49][5] = 91;
        alpha[49][6] = 39;
        alpha[49][7] = 57;
        alpha[49][8] = 93;
        alpha[49][9] = 99;

        alpha[50][0] = 3;
        alpha[50][1] = 21;
        alpha[50][2] = 9;
        alpha[50][3] = 27;
        alpha[50][4] = 63;
        alpha[50][5] = 81;
        alpha[50][6] = 29;
        alpha[50][7] = 47;
        alpha[50][8] = 83;

        alpha[51][0] = 11;
        alpha[51][1] = 17;
        alpha[51][2] = 53;
        alpha[51][3] = 71;
        alpha[51][4] = 19;
        alpha[51][5] = 37;
        alpha[51][6] = 73;
        alpha[51][7] = 91;
        alpha[51][8] = 79;
        alpha[51][9] = 97;

        alpha[52][0] = 1;
        alpha[52][1] = 7;
        alpha[52][2] = 43;
        alpha[52][3] = 61;
        alpha[52][4] = 9;
        alpha[52][5] = 27;
        alpha[52][6] = 63;
        alpha[52][7] = 81;
        alpha[52][8] = 69;
        alpha[52][9] = 87;

        alpha[53][0] = 33;
        alpha[53][1] = 51;
        alpha[53][2] = 17;
        alpha[53][3] = 53;
        alpha[53][4] = 71;
        alpha[53][5] = 59;
        alpha[53][6] = 77;
        alpha[53][7] = 99;

        alpha[54][0] = 23;
        alpha[54][1] = 41;
        alpha[54][2] = 7;
        alpha[54][3] = 43;
        alpha[54][4] = 61;
        alpha[54][5] = 49;
        alpha[54][6] = 67;
        alpha[54][7] = 89;

        alpha[55][0] = 13;
        alpha[55][1] = 31;
        alpha[55][2] = 33;
        alpha[55][3] = 51;
        alpha[55][4] = 39;
        alpha[55][5] = 57;
        alpha[55][6] = 93;
        alpha[55][7] = 79;
        alpha[55][8] = 97;
        alpha[55][9] = 99;

        alpha[56][0] = 3;
        alpha[56][1] = 21;
        alpha[56][2] = 23;
        alpha[56][3] = 41;
        alpha[56][4] = 29;
        alpha[56][5] = 47;
        alpha[56][6] = 83;
        alpha[56][7] = 69;
        alpha[56][8] = 87;
        alpha[56][9] = 89;

        alpha[57][0] = 11;
        alpha[57][1] = 13;
        alpha[57][2] = 31;
        alpha[57][3] = 19;
        alpha[57][4] = 37;
        alpha[57][5] = 73;
        alpha[57][6] = 91;
        alpha[57][7] = 59;
        alpha[57][8] = 77;
        alpha[57][9] = 79;
        alpha[57][10] = 97;

        alpha[58][0] = 1;
        alpha[58][1] = 3;
        alpha[58][2] = 21;
        alpha[58][3] = 9;
        alpha[58][4] = 27;
        alpha[58][5] = 63;
        alpha[58][6] = 81;
        alpha[58][7] = 49;
        alpha[58][8] = 67;
        alpha[58][9] = 69;
        alpha[58][10] = 87;

        alpha[59][0] = 11;
        alpha[59][1] = 17;
        alpha[59][2] = 53;
        alpha[59][3] = 71;
        alpha[59][4] = 39;
        alpha[59][5] = 57;
        alpha[59][6] = 93;
        alpha[59][7] = 59;
        alpha[59][8] = 77;

        alpha[60][0] = 1;
        alpha[60][1] = 7;
        alpha[60][2] = 43;
        alpha[60][3] = 61;
        alpha[60][4] = 29;
        alpha[60][5] = 47;
        alpha[60][6] = 83;
        alpha[60][7] = 49;
        alpha[60][8] = 67;

        alpha[61][0] = 33;
        alpha[61][1] = 51;
        alpha[61][2] = 19;
        alpha[61][3] = 37;
        alpha[61][4] = 73;
        alpha[61][5] = 91;
        alpha[61][6] = 39;
        alpha[61][7] = 57;
        alpha[61][8] = 93;
        alpha[61][9] = 99;

        alpha[62][0] = 23;
        alpha[62][1] = 41;
        alpha[62][2] = 9;
        alpha[62][3] = 27;
        alpha[62][4] = 63;
        alpha[62][5] = 81;
        alpha[62][6] = 29;
        alpha[62][7] = 47;
        alpha[62][8] = 83;
        alpha[62][9] = 89;

        alpha[63][0] = 13;
        alpha[63][1] = 31;
        alpha[63][2] = 17;
        alpha[63][3] = 53;
        alpha[63][4] = 71;
        alpha[63][5] = 19;
        alpha[63][6] = 37;
        alpha[63][7] = 73;
        alpha[63][8] = 91;
        alpha[63][9] = 79;
        alpha[63][10] = 97;

        alpha[64][0] = 3;
        alpha[64][1] = 21;
        alpha[64][2] = 7;
        alpha[64][3] = 43;
        alpha[64][4] = 61;
        alpha[64][5] = 9;
        alpha[64][6] = 27;
        alpha[64][7] = 63;
        alpha[64][8] = 81;
        alpha[64][9] = 69;
        alpha[64][10] = 87;

        alpha[65][0] = 11;
        alpha[65][1] = 33;
        alpha[65][2] = 51;
        alpha[65][3] = 17;
        alpha[65][4] = 53;
        alpha[65][5] = 71;
        alpha[65][6] = 59;
        alpha[65][7] = 77;
        alpha[65][8] = 99;

        alpha[66][0] = 1;
        alpha[66][1] = 23;
        alpha[66][2] = 41;
        alpha[66][3] = 7;
        alpha[66][4] = 43;
        alpha[66][5] = 61;
        alpha[66][6] = 49;
        alpha[66][7] = 67;
        alpha[66][8] = 89;

        alpha[67][0] = 13;
        alpha[67][1] = 31;
        alpha[67][2] = 33;
        alpha[67][3] = 51;
        alpha[67][4] = 39;
        alpha[67][5] = 57;
        alpha[67][6] = 93;
        alpha[67][7] = 79;
        alpha[67][8] = 97;

        alpha[68][0] = 3;
        alpha[68][1] = 21;
        alpha[68][2] = 23;
        alpha[68][3] = 41;
        alpha[68][4] = 29;
        alpha[68][5] = 47;
        alpha[68][6] = 83;
        alpha[68][7] = 69;
        alpha[68][8] = 87;

        alpha[69][0] = 11;
        alpha[69][1] = 13;
        alpha[69][2] = 31;
        alpha[69][3] = 19;
        alpha[69][4] = 37;
        alpha[69][5] = 73;
        alpha[69][6] = 91;
        alpha[69][7] = 59;
        alpha[69][8] = 77;

        alpha[70][0] = 1;
        alpha[70][1] = 3;
        alpha[70][2] = 21;
        alpha[70][3] = 9;
        alpha[70][4] = 27;
        alpha[70][5] = 63;
        alpha[70][6] = 81;
        alpha[70][7] = 49;
        alpha[70][8] = 67;

        alpha[71][0] = 11;
        alpha[71][1] = 17;
        alpha[71][2] = 53;
        alpha[71][3] = 71;
        alpha[71][4] = 39;
        alpha[71][5] = 57;
        alpha[71][6] = 93;
        alpha[71][7] = 99;

        alpha[72][0] = 1;
        alpha[72][1] = 7;
        alpha[72][2] = 43;
        alpha[72][3] = 61;
        alpha[72][4] = 29;
        alpha[72][5] = 47;
        alpha[72][6] = 83;
        alpha[72][7] = 89;

        alpha[73][0] = 33;
        alpha[73][1] = 51;
        alpha[73][2] = 19;
        alpha[73][3] = 37;
        alpha[73][4] = 73;
        alpha[73][5] = 91;
        alpha[73][6] = 79;
        alpha[73][7] = 97;

        alpha[74][0] = 23;
        alpha[74][1] = 41;
        alpha[74][2] = 9;
        alpha[74][3] = 27;
        alpha[74][4] = 63;
        alpha[74][5] = 81;
        alpha[74][6] = 69;
        alpha[74][7] = 87;

        alpha[75][0] = 13;
        alpha[75][1] = 31;
        alpha[75][2] = 17;
        alpha[75][3] = 53;
        alpha[75][4] = 71;
        alpha[75][5] = 59;
        alpha[75][6] = 77;

        alpha[76][0] = 3;
        alpha[76][1] = 21;
        alpha[76][2] = 7;
        alpha[76][3] = 43;
        alpha[76][4] = 61;
        alpha[76][5] = 49;
        alpha[76][6] = 67;

        alpha[77][0] = 11;
        alpha[77][1] = 33;
        alpha[77][2] = 51;
        alpha[77][3] = 39;
        alpha[77][4] = 57;
        alpha[77][5] = 93;

        alpha[78][0] = 1;
        alpha[78][1] = 23;
        alpha[78][2] = 41;
        alpha[78][3] = 29;
        alpha[78][4] = 47;
        alpha[78][5] = 83;

        alpha[79][0] = 13;
        alpha[79][1] = 31;
        alpha[79][2] = 19;
        alpha[79][3] = 37;
        alpha[79][4] = 73;
        alpha[79][5] = 91;
        alpha[79][6] = 99;

        alpha[80][0] = 3;
        alpha[80][1] = 21;
        alpha[80][2] = 9;
        alpha[80][3] = 27;
        alpha[80][4] = 63;
        alpha[80][5] = 81;
        alpha[80][6] = 89;

        alpha[81][0] = 11;
        alpha[81][1] = 17;
        alpha[81][2] = 53;
        alpha[81][3] = 71;
        alpha[81][4] = 79;
        alpha[81][5] = 97;

        alpha[82][0] = 1;
        alpha[82][1] = 7;
        alpha[82][2] = 43;
        alpha[82][3] = 61;
        alpha[82][4] = 69;
        alpha[82][5] = 87;

        alpha[83][0] = 33;
        alpha[83][1] = 51;
        alpha[83][2] = 59;
        alpha[83][3] = 77;
        alpha[83][4] = 99;

        alpha[84][0] = 23;
        alpha[84][1] = 41;
        alpha[84][2] = 49;
        alpha[84][3] = 67;
        alpha[84][4] = 89;

        alpha[85][0] = 13;
        alpha[85][1] = 31;
        alpha[85][2] = 39;
        alpha[85][3] = 57;
        alpha[85][4] = 93;
        alpha[85][5] = 79;
        alpha[85][6] = 97;
        alpha[85][7] = 99;

        alpha[86][0] = 3;
        alpha[86][1] = 21;
        alpha[86][2] = 29;
        alpha[86][3] = 47;
        alpha[86][4] = 83;
        alpha[86][5] = 69;
        alpha[86][6] = 87;
        alpha[86][7] = 89;

        alpha[87][0] = 11;
        alpha[87][1] = 19;
        alpha[87][2] = 37;
        alpha[87][3] = 73;
        alpha[87][4] = 91;
        alpha[87][5] = 59;
        alpha[87][6] = 77;
        alpha[87][7] = 79;
        alpha[87][8] = 97;

        alpha[88][0] = 1;
        alpha[88][1] = 9;
        alpha[88][2] = 27;
        alpha[88][3] = 63;
        alpha[88][4] = 81;
        alpha[88][5] = 49;
        alpha[88][6] = 67;
        alpha[88][7] = 69;
        alpha[88][8] = 87;

        alpha[89][0] = 17;
        alpha[89][1] = 53;
        alpha[89][2] = 71;
        alpha[89][3] = 39;
        alpha[89][4] = 57;
        alpha[89][5] = 93;
        alpha[89][6] = 59;
        alpha[89][7] = 77;
        alpha[89][8] = 99;

        alpha[90][0] = 7;
        alpha[90][1] = 43;
        alpha[90][2] = 61;
        alpha[90][3] = 29;
        alpha[90][4] = 47;
        alpha[90][5] = 83;
        alpha[90][6] = 49;
        alpha[90][7] = 67;
        alpha[90][8] = 89;

        alpha[91][0] = 33;
        alpha[91][1] = 51;
        alpha[91][2] = 19;
        alpha[91][3] = 37;
        alpha[91][4] = 73;
        alpha[91][5] = 91;
        alpha[91][6] = 39;
        alpha[91][7] = 57;
        alpha[91][8] = 93;
        alpha[91][9] = 79;
        alpha[91][10] = 97;
        alpha[91][11] = 99;

        alpha[92][0] = 23;
        alpha[92][1] = 41;
        alpha[92][2] = 9;
        alpha[92][3] = 27;
        alpha[92][4] = 63;
        alpha[92][5] = 81;
        alpha[92][6] = 29;
        alpha[92][7] = 47;
        alpha[92][8] = 83;
        alpha[92][9] = 69;
        alpha[92][10] = 87;
        alpha[92][11] = 89;

        alpha[93][0] = 13;
        alpha[93][1] = 31;
        alpha[93][2] = 17;
        alpha[93][3] = 53;
        alpha[93][4] = 71;
        alpha[93][5] = 19;
        alpha[93][6] = 37;
        alpha[93][7] = 73;
        alpha[93][8] = 91;
        alpha[93][9] = 59;
        alpha[93][10] = 77;
        alpha[93][11] = 79;
        alpha[93][12] = 97;

        alpha[94][0] = 3;
        alpha[94][1] = 21;
        alpha[94][2] = 7;
        alpha[94][3] = 43;
        alpha[94][4] = 61;
        alpha[94][5] = 9;
        alpha[94][6] = 27;
        alpha[94][7] = 63;
        alpha[94][8] = 81;
        alpha[94][9] = 49;
        alpha[94][10] = 67;
        alpha[94][11] = 69;
        alpha[92][12] = 87;

        alpha[95][0] = 11;
        alpha[95][1] = 33;
        alpha[95][2] = 51;
        alpha[95][3] = 17;
        alpha[95][4] = 53;
        alpha[95][5] = 71;
        alpha[95][6] = 39;
        alpha[95][7] = 57;
        alpha[95][8] = 93;
        alpha[95][9] = 59;
        alpha[95][10] = 77;
        alpha[95][11] = 99;

        alpha[96][0] = 1;
        alpha[96][1] = 23;
        alpha[96][2] = 41;
        alpha[96][3] = 7;
        alpha[96][4] = 43;
        alpha[96][5] = 61;
        alpha[96][6] = 29;
        alpha[96][7] = 47;
        alpha[96][8] = 83;
        alpha[96][9] = 49;
        alpha[96][10] = 67;
        alpha[96][11] = 89;

        alpha[97][0] = 13;
        alpha[97][1] = 31;
        alpha[97][2] = 33;
        alpha[97][3] = 51;
        alpha[97][4] = 19;
        alpha[97][5] = 37;
        alpha[97][6] = 73;
        alpha[97][7] = 91;
        alpha[97][8] = 79;
        alpha[97][9] = 97;

        alpha[98][0] = 3;
        alpha[98][1] = 21;
        alpha[98][2] = 23;
        alpha[98][3] = 41;
        alpha[98][4] = 9;
        alpha[98][5] = 27;
        alpha[98][6] = 63;
        alpha[98][7] = 81;
        alpha[98][8] = 29;
        alpha[98][9] = 47;
        alpha[98][10] = 83;
        alpha[98][11] = 69;
        alpha[96][12] = 87;

        alpha[99][0] = 11;
        alpha[99][1] = 13;
        alpha[99][2] = 31;
        alpha[99][3] = 17;
        alpha[99][4] = 53;
        alpha[99][5] = 71;
        alpha[99][6] = 19;
        alpha[99][7] = 37;
        alpha[99][8] = 73;
        alpha[99][9] = 91;
        alpha[99][10] = 59;
        alpha[99][11] = 77;

        alpha[100][0] = 1;
        alpha[100][1] = 3;
        alpha[100][2] = 21;
        alpha[100][3] = 7;
        alpha[100][4] = 43;
        alpha[100][5] = 61;
        alpha[100][6] = 9;
        alpha[100][7] = 27;
        alpha[100][8] = 63;
        alpha[100][9] = 81;
        alpha[100][10] = 49;
        alpha[100][11] = 67;

        alpha[101][0] = 11;
        alpha[101][1] = 33;
        alpha[101][2] = 51;
        alpha[101][3] = 17;
        alpha[101][4] = 53;
        alpha[101][5] = 71;
        alpha[101][6] = 39;
        alpha[101][7] = 57;
        alpha[101][8] = 93;

        alpha[103][0] = 13;
        alpha[103][1] = 31;
        alpha[103][2] = 33;
        alpha[103][3] = 51;
        alpha[103][4] = 19;
        alpha[103][5] = 37;
        alpha[103][6] = 73;
        alpha[103][7] = 91;

        alpha[107][0] = 11;
        alpha[107][1] = 33;
        alpha[107][2] = 51;

        alpha[109][0] = 13;
        alpha[109][1] = 31;
        alpha[109][2] = 99;

        alpha[113][0] = 59;
        alpha[113][1] = 77;
        alpha[113][2] = 99;

        alpha[127][0] = 13;
        alpha[127][1] = 31;
        alpha[127][2] = 19;
        alpha[127][3] = 37;
        alpha[127][4] = 73;
        alpha[127][5] = 91;
        alpha[127][6] = 39;
        alpha[127][7] = 57;
        alpha[127][8] = 93;

        alpha[131][0] = 33;
        alpha[131][1] = 51;
        alpha[131][2] = 17;
        alpha[131][3] = 53;
        alpha[131][4] = 71;
        alpha[131][5] = 99;

        alpha[149][0] = 11;
        alpha[149][1] = 17;
        alpha[149][2] = 53;
        alpha[149][3] = 71;
        alpha[149][4] = 59;
        alpha[149][5] = 77;
        alpha[149][6] = 99;

        alpha[157][0] = 33;
        alpha[157][1] = 51;
        alpha[157][2] = 19;
        alpha[157][3] = 37;
        alpha[157][4] = 73;
        alpha[157][5] = 91;
        alpha[157][6] = 79;
        alpha[157][7] = 97;
    }

    public long[] init() {

//        First matrix
        a[0][0] = x;
        a[0][1] = y;
        a[0][2] = 0;

        a[1][0] = x;
        a[1][1] = 0;
        a[1][2] = y;

        a[2][0] = 0;
        a[2][1] = x;
        a[2][2] = p;

//        Second matrix
        b[0][0] = 0;
        b[0][1] = x;
        b[0][2] = y;

        b[1][0] = x;
        b[1][1] = 0;
        b[1][2] = y;

        b[2][0] = y;
        b[2][1] = n;
        b[2][2] = 0;

//        Intermediate matrix
        d[0][0] = -y;
        d[1][0] = -x;
        d[2][0] = 0;

//        Matrix C
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                c[i][j] = 0;
                for (k = 0; k < 3; k++) {
                    c[i][j] = c[i][j] + (a[i][k] * b[k][j]);
                }
            }
        }

//        Matrix E
        for (i = 0; i < 3; i++) {
            e[i][0] = 0;
            for (k = 0; k < 3; k++) {
                e[i][0] = e[i][0] + (c[i][k] * d[k][0]);
            }
            e[i][0] = Math.abs(e[i][0]);
        }

        val = e[2][0];
        num = val;

        for (ab = 0; ab < level; ab++) {
            Val = Integer.toString(val);

            while (num != 0) {
                sum = sum + num % 10;
                num = num / 10;
            }

            basesum = sum;

            for (j = 0; j < 20; j++) {
                if (alpha[basesum][j] % 2 != 0) {
                    count1++;
                    String Preliminary = Integer.toString(alpha[basesum][j]);
                    resultdata = Val.concat(Preliminary);
                    r[basesum][j] = Integer.parseInt(resultdata);
                }
            }
            pp = new long[count1];

            for (i = 0; i < 40; i++) {
                for (j = 0; j < 20; j++) {
                    if (r[i][j] != 0) {
                        pp[nn] = r[i][j];
                        nn++;
                    }
                }
            }
            for (int m = 0; m < count1; m++) {
                if (pp[m] < 2) {
                    System.out.println("Invalid details");
                }
                if (pp[m] == 2) {
                    System.out.println("Prime");
                }

                count = 0;
                for (i = 3; i < (Math.sqrt(pp[m]) + 1); i++) {
                    if (pp[m] % i == 0) {
                        count++;
                    }
                    i++;
                }

                if (count == 0) {
                    pq[incre] = pp[m];
                    incre++;
                }
            }

//        Level 1
            if (b1 == 0 && b2 == 0) {
                while (pq[tempo] != 0) {
                    pp_copy[tempo] = pq[tempo];
                    System.out.println(pq[tempo]);
                    tempo++;
                }
            }

//        Level 2
            if (b1 == 0 && b2 == 1) {
                val = (int) pq[0];
            }

//        XOR
            if ((b1 ^ b2) == 1) {
                while (pq[tempo] != 0) {
                    System.out.println(pq[tempo]);
                    tempo++;
                }
            }
        }
        return pp_copy;
    }
}
