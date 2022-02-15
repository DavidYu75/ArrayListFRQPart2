import java.util.ArrayList;

public class WordScramble
{
    /** Scrambles a given word.
     *
     *  @param word  the word to be scrambled
     *  @return  the scrambled word (possibly equal to word)
     *
     *  Precondition: word is either an empty string or contains only uppercase letters.
     *  Postcondition: the string returned was created from word as follows:
     *  - the word was scrambled, beginning at the first letter and continuing from left to right
     *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
     *  - letters were swapped at most once
     */
    public static String scrambleWord(String word)
    {
        ArrayList<String> wordAsArrayList = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            wordAsArrayList.add(word.substring(i , i + 1));
        }
        for (int j = 0; j < wordAsArrayList.size() - 1; j++) {
            if (wordAsArrayList.get(j).equals("A")) {
                if (!wordAsArrayList.get(j + 1).equals("A")) {
                    String temp = wordAsArrayList.get(j);
                    wordAsArrayList.set(j, wordAsArrayList.get(j + 1));
                    wordAsArrayList.set(j + 1, temp);
                    j++;
                }
            }
        }
        String newWord = "";
        for (int k = 0; k < wordAsArrayList.size(); k++) {
            newWord += wordAsArrayList.get(k);
        }
        return newWord;
    }

    /** Modifies wordList by replacing each word with its scrambled
     *  version, removing any words that are unchanged as a result of scrambling.
     *
     *  @param wordList the list of words
     *
     *  Precondition: wordList contains only non-null objects
     *  Postcondition:
     *  - all words unchanged by scrambling have been removed from wordList
     *  - each of the remaining words has been replaced by its scrambled version
     *  - the relative ordering of the entries in wordList is the same as it was
     *    before the method was called
     */
    public static void scrambleOrRemove(ArrayList<String> wordList)
    {
        for (int i = 0; i < wordList.size(); i++) {
            if (scrambleWord(wordList.get(i)).equals(wordList.get(i))) {
                wordList.remove(i);
                i--;
            } else {
                wordList.set(i, scrambleWord(wordList.get(i)));
            }
        }
    }
}