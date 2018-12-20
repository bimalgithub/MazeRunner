public class Maze {

    /*public static boolean[][] map = {
            {true, true, false, true},
            {true, false, false, false},
            {false, false, true, true},
            {true, true, true, true},
    };*/

    public static boolean[][] map = {
            {true, true, true, true, false, true},
            {false, false, true, true, false, true},
            {true, false, false, false, false, true},
            {true, true, true, true, false, false},
            {true, false, false, false, false, true},
            {true, false, true, true, true, true}

    };

    int[] startPosition = {1,0};
    int[] endPosition = {5,1};


    public Maze(){

    }

    public void printRoute(int step, int i){
        switch(i) {
            case 1:
                System.out.println(step+" --> North");
                break;
            case 2:
                System.out.println(step+" --> East");
                break;
            case 3:
                System.out.println(step+" --> South");
                break;
            case 4:
                System.out.println(step+" --> West");
                break;
            default:
                System.out.println("Congrats!! you made it to the destination...");
        }

    }


}
