class FibonacciIterative {
    public static int fibonacciIterative(int n) {
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
    public static void main(String args[]) {
        int maxNumber = 10;
        System.out.print("Fibonacci Series of "+maxNumber+" numbers: ");
        for(int i = 0; i < maxNumber; i++){
                System.out.print(fibonacciIterative(i) +" ");
            }
        }
    

}
