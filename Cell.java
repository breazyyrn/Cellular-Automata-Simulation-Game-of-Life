import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
public class Cell {
    // Field for variable alive
    public boolean alive;
    // Constructor method for Cell class
    public Cell() {
    }
    /**
     * constructor method that specifies the Cell's state. 
     * A True argument means the Cell is alive, a False argument means the Cell is dead.
     */
    public Cell(boolean alive) {
        this.alive = alive;
        if (alive == true) {
            System.out.println("Cell is alive");
        } else {
            System.out.println("Cell is dead");
        }
    }
    // Returns the state of the Cell whether it's alive or dead
    public boolean getAlive() {
        return alive;
    }
    //Resets the Cell state to what it was in the begining
    public void reset() {
        alive = false;
    }
    // Sets the Cell's state to being alive
    public void setAlive(boolean alive) {
        /**
         * If boolean alive is set to true or false it sets the Cell's state 
         * corresponding to the boolean passed through the method.
         */
        if (alive == true) {
            alive = true;
        }

        if (alive == false) {
            alive = false;
        }
    }
    // String method for stating whether Cell is dead or alive
    public String toString() {
        String state = "Cell is: ";
        state = state + alive;
        return state;
    } 

    // This method draws the cell as rectangles
    public void draw(Graphics g, int x, int y, int scale) {
        g.drawRect(x, y, 4, 4); //Might have to change type to Graphics instead of Cell
        g.fillRect(x, y, 4, 4);

        if (alive == true) {
            g.setColor(java.awt.Color.green);
        }

        if (alive == false) {
            g.setColor(java.awt.Color.red);
        }

    }

    public void updateState( ArrayList<Cell> neighbors) {
        //Loop through the neighbors arraylist size then check how many items are alive or not
        int aliveNeighbors;
        aliveNeighbors = 0;
        for(int i=0; i<neighbors.size();i++) {
                // If statement  as a conditional statement in order to state games rules
                if (neighbors.get(i).alive) {
                    aliveNeighbors += 1;
                }
                // If the cell is alive and it has 2  or more neighbors it remains alive
                
        }

        if (alive == true && aliveNeighbors >= 2) { //This is mathematically wrong because of the if statment above
            alive = true;
            System.out.println("Cell has: " + neighbors.size() + " neighbors");
        }

        // If the cell is alive and it has 3 or more neighbors it remains alive
        else if (alive == true && aliveNeighbors >= 3) {
            alive = true;
            System.out.println("Cell has: " + neighbors.size() + " neighbors");
        }

        // If the Cell is dead but it has exaclty 3 neighbors it shall become alive
        else if (alive == false && aliveNeighbors == 3) {
            alive = true;
            System.out.println("Cell has: " + neighbors.size() + " neighbors");
        } else{
            alive = false;
        }

        // if (aliveNeighbor.size() == 2 || 3)
    } 

    // Main method for Cell class
    public static void main(String[] args) {
        Cell newCell = new Cell(true);
        System.out.println(newCell);

        newCell.reset();
        newCell.getAlive();
        System.out.println(newCell.toString());
    }


}
