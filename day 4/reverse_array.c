#include <stdio.h>

void reverseArray(int arr[], int n){
    int start = 0;
    int end = n-1;
    int temp;

    for (int i = 0; i < n/2; i++)
    {
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d ",arr[i]);
    } 
    printf("\n"); 
}


int main(){
    int arr1[] = {1,2,3,4,5};
    int n1 = sizeof(arr1)/sizeof(arr1[0]);
    reverseArray(arr1,n1);

    int arr2[] = {4,5,2,3,1,2};
    int n2 = sizeof(arr2)/sizeof(arr2[0]);
    reverseArray(arr2,n2);

    return 0;
}