package com.variationOperators;

import java.util.*;
import com.EClab.Individual;
public class CrossoverOperators {
    private ArrayList<Integer> parentA;
    private ArrayList<Integer> parentB;
    private ArrayList<Integer> childA;
    private ArrayList<Integer> childB;
    private int a;
    private int b;

    public ArrayList<Integer> getParentA() {
        return parentA;
    }

    public void setParentA(ArrayList<Integer> parentA) {
        this.parentA = parentA;
    }

    public ArrayList<Integer> getParentB() {
        return parentB;
    }

    public void setParentB(ArrayList<Integer> parentB) {
        this.parentB = parentB;
    }

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

    public ArrayList<Integer> getChildA() {
        return childA;
    }

    public void setChildA(ArrayList<Integer> childA) {
        this.childA = childA;
    }

    public List<Integer> getChildB() {
        return childB;
    }

    public void setChildB(ArrayList<Integer> childB) {
        this.childB = childB;
    }

    public void generateAB(){
        Random random = new Random();
        int a = random.nextInt(parentA.size());
        int b = random.nextInt(parentA.size());
        while (a==b){
            b = random.nextInt(parentA.size());
        }
        if(a>b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        this.a = a;
        this.b = b;
    }
    public void orderCrossover(){
        generateAB();
        childA.clear();
        childA.addAll(parentA);
        childB.clear();
        childB.addAll(parentB);
        Set<Integer> parentAPart = new HashSet<>();
        Set<Integer> parentBPart = new HashSet<>();
        for (int i = this.a; i <= this.b ; i++) {
            parentAPart.add(parentA.get(i));
            parentBPart.add(parentB.get(i));
        }


        for (int i = 1,ca = this.b,cb = this.b; i <= parentA.size(); i++) {
            int t = (b+i)%(parentA.size());

            if (!parentAPart.contains(parentB.get(t))){
                childA.set(++ca%childA.size(),parentB.get(t));
            }
            if (!parentBPart.contains(parentA.get(t))){
                childB.set(++cb%childB.size(),parentA.get(t));
            }

        }

    }

    public void PMXCrossover(){
        generateAB();
        Map<Integer,Integer> mapAB = new HashMap<>();
        Map<Integer,Integer> mapBA = new HashMap<>();

            for (int i = this.a; i <= this.b ; i++) {

                    mapAB.put(parentA.get(i),parentB.get(i));

                    mapBA.put(parentB.get(i),parentA.get(i));

            }

        childA.clear();
        childA.addAll(parentB);
        childB.clear();
        childB.addAll(parentA);
        for (int i = 0; i < parentA.size(); i++) {
            if (i >=a && i <= b){
            }else {
                int k = parentA.get(i);
                while(mapBA.containsKey(k)){
                    k = mapBA.get(k);
                }
                childA.set(i,k);

                int m = parentB.get(i);
                while(mapAB.containsKey(m)){
                    m = mapAB.get(m);
                }
                childB.set(i,m);
            }

        }
    }
    public void circleCrossover(){
        childA.clear();
//        childA.addAll(parentB);
        childB.clear();
//        childB.addAll(parentA);
        Set<Integer> setValue = new HashSet<>();
        Set<Integer> setIndex = new HashSet<>();
        int i = 0;
        while(!setValue.contains(parentA.get(i))){
            setValue.add(parentA.get(i));
            setIndex.add(i);
            i = parentB.indexOf(parentA.get(i));
        }

        for (int j = 0; j < parentA.size(); j++) {
            if(setIndex.contains(j)){
                childA.add(parentA.get(j));
                childB.add(parentB.get(j));
            }else {
                childA.add(parentB.get(j));
                childB.add(parentA.get(j));
            }
        }
    }

    public void EdgeRecombination(){
        //this method needs adjacency matrix while in TSP problems its fully connected
        Individual individual = new Individual(parentA.size());
        childA.clear();
        childA.addAll(individual.generateOnePath());
        //因为此时的图是全连接的 所以该算法退化为随机生成一个全排列
    }


}
