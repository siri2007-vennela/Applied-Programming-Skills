
import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int left = 0, ans = 0;

        for (int right = 0; right < nums.length; right++) {

            while (!max.isEmpty() && nums[max.peekLast()] < nums[right])
                max.pollLast();

            while (!min.isEmpty() && nums[min.peekLast()] > nums[right])
                min.pollLast();

            max.addLast(right);
            min.addLast(right);

            while (nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                if (max.peekFirst() == left)
                    max.pollFirst();

                if (min.peekFirst() == left)
                    min.pollFirst();

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna