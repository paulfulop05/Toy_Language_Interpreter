package controller.javafx_controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private ListView<?> ExeStackListView;

    @FXML
    private ListView<?> FileTableListView;

    @FXML
    private TableView<?> HeapTableView;

    @FXML
    private Button OneStepButton;

    @FXML
    private ListView<?> OutListView;

    @FXML
    private TextField PrgStatesTextField;

    @FXML
    private ListView<?> ProgramIDsListView;

    @FXML
    private TableView<?> SymTableView;

    public void clickOneStep() {
        IO.print("Testing One step!");
    }
}
