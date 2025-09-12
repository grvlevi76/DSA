//binart tree level order travsersal
// i have made my own  custom queue for it 
import java.util.Scanner;

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
    node root;           //root of our binary tree  
    queue q;             //queue for BFS

    public void level_traverse(node root) {
        if(root == null) {
            System.out.println("no elements in tree");
            return;
        }
        System.out.printf("Elements in Binary tree are : ");
        q = new queue(root);

        while(q!=null) {
            queue temp = q_deque();
            System.out.printf("%d ",temp.node.value);

            if(temp.node.left!=null) {
                q_enque(temp.node.left);
            }
            if(temp.node.right!=null) {
                q_enque(temp.node.right);
            }
        }
        
    }

    public void insert(int key) {
        if(root ==null) {
            root = new node(key);
            return;
        }
        q = new queue(root);
        while(true) {
            int i = 0;
            int n = q_size();
            while(i<n) {
                queue temp = q_deque();
                if(temp.node.left!=null) {
                    q_enque(temp.node.left);
                }else {
                    temp.node.left = new node(key);
                    return;
                }

                if(temp.node.right!=null) {
                    q_enque(temp.node.right);
                }else {
                    temp.node.right = new node(key);
                    return;
                }
                i++;
            }
        }
    }

    public void delete(int key) {
        if(root == null) {
            System.out.println("tree is empty ! nothing to delete");
            return;
        }
        if(root.value ==key && root.left==null && root.right ==null) {
            root =null;
            System.out.println(key + " successfully deleted");
            return;
        }

        //finding the key
        q = new queue(root);
        node keyNode = null;
        node lastNode = null;
        node parentOfLast = null;

    while (q != null) {
        queue temp = q_deque();
        if (temp.node.value == key) {
            keyNode = temp.node;
        }
        if (temp.node.left != null) {
            parentOfLast = temp.node;
            lastNode = temp.node.left;
            q_enque(temp.node.left);
        }
        if (temp.node.right != null) {
            parentOfLast = temp.node;
            lastNode = temp.node.right;
            q_enque(temp.node.right);
        }
    }

        //if key not found
        if(keyNode ==null) {
            System.out.println(key+" doesn't  exist in tree");
            return;
        }

        //exchange the found key with  last node value
        keyNode.value = lastNode.value;

        // Delete last node
        if (parentOfLast.left == lastNode) {
            parentOfLast.left = null;
        } else if (parentOfLast.right == lastNode) {
            parentOfLast.right = null;
        }
        System.out.println(key + " successfully deleted");

    }

    public static void main(String[] args) {
        BT_DFS t = new BT_DFS();
        Scanner sc = new Scanner(System.in);

        t.root = null;
        int val;

        int ch;
        do{
            System.out.println("Insert : ");
            System.out.println("1 for insertion \n2 for deletion \n3 for travserse\n4 for exit ");
            System.out.printf("Enter choice : ");
            ch = sc.nextInt();

            switch(ch) {
                case 1 : 
                    System.out.printf("enter the value to insert : ");
                    val=sc.nextInt();
                    t.insert(val);
                    t.level_traverse(t.root);
                    break;

                case 2 :
                    System.out.printf("enter the value to delete : ");
                    val = sc.nextInt();
                    t.delete(val);
                    t.level_traverse(t.root);
                    break;

                case 3 :
                    t.level_traverse(t.root);
                    break;

                default :
                    sc.close();
                    System.exit(0);

            }
        }while(true);
    }


    //queue functions

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
