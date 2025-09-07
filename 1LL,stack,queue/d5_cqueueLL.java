import java.util.Scanner;
class node {
    int value;
    node next;
}
public class d5_cqueueLL {
    Scanner sc = new Scanner(System.in);
    node start;
    public static void main(String[] args) {
        d5_cqueueLL cq =  new d5_cqueueLL();
        cq.start = null;
        cq.traverse();

        int choice;
        char ch;

        do {
            System.out.println("\nchoose : ");
            System.out.println("1 for enqueue\n2 for dequeue");
            System.out.printf("enter the number : ");
            choice = cq.sc.nextInt();

            switch(choice) {
                case 1:
                    cq.enqueue();
                    cq.traverse();
                    break;

                case 2:
                    cq.dequeue();
                    cq.traverse();
                    break;

                default :
                    System.exit(0);
            }
            System.out.printf("\ndo u want to continoue (type y for yes)");
            ch= cq.sc.next().charAt(0);
        }while(ch=='y'||ch=='Y');
        
    }

    void traverse() {
        if(start == null) {
            System.out.println("queue empty");
        }else {
            node temp = start;
            System.out.printf("elements in queue are : ");
            do {
                System.out.printf(" "+temp.value);
                temp = temp.next;
            }while(temp!=start);
            System.out.println("\n");
        }
    }
    
    void enqueue() {
        node new1 = new node();
        System.out.printf("enter the value : ");
        new1.value= sc.nextInt();
        if(start == null) {
            start  = new1;
        }else{
            node temp = start;
            while(temp.next!=start) {
                temp= temp.next;
            }
            temp.next = new1;
        }
        new1.next = start;
    }

    void dequeue() {
        if(start==null) {
            System.out.println("no elements in queue");
        }else if(start.next==start){
            start=null;
        }else {
            node temp = start;
            while(temp.next != start) {
               temp = temp.next; 
            }
            start = start.next;
            temp.next = start;
        }
    }
}
