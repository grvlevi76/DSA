import java.util.Scanner;

class node {
    int value;
    node next;
}

public class d4_stackLL {
    Scanner sc = new Scanner(System.in);
    node start;
    public static void main(String[] args) {
        d4_stackLL s = new d4_stackLL();
        s.start = null;
        s.traverse();
        int choice;
        char ch;
        do {
            System.out.println("\nchoose : ");
            System.out.println("1 for push\n2 for pop");
            System.out.printf("enter the option : ");
            choice = s.sc.nextInt();
            switch(choice) {
                case 1:
                    s.push();
                    s.traverse();
                    break;

                case 2:
                    s.pop();
                    s.traverse();
                    break;

                default :
                    System.exit(0);
            }
            System.out.printf("do you want to continoue(type y for yes) : ");
            ch= s.sc.next().charAt(0);
        }while(ch=='y' ||ch=='Y');
    }

    void traverse() {
        if(start == null) {
            System.out.println("stack empty");
        }else {
            node temp = start;
            System.out.printf("stack elements are :");
            while(temp!=null) {
                System.out.printf(" "+ temp.value);
                temp = temp.next;
            }
            System.out.println("\n");
        }
    }

    void push() {
        node new1 = new node();
        System.out.printf("enter the value : "); 
        new1.value = sc.nextInt();
        new1.next = null;
        if(start == null) {
            start = new1;
        }else{
            node temp = start;
            while(temp.next !=null ) {
                temp = temp.next;
            } 
            temp.next = new1;
        }
        System.out.println("successfully pushed");
    }

    void pop() {
        if(start == null) {
            System.out.println("stack got no elements to pop");
        }else if(start.next ==null) {
            System.out.println("popped element from stack : " + start.value);
            start = null;
        }else {
            node temp= start;
            while(temp.next.next !=null) {
                temp= temp.next;
            }
            System.out.println("popped element from stack : " + temp.next.value);
            temp.next = null;
        }
    }

}
