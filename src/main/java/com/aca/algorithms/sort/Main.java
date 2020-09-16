package com.aca.algorithms.sort;

/**
 * @author: garik
 * @created" 9/15/2020, 9:47 PM
 */
public class Main {
    public static void main(String[] args) {
        int [] arr = new int[8];
        arr[0] = 5;
        arr[1] = 15;
        arr[2] = 11;
        arr[3] = 12;
        arr[4] = 2;
        arr[5] = -5;
        arr[6] = 19;
        arr[7] = 2;

        quickSort(arr, 0, arr.length - 1);

        System.out.println(arr);
    }

    public static void bubbleSort(int[] a){
        boolean swapped = true;
        while (swapped){
            swapped = false;
            for(int i = 0; i < a.length - 1; ++i){
                if(a[i] > a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void insertionSort(int[] arr){
        for(int i  = 1; i < arr.length; ++i){
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && current < arr[j]){
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j+1] = current;
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; ++i){
            int min = arr[i];
            int minInd = i;
            for(int j = i + 1; j < arr.length; ++j){
                if(arr[j]< min){
                    min = arr[j];
                    minInd = j;
                }
            }

            int temp = arr[i];
            arr[i] = min;
            arr[minInd] = temp;
        }
    }

    public static void mergeSort(int[] arr, int n){
        if(n < 2) return;

        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for(int i = 0; i < n; ++i){
            if(i < mid){
                left[i] = arr[i];
            } else {
                right[i - mid] = arr[i];
            }
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(arr, left, right, mid, n - mid);
    }

    public static void merge(int[] arr,
                             int[] left,
                             int[] right,
                             int leftInd,
                             int rightInd){
        int i = 0, j = 0, k = 0;
        while(i < leftInd && j < rightInd){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }

            while( i < leftInd){
                arr[k++] = left[i++];
            }

            while( j < rightInd){
                arr[k++] = right[j++];
            }
        }
    }

    public static void quickSort(int[] arr, int begin, int end){
        if(begin < end){
            int partInd = partInd(arr, begin, end);
            quickSort(arr, begin, partInd - 1);
            quickSort(arr, partInd + 1, end);
        }
    }

    private static int partInd(int arr[], int begin, int end){
        int pivot = arr[end];
        int i = begin - 1;

        for(int j = begin; j < end; ++j){
            if(arr[j] <= pivot){
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i+1;
    }
}
