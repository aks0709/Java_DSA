package Stack.Revision;

import java.util.Stack;

public class AsteroidCollison {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for (int asteroid : asteroids) {
                boolean destroyed = false;

                // Handle collisions only if the current asteroid is moving left (< 0)
                // and the top of the stack is moving right (> 0)
                while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                    if (Math.abs(asteroid) > Math.abs(stack.peek())) {
                        // Current asteroid destroys the one on top of the stack
                        stack.pop();
                    } else if (Math.abs(asteroid) == Math.abs(stack.peek())) {
                        // Both asteroids destroy each other
                        stack.pop();
                        destroyed = true;
                        break;
                    } else {
                        // Current asteroid is destroyed
                        destroyed = true;
                        break;
                    }
                }

                // If the current asteroid was not destroyed, add it to the stack
                if (!destroyed) {
                    stack.push(asteroid);
                }
            }

            // Convert the stack to an array
            int[] result = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }

            return result;
        }
    }

}
