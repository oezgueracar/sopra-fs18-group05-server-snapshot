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
        //TODO: add a parameter to constructor of expeditionCards, change jackofaltrades to multiColorCard
        //Initialize openSlots
        for(int i = 0; i<3; i++){
            scout[i] = new ExpeditionCard(1, 0.5f, "Scout", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"2\"", "green", 2);
        }
        for(int i = 0; i<3; i++){
            trailblazer[i] = new ExpeditionCard(3, 0.5f, "Trailblazer", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"3\"", "green", 3);
        }
        for(int i = 0; i<3; i++){
            JackOfAllTrades[i] = new ExpeditionCard(2, 0.5f, "Jack-of-all-Trades", "Allows you to move your Playing Piece to a green, yellow or blue Space by increasing your Move Counter to \"1\"", "multicolor", 1);
        }
        for(int i = 0; i<3; i++){
            photographer[i] = new ExpeditionCard(2, 2f, "Photographer", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"3\"", "yellow", 3);
        }
        for(int i = 0; i<3; i++){
            treasureChest[i] = new ExpeditionCard(3, 4f, "Treasure Chest", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"4\"", "yellow", 4);
        }

        //TODO: transmitter card
        /*for(int i = 0; i<3; i++){
            transmitter[i]
            };*/
        //TODO: put arrays in openSlots
        //Puting arrays in openSlots


        //TODO: propplane and adventurer are MultiColorCards, initialize ActionCards
        //Initialize closedSlots
        for(int i = 0; i<3; i++){
            propPlane[i] = new ExpeditionCard(4, 0.5f, "Prop Plane", "Allows you to move your Playing Piece to a green, yellow or blue Space by increasing your Move Counter to \"4\"", "multicolor", 4);
        }
        for(int i = 0; i<3; i++){
            adventurer[i] = new ExpeditionCard(4, 0.5f, "Adventurer", "Allows you to move your Playing Piece to a green, yellow or blue Space by increasing your Move Counter to \"2\"", "green", 2);
        }
        for(int i = 0; i<3; i++){
            pioneer[i] = new ExpeditionCard(5, 0.5f, "Pioneer", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"5\"", "green", 5);
        }
        for(int i = 0; i<3; i++){
            giantMachete[i] = new ExpeditionCard(3, 0.5f, "Giant Machete", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"6\"", "green", 6);
        }
        for(int i = 0; i<3; i++){
            journalist[i] = new ExpeditionCard(3, 0.5f, "Journalist", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"3\"", "yellow", 3);
        }
        for(int i = 0; i<3; i++){
            millionaire[i] = new ExpeditionCard(5, 4f, "Millionaire", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"4\"", "yellow", 4);
        }
/*        for(int i = 0; i<3; i++){
            cartographer[i] = new ActionCard() {
            }
        }
        for(int i = 0; i<3; i++){
            compass[i] = new ActionCard() {
            }
        }
        for(int i = 0; i<3; i++){
            travelLog[i] = new ActionCard() {
            }
        }
        for(int i = 0; i<3; i++){
            scientist[i] = new ActionCard() {
            }
        }
        for(int i = 0; i<3; i++){
           nativ[i] = new ActionCard() {
            }
        }*/
        for(int i = 0; i<3; i++){
            captain[i] = new ExpeditionCard(2, 0.5f, "Captain", "Allows you to move your Playing Piece to a blue Space by increasing your Move Counter to \"3\"", "blue", 3);
        }

        //TODO: put arrays in closedSlots
        //Puting arrays in closedSlots

    }

}


