import java.util.Scanner;
class node{
    int value;
    node next;
}

public class d1_SLL {
    Scanner sc =new Scanner(System.in);
    node start;

    public static void main(String[] args) {
        d1_SLL list = new d1_SLL();
        d1_SLL list2 = new d1_SLL();
        list2.start= null;
       list.start = null;
       list.traverse();

       int choice;
       char ch;
       do{
            System.out.println("insert : \n1 for insertion_at_begin\n2 for insertion_at_end\n3 for insertion_at_position\n4 for delete_by_position\n5 for delete_by_value\n6 for search\n7 for reverse\n8 for ascending\n9 for clone");
            System.out.printf("enter choice : ");
            choice =  list.sc.nextInt();

            switch(choice) {
                case 1:
                    list.insertion_at_begin();
                    list.traverse();
                    break;

                case 2:
                    list.insertion_at_end();
                    list.traverse();
                    break;

                case 3:
                    list.insertion_at_position();
                    list.traverse();
                    break;

                case 4:
                    list.delete_by_position();
                    list.traverse();
                    break;

                case 5:
                    list.delete_by_value();
                    list.traverse();
                    break;

                case 6:
                    list.search();
                    list.traverse();
                    break;

                case 7:
                    list.reverse();
                    list.traverse();
                    break;

                case 8:
                    list.ascending();
                    list.traverse();
                    break;

                case 9:
                    list2.clone(list);
                    System.out.printf("cloned ");
                    list2.traverse();
                    System.out.printf("original ");
                    list.traverse();
                    break;

                default :
                System.exit(0);
            }
            System.out.println("\nDo you want to insert an another choice?");
            System.out.printf("Insert y for yes or n for no : ");
            ch  = list.sc.next().charAt(0);
        }while(ch =='y' || ch=='Y');
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
        start = new1;
    }

    void insertion_at_end() {
        node new1 = new node();
        System.out.printf("enter the value : ");
        new1.value=sc.nextInt();
        if(start == null) {
            new1.next=null;
            start = new1;
        }else{
            node temp=start;
            while(temp.next!=null) {
                temp= temp.next;
            }
            new1.next= temp.next;
            temp.next= new1;
        }
    }

    void insertion_at_position() {
        int count=0;
        node temp=start;
            while(temp!=null) {
                count++;
                temp=temp.next;
            }
        if(count==0) {
            System.out.println("no linked list");
        }else if(count==1){
            System.out.println("linked list should have more than 1 node");
        }else {
            int pos;
            System.out.printf("enter the position : ");
            pos=sc.nextInt();
            
            if(pos<2 || pos>count) {
                System.out.println("the position should be between 2 and " + count);
            }else{
                temp=start;
                for(int i=1;i<pos-1;i++) {
                    temp=temp.next;
                }
                node new1=new node();
                System.out.printf("enter the value : ");
                new1.value=sc.nextInt();
                new1.next=temp.next;
                temp.next=new1;
            }
        }
    }

    void delete_by_position() {
        if(start == null) {
            System.out.println("no linked list");
        }else if(start.next==null) {
            start = null;
            System.out.println("only node deleted");
        }else {
            int pos,count=0;
            node temp = start;
            while(temp!=null) {
                temp= temp.next;
                count++;
            }
            do{
                System.out.printf("enter the position only between 1 and " + count + " : ");
                pos = sc.nextInt();
            }while(pos<1 || pos>count);

            if(pos==1) {
                start = start.next;
                System.out.println("Node at position " + pos + " deleted.");
            }else {
                temp = start;
                for(int i=1;i<pos-1;i++) {
                    temp=temp.next;
                }
                temp.next=temp.next.next;
                System.out.println("Node at position " + pos + " deleted.");
            }

        }
    }

    void delete_by_value() {
        if(start==null) {
            System.out.println("no liked list");
        }else  {
            int val,pos=0,found=0;
            System.out.printf("enter the value : ");
            val = sc.nextInt();
            node temp = start;
            while(temp!=null) {
                pos++;
                if(val==temp.value) {
                    found=1;
                    break;
                }
                temp= temp.next;
            }
            if(found ==0) {
                System.out.println("value " + val+ " doesn't exist in list");
            }else {
                if(start.next==null) {
                    start = null;
                    temp=null;
                    System.out.println("node deleted of value  " + val);
                }else if(pos == 1) {
                    start= start.next;
                    temp=null;
                    System.out.println("node deleted of value  " + val);
                }else {
                    temp = start;
                    for(int i=1;i<pos-1;i++) {
                        temp=temp.next;
                    }
                    temp.next=temp.next.next;
                    System.out.println("node deleted of value  " + val);
                }
            }
        }
    }

    void search() {
        if(start==null) {
            System.out.println("no linked list");
        }else {
            int val,pos=0,found=0;
            System.out.printf("enter the value : ");
            val = sc.nextInt();
            node temp = start;
            while(temp!=null) {
                pos++;
                if(val==temp.value) {
                    found=1;
                    System.out.println("ys "+val+ " exist in list at position "+ pos);
                    break;
                }
                temp=temp.next;
            }
            if(found==0) {
                System.out.println("no " + val+ " doesn't exist in list");
            }
        }
    }

    void reverse() {
        if(start == null) {
            System.out.println("no linked list");
        }else {
            node prev=null;
            node curr= start;
            node nex = null;

            while(curr!=null) {
                nex=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nex;
            }
            start=prev;

        }
    }

    void ascending() {
        if(start== null) {
            System.out.println("no linked list");
        }else{
            node temp = start;
            node temp1;
            int store;
            while(temp!=null) {
                temp1=  start;
                while(temp1!= null) {
                    if(temp.value<temp1.value) {
                        store = temp.value;
                        temp.value= temp1.value;
                        temp1.value= store;
                    }
                    temp1= temp1.next;
                }
                temp = temp.next;
            }
        }
    }

    void clone(d1_SLL list) {
        if(list.start == null) {
            System.out.println("no linked list");
        }else{
           node temp  = list.start;
           node temp1= start;
           while(temp!=null) {
                node new1 = new node();
                new1.value= temp.value;
                if(temp == list.start) {
                    new1.next = start;
                    start = new1;
                    temp1= start;
                }else{
                    new1.next = null;
                    temp1.next =  new1;
                    temp1= temp1.next;
                }
                temp =  temp.next;
            } 
        }
    }
   
}  



