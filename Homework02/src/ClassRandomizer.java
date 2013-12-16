import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class ClassRandomizer {
    public static void main(String[] args){
        String[] students = new String[]{"Kevin", "Ernie", "Marine", "Granger", "Shirley", "Fred", "Rachel", "Mandeep", "Hunter", "TJ"};
        randomizer(students);
    }

    public static void randomizer(String[] s){
        String[] allStuds = Arrays.copyOf(s, s.length);
        int[] usedStuds = new int[allStuds.length];
        for (int k = 0; k < usedStuds.length; k++){
            usedStuds[k] = usedStuds.length+1;
        }
        
        Random rand = new Random();
        boolean alreadyUsed = false;
        String studentA = "";
        String studentB = "";

        for(int j = 0; j < allStuds.length; j+=2){
            do{
                int x = rand.nextInt(allStuds.length);
                int y = rand.nextInt(allStuds.length);
                for (int i = 0; i < usedStuds.length; i++){
                    if(x == usedStuds[i] || y == usedStuds[i] || x == y){
                        alreadyUsed = true;
                        break;
                    }
                    else{
                        alreadyUsed = false;
                    }
                }
                if (alreadyUsed == false){
                    studentA = allStuds[x];
                    studentB = allStuds[y];
                    usedStuds[j] = x;
                    usedStuds[j+1] = y;
                }
            }
            while(alreadyUsed == true);
            System.out.println(studentA + " and " + studentB);
        }
    }
}