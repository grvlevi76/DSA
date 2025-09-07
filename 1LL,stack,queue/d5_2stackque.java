import java.util.Scanner;

//queue using 2 stack
public class d5_2stackque {
    Scanner sc = new Scanner(System.in);
    int n,start1,end1,start2=0,end2=0; //start and end of both stack
    int[] stack1;  //start1 and end1  are starting and end point for stack1
    int[] stack2;  //start2 and end2
    d5_2stackque() {
        System.out.printf("enter the size of both stack : ");
        n = sc.nextInt();
        start1=end1= n-1;
        stack1 = new int[n]; 
        stack2 = new int[n];
    }
    
    public static void main(String[] args) {
        d5_2stackque q=new d5_2stackque();
        q.traverse();

        int choice;
        char ch;
        do {
            System.out.println("choose : ");
            System.out.println("1 for enqueue\n2 for dequeue");
            System.out.printf("enter choice : ");
            choice = q.sc.nextInt();

            switch(choice) {
                case 1:
                    q.enqueue();
                    q.traverse();
                    break;

                case 2:
                    q.dequeue();
                    q.traverse();
                    break;

                default :
                    System.exit(0);
            }
            System.out.printf("\ndo u want to continoue(y for yes) : ");
            ch = q.sc.next().charAt(0);
        }while(ch=='y'||ch=='Y');
        
    }

    void enqueue() {
        if(end2==n) {
            System.out.println("\n queue overflow");
        }else {
            System.out.printf("enter the value : ");
            stack2[end2] = sc.nextInt();
            if(start1!=-1) {
                stack1[start1] = stack2[end2];
                start1--;
            }else{
                end2++;
            }
        }
    }

    void dequeue() {
        if(start1==n-1) {
            System.out.printf("\nqueue underflow");
        }else if(end1==start1&&end2==0 || start2==end2&&end2!=0) {
            System.out.println("\nunderflow detected! values initialised to starting");
            start1=end1=n-1;
            start2=end2=0;
        }else{
            if(end1!=-1) {
                end1--;
            }else {
                start2++;
            }
        }
    }

    void traverse() {
        if(start1==n-1 || end1==start1&&end2==0 ||(start2==n&&end2==n) || end1==-1&&end2==0){
            System.out.println("\n no elements in queue");
        }else {
            int temp;
            if(end1==-1) {
                temp = start2;
            }else{
                temp= end1;
            }
            System.out.printf("elements in queue are : ");
            if(end2!=0) {
                if(end1!=-1) {
                    while(temp>-1) {
                        System.out.printf(" " + stack1[temp]);
                        temp--;
                    }
                    temp =0;
                }
                while(temp<end2) {
                    System.out.printf(" " + stack2[temp]);
                    temp++;
                }
            }else {
                while(temp>start1) {
                    System.out.printf(" " + stack1[temp]);
                    temp--;
                }
            }
        }
    }
}

