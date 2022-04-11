
public class Grid{
    public static void main(String[] args) {
        for(String string : args) {
            System.out.println(string);
        }
         
        int yogi=Integer.parseInt(args[0]);
        int booboo=Integer.parseInt(args[1]);
       
        
        String[][] ranger;

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        ranger = new String[yogi][booboo];

     

        // char randomCharacter = (char) (ranChar.nextInt(25) + 'A');

        for (int i=0;i<ranger.length;i++){
            for(int j=0; j<ranger[i].length;j++){
                ranger[i][j] = "" + alphabet.charAt( (int) (Math.random()*26)); 

            }
        }

        
        for (int i=0;i<ranger.length;i++) {
            for (int j = 0; j<ranger[i].length;j++){
                System.out.print(ranger[i][j]);
            }
            System.out.println();
        }




        // if (args.length>1) {
        //     for (int i = 0; i<args.length; i++) {
        //     System.out.println(args[i]);
        //     }
        // }

        // else{
        //     System.out.println("Usage: args (Java+filename+String....");
        // }
        

    }
}