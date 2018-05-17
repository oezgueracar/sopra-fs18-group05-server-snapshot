package ch.uzh.ifi.seal.soprafs18.entity;


import ch.uzh.ifi.seal.soprafs18.entity.card.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Market implements Serializable {

    private List<Card[]> openSlots;

    private List<Card[]> closedSlots;

    public Market(){
        setup();
    }

    /**
     * Initializes all cards in the market and adds them to the openSlots or closedSlots respectively.
     */
    private void setup(){
        openSlots = new ArrayList<>();
        Card[] scout = new Card[3];
        Card[] trailblazer = new Card[3];
        Card[] JackOfAllTrades = new Card[3];
        Card[] photographer = new Card[3];
        Card[] treasureChest = new Card[3];
        Card[] transmitter = new Card[3];

        closedSlots = new ArrayList<>();
        Card[] propPlane = new Card[3];
        Card[] adventurer = new Card[3];
        Card[] pioneer = new Card[3];
        Card[] giantMachete = new Card[3];
        Card[] journalist = new Card[3];
        Card[] millionaire = new Card[3];
        Card[] cartographer = new Card[3];
        Card[] compass = new Card[3];
        Card[] travelLog = new Card[3];
        Card[] scientist = new Card[3];
        Card[] nativ = new Card[3];
        Card[] captain = new Card[3];

        // Setup openSlots
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
            }

        openSlots.add(0, scout);
        openSlots.add(1, trailblazer);
        openSlots.add(2, JackOfAllTrades);
        openSlots.add(3, photographer);
        openSlots.add(4, treasureChest);
        openSlots.add(5, transmitter);

        // Setup closedSlots
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
            journalist[i] = new ExpeditionCard(3, 3f, "Journalist", "yellow", 3, false);
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


    public List<Card[]> getOpenSlots(){
        return openSlots;
    }

    public List<Card[]> getClosedSlots(){
        return closedSlots;
    }

    //Will only return card from closed slot if there is a free place in the openSlot (free spaces are null)
    public Card getCardByCardId(long cardId){
        for(Card[] cardArray : openSlots){
            if(cardArray != null) {
                for (Card c : cardArray) {
                    if (c != null && c.getId() == cardId) {
                        return c;
                    }
                }
            }
        }

        boolean openSpaceIsFree = false;
        for(Card[] cardArray : openSlots){
            if(cardArray == null){
                openSpaceIsFree = true;
            }
        }
        if(openSpaceIsFree) {
            for (int i = 0; i < closedSlots.size(); i++) {
                if (closedSlots.get(i) != null) {
                    for (int j = 0; j < closedSlots.get(i).length; j++) {
                        if (closedSlots.get(i)[j] != null && closedSlots.get(i)[j].getId() == cardId) {
                            return closedSlots.get(i)[j];
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Removes a card from the according array
     * @param cardId the id of the card that is removed
     * @return the card instance matching cardId
     */
    protected Card removeCard(long cardId){
        for(int i = 0; i < openSlots.size(); i++){
            if(openSlots.get(i) != null) {
                for (int j = 0; j < openSlots.get(i).length; j++) {
                    if (openSlots.get(i)[j] != null && openSlots.get(i)[j].getId() == cardId) {
                        Card toBeRemoved = openSlots.get(i)[j];
                        openSlots.get(i)[j] = null;
                        openSlots.set(i, returnShrunkArray(openSlots.get(i)));
                        return toBeRemoved;
                    }
                }
            }
        }

        boolean openSpaceIsFree = false;
        for(Card[] cardArray : openSlots){
            if(cardArray == null){
                openSpaceIsFree = true;
            }
        }
        if(openSpaceIsFree) {
            for (int i = 0; i < closedSlots.size(); i++) {
                if (closedSlots.get(i) != null) {
                    for (int j = 0; j < closedSlots.get(i).length; j++) {
                        if (closedSlots.get(i)[j] != null && closedSlots.get(i)[j].getId() == cardId) {
                            Card toBeRemoved = closedSlots.get(i)[j];
                            closedSlots.get(i)[j] = null;
                            closedSlots.set(i, returnShrunkArray(closedSlots.get(i)));
                            moveCardSlot(i);
                            return toBeRemoved;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Card removeTransmitter(long cardId){
        for(int i = 0; i < openSlots.size(); i++){
            if(openSlots.get(i) != null) {
                for (int j = 0; j < openSlots.get(i).length; j++) {
                    if (openSlots.get(i)[j] != null && openSlots.get(i)[j].getId() == cardId) {
                        Card toBeRemoved = openSlots.get(i)[j];
                        openSlots.get(i)[j] = null;
                        openSlots.set(i, returnShrunkArray(openSlots.get(i)));
                        return toBeRemoved;
                    }
                }
            }
        }
        for(int i = 0; i < closedSlots.size(); i++){
            if(closedSlots.get(i) != null) {
                for (int j = 0; j < closedSlots.get(i).length; j++) {
                    if (closedSlots.get(i)[j] != null && closedSlots.get(i)[j].getId() == cardId) {
                        Card toBeRemoved = closedSlots.get(i)[j];
                        closedSlots.get(i)[j] = null;
                        closedSlots.set(i, returnShrunkArray(closedSlots.get(i)));
                        return toBeRemoved;
                    }
                }
            }
        }
        return null;
    }

    //Move an array from closedSlots to first empty entry of openSlots

    /**
     * Moves a card array from closedSlots to openSlots
     * @param chosenCardsIndex The index of the card Array in the ArrayList openSlots.
     */

    //Moves the chosen Card Array from closedSlots to openSlots.
    private void moveCardSlot(int chosenCardsIndex){
        for(int i = 0; i < openSlots.size(); i++){
            if (openSlots.get(i) == null){
                openSlots.set(i, closedSlots.get(chosenCardsIndex));
                closedSlots.set(chosenCardsIndex, null);
                System.out.println("The " + i + "th open slot should now contain an array with the cards:");
                for(Card c : openSlots.get(i)){
                    System.out.println(c.getId());
                }
                System.out.println("The " + chosenCardsIndex + "th closed slot should now be null:");
                try {
                    closedSlots.get(i);
                } catch ( NullPointerException e ) {
                    System.out.println("True. It is null.");
                }
                return;
            }
        }
    }

    /**
     *
     * @param cardArray The Array of Cards that needs to be shrunk.
     * @return Returns a shrunken cardArray without any null elements.
     */
    private Card[] returnShrunkArray(Card[] cardArray){
        if((cardArray.length - 1) > 0) {
            Card[] helperArray = new Card[cardArray.length - 1];
            int index = 0;
            for (Card c : cardArray) {
                if (c != null) {
                    helperArray[index++] = c;
                }
            }
            return helperArray;
        }
        return null;
    }
}
