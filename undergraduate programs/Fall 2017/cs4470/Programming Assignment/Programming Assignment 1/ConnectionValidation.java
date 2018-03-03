package MRChatApplicationFinal2;
import javafx.geometry.Pos;  

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConnectionValidation {




	public static void display(String title, String message){
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		Label label = new Label(message);

		Button exit = new Button("Exit");
		exit.setOnAction(e-> window.close());

		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(label, exit);
		vbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vbox);
		String css1 = ChatApplication.class.getResource("openingScene.css").toExternalForm();
		scene.getStylesheets().add(css1);
		window.setScene(scene);
		window.showAndWait();


	}

}
