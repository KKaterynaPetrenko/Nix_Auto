package bill_Traker.entity;

import java.math.BigDecimal;

public class BillItem {
    private static Integer lastId = 0;

    private Kind kind;
    private Integer id = ++lastId;
    private String name;
    private BigDecimal price;


    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Bill Item {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ",price ='" + price + '\''+
                '}';
    }
}
