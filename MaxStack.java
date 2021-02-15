/*
Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.

Implement the MaxStack class:

MaxStack() Initializes the stack object.
void push(int x) Pushes element x onto the stack.
int pop() Removes the element on top of the stack and returns it.
int top() Gets the element on the top of the stack without removing it.
int peekMax() Retrieves the maximum element in the stack without removing it.
int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
 

Example 1:

Input
["MaxStack", "push", "push", "push", "top", "popMax", "top", "peekMax", "pop", "top"]
[[], [5], [1], [5], [], [], [], [], [], []]
Output
[null, null, null, null, 5, 5, 1, 5, 1, 5]

Explanation
MaxStack stk = new MaxStack();
stk.push(5);   // [5] the top of the stack and the maximum number is 5.
stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
stk.top();     // return 5, [5, 1, 5] the stack did not change.
stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
stk.top();     // return 1, [5, 1] the stack did not change.
stk.peekMax(); // return 5, [5, 1] the stack did not change.
stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
stk.top();     // return 5, [5] the stack did not change.
*/
public class MaxStack{
  Stack<Integer> s;
  Stack<Integer> max;
  Stack<Integer> temp;
  public MaxStack() {
      s = new Stack<>();
      max = new Stack<>();
      temp = new Stack<>();
  }

  public void push(int x) {
      s.push(x);
      max.push(max.isEmpty() ? x : (x > max.peek() ? x : max.peek()));
  }

  public int pop() {
      max.pop();
      return s.pop();
  }

  public int top() {
      return s.peek();
  }

  public int peekMax() {
      return max.peek();
  }

  public int popMax() {
      while(!max.peek().equals(s.peek())) {
          temp.push(s.pop());
          max.pop();
      }

      int maxVal = max.pop(); // clear max
      s.pop(); // clear max

      while(!temp.isEmpty()) push(temp.pop());

      return maxVal;
  }
}
