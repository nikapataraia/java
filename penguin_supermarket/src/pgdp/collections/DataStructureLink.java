package pgdp.collections;

public class DataStructureLink<T> {
    private final DataStructureConnector<T> First;
    private final DataStructureConnector<T> Second;
    public DataStructureLink(DataStructureConnector<T> first, DataStructureConnector<T> second){
        this.First = first;
        this.Second = second;
    }
    public boolean moveNextFromAToB(){
        if(First.hasNextElement()){
            Second.addElement(First.removeNextElement());
            return true;
        }
        return false;
    }
    public void moveAllFromAToB(){
        while (First.hasNextElement()){
            Second.addElement(First.removeNextElement());
        }
    }
}
