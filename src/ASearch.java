import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ASearch {

    public static Node aStarSearch(Puzzle8 inicialState){
        //Initialize the fringe with teh inicial state
        Fringe fringe=new Fringe(new Node(inicialState,null,0));
        //Set-safe unic value once
        //hashSet-efficiency table to garantee that arent duplications.
        Set<IState> closedSet = new HashSet<>();
        while(true) {
            if (fringe.isEmpty()) {
                return null;
            } else {
                //remove the next node and meets the state of him
                Node currentNode = fringe.getFringeNode();
                IState currentState = currentNode.getState();
                if (currentState.goal()) {
                    return currentNode;
                }

                // Else-Close state to guarantee that isn t used again
                closedSet.add(currentState);
                //Create ArrayList with next possible Actions
                ArrayList<Action> sucessors = currentState.suc();
                for (Action action : sucessors) {
                    //Create a new Node
                    Node newNode = new Node(action.getState(), currentNode, action.cost);
                    //if action of the newNode isn t in the closedState add it to the fringeNode
                    if (!closedSet.contains(newNode.getState())) {
                        fringe.addFringeNode(newNode);
                    }
                }

            }


            return null;// doesnt find the next action/state that takes it to the next state
        }
    }


}
     