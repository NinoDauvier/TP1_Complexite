package Fibonacci_Matrice;
import java.util.Scanner;

public class Main {
    static int mod = 1000000007;
    private static long[][]matriceMultiply(long[][]m, long[][]n){ //multiplication des deux matrices
        int rows = m.length; //ligne de la première matrice
        int cols = n[0].length; //colonne de la deuxième matrice
        long nouveau[][] = new long[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                for(int k=0;k<n.length;k++){
                    nouveau[i][j]+=m[i][k]*n[k][j];
                    nouveau[i][j]%=mod;//résult pour chaque position de la nouvelle matrice
                }
            }
        }
        return nouveau;
    }

    //Calcul du terme
    private static long fibonacci_m(long n){
        if(n<2) return n;
        long[][] matrixBase = {{1,1},{1,0}};
        long[][] matrixRes = pow(matrixBase,n-1);
        return matrixRes[0][0];
    }
    //exponentiating by squaring, O(logn)
    public static long[][] pow(long[][]a, long n){
        long[][] matrixBase = {{1,0},{0,1}};
        while(n>0){
            if((n&1)==1){
                matrixBase = matriceMultiply(matrixBase,a);
            }
            n>>=1;
            a = matriceMultiply(a,a);
        }
        return matrixBase;
    }
    public static void main(String[] args) {
        while(true){
            System.out.println("Entrer un nombre: ");
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            long res = fibonacci_m(n);
            System.out.println(res);
        }
    }
}
