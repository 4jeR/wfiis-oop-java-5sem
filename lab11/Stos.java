public class Stos<T>{
    public Stos(){
        head = null;
        size = 0;
    }
    public void push(T val){
        if (size == 0){
            head = new Node<T>(val);
            ++size;
        }
        else {
            int i = 0;
            Node<T> traveller = head;
            while(traveller.next != null && i < size){
                traveller = traveller.next;
                ++i;
            }
            traveller.push(val);
        }
        ++size;
    }
    void pop(){
        head.pop();
        --size;
    }
    public String toString(){
        return head.toString();
    }
    private Node<T> head;
    private int size = 0;
}
