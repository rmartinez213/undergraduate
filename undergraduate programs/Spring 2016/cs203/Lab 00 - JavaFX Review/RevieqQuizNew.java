
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;




public class ReviewQuizNew extends Application {

	final int WIDTH = 500, HEIGHT = 400;
	final int T = 5, L = 5, B = 5, R = 5, SIZE = 10;
	final double FONTSIZE = 12.0;
	BorderPane pane = new BorderPane();
	//bottom [ add Up and Down button ]
	Button[] button = {new Button("Left"), new Button("Right"), new Button("Up"), new Button("Down")};
	//right [add Regular ]
	CheckBox[] checkBox = {new CheckBox("Bold"), new CheckBox("Italic"), new CheckBox("Underline")};
	//left [add Blue and Black]
	ToggleGroup toggleGroup = new ToggleGroup();
	RadioButton[] radioButton = {new RadioButton("Red"), new RadioButton("Green"), new RadioButton("Blue"), new RadioButton("Black"), new RadioButton("Orange"), new RadioButton("Pink")};
	//top [add Font size]
	ComboBox<String> comboBox = new ComboBox<>();
	ComboBox<Integer> comboBox2 = new ComboBox<>();

	boolean isUnderLine = true;

	//center
	Text text = new Text();
	TextField centerText = new TextField("Programming is fun!");

	ScrollBar hScrollBar = new ScrollBar();

	//implement vertical ScrollBar
	ScrollBar vScrollBar = new ScrollBar();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		setUI();

		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setTitle("JavaFX quiz");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void setUI(){
		//bottom [ implement Up and Down button]
		FlowPane fp = new FlowPane(T, L);
		for(int i = 0; i < button.length; i++){
			fp.getChildren().add(button[i]);
			button[i].setOnAction(this::setPosition);
		}

		fp.setAlignment(Pos.CENTER);
		pane.setBottom(fp);

		
		//right
		VBox rightVBox = new VBox(T);
		rightVBox.setPadding(new Insets(T,L,B,R));
		rightVBox.setAlignment(Pos.CENTER_LEFT);

		for(int i = 0; i < checkBox.length; i++){
			rightVBox.getChildren().add(checkBox[i]);
			checkBox[i].setOnAction(this::setPostureWeight);
		}

		pane.setRight(rightVBox);

		//left

		VBox leftVBox = new VBox(T);
		leftVBox.setPadding(new Insets(T,L,B,R));
		leftVBox.setAlignment(Pos.CENTER_LEFT);

		for(int i = 0; i < radioButton.length; i++){
			radioButton[i].setToggleGroup(toggleGroup);
			radioButton[i].setOnAction(this::setColor);
			leftVBox.getChildren().add(radioButton[i]);
		}

		pane.setLeft(leftVBox);

		//top 

		HBox[] hBox = {new HBox(R), new HBox(5)};
		hBox[0].getChildren().addAll(new Label("Select Font Style"), comboBox, new Label("Select Font Size"), comboBox2);
		comboBox.getItems().addAll(Font.getFamilies());
		comboBox.setOnAction(this::setFont);	


		//implement font size combobox
		hBox[1].getChildren().addAll(new Label("Enter new message."), centerText);
		comboBox2.getItems().addAll(8, 9, 10, 11, 12);
		comboBox2.setOnAction(this::setFontSize);

		VBox topVBox = new VBox(R);
		for(int i = 0; i < hBox.length; i++){
			topVBox.getChildren().add(hBox[i]);
			hBox[i].setPadding(new Insets(T,L,B,R));
			hBox[i].setAlignment(Pos.CENTER_LEFT);
		}

		centerText.setAlignment(Pos.BOTTOM_RIGHT);
		centerText.setPrefWidth(WIDTH/2);

		pane.setTop(topVBox);

		//center
		BorderPane centerBorderPane = new BorderPane();
		Pane centerPane = new Pane();
		centerPane.getChildren().addAll(text);
		text.setX(centerPane.getWidth()/2);
		text.setY(HEIGHT/2);
		text.setText(centerText.getText());
		centerBorderPane.setCenter(centerPane);
		centerBorderPane.setBottom(hScrollBar);
		centerBorderPane.setLeft(vScrollBar);
		centerText.setOnAction(this::centerTextAction);
		pane.setCenter(centerBorderPane);

		hScrollBar.valueProperty().addListener(new InvalidationListener(){
			public void invalidated(Observable ov){
				text.setX((hScrollBar.getValue() * centerPane.getWidth()/hScrollBar.getMax()) + 30);
			}
		});

		//Changes the scroll bar vertically
		vScrollBar.setOrientation(Orientation.VERTICAL);

		//implement vertical ScrollBar
		vScrollBar.valueProperty().addListener(new InvalidationListener(){
			public void invalidated(Observable ov){
				text.setY((vScrollBar.getValue() * centerPane.getHeight()/vScrollBar.getMax()) + 30);
			}
		});

	}

	public void setPosition(ActionEvent e){
		if (e.getSource() == button[0]){
			text.setX(text.getX() - SIZE);
		}else if (e.getSource() == button[1]){
			text.setX(text.getX() + SIZE);
		}
		else if(e.getSource() == button[2]){
			text.setY(text.getY() - SIZE);
		}
		else if(e.getSource() == button[3]){
			text.setY(text.getY() + SIZE);
		}
		if(text.getY() > text.getY() + SIZE){
			text.setY(vScrollBar.getValue());
		}
		if(text.getX() > text.getX() + SIZE) {
			text.setX(hScrollBar.getValue());
		}
	}

	public void setPostureWeight(ActionEvent e){
		if(checkBox[0].isSelected()){
			if(checkBox[1].isSelected()){
				text.setFont(Font.font((text.getFont()).getName(), FontWeight.BOLD, FontPosture.ITALIC, text.getFont().getSize()));
			}
			else{
				text.setFont(Font.font((text.getFont()).getName(), FontWeight.BOLD, text.getFont().getSize()));
			}
		}else{
			if (checkBox[1].isSelected()){
				text.setFont(Font.font((text.getFont()).getName(), FontPosture.ITALIC, text.getFont().getSize()));
			}
			else{
				text.setFont(Font.font((text.getFont()).getName(), FontWeight.NORMAL, FontPosture.REGULAR, text.getFont().getSize()));
			}
		}
		if(checkBox[2].isSelected()){
			text.setUnderline(true);
		}
		else{
			text.setUnderline(false);
		}

	}

	public void setColor(ActionEvent e){
		if (e.getSource()==(radioButton[0])){
			text.setStroke(Color.RED);
		} else if (e.getSource()==(radioButton[1])){
			text.setStroke(Color.GREEN);
		}
		else if(e.getSource()==(radioButton[2])){
			text.setStroke(Color.BLUE);
		}
		else if(e.getSource()==(radioButton[3])){
			text.setStroke(Color.BLACK);
		}
		else if(e.getSource()==(radioButton[4])){
			text.setStroke(Color.ORANGE);
		}
		else if(e.getSource()==(radioButton[5])){
			text.setStroke(Color.PINK);
		}

	}

	public void setFont(ActionEvent e){
		text.setFont(Font.font(comboBox.getValue()));
	}

	public void setFontSize(ActionEvent e){
		//implement
		text.setFont(Font.font(comboBox2.getValue()));

	}

	public void centerTextAction(ActionEvent e){
		text.setText(centerText.getText());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

}