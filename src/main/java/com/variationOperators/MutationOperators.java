package com.variationOperators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MutationOperators {
    private ArrayList<Integer> integerList;
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(ArrayList<Integer> integerList) {
        this.integerList = integerList;
    }
    public void generateAB(){
        Random random = new Random();
        int a = random.nextInt(integerList.size());
        int b = random.nextInt(integerList.size());
        while (a==b){
            b = random.nextInt(integerList.size());
        }
        if(a>b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        this.a = a;
        this.b = b;
    }
    public void Insert(){
        generateAB();
        int tmp = integerList.get(this.b);
        for (int i = this.b; i > this.a; i--) {
            integerList.set(i,integerList.get(i-1));
        }
        integerList.set(this.a+1,tmp);
    }
    public void swap(){
        generateAB();
        int tmp = integerList.get(this.b);
        integerList.set(this.b,integerList.get(this.a));
        integerList.set(this.a,tmp);
    }
    public void swapWithAB(int a,int b){
        int tmp = integerList.get(b);
        integerList.set(b,integerList.get(a));
        integerList.set(a,tmp);
    }
    public void inversion(){
        generateAB();
        for (int i = a, j = b; i < j; i++,j--) {
            swapWithAB(i,j);
        }
    }
    public void scramble(){
        generateAB();
        Random random = new Random();

        for (int i = this.a,t = this.b-this.a; i < this.b; i++,t--) {
            int k = random.nextInt(t);
            swapWithAB(k+this.a,t+this.a);
        }
    }


}
