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

    public boolean isPalindrome(String word){
        Deque<Character> deque = wordToDeque(word);
        for(int i=0;i<Math.ceil(deque.size()/2);i++){
            if(deque.get(i) != deque.get(deque.size()-1-i)){
                return false;
            }
        }
        return true;
    }
}
