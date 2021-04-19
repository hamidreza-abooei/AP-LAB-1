package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.security.PublicKey;
import java.util.*;

public class Voting {
    private int type;// 0: mono, 1: multiple
    private String question;
    private ArrayList<Person> voters;
    private HashMap<String, HashSet<Vote>> listOfVotesToChoices;
    private Result result;

    public Voting(int type , String question){
        this.question = question;
        this.type = type;
        listOfVotesToChoices = new HashMap<>();
        voters = new ArrayList<>();
        result = new Result(listOfVotesToChoices);

    }

    public String getQuestion() {
        return question;
    }

    public void createChoice(String choice){
        HashSet<Vote> votes = new HashSet<>();
        listOfVotesToChoices.put(choice,votes);
    }

    public void vote(Person person, ArrayList<String> choosenChoices){
        if(type == 0){
            if (choosenChoices.size() == 1 ) {
                voters.add(person);
                JalaliCalendar date = new JalaliCalendar();
                String choosenChoise = choosenChoices.get(0);
                if (choosenChoise.equals("Random")) {
                    Random random = new Random();
                    int randInt = random.nextInt(listOfVotesToChoices.size());
                    HashSet<Vote> votes = listOfVotesToChoices.get(getChoices().get(randInt));
                    Vote vote = new Vote(person, date.getDayOfWeekString());
                    votes.add(vote);
                } else {
                    HashSet<Vote> votes = listOfVotesToChoices.get(choosenChoise);
                    Vote vote = new Vote(person, date.getDayOfWeekString());
                    votes.add(vote);
                }

            }else{
                System.out.println("type is 0 and you have to enter just one choice");
            }
        }else{
            if(type == 1){
                voters.add(person);
                JalaliCalendar date = new JalaliCalendar();
                for (String choosenChoise : choosenChoices) {
                        HashSet<Vote> votes = listOfVotesToChoices.get(choosenChoise);
                        Vote vote = new Vote(person, date.getDayOfWeekString());
                        votes.add(vote);

                }
            }
        }

    }
    public void results(){
        result.showPercent();
    }

    public void getVoters() {
        for (Person person : voters) {
            System.out.println(person.toString());
        }
    }

    public ArrayList<String> getChoices() {
        Set<String> keys = listOfVotesToChoices.keySet();
        return new ArrayList<>(keys);
    }

    public void printVotes(){
//        ArrayList<String> choices = getChoices();
        int winnerVotes = 0;
        String win = new String();
        for (Map.Entry<String, HashSet<Vote>> listOfVoteToChoices: listOfVotesToChoices.entrySet()) {
            int choiceVotes = listOfVoteToChoices.getValue().size();
            System.out.println(listOfVoteToChoices.getKey() +" : "+ choiceVotes);
            if (choiceVotes > winnerVotes){
                winnerVotes = choiceVotes;
                win = listOfVoteToChoices.getKey();
            }
        }
        System.out.println("Winner:" + win + " : " + winnerVotes + " votes");

    }



}
