import java.util.Scanner;

// reverse the string usimg stack
public class d4_stackstr {
    public static void main(String args[] ) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("enter the string : ");
        String s= sc.nextLine();

        // String stack1= s;
        // System.out.println("stack : " + stack1);
        int n = s.length();
        System.out.println("n = "+n);

        char[] c = new char[n];

        for(int i=0;i<n;i++) {
            c[i] = s.charAt(i);
        }

        for(int i=0;i<n;i++) {
            System.out.println(c[i]);
        }


        // for(int i = 0;i<n;i++) {
        //     s.charAt(i)= c[n-1-i];
        // }
    }
}
