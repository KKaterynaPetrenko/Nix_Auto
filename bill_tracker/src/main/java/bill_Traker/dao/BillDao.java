package bill_Traker.dao;

import bill_Traker.entity.Bill;

import java.util.List;

public interface BillDao {
    void create(Bill bill);
    void update(Bill bill);
    void delete(String id);
    Bill findById(String id);
    List<Bill> findAll();

}
