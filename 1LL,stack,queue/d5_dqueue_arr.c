#include<stdio.h>
#include<stdlib.h>
//double ended queue in array
int arr[6];
int start,end;
int n = sizeof(arr)/sizeof(int);

void traverse();
void insertion_at_begin();
void deletion_at_begin();
void insertion_at_end();
void deletion_at_end();

void main() {
    start=-1;
    end=-1;
    traverse();
    int choice;
    char ch;

    do{
        printf("choose : \n");
        printf("1 for insertion_at_begin\n2 for deletion_at_begin\n3 for insertion_at_end\n4 for deletion_at_end");
        printf("\nenter number : ");
        scanf("%d",&choice);
        getchar();
        switch(choice) {
            case 1:
                insertion_at_begin();
                traverse();
                break;

            case 2:
                deletion_at_begin();
                traverse();
                break;

            case 3:
                insertion_at_end();
                traverse();
                break;

            case 4:
                deletion_at_end();
                traverse();
                break;

            default :
                exit(0);
        }
        printf("do u want to continoue(type y for yes : )");
        scanf("%c",&ch);
    }while(ch=='y' || ch=='Y');
}

void traverse() {
    if(start==-1) {
        printf("\nno elements in queue\n");
    }else{
        int temp= start;
        printf("elements in queue are : ");
        if(start<=end){
            while(temp<=end) {
                printf(" %d",arr[temp]);
                temp++;
            }
        }else {
            while(temp<n) {
                printf(" %d",arr[temp]);
                temp++;
            }
            temp=0;
            while(temp<=end) {
                printf(" %d",arr[temp]);
                temp++;
            }
        }
        printf("\n");
    }
}

void insertion_at_begin() {
    if(start==0&&end ==n-1 || start==end+1) {
        printf("queue overflow\n");
    }else {
        if(start==-1){ 
            start++;
            end++;
        }else if(start==0){
            start=n-1;
        }else {
            start--;
        }
        printf("\nenter the value : ");
        scanf("%d",&arr[start]);
        getchar();
    }
}

void deletion_at_begin() {
    if(start==-1) {
        printf("queue underflow\n");
    }else if(start==end){
        start=-1;
        end=-1;
    }else if(start==n-1) {
        start=0;
    }else {
        start++;
    }
}

void insertion_at_end() {
    if(end ==n-1&&start==0 || start==end+1) {
        printf("stack overflow\n");
    }else {
        if(start==-1) {
            start++;
        }else if(end==n-1) {
            end=-1;
        }
        end++;
        printf("\nenter the value : ");
        scanf("%d",&arr[end]);
        getchar();
    }
}

void deletion_at_end() {
    if(start==-1) {
        printf("queue underflow");
    }else if(start==end){
        start=end=-1;
    }else if(end==0) {
        end=n-1;
    }else {
        end--;
    }
}
