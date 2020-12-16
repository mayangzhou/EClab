package com.EClab;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Individual {
    private int cityNumber;

    public int getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(int cityNumber) {
        this.cityNumber = cityNumber;
    }

    public Individual(int x){
        this.cityNumber = x;
    }
    public ArrayList<Integer> generateOnePath(){
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        for (int i = 1; i <= this.cityNumber ; i++) {
            listA.add(i);
        }
        Random random = new Random();
        int t = this.cityNumber;
        for (int i = 1; i <= this.cityNumber ; i++,t--) {
            int k = random.nextInt(t);
            listB.add(listA.get(k));
            //swap k and t in lista
            int tmp = listA.get(t);
            listA.set(t,listA.get(k));
            listA.set(k,tmp);
            
        }
        return listB;
    }
}
