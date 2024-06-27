package model;

import java.util.Map;

import view.View;

public class MultiplicationModel implements OperationModel {

    View view;

    public MultiplicationModel(View view) {
        this.view = view;
    }

    @Override
    public String calculate(Map<String, Double> nums) {
        String result;
        if (nums.containsKey("imNum1") && nums.containsKey("imNum2")) {
            double res1 = nums.get("num1") * nums.get("num2");
            double res2 = nums.get("num1") * nums.get("imNum2");
            double res3 = nums.get("imNum1") * nums.get("num2");
            double res4 = nums.get("imNum1") * nums.get("imNum2") * -1; // т.к. i^2 = -1
            if ((res1 + res4) % 1 == 0) {
                int result1 = (int) (res1 + res4);
                result = String.valueOf(result1 + " + ");
            } else {
                double result1 = res1 + res4;
                result = String.valueOf(result1 + " + ");
            }
            if ((res2 + res3) % 1 == 0) {
                int result2 = (int) (res2 + res3);
                result = result + result2 + "i";
            } else {
                double result2 = res2 + res3;
                result = result + result2 + "i";
            }
        } else if (!nums.containsKey("imNum1") && !nums.containsKey("imNum2")) {
            if ((nums.get("num1") * nums.get("num2")) % 1 == 0) {
                result = String.valueOf((int) (nums.get("num1") * nums.get("num2")));
            } else {
                result = String.valueOf(nums.get("num1") * nums.get("num2"));
            }
        } else {
            view.printCalculationError();
            return "not calculated";
        }

        return result;
    }

}
