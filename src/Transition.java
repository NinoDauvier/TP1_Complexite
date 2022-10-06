public class Transition {
    //la lettre, le mouvement et l'état d'arrivée définissant la transition
    int symbol;
    int move;
    int nextState;

    boolean isFinal;

    public Transition(int symbol, int move, int nextState, int finalState){
        this.symbol = symbol;
        this.move = move;
        this.nextState = nextState;

        //retient si la transition amène a un état final
        this.isFinal = nextState == finalState;
    }

    //getters classique
    public int getSymbol(){
        return symbol;
    }
    public int getMove(){
        return move;
    }
    public int getNextState(){
        return nextState;
    }
}
