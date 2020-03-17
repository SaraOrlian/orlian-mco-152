package orlian.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Scrabble {

    HashSet<String> set = new HashSet<String>();
    Iterator<String> itr = set.iterator();



    // read text file into HashSet
    public void readFile(String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String nextWord = scanner.nextLine();
            set.add(nextWord.toLowerCase());
        }
    }

    // check HashSet for specified word
    public boolean isWord(String word) {
        word = word.toLowerCase();
        Collection<String> firstWords = (Collection<String>) set.stream().map(s -> s.split(" ")[0]).collect(Collectors.toSet());
        if (firstWords.contains(word))
        {
            return true;
        }
        return false;
    }
}


