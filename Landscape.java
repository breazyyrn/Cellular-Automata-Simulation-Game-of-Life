import java.util.Random;
import java.util.ArrayList;
import java.awt.Graphics;
public class Landscape {
    Cell [][] LandscapeGrid;
    int rows = 4;
    int cols = 4;

    public Landscape(int rows, int cols) {
        //Initiates rows, cols
        this.rows = rows;
        this.cols = cols;

        LandscapeGrid = new Cell[rows][cols];

        //Creates a random object so we can get random boolean for our cells

        Random randomBoolean = new Random();

        // Lets add in Cells to each row and column using random boolean method

        //Lets fill in the 2D Grid LandscapeGrid

        for (int i=0; i<LandscapeGrid.length; i++) {
            for (int j=0; j<LandscapeGrid[i].length; j++) {
                /**
                 * For every LandscapeGrid position [i][j] generate
                 * a new Cell which holds a random boolean value
                 */
                LandscapeGrid[i][j] = new Cell(randomBoolean.nextBoolean());
                System.out.print(LandscapeGrid[i][j]);
                // LandscapeGrid[i][j] = new Cell(randomBoolean.nextBoolean());
            }
            System.out.println();
        }

    }

    //This method loops over each and every element in the 2D Grid and sets the elements to null
    public void reset() {
        for (int i=0; i<LandscapeGrid.length; i++) {
            for (int j=0; j<LandscapeGrid[i].length; j++) {
                /**
                 * For every LandscapeGrid position [i][j] set element position
                 * value to none so therefore it removes every cell that was generated
                 * at that position before
                 */
                LandscapeGrid[i][j] = null; //It might be [rows][cols] instad of [i][j]
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell getCell(int row, int col) {
        /**
         * I could also create a variable called Cell retrieved = LandscapeGrid[row][col]
         * Then I could return retrieved variable
         * use this method if the following one doesn't work
         */
        return LandscapeGrid[row][col];
    }

    public String toString() {
        String lanscapeString = "";

        for (int i=0; i<LandscapeGrid.length;i++) {
            for(int j=0; j<LandscapeGrid[i].length;j++) {
                lanscapeString += LandscapeGrid[i][j] + " ";
            }
            lanscapeString += "\n";
        }

        return lanscapeString;
    }

    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> neighbors = new ArrayList<Cell>();
        if (col > 0){
            Cell above = LandscapeGrid[row][col-1];
            neighbors.add(above);
        }
        if (col < LandscapeGrid.length - 1){
            Cell below = LandscapeGrid[row][col+1];
            neighbors.add(below);
        }
        if (row > 0){
            Cell left = LandscapeGrid[row-1][col];
            neighbors.add(left);
        }
        if (row < LandscapeGrid.length - 1){
            Cell right = LandscapeGrid[row+1][col];
            neighbors.add(right);
        }
        if (row < LandscapeGrid.length - 1 && col < LandscapeGrid.length - 1){
            Cell wCell = LandscapeGrid[row+1][col+1];
            neighbors.add(wCell);
        }
        if (row < LandscapeGrid.length - 1 && col > 0){
            Cell tCell = LandscapeGrid[row+1][col-1];
            neighbors.add(tCell);
        }
        if (row > 0 && col < LandscapeGrid.length - 1){
            Cell bCell = LandscapeGrid[row-1][col+1];
            neighbors.add(bCell);
        }
        if (row > 0 && col > 0){
            Cell eCell = LandscapeGrid[row-1][col-1];
            neighbors.add(eCell);
        }
        return neighbors;
        

    }

    // Draws the landscape
    public void draw(Graphics g, int gridScale) {
        for (int i=0; i<LandscapeGrid.length;i++) {
            for (int j=0; j<LandscapeGrid[i].length;j++) {
                LandscapeGrid[i][j].draw(g, i*gridScale, j*gridScale, 1*gridScale);
            }
        }
    }

    public void advance() {
        // Make a new 2D Grid 
        Cell [][] newGenerationCells;
        newGenerationCells = new Cell[rows][cols];

        // We want to loop in the landscape and fill it in with the new figures for Cells

        for (int i=0; i<newGenerationCells.length; i++) {
            for (int j=0; j<newGenerationCells.length; j++) {
                 newGenerationCells[i][j] = new Cell(LandscapeGrid[i][j].getAlive());
                 newGenerationCells[i][j].updateState(getNeighbors(i, j));
            }
        }

        //Make Landscape Grid equals to the new Grid
        LandscapeGrid = newGenerationCells;
    }


    public static void main(String[] args) {
        Landscape newLandscape = new Landscape(4, 4);
        System.out.println(newLandscape.getNeighbors(3, 3));
        // System.out.println(newLandscape.rows);
        // newLandscape.reset();


        // int rowNum = newLandscape.getRows();
        // System.out.println(rowNum);
    }





    
}
