#include<stdio.h>
//binary search through recursion

int binary_rec(int arr[],int key,int low,int high);

void main() {
    int value;
    int arr1[9] ={2,4,6,7,8,12,45,56,78}; //lets just take sorted array for now 
    int n=sizeof(arr1)/sizeof(int);
    printf("enter the value to search : ");
    scanf("%d",&value);
    binary_rec(arr1,value,0,n-1);
}

int binary_rec(int arr[],int key,int low,int high) {
    if(low>high) {
        printf("value doesn't exist in array\n");
        return 1;
    } 
    int mid = (low+high)/2;
    if(key==arr[mid]) {
        printf("value %d found at index %d\n",key,mid);
        return 0;
    }else if(key<arr[mid]) {
        return binary_rec(arr,key,low,--mid);
    }else {
        return binary_rec(arr,key,++mid,high);
    }

}