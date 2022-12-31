public class CacheImpl implements Cache{
    private BST tree;
    private int size;
    private Node head,tail;
    private final int CAPACITY;
    private long hitCount = 0;
    private long missCount = 0;
    private long lookups = 0;

    public CacheImpl(int in_capacity){
        this.CAPACITY = in_capacity;
        tree = new BST();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        size = 0;

    }

    public void deleteNode(Node node){
        if(node ==null){
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    @Override
    public Object lookUp(Object key) {
        lookups++;
        if(tree.find(key)!=null){
            hitCount++;
            Node n =  tree.find(key);
            Object result = n.getData();
            deleteNode(n);
            addToHead(n);
            //System.out.println("Got the value : " + result + " for the key: " + key);
            return result;
        }
        //System.out.println("Did not get any value" + " for the key: " + key);
        missCount++;
        return null;
    }

    @Override
    public void store(Object key, Object value) {
        //System.out.println("Going to set the (key, " + "value) : (" + key + ", " + value + ")");
            if(tree.find(key)!= null){
                Node n = (Node)tree.find(key);
                n.data = value;
                deleteNode(n);
                addToHead(n);
            }
            else{

                Node n = new Node(key,value);
                tree.insert(n);
                if(size<CAPACITY){
                    size++;
                    addToHead(n);
                }
                else{
                    tree.remove(tail.prev.key);
                    deleteNode(tail.prev);
                    addToHead(n);
                }
            }

    }

    @Override
    public double getHitRatio() {
        return (double)hitCount/((double)hitCount+(double)missCount);
    }

    @Override
    public long getHits() {
        return hitCount;
    }

    @Override
    public long getMisses() {
        return missCount;
    }

    @Override
    public long getNumberOfLookUps() {
        return lookups;
    }


}
