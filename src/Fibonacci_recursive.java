import java.util.*;
import java.lang.*;
public class Fibonacci_recursive {


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

    public static void main( String[] args){

        int test ;
        Scanner input = new Scanner(System.in);
        int n = input.nextInt() ;

        test = fibonacci_r(n) ;
        System.out.println("test fibonacci(" + n + ") = " + test) ;

    }
}
