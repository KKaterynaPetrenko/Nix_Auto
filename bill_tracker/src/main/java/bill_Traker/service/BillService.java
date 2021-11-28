package bill_Traker.service;

import bill_Traker.entity.Bill;

import java.util.List;

public interface BillService {
    void create(Bill bill);
    void update(Bill bill);
    void delete(String id);
    Bill findById(String id);
    List<Bill> getAll();
}
