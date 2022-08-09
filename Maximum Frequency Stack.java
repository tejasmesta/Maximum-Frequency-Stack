class FreqStack {  
    Map<Integer,Integer> f;
    Map<Integer,Stack<Integer>> stack;
    
    int mF;

    public FreqStack() {
        f = new HashMap<>();
        stack = new HashMap<>();
        mF = 0;
    }
    
    public void push(int val) {
        int ff = f.getOrDefault(val,0)+1;
        f.put(val,ff);
        if(ff>mF)
        {
            mF = ff;
        }
        stack.computeIfAbsent(ff,z-> new Stack()).push(val);
    }
    
    public int pop() {
        int x = stack.get(mF).pop();
        f.put(x,f.get(x)-1);
        if(stack.get(mF).size()==0)
        {
            mF--;
        }
        return x;
    }
    
    
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
