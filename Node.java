public class Node<E> {
     E key;
     E data;
    private int hitCount = 0;
    Node prev;
    Node next;
    public Node(E in_key, E in_data){
        this.key = in_key;
        this.data = in_data;
    }
    public void setData(E in_data){
        this.data = in_data;
    }
    public E getData(){
        return data;
    }

    public E getKey(){
        return key;
    }

    public Node<E> getNext(){
        return next;
    }

    public Node<E> getPrev(){
        return prev;
    }

    public void setNext(Node<E> in_next){
        this.next = in_next;
    }

    public void setPrev(Node<E> in_prev){
        this.prev = in_prev;
    }

    public void increaseHitCount(){
        this.hitCount++;
    }
    public int getHitCount(){
        return this.hitCount;
    }


}
