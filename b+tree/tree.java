import java.util.ArrayList;

public class tree{
    public int len;
    public node root;
    public class node{
        private int len;
        ArrayList<node> childer = new ArrayList<>();
        ArrayList<Integer> elements = new ArrayList<>();
        node parrent;
        boolean isleaf;
        public node(int len,boolean isleaf){
            this.len = len;
            this.isleaf = isleaf;
        }
        public void add_leaf(int newel){
            node toadd = root;
            while(!this.isleaf){
                int j = 0;
                while(j < len){
                    if(newel >= elements.get(j)){
                        break;
                    }
                    j++;
                }
                toadd = childer.get(j);
            }
            int j = 0;
            while(j < len){
                if(newel >= elements.get(j)){
                    break;
                }
                j++;
            }
            ArrayList<Integer> fir = (ArrayList<Integer>) elements.subList(0, j);
            ArrayList<Integer> sec = (ArrayList<Integer>) elements.subList(j, len);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(fir);
            temp.add(newel);
            temp.addAll(sec);
            if(j == len){
                ArrayList<Integer> left = (ArrayList<Integer>) temp.subList(0, (len+1)/2);
                ArrayList<Integer> right = (ArrayList<Integer>) temp.subList((len+1)/2, len + 1);
                if(this.isleaf){

                }
            }
            else{
                this.elements = temp;
            }

        }
        public void add_nonleaf(int el){

        }
    }
    public tree(int len){
        while(len < 1){
            System.out.println("length must be > 0 , try for new length");
            // system input = len
        }
        this.len = len;
        root = new node(len,true);
    }
    public void add(int el){
        root.add_leaf(el);
    }
    public static void main(String[] args) {
    }
}