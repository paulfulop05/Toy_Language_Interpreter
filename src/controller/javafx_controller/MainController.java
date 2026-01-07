package controller.javafx_controller;

import controller.ProgramService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import repo.ArrayListRepository;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private ListView<String> ExeStackListView;

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
    private ListView<Integer> ProgramIDsListView;

    @FXML
    private TableView<?> SymTableView;

    private List<ProgramService> programServiceList;
    private ProgramService mainProgramService;

    @FXML
    public void initialize() {
        programServiceList = new ArrayList<ProgramService>();
    }

    public void addProgramService(ProgramService programService) {
        programServiceList.add(programService);
    }

    public void setProgramToTest(int pos) {
        clearView();

        mainProgramService = programServiceList.get(pos);
        var repo = mainProgramService.getRepo();
        PrgStatesTextField.setText(String.valueOf(repo.getNumOfPrograms()));

        for (var program : repo.getProgramStates()){
            ProgramIDsListView.getItems().add(program.getProgramId());
        }
    }

    public void onProgramIDListViewClicked() {
        int programID = ProgramIDsListView.getSelectionModel().getSelectedItem();

        ExeStackListView.getItems().clear();
        var exeStack = mainProgramService.getRepo().getProgram(programID).exeStack();

        for(int i = 0; i < exeStack.size(); i++){
            ExeStackListView.getItems().add(exeStack.get(i).toString());
        }
    }

    public void clickOneStep() {
        IO.print("OK!");
    }

    public void clearView(){
        ExeStackListView.getItems().clear();
        FileTableListView.getItems().clear();
        HeapTableView.getItems().clear();
        ProgramIDsListView.getItems().clear();
        SymTableView.getItems().clear();
        PrgStatesTextField.clear();
    }
}
