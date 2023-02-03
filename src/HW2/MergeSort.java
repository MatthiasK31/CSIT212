/*
Matthias Kim
HW2
Data Structures and Algorithms
02/03/23
 */

package HW2;

import java.util.*;

public class MergeSort {
    public static int[] merge_sort(int[] array, int p, int r) {
        //if the left index is less than the right index then run sort
        if (p < r) {
            //find midpoint
            int q = p + (r - p) / 2;

            //sort halves
            merge_sort(array, p, q);
            merge_sort(array, q + 1, r);

            //merge sorted halves
            merge(array, p, q, r);
        }
        return array;
    }

    public static int[] merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1; //set size and right bound for left side
        int n2 = r - q; //set size and right bound for right side
        //create arrays the size of each side
        int[] left = new int[n1];
        int[] right = new int[n2];

        //copy elements into the left and right arrays from the original array
        for (int i = 0; i < n1; i++) {
            left[i] = array[p + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = array[q + 1 + j];
        }

        //loop while the i index less than left array bound and j index less than right array bound
        int i = 0, j = 0;
        int k = p;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) { //if the value at i in the left array less than/equal to value at j in right array, then set the value of k in the array to the value at i
                array[k] = left[i];
                i++;
            } else { //else set value at k to value at j
                array[k] = right[j];
                j++;
            }
            k++;
        }

        //continue to fill each side with any remaining elements
        while (i < n1) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = right[j];
            j++;
            k++;
        }
        return array;
    }

    /*
     * n: the size of the output array
     * k: the maximum value in the array
     */
    public static int[] generate_random_array(int n, int k) {
        List<Integer> list;
        int[] array;
        Random rnd;
        rnd = new Random(System.currentTimeMillis());
        list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++)
            list.add(rnd.nextInt(k + 1));
        Collections.shuffle(list, rnd);
        array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = list.get(i).intValue();
        return array;
    }

    /*
     * n: the size of the output array
     */
    public static int[] generate_random_array(int n) {
        List<Integer> list;
        int[] array;
        list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        Collections.shuffle(list, new Random(System.currentTimeMillis()));
        array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = list.get(i).intValue();
        return array;
    }

    /*
     * Input: an integer array
     * Output: true if the array is acsendingly sorted, otherwise return false
     */
    public static boolean check_sorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i])
                return false;
        }
        return true;
    }

    public static void print_array(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        System.out.println("Merge sort starts ------------------");
        for (int n = 100000; n <= 1000000; n = n + 100000) {
            int[] array = MergeSort.generate_random_array(n);
            //Sort.print_array(array);
            long t1 = System.currentTimeMillis();
            array = MergeSort.merge_sort(array, 0, n - 1);
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            //Sort.print_array(array);
            boolean flag = MergeSort.check_sorted(array);
            System.out.println(n + "," + t + "," + flag);
        }
        System.out.println("Merge sort ends ------------------");
    }
}