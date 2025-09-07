class node {
    int value;
    node left_ch;
    node right_ch;
}

public class BST {
    node root;
    node new1;

    public void insert(int val) {   //insertion in BST assuming insertion happenes by checking key to root node value 
        new1 = new node();
        new1.value = val;
        if(root == null) {
            root = new1;
        } else {
            node temp =  root;
            do {
                if(val<temp.value) {
                    if(temp.left_ch==null) {
                        temp.left_ch= new1;
                        return;
                    }    
                    temp = temp.left_ch;
                }else {
                    if(temp.right_ch==null) {
                        temp.right_ch= new1;
                       return;
                    }    
                    temp = temp.right_ch;
                }
            }while(true);
        }
    }

    public void search(int key) {
        if(root ==null) {
            System.out.println("there's no element in tree");
        }else{
            node temp = root;
            int level = 1;
            do {
                if(key==temp.value) {
                    System.out.println(key + " exist in tree at level " + level );
                    return;
                }else if(key<temp.value) {
                    if(temp.left_ch==null) {
                        System.out.println(key + "doesn't exist in tree");
                        return;
                    }
                    temp = temp.left_ch;
                    level++;
                }else {
                    if(temp.right_ch==null) {
                        System.out.println(key + " doesn't exist in tree");
                        return;
                    }
                    temp = temp.right_ch;
                    level++;
                }
            }while(true);
        }
    }

    public node delete (node root, int key) {
        //taken from gfg
        if(root==null) {
                System.out.println("there's no element " + key + " in tree");
                return null;
        }

        if(key<root.value) {
            root.left_ch = delete(root.left_ch, key);
        }else if(key>root.value) {
            root.right_ch = delete(root.right_ch, key);
        }else{
            //when only 1 child available
            if(root.left_ch==null) {
                return root.right_ch;
            }
            if(root.right_ch==null) {
                return root.left_ch;
            }

            //when both child r available
            //finding inorder least successor
            node temp =  root;
            temp = temp.right_ch;
            while(temp.left_ch!=null) {
                temp  = temp.left_ch;
            }
            root.value = temp.value;  //copy the successor

            root.right_ch = delete(root.right_ch,temp.value);  //then delete or replace the original least successor

        }

        return root;
    }

    public void traverse_in( node root) {
        //in order
        //always shows elements in ascending order in BST
        if(root == null) {
            System.out.println("tree is empty");
        }else {
            if(root == this.root) {
                System.out.println("element in trees are : ");
            }

            //for traversal of left subtree
            if(root.left_ch!=null) {
                traverse_in(root.left_ch);
                System.out.println(root.value);
            }else {
                System.out.println(root.value);
            }
            //for traversal of right subtre
            if(root.right_ch!=null) {
                traverse_in(root.right_ch);
            }

        }
    }

    public void traverse_pre( node root) {
        //pre order
        if(root == null) {
            System.out.println("tree is empty");
        }else {
            if(root == this.root) {
                System.out.println("element in trees are : ");
            }

            System.out.println(root.value);  //print root node of subtree
            //for traversal of left subtree
            if(root.left_ch!=null) {
                traverse_pre(root.left_ch);
            }
            //for traversal of right subtre
            if(root.right_ch!=null) {
                traverse_pre(root.right_ch);
            }

        }
    }

    public void traverse_post( node root) {
        //post order
        if(root == null) {
            System.out.println("tree is empty");
        }else {
            if(root == this.root) {
                System.out.println("element in trees are : ");
            }

            //for traversal of left subtree
            if(root.left_ch!=null) {
                traverse_post(root.left_ch);
            }
            //for traversal of right subtre
            if(root.right_ch!=null) {
                traverse_post(root.right_ch);
            }
            System.out.println(root.value);  //print root node of subtree

        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(8);
        tree.insert(9);
        tree.insert(11);

        tree.traverse_in(tree.root);
        tree.traverse_pre(tree.root);
        tree.traverse_post(tree.root);
        
        tree.search(12);

        tree.delete(tree.root,9);
        System.out.println("after delete : ");
        tree.traverse_in(tree.root);
        tree.traverse_pre(tree.root);

    }
}