package algorithms.newcoder;
import java.util.HashMap;
import java.util.Scanner;

public class Step {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String inputStr = in.nextLine();
            String[] inputArr = inputStr.split(" ");
            int[] steps = new int[inputArr.length];
            for(int i=0;i<inputArr.length;i++) {
                steps[i] = Integer.parseInt(inputArr[i]);
            }

            int maxLargestStep = steps.length/2-1; //range 1-maxLargestStep

            HashMap<Integer, Integer> available = new HashMap<>();
            int length = steps.length;
            for(int i=length-2;i>=maxLargestStep+1;i--) {
                if(i+steps[i]>length-1) {
                    available.put(i, -1);
                }else if(i+steps[i] == length-1){
                    available.put(i, 1);
                }else {
                    if(available.get(i+steps[i]) != -1) {
                        available.put(i, available.get(i+steps[i])+1);
                    }else {
                        available.put(i, -1);
                    }
                }
            }

            int minSteps = 100;
            for(int i=1;i<=maxLargestStep;i++) {
                int index = i;
                int countStep = 1;
                while(index<= maxLargestStep) {
                    index += steps[index];

                    countStep++;
                    if(index ==length-1) {
                        minSteps = countStep;
                        break;
                    }
                }
                if (available.keySet().contains(index)) {
                    if(available.get(index) != -1){
                        minSteps = (countStep + available.get(index))<=minSteps?(countStep + available.get(index)):minSteps;
                    }
                }else {
                    continue;
                }
            }
            if(minSteps == 100) {
                System.out.println(-1);
            }else {
                System.out.println(minSteps);
            }
        }
    }
}
