# include <stdio.h>
# include <stdlib.h>

struct link
{
	int info;
	struct link *next;
};

struct link *start, *new1;

void insertion_at_begin();
void insertion_at_end();
void insertion_at_position();
void delete_by_position();
void delete_by_value();
void search();
void reverse();
void traverse ();
void short_ascending();
void shivam_reverse();

/* Function main */
void main()
{
	int choice;
	char ch;

	start = NULL;      /* Empty list */
	traverse();

	do
	{
		printf("\n\nInsert\n1 for insert_at_beginning\n2 for insert_at_end\n3 for insert_at_position\n4 delete_by_position\n5 delete_by_value\n6 search\n7 reverse\n8 for short_ascending\n9 for shiva_reverse");

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

			case 9:
				shivam_reverse();
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

/* Function to insert a node at the beginning of SLL */
void insertion_at_begin()
{
	new1 = (struct link* ) malloc(sizeof(struct link));
	printf("\n Input the node value: ");
	scanf("%d", &new1->info);
	getchar();

	new1->next = start ;
	start = new1;
}

/* Function to insert a node at the end of SLL */
void insertion_at_end()
{
	struct link *temp=start;        /* Point to the first node of the list */

	new1 = (struct link* ) malloc(sizeof(struct link));

	printf("\n Input the node value: ");
	scanf("%d", &new1->info);
	getchar();

	if(start == NULL)
	{
		new1->next = start ;
		start = new1;
	}
	else
	{
		while (temp->next != NULL)  {   // To reach before the desired position
			temp = temp->next;
		}

		new1->next = temp->next ;
		temp->next = new1;
	}
}

/* Function to traverse the SLL */
void traverse()
{
	struct link *temp=start;      /* Point to the first node of the list */

	if(start == NULL)
		printf("\n Empty linked list");
	else
	{
		printf("\n List is as follows:\n");
		while (temp)
		{
			printf(" %d", temp->info);
			temp = temp->next;
		}
	}
}

void insertion_at_position() {
	int pos=0;
	int count=0;
	struct link *temp =start;
	
	while(temp) {
		temp=temp->next;
		count++;
	}

	if(count<2) {
		printf("there should be atleast 2 nodes to use insertion_at_choice");
	}else{
		printf("total node exist : %d\n",count);
		while(pos<2||pos>count) {
			printf("enter the position only betweem 2 and %d: ",count);
			scanf("%d",&pos);
		}
	    new1=(struct link*)malloc(sizeof(struct  link));
	    if(new1==NULL) {
		    printf("memory allocation failed!");
			exit(0);
		}
	    printf("enter value of new node : ");
	    scanf("%d",&new1->info);
	    getchar();

		temp=start;
		for(int i=1;i<pos-1;i++) {
			temp =temp->next;
		}
	    new1->next=temp->next;
	    temp->next=new1;
	}

}

void delete_by_position() {
	int pos=0;
	int count=0;
	struct link *temp=start;
	struct link *prev_temp;
	while(temp) {
		temp=temp->next;
		count++;
	}

	if(count==0) {
		printf("no node exist! first create one ");

	}else if(count==1) {
		free(start);
		printf("one node got deleted");

	}else {

		printf("total node : %d\n",count);

		do{
			printf("enter the position of node to be deleted(only between 1 and %d) : ",count);
		    scanf("%d",&pos);
		    getchar();
		}while(pos<1 || pos>count);

		temp=start;
		for(int i=1;i<pos;i++) {
			if(i==pos-1) {
				prev_temp=temp;
			}
			temp=temp->next;
		}

		if(pos==1) {
			start=temp->next;
			free(temp);
		}else {
			prev_temp->next=temp->next;
		    free(temp);
		}
		

	}    
}

void delete_by_value() {
	int value;
	int found=0;
	struct link *temp = start;
	struct link *prev_temp;
	if(temp==NULL) {
		printf("no node exist");
	}else {

		printf("enter the value of node to be deleted : ");
		scanf("%d",&value);
		getchar();

		if(value==temp->info) {        //for first node
		    found=1;
			start = temp->next;
			free(temp);
			printf("node deleted");

		}else if(temp->next!=NULL ){
			while(temp) {               //for other nodes
				prev_temp=temp;
				temp=temp->next;
				if(temp!=NULL && value==temp->info) {
					found=1;
					prev_temp->next=temp->next;
					free(temp);
					printf("node deleted");
					break;
				}
		    }
		}
		if(found ==0) {
			printf("value %d doesn't exist in list",value);
		}

		
	}
}

void search() {
	int value;
	struct link *temp=start;

	if(temp==NULL) {
		printf("no node exist");
	}else {
		printf("enter the value for searching : ");
		scanf("%d",&value);
		getchar();
		
		while(temp) {
		if(value==temp->info) {
			printf("ys value %d exist",value);
			break;
		}
		temp=temp->next;
		if(temp==NULL) {
			printf("value %d does not exist\n",value);
		}
	}
	}

}

 void reverse() {
	struct link *past=NULL;
	struct link *curr=start;
	struct link *next=NULL;

	if(curr==NULL) {
		printf("no linked list exist\n");
	}else {
		while(curr) {
			next = curr->next;
			curr->next=past;
			past=curr;
			curr=next;
		}
		start = past;
	}

	printf("reverse the list completed");
}

void short_ascending() {
	if(start== NULL) {
		printf("no linked list");
	}else{
		struct link *temp = start;
		struct link *temp1;
		int store;
		while(temp!=NULL) {
			temp1=  start;
			while(temp1!= NULL) {
				if(temp->info<temp1->info) {
					store = temp->info;
					temp->info= temp1->info;
					temp1->info= store;
				}
				temp1= temp1->next;
			}
			temp = temp->next;
		}
	}
}


//short linked list ascending or descending order

struct link *rcrs(struct link *temp) {
	if(temp == NULL || temp->next==NULL) {
		return temp;
	}
	struct link *newstart = rcrs(temp->next);
	temp->next->next=temp;
	temp->next=NULL;
	return newstart;
}

void shivam_reverse() {
	start = rcrs(start);
}
