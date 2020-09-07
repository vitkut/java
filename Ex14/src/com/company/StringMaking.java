package com.company;

public class StringMaking {

    public static StringBuilder make(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stringOfMatrix(Main.matrixA, Main.m, Main.n));
        stringBuilder.append("\n*\n\n");
        stringBuilder.append(stringOfMatrix(Main.matrixB, Main.n, Main.k));
        stringBuilder.append("\n=\n\n");
        stringBuilder.append(stringOfMatrix(MatrixC.matrixC, Main.m, Main.k));
        return stringBuilder;
    }

    public static StringBuilder stringOfMatrix(int[][] matrix, int m, int n){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(j == n-1){
                    stringBuilder.append(matrix[i][j]);
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append(matrix[i][j]);
                    stringBuilder.append(", ");
                }
            }
        }
        return stringBuilder;
    }
}
