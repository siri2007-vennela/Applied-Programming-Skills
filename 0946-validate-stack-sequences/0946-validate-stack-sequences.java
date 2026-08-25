import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // pointer for popped array

        for (int x : pushed) {
            stack.push(x);
            // keep popping while top of stack equals popped[j]
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // if all elements in popped are matched, it's valid
        return j == popped.length;
    }
}
