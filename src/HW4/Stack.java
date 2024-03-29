/*
Matthias Kim
HW4 - Queue/Stack/LinkedList
3/3/23
 */

package HW4;

public class Stack {
    public int size;
    public int top;
    public int[] array;

    public Stack () {
        size = 0;
        top = -1;
        array = null;
    }

    public Stack (int _size) {
        size = _size;
        top = -1;
        array = new int[size];
    }

    /*
     * Implement the Stack-Empty(S) function
     */
    public boolean empty () {
        if(array[top] == 0)
            return true;
        return false;
    }

    /*
     * Implement the Push(S, x) function
     */
    public void push (int x) {
        if (top == size -1) //extra credit: detect if stack is above capacity.
            System.err.println("Error: Stack overflow detected.");

        top = top + 1;
        array[top] = x;
    }

    /*
     * Implement the Pop(S) function
     * Return -1 if the stack is empty
     */
    public int pop () {
        if(empty())
            return 0;
        else{
            top = top - 1;
            return array[top+1];
        }
    }

    /*
     * Convert stack to string in the format of #size, [#elements]
     */
    public String toString () {
        String str;

        str = size + ", [";
        for (int i = 0; i <= top; i++)
            str += array[i] + ", ";

        str += "]";
        return str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack s;

        s = new Stack(10);
        for (int i = 0; i < 10; i++)
            s.push(i);
        System.out.println(s.toString());

        //extra credit:
        s.push(13); //to test overflow detector

        for (int i = 0; i < 2; i++)
            s.pop();
        System.out.println(s.toString());
    }

}