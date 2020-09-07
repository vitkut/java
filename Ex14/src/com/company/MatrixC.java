package com.company;

public class MatrixC {

    public static int[][] matrixC;
    public static boolean[][] workInProgressBool;

    public synchronized int getCij(int i, int j) throws Exception{
        if(!workInProgressBool[i][j]){
            workInProgressBool[i][j] = true;
            return matrixC[i][j];
        } else {
            throw new Exception("Exception message");
        }
    }

    public void setCij(int cij, int i, int j){
        matrixC[i][j] = cij;
    }

    public static void setMatrixSize(int m, int k){
        matrixC = new int[m][k];
        workInProgressBool = new boolean[m][k];
    }
}
