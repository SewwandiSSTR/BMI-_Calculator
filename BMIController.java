// Member 4: Coordination and Event Handling
import javax.swing.*;
import java.awt.Color;

public class BMIController {
    private BMIView view;

    public BMIController(BMIView view) {
        this.view = view;

        // Connect buttons to actions
        this.view.btnCalculate.addActionListener(e -> handleCalculate());
        this.view.btnClear.addActionListener(e -> handleClear());
    }

    private void handleCalculate() {

        //Display error , when Gender is not Selected
        if (!view.rbMale.isSelected() && !view.rbFemale.isSelected()) {
            JOptionPane.showMessageDialog(view, "Please select a gender.");
            return;
        }

        try {
            // Set Values from user input
            UserData data = new UserData(
                    Integer.parseInt(view.txtAge.getText()),
                    view.rbMale.isSelected() ? "Male" : "Female",
                    Double.parseDouble(view.txtHeight.getText()),
                    (String)view.unitHeight.getSelectedItem(),
                    Double.parseDouble(view.txtWeight.getText()),
                    (String)view.unitWeight.getSelectedItem()
            );

            // Calculate BMI
            double bmi = BMIEngine.calculateBMI(data);

            //Get Category
            String category = BMIEngine.getCategory(bmi);

            // View BMI value
            view.txtResult.setText(String.format("%.1f", bmi));

            // View BMI Category
            view.lblStatus.setText(category);

            // Highlight Category When BMI > 25
            if (bmi < 25) view.lblStatus.setForeground(new Color(0, 128, 0));
            else view.lblStatus.setForeground(Color.RED);

        }
        //Error Message
        catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error: Invalid numeric input.");
        }
    }

    //Clear Every Value
    private void handleClear() {
        view.txtAge.setText("");
        view.txtHeight.setText("");
        view.txtWeight.setText("");
        view.txtResult.setText("");
        view.lblStatus.setText("---");
        view.genderGroup.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BMIView view = new BMIView();
            new BMIController(view);
            view.setVisible(true);
        });
    }
}