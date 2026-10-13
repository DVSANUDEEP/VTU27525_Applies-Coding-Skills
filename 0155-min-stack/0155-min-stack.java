class MinStack {
    Stack<Integer> s;
    Stack<Integer> ms;

    public MinStack() {
        s = new Stack<>();
        ms = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if (ms.isEmpty()) {
            ms.push(val);
        } else {
            int min = Math.min(val, ms.peek());
            ms.push(min);
        }
    }
    
    public void pop() {
        s.pop();
        ms.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return ms.peek();
    }
}