public class IntDoubleList {
    private IntDoubleListElement head;
    private IntDoubleListElement tail;
    public IntDoubleList(){
        head = null;
        tail = null;
    }
    public void append(int info){
        IntDoubleListElement newElement = new IntDoubleListElement(info);
        if(head == null){
            head = newElement;
            tail = newElement;
        }
        else{
            tail.next = newElement;
            newElement.prev = tail;
            tail = newElement;
        }
    }
    public IntDoubleListElement getFirstElement(){
        return head;
    }
    public IntDoubleListElement getLastElemnt(){
        return tail;
    }
    public int size(){
        if(head == null)return 0;
        int count = 1;
        IntDoubleListElement temp = head;
        while(temp.next!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public int get(int pos){
        if(pos < 0 || pos+1 > this.size()) return -1;
        IntDoubleListElement temp = head;
        for(int i = 0; i < pos; i++ ){
            temp = temp.next;
        }
        return temp.getInfo();
    }
    public void remove(int pos){
        if(pos < 0 || pos+1 > this.size()) System.out.println("error");
        IntDoubleListElement temp = head;
        if(pos == 0){
            head = head.next;
            if(head!=null){
                head.prev = null;
            }
            else tail = null;
        }
        else{
            int i = 0;
            while(i<pos){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if(temp.next != temp){
                temp.next.prev = temp;
            }
            else{
                tail = temp;
            }
        }
    }
    public String toString(){
        if(head == null){
            return null;
        }
        IntDoubleListElement b = head;
        StringBuilder a = new StringBuilder();
        while(b != null){
            if(b.next!=null){
            a.append(b.getInfo()+", ");}
            else a.append(b.getInfo());
            b=b.next;
        }
        return a.toString();
    }
    public boolean isEqual(IntDoubleList other){
        if(this.size() != other.size())return false;
        IntDoubleListElement a = head;
        IntDoubleListElement b = other.getLastElemnt();
        while(a != null || b!= null){
            if(a.getInfo() != b.getInfo()){
                return false;
            }
            a=a.next;
            b=b.next;
        }
        return true;
    }
    public int sum(){
        IntDoubleListElement a = head;
        int result = 0;
        while(a!=null){
            result = result + a.getInfo();
            a = a.next;
        }
        return result;
    }
    public IntDoubleList copy(){
        IntDoubleList result = new IntDoubleList();
        if(this.size() == 0)return null;
        IntDoubleListElement element = head;
        while(element!=null){
            result.append(element.getInfo());
            element = element.next;
        }
        return result;
    }
    public IntDoubleListElement[] search(int intValue){
        IntDoubleListElement[] result = new IntDoubleListElement[this.size()];
        int j = 0;
        IntDoubleListElement temp = head;
        while(temp!=null){
            if(temp.getInfo() == intValue){
                result[j] = temp;
                j++;
            }
            temp = temp.next;
        }
        IntDoubleListElement[] res = new IntDoubleListElement[j];
        for(int i =0; i < j; i++){
            res[i] = result[i];
        }
        return res;
    }
    public static void main(String[] args) {
        IntDoubleListElement a = new IntDoubleListElement(6);
        IntDoubleList b = new IntDoubleList();
        b.append(5);
        b.append(4);
        a.next = new IntDoubleListElement(5);
        System.out.println(b.toString());
    }
}

