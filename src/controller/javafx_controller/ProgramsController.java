package controller.javafx_controller;

import controller.GarbageCollector;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import repo.ArrayListRepository;
import repo.Repository;

public class ProgramsController  {
    @FXML
    private ListView<String> AllProgramsListView;

    private Repository programsRepository;

    public void setRepo(Repository programs) {
        //AllProgramsListView.getItems().setAll(programs);
        programsRepository = programs;
    }

    @FXML
    public void initialize() {
        AllProgramsListView.getItems().addAll("Apple", "Banana", "Orange");
    }

}
