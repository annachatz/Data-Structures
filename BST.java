import java.util.Comparator;
public class BST {
    private TreeNode head;
    public BST(){
        this.head = null;
    };
    public void insert(Node node){
        TreeNode current = head;
        if(head == null){
            head = new TreeNode(node);
        }
        else{
            if(((Object)node.key).getClass().getSimpleName().equals("String")){
                while(true){
                    if(current.getKey().equals(node.getKey())){
                        current.setValue(node);
                        return;
                    }
                    if(String.valueOf((current.getKey())).compareTo(String.valueOf(node.getKey()))<0){
                        if(current.getRight() == null){
                            current.setRight(new TreeNode(node));
                            return;
                        }
                        else{
                            current = current.getRight();
                        }
                    }
                    else{
                        if(current.getLeft() == null){
                            current.setLeft(new TreeNode(node));
                            return;
                        }
                        else{
                            current = current.getLeft();
                        }
                    }
                }
            }
            else if(((Object)node.key).getClass().getSimpleName().equals("Integer")){
                while(true){
                    if(current.getKey().equals(node.getKey())){
                        current.setValue(node);
                        return;
                    }
                    if(Integer.valueOf((Integer)current.getKey())<(Integer)node.getKey()){
                        if(current.getRight() == null){
                            current.setRight(new TreeNode(node));
                            return;
                        }
                        else{
                            current = current.getRight();
                        }
                    }
                    else{
                        if(current.getLeft() == null){
                            current.setLeft(new TreeNode(node));
                            return;
                        }
                        else{
                            current = current.getLeft();
                        }
                    }
                }
            }

        }
    }
    public Node find(Object key){
        TreeNode current = head;
        int flag;
        if(((Object)key).getClass().getSimpleName().equals("String")){
            flag =0;
            while(true){
                if(current == null){
                    return null;
                }
                if(current.getKey().equals(key)){
                    return current.node;
                }
                if(String.valueOf((current.getKey())).compareTo(String.valueOf(key))<0){
                    current = current.getRight();
                }
                else{
                    current = current.getLeft();
                }
            }
        }
        else if(((Object)key).getClass().getSimpleName().equals("Integer")){
            while(true){
                if(current == null){
                    return null;
                }
                if(current.getKey().equals(key)){
                    return current.node;
                }
                if(Integer.valueOf((Integer)current.getKey())<(Integer)key){
                    current = current.getRight();
                }
                else{
                    current = current.getLeft();
                }
            }
        }
        return null;
    }

    public void remove(Object key){
        TreeNode current = head;
        TreeNode parent = null;
        int flag;               //flag =0 when key is String, whereas flag =1 when key is Integer
        if(((Object)key).getClass().getSimpleName().equals("String")){
            flag =0;
            while(true){
                if(current == null)
                    return;
                if(current.getKey().equals(key))
                    break;
                parent = current;
                if(String.valueOf((current.getKey())).compareTo(String.valueOf(key))<0)
                    current = current.getRight();
                else
                    current = current.getLeft();
            }
        }
        else if(((Object)key).getClass().getSimpleName().equals("Integer")){
            flag = 1;
            while(true){
                if(current == null)
                    return;
                if(current.getKey().equals(key))
                    break;
                parent = current;
                if(Integer.valueOf((Integer)current.getKey())<(Integer)key)
                    current = current.getRight();
                else
                    current = current.getLeft();
            }
        }

        //node to replace with
        TreeNode replace = null;
        //only right
        if(current.getLeft() == null)
            replace = current.getRight();
        else if(current.getRight() == null)
            replace = current.getLeft();
        else{
            //find left most child of current right subtree
            TreeNode findCurrent = current.getRight();

            while(true){
                if(findCurrent.getLeft()!= null)
                    findCurrent = findCurrent.getLeft();
                else
                    break;
            }

            //only has zero or one child
            remove(findCurrent.getKey());

            findCurrent.setLeft(current.getLeft());
            findCurrent.setRight(current.getRight());
            replace = findCurrent;
        }
        //replace parents reference
        if(parent == null){ //head
            head = replace;
        }
        else{
            if(parent.getLeft() == current)
                parent.setLeft(replace);
            if(parent.getRight() == current)
                parent.setRight(replace);
        }
    }

    private class TreeNode<E>{
        Node node;
        TreeNode left;
        TreeNode right;
        TreeNode(Node in_node){
            this.node = in_node;
        }
        public void setValue(Node in_node){
            this.node.setData(in_node.getData());
        }
        public E getData(){
            return (E) this.node.getData();
        }

        public E getKey(){
            return (E) this.node.getKey();
        }

        public void setRight(TreeNode r){
            this.right = r;
        }
        public void setLeft(TreeNode l){
            this.left = l;
        }
        public TreeNode getLeft() {
            return left;
        }
        public TreeNode getRight() {
            return right;
        }
    }
}
