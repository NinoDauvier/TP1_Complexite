import java.io.*;

public class MainMachineTuring {
    public static void main(String[] args) throws InterruptedException, IOException {

        TuringMachine myMachine = new TuringMachine("src\\Turing_prog");
        myMachine.calculAndPrint();
    }
}
