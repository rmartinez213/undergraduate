package MRChatApplicationFinal2;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.geometry.Pos; 

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Stage;

public class MessageSent {
	static ArrayList<SocketList> connect = new ArrayList<SocketList>();
	static Stage window;
	static Label label, label2; //label2 will retreive data
	static Button exit, client2;
	public static void display(String title, String message, int id, String textArea){
		 window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);

		label = new Label(message + " " + id);
		System.out.println("Sent!");
		

		exit = new Button("Exit window");
		exit.setOnAction(e-> window.close());
		exit.setId("exit");

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
