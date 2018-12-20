public class Solution {

    public static int[] path;
    public Solution(int[] path){
        this.path = path;
    }

    public int[] getFinalSolution(){

        int length = path.length;
        int[] tempPath = new int[length];
        for(int i=0; i<length; i++){
            tempPath[i]=path[i];
        }

        //////////////////////////////
        int correctionCount=0;
        int[] finalPath;

        do{
            finalPath = new int[tempPath.length];
            int index = 0;
            correctionCount=0;
            for(int i=0;i<tempPath.length-1;i++){
                if(Math.abs(tempPath[i]-tempPath[i+1])==2){
                    i++;
                    correctionCount++;

                } else {
                    finalPath[index]=tempPath[i];
                    index++;
                   /* if(i==tempPath.length-2)
                        finalPath[index]=tempPath[length-1];*/
                }


            }

            tempPath = finalPath;

        }while (correctionCount!=0);


        length=0;
        for(int i=0;finalPath[i]!=0;i++){
            length++;
        }
        System.out.println("N0 of steps : " + length);
        int[] trimmedSolution = new int[length+1];
        for(int i=0;finalPath[i]!=0;i++){
            trimmedSolution[i]=finalPath[i];
        }

        return trimmedSolution;
    }
}
