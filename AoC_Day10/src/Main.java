import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.StrictMath.max;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        ArrayList<String> rows = new ArrayList<>();
        ArrayList<ArrayList<Boolean>> asteroidMap = new ArrayList<>();
        ArrayList<IntPair> lineMap = new ArrayList<>();
        ArrayList<IntPair> directions = new ArrayList<>();



        Scanner scanner = new Scanner(new File("Puzzle_Input.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            rows.add(line);
        }

        for (int i = 0; i < rows.size(); i++) {
            ArrayList<Boolean> inner = new ArrayList<>();
            for (int j = 0; j < rows.get(0).length(); j++) {
                if (rows.get(i).charAt(j) == '#') {
                    inner.add(true);
                } else {
                    inner.add(false);
                }
            }
            asteroidMap.add(inner);
        }
        int[] answerPoint = new int[2];
        int answer = 0;
        for (int y = 0; y < asteroidMap.size() ; y++) {
            for (int x = 0; x < asteroidMap.get(y).size() ; x++) {
                int counter = 0;

                if (asteroidMap.get(y).get(x)){

                    for (int compY = 0; compY < asteroidMap.size() ; compY++) {

                        for (int compX = 0; compX < asteroidMap.get(compY).size() ; compX++) {

                            if((y == compY && x == compX) || !asteroidMap.get(compY).get(compX)){
                                continue;
                            }
                            counter += hasLoS(x,y,compX,compY,asteroidMap);

                        }
                    }
                }
                if(answer < counter){
                    answerPoint[0] = x;
                    answerPoint[1] = y;
                }
                answer = max(answer,counter);
                System.out.println(answer);
            }
        }
        for (int y = 0; y < asteroidMap.size() ; y++) {
            for (int x = 0; x < asteroidMap.get(y).size(); x++) {
                int lineY = y - answerPoint[1];
                int lineX = x - answerPoint[0];
                if(lineY != 0 && lineX != 0){
                    int gcd = gcdBySteinsAlgorithm(Math.abs(lineX),Math.abs(lineY));
                    IntPair value = new IntPair(lineX / gcd, lineY / gcd);
                    for (int i = 0; i < lineMap.size() ; i++) {
                        if(lineMap.contains(value)){
                            continue;
                        }
                        else{
                            lineMap.add(value);
                        }

                    }

                }
            }

        }
    }

    public static int hasLoS(int x, int y, int compX,int compY, ArrayList<ArrayList<Boolean>> map){

        int mutableX = x;
        int mutableY = y;
        int lineX = compX-x;
        int lineY = compY-y;
        int gcd = gcdBySteinsAlgorithm(Math.abs(lineX),Math.abs(lineY));
        lineX /= gcd;
        lineY /= gcd;


        while (true) {
            mutableX += lineX;
            mutableY += lineY;
            if (mutableX == compX && mutableY == compY) {
                return 1;
            }
            if (map.get(mutableY).get(mutableX)) {
                return 0;
            }
        }
    }

    public static int gcdBySteinsAlgorithm(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        }

        if (n2 == 0) {
            return n1;
        }

        int n;
        for (n = 0; ((n1 | n2) & 1) == 0; n++) {
            n1 >>= 1;
            n2 >>= 1;
        }

        while ((n1 & 1) == 0) {
            n1 >>= 1;
        }

        do {
            while ((n2 & 1) == 0) {
                n2 >>= 1;
            }

            if (n1 > n2) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            n2 = (n2 - n1);
        } while (n2 != 0);
        return n1 << n;
    }
}

