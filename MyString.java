import java.util.Random;

/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(subsetOf("sap","space")); // true
        System.out.println(subsetOf("spa","space")); //returns true
        System.out.println(subsetOf("pass","space")); //returns false
        System.out.println(subsetOf("c","space")); //returns true
        System.out.println(spacedString("silent"));
        System.out.println(randomStringOfLetters(3));
        System.out.println(remove("meet","committee")); //returns "comit" );
        System.out.println(insertRandomly('s',"cat"));
        //System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        str = str.toLowerCase();
        int num = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch){
                num++;
            }
        }
        return num;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str2.isEmpty() || str2 == null || str1.isEmpty() || str1 == null)
            return false;
        for(char c : str1.toCharArray()){
            if (countChar(str1, c) > countChar(str2, c))  {
                return false;
            }
        }
        return true;
    }
    

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String news = "";
        for (int i =0; i < str.length(); i++){
            news += str.charAt(i);
            news += " ";
        }
        return news;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        Random r = new Random();
        String rnd = "";
        while (n > 0){
            rnd += (char)(r.nextInt(26) + 'a');   
            n--;
        }
        return rnd.toLowerCase();
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */

    public static String remove(String str1, String str2) {
        if (str1.isEmpty() || str1 == null)
            return str2;
        String newstring = ""; 
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if ((countChar(str1, ch) == 0 || countChar(str1, ch) < countChar(str2, ch)) && !newstring.contains(String.valueOf(ch))) { 
                newstring += ch; 
            }
        }
        return newstring;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
    }*/

    public static String insertRandomly(char ch, String str) {
         //Random index = new Random();
         //int rnd = index.nextInt(str.length() + 1);
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
