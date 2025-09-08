//i was having hard time implementing insertion in BT in DFS way so i ended up creating my own way 


class node  {
    int value;
    node left;
    node right;
    node(int value)  {
        this.value = value;
        left = right = null;
    }
}

public class Binary_tree {
    
    static int last_lvl= 0;  //max level of tree
    static int last_lvl_nod =0;       //avilable no. nodes in last level

    public static void main(String[] args)  {
        Binary_tree bt = new Binary_tree();

        node root = new node(1);
        last_lvl_nod++;

        //bt.insertion(bt.root,1,0);
        bt.insertion(root,2,0);
        bt.insertion(root,3,0);
        bt.insertion(root,4,0);
        bt.insertion(root,5,0);
        bt.insertion(root,6,0);

        System.out.printf("binary tree elements (inorder) : ");
        bt.traverse_inorder(root);
        System.out.println();

    }
    
    int insertion(node root, int key , int i) {   //i represent temperory level climber depending on recursion
        if(last_lvl_nod == Math.pow(2,last_lvl)) {
            last_lvl++;
            last_lvl_nod =0;
        }

        while(i<last_lvl-1) {
            if(insertion(root.left,key,i+1)==0) {
                return 0;
            }else {
                break;
            }
        }

        while(i<last_lvl-1) {
            if(insertion(root.right,key,i+1)==0) {
                return 0;
            }else {
                break;
            }
        }

        if(root.left==null)  {
            root.left=new node(key);
            last_lvl_nod++;
            return 0;
        }

        if(root.right==null)  {
            root.right=new node(key);
            last_lvl_nod++;
            return 0;
        }
        return 1;
    }

    void traverse_inorder(node root) {
        if(root == null) {
            return;
        }

        
        traverse_inorder(root.left);
        System.out.printf("%d ",root.value);
        traverse_inorder(root.right);
         
    }


}
