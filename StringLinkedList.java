public class StringLinkedList{

    class Node{
        public String value;
        public Node next;
        public Node(String data){
            value = data;
            next = null;
        }
    } 


    class Iterator{
        public Node current;
        public Iterator(){
            current = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    private Iterator iterator;

    public StringLinkedList(){
        head = null;
        tail = null;
        size = 0;
        iterator = new Iterator();
    }

    public StringLinkedList(String value){
        head = new Node(value);
        tail = head;
        size = 1;
        iterator = new Iterator();
    }


    public void add(String value){
        Node node = new Node(value); 
        // case 1: at least 1 element
        if( !(size < 1) ){
            tail.next = node;
            tail = node;
        }else{
            head = node;
            tail = node;
        }
        size++;
        return;
    }


    public Node next(){
        if(iterator.current == null){
            iterator.current = head;
        }else{
            iterator.current = iterator.current.next;
        }
        return iterator.current;
    }

    public boolean hasNext(){
        if(iterator.current == null){
            return head != null;
        }
        return iterator.current.next != null;
    }

    public int size(){return size;}

}