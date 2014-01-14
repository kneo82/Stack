package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        StackList<Integer> stack = new StackList<Integer>();
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            int k = rand.nextInt();
            stack.push(k);
            System.out.print("el " + i + " : " + k + " / ");
        }
        System.out.println("************* Stack after added 100 elements ****************");
        for (Integer out : stack)
            System.out.print(out + " : ");
        System.out.println("************** Pop 10 elements ******************************");
        for (int i = 0; i < 10; i++)
            System.out.println("pop item : " + stack.pop());
        System.out.println("****************** Stack After Pop 10 elements***************");
        for (Integer out : stack)
            System.out.print(out + " : ");
        System.out.println("Stack size: " + stack.getSize());
        System.out.println("****************** Push 10000 elements **********************");
        Integer[] ar = new Integer[10000];
        for (int i = 0; i < ar.length; i++)
            ar[i] = rand.nextInt();
        stack.push(ar);
        System.out.println("Size stack : " + stack.getSize());
        System.out.println("************** Pop 10 elements ******************************");
        for (int i = 0; i < 10; i++)
            System.out.println("pop item : " + stack.pop());
        System.out.println("****************** Stack After Pop 10 elements***************");

        System.out.println("Stack size: " + stack.getSize());
        System.out.println("************** Pop 7000 elements ******************************");
        stack.pop(7000);
        System.out.println("****************** Stack After Pop 7000 elements***************");

        System.out.println("Stack size: " + stack.getSize());

        System.out.println("************** Pop 70 elements ******************************");
        Integer[] tmpOut;
        //tmpOut=(Integer[])stack.pop(70);
        System.out.println(Arrays.toString(stack.pop(70)));

        System.out.println("****************** Stack After Pop 70 elements***************");

        System.out.println("Stack size: " + stack.getSize());
    }
}
