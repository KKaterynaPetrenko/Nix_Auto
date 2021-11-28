package bill_Traker.entity;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private String id;
    private final List<BillItem> items = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addItem(BillItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        String result = "";
        for (BillItem item : items) {
            result += item.toString();
        }
        return "Bill {" +
                "id='" + id + '\'' + result +
                "}\n";
    }

    public BillItem findBillItem(Integer ItemId) {
        for (BillItem item : items) {
            if (item.getId() == ItemId)
                return item;
        }
        return null;
    }

    public void deleteById(Integer ItemId) {
        BillItem item = findBillItem(ItemId);
        items.remove(item);
    }

    public List<BillItem> filterBy(Kind kind) {
        List<BillItem> result = new ArrayList<>();
        for (BillItem item: items) {
            if (item.getKind() == kind) {
                 result.add(item);
            }
        }
        return result;
    }
}
