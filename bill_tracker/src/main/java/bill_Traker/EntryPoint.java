package bill_Traker;

import bill_Traker.controller.BillController;

import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException {
            BillController controller = new BillController();
            controller.run();
    }
}
