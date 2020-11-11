import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.HashMap;

public class CoffeeShop extends Application implements EventHandler {


	HashMap<String, Scene> sceneMap;
	ArrayList<Integer> amounts;

	// Buttons for selecting the sizes of the coffee
	Button small = new Button("Basic");
	Button medium = new Button("Medium");
	Button large = new Button("Large");
	Button extra_large = new Button("Extra Large");

	// number of items
	Text cream_button_text = new Text();
	Text extra_shot_button_text = new Text();
	Text sugar_button_text = new Text();
	Text chocolate_button_text = new Text();
	Text mint_button_text = new Text();

	// cost per item
	Text cream_amount = new Text();
	Text extra_shot_amount = new Text();
	Text sugar_amount = new Text();
	Text chocolate_amount = new Text();
	Text mint_amount = new Text();

	int resized_coffee = 1;

	String output_cost;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		amounts = new ArrayList<Integer>(5);
		output_cost = "Black Coffee: $3.99\n";
		for(int i = 0; i < 5; i++) amounts.add(0);
		sceneMap = new HashMap<String, Scene>();
		sceneMap.put("start", create_start_order());
		primaryStage.setTitle("Coffee Shop");
		String intro = "WELCOME TO COZMO'S\n";
		Button start_simulator = new Button("Start Order");
		start_simulator.setStyle("-fx-background-color: #ffffff; ");
		start_simulator.setOnAction(e -> primaryStage.setScene(sceneMap.get("start")));

		Text text = new Text();
		text.setText(intro);
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		text.setFill(Color.GOLD);
		text.setStrokeWidth(2);
		text.setStroke(Color.TOMATO);

		VBox basic_items = new VBox(text, start_simulator);
		basic_items.setAlignment(Pos.CENTER);
		basic_items.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, null, null)));

		Scene scene = new Scene(basic_items,450,450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Scene create_start_order() {

		Text text = new Text();
		text.setText("COZMO's COFFEE SHOP");
		text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		text.setFill(Color.GOLD);
		text.setStrokeWidth(2);
		text.setStroke(Color.TOMATO);
		HBox title = new HBox(text);
		title.setAlignment(Pos.CENTER);

//		Text selection = new Text();
//		selection.setText(" Default Selection: Basic");
//		selection.setFont(Font.font("verdana", FontPosture.REGULAR, 13));

		Text select_size = new Text();
		select_size.setText(" Select Size :");
		select_size.setFont(Font.font("verdana", FontPosture.REGULAR, 13));


		small.setId("small_coffee");
		small.setStyle("-fx-background-color: #edbfb9; ");
		medium.setId("medium_coffee");
		medium.setStyle("-fx-background-color: #ffffff; ");
		large.setId("large_coffee");
		large.setStyle("-fx-background-color: #ffffff; ");
		extra_large.setId("extra_large_coffee");
		extra_large.setStyle("-fx-background-color: #ffffff; ");

		// set on action for buttons
		small.setOnAction(this);
		medium.setOnAction(this);
		large.setOnAction(this);
		extra_large.setOnAction(this);

		HBox size_selection = new HBox(select_size, small, medium, large, extra_large);
		size_selection.setSpacing(20);

		Text select_add_ons = new Text();
		select_add_ons.setText("SELECT OPTIONAL ADD-ONS");
		select_add_ons.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
		HBox add_ons_text = new HBox(select_add_ons);
		add_ons_text.setAlignment(Pos.CENTER);

		Button cream_button = new Button("   Cream  ");
		cream_button.setStyle("-fx-background-color: #ffffff; ");
		Button extra_shot_button = new Button(" ExtraShot");
		extra_shot_button.setStyle("-fx-background-color: #ffffff; ");
		Button sugar_button = new Button("    Sugar   ");
		sugar_button.setStyle("-fx-background-color: #ffffff; ");
		Button chocolate_button = new Button("Chocolate");
		chocolate_button.setStyle("-fx-background-color: #ffffff; ");
		Button mint_button = new Button("     Mint    ");
		mint_button.setStyle("-fx-background-color: #ffffff; ");

		// set button IDs
		cream_button.setId("cream");
		extra_shot_button.setId("extra_shot");
		sugar_button.setId("sugar");
		chocolate_button.setId("chocolate");
		mint_button.setId("mint");

		// set button actions
		cream_button.setOnAction(this);
		extra_shot_button.setOnAction(this);
		sugar_button.setOnAction(this);
		chocolate_button.setOnAction(this);
		mint_button.setOnAction(this);

		refresh_text();
		VBox names = new VBox(cream_button, extra_shot_button, sugar_button, chocolate_button, mint_button);
		names.setSpacing(15);
		VBox texts = new VBox(cream_button_text, extra_shot_button_text, sugar_button_text, chocolate_button_text, mint_button_text);
		texts.setSpacing(27);
		VBox amounts = new VBox(cream_amount, extra_shot_amount, sugar_amount, chocolate_amount, mint_amount);
		amounts.setSpacing(27);
		HBox add_ons = new HBox(names, texts, amounts);
		add_ons.setSpacing(30);
		add_ons.setAlignment(Pos.CENTER);

		Button place_order = new Button("Place\nOrder");
		place_order.setId("place_order");
		place_order.setOnAction(this);
		place_order.setStyle("-fx-background-color: #ffffff; ");

		Button start_over = new Button("Start\nOver");
		start_over.setId("start_over");
		start_over.setOnAction(this);
		start_over.setStyle("-fx-background-color: #ffffff; ");

		HBox last_line = new HBox(start_over, place_order);
		last_line.setAlignment(Pos.CENTER);
		last_line.setSpacing(250);

		VBox main_root = new VBox(title, size_selection, add_ons_text, add_ons, last_line);
		main_root.setSpacing(30);
		main_root.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, null, null)));
		return new Scene(main_root, 450, 450);


	}

	public void refresh_text(){
		cream_button_text.setText("x 0");
		cream_button_text.setFont(Font.font("verdana", FontPosture.REGULAR, 12));

		extra_shot_button_text.setText("x 0");
		extra_shot_button_text.setFont(Font.font("verdana", FontPosture.REGULAR, 12));

		sugar_button_text.setText("x 0");
		sugar_button_text.setFont(Font.font("verdana", FontPosture.REGULAR, 12));

		chocolate_button_text.setText("x 0");
		chocolate_button_text.setFont(Font.font("verdana", FontPosture.REGULAR, 12));

		mint_button_text.setText("x 0");
		mint_button_text.setFont(Font.font("verdana", FontPosture.REGULAR, 12));

		cream_amount.setText("$0.00");
		cream_amount.setFont(Font.font("verdana", FontPosture.REGULAR, 12));

		extra_shot_amount.setText("$0.00");
		extra_shot_amount.setFont(Font.font("verdana", FontPosture.REGULAR, 12));

		sugar_amount.setText("$0.00");
		sugar_amount.setFont(Font.font("verdana", FontPosture.REGULAR, 12));

		chocolate_amount.setText("$0.00");
		chocolate_amount.setFont(Font.font("verdana", FontPosture.REGULAR, 12));

		mint_amount.setText("$0.00");
		mint_amount.setFont(Font.font("verdana", FontPosture.REGULAR, 12));
	}

	public void resultsAlert() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Order Details");
		alert.setContentText(output_cost);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		Image image = new Image("coffee.png");
		ImageView imageView = new ImageView(image);
		alert.setGraphic(imageView);
		alert.show();
		alert.setOnCloseRequest(e-> start_over());
	}

	public void start_over(){
		for(int i = 0; i < 5; i++) amounts.set(i, 0);
		refresh_text();
		output_cost = "Black Coffee: $3.99\n";
		resized_coffee = 1;
		small.setStyle("-fx-background-color: #edbfb9; ");
		medium.setStyle("-fx-background-color: #ffffff; ");
		large.setStyle("-fx-background-color: #ffffff; ");
		extra_large.setStyle("-fx-background-color: #ffffff; ");
	}

	@Override
	public void handle(Event event) {
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("place_order")){
			Coffee order = new BasicCoffee();
			for(int i = 0; i < amounts.size(); i++){
				for(int j = 0; j < amounts.get(i); j++){
					if(i == 0) { order = new Cream(order); output_cost += "+ cream: $.50\n";}
					else if(i == 1) { order = new ExtraShot(order); output_cost +=  " + extra shot: $1.20\n";}
					else if(i == 2) { order = new Sugar(order); output_cost += " + sugar: $.50\n";}
					else if(i == 3) { order = new Chocolate(order); output_cost += " + chocolate: $1.00\n";}
					else if(i == 4) { order = new Mint(order); output_cost += " + mint: $.50\n";}
				}
			}
			if(resized_coffee == 2) { order = new Medium(order); output_cost += " + medium : $1.50\n";}
			else if(resized_coffee == 3) { order = new Large(order); output_cost += " + large : $1.75\n";}
			else if(resized_coffee == 4) { order = new ExtraLarge(order); output_cost += " + extra large : $2.00\n";}

			double cost = order.makeCoffee();
			output_cost += "Total: $"+ cost;
			resultsAlert();

		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("cream")){
			amounts.set(0, amounts.get(0)+1);
			cream_button_text.setText("x "+amounts.get(0));
			cream_amount.setText("$" + (0.50 * amounts.get(0)));

		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("extra_shot")){
			amounts.set(1, amounts.get(1)+1);
			extra_shot_button_text.setText("x "+amounts.get(1));
			extra_shot_amount.setText("$" + (1.20 * amounts.get(1)));
		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("sugar")){
			amounts.set(2, amounts.get(2)+1);
			sugar_button_text.setText("x "+amounts.get(2));
			sugar_amount.setText("$" + (0.50 * amounts.get(2)));
		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("chocolate")){
			amounts.set(3, amounts.get(3)+1);
			chocolate_button_text.setText("x "+amounts.get(3));
			chocolate_amount.setText("$" + (1.00 * amounts.get(3)));
		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("mint")){
			amounts.set(4, amounts.get(4)+1);
			mint_button_text.setText("x "+amounts.get(4));
			mint_amount.setText("$" + (0.50 * amounts.get(4)));
		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("start_over")){
			start_over();
		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("small_coffee")){
				small.setStyle("-fx-background-color: #edbfb9; ");
				medium.setStyle("-fx-background-color: #ffffff; ");
				large.setStyle("-fx-background-color: #ffffff; ");
				extra_large.setStyle("-fx-background-color: #ffffff; ");
				resized_coffee = 1;
		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("medium_coffee")){
				small.setStyle("-fx-background-color: #ffffff; ");
				medium.setStyle("-fx-background-color: #edbfb9; ");
				large.setStyle("-fx-background-color: #ffffff; ");
				extra_large.setStyle("-fx-background-color: #ffffff; ");
				resized_coffee = 2;
		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("large_coffee")){
				small.setStyle("-fx-background-color: #ffffff; ");
				medium.setStyle("-fx-background-color: #ffffff; ");
				large.setStyle("-fx-background-color: #edbfb9; ");
				extra_large.setStyle("-fx-background-color: #ffffff; ");
				resized_coffee = 3;

		}
		if(event.getSource() instanceof Button && ((Button) event.getSource()).getId().equals("extra_large_coffee")){
				small.setStyle("-fx-background-color: #ffffff; ");
				medium.setStyle("-fx-background-color: #ffffff; ");
				large.setStyle("-fx-background-color: #ffffff; ");
				extra_large.setStyle("-fx-background-color: #edbfb9; ");
				resized_coffee = 4;
		}
	}
}
