class node {
    int value;
    node left;
    node right;
}

public class heap_sort {
    node start,new1,temp;
    public static void main(String[] args) {
        heap_sort heap = new heap_sort();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println("array : " + arr[3]);
        heap.binary_tree(arr);
    }

    void binary_tree(int[] arr) {
        int i=0;
        while(i<arr.length) {
            new1 = new node();
            new1.value= arr[i];
            if(start == null) {
                start= new1;
                temp = start;
            }else{
                if(temp.left == null) {
                    temp.left= new1;
                }else {
                    temp.right= new1;
                    if(temp ==start) {
                        temp = temp.left;
                    }else if(temp == start.left) {
                        temp = start.right;
                    }else {
                        temp = start.left.left;
                    }
                }
            }
        }
    }
}

//use doubly linked list 
//after inserting element in both the child ,the temp should go back to upper node to  check if its both child got value or not 