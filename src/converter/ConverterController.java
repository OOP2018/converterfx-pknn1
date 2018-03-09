package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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
    private ComboBox<Length> unit1;

    @FXML
    private ComboBox<Length> unit2;

    @FXML
    private Button convertButton;

    @FXML
    private Button clearButton;

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
            if (event.getCode().equals(KeyCode.ENTER)) {
                convertButton.fire();
            }
            lastEditField = 1;
        });
        field2.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                convertButton.fire();
            }
            lastEditField = 2;
        });
    }

    /**
     * Handler for the buttons.
     * - Convert the value to the target unit.
     * - Clear the field.
     * @param event Button click event.
     */
    @FXML
    public void buttonHandler(ActionEvent event) {
        if (event.getSource().equals(convertButton)) {
            if (lastEditField == 1) {
                convert(field1, field2, unit1.getValue(), unit2.getValue());
            } else {
                convert(field2, field1, unit2.getValue(), unit1.getValue());
            }
        } else if (event.getSource().equals(clearButton)) {
            field1.clear();
            field2.clear();
        }
    }

    /**
     * Convert value to the target unit and display the result.
     * @param convertField field for filling the value to convert.
     * @param resultField field for display the result.
     * @param originalUnit unit of the original value.
     * @param convertedUnit unit of the target value.
     */
    private void convert(TextField convertField, TextField resultField, Length originalUnit, Length convertedUnit) {
        double value = Double.parseDouble(convertField.getText()) / convertedUnit.getValue() * originalUnit.getValue();
        resultField.setText(String.format("%.4g", value));
    }
}
