package orlian.scrabble;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ScrabbleFrame extends JFrame {

    private final JTextField wordField;
    private final JLabel answerLabel;

    public ScrabbleFrame(){

        setSize(400, 300);
        setTitle("Scrabble Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        wordField = new JTextField();
        wordField.setPreferredSize(new Dimension( 160, 40));
        JButton checkButton = new JButton("Check");

        checkButton.addActionListener(actionEvent -> checkWord());

        answerLabel = new JLabel();
        answerLabel.setPreferredSize(new Dimension(100, 40));
        answerLabel.setOpaque(true);
        add(wordField);
        add(checkButton);
        add(answerLabel);
    }

    public void checkWord() {
        Scrabble dictionary = new Scrabble();
        try {
            dictionary.readFile("src\\orlian\\scrabble\\dictionary.txt");
            boolean isInDictionary = dictionary.isWord(wordField.getText());
            answerLabel.setBackground(isInDictionary ? Color.GREEN : Color.RED);
            answerLabel.setText(String.valueOf(isInDictionary));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ScrabbleFrame frame = new ScrabbleFrame();
        frame.setVisible(true);


    }
}
