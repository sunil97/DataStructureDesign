
/**
 * @author Sunil.Yadav
 * 	
 */
class MyCircularDeque {
        int []list;
        int cnt =0;
        int front=0,rear=0,cap=0;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        list = new int[k];
        cap = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())return false;
        cnt++;
        
        list[front] = value;
        front = (front+1+cap)%cap;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())return false;
        cnt++;
        rear = (rear-1+cap)%cap;
        list[rear] = value;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
       if(isEmpty()) return false;
        front = (front-1+cap)%cap;
        cnt--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
         if(isEmpty()) return false;
        rear = (rear+1+cap)%cap;
        cnt--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty()?-1:list[(front-1+cap)%cap];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return  isEmpty()?-1:list[rear];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(cnt==0)return true;
        return false;
            
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(cnt==cap)return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
