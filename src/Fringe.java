import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that represents current set of fringe nodes
 * @author vss
 */

public class Fringe {
    private Stack<Node> fringeNodes;

    /**
     * Constructor
     */
    public Fringe(Node firstNode){
        fringeNodes = new Stack<>();
        fringeNodes.add(firstNode);
    }

    public Node checkFringeNode(){
        return fringeNodes.peek();
    }

    /**
     * removes and returns head of fringe list
     * @return
     */
    public Node getFringeNode(){
        return fringeNodes.pop();
    }

    /**
     * adds node to fringe list
     * @param newNode
     */
    public void addFringeNode(Node newNode){
        fringeNodes.push(newNode);
    }

    public boolean isEmpty(){
        return fringeNodes.isEmpty();
    }

    public boolean containsNode(Node node) {
        for (Node n : fringeNodes) {
            if (n.getState().equals(node.getState())) {
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return fringeNodes.size();
    }

    @Override
    public String toString() {
        String s = "";
        for (Node node : fringeNodes) {
            s += node.getState().toString() + "\n";
        }
        return s;
    }
}

