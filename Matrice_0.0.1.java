package Fibonacci_Matrice;
import  java.util.Scanner;
public class Matrice {
    private static int mod = (int)1e9+7;//mod

    public static void main(String[] args) {
        System.out.println("Entrer un nombre: ");
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();
            long t1 = System.currentTimeMillis();
            int test = fibbonaci(n);
            long t2 = System.currentTimeMillis();
            System.out.println(test);
            System.out.println("time: "+(t2-t1));
        }
    }

    public static int fibbonaci(int n){
        if(n<=1) return n;
        long[][] matriceBase = new long[][]{
                {1,1},
                {1,0}
        } ;
        long[][] matriceRes = new long[][]{
                {1},
                {0}
        };
       int x = n-1;
       while(x!=0){
           if((x&1) != 0){//x ->impair
               matriceRes = matriceMultiply(matriceBase,matriceRes);
           }//x ->pair
           matriceBase = matriceMultiply(matriceBase,matriceBase);
           x>>=1;
       }
       return (int)(matriceRes[0][0]%mod);
    }


    public static long[][]matriceMultiply(long[][]m, long[][]n){ //multiplication des deux matrices
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
}
