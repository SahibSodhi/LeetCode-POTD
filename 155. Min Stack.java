import java.util.Stack;

class MinStack {
    Stack<Long> stack; //Used long to handle overflow as we are storing 2 * value - min in stack and -2^31 <= val <= 2^31 - 1
    Long min = Long.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);
        if(stack.isEmpty()){
            stack.push(value);
            min = value;
        }
        else if(value >= min){
            stack.push(value);
        }
        else {
            stack.push(2 * value - min);
            min = value;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()){
            return;
        }

        Long val = stack.pop();
        if(val < min) {
            min = 2 * min - val;
        }
    }
    
    public int top() {
        Long val = stack.peek();

        if(val < min){
            return min.intValue();
        }
        else {
            return val.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */