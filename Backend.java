public class Backend {
    public static void main(String args[]) {
        
        List list = new List();
        list.append(5);
        list.append(4);
        list.append(6);
        list.append(7);
        list.append(5);
        list.append(3);
        list.append(5);
        
        list.printAll();
        System.out.println("------------------");
          
        list.removeAbove(5);
        
        list.printAll();
        System.out.println("------------------");
        
        list.removeLast ();
        list.printAll();
        System.out.println("------------------");
        
        
    }
    
    static class List {
        Node node;
        
        void append (int value) {
            
            Node newNode = new Node(value);
            
            if (node == null) {
                node = newNode;
            } else {
                Node iterator = this.node;
                while (iterator.next != null) {
                    iterator = iterator.next;
                }
                iterator.next = newNode;
            }
        }
        
        void removeLast () {
            if (node == null || node.next == null) {
                node = null;
                return;
            }
            Node iterator = this.node;
            while (iterator.next.next != null){
                iterator = iterator.next;
            }
            iterator.next = null;
        }
        
        void removeAbove (int key) {
            Node iterator = this.node;
            Node previous = null;
            
            while (iterator != null) {
                if (iterator.data > key) {
                    if (previous != null) {
                        previous.next = iterator.next;
                        iterator =  iterator.next;
                    } else {
                        node = node.next;
                        iterator = node; 
                        previous = null;
                    }
                } else {
                    previous = iterator;
                    iterator =  iterator.next;
                }
            }

        }
        
        void printAll() {
            Node iterator = this.node;
            while (iterator != null){
                System.out.println(iterator.data + ", ");
                iterator = iterator.next;
            }
            
        }
    }
    
    static class Node {
        public int data;
        public Node next;
        public Node (int data) {
            this.data = data;
            this.next = null;
        }
    }
}
