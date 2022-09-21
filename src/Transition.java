public class Transition {
    int word;
    int move;
    int nextState;

    boolean isFinal;

    public Transition(int word, int move, int nextState){
        this.word = word;
        this.move = move;
        this.nextState = nextState;

        this.isFinal = false;
    }

    public Transition(boolean isFinal){
        this.isFinal = true;
    }

    public int getWord(){
        return word;
    }
    public int getMove(){
        return move;
    }
    public int getNextState(){
        return nextState;
    }
}
