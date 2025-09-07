public class selection_sort {
    //selection sort
    public static void main(String[] args) {
        int arr[] = {9,8,8,6,5,4,3,2,1};
        int n = arr.length;
        int max,temp;
        for(int i = 0;i<n;i++) {
            max = 0;
            for(int j =1;j<=n-1-i;j++) {
                if(arr[j]>arr[max]) {
                    max = j;
                }
            }
            temp = arr[n-1-i];
            arr[n-1-i] = arr[max];
            arr[max] = temp;
        }

        System.out.println("sorted array : ");
        for(int i = 0;i<n;i++) {
            System.out.printf(" " + arr[i]);
        }
        System.out.println();
        
    }
}
