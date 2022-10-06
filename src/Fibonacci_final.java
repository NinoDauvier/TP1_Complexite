import java.lang.*;
public class Fibonacci_final {
    private int[] test_values_r ;      //contient les termes à calculer
    private int[] test_values_i ;
    private long[] test_values_m ;

    private long[] execution_times ; //contient les temps de calcul respectifs pour chaque terme
    private int nb_calculs ;         //Nombre de termes à calculer


    private int type ;



//Utilisé pour l'exponentiation de matrices
    private static int mod = (int)1e9+7;//mod

//Modifier les tableaux ici pour tester différentes valeurs (en dur)
    Fibonacci_final() {
        nb_calculs = 10 ;

    //1 pour itérative, 2 pour récursive, 3 pour matricielle
        this.type = 1 ;

        this.test_values_r = new int[]{10,20,36,37,38,39,40,41,42,43} ;
        this.test_values_i = new int[]{10,100,1_000,10_000,100_000,1_000_000,10_000_000,100_000_000,1_000_000_000,2_000_000_000} ;
        this.test_values_m = new long[]
                {10,100,1_000,10_000,100_000,
                10_000_00,100_000_000, 10_000_000_000_000L,
                1_000_000_000_000_000L, 100_000_000_000_000_000L};
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
    private static long[][]matriceMultiply(long[][]m, long[][]n){ //multiplication des deux matrices
        int rows = m.length; //ligne de la première matrice
        int cols = n[0].length; //colonne de la deuxième matrice
        long nouveau[][] = new long[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(nouveau[i][j]==0) continue;
                for(int k=0;k<n.length;k++){
                    nouveau[i][j]+=(m[i][k]*n[k][j])%mod;
                    //nouveau[i][j]%=mod;//résult pour chaque position de la nouvelle matrice
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
            if((n&1)==1){                                   //impair
                matrixBase = matriceMultiply(matrixBase,a);
            }
            n=n>>1;                                         //bitwise operation peut reduire le temps de calcul
            a = matriceMultiply(a,a);
        }
        return matrixBase;
    }


    public void solve(){
        //On calcule le n-ieme terme de la suite pour chaque valeur dans test_values
        long debut, fin ;
        for(int i = 0 ; i < this.nb_calculs ; i++) {
            debut = System.currentTimeMillis() ;

            if(this.type == 1)fibonacci_i(this.test_values_i[i]) ;
            if(this.type == 2)fibonacci_r(this.test_values_r[i]) ;
            if(this.type == 3)fibonacci_m(this.test_values_m[i]) ;
            /*-------------------------------------------------------------------------------------------------*/

            fin = System.currentTimeMillis() ;
            this.execution_times[i] = fin-debut ;
        }
    }



    public String toString(){
        String s = "Calcul des n-ièmes termes de Fibonacci :\n" ;
        for(int i = 0 ; i < nb_calculs ; i++){
            if(this.type == 1) s += "n = " + this.test_values_i[i] + " --> " + this.execution_times[i] + " milisecondes\n";
            if(this.type == 2) s += "n = " + this.test_values_r[i] + " --> " + this.execution_times[i] + " milisecondes\n";
            if(this.type == 3) s += "n = " + this.test_values_m[i] + " --> " + this.execution_times[i] + " milisecondes\n";
        }

        return s;
    }

    public static void main( String[] args){

        Fibonacci_final fib = new Fibonacci_final() ;

        fib.solve() ;
        System.out.println(fib.toString()) ;
    }
}
