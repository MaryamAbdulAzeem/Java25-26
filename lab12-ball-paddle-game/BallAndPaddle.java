/**
 * @author: Maryam Abdul Azeem
 */
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class BallAndPaddle extends Application {
    private double dx = 2; // horizontal speed
    private double dy = 1; // vertical speed
    private double radius = 5;
    double scoreValue = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // borderpane to have both other panes
        BorderPane root = new BorderPane();

        Pane pane = new Pane();
        pane.setPrefSize(400, 600);
        pane.setStyle("-fx-background-color: linear-gradient(to bottom, black, #020214, purple);");

        Rectangle paddle = new Rectangle(10, 570, 50, 5);
        paddle.setFill(Color.LIGHTSEAGREEN);
        pane.setOnMouseMoved(e -> {
            paddle.setX(e.getX());
        });

        Circle ball = new Circle(Math.random() * pane.getWidth(), 0, radius);
        ball.setFill(Color.FUCHSIA);
        ball.setStyle("-fx-effect: dropshadow(gaussian,white, 30, 0.8,0,0)");

        Circle[] circleArray = new Circle[1000];
        for (int i = 0; i < circleArray.length; i++) {
            circleArray[i] = new Circle(Math.random() * 400, Math.random() * 600, 0.5);
            circleArray[i].setFill(Color.WHITE);
            circleArray[i].setOpacity(0.5);
            pane.getChildren().add(circleArray[i]);
        }

        pane.getChildren().addAll(paddle, ball);
        root.setCenter(pane);

        FlowPane controlPane = new FlowPane();
        controlPane.setStyle("-fx-background-color: lightgrey");

        Label score = new Label("Score: ");
        score.setFont(Font.font("Arial", 15));
        Text scoreCount = new Text("0");
        scoreCount.setFont(Font.font("Arial", 15));

        Button play = new Button("Play");
        Button stop = new Button("Stop");
        Button reset = new Button("Reset");

        controlPane.getChildren().addAll(score, scoreCount, play, stop, reset);
        root.setBottom(controlPane);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            ball.setCenterX(ball.getCenterX() + dx);
            ball.setCenterY(ball.getCenterY() + dy);

            if (ball.getCenterX() > pane.getWidth() || ball.getCenterX() < 0) {
                dx = -1 * dx;
            } else if (ball.getCenterY() < 0) {
                dy = -1 * dy;
            } else if ((ball.getCenterY() + radius >= paddle.getY() &&
                    ball.getCenterX() - radius > paddle.getX() &&
                    ball.getCenterX() < paddle.getX() + paddle.getWidth())) {
                dy = -1 * dy;
                double value = Double.parseDouble(scoreCount.getText()); // get the value
                //(for exercise 1) scoreCount.setText(String.valueOf(value + 1)); // add one
                scoreValue++; // for exercise 2 (increase the speed each time the score increases by 5 and change the colour of the ball.
                scoreCount.setText(String.valueOf(scoreValue));

                if (scoreValue % 5 == 0 && scoreValue != 0) {
                    dx *= 1.5;
                    dy *= 1.5;
                    ball.setFill(Color.color(Math.random(), Math.random(), Math.random())); // for assigning random RGB values
                }
            } else if (ball.getCenterY() + radius > paddle.getY()) {
                dy = 0;
                dx = 0;
                pane.setOnMouseMoved(null); // to disable paddle movement
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        play.setOnAction(e -> {
            timeline.play(); // to play it
        });

        stop.setOnAction(e -> {
            timeline.stop(); // to stop it
        });

        reset.setOnAction(e -> {
            ball.setCenterX(Math.random() * 350);
            ball.setCenterY(0);
            scoreCount.setText("0");
            dx = 2;
            dy = 1;
            scoreValue = 0;
            pane.setOnMouseMoved(ev -> paddle.setX(ev.getX()));
            timeline.playFromStart();
        });

        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            for (int i = 0; i < circleArray.length; i++) {
                circleArray[i].setCenterY(circleArray[i].getCenterY() + 1);
                if (circleArray[i].getCenterY() > 600) {
                    circleArray[i].setCenterY(0);
                }
            }
        }));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();

        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
