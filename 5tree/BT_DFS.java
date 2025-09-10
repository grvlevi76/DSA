//binart tree level order travsersal
// i have made my own  custom queue for it 
class node {
    int value;
    node left;
    node right ;

    node(){};
    node (int value) {
        this.value = value;
        left = right = null;
    }
}

class queue {           //we r using our custom queue for level order traversel
    node node;
    queue next;

    queue(node root) {
        node = root;
        next = null;
    }
}

public class BT_DFS {
    node root;           //root of our binary tree (all the subtree will get extend from here)  
    queue q;             //queue for BFS

    public void level_traverse(node root) {
        if(root == null) {
            System.out.println("no elements in tree");
            return;
        }
        System.out.printf("Elements in Binary tree are : ");
        q_enque(root);

        while(true) {
            int i=0;
            int n = q_size();
            
            while(i<n) {
                queue temp = q_deque();
                System.out.printf("%d ",temp.node.value);

                if(temp.node.left!=null) {
                    q_enque(temp.node.left);
                }
                if(temp.node.right!=null) {
                    q_enque(temp.node.right);
                }
                i++;
            }
            if(q==null) {
                break;
            }
        }
        
    }
    public static void main(String[] args) {
        BT_DFS t = new BT_DFS();

        t.root = new node(1);
        t.root.left = new node(2);
        t.root.right = new node(3);
        t.root.left.left = new node(4);
        t.root.right.left = new node(6);
        t.root.right.right = new node(7);

        t.level_traverse(t.root);
        System.out.println();
    }

    public void q_enque(node root) {
        if(q==null) {
            q = new queue(root);
            return;
        }
        queue temp = q;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = new queue(root);
    }
    public queue q_deque() {
        if(q ==null) {
            return q;
        }
        queue temp = q; 
        q = q.next;
        return temp;
    }

    public int q_size() {
        queue temp = q;
        int s=0;
        while(temp!=null) {
            s++;
            temp = temp.next;
        }
        return s;
    }
}
