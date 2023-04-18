public class MetricConverter extends Application {

    private static final double METER_TO_FEET = 3.28084;
    private static final double KILOMETER_TO_MILE = 0.621371;
    private static final double CENTIMETER_TO_INCH = 0.393701;

    private ComboBox<String> fromBox;
    private ComboBox<String> toBox;
    private TextField inputField;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // Create "From" label and combo box
        Label fromLabel = new Label("From:");
        GridPane.setConstraints(fromLabel, 0, 0);

        fromBox = new ComboBox<>();
        fromBox.getItems().addAll("Meter", "Kilometer", "Centimeter");
        fromBox.setValue("Meter");
        GridPane.setConstraints(fromBox, 1, 0);

        // Create "To" label and combo box
        Label toLabel = new Label("To:");
        GridPane.setConstraints(toLabel, 0, 1);

        toBox = new ComboBox<>();
        toBox.getItems().addAll("Feet", "Mile", "Inch");
        toBox.setValue("Feet");
        GridPane.setConstraints(toBox, 1, 1);

        // Create input field
        inputField = new TextField();
        inputField.setPromptText("Enter a value");
        GridPane.setConstraints(inputField, 0, 2, 2, 1);

        // Create convert button
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                convert();
            }
        });
        GridPane.setConstraints(convertButton, 0, 3);

        // Create result label
        resultLabel = new Label();
        GridPane.setConstraints(resultLabel, 1, 3);

        // Add all the elements to the grid
        grid.getChildren().addAll(fromLabel, fromBox, toLabel, toBox, inputField, convertButton, resultLabel);

        primaryStage.setScene(new Scene(grid, 300, 150));
        primaryStage.show();
    }

    private void convert() {
        double value = Double.parseDouble(inputField.getText());
        double result;

        // Convert the input value to meters
        switch (fromBox.getValue()) {
            case "Kilometer":
                value *= 1000;
                break;
            case "Centimeter":
                value /= 100;
                break;
            default:
                break;
        }

        // Convert the meters to the output value
        switch (toBox.getValue()) {
            case "Feet":
                result = value * METER_TO_FEET;
                break;
            case "Mile":
                result = value * KILOMETER_TO_MILE / 1000;
                break;
            case "Inch":
                result = value * CENTIMETER_TO_INCH / 100;
                break;
            default:
                result = 0;
                break;
       
