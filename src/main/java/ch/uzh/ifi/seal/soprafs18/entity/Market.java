package ch.uzh.ifi.seal.soprafs18.entity;


import ch.uzh.ifi.seal.soprafs18.entity.card.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Market implements Serializable {

    private List<Card[]> openSlots;
    private Card[] scout;
    private Card[] trailblazer;
    private Card[] JackOfAllTrades;
    private Card[] photographer;
    private Card[] treasureChest;
    private Card[] transmitter;

    private List<Card[]> closedSlots;
    private Card[] propPlane;
    private Card[] adventurer;
    private Card[] pioneer;
    private Card[] giantMachete;
    private Card[] journalist;
    private Card[] millionaire;
    private Card[] cartographer;
    private Card[] compass;
    private Card[] travelLog;
    private Card[] scientist;
    private Card[] nativ;
    private Card[] captain;


    public Market(){
        openSlots = new ArrayList<>();
        scout = new Card[3];
        trailblazer = new Card[3];
        JackOfAllTrades = new Card[3];
        photographer = new Card[3];
        treasureChest = new Card[3];
        transmitter = new Card[3];

        closedSlots = new ArrayList<>();
        propPlane = new Card[3];
        adventurer = new Card[3];
        pioneer = new Card[3];
        giantMachete = new Card[3];
        journalist = new Card[3];
        millionaire = new Card[3];
        cartographer = new Card[3];
        compass = new Card[3];
        travelLog = new Card[3];
        scientist = new Card[3];
        nativ = new Card[3];
        captain = new Card[3];

        //setup openSlots
        for(int i = 0; i<3; i++){
            scout[i] = new ExpeditionCard(1, 0.5f, "Scout","green", 2, false);
        }
        for(int i = 0; i<3; i++){
            trailblazer[i] = new ExpeditionCard(3, 0.5f, "Trailblazer", "green", 3, false);
        }
        for(int i = 0; i<3; i++){
            JackOfAllTrades[i] = new MulticolorCard(2, 0.5f, "Jack-of-all-Trades", "multicolor", 1, false);
        }
        for(int i = 0; i<3; i++){
            photographer[i] = new ExpeditionCard(2, 2f, "Photographer", "yellow", 3, false);
        }
        for(int i = 0; i<3; i++){
            treasureChest[i] = new ExpeditionCard(3, 4f, "Treasure Chest", "yellow", 4, true);
        }
        for(int i = 0; i<3; i++){
            transmitter[i] = new Transmitter();
            };

        //Putting arrays in openSlots
        openSlots.add(0, scout);
        openSlots.add(1, trailblazer);
        openSlots.add(2, JackOfAllTrades);
        openSlots.add(3, photographer);
        openSlots.add(4, treasureChest);
        openSlots.add(5, transmitter);

        //setup closedSlots
        for(int i = 0; i<3; i++){
            propPlane[i] = new MulticolorCard(4, 0.5f, "Prop Plane", "multicolor", 4, true);
        }
        for(int i = 0; i<3; i++){
            adventurer[i] = new MulticolorCard(4, 0.5f, "Adventurer", "green", 2, false);
        }
        for(int i = 0; i<3; i++){
            pioneer[i] = new ExpeditionCard(5, 0.5f, "Pioneer", "green", 5, false);
        }
        for(int i = 0; i<3; i++){
            giantMachete[i] = new ExpeditionCard(3, 0.5f, "Giant Machete", "green", 6, true);
        }
        for(int i = 0; i<3; i++){
            journalist[i] = new ExpeditionCard(3, 0.5f, "Journalist", "yellow", 3, false);
        }
        for(int i = 0; i<3; i++){
            millionaire[i] = new ExpeditionCard(5, 4f, "Millionaire", "yellow", 4, false);
        }
        for(int i = 0; i<3; i++){
            cartographer[i] = new Cartographer();
        }
        for(int i = 0; i<3; i++){
            compass[i] = new Compass();
        }
        for(int i = 0; i<3; i++){
            travelLog[i] = new TravelLog();
        }
        for(int i = 0; i<3; i++){
            scientist[i] = new Scientist();
        }
        for(int i = 0; i<3; i++){
            nativ[i] = new Native();
        }
        for(int i = 0; i<3; i++){
            captain[i] = new ExpeditionCard(2, 0.5f, "Captain", "blue", 3, false);
        }

        //Putting arrays in closedSlots
        closedSlots.add(0, propPlane);
        closedSlots.add(1, adventurer);
        closedSlots.add(2, pioneer);
        closedSlots.add(3, giantMachete);
        closedSlots.add(4, journalist);
        closedSlots.add(5, millionaire);
        closedSlots.add(6, cartographer);
        closedSlots.add(7, compass);
        closedSlots.add(8, travelLog);
        closedSlots.add(9, scientist);
        closedSlots.add(10, nativ);
        closedSlots.add(11, captain);

    }


    //Getter and Setter
    public List<Card[]> getOpenSlots(){
        return openSlots;
    }

    public List<Card[]> getClosedSlots(){
        return closedSlots;
    }

    //remove a Card from an Array in an ArrayList
    void removeCard(Card[] a){
        for(int i=0; i<a.length; i++){
            if(a[i] == null){}
            else{
                a[i] = null;
                break;
            }
        }
    }

    //move an array from closedSlots to openSlots
    private void moveCardSlot(int emptySlot, int chosenCards){
        Card[] helpArray;
        helpArray = openSlots.get(emptySlot);
        openSlots.set(emptySlot, closedSlots.get(chosenCards));
        closedSlots.set(chosenCards, helpArray);
    }
}


