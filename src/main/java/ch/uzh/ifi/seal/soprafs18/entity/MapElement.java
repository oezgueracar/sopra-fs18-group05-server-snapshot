package ch.uzh.ifi.seal.soprafs18.entity;

public abstract class MapElement {

    protected Blockade blockade1;
    protected Blockade blockade2;
    protected Blockade blockade3;
    protected Blockade blockade4;
    protected Blockade blockade5;
    protected Blockade blockade6;

    public void addRow1(Space s){}
    public void addRow2(Space s){}
    public void addRow3(Space s){}
    public void addRow4(Space s){}
    public void addRow5(Space s){}
    public void addRow6(Space s){}
    public void addRow7(Space s){}

    public Blockade getRandomBlockade()

    public void setNextTilePos(int p){}
    public void setRotation(int r){}

}
