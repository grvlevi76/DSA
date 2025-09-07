#include<stdio.h>
#include<stdlib.h>

int indec=0;
struct test {
    int x;
    struct test *next;
};
struct test *start,*new;
struct test node[100];


void insertion_at_begin() {
    
    new=&node[indec];
    indec++;
    printf("\nenter the value : ");
    scanf("%d",&new->x);
    getchar();
    new->next=start;
    start=new;
}

void traverse() {

    struct test *temp;
    temp=start;
    if(start == NULL) {
        printf("empty list\n");
    }else {
        printf("\nlist is as follows :");
        while(temp) {
            printf(" %d",temp->x);
            temp=temp->next;
        }
        printf("\n");
    }
    
}

void insertion_at_end() {


    new = &node[indec];
    indec++;
    struct test *temp;
    temp=start;
    printf("\nenter the value : ");
    scanf("%d",&new->x);
    getchar();
    if(temp==NULL) {
        new->next=start;
        start=new;
    }else {
        while(temp->next!=NULL) {
            temp=temp->next;
        }
        new->next=temp->next;
        temp->next=new;
    }
}

void main() {
    start=NULL;
    traverse();

    int choice;
    char ch;

    do{
        printf("\ninsert\n1 for insertion_at_begin\n2 insertion_at_end");
        printf("\nenter a choice : ");
        scanf("%d",&choice);
            
        switch(choice) {
            case 1:
                insertion_at_begin();
                traverse();
                break;

            case 2:
                insertion_at_end();
                traverse();
                break;

            default : 
                exit(0);
        }

        printf("\n\n Do you want to insert an another choice?  ");
		printf("\n Insert y for yes or n for no.  ");
		//fflush(stdin);
		scanf("%c",&ch);
    }while(ch == 'y' || ch == 'Y');

}

//make an  array of ur own where u will grant a specific size of empty array and provide a indexing method to store and navigate into array 


