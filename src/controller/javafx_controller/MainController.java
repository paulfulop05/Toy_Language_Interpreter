package controller.javafx_controller;

import controller.ProgramService;
import exceptions.ProgramException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.states.MyHeap;
import model.states.MyMap;
import model.states.ProgramState;
import model.values.IntValue;
import model.values.StringValue;
import model.values.Value;
import repo.ArrayListRepository;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainController {

    @FXML
    private ListView<String> ExeStackListView;

    @FXML
    private TableView<Map.Entry<String, String>> FileTableView;

    @FXML
    private TableView<Map.Entry<String, String>> HeapTableView;

    @FXML
    private Button OneStepButton;

    @FXML
    private ListView<String> OutListView;

    @FXML
    private TextField PrgStatesTextField;

    @FXML
    private ListView<Integer> ProgramIDsListView;

    @FXML
    private TableView<Map.Entry<String, String>> SymTableView;

    private List<ProgramService> programServiceList;
    private ProgramService mainProgramService;
    private List<ProgramState> programStates;

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
        programStates = repo.getProgramStates();
        PrgStatesTextField.setText(String.valueOf(repo.getNumOfPrograms()));

        for (var program : repo.getProgramStates()){
            ProgramIDsListView.getItems().add(program.getProgramId());
        }
    }

    public void onProgramIDListViewClicked() {
        int programID = ProgramIDsListView.getSelectionModel().getSelectedItem();
        populateExeStackListView(programID);
        populateSymTableView(programID);
    }

    public void populateExeStackListView(int programID){
        ExeStackListView.getItems().clear();
        var exeStack = mainProgramService.getRepo().getProgram(programID).exeStack();

        for(int i = 0; i < exeStack.size(); i++){
            ExeStackListView.getItems().add(exeStack.get(i).toString());
        }
    }

    public void populateSymTableView(int programID){
        SymTableView.getItems().clear();
        var symTable = mainProgramService.getRepo().getProgram(programID).symTable();

        SymTableView.getItems().addAll(
                symTable.getMap().entrySet().stream()
                        .map(entry -> Map.entry(
                                entry.getKey(),                    // Already String
                                entry.getValue().toString()        // Convert Value to String
                        ))
                        .toList()
        );
    }

    public void populateHeapTableView(){
        HeapTableView.getItems().clear();
        var heapTable = mainProgramService.getRepo().getMainProgram().heapTable();

        HeapTableView.getItems().addAll(
                heapTable.getMap().entrySet().stream()
                        .map(entry -> Map.entry(
                                entry.getKey().toString(),
                                entry.getValue().toString()
                        ))
                        .toList()
        );
    }

    public void populateFileTableView(){
        FileTableView.getItems().clear();
        var fileTable = mainProgramService.getRepo().getMainProgram().fileTable();

        FileTableView.getItems().addAll(
          fileTable.getMap().entrySet().stream()
                  .map(entry -> Map.entry(
                          entry.getKey().toString(),
                          entry.getValue().toString()
                  ))
                  .toList()
        );
    }

    public void populateOutListView(){
        var output = mainProgramService.getRepo().getMainProgram().out();
        OutListView.getItems().clear();
        OutListView.getItems().addAll(output.getElements().stream().map(Object::toString).toList());
    }

    // similar to executeMainProgram() but for the gui
    public void clickOneStep() throws ProgramException, InterruptedException {
        if (programStates.isEmpty()) {
            mainProgramService.getExecutor().shutdownNow();
            mainProgramService.getRepo().setProgramStates(programStates);
            IO.print("Program has been terminated!");
            return;
        }

        programStates = mainProgramService.removeCompletedPrograms(mainProgramService.getRepo().getProgramStates());
        var allSymbolTables = programStates.stream()
                .map(ProgramState::symTable)
                .toList();
        mainProgramService.getGarbageCollector().run(allSymbolTables, programStates.getFirst().heapTable());
        mainProgramService.executeOneStepForAllPrograms(programStates);
        programStates = mainProgramService.removeCompletedPrograms(mainProgramService.getRepo().getProgramStates());
    }

    public void clearView(){
        ExeStackListView.getItems().clear();
        FileTableView.getItems().clear();
        HeapTableView.getItems().clear();
        ProgramIDsListView.getItems().clear();
        SymTableView.getItems().clear();
        PrgStatesTextField.clear();
    }
}
