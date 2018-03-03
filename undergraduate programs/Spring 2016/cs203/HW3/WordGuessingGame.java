
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WordGuessingGame extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {


		//Creates border pane for scene
		BorderPane BorderPane = new BorderPane(); 
		TextField TextF = new TextField("Enter Your Letter Here...");
		//Creates 2 nodes, one node that displays center. The other node that display on the top.
		Text DisplayTxt = new Text();
		Text DisplayWrongTxt = new Text();

		//Create the circles necessary for the program.		
		Ellipse CShape = new Ellipse(200, 200, 40, 40);
		Ellipse CShape2 = new Ellipse(200, 200, 40, 40);
		Ellipse CShape3 = new Ellipse(200, 200, 40, 40);
		Ellipse CShape4 = new Ellipse(200, 200, 40, 40);
		Ellipse CShape5 = new Ellipse(200, 200, 40, 40);
		Ellipse CShape6 = new Ellipse(200, 200, 40, 40);
		Ellipse CShape7 = new Ellipse(200, 200, 40, 40);
		Ellipse TopBlank1 = new Ellipse(200, 200, 40, 20);
		Ellipse TopBlank2 = new Ellipse(200, 200, 40, 20);



		//Sets the color
		CShape.setFill(Color.MAROON);
		CShape2.setFill(Color.MAROON);
		CShape3.setFill(Color.MAROON);
		CShape4.setFill(Color.MAROON);
		CShape5.setFill(Color.MAROON);
		CShape6.setFill(Color.MAROON);
		CShape7.setFill(Color.MAROON);

		//Sets the Opacity to each circle
		CShape.setOpacity(.14);
		CShape2.setOpacity(0.28);
		CShape3.setOpacity(0.42);
		CShape4.setOpacity(0.56);
		CShape5.setOpacity(0.70);
		CShape6.setOpacity(84);
		CShape7.setOpacity(1);
		//Sets the top circle to no opacity, in order to pad text to the center...
		TopBlank1.setOpacity(0);
		TopBlank2.setOpacity(0);


		//This sets the HORIZONTAL box for TOP
		HBox HorzBoxTop = new HBox();
		HorzBoxTop.setSpacing(30);
		HorzBoxTop.getChildren().addAll(TopBlank1, DisplayWrongTxt, TopBlank2);


		//This sets the VERTICAL boxes on the LEFT and adds circles to the boxes
		VBox VertBoxLeft = new VBox();
		VertBoxLeft.setSpacing(10);
		VertBoxLeft.getChildren().addAll(CShape, CShape2, CShape3);
		BorderPane.setLeft(VertBoxLeft);


		//This sets the VERTICAL box on the RIGHT and adds circles to the boxes
		VBox VertBoxRight = new VBox();
		VertBoxRight.setSpacing(10);
		VertBoxRight.getChildren().addAll(CShape4, CShape5, CShape6, CShape7);
		BorderPane.setRight(VertBoxRight);

		//Generate a word using a random
		int GenWord = 0 + (int)(Math.random() * (18 - 0 + 1));

		String[] WordList = {"butter", "playstation", "classroom", "building", "free", "world",
				"pizza", "biology", "paper", "sociology", "science", "food", "cellular", "toilet", "college",
				"pin", "table", "movies", "trumpet", "enter"
		};


		System.out.println(WordList[GenWord]);

		//Variable types the spaces needed for user to guess the word.
		String spaces = "";

		for(int i = 0 ; i < WordList[GenWord].length() ; i++){
			spaces += "_";
		}

		DisplayTxt.setText(spaces);


		TextF.setOnKeyPressed(new EventHandler<KeyEvent>(){
			boolean count = true;
			int CountAttempt = 8;
			int CountWin = 0;
			String WrongLetters = "";
			String RightLetters = "";
			boolean setup = true;

			@Override
			public void handle(KeyEvent e){

				if(e.getCode() == KeyCode.ENTER && TextF.getText().matches("\\d+")){
					DisplayTxt.setText("You can't enter numbers! -.-");
					TextF.clear();
				}

				else{
					if((e.getCode() == KeyCode.ENTER) && setup){
						for(int n = 0 ; n < WordList[GenWord].length() ; n++){
							RightLetters += "_";
						}
						setup = false;
					}

					if((e.getCode() == KeyCode.ENTER)){

						for(int i = 0; i < WordList[GenWord].length() ; i++){

							if((WordList[GenWord].substring(i, i + 1).equalsIgnoreCase(TextF.getText()) && !WordList[GenWord].substring(i, i+1).equals(RightLetters.substring(i, i+1)))){

								RightLetters = RightLetters.substring(0, i) + TextF.getText().toLowerCase() + RightLetters.substring(i + 1, WordList[GenWord].length());
								count = false;
								DisplayTxt.setText(RightLetters);
								DisplayWrongTxt.setText("You are correct! :)");
								CountWin += 1;
							}

							else if (WordList[GenWord].substring(i, i+1).equals(RightLetters.substring(i, i+1)) && WordList[GenWord].substring(i, i + 1).equalsIgnoreCase(TextF.getText())){
								DisplayWrongTxt.setText("You can't enter the same letter. -.-\r"
										+ "Letters Guessed: " + WrongLetters + "\rYou have "
										+ CountAttempt + " attempts.\rYou were not penalized.");
								count = false;
							}
						}	
					}

					if(e.getCode() == KeyCode.ENTER){
						for(int i = 0 ; i < WrongLetters.length() ; i++){
							if(WrongLetters.substring(i, i + 1).equals(TextF.getText())){
								DisplayWrongTxt.setText("You can't enter the same letter. -.-\r"
										+ "Letters Guessed: " + WrongLetters + "\rYou have "
										+ (CountAttempt - 1) + " attempts.\rYou were not penalized.");
								count = false;
							}
						}
					}

					//If user input more then 2 string character, then displays error
					if ((e.getCode() == KeyCode.ENTER) && (TextF.getText().length() != 1)){
						DisplayWrongTxt.setText("You entered more than 1 letter :o\r"
								+ "Letters Guessed: " + WrongLetters + "\rYou have "
								+ (CountAttempt - 1) + " attempts.\rYou were not penalized.");
						count = false;
					}

					//Returns the wrong guessed letters.
					if ((e.getCode() == KeyCode.ENTER) && (count)){
						CountAttempt--;
						System.out.println();
						WrongLetters += TextF.getText() + " ";
						DisplayWrongTxt.setText("You are wrong! :( \r" + "Letters Guessed: " + WrongLetters + "\rYou have "
								+ (CountAttempt - 1) + " attempts.");

						switch(CountAttempt){

						case 1: CShape.setRadiusX(0);
						CShape.setRadiusY(0);
						break;

						case 2: CShape2.setRadiusX(0);
						CShape2.setRadiusY(0);
						break;

						case 3: CShape3.setRadiusX(0);
						CShape3.setRadiusY(0);
						break;

						case 4: CShape4.setRadiusX(0);
						CShape4.setRadiusY(0);
						break;

						case 5: CShape5.setRadiusX(0);
						CShape5.setRadiusY(0);
						break;
						case 6: CShape6.setRadiusX(0);
						CShape6.setRadiusY(0);
						break;

						case 7: CShape7.setRadiusX(0);
						CShape7.setRadiusY(0);
						break;
						}
					}

					//If player loses display message if they want to play again
					if(CountAttempt == 1){
						DisplayTxt.setText("YOU LOST! >:( \r" + "The word was: " + WordList[GenWord]
								+ "\rWould you like to play again (Type yes or no)?");
						DisplayWrongTxt.setText("");

						if((e.getCode() == KeyCode.ENTER) && TextF.getText().equalsIgnoreCase("yes")){
							try {
								start(primaryStage);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
						else if((e.getCode() == KeyCode.ENTER) && TextF.getText().equalsIgnoreCase("no")){
							System.exit(0);
						}
					}

					//If player wins display message if they want to play again
					if((e.getCode() == KeyCode.ENTER) && CountWin == WordList[GenWord].length()){
						DisplayTxt.setText("You win!! :D \r" + "The word was: " + RightLetters 
								+ "\rWould you like to play again (yes or no)?");
						DisplayWrongTxt.setText("");

						if((e.getCode() == KeyCode.ENTER) && (TextF.getText().equalsIgnoreCase("yes"))){
							try {
								start(primaryStage);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}

						else if((e.getCode() == KeyCode.ENTER) && TextF.getText().equalsIgnoreCase("no")){
							System.exit(0);
						}
					}

					if ((e.getCode() == KeyCode.ENTER)){
						TextF.clear();
					}
				}
				count = true;
			}
		});

		BorderPane.setBottom(TextF);
		BorderPane.setCenter(DisplayTxt);
		BorderPane.setTop(HorzBoxTop);


		Scene scene = new Scene(BorderPane, 400, 450); //Set the scene
		primaryStage.setTitle("Guessing Game"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
