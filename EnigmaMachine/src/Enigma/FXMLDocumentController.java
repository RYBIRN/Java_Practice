package Enigma;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class FXMLDocumentController {

    ObservableList<String> RotorList_1 = FXCollections.observableArrayList("Rotor 1", "Rotor 2", "Rotor 3", "Rotor 4", "Rotor 5");
    ObservableList<String> RotorList_2 = FXCollections.observableArrayList("Rotor 1", "Rotor 2", "Rotor 3", "Rotor 4", "Rotor 5");
    ObservableList<String> RotorList_3 = FXCollections.observableArrayList("Rotor 1", "Rotor 2", "Rotor 3", "Rotor 4", "Rotor 5");

    ObservableList<Integer> WheelStartList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button beginProgram;

    @FXML
    private Label MainLable;

 

 


    @FXML
    private ChoiceBox<String> OuterChoice;

    @FXML
    private ChoiceBox<String> InnerChoice;

    @FXML
    private ChoiceBox<String> MiddleChoice;

    @FXML
    private Label WL1;

    @FXML
    private Label WL2;

    @FXML
    private Label WL3;

    @FXML
    private ComboBox<Integer> InnerStart;

    @FXML
    private ComboBox<Integer> MiddleStart;

    @FXML
    private ComboBox<Integer> OuterStart;

    @FXML
    private TextField plugboardSettings;

    @FXML
    private TextField reflectorSettings;

    @FXML
    private TextField fileName;

    @FXML
    void handleButtonAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.dir")));

        fileChooser.setTitle("Open Resource File");
        
        Window stage = null;
        File file = fileChooser.showOpenDialog(stage);

        EnigmaMachineDemo newEnigmaMachineDemo = new EnigmaMachineDemo(InnerChoice.getValue(), MiddleChoice.getValue(), OuterChoice.getValue(),
                InnerStart.getValue(), MiddleStart.getValue(), OuterStart.getValue(),
                file, plugboardSettings.getText(), reflectorSettings.getText());

       

        
            newEnigmaMachineDemo.EncodeDecode();
        

       
            
        

    }

    @FXML
    void initialize() {
        assert beginProgram != null : "fx:id=\"beginProgram\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert MainLable != null : "fx:id=\"MainLable\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert OuterChoice != null : "fx:id=\"OuterChoice\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert InnerChoice != null : "fx:id=\"InnerChoice\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert MiddleChoice != null : "fx:id=\"MiddleChoice\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert WL1 != null : "fx:id=\"WL1\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert WL2 != null : "fx:id=\"WL2\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert WL3 != null : "fx:id=\"WL3\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert InnerStart != null : "fx:id=\"InnerStart\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert MiddleStart != null : "fx:id=\"MiddleStart\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert OuterStart != null : "fx:id=\"OuterStart\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert plugboardSettings != null : "fx:id=\"plugboardSettings\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert reflectorSettings != null : "fx:id=\"reflectorSettings\" was not injected: check your FXML file 'FXMLDocument.fxml'.";
        assert fileName != null : "fx:id=\"fileName\" was not injected: check your FXML file 'FXMLDocument.fxml'.";

     

        InnerChoice.setItems(RotorList_1);
        InnerChoice.setValue("Rotor 1");
        MiddleChoice.setItems(RotorList_2);
        MiddleChoice.setValue("Rotor 5");
        OuterChoice.setItems(RotorList_3);
        OuterChoice.setValue("Rotor 3");

        InnerChoice.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String oldVal, String newVal) {
                RotorList_2.setAll(RotorList_1);
                RotorList_2.remove(newVal);
            }
        });
        MiddleChoice.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String oldVal, String newVal) {
                RotorList_3.setAll(RotorList_2);
                RotorList_3.remove(newVal);
            }
        });

        InnerStart.setItems(WheelStartList);
        InnerStart.setValue(14);
        MiddleStart.setItems(WheelStartList);
        MiddleStart.setValue(9);
        OuterStart.setItems(WheelStartList);
        OuterStart.setValue(24);

    }
}
