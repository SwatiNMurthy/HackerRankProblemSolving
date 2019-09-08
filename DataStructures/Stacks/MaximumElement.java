import java.util.Stack;
import java.io.*;
import java.util.*;

public class MaximimElement {

    // objective here is to keep track of maximum value in a stack of integers
    // create another another Stack which will keep track of maximum
    Stack<Long> main = new Stack<>();
    Stack<Long> track = new Stack<>();

    public void insert(Long x) {
        if (main.isEmpty()) { // if stack is empty, insert the number in both
            // stacks
            main.add(x);
            track.add(x);
        } else {
            // check if number in Stack(track) is bigger than x
            // which ever is bigger, insert it into Stack
            long a = track.peek();
            track.add(Math.max(a, x));
            main.add(x); // insert it into main stack.
        }
    }

    public void remove() {
        if (!main.isEmpty()) { // pop the top elements
            track.pop();
            main.pop();
        }

    }

    public Long getMax() {
        return track.peek();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TrackMaxInStack i = new TrackMaxInStack();
        int n = scan.nextInt();
        int a;
        long num;
        for (int k = 0; k < n; k++) {
            a = scan.nextInt();

            switch (a) {
            case 1:
                num = scan.nextLong();
                i.insert(num);
                break;
            case 2:
                i.remove();
                break;
            case 3:
                System.out.println(i.getMax());
                break;
            }
        }
    }
}