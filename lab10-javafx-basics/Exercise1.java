import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class Exercise1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        root.setStyle("-fx-background-color: white");

        Text[] a = new Text[5];
        HBox hBox = new HBox();
        hBox.setLayoutX(50);
        hBox.setLayoutY(100);
        hBox.setSpacing(-30);

        for (int i = 0; i < a.length; i++) {
            a[i] = new Text("JavaFx");
            a[i].setRotate(90);
            a[i].setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 27));
            Color color = new Color(Math.random(), Math.random(), Math.random(), Math.random());
            a[i].setFill(color);
            hBox.getChildren().add(a[i]);
        }

        root.getChildren().add(hBox);

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("My First JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }
}
