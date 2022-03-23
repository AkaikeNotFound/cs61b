public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        if(!Character.isLetter(x) || !Character.isLetter(y)){
            return false;
        }
        int diff = Character.getNumericValue(x) - Character.getNumericValue(y);
        return diff == 1 || diff == -1 ;
    }
}
