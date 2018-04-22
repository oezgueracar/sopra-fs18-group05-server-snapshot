package ch.uzh.ifi.seal.soprafs18.entity.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

@Entity
public abstract class Map implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    protected ArrayList<MapElement> mapTiles = new ArrayList<MapElement>();
    @Column
    protected String name;

    protected ArrayList<Blockade> blockades = new ArrayList<Blockade>();
    protected Random random;



  /*  public Map(){



        //Tile B
        MapElement tile1 = new Tile();
        tile1.setRotation(300);
        tile1.setNextTilePos(5);

        tile1	.addRow1(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow1(	new Space(	"	blue	",	1	,	false)	);
        tile1	.addRow1(	new Space(	"	red 	",	1	,	false)	);
        tile1	.addRow1(	new Space(	"	blue	",	1	,	false)	);
        tile1	.addRow2(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow2(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow2(	new Space(	"	yellow	",	1	,	false)	);
        tile1	.addRow2(	new Space(	"	black	",	0	,	false)	);
        tile1	.addRow2(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	yellow	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	blue	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	yellow	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	yellow	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	blue	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow6(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow6(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow6(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow6(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow6(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow7(	new Space(	"	green	",	0	,	false)	);
        tile1	.addRow7(	new Space(	"	green	",	0	,	false)	);
        tile1	.addRow7(	new Space(	"	green	",	0	,	false)	);
        tile1	.addRow7(	new Space(	"	green	",	0	,	false)	);

        // Tile C
        MapElement tile2 = new Tile();
        tile2.setNextTilePos(6);
        tile2.setRotation(0);
        mapTiles.add(tile2);

        tile2	.addRow1(	new Space(	"	green	",	1	,	false)	);
        tile2	.addRow1(	new Space(	"	green	",	1	,	false)	);
        tile2	.addRow1(	new Space(	"	grey	",	1	,	false)	);
        tile2	.addRow1(	new Space(	"	grey	",	1	,	false)	);
        tile2	.addRow2(	new Space(	"	green	",	1	,	false)	);
        tile2	.addRow2(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow2(	new Space(	"	grey	",	1	,	false)	);
        tile2	.addRow2(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow2(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow3(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow3(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow3(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow3(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow3(	new Space(	"	grey	",	1	,	false)	);
        tile2	.addRow3(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow4(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow4(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow4(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow4(	new Space(	"	yellow	",	0	,	false)	);
        tile2	.addRow4(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow4(	new Space(	"	grey	",	1	,	false)	);
        tile2	.addRow4(	new Space(	"	grey	",	1	,	false)	);
        tile2	.addRow5(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow5(	new Space(	"	grey	",	1	,	false)	);
        tile2	.addRow5(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow5(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow5(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow5(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow6(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow6(	new Space(	"	grey	",	1	,	false)	);
        tile2	.addRow6(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow6(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow6(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow7(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow7(	new Space(	"	yellow	",	1	,	false)	);
        tile2	.addRow7(	new Space(	"	blue	",	1	,	false)	);
        tile2	.addRow7(	new Space(	"	blue	",	1	,	false)	);

        //Tile G
        MapElement tile3 = new Tile();
        tile3.setRotation(120);
        tile3.setNextTilePos(4);

        tile3	.addRow1(	new Space(	"	green	",	1	,	false));
        tile3	.addRow1(	new Space(	"	green	",	1	,	false));
        tile3	.addRow1(	new Space(	"	green	",	1	,	false));
        tile3	.addRow1(	new Space(	"	green	",	1	,	false));
        tile3	.addRow2(	new Space(	"	green	",	1	,	false));
        tile3	.addRow2(	new Space(	"	green	",	2	,	false));
        tile3	.addRow2(	new Space(	"	yellow	",	1	,	false));
        tile3	.addRow2(	new Space(	"	black	",	0	,	false));
        tile3	.addRow2(	new Space(	"	green	",	1	,	false));
        tile3	.addRow3(	new Space(	"	yellow	",	1	,	false));
        tile3	.addRow3(	new Space(	"	yellow	",	2	,	false));
        tile3	.addRow3(	new Space(	"	yellow	",	2	,	false));
        tile3	.addRow3(	new Space(	"	grey	",	1	,	false));
        tile3	.addRow3(	new Space(	"	yellow	",	1	,	false));
        tile3	.addRow3(	new Space(	"	green	",	1	,	false));
        tile3	.addRow4(	new Space(	"	black	",	0	,	false));
        tile3	.addRow4(	new Space(	"	black	",	0	,	false));
        tile3	.addRow4(	new Space(	"	yellow	",	4	,	false));
        tile3	.addRow4(	new Space(	"	yellow	",	3	,	false));
        tile3	.addRow4(	new Space(	"	yellow	",	2	,	false));
        tile3	.addRow4(	new Space(	"	green	",	2	,	false));
        tile3	.addRow4(	new Space(	"	red 	",	1	,	false));
        tile3	.addRow5(	new Space(	"	yellow	",	1	,	false));
        tile3	.addRow5(	new Space(	"	yellow	",	2	,	false));
        tile3	.addRow5(	new Space(	"	yellow	",	2	,	false));
        tile3	.addRow5(	new Space(	"	grey	",	1	,	false));
        tile3	.addRow5(	new Space(	"	yellow	",	1	,	false));
        tile3	.addRow5(	new Space(	"	green	",	1	,	false));
        tile3	.addRow6(	new Space(	"	green	",	1	,	false));
        tile3	.addRow6(	new Space(	"	green	",	2	,	false));
        tile3	.addRow6(	new Space(	"	yellow	",	1	,	false));
        tile3	.addRow6(	new Space(	"	black	",	0	,	false));
        tile3	.addRow6(	new Space(	"	green	",	1	,	false));
        tile3	.addRow7(	new Space(	"	green	",	1	,	false));
        tile3	.addRow7(	new Space(	"	green	",	1	,	false));
        tile3	.addRow7(	new Space(	"	green	",	1	,	false));
        tile3	.addRow7(	new Space(	"	green	",	1	,	false));


        //Tile K
        MapElement tile4 = new Tile();
        tile4.setNextTilePos(1);
        tile4.setRotation(300);

        tile4	.addRow1(	new Space(	"	red 	",	1	,	false));
        tile4	.addRow1(	new Space(	"	green	",	2	,	false));
        tile4	.addRow1(	new Space(	"	green	",	2	,	false));
        tile4	.addRow1(	new Space(	"	green	",	1	,	false));
        tile4	.addRow2(	new Space(	"	green	",	1	,	false));
        tile4	.addRow2(	new Space(	"	green	",	1	,	false));
        tile4	.addRow2(	new Space(	"	blue	",	3	,	false));
        tile4	.addRow2(	new Space(	"	green	",	1	,	false));
        tile4	.addRow2(	new Space(	"	green	",	2	,	false));
        tile4	.addRow3(	new Space(	"	green	",	1	,	false));
        tile4	.addRow3(	new Space(	"	green	",	2	,	false));
        tile4	.addRow3(	new Space(	"	green	",	1	,	false));
        tile4	.addRow3(	new Space(	"	green	",	3	,	false));
        tile4	.addRow3(	new Space(	"	green	",	1	,	false));
        tile4	.addRow3(	new Space(	"	green	",	2	,	false));
        tile4	.addRow4(	new Space(	"	green	",	2	,	false));
        tile4	.addRow4(	new Space(	"	green	",	1	,	false));
        tile4	.addRow4(	new Space(	"	green	",	3	,	false));
        tile4	.addRow4(	new Space(	"	green	",	1	,	false));
        tile4	.addRow4(	new Space(	"	green	",	3	,	false));
        tile4	.addRow4(	new Space(	"	green	",	1	,	false));
        tile4	.addRow4(	new Space(	"	green	",	2	,	false));
        tile4	.addRow5(	new Space(	"	green	",	2	,	false));
        tile4	.addRow5(	new Space(	"	green	",	1	,	false));
        tile4	.addRow5(	new Space(	"	green	",	3	,	false));
        tile4	.addRow5(	new Space(	"	green	",	1	,	false));
        tile4	.addRow5(	new Space(	"	green	",	2	,	false));
        tile4	.addRow5(	new Space(	"	green	",	1	,	false));
        tile4	.addRow6(	new Space(	"	green	",	2	,	false));
        tile4	.addRow6(	new Space(	"	green	",	1	,	false));
        tile4	.addRow6(	new Space(	"	yellow	",	4	,	false));
        tile4	.addRow6(	new Space(	"	green	",	1	,	false));
        tile4	.addRow6(	new Space(	"	green	",	1	,	false));
        tile4	.addRow7(	new Space(	"	green	",	1	,	false));
        tile4	.addRow7(	new Space(	"	green	",	2	,	false));
        tile4	.addRow7(	new Space(	"	green	",	2	,	false));
        tile4	.addRow7(	new Space(	"	red	    ",	1	,	false));

        // Tile J
        MapElement tile5 = new Tile();
        tile5.setRotation(300);
        tile5.setNextTilePos(6);

        tile5	.addRow1(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow1(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow1(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow1(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow2(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow2(	new Space(	"	black	",	0	,	false));
        tile5	.addRow2(	new Space(	"	blue	",	2	,	false));
        tile5	.addRow2(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow2(	new Space(	"	grey	",	2	,	false));
        tile5	.addRow3(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow3(	new Space(	"	blue	",	2	,	false));
        tile5	.addRow3(	new Space(	"	green	",	1	,	false));
        tile5	.addRow3(	new Space(	"	green	",	2	,	false));
        tile5	.addRow3(	new Space(	"	grey	",	2	,	false));
        tile5	.addRow3(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow4(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow4(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow4(	new Space(	"	green	",	2	,	false));
        tile5	.addRow4(	new Space(	"	red 	",	1	,	false));
        tile5	.addRow4(	new Space(	"	green	",	1	,	false));
        tile5	.addRow4(	new Space(	"	grey	",	2	,	false));
        tile5	.addRow4(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow5(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow5(	new Space(	"	yellow	",	2	,	false));
        tile5	.addRow5(	new Space(	"	green	",	1	,	false));
        tile5	.addRow5(	new Space(	"	green	",	1	,	false));
        tile5	.addRow5(	new Space(	"	grey	",	2	,	false));
        tile5	.addRow5(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow6(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow6(	new Space(	"	yellow	",	2	,	false));
        tile5	.addRow6(	new Space(	"	yellow	",	2	,	false));
        tile5	.addRow6(	new Space(	"	black	",	0	,	false));
        tile5	.addRow6(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow7(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow7(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow7(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow7(	new Space(	"	grey	",	2	,	false));

        // Tile N
        MapElement tile6 = new Tile();
        tile6.setNextTilePos(4);
        tile6.setRotation(120);

        tile6	.addRow1(	new Space(	"	green	",	1	,	false));
        tile6	.addRow1(	new Space(	"	green	",	1	,	false));
        tile6	.addRow1(	new Space(	"	green	",	1	,	false));
        tile6	.addRow1(	new Space(	"	green	",	1	,	false));
        tile6	.addRow2(	new Space(	"	yellow	",	1	,	false));
        tile6	.addRow2(	new Space(	"	green	",	1	,	false));
        tile6	.addRow2(	new Space(	"	green	",	2	,	false));
        tile6	.addRow2(	new Space(	"	green	",	1	,	false));
        tile6	.addRow2(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow3(	new Space(	"	yellow	",	1	,	false));
        tile6	.addRow3(	new Space(	"	yellow	",	2	,	false));
        tile6	.addRow3(	new Space(	"	green	",	1	,	false));
        tile6	.addRow3(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow3(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow3(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow4(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow4(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow4(	new Space(	"	yellow	",	3	,	false));
        tile6	.addRow4(	new Space(	"	yellow	",	4	,	false));
        tile6	.addRow4(	new Space(	"	yellow	",	3	,	false));
        tile6	.addRow4(	new Space(	"	yellow	",	2	,	false));
        tile6	.addRow4(	new Space(	"	yellow	",	1	,	false));
        tile6	.addRow5(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow5(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow5(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow5(	new Space(	"	green	",	1	,	false));
        tile6	.addRow5(	new Space(	"	yellow	",	2	,	false));
        tile6	.addRow5(	new Space(	"	yellow	",	1	,	false));
        tile6	.addRow6(	new Space(	"	green	",	1	,	false));
        tile6	.addRow6(	new Space(	"	green	",	1	,	false));
        tile6	.addRow6(	new Space(	"	green	",	2	,	false));
        tile6	.addRow6(	new Space(	"	green	",	1	,	false));
        tile6	.addRow6(	new Space(	"	green	",	1	,	false));
        tile6	.addRow7(	new Space(	"	green	",	1	,	false));
        tile6	.addRow7(	new Space(	"	green	",	1	,	false));
        tile6	.addRow7(	new Space(	"	green	",	1	,	false));
        tile6	.addRow7(	new Space(	"	green	",	1	,	false));

        // Tile U
        MapElement tile7 = new EndTile();
        tile7.setRotation(270);

        tile7	.addRow1(	new Space(	"	green	",	1	,	false));
        tile7	.addRow1(	new Space(	"	green	",	1	,	false));
        tile7	.addRow1(	new Space(	"	green	",	1	,	false));


        // Initializing Blockades
        blockades.add(new Blockade("green", 1));
        blockades.add(new Blockade("yellow", 1));
        blockades.add(new Blockade("grey", 1));
        blockades.add(new Blockade("blue", 1));
        blockades.add(new Blockade("green", 2));
        blockades.add(new Blockade("grey", 2));

        //Filling element of the map in the ArrayList
        mapTiles.add(tile1);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile2);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile3);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile4);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile5);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile6);
        mapTiles.add(tile7);
    }*/

    protected Blockade getRandomBlockade(){
        random = new Random();
        int index = random.nextInt(blockades.size());
        Blockade blockade = blockades.get(index);
        blockades.remove(index);

        return blockade;
    }

}
