import java.util.ArrayList;
public class TowerOfHanoi
{
    // Determines how many discs will be present in the puzzle at the beginning
    private static final int DISCS = 3;
    
    /*
        Recursively solves the Tower of Hanoi problem
    */
    public static void towerOfHanoi(ArrayList<ArrayList<Integer>> pegs, int disc, int from, int to) {
        
        if(disc == 1){
            pegs.get(from).remove(pegs.get(from).size()-1);
            pegs.get(to).add(disc);
            System.out.println("Moving " + disc + " from " + from + " to " + to);
            displayTower(pegs);
            return;
        }
        
        int index = 0;
        int crane = 0;
        int crow = 0;
        for(int i = 0; i < pegs.get(from).size(); i++){
            if(pegs.get(from).get(i) == disc){
                index = i;
                
            }
        }
        
        
        int dove = 0;
        if(from != 0 && to != 0){
            dove = 0;
        }
        if(from != 1 && to != 1){
            dove = 1;
        }if(from != 2 && to != 2){
            dove = 2;
        }
        
        crane = (index+1);
        if(crane == pegs.get(from).size()){
            pegs.get(from).remove(pegs.get(from).size()-1);
            pegs.get(to).add(disc);
            System.out.println("Moving " + disc + " from " + from + " to " + to);
            displayTower(pegs);
            return;
        }
        crow = pegs.get(from).get(crane);
        towerOfHanoi(pegs, crow, from, dove);
        towerOfHanoi(pegs, disc, from, to);
        towerOfHanoi(pegs, crow, dove, to);
    }
    
    /*
        Returns a String with a color applied to the number passed as a parameter
    */
    public static String cNum(int n) {
        return Color.NUM[(n - 1) % 8] + n + Color.RESET;
    }
    
    /*
        Prints out the pegboard
    */
        public static void displayTower(ArrayList<ArrayList<Integer>> pegs) {
        for(int i = 0; i < DISCS; i++) {
            System.out.print(" ");
            for(int j = 0; j < 3; j++) {
                if(pegs.get(j).size() >= DISCS - i) {
                    
                    System.out.print(cNum(pegs.get(j).get(DISCS - i - 1)) + "\t");
                }
                else {
                    System.out.print("|\t");
                }
            }
            System.out.println();
        }
        for(int i = 0; i < 18; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(" 0\t1\t2\n");
    }
    
    /*
        This is the main method
        It creates the pegboard, then calls the towerOfHanoi method on it
    */
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> pegs = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < 3; i++) {
            pegs.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < DISCS; i++) {
            pegs.get(0).add(DISCS - i);
        }
        System.out.println("Starting Position");
        displayTower(pegs);
        towerOfHanoi(pegs, DISCS, 0, 2);
    }
}