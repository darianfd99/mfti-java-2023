package Collections;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
    Node<E> head; // head of the linked list

    // add new node to the end of the linked list
    public void add(E el){
        Node<E> newNode = new Node<>(el);
        if (head == null){
            head = newNode;
            return;
        }

        Node<E> node = head;
        while (node.next != null){
            node = node.next;
        }
        node.next = newNode;
    }

    // add new element to the index position of the linked list
    public void add(int index, E element){
        Node<E> newNode = new Node<E>(element);
        Node<E> node = head;

        if (index == 0){
            head = newNode;
            head.next = node;
            return;
        }

        for (int i = 0; i < index - 1; ++i){
            node = node.next;
        }

        Node<E> oldNode = node.next;
        node.next = newNode;
        node.next.next = oldNode;
    }

    // get element in the index position of the linked list
    public E get(int index){
        Node<E> node = head;
        for (int i = 0; i < index; ++i){
            node = node.next;
        }
        return node.element;
    }

    // remove index element of the linked list
    public E remove(int index){
        if (index == 0){
            E element = head.element;
            head = head.next;
            return element;
        }

        Node<E> node = head;
        for (int i = 0; i < index - 1; ++i){
            node = node.next;
        }

        E element = node.next.element;
        node.next = node.next.next;
        return element;
    }



    @Override
    public  String toString(){
        StringBuilder builder = new StringBuilder();
        Node<E> node = head;
        builder.append("[ ");
        builder.append(node.element.toString());
        while (node.next != null){
            node = node.next;
            builder.append(" -> ");
            builder.append(node.element.toString());
        }
        builder.append(" ]");
        return builder.toString();
    }

    public Iterator<E> iterator(){
        return new LinkedListIterator<E>(head);
    }

    public static class LinkedListIterator<E> implements Iterator<E> {
        Node<E> node;

        LinkedListIterator(Node<E> head){
            node = head;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E element = node.element;
            node = node.next;
            return element;
        }
    }

    public boolean addAll(Collection<? extends E> c){
        for(E el : c){
            try{
                add(el);
            }catch (Exception e){
                return false;
            }

        }
        return true;
    }

    public boolean copy(Collection<? extends E> c){
        this.head = null;
        return addAll(c);
    }

    //Linked list node
    public static class Node<E>{
        private E element;  // element in node
        private Node<E> next; // next node

        // constructor node
        Node(E el){
            element = el;
            next = null;
        }

        // getters
        public Node<E> getNext() {
            return next;
        }

        public E getElement() {
            return element;
        }

        // setters
        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

}
