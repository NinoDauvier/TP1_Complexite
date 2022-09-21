import java.util.*;
import java.lang.*;
public class Fibonacci_recursive {
    private int[] test_values ;
    private long[] execution_times ;
    private int nb_calculs ;

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

    //Modifier les tableaux ici pour tester différentes valeurs
    Fibonacci_recursive() {
        nb_calculs = 6 ;
        this.test_values = new int[]{10, 20, 30, 40, 41, 42} ;
        this.execution_times = new long[nb_calculs] ;
    }

    public String toString(){
        String s = "Calcul des n-ièmes termes de Fibonacci, méthode récursive :\n" ;
        for(int i = 0 ; i < nb_calculs ; i++){
            s += "Pour n = " + this.test_values[i] + " --> temps : " + this.execution_times[i] + "nanosecondes\n";
        }

        return s;
    }

    public static void main( String[] args){
        long debut, fin ;
        Fibonacci_recursive fib = new Fibonacci_recursive() ;

    //On calcule le n-ieme terme de la suite pour chaque valeur dans test_values
    //Les temps respectifs seront rangés dans execution_times
        for(int i = 0 ; i < fib.nb_calculs ; i++) {
            debut = System.nanoTime() ;
            fibonacci_r(fib.test_values[i]) ;
            fin = System.nanoTime() ;
            fib.execution_times[i] = fin-debut ;
        }
        System.out.println(fib.toString()) ;

    }
}
