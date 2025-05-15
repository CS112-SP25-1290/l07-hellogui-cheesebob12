package edu.miracosta.cs112.lab07;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {

    // GUI Components
    private Label label1;
    private Label label2;
    private Button button1;
    private Button button2;
    private TextField textField;
    private int count = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello GUI: Your Name");

        // Labels
        label1 = new Label("Hello GUI World");
        label2 = new Label("Click count: 0");

        // Buttons
        button1 = new Button("Set Text");
        button2 = new Button("Click Me");

        // Button functionality
        button1.setOnAction(this);
        button2.setOnAction(this);

        // Text Field
        textField = new TextField();
        textField.setPromptText("Enter text here");

        // Layout
        VBox layout = new VBox(10); // Spacing between elements
        layout.getChildren().addAll(label1, textField, label2, button1, button2);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button1) {
            String userInput = textField.getText();
            label1.setText(userInput);
        } else if (actionEvent.getSource() == button2) {
            count++;
            label2.setText("Click count: " + count);
        }
    }
}
