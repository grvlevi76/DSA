#include<stdio.h>
#include<stdlib.h>
#include<string.h>

//hashing with division method and linear probing for collision
struct entry{
    char key[10];
    char value[10];
    int is_deleted;
};
struct entry *hashtable;
int n;

void insertion();
void searching();
void deletion();
void traverse();
void dynamic_resize();
int hash_func(char k[]); 

void main() {
    n=7;
    hashtable=(struct entry*)malloc(n*sizeof(struct entry));
    if(hashtable==NULL) {
        printf("memory allocation failed");
        exit(0);
    }
    printf("table size : %d\n",n);
    int choose;
    char ch;

    //assigning '\0' to the every key so that i can find out key is empty or not  
    for(int i =0;i<n;i++) {
        hashtable[i].key[0] = '\0';
        hashtable[i].is_deleted=0;
    }

    do {
        printf("\nchoose : \n");
        printf("1 for insert\n2 for searching\n3 for deletion\n4 for traverse\n");
        printf("choose the option : ");
        scanf("%d",&choose);
        getchar();

        switch(choose) {
            case 1:
                insertion();
                //for dynamic resizing by checking load_factor
                dynamic_resize();
                traverse();
                break;

            case 2:
                searching();
                traverse();
                break;

            case 3:
                deletion();
                traverse();
                break;

            case 4:
                traverse();
                break;
            
            default : 
                exit(0);
        }
    }while(1);

}

void insertion() {
    char k[10];
    printf("enter the key : ");
    scanf("%s",k);

    int index = hash_func(k);   //0 parameter means we dont want searching 
    int empty_space=0,ind = index;

    //if collision then using linear probing
    do {
        if(hashtable[ind].key[0]=='\0'|| hashtable[ind].is_deleted==1) {
            empty_space=1;
            break;                          
        }
        ind++;
        if(ind ==n) {
            ind =0;
        }
    }while(ind!=index);
    if(empty_space==0) {   
        printf("array overflow\n");
    }else {
        //store key
        printf("index : %d\n",ind);
        strcpy(hashtable[ind].key,k);
        printf("enter the value : ");
        scanf("%s",hashtable[ind].value);
        getchar();
        hashtable[ind].is_deleted=0;
    }
}

void searching() {
    char k[10];
    printf("enter the key to search : ");
    scanf("%s",k);
    getchar();

    int index=hash_func(k);
    int found=0;
    printf("index : %d\n",index);

    //if collision then using linear probing
    do {
        if(strcmp(hashtable[index].key, k) == 0 && hashtable[index].is_deleted!=1) {
            found=1;
            printf("at key : %s\nvalue : %s\n",hashtable[index].key,hashtable[index].value);
            break;                          
        }
        printf("index inside loop : %d\n",index);
        printf("key at index 1  : %s\n",hashtable[1].key);
        printf("key at index 1  : %s\n",k);
        index++;
        if(index ==n) {
            index =0;
        }
    }while(hashtable[index].key[0]!='\0');
    if(found==0) {
        printf("the key %s has no value\n",k);
    }

}

void deletion() {
    //we will delete through key
    char k[10];
    printf("enter thye key u want to delete : ");
    scanf("%s",k);
    getchar();

    int found=0,index= hash_func(k);
    printf("index : %d\n",index);

    do {
        if(strcmp(hashtable[index].key,k)==0 && hashtable[index].is_deleted!=1) {
            printf("index inside loop : %d\n",index);
            printf("key at index 1  : %s\n",hashtable[1].key);
            printf("key at index 1  : %s\n",k);
            hashtable[index].is_deleted=1;
            printf("key %s found at index %d got deleted\n",k,index);
            found=1;
            break;
        }
        index++;
        if(index==n) {
            index=0;
        }
    }while(hashtable[index].key[0]!='\0');
    if(found==0) {
        printf("key %s doesn't exist in table\n",k);
    }
}

void traverse() {
    printf("hashtable : \n");
    for(int i=0;i<n;i++) {
        printf("%s        ",hashtable[i].key);
    }
    printf("\n");
    for(int i=0;i<n;i++) {
        printf("%s  ",hashtable[i].value);
    }
    printf("\n");
}

void dynamic_resize() {
    int total_entry=0;
    float load_factor;
    for(int i=0;i<n;i++) {
        if(hashtable[i].key[0]!='\0' && hashtable[i].is_deleted!=1) {
            total_entry++;
        }
    }
    printf("total_entry : %d\n",total_entry);
    load_factor=(float)total_entry/(float)n;
    if(load_factor>=0.75) {
        int prev_size=n;
        n =2*n;
        hashtable=(struct entry*)realloc(hashtable,n*sizeof(struct entry));
        if(hashtable==NULL) {
            printf("memory allocation failed");
            exit(0);
        }
        for(int i =prev_size;i<n;i++) {
            hashtable[i].key[0] = '\0';
            hashtable[i].is_deleted=0;
        }
        printf("\n==>table size increases to double of its original size for better efficiency<==\n\n");
        printf("table size : %d\n",n);
    }
}

int hash_func(char k[]) {    //search parameter is for when we gonna use searching 
    //converting the key string to integer
    int ksum=0;
    for(int i=0;i<strlen(k);i++) {
        ksum+=k[i];
    }

    //selecting prime number closer to size of table
    printf("size of array : %d\n",n);
    int i,prime= n;
    while(prime!=2) {
        i=prime/2;
        while(i>1) {
            if(prime%2==0 || prime%3==0 || prime%i==0) {
                break;
            }
            i--;
        }
        if(i==1) {
            break;
        }
        prime--;
    }
    printf("k : %s\n",k);
    printf("ksum : %d\n",ksum);
    printf("prime : %d\n",prime);

    return ksum%prime;
}


//dynamic Resizing Doesn’t Rehash Existing Keys so old entry becomes garbage 
//make a stack array program with other than division hash method and chaining(using linked list) for collision
//make a stack array program with other than division hash method and double hash in open searching for collision 
