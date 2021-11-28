package bill_Traker.db;

import bill_Traker.entity.Bill;
import bill_Traker.entity.BillItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DBInMemory {
    private static final List<Bill> bills  = new ArrayList<>();
    private final static DBInMemory instance = new DBInMemory();

    private DBInMemory() { }

    public static DBInMemory getInstance() {
        return instance;
    }

    public void insert(Bill bill) {
        bill.setId(generateId());
        bills.add(bill);
    }

    public Bill selectById(String id) {
        for (Bill bill : bills) {
            if (bill.getId().equals(id)) {
                return bill;
            }
        }
        return null;
    }

    public List<Bill> selectAll() {
        return bills;
    }

    public void delete(String id) {
        bills.removeIf(bill -> bill.getId().equals(id));
    }

    public void update(Bill bill) {
        for (Bill current : bills) {
            if (current.getId().equals(bill.getId())) {
                current = bill;
            }
        }
   }


    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
