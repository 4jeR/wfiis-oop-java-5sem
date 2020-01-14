public class Node<T>{
    public T value;
    public Node<T> next;

    public Node(T val){
        value = val;
        next = null;
    }
    
    public void push(T val){
        next = new Node<T>(val);
        next.next = null;
    }

    void pop(){
        next.next = null;
    }

    public String toString(){
        if(next != null){
            return next.toString() + " {" + value + "}";
        }
        else return "{" + value + "}";
    }
}