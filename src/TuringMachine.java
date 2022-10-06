import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.List;


public class TuringMachine {
    int nbStates;
    int currentState;
    int nbAlphabet;
    List<String> alphabet;
    Transition[][] transition;

    int[] tape;
    int pointer = 0;
    boolean finished = false;

    public TuringMachine(String path) throws IOException {

        //reader qui récupère le programme dans path
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        //récupère le nombre d'états, l'état initial et le final
        String line = br.readLine();
        String[] words = line.split(" ");
        this.nbStates = Integer.parseInt(words[0]);
        this.currentState = Integer.parseInt(words[1]);
        int finalState = Integer.parseInt(words[2]);

        //on récupère la taille de l'alphabet et l'ensemble des caractères par défault le symbol blanc est le premier définit
        this.nbAlphabet = Integer.parseInt(br.readLine());
        this.alphabet = new ArrayList<>();
        line = br.readLine();
        words = line.split(" ");
        alphabet.addAll(Arrays.asList(words));

        //récupère la taille du ruban utilisé et son état initial, si il n'est pas entièrement décrit, il est remplit de blanc
        this.tape = new int[Integer.parseInt(br.readLine())];
        line = br.readLine();
        words = line.split(" ");
        for (int i = 0; i < tape.length; i++) {
            if (i<=words.length){
                tape[i] = Integer.parseInt(words[i]);
            }
            else {
                tape[i] = 0;
            }
        }

        //création de la table des transitions
        this.transition = new Transition[nbStates][nbAlphabet];
        line = br.readLine();
        while(line != null){
            words = line.split(" ");
            transition[Integer.parseInt(words[0])][alphabet.indexOf(words[1])] = new Transition(alphabet.indexOf(words[2]), Integer.parseInt(words[3]), Integer.parseInt(words[4]), finalState);
            line = br.readLine();
        }
    }

    public void calcul(){
        //effectue le calcul avec le programme chargé precedemment et affiche l'état final du ruban
        while (!finished){
            step();
        }
        this.printTape();
    }

    public void calculAndPrint() throws InterruptedException {
        //effectue le calcul avec le programme chargé precedemment et affiche le ruban a chaque étape avec le curseur visible
        while (!finished){
            System.out.println(new String(new char[pointer * 3 + 1]).replace('\0', ' ') + "I");
            this.printTape();
            step();
            Thread.sleep(100);
        }
    }


    public void step(){
        Transition currentTransition = transition[currentState][tape[pointer]];
        if (currentTransition == null){
            finished = true;
            System.out.print("Le calcul est arrivé à une transition non définit");
            return;
        }
        if (currentTransition.isFinal){
            finished = true;
            return;
        }
        tape[pointer] = currentTransition.getSymbol();
        pointer += currentTransition.getMove();
        currentState = currentTransition.getNextState();

        if (pointer < 0){
            System.out.println("erreur 1: la machine tente d'aller à gauche de la case 0");
            finished = true;
        }
        if (pointer >= tape.length){
            System.out.println("erreur 2: la machine tente d'aller à droite de l'extremité droite du ruban 0");
            finished = true;
        }
    }

    public void printTape(){
        System.out.print("[");
        for (int i = 0; i<tape.length-1; i++) {
            System.out.print(alphabet.get(tape[i]));
            System.out.print(", ");
        }
        System.out.print(alphabet.get(tape[tape.length-1]));
        System.out.print("]");
        System.out.println();
    }
}