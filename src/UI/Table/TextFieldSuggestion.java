package UI.Table;

import UI.Table.TextFieldSuggestionUI;
import javax.swing.JTextField;

public class TextFieldSuggestion extends JTextField {

    public TextFieldSuggestionUI textUI;

    public TextFieldSuggestion() {
        textUI = new TextFieldSuggestionUI(this);
        setUI(textUI);
    }

    public void addItemSuggestion(String text) {
        textUI.getItems().add(text);
    }

    public void removeItemSuggestion(String text) {
        textUI.getItems().remove(text);
    }

    public void clearItemSuggestion() {
        textUI.getItems().clear();
    }

    public void setRound(int round) {
        textUI.setRound(round);
    }

    public int getRound() {
        return textUI.getRound();
    }

    public void setEchoChar(char c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getFloat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
