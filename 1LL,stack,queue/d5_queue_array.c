#include<stdio.h>
#include<stdlib.h>
int queue[7];
int curr,start=0;

void enqueue();
void dequeue();
void traverse();

void main() {
    curr = -1;
    traverse();
    int choice;
    char ch;
    do {
        printf("\nchoose : \n");
        printf("1 for enqueue\n2 for dequeue\n");
        printf("enter the option : ");
        scanf("%d",&choice);
        getchar();
        switch(choice) {
            case 1:
                enqueue();
                traverse();
                break;

            case 2:
                dequeue();
                traverse();
                break;

            default :
            exit(0);
        }
        printf("do u want to continoue (type y for yes) : ");
        scanf("%c",&ch);
    }while(ch=='y'||ch=='Y');
}

void traverse() {
    if(curr==-1) {
        printf("no element in queue\n");
    }else if(start>curr) {
        printf("queue underflow\n");
    }else {
        int temp= start;
        printf("elements of queue are : ");
        while(temp<=curr) {
            printf(" %d",queue[temp]);
            temp++;
        }
        printf("\n");
    }
}

void enqueue(){
    if(curr==sizeof(queue)/sizeof(int)-1) {
        printf("queue overflow\n");
    }else {
        curr++;
        printf("enter the value : ");
        scanf("%d",&queue[curr]);
        getchar();
    }
}

void dequeue() {
    if(curr==-1) {
        printf("no element in queue\n");
    }else if(start>curr)  {
        printf("queue underflow\n");
    }else {
        start++;
    }
}