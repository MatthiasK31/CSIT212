package HW3;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int N = arr.length;

        // Function call
        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    public int getParent(int i){
        return (int) Math.floor(i/2);
    }

    public int getLeft(int i){
        return 2 * i;
    }

    public int getRight(int i){
        return getLeft(i) + 1;
    }

    public void maxHeapify(int [] a, int i){
        int largestIndex;
        int l = getLeft(i);
        int r = getRight(i);
        if (l < a.length && a[l] > a[i])
            largestIndex = l;
        else
            largestIndex = i;

        if (r <= a.length && a[r] > a[largestIndex])
            largestIndex = r;

        if(largestIndex != i){
            int temp = a[i];
            a[i] = a[largestIndex];
            a[largestIndex] = temp;
            maxHeapify(a, largestIndex);
        }
    }

    public void buildHeap(int [] a){
        int length = a.length;
        for (int i = (int)Math.floor(length/2) -1; i >= 0 ; i--) {
            maxHeapify(a, i);
        }
    }

    public void sort(int [] a){
        buildHeap(a);
        for (int i = a.length-1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = a[0];

            maxHeapify(a, 0);
        }
    }

    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }


}
