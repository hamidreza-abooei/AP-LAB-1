package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
	// write your code here
        VotingSystem election = new VotingSystem();
        Person p1 = new Person("Hamidreza","Abooei");
        Person p2 = new Person("Hasan","Hasani");
        Person p3 = new Person("Hossein","Hosseini");
        Person p4 = new Person("Hanie","Haniei");
        Person p5 = new Person("Hoora","Hooraei");
        Person p6 = new Person("Hamed","Hamedi");
        ArrayList<String> choices = new ArrayList<>();
        choices.add("AmirMahdiJule");
        choices.add("HasanRohani");
        choices.add("MammoootAhmadiNejat");
        election.createVoting("next iran president",0,choices);
        election.printVotingQuestions();
        ArrayList<String> choice = new ArrayList<>();
        choice.add("AmirMahdiJule");
        election.vote(0,p1,choice);
        choice.clear();
        choice.add("HasanRohani");
        election.vote(0,p2,choice);
        choice.clear();
        choice.add("Random");
        election.vote(0,p1,choice);
        choice.clear();
        choice.add("Random");
        election.vote(0,p4,choice);
        choice.clear();
        choice.add("Random");
        election.vote(0,p5,choice);
        choice.clear();
        choice.add("Random");
        election.vote(0,p6,choice);
        System.out.println("");
        election.printVoting(0);
        System.out.println("");
        election.printResult(0);

    }

}
