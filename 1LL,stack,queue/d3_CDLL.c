#include<stdio.h>
struct node {
    int value;
    struct node *next;
    struct node *prev;
};

void insertion_at_begin();
void insertion_at_end();
void insert_at_position();
void traverse();
void delete_by_position();

struct node *new1,*start;
void main() {
    int choice;
	char ch;

	start = NULL;      /* Empty list */
	traverse();

	do
	{
		printf("\n\nInsert\n1 for insert_at_beginning\n2 for insert_at_end\n3 for insert_at_position\n4 delete_by_position\n5 delete_by_value\n6 search\n7 reverse\n8 for short_ascending");

		printf("\n Insert choice: ");
		scanf("%d", &choice);
		getchar();

		switch(choice)
		{
			case 1:
				insertion_at_begin ();
				traverse ();
				break;

			case 2:
				insertion_at_end ();
				traverse ();
				break;

			case 3:
				insertion_at_position();
				traverse();
				break;

			case 4:
				delete_by_position();
				traverse();
				break;

			case 5:
				delete_by_value();
				traverse();
				break;

			case 6:
				search();
				traverse();
				break;

			case 7:
				reverse();
				traverse();
				break;

			case 8 :
				short_ascending();
				traverse();
				break;

			default:
				exit(1);
		}
		printf("\n\n Do you want to insert an another choice?  ");
		printf("\n Insert y for yes or n for no.  ");
		//fflush(stdin);
		scanf("%c",&ch);
	}while(ch == 'y' || ch == 'Y');
}

void traverse() {
    if(start==NULL) {
        printf("list empty\n");
    }else{
        struct node *temp =  start;
        printf("elements in list are : ");
        do {
            printf(" %d",temp->value);
            temp=temp->next;
        }while(temp!=start);
        printf("\n");
    }
}

void insertion_at_begin() {
    new1= (struct node*)malloc(sizeof(struct node));
    printf("enter the value : ");
    scanf("%d",new1->value);
    if(start==NULL) {
        new1->next=new1;
        new1->prev=new1;
    }else {
        struct node *temp=start;
        while(temp->next!=start) {
            temp = temp->next;
        }
        start->prev= new1;
        new1->next=start;
        new1->prev=temp;
        temp->next=new1;
    }
    start=new1;

}

void insertion_at_end() {
    new1= (struct node*)malloc(sizeof(struct node));
    printf("enter the value : ");
    scanf("%d",new1->value);
    if(start==NULL) {
        new1->next=new1;
        new1->prev=new1;
        start= new1;
    }else {
        struct node *temp = start;
        while(temp->next!=start) {
            temp = temp->next;
        }
        temp->next=new1;
        new1->prev=temp;
        start->prev=new1;
        new1->next=start;
    }
}

void insert_at_position() {
    if(start==NULL) {
        printf("liste empty\n");
    } else{
        int count=1;
        struct node *temp=start;
        while(temp->next!=start) {
            count++;
            temp = temp->next;
        }
        if(count<2) {
            printf("there should be atleast two node to insert at position\n");
        }else {
            int pos;
            do {
                printf("enter position between 2 and &d only: ",count);
                scanf("%d",&pos);
            }while(pos<2 ||pos>count);

            new1= (struct node*)malloc(sizeof(struct node));
            ptintf("enter the value : ");
            scanf("%d",new1->prev);

            for(int i=count;i>pos+1;i--) {
                temp =  temp->prev;
            }
            new1->next=temp;
            new1->prev=temp->prev;
            temp->prev->next=new1;
            temp->prev=new1;

        }
    }
}

void delete_by_position() {
    if(start==NULL) {
        printf("liste empty\n");
    }else{
        int count=1;
        struct node *temp=start;
        while(temp->next!=start) {
            count++;
            temp = temp->next;
        }

        int pos;
        struct node *temp=start;
        do{
            printf("enter position between 1 and %d only",count);
            temp=temp->next;
        }while(pos<1 || pos>count);

        if(pos==1) {
            free(start);
        }else if(pos==count){
            temp->prev->next==start;    //temp is already at last
            start->prev=temp->prev;
            free(temp);
        }else{
            for(int i=count;i>pos+1;i--) {      //temp is already at last
                temp =  temp->prev;
            }
            struct node *prev_temp = temp->prev;
            temp->prev=temp->prev->prev;
            temp->prev->prev->next=temp;
            free(prev_temp);
        }

    }
}

void ascending() {
    if(start==NULL) {
        printf("empty list");
    }else{
        int store;
        struct node *temp= start;
        while(temp->next!=start) {
            if(temp->value>temp->next->value) {
                store = temp->value;
                temp->value=temp->next->value;
                temp->next->value=store;
                if(temp!=start) {
                    temp=temp->prev->prev;
                }
            }
            temp=temp->next;
        }
    }
}
