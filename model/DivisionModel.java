package model;

import java.util.Map;

import view.View;

public class DivisionModel implements OperationModel {

    View view;

    public DivisionModel(View view) {
        this.view = view;
    }

    @Override
    public String calculate(Map<String, Double> nums) {
        String result;
        if (nums.containsKey("imNum1") && nums.containsKey("imNum2")) {
            double resDividend1 = (nums.get("num1") * nums.get("num2"))
                    + (nums.get("imNum1") * -(nums.get("imNum2")) * -1);
            double resDividend2 = (nums.get("num1") * -(nums.get("imNum2"))) + (nums.get("imNum1") * nums.get("num2"));
            double resDivisor1 = (nums.get("num2") * nums.get("num2"))
                    + (nums.get("imNum2") * (-(nums.get("imNum2"))) * -1);
            double resDivisor2 = nums.get("num2") * (-(nums.get("imNum2"))) + (nums.get("imNum2") * nums.get("num2"));
            if (resDivisor2 == 0) {
                resDividend1 /= resDivisor1;
                resDividend2 /= resDivisor1;
            }
            if (resDividend2 < 0) {
                resDividend2 *= -1;
                result = String.valueOf(resDividend1 + " - " + resDividend2 + "i");
            } else {
                result = String.valueOf(resDividend1 + " + " + resDividend2 + "i");
            }
        } else if (!nums.containsKey("imNum1") && !nums.containsKey("imNum2")) {
            if ((nums.get("num1") / nums.get("num2")) % 1 == 0) {
                result = String.valueOf((int) (nums.get("num1") / nums.get("num2")));
            } else {
                result = String.valueOf(nums.get("num1") / nums.get("num2"));
            }
        } else {
            view.printCalculationError();
            return "not calculated";
        }

        return result;
    }

}
