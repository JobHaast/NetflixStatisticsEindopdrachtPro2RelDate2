package logic;

import javafx.beans.property.SimpleStringProperty;

public class StringForTableView {
    private final SimpleStringProperty string;

    public StringForTableView(String string){
        this.string = new SimpleStringProperty(string);
    }

    public String getString() {
        return string.get();
    }

    public void setString(String string) {
        this.string.set(string);
    }
}
