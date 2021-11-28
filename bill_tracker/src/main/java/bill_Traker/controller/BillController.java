package bill_Traker.controller;

import bill_Traker.entity.Bill;
import bill_Traker.entity.BillItem;
import bill_Traker.entity.Kind;
import bill_Traker.service.BillServiceImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class BillController {
    private final BillServiceImp service = new BillServiceImp();
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your options:");
        menu();
        String option;
        while ((option = reader.readLine()) != null) {
            switchToCrudOperations(option, reader);
            menu();
        }
    }
    private void menu() {
        System.out.println();
        System.out.println("if you want create bill, please enter 1");
        System.out.println("if you want update bill, please enter 2");
        System.out.println("if you want delete bill, please enter 3");
        System.out.println("if you want select bill, please enter 4");
        System.out.println("if you want sort by kind of products, please enter 5");
        System.out.println("if you want select all bills, please enter 6");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void switchToCrudOperations(String option, BufferedReader reader) throws IOException {
        switch (option) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> sortBy(reader);
            case "6" -> readAll();
            case "0" -> System.exit(0);
            default -> System.out.println("incorrect input value");
        }
    }

    private BillItem createBillItem(BufferedReader reader) throws IOException {
        System.out.println("Please, enter kind of product (GROCERY, DRUGS, CLOTHES):");
        String kindString = reader.readLine();
        Kind kind = Kind.valueOf(kindString);

        System.out.println("Please, enter name:");
        String name = reader.readLine();

        System.out.println("Please, enter price:");
        String priceString = reader.readLine();
        BigDecimal price = new BigDecimal(priceString);

        BillItem billItem = new BillItem();
        billItem.setKind(kind);
        billItem.setName(name);
        billItem.setPrice(price);

        return billItem;
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("BillController.create");

        Bill bill = new Bill();
        while (true) {
            BillItem billItem = createBillItem(reader);
            bill.addItem(billItem);
            System.out.println("Continue? (y/n)");
            String operation = reader.readLine();
            if (operation.equals("n")) {
                break;
            }
        }

        service.create(bill);
        System.out.println(bill);
    }

    private void readAll() {
        var bills = service.getAll();
        System.out.println(bills);
    }
    private void menuUpdateItem() {
        System.out.println();
        System.out.println("if you want update bill item, please enter 1");
        System.out.println("if you want delete bill item, please enter 2");
        System.out.println("if you want add bill item, please enter 3");
    }


    private void update(BufferedReader reader) throws IOException {
        System.out.println("BillController.update");

        System.out.println("Please, enter bill id:");
        String id = reader.readLine();
        Bill bill = service.findById(id);

        System.out.println(bill);

        menuUpdateItem();

        String chooseOperation = reader.readLine();
        if (chooseOperation.equals("1")) {
            System.out.println("Please, enter bill item id");
            String itemId = reader.readLine();
            int intId = Integer.parseInt(itemId);
            BillItem billItem = bill.findBillItem(intId);

            System.out.println("Please, enter kind of new product (GROCERY, DRUGS, CLOTHES):");
            String kindString = reader.readLine();
            Kind kind = Kind.valueOf(kindString);

            System.out.println("Please, enter new name");
            String name = reader.readLine();

            System.out.println("Please, enter new price");
            String priceString = reader.readLine();
            BigDecimal price = new BigDecimal(priceString);

            billItem.setKind(kind);
            billItem.setName(name);
            billItem.setPrice(price);
            service.update(bill);
        }

        if (chooseOperation.equals("2")) {
            System.out.println("Please, enter bill item id");
            String itemId = reader.readLine();
            int intId = Integer.parseInt(itemId);
            BillItem billItem = bill.findBillItem(intId);
            bill.deleteById(intId);
            System.out.println("Item is deleted");
        }
        if (chooseOperation.equals("3")) {
            BillItem newItem = createBillItem(reader);
            bill.addItem(newItem);
            System.out.println("New Item is added!");
        }
    }

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("BillController.findById");
        System.out.println("Please, enter id:");
        String id = reader.readLine();
        Bill bill = service.findById(id);
        System.out.println("bill = " + bill);
    }
    private void delete(BufferedReader reader) throws IOException {
        System.out.println("BillController.delete");
        System.out.println("Please, enter id:");
        String id = reader.readLine();
        service.delete(id);
        System.out.println("Current bill is deleted");
    }

    private void sortBy(BufferedReader reader) throws IOException {
        System.out.println("Please, enter type of product (GROCERY, DRUGS, CLOTHES)");
        String kindString = reader.readLine();
        Kind kind = Kind.valueOf(kindString);
        var bills = service.getAll();
        for (Bill bill: bills) {
            System.out.println(bill.getId());
            List<BillItem> result = bill.filterBy(kind);
            for (BillItem billItem: result) {
                System.out.println(billItem);
            }
        }
    }
}
