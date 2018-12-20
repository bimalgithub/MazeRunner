public class MazeMain {
    public static void main(String[] args){
        Maze maze = new Maze();
        Agent agent = new Agent(maze);

        int[] traversedPath = agent.traceRoute();
        for(int i=0; i<traversedPath.length;i++) {
            maze.printRoute(i+1,traversedPath[i]);
        }

        Solution solution = new Solution(traversedPath);
        int[] finalSolution = solution.getFinalSolution();
        System.out.println("The final navigation guide for the tour is..........");
        for(int i=0;i<finalSolution.length;i++){
            maze.printRoute(i+1,finalSolution[i]);

        }


    }


}
