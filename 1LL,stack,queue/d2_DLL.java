import java.util.Scanner;
class node{
    int value;
    node next;
    node prev;
}

public class d2_DLL {
    Scanner sc =new Scanner(System.in);
    node start;

    public static void main(String[] args) {
        d2_DLL db = new d2_DLL();
        d2_DLL db2 = new d2_DLL();
        db2.start = null;
        db.start = null;
        db.traverse();

       int choice;
       char ch;
       do{
            System.out.println("insert : \n1 for insertion_at_begin\n2 for insertion_at_end\n3 for insertion_at_position\n4 for delete_by_position\n5 for delete_by_value\n6 for search\n7 for reverse\n8 for ascending order\n9 for clone");
            System.out.printf("enter choice : ");
            choice =  db.sc.nextInt();

            switch(choice) {
                case 1:
                    db.insertion_at_begin();
                    db.traverse();
                    break;

                case 2:
                    db.insertion_at_end();
                    db.traverse();
                    break;

                case 3:
                    db.insertion_at_position();
                    db.traverse();
                    break;

                case 4:
                    db.delete_by_position();
                    db.traverse();;
                    break;

                case 5:
                    db.delete_by_value();
                    db.traverse();;
                    break;

                case 6:
                    db.search();
                    db.traverse();
                    break;

                case 7:
                    db.reverse();
                    db.traverse();
                    break;

                case 8:
                    db.ascending();
                    db.traverse();
                    break;

                case 9:
                    db2.clone(db);
                    System.out.printf("cloned ");
                    db2.traverse();
                    System.out.printf("original ");
                    db.traverse();
                    break;

                default :
                System.exit(0);
            }
            System.out.println("\nDo you want to insert an another choice?");
            System.out.printf("Insert y for yes or n for no : ");
            ch  = db.sc.next().charAt(0);
        }while(ch =='y' || ch=='Y');

        db.sc.close();
    }

    void traverse() {
        if(start == null) {
            System.out.println("empty linked list");
        }else {
            node temp = start;
            System.out.printf("list are as follows :");
            while(temp!=null) {
                System.out.printf(" " + temp.value);
                temp=temp.next;
            }
            System.out.println("\n");
        }
    }

    void insertion_at_begin() {
        node new1 =new node();
        System.out.printf("enter the value : ");
        new1.value=sc.nextInt();
        new1.next= start;
        new1.prev= null;
        if(start!=null) {
            start.prev= new1;
        }
        start = new1;
    }

    void insertion_at_end() {
        node new1 = new node();
        System.out.printf("enter the value : ");
        new1.value=sc.nextInt();
        if(start == null) {
            new1.next=start;
            new1.prev= null;
            start = new1;
        }else{
            node temp= start;
            while(temp.next!=null) {
                temp= temp.next;
            }
            temp.next= new1;
            new1.prev= temp;
            new1.next=null;
        }
    }

    void insertion_at_position() {
        if(start== null) {
            System.out.println("empty linked list");
        }else if(start.next==null) {
            System.out.println("list should have more than 1 node to use insertion at position");
        }else {
            int count=0;
            node temp = start;
            while(temp!=null) {
                count++;
                temp = temp.next;
            }
            int pos;
            System.out.printf("enter the position : ");
            pos = sc.nextInt();
            if(pos<1||pos>=count) {
                System.out.println("position should be between 1 and " + (count-1));
            }else{
                node new1 = new node();
                System.out.printf("enter the value : ");
                new1.value= sc.nextInt();
                temp = start;
                for(int i = 1; i<=pos;i++) {
                    temp= temp.next;
                }
                new1.prev= temp.prev;
                temp.prev.next= new1;
                new1.next = temp;
                temp.prev = new1;
            }
        }
    }

    void delete_by_position() {
        if(start== null) {
            System.out.println("no linked list");
        }else if(start.next==null) {
            start=null;
            System.out.println("the only node at position 1 got deleted");
        }else{
            int count=1;
            node temp = start;
            while(temp.next!=null) {
                count++;
                temp = temp.next;
            }
            int pos;
            System.out.printf("enter the position : ");
            pos= sc.nextInt();
            if(pos<1||pos>count) {
                System.out.println("position should be between 1 and " + count);
            }else{
                if(pos==1) {
                    start.next.prev= null;
                    start = start.next;
                    System.out.println("node at position 1 got deleted");
                }else if(pos==count){
                    temp.prev.next = null;
                    System.out.println("node at position " + count+ " got deleted");
                }else{
                    while(count!=pos) {
                        count--;
                        temp= temp.prev;
                    }
                    temp.prev.next= temp.next;
                    temp.next.prev= temp.prev;
                    System.out.println("node at position " + pos + " got deleted");
                }
            }
        }
    }

    void delete_by_value() {
        if(start== null) {
            System.out.println("no linked list");
        }else{
            int val;
            System.out.printf("enter the value : ");
            val= sc.nextInt();
            node temp = start;
            while(temp !=null && val!=temp.value) {
                temp= temp.next;
            }

            if(temp == null) {
                System.out.println("value " + val+" doesn't exist in list");
            }else{
                if(start.next== null) {
                    start=null;
                    System.out.println("the only node with value " + val+ " got deleted");
                }else if(temp == start) {
                    start.next.prev= null;
                    start = start.next;
                    System.out.println("node with value "+val+" got deleted");
                }else if(temp.next == null) {
                    temp.prev.next= null;
                    System.out.println("node with value" + val+ " got deleted");
                }else{
                    temp.prev.next= temp.next;
                    temp.next.prev= temp.prev;
                    System.out.println("node with value " + val + " got deleted");
                }
            }
        }
    }

    void search() {
        if(start== null) {
            System.out.println("no linked list");
        }else{
            int val,pos= 1;
            System.out.printf("enter the value : ");
            val= sc.nextInt();
            node temp = start;
            while(temp !=null && val!=temp.value) {
                temp= temp.next;
                pos++;
            }

            if(temp == null) {
                System.out.println("value "+ val+" doesn't exist in list");
            }else{
                System.out.println("value " +val+" found at position "+ pos);
            }
        }
    }

    void reverse() {
        if(start== null) {
            System.out.println("no linked list");
        }else{
            node curr  = start;
            node nex= null;
            while(curr!=null) {
                nex= curr.next;
                curr.next =curr.prev;
                curr.prev= nex;
                if(nex==null) {
                    break;
                }
                curr= nex;
            }
            start= curr;
        } 
    }

    void ascending() {
        if(start== null) {
            System.out.println("no linked list");
        }else{
            node temp = start;
            int store;
            while(temp.next!=null) {
                if(temp.value>temp.next.value) {
                    store = temp.value;
                    temp.value = temp.next.value;
                    temp.next.value= store;
                    if(temp != start) {
                        temp = temp.prev;
                    }
                }else{
                    temp = temp.next;
                }
            }
        }
    }

    void clone(d2_DLL db) {
        if(db.start== null) {
            System.out.println("no linked list");
        }else{
            node temp = db.start;
            node temp1= start;
            while(temp!=null) {
                node new1 = new node();
                new1.value= temp.value;
                if(temp == db.start) {
                    new1.next = start;
                    new1.prev=null;
                    start = new1;
                    temp1= start;
                }else{
                    new1.next = null;
                    new1.prev = temp1;
                    temp1.next = new1;
                    temp1 = temp1.next;
                }
                temp = temp.next;
            }
        }
    }
 }

//make a linked list where node starts from last with doubly(cause we can only go back with doubly)


