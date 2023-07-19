package java.Btree;

import java.util.ArrayList;

public class Node {
    public ArrayList<int> elements;
    public ArrayList<Node> roots;
    public int siz;
    public Node parrent;
    public Node(int a){
        this.siz = a;
        this.elements = new ArrayList<>(a);
        this.roots =  new ArrayList<>(a+1);
    }

    public void makechildof(Node par){
        this.parrent = par;
    }
    public int search_spot(int el){
        int result = 0;
        for(int i = 0; i < elements.length(); i++){
            if(el < elements[i]){
                break;
            }
            result++;
        }
        return result;
    }

    public int add(int el){
        int index = search_spot(el);
        ArrayList<int> tmparr = new ArrayList<>();
        ArrayList<Node> tmpnode = new ArrayList<>();
        for(int i = 0;i < elements.length(); i++){
                if(i == index){
                    tmparr.add(el)
                }
                tmparr.add(elements.get(i))
            }
        for(int i = 0; i < roots.length(); i++){
            if(i == index){
                
            }
        }
        if(elements.length() == siz){

        }
        else{
            
        }
        
        
    }

}
