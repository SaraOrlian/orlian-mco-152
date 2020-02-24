package orlian.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Scrabble {

    HashSet<String> set = new HashSet<String>();
    Iterator<String> itr = set.iterator();

    // read text file into HashSet
    public void readFile(String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String nextWord = scanner.next();
            set.add(nextWord.toLowerCase());
        }
    }

    // check HashSet for specified word
    public boolean isWord(String word) {
        word = word.toLowerCase();
        if (set.contains(word))
        {
            return true;
        }
        return false;
    }
}


