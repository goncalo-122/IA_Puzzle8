public class Action {
    Puzzle8 state;
    int cost;

    public Action(Puzzle8 state, int cost) {
        this.state = state;
        this.cost = cost;
    }

    public Puzzle8 getState() {
        return state;
    }

    public void setState(Puzzle8 state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Action: [ state: " + state + "] [cost: " + cost + " ]";
    }


}
