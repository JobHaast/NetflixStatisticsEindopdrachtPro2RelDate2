package GUIScenes.CRUDActions;

import database.Read;
import database.Create;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateAccount {
    public static Scene display(Stage stage, Read read){
        Create cA = new Create("jdbc:sqlserver://localhost;databaseName=Login;integratedSecurity=true;");

        //CRUD Scene
        GridPane createAccountGridPane = new GridPane();
        createAccountGridPane.setAlignment(Pos.CENTER);
        createAccountGridPane.setHgap(10);
        createAccountGridPane.setVgap(10);
        createAccountGridPane.setPadding(new Insets(25, 25, 25, 25));

        //Label for AccountName
        Label accountNameLabel = new Label("Account Name:");
        createAccountGridPane.add(accountNameLabel, 0, 0);

        //textfield for accountname
        TextField accountNameTextField = new TextField();
        createAccountGridPane.add(accountNameTextField, 1, 0);

        //Label for email
        Label emailLabel = new Label("Email:");
        createAccountGridPane.add(emailLabel, 0, 1);

        //Textfield for email
        TextField emailTextField = new TextField();
        createAccountGridPane.add(emailTextField, 1, 1);

        //Label for phonenumber
        Label phonenumberLabel = new Label("Phonenumber:");
        createAccountGridPane.add(phonenumberLabel, 0, 2);

        //Textfield for phonenumber
        TextField textFieldPhonenumber = new TextField();
        createAccountGridPane.add(textFieldPhonenumber, 1, 2);

        //Label for password
        Label passwordLabel = new Label("Password:");
        createAccountGridPane.add(passwordLabel, 0, 3);

        //Passwordfield for password
        PasswordField passwordFieldPassword = new PasswordField();
        createAccountGridPane.add(passwordFieldPassword, 1, 3);

        //Label for streetname
        Label labelAddress = new Label("Streetname:");
        createAccountGridPane.add(labelAddress, 0, 4);

        //Textfield for streetname
        TextField textFieldStreetName = new TextField();
        createAccountGridPane.add(textFieldStreetName, 1, 4);

        //Label for number
        Label labelNumber = new Label("Number:");
        createAccountGridPane.add(labelNumber, 0, 5);

        //Textfield for number
        TextField textFieldNumber = new TextField();
        createAccountGridPane.add(textFieldNumber, 1, 5);

        //Label for Addition
        Label labelAddition = new Label("Addition:");
        createAccountGridPane.add(labelAddition, 0, 6);

        //Textfield for Addition
        TextField textFieldAddition = new TextField();
        createAccountGridPane.add(textFieldAddition, 1, 6);

        //Label for City
        Label labelCity = new Label("City:");
        createAccountGridPane.add(labelCity, 0, 7);

        //Textfield for City
        TextField textFieldCity = new TextField();
        createAccountGridPane.add(textFieldCity, 1, 7);

        final Text actiontarget = new Text();
        createAccountGridPane.add(actiontarget, 1, 9);

        Button submit = new Button("Button");
        createAccountGridPane.add(submit,0,8);
        submit.setOnAction(event -> {
            if(textFieldStreetName.getText() == null || textFieldNumber.getText() == null || textFieldCity.getText() == null || accountNameTextField.getText() == null || accountNameTextField.getText() == null || emailTextField.getText() == null ||
                    textFieldPhonenumber.getText() == null || passwordFieldPassword.getText() == null){
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Please fill in all fields!");
            }else if("Address created".equals(cA.createAddress(textFieldStreetName.getText(), Integer.parseInt(textFieldNumber.getText()), textFieldAddition.getText(), textFieldCity.getText())) &&
                    "Account created".equals(cA.createAccount(accountNameTextField.getText(), emailTextField.getText(), textFieldPhonenumber.getText(), passwordFieldPassword.getText(),
                            Integer.parseInt(read.executeQueryOneValue("SELECT AddressId FROM Address WHERE Streetname = '"+textFieldStreetName.getText()+"' AND Number = "+textFieldNumber.getText()+" AND Addition = '"+textFieldAddition.getText()+"' AND City = '"+textFieldCity.getText()+"'", "AddressId"))))){
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Account created successfully");
            }else{
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("An error has occurred");
            }
        });

        Scene createAccount = new Scene(createAccountGridPane);
        return createAccount;
    }
}
