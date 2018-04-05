package ch.uzh.ifi.seal.soprafs18.entity;


import java.util.ArrayList;

public class Market {

    private ArrayList<Card[]> openSlots;
    private Card[] scout;
    private Card[] trailblazer;
    private Card[] JackOfAllTrades;
    private Card[] photographer;
    private Card[] treasureChest;
    private Card[] transmitter;

    private ArrayList<Card[]> closedSlots;
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
        //Initialize openSlots
        for(int i = 0; i<3; i++){
            scout[i] = new ExpeditionCard(1, 0.5f, "Scout", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"2\"", "green", 2, false);
        }
        for(int i = 0; i<3; i++){
            trailblazer[i] = new ExpeditionCard(3, 0.5f, "Trailblazer", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"3\"", "green", 3, false);
        }
        for(int i = 0; i<3; i++){
            JackOfAllTrades[i] = new MulticolorCard(2, 0.5f, "Jack-of-all-Trades", "Allows you to move your Playing Piece to a green, yellow or blue Space by increasing your Move Counter to \"1\"", "multicolor", 1, false);
        }
        for(int i = 0; i<3; i++){
            photographer[i] = new ExpeditionCard(2, 2f, "Photographer", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"3\"", "yellow", 3, false);
        }
        for(int i = 0; i<3; i++){
            treasureChest[i] = new ExpeditionCard(3, 4f, "Treasure Chest", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"4\"", "yellow", 4, true);
        }
        for(int i = 0; i<3; i++){
            transmitter[i] = new Transmitter(4f, 0.5f, "Transmitter,", "Choose any one card from the market (off board cards are allowed) and place it on your discard pile");
            };

        //Puting arrays in openSlots
        openSlots.add(0, scout);
        openSlots.add(1, trailblazer);
        openSlots.add(2, JackOfAllTrades);
        openSlots.add(3, photographer);
        openSlots.add(4, treasureChest);
        openSlots.add(5, transmitter);

        //Initialize closedSlots
        for(int i = 0; i<3; i++){
            propPlane[i] = new MulticolorCard(4, 0.5f, "Prop Plane", "Allows you to move your Playing Piece to a green, yellow or blue Space by increasing your Move Counter to \"4\"", "multicolor", 4, true);
        }
        for(int i = 0; i<3; i++){
            adventurer[i] = new MulticolorCard(4, 0.5f, "Adventurer", "Allows you to move your Playing Piece to a green, yellow or blue Space by increasing your Move Counter to \"2\"", "green", 2, false);
        }
        for(int i = 0; i<3; i++){
            pioneer[i] = new ExpeditionCard(5, 0.5f, "Pioneer", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"5\"", "green", 5, false);
        }
        for(int i = 0; i<3; i++){
            giantMachete[i] = new ExpeditionCard(3, 0.5f, "Giant Machete", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"6\"", "green", 6, true);
        }
        for(int i = 0; i<3; i++){
            journalist[i] = new ExpeditionCard(3, 0.5f, "Journalist", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"3\"", "yellow", 3, false);
        }
        for(int i = 0; i<3; i++){
            millionaire[i] = new ExpeditionCard(5, 4f, "Millionaire", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"4\"", "yellow", 4, false);
        }
        for(int i = 0; i<3; i++){
            cartographer[i] = new Cartographer(4f, 0.5f, "Cartographer", "Draw 2 cards from your draw pile");
        }
        for(int i = 0; i<3; i++){
            compass[i] = new Compass(2f, 0.5f, "Compass", "Draw 3 cards from your draw pile");
        }
        for(int i = 0; i<3; i++){
            travelLog[i] = new TravelLog(3f, 0.5f, "Travel Log", "Draw 2 cards from your draw pile. Then choose up to 2 cards in your hand and remove them from the game");
        }
        for(int i = 0; i<3; i++){
            scientist[i] = new Scientist(4f, 05.f, "Scientist", "Draw 1 card from your draw pile. Then choose up to 1 card in your hand and remove it from the game.");
        }
        for(int i = 0; i<3; i++){
           nativ[i] = new Native(5f, 0.5, "Native", "Move your playing piece onto an adjacent space");
        }
        for(int i = 0; i<3; i++){
            captain[i] = new ExpeditionCard(2, 0.5f, "Captain", "Allows you to move your Playing Piece to a blue Space by increasing your Move Counter to \"3\"", "blue", 3, false);
        }

        //Puting arrays in closedSlots
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
    public ArrayList<Card[]> getOpenSlots(){
        return openSlots;
    }

    public ArrayList<Card[]> getClosedSlots(){
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
        private Card[] helpArray;
        helpArray = openSlots.get(emptySlot);
        openSlots.set(emptySlot, closedSlots.get(chosenCards));
        closedSlots.set(chosenCards, helpArray);

    }
}


