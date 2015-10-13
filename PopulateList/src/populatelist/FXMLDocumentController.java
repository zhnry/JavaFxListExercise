/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package populatelist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Phil O'Connell <pxo4@psu.edu>
 */
public class FXMLDocumentController implements Initializable {
  
  @FXML
  private Label label;
    @FXML
    private Button button;
    @FXML
    private ListView<String> lvPeople;
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private Button btnAddPerson;
  
  @FXML
  private void handleButtonAction(ActionEvent event) {
    System.out.println("You clicked me!");
    label.setText("Hello World!");
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  

    @FXML
    private void handleBtnAddPersonClicked(MouseEvent event) {
        String fullName = tfFirstName.getText() + " " + tfLastName.getText();
        System.out.println(fullName);
        lvPeople.getItems().add(fullName);
    }
    
    SyncPeopleListView(){
            // Items inside the list
    ObservableList<String> items = lvPeople.getItems();

    // Clear out the list
    items.clear();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PopulateListPU");
        PersonJpaController jpaPerson;
    jpaPerson = new PersonJpaController(emf);

    List<Person> people = jpaPerson.findPersonEntities();

    }
    
        // Add each person to the list
    for (Person p : people) {
      String fullName = p.getFirstName() + " " + p.getLastName();
      lvPeople.getItems().add(fullName);
    }

}
