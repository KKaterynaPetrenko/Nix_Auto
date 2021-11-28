package bill_Traker.dao;

import bill_Traker.db.DBInMemory;
import bill_Traker.entity.Bill;

import java.util.List;

public class BillDaoImpl implements BillDao {
    private final DBInMemory db = DBInMemory.getInstance();

    @Override
    public void create(Bill bill) {
        db.insert(bill);
    }

    @Override
    public void update(Bill bill) {
        db.update(bill);

    }

    @Override
    public void delete(String id) {
        db.delete(id);

    }


    @Override
    public Bill findById(String id) {
        return db.selectById(id);
    }


    @Override
    public List<Bill> findAll() {
       return db.selectAll();
    }
}
