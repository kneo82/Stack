package com.company;

import java.util.Iterator;

/**
 * Created by kneo82 on 14.01.14.
 * public boolean isEmpty()       - return 'true' if stack's empty
 * public int getSize()           - returns the number of objects in the stack
 * public void push(Item item)    - places an 'item' on the stack
 * public void push(Item[] item)  - place arrays 'item' on the stack
 * public Item pop())             - removes and return an 'item' from the stack
 * public Item[] pop(int quantity)- remove and return arrays 'item' from the stack
 */
public class StackList<Item> implements Iterable<Item> {

    private Node first = null;
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node nodeNext;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize(){
        return size;
    }

    public void push(Item item) {
        if (item == null)
            throw new java.lang.NullPointerException("Item == NULL ");
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.nodeNext = oldFirst;
        size++;
    }
    public void push(Item[] item) {
        if (item == null)
            throw new java.lang.NullPointerException("Item == NULL ");
        for (int i = 0; i < item.length; i++)
            push(item[i]);
    }

    public Item pop() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("Not elements in Stack");
        Item item = (Item) first.item;
        first=first.nodeNext;
        size--;
        return item;
    }

    public Item[] pop(int quantity) {
        if (isEmpty())
            throw new java.util.NoSuchElementException("Not elements in Stack");
        Item[] copy = (Item[]) new Object[quantity];
        for (int i = 0; i < quantity; i++) copy[i] = pop();
        return copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        public Item next() {
            if (current == null)
                throw new java.util.NoSuchElementException();
            Item item = (Item) current.item;
            current = current.nodeNext;
            return item;
        }
    }
}
