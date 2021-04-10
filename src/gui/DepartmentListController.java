package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {
	
	@FXML
	private TableView<Department> TableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> TableColumnId;
	
	@FXML
	private TableColumn<Department, String> TableColumnName;
	
	@FXML
	private Button BtAction; 
		
	@FXML
	public void onBtAction() {
		System.out.println("onBtAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		// TODO Auto-generated method stub
		
	}

	private void initializeNodes() {
		//para inicializar o comportamento da tabela
		TableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//macete para o tamanho da tabela companhar a tela;
		Stage stage = (Stage) Main.getMainScene().getWindow();
		TableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		TableViewDepartment.prefWidthProperty().bind(stage.widthProperty());
		
	}
	

}
