import java.lang.*;
public class Fibonacci_final {
    private int[] test_values ;      //contient les termes à calculer
    private long[] execution_times ; //contient les temps de calcul respectifs pour chaque terme
    private int nb_calculs ;         //Nombre de termes à calculer

//Utilisé pour l'exponentiation de matrices
    private static int mod = (int)1e9+7;//mod

//Modifier les tableaux ici pour tester différentes valeurs (en dur)
    Fibonacci_final() {
        nb_calculs = 10 ;
        this.test_values = new int[]{10,20,36,37,38,39,40,41,42,43} ;
        this.execution_times = new long[nb_calculs] ;
    }

//Calcul du n-ième terme de la suite de Fibonacci par méthode récursive
    private static int fibonacci_r(int n){
        if (n == 0){
            return 0 ;
        }
        else if(n == 1){
            return 1 ;
        }else{
            return fibonacci_r(n-1) + fibonacci_r(n-2) ;
        }
    }

//Calcul du n-ième terme de la suite de Fibonacci par méthode itérative
    private static int fibonacci_i(int n) {
        if(n ==0)
        {
            return 0;
        }
        if(n==1 || n==0)
        {
            return 1;
        }
        int fib = 1;
        int prevFib = 1;

        for(int i=2; i<n; i++) {
            int temp = fib;
            fib+= prevFib;
            prevFib = temp;
        }
        return fib;
    }
//Calcul du n-ième terme de la suite de Fibonacci par exponentiation de matrices

//Multiplication de matrices
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

//Calcul du terme
    public static int fibonacci_m(int n){
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



    public String toString(){
        String s = "Calcul des n-ièmes termes de Fibonacci :\n" ;
        for(int i = 0 ; i < nb_calculs ; i++){
            s += "n = " + this.test_values[i] + " --> " + this.execution_times[i] + " milisecondes\n";
        }

        return s;
    }

    public static void main( String[] args){
        long debut, fin ;
        Fibonacci_final fib = new Fibonacci_final() ;

//On calcule le n-ieme terme de la suite pour chaque valeur dans test_values
        for(int i = 0 ; i < fib.nb_calculs ; i++) {
            debut = System.currentTimeMillis() ;

/*Changer cette ligne pour modifier la méthode de calcul :
fibonacci_i pour itérative, fibonacci_m pour l'exponentiation de matrices, fibonacci_r pour récursive*/
            fibonacci_r(fib.test_values[i]) ;
/*-------------------------------------------------------------------------------------------------*/

            fin = System.currentTimeMillis() ;
            fib.execution_times[i] = fin-debut ;
        }
        System.out.println(fib.toString()) ;
    }
}
