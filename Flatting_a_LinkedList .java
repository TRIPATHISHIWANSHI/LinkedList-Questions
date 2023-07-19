class Solution {
    public Node flatten(Node head) {
        Node curr = head, tail = head;
        Stack<Node> st = new Stack<>(); // this stack will store the child nodes and while flattening the list we will be flattening the child nodes which are present at last so stack will work here
        while(curr!=null){
            if(curr.child!=null){
                Node child = curr.child;
                if(curr.next!=null){   
                    st.push(curr.next);
                    curr.next.prev = null;
                }
                curr.next = child;
                child.prev = curr;
                curr.child = null;
            }
            tail = curr;
            curr = curr.next;
        }
        // after the above loop curr will be pointing to null
        while(!st.isEmpty()){
            curr = st.pop();
            tail.next = curr;
            curr.prev = tail;
            while(curr!=null){ // moving curr at the end of the child node which is popped out of the stack to add other child nodes if present in the stack
                tail = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
