import java.util.Random;
public class LifeSimulation {
    public static void main(String[] args) throws InterruptedException {

        //ParseInt converts string to integer
        int firstDimension=Integer.parseInt(args[0]);
        int secondDimension=Integer.parseInt(args[1]);
       
       // Landscape takes in Command Line arguments which control the dimensions for the landscape
        Landscape scape = new Landscape(firstDimension, secondDimension);
        Random gen = new Random();
        double density = 0.3;

        

        // initialize the grid to be 30% full
        for (int i = 0; i < scape.getRows(); i++) {
            for (int j = 0; j < scape.getCols(); j++ ) { 
                scape.getCell( i, j ).setAlive( gen.nextDouble() <= density );
            }
        }

        LandscapeDisplay display = new LandscapeDisplay(scape, 8);

        /**
         * Goes through the whole landscape grid
         * Updates the cell status
         * advances to the next generation of the game
         */
        for (int i=0; i<scape.getRows(); i++) {
            for (int j=0; j<scape.getCols(); j++) {
                scape.advance();
                display.repaint();
                Thread.sleep(250);
                display.saveImage( "data/life_frame_" + String.format( "%03d", i ) + ".png" );
            }
        }

        

      

        

    }

    
}
