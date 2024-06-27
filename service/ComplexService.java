package service;

import java.util.HashMap;
import java.util.Map;

import view.View;

public class ComplexService {

    View view;

    public ComplexService(View view) {
        this.view = view;
    }

    public String[] separateNum(String num) {
        num = num.replace("-", "+-");
        num = num.replace(",", ".");
        num = num.replace(" ", "");
        String[] res = num.split("\\+");
        for (int i = 0; i < res.length; i++) {
            if (res[i].isEmpty()) {
                res[i] = "0";
            }
            if (res[i].contains("[a-hA-H]") || res[i].contains("[j-zJ-Z]")) {
                view.printInputError();
                return null;
            }
        }
        // for (int i = 0; i < res.length; i++) {
        // System.out.println(res[i]);
        // }
        return res;
    }

    public Map<String, Double> separateNumsAndComplexNums(String[] a, String[] b) {
        Map<String, Double> nums = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i].contains("i")) {
                if (a[i].equals("i")) {
                    a[i] = "1";
                } else if (a[i].equals("-i")) {
                    a[i] = "-1";
                } else {
                    a[i] = a[i].replace('i', ' ').trim();
                }
                nums.put("imNum1", Double.parseDouble(a[i]));
            } else {
                nums.put("num1", Double.parseDouble(a[i]));
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i].contains("i")) {
                if (b[i].equals("i")) {
                    b[i] = "1";
                } else if (b[i].equals("-i")) {
                    b[i] = "-1";
                } else {
                    b[i] = b[i].replace('i', ' ').trim();
                }
                nums.put("imNum2", Double.parseDouble(b[i]));
            } else {
                nums.put("num2", Double.parseDouble(b[i]));
            }
        }
        return nums;
    }
}
