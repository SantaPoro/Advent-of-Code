import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("Puzzle_Input.txt"));
        String cable1 = scanner.nextLine();
        String cable2 = scanner.nextLine();
        String[] instructions1 = cable1.split(",");
        String[] instructions2 = cable2.split(",");

        ArrayList<IntPair>path1 = instructions(instructions1);
        ArrayList<IntPair>path2 = instructions(instructions2);
        ArrayList<IntPair>intersections = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        int compare;

        for (IntPair pos1 : path1) {
            for (IntPair pos2 : path2){
                if(compare(pos1,pos2)){
                    pos1.counter += pos2.counter;
                    intersections.add(pos1);
                }
            }
        }

        for (IntPair pos : intersections){
            //compare = (Math.abs(pos.x) + Math.abs(pos.y));
            compare = pos.counter;
            if (compare < answer && compare != 0){
                answer = compare;
            }
            //System.out.println(pos.x + " " + pos.y);
        }
        System.out.println(answer);
    }

    public static ArrayList<IntPair> instructions(String[] a) {
        int steps = 0;
        ArrayList<IntPair>output = new ArrayList<IntPair>();
        output.add(new IntPair(0,0,0));

        for (int i = 0; i < a.length; i++){
            steps = Integer.parseInt(a[i].substring(1));
            IntPair previous = output.get(output.size()-1);

            switch (a[i].charAt(0)) {
                case 'U':
                    for (int j = 1; j <= steps ; j++) {
                        output.add(new IntPair(previous.x,previous.y+j,previous.counter+j));
                    }
                    break;
                case 'D':
                    for (int j = 1; j <= steps ; j++) {
                        output.add(new IntPair(previous.x,previous.y-j,previous.counter+j));
                    }
                    break;
                case 'R':
                    for (int j = 1; j <= steps ; j++) {
                        output.add(new IntPair(previous.x+j,previous.y,previous.counter+j));
                    }
                    break;
                case 'L':
                    for (int j = 1; j <= steps ; j++) {
                        output.add(new IntPair(previous.x-j,previous.y,previous.counter+j));
                    }
                    break;
            }

        }
        return output;
    }


    public static boolean compare (IntPair a, IntPair b){
        if (a.x == b.x && a.y == b.y) {
            return true;
        }
        return false;
    }
}
