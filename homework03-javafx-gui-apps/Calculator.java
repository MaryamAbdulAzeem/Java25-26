import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;

public class Calculator extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // Class variables
    String currentInput = "";
    double firstNumber = 0;
    String operator = "";
    boolean newInput = true;
    boolean justCalculated = false;

    public String format(double value) { // helper method to display an integer value as an integer and a double value as a double.
        if (value % 1 == 0) {
            return String.valueOf((int) value);
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        String[][] labels = {
                {"%", "CE", "C", "⌫"},
                {"1/x", "x²", "√x", "÷"},
                {"7", "8", "9", "×"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"±", "0", ".", "="}
        };

        GridPane pane = new GridPane();
        pane.setAlignment(CENTER);
        pane.setHgap(2);
        pane.setVgap(2);
        pane.setPadding(new Insets(2));
        pane.setStyle("-fx-background-color: black");

        Label calcHistory = new Label();
        calcHistory.setStyle("-fx-background-color: black");
        calcHistory.setFont(new Font(12));
        calcHistory.setAlignment(Pos.CENTER_RIGHT);
        calcHistory.setMaxWidth(Double.MAX_VALUE);
        calcHistory.setTextFill(Color.THISTLE);

        TextField tf = new TextField();
        tf.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: mistyrose");
        tf.setPrefHeight(50);
        tf.setAlignment(Pos.CENTER_RIGHT);
        tf.setFont(new Font(20));
        tf.setEditable(false);

        VBox vBox = new VBox(calcHistory, tf);
        pane.add(vBox, 0, 0, 4, 1);

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {
                Button button = new Button(labels[i][j]);
                button.setPrefSize(60, 60);

                if (labels[i][j].contains("x")) {
                    button.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 16));
                }

                button.setStyle("-fx-background-color: thistle");
                button.setOnMouseEntered(e -> {
                    button.setStyle("-fx-background-color: plum");
                });
                button.setOnMouseExited(e -> {
                    button.setStyle("-fx-background-color: thistle");
                });
                button.setOnMousePressed(e -> {
                    button.setStyle("-fx-background-color: mediumorchid;" + "-fx-effect: dropshadow(gaussian,white, 20, 0.5,0,0);");
                });
                button.setOnMouseReleased(e -> {
                    button.setStyle("-fx-background-color: plum");
                });

                button.setOnAction(e -> handleButton(tf, calcHistory, button.getText()));
                pane.add(button, j, i + 1);
            }
        }

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void handleButton(TextField tf, Label history, String text) {
        if (text.length() == 1 && text.charAt(0) >= '0' && text.charAt(0) <= '9') {
            if (justCalculated) {
                history.setText(""); // clears history after the calculation is complete
                justCalculated = false;
            }
            if (newInput) {
                currentInput = ""; // whenever we enter new input, the currentInput is intialised so that it can hold the new values.
                newInput = false; // after the new input is entered, currentInput entry will be sealed.
            }
            currentInput += text;
            tf.setText(currentInput);
        }
        else if (text.equals("+") || text.equals("-") || text.equals("×") || text.equals("÷")) {
            if (!currentInput.isEmpty()) {
                firstNumber = Double.parseDouble(tf.getText());
            }
            operator = text;
            newInput = true;
            justCalculated = false;
            history.setText(format(firstNumber) + " " + operator);
        }
        else if (text.equals("=")) {
            double secondNumber = Double.parseDouble(tf.getText());
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "×":
                    result = firstNumber * secondNumber;
                    break;
                case "÷":
                    if (firstNumber == 0 && secondNumber == 0) { // checking for edge case 1: (0÷0)
                        currentInput = "Result is undefined";
                        history.setText(format(firstNumber) + " " + "÷");
                        tf.setText(currentInput);
                        newInput = true;
                        justCalculated = true;
                        return;
                    }
                    if (secondNumber == 0) { // checking for edge case 2: (number÷0)
                        currentInput = "Cannot divide by zero";
                        tf.setText(currentInput);
                        history.setText(format(firstNumber) + " " + "÷");
                        newInput = true;
                        justCalculated = true;
                        return;
                    }
                    result = firstNumber / secondNumber; // normal case
                    break;
                default: // the default case is that when you type a number and click = without entering a second number, the same number is returned.
                    currentInput = tf.getText();
                    history.setText(currentInput + "=");
                    tf.setText(currentInput);
                    return;
            }

            if (result % 1 == 0) { // this displays an integer result as an integer value and a decimal result as a decimal value.
                currentInput = String.valueOf((int) result);
            } else {
                currentInput = String.valueOf(result);
            }
            tf.setText(currentInput);
            history.setText(format(firstNumber) + " " + operator + " " + format(secondNumber) + " " + text);
            newInput = true;
            justCalculated = true;
        }
        /* Implementing the C button */
        else if (text.equals("C")) {
            currentInput = "";
            firstNumber = 0;
            operator = "";
            newInput = true;
            tf.setText("");
            history.setText("");
        }
        /* Implementing the backspace button */
        else if (text.equals("⌫")) {
            if (!tf.getText().isEmpty()) {
                currentInput = tf.getText();
                currentInput = currentInput.substring(0, currentInput.length() - 1);
                tf.setText(currentInput);
            }
        }
        /* Implementing the CE button */
        else if (text.equals("CE")) {
            currentInput = "";
            tf.setText(currentInput);
        }
        /* Implementing the . button */
        else if (text.equals(".")) {
            if (newInput || currentInput.isEmpty()) { // if we are typing a new number (after operator or =) or if nothing has been typed yet..
                currentInput = "0."; // returns 0.[the number you entered]
                newInput = false;
            } else if (!currentInput.contains(".")) {
                currentInput += '.';
            }
            tf.setText(currentInput);
        }
        /* Implementing the x² button */
        else if (text.equals("x²")) {
            double number;
            double squaredNumber;
            if (!tf.getText().isEmpty()) {
                number = Double.parseDouble(tf.getText());
                squaredNumber = number * number;
                history.setText("sqr(" + format(number) + ")");
                currentInput = format(squaredNumber);
                tf.setText(currentInput);
                newInput = true;
            }
        }
        /* Implementing the 1/x button */
        else if (text.equals("1/x")) {
            double num;
            double numFraction;
            if (!tf.getText().isEmpty()) {
                num = Double.parseDouble(tf.getText());

                if (num == 0) {
                    history.setText("1/(0)");
                    tf.setText("Cannot divide by zero");
                    currentInput = "";
                    newInput = true;
                    justCalculated = true;
                } else {
                    numFraction = 1 / num;
                    history.setText("1/(" + format(num) + ")");
                    currentInput = format(numFraction);
                    tf.setText(currentInput);
                    newInput = true;
                    justCalculated = true;
                }
            }
        }
        /* Implementing the √x button */
        else if (text.equals("√x")) {
            double numR;
            double rootOfNum;
            if (!tf.getText().isEmpty()) {
                numR = Double.parseDouble(tf.getText());
                if (numR < 0) { // handles the edge case when the square root of a negative number is being taken.
                    history.setText("√(-" + format(numR) + ")");
                    tf.setText("Invalid Input");
                } else {
                    rootOfNum = Math.sqrt(numR);
                    history.setText("√(" + format(numR) + ")");
                    currentInput = format(rootOfNum);
                    tf.setText(currentInput);
                    newInput = true;
                    justCalculated = true;
                }
            }
        }
        /* Implementing the % button */
        else if (text.equals("%")) {
            double numP;
            double numResult;
            if (!tf.getText().isEmpty()) {
                numP = Double.parseDouble(tf.getText());
                numResult = numP / 100;
                history.setText(format(numP) + "%");
                currentInput = format(numResult);
                tf.setText(currentInput);
                newInput = true;
                justCalculated = true;
            }
        }
        /* Implementing the ± button */
        else if (text.equals("±")) {
            double num1;
            double negResult;
            if (!tf.getText().isEmpty()) {
                num1 = Double.parseDouble(tf.getText());
                negResult = num1 * (-1);
                history.setText(format(negResult));
                currentInput = format(negResult);
                tf.setText(currentInput);
                newInput = true;
                justCalculated = true;
            }
        }
    }
}
