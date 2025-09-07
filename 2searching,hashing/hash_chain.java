//make a array program with other than division hash method and chaining(using linked list) for collision
//dynamic resize
//in case of chain collision we have to make a refrence or pointer named 'chain_ll' in class or structure which gonna pooint to the linked list we will make 
//in case of chain collision for searching if chain_ll is null or not thats when we decide do search ot not that branch
//but then the blocks where there is no collision then the pointers will just get waisted
import java.util.Scanner;
class entry {  //for the hashtable
    String key;
    String value;
    entry chain;
}

public class hash_chain {
    Scanner sc = new Scanner(System.in);
    static entry hashtable[];             //hashtable(array of objects of class entry)
    int n;
    hash_chain(){
        // System.out.println("enter the size of array : ");
        // n = sc.nextInt();
        n = 7;
        hashtable = new entry[n];
        for(int i=0;i<n;i++) {
            hashtable[i]  = new entry();
        }
    }

    public static void main(String[] args) {
        hash_chain hash = new hash_chain();
        int choice;
        do {
            System.out.println("choose  : ");
            System.out.println("1 for insertion\n2 for search\n3 for deletion\n4 for traverse");
            System.out.printf("enter the option : ");
            choice = hash.sc.nextInt();
            switch(choice) {
                case 1:
                    hash.insertion();
                    hash.traverse();
                    break;

                case 2:
                    hash.search();
                    hash.traverse();
                    break;

                case 3:
                    hash.deletion();
                    hash.traverse();
                    break;

                case 4:
                    hash.traverse();
                    break;

                default :
                    System.exit(0);
            }
        }while(true);
        
    }

    void insertion() {
        String k;
        System.out.printf("enter the key : ");
        k =  sc.nextLine();
        int index = hash_func(k);
        if(hashtable[index].key==null) {
            hashtable[index].key=k;
            System.out.printf("enter the value : ");
            hashtable[index].value=sc.nextLine();
        }else{
            entry new1 = new entry();
            new1.key=k;
            System.out.printf("enter the value");
            new1.value= sc.nextLine();
            if(hashtable[index].chain==null) {
                hashtable[index].chain= new1;
            }else{
                entry temp = hashtable[index].chain;
                while(temp.chain!=null) {
                    temp = temp.chain;
                }
                temp.chain = new1;
            }
        }

    }

    void traverse() {
        for(int i=0;i<n;i++) {
            System.out.printf(hashtable[i].key);
            System.out.printf("     " + hashtable[i].value);
            if(hashtable[i].chain!=null) {
                entry temp = hashtable[i].chain;
                while(temp!=null) {
                    System.out.printf("=>["+temp.key+": "+temp.value+"]");
                    temp =  temp.chain;
                }
            }
            System.out.printf("\n");
        }
    }

    void search() {
        int flag=0;
        String k;
        System.out.printf("enter the key : ");
        k = sc.nextLine();
        int index = hash_func(k);
        if(hashtable[index].key==k) {
            System.out.println("found : ");
            System.out.printf("["+hashtable[index].key+" : "+hashtable[index].value+"]");
            flag =1;
        }else {
            if(hashtable[index].chain!=null) {
                entry temp = hashtable[index].chain;
                while(temp!=null)  {
                    if(temp.key ==k) {
                        System.out.println("found : ");
                        System.out.printf("["+temp.key+" : "+temp.value+"]");
                        flag =1;
                        break;
                    }
                    temp = temp.chain;
                }
            }
        }
        if(flag ==0) {
            System.out.println("key not exist in list");
        }
    }

    void deletion() {
        String k;
        System.out.printf("enter the key : ");
        k=sc.nextLine();

        int index = hash_func(k);
        if(hashtable[index].key==k) {
            hashtable[index].key=null;
            hashtable[index].value=null;
            System.out.println("deletion successful");
        }else if(hashtable[index].chain!=null){
            entry temp = hashtable[index].chain;
            if(temp.key==k) {
                hashtable[index].chain=temp.chain;
            }else{
                while(temp.chain!=null) {
                    if(temp.chain.key==k) {
                        temp.chain=temp.chain.chain;
                        break;
                    }
                    temp=temp.chain;
                }
                if(temp.chain==null) {
                    System.out.println("key doesn't in hashtable");
                }
            }
            
        }else{
            System.out.println("key doesn't in hashtable");
        }

    }

    int hash_func(String k) {
        int ksum=0;
        for(int i=0;i<k.length();i++) {
            ksum+=k.charAt(i);
        }

        int j,prime =n;
        for(int i =prime;i>1;i--) {
            for(j=prime/2;j>1;j--) {
                if(i%2==0 || i%3==0||i%j==0) {
                    break;
                }
            }
            if(j==1) {
                break;
            }
        }
        return ksum%prime;
    }
    
}
