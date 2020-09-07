package com.company;

public class CountMatrixElements extends Thread {

    public int m;
    public int n;
    public int k;


    public CountMatrixElements(){

    }

    public CountMatrixElements(int m, int n, int k){
        this.m = m;
        this.n = n;
        this.k = k;
    }

    @Override
    public void run(){
        MatrixC matrixC = new MatrixC();
        for(int i = 0; i < m; i++){

            for(int j = 0; j < k; j++){
                try {
                    matrixC.getCij(i, j);
                    int cij = countElement(i, j);
                    //System.out.println("i: "+i+" j: "+j+" Cij: "+cij+" Thread: "+getName());
                    matrixC.setCij(cij, i, j);
                    try{
                        Thread.sleep(m);
                    } catch (InterruptedException ex){
                    }
                } catch (Exception ex){
                }
            }
        }
        StateOfThreads state = new StateOfThreads();
        state.decrement();
        System.out.println(getName()+" is done!");
    }

    private int countElement(int i, int j){
        int answer = 0;
        for(int i1 = 0; i1 < n; i1++){
            answer += Main.matrixA[i][i1]*Main.matrixB[i1][j];
        }
        return answer;
    }

}
