package pgdp.collections;

public class Checkout {
    private final Queue<PenguinCustomer> line;
    private final Queue<FishyProduct> onbelt;
    private final Queue<FishyProduct> ontape;

    public Checkout() {
        line = new LinkedQueue<>();
        onbelt = new LinkedQueue<>();
        ontape = new LinkedQueue<>();
    }

    public Queue<PenguinCustomer> getQueue() {
        return line;
    }

    public Queue<FishyProduct> getBandBeforeCashier() {
        return ontape;
    }

    public Queue<FishyProduct> getBandAfterCashier() {
        return onbelt;
    }

    public int queueLength() {
        return line.size();
    }

    public void serveNextCustomer() {
        if (!line.isEmpty()) {
            PenguinCustomer a = line.dequeue();
            int price = 0;
            a.placeAllProductsOnBand(onbelt);

//            DataStructureConnector<FishyProduct> belt = new QueueConnector<>(onbelt);
//            DataStructureConnector<FishyProduct> tape = new QueueConnector<>(ontape);
//            DataStructureLink<FishyProduct> liink = new DataStructureLink<FishyProduct>(belt, tape);
//            liink.moveAllFromAToB();
//            DataStructureConnector<FishyProduct> oncart = new StackConnector<>(a.getProducts());
//            DataStructureLink<FishyProduct> seclink = new DataStructureLink<FishyProduct>(tape, oncart);
//            a.takeAllProductsFromBand(ontape);
            while (!onbelt.isEmpty()){
                FishyProduct savedprod = onbelt.dequeue();
                price = price + savedprod.getPrice();
                ontape.enqueue(savedprod);
            }
            a.pay(price);
            a.takeAllProductsFromBand(ontape);
        }
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "line=" + line +
                ", onbelt=" + onbelt +
                ", ontape=" + ontape +
                '}';
    }
}

