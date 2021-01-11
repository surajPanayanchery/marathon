import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Marathon{

     public static void main(String []args){
         
        System.out.println("Enter the distances covered by racers in Marathon(Kilometers) please");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Float> array = new ArrayList<Float>();
        ArrayList<Float> finishers = new ArrayList<Float>();
        
        while (scanner.hasNext()){
            if(scanner.hasNextFloat()){
                array.add(scanner.nextFloat());
            }
            else if(scanner.next() == "q"){
                break;
            }
        }
        Collections.sort(array);
        for(int i = array.size()-1;finishers.size() <= 2; i--){
            if(Float.compare(array.get(i),new Float(42.195)) != 0) {
               finishers.add(array.get(i));
            }
            if(i <= 0 ){
                break;
            }
        }
        System.out.println("Highest Distances excluding Finishers:" + finishers.toString());
        
    }
}
