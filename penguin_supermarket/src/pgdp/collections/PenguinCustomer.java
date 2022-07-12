package pgdp.collections;

public class PenguinCustomer {
    private final String name;
    private int money;
    private final Stack<FishyProduct> products;
    public PenguinCustomer(String name, int money){
        if(name == null|| money < 0) ExceptionUtil.unsupportedOperation("this penguin has no name or is in dept, would u like to be in a same situation? yee, thought so");
        products = new LinkedStack<>();
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public Stack<FishyProduct> getProducts() {
        return products;
    }
    public void addProductToBasket(FishyProduct prod){
        products.push(prod);
    }
    public void placeAllProductsOnBand(Queue<FishyProduct> queue){
//        DataStructureLink<FishyProduct> a = new DataStructureLink<FishyProduct>((DataStructureConnector) products,(DataStructureConnector) queue);
        DataStructureConnector<FishyProduct> a = new StackConnector<>(products);
        DataStructureConnector<FishyProduct> b = new QueueConnector<>(queue);
        DataStructureLink<FishyProduct> c = new DataStructureLink<>(a,b);
        c.moveAllFromAToB();
    }
    public void takeAllProductsFromBand(Queue<FishyProduct> queue){
//        DataStructureLink<FishyProduct> a = new DataStructureLink<FishyProduct>((DataStructureConnector) queue ,(DataStructureConnector) products);
        DataStructureConnector<FishyProduct> a = new StackConnector<>(products);
        DataStructureConnector<FishyProduct> b = new QueueConnector<>(queue);
        DataStructureLink<FishyProduct> c = new DataStructureLink<>(b,a);
        c.moveAllFromAToB();
    }
    public void pay(int bill){
        if(bill < 0) ExceptionUtil.unsupportedOperation("i dont take things for free");
        if(money < bill) ExceptionUtil.unsupportedOperation("not enough money m8");
        money = money - bill;
    }

    @Override
    public String toString() {
        return "PenguinCustomer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", cart=" + products.toString() +
                '}';
    }
    public void goToCheckout(PenguinSupermarket market){
        market.getCheckoutWithSmallestQueue().getQueue().enqueue(this);
    }
}

