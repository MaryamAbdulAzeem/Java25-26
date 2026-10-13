import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TrafficLight extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 200, 300);
        primaryStage.setScene(scene);

        Rectangle black = new Rectangle(72.5, 60, 55, 180);

        Circle red = new Circle(100, 100, 15);
        red.setFill(Color.RED);

        Circle yellow = new Circle(100, 150, 15);
        yellow.setFill(Color.YELLOW);

        Circle green = new Circle(100, 200, 15);
        green.setFill(Color.GREEN);

        root.getChildren().addAll(black, red, yellow, green);

        primaryStage.setTitle("Traffic Light");
        primaryStage.show();
    }
}
