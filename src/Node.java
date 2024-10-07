public class Node {
    private IState state;
    private Node parent;
    private double g; // Cost from start to the current node
    private double f; // evaluation function

    public Node(IState state, Node parent, double cost) {
        this.state = state;
        this.parent = parent;
        if (parent == null){
            g = cost;
            f = state.h();
        } else {
            g = parent.g + cost;
            f = state.h() + g;
        }
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public double getF(){
        return f;
    }
}
