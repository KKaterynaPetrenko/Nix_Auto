package bill_Traker.service;

import bill_Traker.dao.BillDao;
import bill_Traker.dao.BillDaoImpl;
import bill_Traker.db.DBInMemory;
import bill_Traker.entity.Bill;

import java.util.List;

public class BillServiceImp implements BillService {
    private final BillDaoImpl billDao = new BillDaoImpl();

    @Override
    public void create(Bill bill) {
        DBInMemory.getInstance().insert(bill);
    }

    @Override
    public void update(Bill bill) {
        billDao.update(bill);

    }

    @Override
    public void delete(String id) {
        billDao.delete(id);

    }


    @Override
    public Bill findById(String id) {
        return billDao.findById(id);
    }

    @Override
    public List<Bill> getAll() {
        return DBInMemory.getInstance().selectAll();
    }
}
