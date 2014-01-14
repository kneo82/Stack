package com.company;

import java.util.Iterator;

/**
 * Created by kneo82 on 14.01.14.
 * <p/>
 * public boolean isEmpty()       - return 'true' if stack's empty
 * public int getSize()           - returns the number of objects in the stack
 * public void push(Item item)    - places an 'item' on the stack
 * public void push(Item[] item)  - place arrays 'item' on the stack
 * public Item pop())             - removes and return an 'item' from the stack
 * public Item[] pop(int quantity)- remove and return arrays 'item' from the stack
 */
public class StackArray<Item> implements Iterable<Item> {

    private Item[] stack;
    private int size;

    public StackArray() {
        stack = (Item[]) new Object[1];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(Item item) {
        if (item == null)
            throw new java.lang.NullPointerException();
        if (size == stack.length) resize(2 * stack.length);
        stack[size++] = item;
    }

    public void push(Item[] item) {
        if (item == null)
            throw new java.lang.NullPointerException();
        if (size == stack.length || size + item.length >= stack.length) resize(2 * (stack.length + item.length));
        for (int i = 0; i < item.length; i++)
            stack[size++] = item[i];
    }

    public Item pop() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        size--;
        Item tmp = stack[size];
        stack[size] = null;
        if (size > 0 && size <= stack.length / 4)
            resize(stack.length / 2);
        return tmp;
    }

    public Item[] pop(int quantity) {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        Item[] copy = (Item[]) new Object[quantity];
        for (int i = 0; i < quantity; i++) copy[i] = pop();
        return copy;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size && i < stack.length; i++)
            copy[i] = stack[i];
        stack = copy;
    }


    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }


    private class StackIterator implements Iterator<Item> {

        private Item[] iter;
        private int sizeIter;

        private StackIterator() {
            iter = (Item[]) new Object[size];
            sizeIter = size;
            for (int i = 0; i < size; i++)
                iter[i] = stack[i];
        }

        @Override
        public boolean hasNext() {
            return sizeIter > 0;
        }


        @Override
        public Item next() {
            if (sizeIter == 0)
                throw new java.util.NoSuchElementException();
            return iter[--sizeIter];
        }


        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
