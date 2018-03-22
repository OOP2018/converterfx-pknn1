package converter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

/**
 * Controller of the Converter Application.
 * Handle the action event and logic part for the application.
 *
 * @author Pakanon Pantisawat
 */
public class ConverterController {
    @FXML
    private TextField field1;

    @FXML
    private TextField field2;

    @FXML
    private ComboBox<Unit> unit1;

    @FXML
    private ComboBox<Unit> unit2;

    @FXML
    private Button convertButton;

    @FXML
    private Button clearButton;

    @FXML
    private MenuItem exitButton;

    private byte lastEditField = 0;

    /**
     * Initialize the FXML function.
     * Set the combo box items and add event type.
     */
    @FXML
    public void initialize() {
        if (unit1 != null) {
            unit1.getItems().addAll(Length.values());
            unit1.getSelectionModel().select(0);
        }
        if (unit2 != null) {
            unit2.getItems().addAll(Length.values());
            unit2.getSelectionModel().select(1);
        }

        field1.setOnKeyPressed(event -> {
            lastEditField = 1;
        });
        field2.setOnKeyPressed(event -> {
            lastEditField = 2;
        });

        convertButton.setDefaultButton(true);
        clearButton.setCancelButton(true);
    }

    /**
     * Handler for the buttons.
     * - Convert the value to the target unit.
     * - Clear the field.
     *
     * @param event Button click event.
     */
    @FXML
    public void buttonHandler(ActionEvent event) {
        if (event.getSource().equals(convertButton)) {
            if (lastEditField == 1 && field1.getLength() != 0) {
                convert(field1, field2, unit1.getValue(), unit2.getValue());
            } else if (lastEditField == 2 && field2.getLength() != 0) {
                convert(field2, field1, unit2.getValue(), unit1.getValue());
            }
        } else if (event.getSource().equals(clearButton)) {
            field1.clear();
            field2.clear();
        }
    }

    /**
     * Convert value to the target unit and display the result.
     *
     * @param convertField  field for filling the value to convert.
     * @param resultField   field for display the result.
     * @param originalUnit  unit of the original value.
     * @param convertedUnit unit of the target value.
     */
    private void convert(TextField convertField, TextField resultField, Unit originalUnit, Unit convertedUnit) {
        if (convertField.getText().matches("[\\d]+$")) {
            double value = originalUnit.convert(Double.parseDouble(convertField.getText()), convertedUnit);
            resultField.setText(String.format("%.4g", value));
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You can't input text.");
            alert.show();
            clearButton.fire();
        }
    }

    /**
     * Handling the event from the menu bar.
     * @param event event from the menu button.
     */
    public void menuHandler(ActionEvent event) {
        unit1.getItems().clear();
        unit2.getItems().clear();
        if (event.getSource().equals(exitButton)) {
            Platform.exit();
        } else {
            UnitType unitType = UnitType.valueOf(((MenuItem) event.getSource()).getText());
            Unit<?>[] units = UnitFactory.getInstance().getUnit(unitType);
            unit1.getItems().addAll(units);
            unit2.getItems().addAll(units);
        }
        unit1.getSelectionModel().select(0);
        unit2.getSelectionModel().select(1);
    }
}
