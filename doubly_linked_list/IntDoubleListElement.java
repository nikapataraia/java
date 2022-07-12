public class IntDoubleListElement {
    public IntDoubleListElement next;
    public IntDoubleListElement prev;
    private int info;
    public IntDoubleListElement(int info){
        this.next = null;
        this.info = info;
        this.prev = null;
    }
    public int getInfo(){
        return info;
    }
    public void setInfo(int a){
        this.info = a;
    }
}
