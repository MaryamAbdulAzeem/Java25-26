import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MotivationalQuotesApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // class variables:
    String[] quotes; // array to store all the five quotes
    int index = 0; // keeps track of the current quote
    int counter = 0; // keeps track of the number of times 'Count' was clicked

    @Override
    public void start(Stage primaryStage) {
        VBox vPane = new VBox(10); // creates a vertical layout
        vPane.setStyle("-fx-background-color: linear-gradient(to bottom right, lightblue, plum)");
        vPane.setSpacing(15);
        vPane.setAlignment(Pos.CENTER);
        vPane.setPadding(new Insets(40, 20, 20, 20)); // spacing around the edges

        Label heading = new Label("Motivational Quotes Counter App");
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        quotes = new String[]{ // filling the array with quotes
                "Be like a flower—survive the rain, but use it to grow.\n -Unknown",
                "The UAE has thick skin and bitter flesh; we are no easy prey.\n -Sheikh Mohamed bin Zayed Al Nahyan",
                "Whoever fears climbing mountains will live forever among the pits.\n -Abu al-Qasim al-Shabi",
                "Education is the foundation for building a better future. \n -Sheikh Mohamed bin Zayed Al Nahyan",
                "Do not despair if the road is long; every step brings you closer. \n -Al-Mu'tamid ibn Abbad"
        };

        Label quoteLabel = new Label(quotes[index]);
        quoteLabel.setPrefHeight(120);
        quoteLabel.setMinHeight(120);
        quoteLabel.setMaxHeight(120); // locks the height-prevents the interface from changing in orientation.
        quoteLabel.setMinWidth(400);
        quoteLabel.setMaxWidth(400); // locks the width-prevents the interface from horizontal resizing.
        quoteLabel.setFont(Font.font("Lucida Calligraphy", FontWeight.BOLD, 14));
        quoteLabel.setAlignment(Pos.CENTER);
        quoteLabel.setWrapText(true); // The continuation of a long text goes to the next line

        Label countLabel = new Label("Count: 0");
        countLabel.setFont(Font.font("Arial", 18));

        // creating horizontal rows for buttons
        HBox row1 = new HBox(10);
        HBox row2 = new HBox(10);
        row1.setSpacing(20);
        row2.setSpacing(20);
        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);

        String[][] buttons = { // 2D array to hold the buttons
                {"Count", "Reset"},
                {"Previous", "Next"}
        };

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                Button button = new Button(buttons[i][j]); // creates buttons with texts
                button.setPrefWidth(100);
                button.setPrefHeight(40);
                button.setStyle("-fx-background-color: cadetblue");

                button.setOnMouseEntered(e -> {
                    button.setStyle("-fx-background-color: mediumorchid");
                });
                button.setOnMouseExited(e -> {
                    button.setStyle("-fx-background-color: cadetblue");
                });
                button.setOnMousePressed(e -> {
                    button.setStyle("-fx-background-color: purple;" + "-fx-effect: dropshadow(gaussian,white, 20, 0.5,0,0);");
                });
                button.setOnMouseReleased(e -> {
                    button.setStyle("-fx-background-color: mediumorchid");
                });

                button.setOnAction(e -> handleButton(button.getText(), quoteLabel, countLabel));

                if (i == 0) {
                    row1.getChildren().add(button);
                } else {
                    row2.getChildren().add(button);
                }
            }
        }

        vPane.getChildren().addAll(heading, quoteLabel, countLabel, row1, row2);

        Scene scene = new Scene(vPane, 500, 350);
        primaryStage.setTitle("Motivational Quotes App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void handleButton(String action, Label quoteLabel, Label countLabel) {
        if (action.equals("Count")) {
            counter++;
            countLabel.setText("Count: " + counter);
        }
        if (action.equals("Reset")) {
            counter = 0;
            countLabel.setText("Count: 0");
        }
        if (action.equals("Previous")) {
            index = (index - 1 + quotes.length) % quotes.length; // wraps around (like a circular array) so that when the user is at the first quote and clicks on "Previous", the last quote will be displayed. +quoutes.length prevents negative index.
            quoteLabel.setText(quotes[index]);
            counter = 0;
            countLabel.setText("Count: 0");
        }
        if (action.equals("Next")) {
            index = (index + 1) % quotes.length; // wraps around (like a circular array) so that when the user is at the last quote and clicks on "Next", the first quote will be displayed.
            quoteLabel.setText(quotes[index]);
            counter = 0;
            countLabel.setText("Count: 0");
        }
    }
}
