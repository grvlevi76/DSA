#include<stdio.h>

void quick_sort(int arr[],int pivot,int low,int high);
void main() {
    int arr[] = {4,3,1,2,5,7,9,10,6};
    int n = sizeof(arr)/sizeof(int);
    printf("size of array : %d\n",n);

    printf("array before sorting : ");
    for(int i = 0;i<n;i++) {
        printf(" %d",arr[i]);
    }
    
    quick_sort(arr,0,1,n-1);

     printf("\narray after sorting : ");
    for(int i = 0;i<n;i++) {
        printf(" %d",arr[i]);
    } 
    printf("\n");
}

void quick_sort(int arr[],int pivot,int low,int high) {
    int left = low;
    int right = high;
    int temp;

    while(1) {
        if(left>right) {
            break;
        }
        while(arr[right]>arr[pivot]) {
            right--;
        }
        if(left>right) {
            break;
        }
        temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
        pivot = right;
        right --;

        if(left>right) {
            break;
        }
        while(arr[left]<arr[pivot]) {
            left--;
        }
        if(left>right) {
            break;
        }
        temp = arr[pivot];
        arr[pivot] = arr[left];
        arr[left] = temp;
        pivot = left;
        left ++;
    }

    if((high!=low+1)&&(high!=low)) {
        if(pivot>low) {
            quick_sort(arr,low-1,low,pivot-1);
        }

        if(pivot<high-1) {
            quick_sort(arr,pivot+1,pivot+2,high);
        }
    }
}