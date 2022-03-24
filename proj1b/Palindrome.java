public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        int string_size = word.length();
        Deque<Character> deque;
        deque = new ArrayDeque<Character>();

        for (int i = 0; i < string_size ; i++){
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    private boolean isequal(Deque d){
        if(d.size() == 0 || d.size()==1){
            return true;
        }
        if(d.removeFirst() == d.removeLast()){
            return isequal(d);
        }
        return false;
    }

    public boolean isPalindrome(String word){
        Deque<Character> deque = wordToDeque(word);
        return isequal(deque);
    }

    private boolean isoffbyone(Deque<Character> d,CharacterComparator cc){
        if(d.size() == 0){
            return true;
        }
        if(d.size() == 1){
            return Character.isLetter(d.removeLast());
        }
        char df = d.removeFirst();
        char dl = d.removeFirst();
        if(cc.equalChars(df,dl) && Character.isLetter(df) &&Character.isLetter(dl)){
            return isoffbyone(d,cc);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> deque = wordToDeque(word);
        return isoffbyone(deque,cc);
    }

}
