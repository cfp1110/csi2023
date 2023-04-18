import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private static final int BOARD_SIZE = 5;
    private static final int LINE_THICKNESS = 5;
    private static final int BUTTON_SIZE = 100;
    private static final int FONT_SIZE = 50;

    private Button[][] buttons;
    private boolean player1Turn = true;
    private int numMoves = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");

        // Create grid of buttons
        buttons = new Button[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Button button = new Button();
                button.setMinSize(BUTTON_SIZE, BUTTON_SIZE);
                button.setOnAction(event -> {
                    if (!button.getText().equals("")) {
                        return;
                    }

                    if (player1Turn) {
                        button.setText("X");
                        button.setTextFill(Color.BLUE);
                    } else {
                        button.setText("O");
                        button.setTextFill(Color.RED);
                    }

                    numMoves++;
                    if (checkWin(i, j)) {
                        endGame(player1Turn);
                    } else if (numMoves == BOARD_SIZE * BOARD_SIZE) {
                        endGame(null);
                    } else {
                        player1Turn = !player1Turn;
                    }
                });
                buttons[i][j] = button;
            }
        }

        // Create grid pane to hold buttons
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                gridPane.add(buttons[i][j], j, i);
            }
        }

        // Create vertical lines
        for (int i = 1; i < BOARD_SIZE; i++) {
            Line line = new Line();
            line.setStartX(i * BUTTON_SIZE);
            line.setStartY(0);
            line.setEndX(i * BUTTON_SIZE);
            line.setEndY(BOARD_SIZE * BUTTON_SIZE);
            line.setStrokeWidth(LINE_THICKNESS);
            gridPane.getChildren().add(line);
        }

        // Create horizontal lines
        for (int i = 1; i < BOARD_SIZE; i++) {
            Line line = new Line();
            line.setStartX(0);
            line.setStartY(i * BUTTON_SIZE);
            line.setEndX(BOARD_SIZE * BUTTON_SIZE);
            line.setEndY(i * BUTTON_SIZE);
            line.setStrokeWidth(LINE_THICKNESS);
            gridPane.getChildren().add(line);
        }

        // Create scene and show stage
        Scene scene = new Scene(gridPane, BOARD_SIZE * BUTTON_SIZE, BOARD_SIZE * BUTTON_SIZE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean checkWin(int row, int col) {
        String mark = player1Turn ? "X" : "O";
        int count = 0;

        // Check row
        for (int i = 0; i < BOARD_SIZE; i++) {
            if
