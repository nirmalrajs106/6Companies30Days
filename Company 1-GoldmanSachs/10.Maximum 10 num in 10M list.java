package GoldmanSachs;

import java.util.*;
/*
 problem statement wasn't available
 I am taking a small array with 100 entries and selecting largest 10 elements
 This will work fine with larger size array as well
 Quick Select partitioning : TC: O(N), worst case O(N^2)
 */

public class TenLargestElement {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }

        int pos = kthSmallest(arr, 0, arr.length - 1, 10);
        for(int i = 0; i <= pos; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int kthSmallest(int arr[], int l, int r, int k)
    {

        if (k > 0 && k <= r - l + 1)
        {

            int pos = randomPartition(arr, l, r);

            if (pos-l == k-1)
                return pos;

            if (pos-l > k-1)
                return kthSmallest(arr, l, pos-1, k);

            return kthSmallest(arr, pos+1, r, k-pos+l-1);
        }

        return Integer.MAX_VALUE;
    }

    private static int partition(int arr[], int l, int r)
    {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++)
        {
            if (arr[j] <= x)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    // randomly select pivot
    private static int randomPartition(int arr[], int l, int r)
    {
        int n = r-l+1;
        int pivot = (int)(Math.random()) * (n-1);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

    private static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}