import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Exercise2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 100, 100);
        primaryStage.setScene(scene);

        double height = 90;
        double width = 2 * 90;
        double stripeHeight = height / 3;

        Rectangle redStripe = new Rectangle(50, 50, 0.25 * width, height);
        Color red = new Color(200 / 255.0, 16 / 255.0, 46 / 255.0, 1.0);
        redStripe.setFill(red);

        Rectangle greenStripe = new Rectangle(50 + 0.25 * width, 50, 0.75 * width, stripeHeight);
        Color green = new Color(0 / 255.0, 132 / 255.0, 61 / 255.0, 1.0);
        greenStripe.setFill(green);

        Rectangle whiteStripe = new Rectangle(50 + 0.25 * width, stripeHeight + 50, 0.75 * width, stripeHeight);
        Color white = new Color(225 / 255.0, 225 / 255.0, 225 / 255.0, 1.0);
        whiteStripe.setFill(white);

        Rectangle blackStripe = new Rectangle(50 + 0.25 * width, 2 * stripeHeight + 50, 0.75 * width, stripeHeight);
        Color black = new Color(0 / 255.0, 0 / 255.0, 0 / 255.0, 1.0);
        blackStripe.setFill(black);

        root.getChildren().addAll(redStripe, greenStripe, whiteStripe, blackStripe);

        primaryStage.setTitle("UAE Flag");
        primaryStage.show();
    }
}
