import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws FileNotFoundException {
        int sumOfFuel = 0;


        Scanner scanner = new Scanner(new File("Modules_mass.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sumOfFuel +=  countFuel(Integer.parseInt(line));
            System.out.println(line);
            // process the line
        }
        System.out.println(sumOfFuel);
        System.out.println(countFuel(14));
        System.out.println(countFuel(1969));
    }


    public static int countFuel (int mass){
        int all_fuel = 0;
        int sum =(int)Math.floor(mass / 3) - 2;
        if(sum > 0)
        {
            all_fuel += countFuel(sum);
        }
        else if (sum <= 0)
        {
            return 0;
        }
        all_fuel += sum;


        return all_fuel;
    }

}


