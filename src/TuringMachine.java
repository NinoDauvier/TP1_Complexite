import java.util.Arrays;

public class TuringMachine {
    int nbStates;
    int nbAlphabet;
    int currentState;
    Transition[][] transition;

    int[] tape;
    int pointer = 0;
    boolean finished = false;

    public TuringMachine(int nbStates, int nbAlphabets, int initialState, Transition[][] transition, int[] initialTape){
        this.nbStates = nbStates;
        this.nbAlphabet = nbAlphabets;
        this.transition = transition;
        this.currentState = initialState;
        this.tape = initialTape;
    }

    public void calcul(){
        while (!finished){
            step();
        }
    }

    public void calculAndPrint() throws InterruptedException {
        while (!finished){
            System.out.println(new String(new char[pointer * 3 + 1]).replace('\0', ' ') + "I");
            System.out.println(Arrays.toString(tape));
            step();
            Thread.sleep(1000);
        }
    }


    public void step(){
        Transition currentTransition = transition[currentState][tape[pointer]];
        if (currentTransition.isFinal == true){
            finished = true;
            return;
        }
        tape[pointer] = currentTransition.getWord();
        pointer += currentTransition.getMove();
        currentState = currentTransition.getNextState();

        if (pointer < 0){
            System.out.println("erreur 1: la machine tente d'aller à gauche de la case 0");
            finished = true;
        }
        if (pointer >= tape.length){
            System.out.println("erreur 2: la machine tente d'aller à droite de la fin du ruban 0");
            finished = true;
        }

        return;
    }

    public void printTape(){
        System.out.println(Arrays.toString(tape));
    }
}