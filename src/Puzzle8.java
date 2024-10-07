import java.util.ArrayList;

public class Puzzle8 implements IState {
    int[][] state;
    int zeroRow, zeroCol; // Position of the empty tile (0)

    public Puzzle8(int[][] state) {
        this.state = state;
        getEmptyTile();
    }

    // function to find empty tile
    public void getEmptyTile(){
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] == 0) {
                    zeroRow = i;
                    zeroCol = j;
                    return;
                }
            }
        }
    }
    //Function moves 1 line Up empty tile. Update zeroRow->zeroRow-- and update in matrix empty tile position->swap(zeroRow,zeroCol,zeroRow-1,zeroCol);
    public  void moveUp(){
        if(zeroRow>0){
            swap(zeroRow,zeroCol,zeroRow-1,zeroCol);
            zeroRow--;
        }
    }

    //Function moves 1 line down empty tile. Verify if has more row after zerorow and then swap it
    public void moveDown(){
        if (zeroRow< state.length-1){
            swap(zeroRow,zeroCol,zeroRow+1,zeroCol);
            zeroRow++;
        }
    }
    //Function moves 1 colum left if it is not the first one.
    public void moveLeft(){
        if(zeroCol>0){
            swap(zeroRow,zeroCol,zeroRow,zeroCol-1);
            zeroCol--;
        }
    }

    //Function moves 1 colum right empty tile. Verify if has more colum after zerorow and then swap it
    public void moveRight(){
        if (zeroCol< state[0].length-1){
            swap(zeroRow,zeroCol,zeroRow,zeroCol+1);
            zeroCol++;
        }
    }
    //swap location of empty tile
    public void swap( int row1,int colum1,int row2,int colum2){
        int temp=state[row1][colum1];
        state[row1][colum1]=state[row2][colum2];
        state[row2][colum2]=state[row1][colum1];
    }



//Implemented methods of Istate

    @Override
    //h represents number of tiles that are out of place
    public double h() {
        int[][] goalState = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

        int misplacedTiles = 0;
        //comparasion between goal state and actual state to count down tiles of place
        for (int line = 0; line < state.length; line++) {
            for (int colum = 0; colum < state[line].length; colum++) {
                if (state[line][colum] != goalState[line][colum]) {
                    misplacedTiles++;
                }
            }
        }
        return misplacedTiles;
    }

    @Override
    //Verify if any actual state is on the final position
    public boolean goal() {
        int[][] goalState = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (state[i][j] != goalState[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }




    // this method looks to  sucessors states from the actual state. Returns actions that save sucessors states
    @Override
    public ArrayList<Action> suc() {
        ArrayList<Action> actions = new ArrayList<>();


        if (zeroRow > 0) {
            Puzzle8 newState = new Puzzle8(cloneState());
            newState.moveUp();
            actions.add(new Action(newState, 1));
        }

        if (zeroRow < state.length - 1) {
            Puzzle8 newState = new Puzzle8(cloneState());
            newState.moveDown();
            actions.add(new Action(newState, -1));
        }


        if (zeroCol > 0) {
            Puzzle8 newState = new Puzzle8(cloneState());
            newState.moveLeft();
            actions.add(new Action(newState, 1));
        }


        if (zeroCol < state[0].length - 1) {
            Puzzle8 newState = new Puzzle8(cloneState());
            newState.moveRight();
            actions.add(new Action(newState, -1));
        }

        return actions;
    }

    //Clones all states of matrix to facilitate the search of next state
    private int[][] cloneState() {
        int[][] newState = new int[state.length][state[0].length];
        for (int i = 0; i < state.length; i++) {
            System.arraycopy(state[i], 0, newState[i], 0, state[i].length);
        }
        return newState;
    }



    public String toString(){
        String result="";
        for (int row = 0; row < state.length; row++) {
            for (int colum = 0; colum < state[row].length; colum++) {
                result+=state[row][colum]+ " ";

            }
            result+="\n";
        }
        return result;


    }

}

