package pgdp.collections;

public class FishyProduct {
    private final String name;
    private final int price;
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public FishyProduct(String name, int price){
        if(name == null || price <=0){
            ExceptionUtil.unsupportedOperation("either name is null or price is equal or lower than 0");
        }
        this.name = name;
        this.price = price;
    }



    @Override
    public String toString() {
        return "FishyProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

