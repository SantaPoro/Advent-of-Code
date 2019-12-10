public class IntPair {

    int x;
    int y;
    public IntPair (int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean compare (IntPair a, IntPair b){
        if(a.x == b.x && a.y == b.y){
            return true;
        }
        return false;
    }
}
