

public class Agent {

    public Maze currentMaze;

    private int[][] agentMap = new int[Maze.map.length+2][Maze.map[0].length+2];

    int currentX;
    int currentY;
    int endX;
    int endY;

    public Agent(Maze currentMaze){
        this.currentMaze = currentMaze;
        this.currentX = currentMaze.startPosition[0];
        this.currentY = currentMaze.startPosition[1];
        this.endX = currentMaze.endPosition[0];
        this.endY = currentMaze.endPosition[1];

    }



    ////////////////////// Method to find the path form start position to end position /////////////////////////////

    public int[] traceRoute(){
        int[] solution = new int[Maze.map.length * Maze.map[0].length];
        int solutionIndex = 0;
        int processCount=1;

        while(!(currentX==endX && currentY==endY)){
            // test point 1
            System.out.println("********** Processing data for step "+processCount+" **********");
            System.out.println("currentX : "+ currentX+"  currentY : "+currentY);
            buildAgentMap(currentX,currentY);
            int[] navOptions = getSurrounding(currentX,currentY);
            int direction = getDirection(navOptions);
            updatePosition(direction);
            solution[solutionIndex]=direction+1;
            ++solutionIndex;
            ++processCount;
            System.out.println();

        }
        int length=0;
        for(int i=0;solution[i]!=0;i++){
            length++;
        }
        int[] sizedSolution = new int[length+1];
        for(int i=0;solution[i]!=0;i++){
            sizedSolution[i]=solution[i];
        }
        return sizedSolution;
    }


    //////////////////////  Method to build the agent map from each step taken by the agent ///////////////////////////


    public void buildAgentMap(int x, int y){

        boolean[][] map = this.currentMaze.map;

        int agentX = x+1;
        int agentY = y+1;

        // North cell value
        if(agentMap[agentX-1][agentY]==0) {
            this.agentMap[agentX - 1][agentY] = ((x - 1 < 0) ? true : map[x - 1][y]) ? 2 : 0;
        }

        // East cell value
        if(agentMap[agentX][agentY+1]==0) {
            this.agentMap[agentX][agentY + 1] = ((y + 1 > (map[0].length - 1) ? true : map[x][y + 1])) ? 2 : 0;
        }

        // South cell value
        if(agentMap[agentX + 1][agentY]==0)
            this.agentMap[agentX+1][agentY] = ((x+1 > (map.length-1)) ? true: map[x+1][y]) ? 2:0;

        // West cell value
        if(agentMap[agentX][agentY-1]==0)
            this.agentMap[agentX][agentY-1] = ((y-1 < 0) ? true: map[x][y-1]) ? 2:0;

        // test point -- 2
        System.out.println("Build map ---------> "+ "N-" + agentMap[agentX-1][agentY]
                         +" E-" + agentMap[agentX][agentY+1]
                          +" S-"+ agentMap[agentX + 1][agentY]
                          +" W-"+ agentMap[agentX][agentY-1]);


    }


    ///////////////////// Method to enquire about the weight of the surrounding cells ///////////////////////////////


    public int[] getSurrounding(int x, int y){
        int agentX = x+1;
        int agentY = y+1;
        int blockade = 0;
        int N = agentMap[agentX-1][agentY];
        int E = agentMap[agentX][agentY+1];
        int S = agentMap[agentX+1][agentY];
        int W = agentMap[agentX][agentY-1];

        int[] surrounding={N, E, S, W};
        for(int i=0; i<surrounding.length; i++){
            if(surrounding[i]==2)
                blockade++;
        }
        if(blockade==3)
            agentMap[agentX][agentY]=1;
        // test point -- 3
        System.out.println("Surrounding info --> N-"+N+" E-"+E+" S-"+S+" W-"+W);
        System.out.println("Current cell weight --> "+agentMap[agentX][agentY]);
        return surrounding;

    }

    ////////////////////////// Method to choose a direction for next move among other possible options ////////////////


    public int getDirection(int[] navOptions){
        int min= navOptions[0];
        int n=0;

        for(int i=0; i<navOptions.length; i++){
           if(navOptions[i]== min)
               n++;
           if(navOptions[i] < min) {
               min = navOptions[i];
               n=1;
           }
        }

        int[] indexesOfMin = new int[n];
        int index =0;
        for(int i=0; i<navOptions.length; i++){
            if(navOptions[i]==min)
                indexesOfMin[index++]=i;
        }

        return indexesOfMin[0];

    }

    //////////////////////// Method to update the current position of agent after each move ///////////////////////////

    public void updatePosition(int direction){
        int agentX = currentX+1;
        int agentY = currentY+1;
        // test point -- 4
        System.out.println("Selected direction (0-N , 1-E, 2-S, 3-W)-----> "+direction);
        agentMap[agentX][agentY] +=1;
        // test point -- 5
        System.out.println("Updated previous cell weight --> "+agentMap[agentX][agentY]);

        switch(direction){

            case 0:
                currentX-=1;
                break;
            case 1:
                currentY+=1;
                break;
            case 2:
                currentX+=1;
                break;
            case 3:
                currentY-=1;
                break;
             default:
                 System.out.println("Sorry... Incorrect direction!!!");

        }

        // test point -- 6
        System.out.println("UpdatedX : "+currentX+"  UpdatedY : "+currentY);
    }

}
