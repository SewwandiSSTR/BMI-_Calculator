// Member 3: User Interface
import javax.swing.*;
import java.awt.*;

public class BMIView extends JFrame {
    public JTextField txtAge, txtHeight, txtWeight, txtResult;
    public JComboBox<String> unitHeight, unitWeight;
    public JRadioButton rbMale, rbFemale;
    public JButton btnCalculate, btnClear;
    public JLabel lblStatus;
    public ButtonGroup genderGroup;
    private JTextArea areaCategories; // Added for the reference table

    //App Window
    public BMIView() {
        setTitle("Body Mass Index Calculator");
        setSize(450, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));
        initComponents();
    }
    //Components inside the window of app
    private void initComponents() {
        // --- Main Title (From your sketch) ---
        JLabel lblMainTitle = new JLabel("Body Mass Index Calculator", SwingConstants.CENTER);
        lblMainTitle.setBounds(50, 15, 350, 30);
        lblMainTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblMainTitle);

        // --- Inputs Section ---

        //Age label
        autoLabel("Age:", 30, 70);

        //Age TextField
        txtAge = new JTextField();
        txtAge.setBounds(130, 70, 80, 25);
        add(txtAge);

        //Gender Label
        autoLabel("Gender:", 30, 110);

        //Gender Radio Button
        rbMale = new JRadioButton("M");
        rbFemale = new JRadioButton("F");
        rbMale.setBounds(130, 110, 50, 25);
        rbFemale.setBounds(190, 110, 50, 25);
        rbMale.setOpaque(false); rbFemale.setOpaque(false);
        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        add(rbMale); add(rbFemale);

        //Height label
        autoLabel("Height:", 30, 150);

        //Height TextField
        txtHeight = new JTextField();
        txtHeight.setBounds(130, 150, 150, 25);
        add(txtHeight);

        //Dropdown box for Height (cm,inches)
        unitHeight = new JComboBox<>(new String[]{"cm", "inches"});
        unitHeight.setBounds(290, 150, 80, 25);
        add(unitHeight);

        //Weight Label
        autoLabel("Weight:", 30, 190);

        //Weight TextField
        txtWeight = new JTextField();
        txtWeight.setBounds(130, 190, 150, 25);
        add(txtWeight);

        //Dropdown box for Weight (Kg,lbs)
        unitWeight = new JComboBox<>(new String[]{"kg", "lbs"});
        unitWeight.setBounds(290, 190, 80, 25);
        add(unitWeight);

        // --- Action Buttons ---

        //Clear Button
        btnClear = new JButton("Clear");
        btnClear.setBounds(80, 240, 100, 35);
        add(btnClear);

        //Calculate Button
        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(240, 240, 120, 35);
        add(btnCalculate);

        // --- Results Panel ---
        JPanel resPanel = new JPanel(null);
        resPanel.setBounds(30, 300, 370, 280);
        resPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        resPanel.setBackground(Color.WHITE);
        add(resPanel);

        //Title
        JLabel lblResTitle = new JLabel("BMI Result", SwingConstants.CENTER);
        lblResTitle.setBounds(10, 10, 350, 25);
        lblResTitle.setFont(new Font("Arial", Font.BOLD, 16));
        resPanel.add(lblResTitle);

        //Details for display
        JLabel lblRes = new JLabel("Your BMI Value:");
        lblRes.setBounds(40, 50, 120, 25);
        resPanel.add(lblRes);

        //TextField for display BMI Value (Can not editable)
        txtResult = new JTextField();
        txtResult.setEditable(false);
        txtResult.setBounds(170, 50, 100, 25);
        txtResult.setHorizontalAlignment(JTextField.CENTER);
        resPanel.add(txtResult);

        //Display Value
        lblStatus = new JLabel("You are: ---", SwingConstants.CENTER);
        lblStatus.setBounds(10, 90, 350, 30);
        lblStatus.setFont(new Font("Arial", Font.ITALIC, 18));
        resPanel.add(lblStatus);

        // --- BMI Reference Table (Categories) ---
        areaCategories = new JTextArea(
                " BMI Values\n" +
                        " Underweight : < 18.5\n" +
                        " Normal      : 18.5 - 24.9\n" +
                        " Overweight  : 25 - 29.9\n" +
                        " Obese       : 30 or greater"
        );
        areaCategories.setBounds(25, 130, 320, 130);
        areaCategories.setEditable(false);
        areaCategories.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaCategories.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        resPanel.add(areaCategories);
    }

    private void autoLabel(String text, int x, int y) {
        JLabel l = new JLabel(text);
        l.setBounds(x, y, 100, 25);
        l.setFont(new Font("Arial", Font.PLAIN, 14));
        add(l);
    }
}