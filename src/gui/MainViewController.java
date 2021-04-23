package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.service.DepartmentService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}

	@FXML
	public void onMenuItemDepartmentAction() {
		loadView2("/gui/DepartmentList.fxml");;
	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml"); //absoluteName
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}
	// funcão para trocar a view
	private synchronized void loadView(String absoluteName) { //synchronized: garante a não interrupção(mult tred)
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			// instancia a cena principal
			Scene mainScene = Main.getMainScene();
			// getRoot pega o 1o elemento da view
			// casting para ScrollPane (tipo do 1o elemento da mainView
			//getContent para acessar o conteúdo do <content>
			//casting para VBox (tipo do 1o conteudo do <content>
			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			//guardar referência do menu (que não pode mudar):
			//getChildren().get(0): pega o 1o elemento do <children>
			Node mainMenu = mainVbox.getChildren().get(0);
			//.clear() limpa os elementos do elemento
			mainVbox.getChildren().clear();
			//.add() adiciona os elementos da instancia de Node"mainMenu"
			mainVbox.getChildren().add(mainMenu);
			//.addAll() adiciona a coleção de elementos de <children> da view instanciada(absoluteName)
			mainVbox.getChildren().addAll(newVBox.getChildren());

		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading View", e.getMessage(), Alert.AlertType.ERROR);
		}
	}
	
	private synchronized void loadView2(String absoluteName) { //synchronized: garante a não interrupção(mult tred)
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			// instancia a cena principal
			Scene mainScene = Main.getMainScene();
			// getRoot pega o 1o elemento da view
			// casting para ScrollPane (tipo do 1o elemento da mainView
			//getContent para acessar o conteúdo do <content>
			//casting para VBox (tipo do 1o conteudo do <content>
			VBox mainVbox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			//guardar referência do menu (que não pode mudar):
			//getChildren().get(0): pega o 1o elemento do <children>
			Node mainMenu = mainVbox.getChildren().get(0);
			//.clear() limpa os elementos do elemento
			mainVbox.getChildren().clear();
			//.add() adiciona os elementos da instancia de Node"mainMenu"
			mainVbox.getChildren().add(mainMenu);
			//.addAll() adiciona a coleção de elementos de <children> da view instanciada(absoluteName)
			mainVbox.getChildren().addAll(newVBox.getChildren());
			
			DepartmentListController controller = loader.getController();
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();

		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading View", e.getMessage(), Alert.AlertType.ERROR);
		}
	}

}
