package MRChatApplicationFinal2;
import java.awt.Color;
import java.awt.Frame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChatApplication extends Application {
	Stage window;
	String css1;
	Button newConnection, submit,connectionButton, backButton, send, terminateButton;
	ComboBox<String> comboBox;
	Scene scene1,scene3, sceneIP, scenePort, scene5, scene6,sceneTerminate, scene8;//will add more scenes
	int portInputNumber;
	static Socket socket;
	static ArrayList<SocketList> connect = Server.getList();
	static int id = 1;

	//getting input and output  stream
	static DataInputStream in;
	//getting output
	static DataOutputStream out;
	
	//
	static JFrame frame = new JFrame("Message!");

	public static void main(String[] args){
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		window.setTitle("MR Chat Application");

		Label introduction = new Label("Directions: ");
		Label step1 = new Label("1. Ready to chat? Click on New Chat to initialize the server.");
		Label step2 = new Label("2. Not sure in what you want to do? The help drop down menu can help you out!");

		//New Connection Button
		newConnection = new Button("New Chat");
		newConnection.setId("newConnection-button");
		//when user clicks the New Chat button it will direct them to Scene2
		newConnection.setOnAction(e-> StartServerWindow.display("Server", "The server has started...")); // Scene 2

		//submit button
		submit = new Button("Submit");
		submit.setId("submit-button1");


		//command option button ->  myip, myport,connection, list, terminate, send, exit
		comboBox = new ComboBox<>();
		comboBox.setId("comboBox-menu");
		comboBox.getItems().addAll("myip","myport","connection","list","terminate","send","exit");

		//set prompt text to "help" so users can pick what they want
		comboBox.setPromptText("Help");
		comboBox.setStyle("-fx-text-fill: purple");

		//When user clicks submit it will change scene depending what the user clicks
		submit.setOnAction(e -> {
			try {
				getCommandOption();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});


		//Vbox that implements introduction, step1, and step2
		VBox instructionBox = new VBox(6);
		instructionBox.getChildren().addAll(introduction, step1, step2);
		instructionBox.setAlignment(Pos.CENTER);

		//Hbox to implement newConnection, comboBox, and submit
		HBox menuBox = new HBox(6);
		menuBox.getChildren().addAll(newConnection, comboBox, submit);
		menuBox.setAlignment(Pos.BOTTOM_CENTER);

		//BorderPane sets the instructionBox to the center and sets menuBox to the bottom
		BorderPane pane = new BorderPane();
		pane.setCenter(instructionBox);
		pane.setBottom(menuBox);
		//Scene1
		scene1 = new Scene(pane,500,450);
		css1 = ChatApplication.class.getResource("openingScene.css").toExternalForm();
		scene1.getStylesheets().add(css1);
		window.setScene(scene1);
		window.show();
	}


	private void getCommandOption() throws IOException {


		//if user chooses myip
		if(comboBox.getValue() == "myip"){
			/*
			 * --- User clicks myip- Scene 3 Client Side will display and 
			 * return ip address
			 */

			//Back buttons to return to main menu 
			backButton = new Button("Return to Menu");
			backButton.setOnAction(e -> window.setScene(scene1));
			backButton.setId("ReturnMenu");
			//Create Hbox to implement Label and Button
			VBox IPBox = new VBox(5);

			//Creates the scene and implements the HBox
			BorderPane paneIP = new BorderPane();
			Label IP = new Label(IPAddress()); 
			IPBox.getChildren().addAll(IP, backButton);
			IPBox.setAlignment(Pos.CENTER);

			sceneIP = new Scene(IPBox,550,450);
			sceneIP.getStylesheets().add(css1);
			window.setScene(scene1);
			window.show();
			window.setScene(sceneIP);
		}
		//if user chooses myport
		if(comboBox.getValue() == "myport"){
			/*
			 * -- User clicks myport- Scene 4 client side will display port number		
			 */

			//Back buttons to return to main menu 
			backButton = new Button("Return to Menu");
			backButton.setOnAction(e -> window.setScene(scene1));
			backButton.setId("ReturnMenu");
			//Create Hbox to implement Port Label and back Button
			VBox PortBox = new VBox(5);

			BorderPane panePort = new BorderPane();
			Label Port = new Label(PortNumber());
			PortBox.getChildren().addAll(Port, backButton);
			PortBox.setAlignment(Pos.CENTER);

			scenePort = new Scene(PortBox,550,450);
			scenePort.getStylesheets().add(css1);
			window.setScene(scene1);
			window.show();
			window.setScene(scenePort);
		}
		//if user chooses connection
		if(comboBox.getValue() == "connection"){

			/*
			 * ----- User clicks connection- Sciene 5 client side; user will be inputing 
			 * ip address and port number that they want to connect to
			 */
			// Create label for host, TextField for user can enter IP Address, Label for Port, and TextFirled for user can enter the port number they want to connect to
			Label host = new Label("Host");
			TextField ipInput = new TextField("Enter IP Address");
			Label port = new Label("Port");
			TextField portInput = new TextField("Enter Port Number");


			connectionButton = new Button("Connect"); //When user clicks connect it will go to another method 
			connectionButton.setOnAction(e -> isInt(ipInput, portInput, ipInput.getText(), portInput.getText()));
			connectionButton.setId("connectionButtton");
			//Back buttons to return to main menu 
			backButton = new Button("Return to Menu");
			backButton.setOnAction(e -> window.setScene(scene1));
			backButton.setId("ReturnMenu");

			//HBox
			HBox usersInput = new HBox(5);
			usersInput.getChildren().addAll(host,ipInput,port,portInput,connectionButton, backButton);
			usersInput.setAlignment(Pos.CENTER);

			scene5 = new Scene(usersInput,800,450);

			scene5.getStylesheets().add(css1);
			window.setScene(scene1);
			window.show();
			window.setScene(scene5);
		}
		//if user chooses list,
		if(comboBox.getValue() == "list"){
			/*
			 * ----- User clicks list will direct them to another Scene where it displays all the ip address with their ports
			 */

			Label displayList = new Label(displayList());
			HBox displayBox = new HBox();
			backButton = new Button("Return to Menu");
			backButton.setOnAction(e -> window.setScene(scene1));
			backButton.setId("ReturnMenu");
			displayBox.getChildren().add(backButton);
			displayBox.setAlignment(Pos.BOTTOM_CENTER);

			BorderPane display = new BorderPane();
			display.setCenter(displayList);
			display.setBottom(displayBox);

			scene6 = new Scene(display,800,450);

			scene6.getStylesheets().add(css1);
			window.setScene(scene1);
			window.show();
			window.setScene(scene6);

		}
		//if user chooses terminate
		if(comboBox.getValue() == "terminate"){
			//Text field to ather user's input
			Label label = new Label("Terminate:");
			TextField idInput = new TextField("Enter the ID you want to terminate");

			//Backbuttons 
			backButton = new Button("Return to Menu");
			backButton.setOnAction(e -> window.setScene(scene1));
			backButton.setId("ReturnMenu");

			//Button that calls the terminate action
			terminateButton = new Button("Terminate");
			terminateButton.setOnAction(e -> Terminate(idInput));
			terminateButton.setId("terminateButton");


			//Create Hbox to implement Label and Button
			HBox TerminateBox = new HBox(5);

			//scenePort -- Displays scene 4 client side
			BorderPane pane = new BorderPane();
			TerminateBox.getChildren().addAll(label, idInput, terminateButton, backButton);
			TerminateBox.setAlignment(Pos.CENTER);

			sceneTerminate = new Scene(TerminateBox,550,450);
			sceneTerminate.getStylesheets().add(css1);
			window.setScene(scene1);
			window.show();

			window.setScene(sceneTerminate);	
		}
		//if user chooses send
		if(comboBox.getValue() == "send"){

			/*
			 * --- User clicks the send from the drop down menu - Scene 8 client side of message - 
			 */

			//Create a welcome Label, a label that displays the ip address they are messaging
			Label welcomeClient= new Label("Welcome to the MR Chat Application"); //try to get this top center
			TextField idInput = new TextField("Enter ID");
			//add welcomeClient and id to VBox
			VBox WelcomeIP = new VBox();
			WelcomeIP.getChildren().addAll(welcomeClient, idInput);
			WelcomeIP.setAlignment(Pos.TOP_CENTER);
			//add  textArea to textBox
			VBox textBox = new VBox(5); //change name of every box
			TextArea textArea = new TextArea();
			//get textArea

			final int MAX_CHAR = 100;//limit the characters to 100 including spaces
			textArea.setTextFormatter(new TextFormatter<String>(change -> 
			change.getControlNewText().length() <= MAX_CHAR ? change : null));
			textBox.getChildren().add(textArea);

			HBox box9 = new HBox(5);
			send = new Button("Send");
			send.setAlignment(Pos.BASELINE_RIGHT);
			send.setOnAction(e -> SendMessage(idInput.getText(), textArea.getText()));
			send.setId("sendButton");
			backButton = new Button("Return to Menu");
			backButton.setOnAction(e -> window.setScene(scene1));
			backButton.setId("ReturnMenu");
			box9.getChildren().addAll(send, backButton);
			box9.setAlignment(Pos.BASELINE_CENTER);

			BorderPane pane8 = new BorderPane();
			pane8.setTop(WelcomeIP);
			pane8.setCenter(textBox);
			pane8.setBottom(box9);

			scene8 = new Scene(pane8,650,550);

			scene8.getStylesheets().add(css1);
			window.setScene(scene1);
			window.show();
			window.setScene(scene8);

		}
		//if user chooses exit, the program will exit...
		if(comboBox.getValue() == "exit"){
			window.close();
		}
	}

	private void SendMessage(String idString, String message){


		int id = Integer.parseInt(idString);

		for(final SocketList x : connect){	
			if(x.getId() == id){

				try {
					in = new DataInputStream(x.getSockets().getInputStream());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				MessageSent.display("MR Chat Application", "The message was sent to: ", id, "\rHere is your message: " + message);

				try {
					out = new DataOutputStream(x.getSockets().getOutputStream());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// create the thread that will be sending the message  
				Thread sendMessage = new Thread(new Runnable(){

					@Override
					public void run() {
						while(true){
							//read the message to deliver
							//label2 = new Label(textArea);

							//testing to read the message to deliver
							String msg = message;

							try{
								//write the output stream
								out.writeUTF("Message was sent from: " + IPAddress() + "\rSender's Port: " + PortNumber() + "\rMessage: " + msg);
								out.flush();

							} catch (IOException e){
								e.printStackTrace();
							}
							break;
						}
					}
				});
				
				

				// create the thread that will be reading the message
				
				Thread readMessage = new Thread(new Runnable(){
					

					@Override
					public void run() {
						while(true){
							try{
								//read the message that was sent from the thread send Message
								//Label message = new Label(in.readUTF());

								String msg = in.readUTF();
								
								System.out.println(msg);
								
								//Set frame style
								frame.setSize(500, 400);
								frame.setBackground(Color.green);
								
								
								JOptionPane.showMessageDialog(frame, msg);


								//ConnectionValidation.display("MR Chat Application", msg);

							} catch(IOException e){
								e.printStackTrace();
							}
							break;
						}
					}
				});
				sendMessage.start();
				readMessage.start();
			}
		}
	}


	//validate the ip and port number
	private void isInt(TextField ipInput,TextField port,  String ip, String portNumber) {

		//Socket creation
		try {
			socket = new Socket (ip, Integer.parseInt(portNumber));
			connect.add(new SocketList(id, ip, portNumber, null, null, socket));
			id++;

			if(socket.isConnected() == true){
				ConnectionValidation.display("MR Chat Application", "The client has been connected...");
				System.out.println("You are connected to the server.");
			}

			//IF user enters the incorrect ip and or port number will display an alert box notifying the user
		} catch (NumberFormatException e1) {
			ConnectionValidation.display("Connection", "Incorrect IP/Port Number");
		} catch (UnknownHostException e1) {
			ConnectionValidation.display("Connection", "Incorrect IP/Port Number");
		} catch (IOException e1) {
			ConnectionValidation.display("Connection", "Incorrect IP/Port Number");
		}
	}

	//Displays the IP Address to the user in sceneIP and returns IP Address for other methods
	private String IPAddress(){
		try {
			String IP = Inet4Address.getLocalHost().getHostAddress();
			return IP;
		} catch (UnknownHostException e) {

			System.out.println("There was an error with the IP address you entered. Please Re-Enter the IP address.");
		}
		return null;
	}
	//PortNumber
	private String PortNumber(){

		for(SocketList list: connect){
			try{
				if(list.getSockets().isConnected()){
					String PortNumber = socket.getLocalPort() + "";
					return  PortNumber;
				}
			} catch (Throwable e){
				return "4444";
			}
		}
		return "There is no socket connected yet. Return to Main Menu and Connect first.";
	}

	private String displayList(){
		
		
		for(SocketList list: connect){
			System.out.println(connect.get(0).getSockets().isConnected());
			
			
			return "id:\t IP address\t\t\tPort No.\r" +
					list.getId() + ":      " + list.getIpAddress() + "\t\t\t" + list.getPortNumber();
		}
		return "You have not connected yet! Go back to main menu!!!!!!";
	}

	//need to figure out what to actually return if there isn't an id?? 
	private int displayId(){
		for(final SocketList list: connect){
			return list.getId();
		}
		return 0;
	}

	//Pass in the arraylist
	private void Terminate(TextField idInput){
		for(SocketList x : connect){
			int validateX = Integer.parseInt(idInput.getText().trim());
			if(validateX == x.getId()){
				try {
					connect.remove(validateX - 1);
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Client Removed");
				}
//					try {
//						x.getSockets().close();
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					try {
//						x.getOutData().close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					try {
//						x.getInData().close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				connect.remove(validateX - 1);
	//			try {
//					x.getSockets().close();
					//System.out.println("After closing socket");
	//			} catch (IOException e) {
					//System.out.println("Socket Close Error");
					
//					x.getSockets();
					
				}
				ConnectionValidation.display("Termination", "The connection has been terminated");
				break;
			}
//			else{
//				ConnectionValidation.display("Termination", "Incorrect ID. Nothing was terminated.");
//			}
		
		ConnectionValidation.display("Termination", "Incorrect ID. Nothing was terminated.");
	}
}
