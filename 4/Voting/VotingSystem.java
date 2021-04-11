package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem(){
        votingList = new ArrayList<>();
    }

    public void createVoting(String question,int type, ArrayList<String> listOfChoices){
        Voting voting = new Voting (type , question);
        votingList.add(voting);
        for (String choice :listOfChoices) {
            voting.createChoice(choice);
        }
    }

    public void printVotingQuestions(){
        for (Voting voting : votingList) {
            System.out.println(voting.getQuestion());
        }
    }

    public void printVoting(int votingNumber){
        System.out.println(votingList.get(votingNumber).getQuestion());
        System.out.println("Choices:");
        for (String choices: votingList.get(votingNumber).getChoices()) {
            System.out.println(choices);
        }
        System.out.println("Voters:");
        votingList.get(votingNumber).getVoters();
    }


    public void vote (int votingNumber, Person voter, ArrayList<String> choosenChoices){
        votingList.get(votingNumber).vote(voter,choosenChoices);
    }

    /**
     *
     * @param votingNumber
     */
    public void printResult(int votingNumber){
        votingList.get(votingNumber).printVotes();
    }


}
