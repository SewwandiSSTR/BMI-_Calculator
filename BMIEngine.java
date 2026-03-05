// Member 2: Logic and Calculations
public class BMIEngine {

    public static double calculateBMI(UserData data) {
        double h = data.getHeight();
        double w = data.getWeight();
        double bmi;

        //calculate bmi , when height is in metric
        if (data.getHUnit().equals("inches")) {
            if (data.getWUnit().equals("lbs")) {
                bmi = 703 * (w / (h * h));
            } else {
                bmi = w / ((h * 0.0254) * (h * 0.0254));
            }
        }

        //calculate bmi , when height is in english
        else {
            double hMeters = h / 100;

            //calculate bmi
            if (data.getWUnit().equals("kg")) {
                bmi = w / (hMeters * hMeters);
            } else {
                bmi = (w * 0.453592) / (hMeters * hMeters);
            }
        }
        return bmi;
    }

    //display BMI Category that you in,
    public static String getCategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal Weight";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }
}