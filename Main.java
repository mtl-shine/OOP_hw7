import controller.Controller;
import service.ComplexService;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view, new ComplexService(view));
        controller.startCalc();
    }
}
