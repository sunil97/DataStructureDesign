
/**
 * @author Sunil.Yadav
 */
class MyCircularQueue {
        int []q;
        int front=0,rear=0,cap=0,cnt=0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        q = new int [k];
        cap = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) return false;
        cnt++;
        q[rear] = value;
        rear = (rear+1+cap)%cap;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) return false;
        cnt--;
        front = (front+1+cap)%cap;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty()?-1:q[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty()?-1:q[(rear-1+cap)%cap];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(cnt==0)return true;
        return false;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(cnt==cap) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
