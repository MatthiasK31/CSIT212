/*
Matthias Kim
HW3 - QuickSort
2/15/23
 */

package HW3;

import java.util.*;

public class QuickSort {
    public static int[] quick_sort(int[] array, int l, int r) {
        if (l < r) {
            int q = partition(array, l, r);
            quick_sort(array, l, q - 1);
            quick_sort(array, q + 1, r);
        }
        return array;
    }

    public static int partition(int[] array, int l, int r) {
        int pivot = array[r];
        int i = l - 1;

        for (int j = l; j < r - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] counting_sort(int[] a, int k) {
        int n = a.length;
        int[] b = new int[n];
        int[] c = new int[k + 1];

        //fill c array
        for (int i = 0; i <= k; i++) {
            c[i] = 0;
        }

        //count times each value appears in a
        for (int j = 0; j < a.length; j++) {
            c[a[j]]++;
        }

        //count number of elements <= each index of c
        for (int i = 1; i <= k; i++) {
            c[i] = c[i] + c[i - 1];
        }

        //sort
        for (int j = a.length - 1; j >= 0; j--) {
            b[c[a[j]]] = a[j];
            c[a[j]] = c[a[j]] - 1;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "   ");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + "   ");
        }
        System.out.println();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + "   ");
        }
        System.out.println();
        return b;
    }

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
        int k = 10;
        System.out.println("Quick sort starts ------------------");
        for (int n = 100000; n <= 1000000; n = n + 100000) {
            int[] array = QuickSort.generate_random_array(n);
            long t1 = System.currentTimeMillis();
            array = QuickSort.quick_sort(array, 0, n - 1);
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            boolean flag = QuickSort.check_sorted(array);
            System.out.println(n + "," + t + "," + flag);
        }
        System.out.println("Quick sort ends ------------------");
        System.out.println("Counting sort starts ------------------");
        for (int n = 10; n <= 100; n = n + 10) {
            int[] array = QuickSort.generate_random_array(n, k);
            long t1 = System.currentTimeMillis();
            array = QuickSort.counting_sort(array, k);
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            boolean flag = QuickSort.check_sorted(array);
            System.out.println(n + "," + t + "," + flag);
        }
        System.out.println("Counting sort ends ------------------");
    }
}