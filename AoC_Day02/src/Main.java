import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        Scanner scanner = new Scanner(new File("String_code.txt"));
        String line = scanner.nextLine();
        String[] stringArray = (line.split(","));
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < intArray.length ; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);

        }


        for (int i = 0; i < intArray.length ; i += 4) {
            if(intArray[i] == 1){
                int term1 = intArray[intArray[i+1]];
                int term2 = intArray[intArray[i+2]];
                int adress = intArray[i+3];
                intArray[adress] = term1+term2;

            }
            else if(intArray[i] == 2){
                int term1 = intArray[intArray[i+1]];
                int term2 = intArray[intArray[i+2]];
                int adress = intArray[i+3];
                intArray[adress] = term1*term2;

            }
            else if(intArray[i] == 99){
                break;
            }
        }
        for (int i = 0; i < intArray.length ; i++) {
            System.out.println(intArray[i]);

        }
        System.out.println(intArray[0]);
    }
}