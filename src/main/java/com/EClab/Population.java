package com.EClab;
import com.EClab.Individual;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Population {
    private int size;
    private Set<ArrayList<Integer>> population;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Set<ArrayList<Integer>> getPopulation() {
        return this.population;
    }

    public void setPopulation(int cityNumber,int size) {
//        Set<List<Integer>> myset = new HashSet<>();
        for (int i = 0; i < size; i++) {
            Individual individual = new Individual(cityNumber);
            this.population.add(individual.generateOnePath());
        }

    }

    public Population(int cityNumber,int size) {
        this.size = size;
        setPopulation(cityNumber,size);
    }
}
