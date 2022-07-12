package pgdp.collections;

public class PenguinSupermarket {
    private Checkout[] checkoutpoints;
    public PenguinSupermarket(int size){
        if(size<=0) ExceptionUtil.illegalArgument("u dont see supermarkets irl that have minus amount of registers do u?");
        checkoutpoints = new Checkout[size];
        for(int i = 0; i < size; i++){
            checkoutpoints[i] = new Checkout();
        }
    }

    public Checkout[] getCheckouts() {
        return checkoutpoints;
    }
    public Checkout getCheckoutWithSmallestQueue(){
        Checkout a= checkoutpoints[0];
        int Min = Integer.MAX_VALUE;
        for (Checkout checkoutpoint : checkoutpoints) {
            if (checkoutpoint == null) return checkoutpoint;
            if (checkoutpoint.queueLength() < Min) {
                Min = checkoutpoint.queueLength();
                a = checkoutpoint;
            }
        }
        return a;
    }
    public void closeCheckout(int index){
        if(index >= checkoutpoints.length){
            ExceptionUtil.illegalArgument("choose ur indexes better u fucking polar bears");
        }
        if(index < 0){
            ExceptionUtil.illegalArgument("sry, if i close this register i will go out of buisness ;((");
        }
        if(checkoutpoints.length == 0){
            ExceptionUtil.unsupportedOperation("no registers exist");
        }
        if(checkoutpoints.length == 1){
            ExceptionUtil.illegalArgument("sry, if i close this register i will go out of buisness ;((");
        }
        Checkout[] b = new Checkout[checkoutpoints.length - 1];
        Checkout k = checkoutpoints[index];
        for(int i = 0 ; i < checkoutpoints.length; i++){
            if(i < index){
                b[i] = checkoutpoints[i];
            }
            if(i > index){
                b[i-1] = checkoutpoints[i];
            }
        }
        checkoutpoints = b;
        if(k.queueLength() == 0)return;
        DataStructureConnector<PenguinCustomer> c = new StackConnector<>(new LinkedStack<>());
        DataStructureConnector<PenguinCustomer> d = new QueueConnector<>(k.getQueue());
        DataStructureLink<PenguinCustomer> a = new DataStructureLink<>(d,c);
        a.moveAllFromAToB();
        while(c.hasNextElement()){
            c.removeNextElement().goToCheckout(this);
        }
    }
    public void serveCustomers(){
        for (Checkout checkoutpoint : checkoutpoints) checkoutpoint.serveNextCustomer();
    }

}
