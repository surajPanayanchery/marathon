import java.util.Scanner;
import java.util.Arrays;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Enter no Of Rows");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        String line = scanner.nextLine();
        CrossWord cross = new CrossWord(rows);
        System.out.println(cross.square.length);
        for(int i=0;i<rows;i++){
            System.out.println("Enter " + (i+1)+" Column black squares");
            line = scanner.nextLine();
            String[] values= line.split(",");
            if(Integer.parseInt(values[0]) != 0){
                for(int j =0 ; j< values.length ; j+=2){
                cross.fillColumnsBlack(i,Integer.parseInt(values[j]),Integer.parseInt(values[j+1]));
                }
            }
        }
        System.out.println(Arrays.deepToString(cross.square));    
        cross.populateC();
        System.out.println(Arrays.deepToString(cross.clueNumbers));
         
     }
     
}

class CrossWord{
    String[][] square;
    String[] clues;
    String[][] clueNumbers;
    int lastValue = 0;
    
    CrossWord(int rows){
        this.square = new String[rows][rows];
    }
    
    public void fillColumnsBlack(int row,int col,int length){
        for(int i = col-1;i<col+length-1;i++){
            this.square[row][i]  = "b";
        }
    }
    
    public void populateC(){
        this.clueNumbers = new String[this.square.length][this.square.length];
        
        for(int i = 0;i<this.square.length;i++){
            for(int j =0;j<square[i].length;j++){
                if(square[i][j]!="b"){
                   if(this.isBlank(this.square.length,i,this.square.length,j-1) ){
                       if(this.clueNumbers[i][j-1] == null){
                           this.lastValue++;
                       }
                       this.clueNumbers[i][j-1] = this.lastValue + "A";
                       continue;
                   }
                   if(this.isBlank(this.square.length,i-1,this.square.length,j) ){
                       if(this.clueNumbers[i-1][j] == null){
                           this.lastValue++;
                           
                       }
                       
                       this.clueNumbers[i-1][j] = this.lastValue + "D";
                       continue;
                   }
                   if(this.isBlank(this.square.length,i,this.square.length,j+1) ){
                       if(this.clueNumbers[i][j+1] == null){
                           this.lastValue++;
                           
                       }
                       this.clueNumbers[i][j+1] = this.lastValue + "A";
                       continue;
                   }
                   if(this.isBlank(this.square.length,i+1,this.square.length,j) ){
                       if(this.clueNumbers[i+1][j] == null){
                           this.lastValue++;
                           
                       }
                       this.clueNumbers[i+1][j] = this.lastValue + "D";
                       continue;
                   }
                }
            }
        }
    }
    
    public boolean isBlank(int rows,int row,int cols,int col){
        if(row>0 && row<rows){
            if(col>0 && col<cols){
                if(this.square[row][col] == null){
                    return true;
                }
            }
        }
        return false;
    }
}
