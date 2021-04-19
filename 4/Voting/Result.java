package com.company;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Result {
    private HashMap<String, HashSet<Vote>> listOfVotes;
    private ArrayList<Integer> voted;
    private ArrayList<Integer> indexes;
    private ArrayList<String> sorted;
    private int allVotes;

    public Result (HashMap<String, HashSet<Vote>> listOfVotes ){
        this.listOfVotes = listOfVotes;
        voted = new ArrayList<>();
        indexes = new ArrayList<>();
        sorted = new ArrayList<>();
    }
    private void sort(){
        int index = 0;
        allVotes = 0;
        for ( Map.Entry<String, HashSet<Vote>> listOfVote: listOfVotes.entrySet() ) {
            sorted.add(listOfVote.getKey());
            voted.add(listOfVote.getValue().size());
            allVotes += listOfVote.getValue().size();
            indexes.add(index);
            index++;
        }

        for (int i = 0; i < voted.size(); i++) {
            int max = 0;
            int ind = 0;
            for (int j = i; j < voted.size(); j++) {
                if (voted.get(j) >= max) {
                    max = voted.get(j);
                    ind = j;
                }
            }
            int temp = voted.get(i);
            voted.set(i,max);
            voted.set(ind,temp);
            temp = indexes.get(i);
            indexes.set(i,indexes.get(ind));
            indexes.set(ind,temp);

        }

        ArrayList<String> sort = new ArrayList<>();
        for (int i = 0; i < indexes.size(); i++) {
            sort.add(sorted.get(indexes.get(i)));
//            System.out.println(indexes);
        }
        sorted = sort;

    }
    public void showPercent(){

//        System.out.println(allVotes);
        sort();
        for (int i = 0; i < sorted.size(); i++)
        {
            System.out.print(sorted.get(i));
            System.out.print("  " +(((float)voted.get(i)) /allVotes * 100) );
            System.out.println("%");
        }

    }

}
