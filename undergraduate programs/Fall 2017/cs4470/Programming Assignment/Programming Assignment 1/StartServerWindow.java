package MRChatApplicationFinal2;
import java.io.IOException;

import javafx.geometry.Pos;   

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StartServerWindow {
	
	public static void display(String title, String message){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label(message);
		
		Button exit = new Button("Exit window");
		exit.setOnAction(e-> window.close());
		exit.setId("exit");
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(label, exit);
		vbox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(vbox);
		String css1 = ChatApplication.class.getResource("openingScene.css").toExternalForm();
		scene.getStylesheets().add(css1);
		window.setScene(scene);
		window.showAndWait();
		
		//Start the server here
		try {
			Server.server();
		} catch (InterruptedException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}