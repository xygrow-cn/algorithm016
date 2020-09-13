public class MyCircularDeque {
    class node{
        int val;
        node next = null;
        node pre = null;

        node(int v){
            this.val = v;
        }
    }

    node firsthead = null;
    node lasthead = null;
    int capacity;
    int count;   

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.count = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        node nd = new node(value);
        if(firsthead==null){
            firsthead = nd;
            lasthead = nd;
        }else {
            //只要firsthead不空 lasthead肯定也不空
            nd.next = firsthead;
            firsthead.pre = nd;
            firsthead = nd;
        }
        count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())
            return false;
        node nd = new node(value);
        if(lasthead==null){
            lasthead = nd;
            firsthead = nd;
        }else {
            nd.pre = lasthead;
            lasthead.next = nd;
            lasthead = nd;
        }
        count++;
        return  true;

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
            return false;
        if(count==1){
            firsthead = null;
            lasthead = null;
        }else {
            firsthead = firsthead.next;
            firsthead.pre = null;
        }
        count--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        if (count==1){
            firsthead = null;
            lasthead = null;
        }else {
            lasthead = lasthead.pre;
            lasthead.next = null;
        }
        count --;
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(this.firsthead == null)
            return -1;
        else
            return firsthead.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(this.lasthead == null)
            return -1;
        else
            return this.lasthead.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(this.count == 0)
            return true;
        else
            return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(this.count==this.capacity)
            return true;
        else
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