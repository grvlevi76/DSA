import java.util.Scanner;
class node{
    int value;
    node next;
}

public class d3_CLL {
    Scanner sc =new Scanner(System.in);
    node start;

    public static void main(String[] args) {
        d3_CLL list = new d3_CLL();
        d3_CLL list2 = new d3_CLL();
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
            do {
                System.out.printf(" " + temp.value);
                temp=temp.next;
            }while(temp!=start);
            System.out.println("\n");
        }
    }

    void insertion_at_begin() {
        node new1 =new node();
        System.out.printf("enter the value : ");
        new1.value=sc.nextInt();

        if(start==null) {
            start = new1;
            start.next = start;
        }else{
            new1.next = start;
            node temp =start;
            while(temp.next != start) {
                temp = temp.next;
            }
            start = new1;
            temp.next = start;
        }
    }

    void insertion_at_end() {
        node new1 = new node();
        System.out.printf("enter the value : ");
        new1.value=sc.nextInt();
        if(start == null) {
            start = new1;
            start.next = start;
        }else{
            node temp=start;
            while(temp.next!=start) {
                temp= temp.next;
            }
            temp.next= new1;
            new1.next = start;
        }
    }

    void insertion_at_position() {
        if(start==null) {
            System.out.println("no linked list");
        }else if(start.next==start) {
            System.out.println("linked list should have more than 1 node");
        }else{
            int count=1;
            node temp=start;
            while(temp.next!=start) {
                count++;
                temp=temp.next;
            }
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
        }else if(start.next==start) {
            start = null;
            System.out.println("only node deleted");
        }else {
            int pos,count=1;
            node temp = start;
            while(temp.next!=start) {
                temp= temp.next;
                count++;
            }

            do{
                System.out.printf("enter the position only between 1 and " + count + " : ");
                pos = sc.nextInt();
            }while(pos<1 || pos>count);

            if(pos==1) {
                start = start.next;
                temp.next = start;
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
            do {
                pos++;
                if(val==temp.value) {
                    found=1;
                    break;
                }
                temp= temp.next;
            }while(temp!=start);

            if(found ==0) {
                System.out.println("value " + val+ " doesn't exist in list");
            }else {
                if(start.next==start) {
                    start = null;
                    temp=null;
                    System.out.println("node deleted of value  " + val);
                }else if(pos == 1) {
                    start= start.next;
                    while(temp.next!=null) {
                        temp = temp.next;
                    }
                    temp.next=start;
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
            do {
                pos++;
                if(val==temp.value) {
                    found=1;
                    System.out.println("ys "+val+ " exist in list at position "+ pos);
                    break;
                }
                temp=temp.next;
            }while(temp!=start);
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

            while(curr.next!=start) {
                nex=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nex;
            }
            curr.next = prev;
            start.next = curr;
            start=curr;

        }
    }

    void ascending() {
        if(start== null) {
            System.out.println("no linked list");
        }else{
            node temp = start;
            node temp1;
            int store;
            do {
                temp1=  start;
                do  {
                    if(temp.value<temp1.value) {
                        store = temp.value;
                        temp.value= temp1.value;
                        temp1.value= store;
                    }
                    temp1= temp1.next;
                }while(temp1!= start);
                temp = temp.next;
            }while(temp!=start);
        }
    }

    void clone(d3_CLL list) {
        if(list.start == null) {
            System.out.println("no linked list");
        }else{
           node temp  = list.start;
           node temp1= start;
           do{
                node new1 = new node();
                new1.value= temp.value;
                if(temp == list.start) {
                    start = new1;
                    start.next = start;
                    temp1= start;
                }else{
                    new1.next = start;
                    temp1.next =  new1;
                    temp1= temp1.next;
                }
                temp =  temp.next;
            }while(temp!=list.start);
        }
    }
   
}  




