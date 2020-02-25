package orlian.scrabble;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class ScrabbleTest{

    @Test
    public void isWord() throws FileNotFoundException {
        // given
        Scrabble scrabble= new Scrabble();
        scrabble.readFile("src\\orlian\\scrabble\\dictionary.txt");

        // when
        boolean present = scrabble.isWord("ah");

        // then
        assertEquals(true, present);
    }

    @Test
    public void isWordNotExist() throws FileNotFoundException {
        // given
        Scrabble scrabble= new Scrabble();
        scrabble.readFile("src\\orlian\\scrabble\\dictionary.txt");

        // when
        boolean present = scrabble.isWord("xyz");

        // then
        assertEquals(false, present);
    }

    @Test
    public void isWordIgnoreCase() throws FileNotFoundException {
        // given
        Scrabble scrabble= new Scrabble();
        scrabble.readFile("src\\orlian\\scrabble\\dictionary.txt");

        // when
        boolean present = scrabble.isWord("ah");
        boolean present2 = scrabble.isWord("AH");

        // then
        assertEquals(true, present);
        assertEquals(true, present2);
    }
}