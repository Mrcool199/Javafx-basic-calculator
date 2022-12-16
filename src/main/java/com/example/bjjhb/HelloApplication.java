package com.example.bjjhb;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public TextField textField1  = new TextField();
    public long number = 0;
    public String op = "";
    public boolean start = true;

    public static void main(String[] args) {
        launch();

    }
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GWC Timer App");

        textField1.setEditable(false);

        TilePane tile1 = new TilePane();
        tile1.setHgap(8);
        tile1.setVgap(8);
        tile1.setAlignment(Pos.CENTER);
        tile1.getChildren().addAll(
                createNumberButton("7"),
                createNumberButton("8"),
                createNumberButton("9"),
                createOperatorsButton("/"),

                createNumberButton("4"),
                createNumberButton("5"),
                createNumberButton("6"),
                createOperatorsButton("x"),

                createNumberButton("1"),
                createNumberButton("2"),
                createNumberButton("3"),
                createOperatorsButton("-"),

                createNumberButton("0"),
                createClearButton("C"),
                createOperatorsButton("="),
                createOperatorsButton("+")
                );

        BorderPane layout = new BorderPane();
        primaryStage.setTitle("Calculator");
        Scene scene = new Scene(layout, 150,180);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        layout.setCenter(tile1);
        layout.setTop(textField1);
    }
    public Button createOperatorsButton(String Number){
        Button button1 = new Button(Number);
        button1.setPrefSize(30,30);
        button1.setOnAction(this::Operator);
        return button1;
    }
    public Button createNumberButton(String Number){
        Button button1 = new Button(Number);
        button1.setPrefSize(30,30);
        button1.setOnAction(this::Number1);
        return button1;
    }
    public Button createClearButton(String Number){
        Button button1 = new Button(Number);
        button1.setPrefSize(30,30);
        button1.setOnAction(event -> {
            textField1.setText("");
        op ="";
        start = true;
        });
        return button1;
    }

    public void Operator(ActionEvent e){
        String a = ((Button)e.getSource()).getText();
        if (!a.equals("=")){
            if (!op.isEmpty())
                return;
                number = Long.parseLong(textField1.getText());
                op = a;
                textField1.setText("");
            }else {
                if (op.isEmpty())
                    return;
                long number2 = Long.parseLong(textField1.getText());
                float answer = calculate(number,number2,op);
                textField1.setText(String.valueOf(answer));
                start=true;
                op = "";
            }
        }
    public float calculate(long number,long number2,String op){
        switch (op){
            case "+": return number+number2;
            case "-": return number-number2;
            case "x": return number*number2;
            case "/": return number/number2;
            default: return 0;
        }
    }
    public void Number1(ActionEvent e){
        if (start){
            textField1.setText("");
            start=false;
        }
        String a = ((Button)e.getSource()).getText();
        textField1.setText(textField1.getText()+a);
    }
}