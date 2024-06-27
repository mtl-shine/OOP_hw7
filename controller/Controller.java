package controller;

import view.View;
import service.ComplexService;
import model.*;

public class Controller {
    View view;
    OperationModel operation;
    ComplexService service;

    public Controller(View v, ComplexService s) {
        view = v;
        service = s;
    }

    public String operationChoice(String choice) {
        if (choice.trim().equals("1")) {
            operation = new AdditionModel(view);
            return "The sum of ";
        } else if (choice.trim().equals("2")) {
            operation = new MultiplicationModel(view);
            return "The product of ";
        } else if (choice.trim().equals("3")) {
            operation = new DivisionModel(view);
            return "The quotient of ";
        }
        return null;
    }

    public void startCalc() {
        boolean answer = true;
        while (answer) {
            String a = view.getNumber("Please, enter the first value: ");
            String b = view.getNumber("Please, enter the second value: ");
            String title = operationChoice(view.getOperationChoice());
            try {
                String res = operation.calculate(service.separateNumsAndComplexNums(service.separateNum(a), service.separateNum(b)));
                view.printResult(title, a, b, res);
            } catch (Exception e) {
                view.printInputError();
            }
            if (view.askToContinue().equals("2")) {
                answer = false;
            }
        }
    }

}
