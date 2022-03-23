public class OffByN implements CharacterComparator{
    private int n;

    public OffByN(int N){
        n = N;
    }

    public boolean equalChars(char x, char y){
        if(!Character.isLetter(x) || !Character.isLetter(y)){
            return false;
        }
        int diff = Character.getNumericValue(x) - Character.getNumericValue(y);
        return diff == n || diff == -n ;
    }
}
