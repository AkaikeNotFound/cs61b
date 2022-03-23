import org.junit.Test;

import java.sql.Array;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must  use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    /*Uncomment this class once you've created your Palindrome class. */
    @Test
    public void testisPalindrome(){
        boolean a = palindrome.isPalindrome("cat");
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("nmsl"));
        assertFalse(palindrome.isPalindrome("caonima"));
        assertFalse(palindrome.isPalindrome("nishizhu"));

        assertTrue(palindrome.isPalindrome("nusun"));

        assertTrue(palindrome.isPalindrome("flake",cc));
    }

    public void main(String[] args){
        testWordToDeque();
        testisPalindrome();
    }
}
