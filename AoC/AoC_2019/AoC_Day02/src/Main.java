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

        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99 ; verb++) {
                findvalue(intArray,noun,verb);
            }
        }

        System.out.println(intArray[0]);
    }
    public static int findvalue(int[] a, int noun, int verb ){
        int[] copya = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            copya[i] = a[i];
        }
        copya[1] = noun;
        copya[2] = verb;
        int value = calculate(copya);
        if( value == 19690720){
            System.out.println(100*noun+verb);
            return 100*noun + verb;
        }
        else return 0;
    }

    public static int calculate(int[] a){

        for (int i = 0; i < a.length ; i += 4) {
            if(a[i] == 1){
                int term1 = a[a[i+1]];
                int term2 = a[a[i+2]];
                int adress = a[i+3];
                a[adress] = term1+term2;

            }
            else if(a[i] == 2){
                int term1 = a[a[i+1]];
                int term2 = a[a[i+2]];
                int adress = a[i+3];
                a[adress] = term1*term2;

            }
            else if(a[i] == 99){
                return a[0];
            }
        }
        for (int i = 0; i < a.length ; i++) {
            System.out.println(a[i]);
        }
        return -1;
    }
}