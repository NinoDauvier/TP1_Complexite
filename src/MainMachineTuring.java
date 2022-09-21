public class MainMachineTuring {
    public static void main(String[] args) throws InterruptedException {
        int state = 2;
        int alphabet =2;
        int[] myTape = new int[20];
        Transition[][] myTransition = new Transition[state][alphabet];
        myTransition[0][0] = new Transition(1, 1, 1);
        myTransition[0][1] = new Transition(1, 0, 1);
        myTransition[1][0] = new Transition(1, -1, 0);
        myTransition[1][1] = new Transition(true);

        TuringMachine myMachine = new TuringMachine(2, 2,0, myTransition, myTape);
        myMachine.calculAndPrint();
        myMachine.printTape();
    }
}
