package com.company;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static int[][] matrixA;
    public static int[][] matrixB;

    public static int m;
    public static int n;
    public static int k;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter m = ");
        m = scanner.nextInt();
        System.out.print("Enter n = ");
        n = scanner.nextInt();
        System.out.print("Enter k = ");
        k = scanner.nextInt();

        matrixA = new int[m][n];
        matrixB = new int[n][k];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print("A["+i+"]["+j+"] = ");
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println();
        scanner.nextLine();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                System.out.print("B["+i+"]["+j+"] = ");
                matrixB[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\n-----\nStart:\n\n");

        Date date1 = new Date();

        MatrixC.setMatrixSize(m, k);

        StateOfThreads state = new StateOfThreads();

        for(int i = 0; i < m; i++){
            CountMatrixElements newThread = new CountMatrixElements(m, n, k);
            state.increment();
            newThread.start();
        }

        while (state.getCountOfWorkingThreads() > 0){
            try{
                Thread.sleep(2);
            } catch (InterruptedException ex){}
        }

        FileWriterService fileWriterService = new FileWriterService();
        fileWriterService.start();

        System.out.println("Matrix A:");
        outMatrix(matrixA, m, n);
        System.out.println();
        System.out.println("Matrix B:");
        outMatrix(matrixB, n, k);
        System.out.println();
        System.out.println("Answer matrix C:");
        outMatrix(MatrixC.matrixC, m, k);

        try{
            fileWriterService.join();
        } catch (InterruptedException ex){}

        Date date2 = new Date();
        System.out.println("Time: "+(date2.getTime()-date1.getTime()));

    }

    public static void outMatrix(int[][] matrix, int m, int k){
        System.out.println("---------------");
        for(int i = 0; i < m; i++){
            for (int j = 0; j < k; j++){
                if(j == k-1){
                    System.out.println(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j]+", ");
                }
            }
        }
        System.out.println("---------------");

    }
}
