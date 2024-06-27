package model;

import java.util.Map;

import view.View;

public class AdditionModel implements OperationModel {

    View view;

    public AdditionModel(View view) {
        this.view = view;
    }

    @Override
    public String calculate(Map<String, Double> nums) {
        String result;
        if (nums.containsKey("imNum1") && nums.containsKey("imNum2")) {
            if ((nums.get("num1") + nums.get("num2")) % 1 == 0) {
                int res1 = (int) (nums.get("num1") + nums.get("num2"));
                result = String.valueOf(res1);
            } else {
                double res1 = nums.get("num1") + nums.get("num2");
                result = String.valueOf((double) Math.round(res1 * 100) / 100);
            }
            if ((nums.get("imNum1") + nums.get("imNum2")) % 1 == 0) {
                int res2 = (int) (nums.get("imNum1") + nums.get("imNum2")); // не выделено в отдельный метод, т.к. разный тип данных
                if (res2 >= 0) {
                    result = result + "+" + res2 + "i";
                } else {
                    res2 *= -1;
                    result = result + "-" + res2 + "i";
                }
            } else {
                double res2 = nums.get("imNum1") + nums.get("imNum2");
                if (res2 >= 0) {
                    result = result + "+" + res2 + "i";
                } else {
                    res2 *= -1;
                    result = result + "-" + res2 + "i";
                }
            }
        } else if (!nums.containsKey("imNum1") && !nums.containsKey("imNum2")) {
            if ((nums.get("num1") + nums.get("num2")) % 1 == 0) {
                result = String.valueOf((int) (nums.get("num1") + nums.get("num2")));
            } else {
                result = String.valueOf(nums.get("num1") + nums.get("num2"));
            }
        } else {
            view.printCalculationError();
            ;
            return "not calculated";
        }
        return result;
    }

}
