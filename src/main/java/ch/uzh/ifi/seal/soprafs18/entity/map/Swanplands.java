package ch.uzh.ifi.seal.soprafs18.entity.map;

import net.minidev.json.annotate.JsonIgnore;

public class Swanplands extends Map {

    @JsonIgnore
    public Swanplands(){

        // Tile A
        MapElement tile1 = new Tile();
        tile1.setNextTilePos(1);
        tile1.setNextTilePos(330);

        tile1	.addRow1(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow1(	new Space(	"	red	",	1	,	false)	);
        tile1	.addRow1(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow1(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow2(	new Space(	"	blue	",	1	,	false)	);
        tile1	.addRow2(	new Space(	"	black	",	0	,	false)	);
        tile1	.addRow2(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow2(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow2(	new Space(	"	yellow	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	black	",	0	,	false)	);
        tile1	.addRow3(	new Space(	"	yellow	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow3(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	yellow	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	blue	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	yellow	",	1	,	false)	);
        tile1	.addRow4(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	yellow	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	green	",	1	,	false)	);
        tile1	.addRow5(	new Space(	"	blue	",	1	,	false)	);
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


        // Tile R
        MapElement tile2 = new TerrainStrip();
        tile2.setNextTilePos(6);
        tile2.setRotation(270);

        tile2	.addRow1(	new Space(	"	green	",	1	,	false));
        tile2	.addRow1(	new Space(	"	green	",	1	,	false));
        tile2	.addRow1(	new Space(	"	black	",	0	,	false));
        tile2	.addRow1(	new Space(	"	yellow	",	1	,	false));
        tile2	.addRow1(	new Space(	"	yellow	",	1	,	false));
        tile2	.addRow2(	new Space(	"	green	",	1	,	false));
        tile2	.addRow2(	new Space(	"	green	",	3	,	false));
        tile2	.addRow2(	new Space(	"	black	",	0	,	false));
        tile2	.addRow2(	new Space(	"	yellow	",	1	,	false));
        tile2	.addRow2(	new Space(	"	red 	",	1	,	false));
        tile2	.addRow2(	new Space(	"	yellow	",	1	,	false));
        tile2	.addRow3(	new Space(	"	green	",	1	,	false));
        tile2	.addRow3(	new Space(	"	green	",	1	,	false));
        tile2	.addRow3(	new Space(	"	black	",	0	,	false));
        tile2	.addRow3(	new Space(	"	yellow	",	1	,	false));
        tile2	.addRow3(	new Space(	"	yellow	",	1	,	false));

        // Tile D
        MapElement tile3 = new Tile();
        tile3.setRotation(210);
        tile3.setNextTilePos(6);

        tile3	.addRow1(	new Space(	"	green	",	1	,	false));
        tile3	.addRow1(	new Space(	"	green	",	1	,	false));
        tile3	.addRow1(	new Space(	"	black	",	0	,	false));
        tile3	.addRow1(	new Space(	"	blue	",	3	,	false));
        tile3	.addRow2(	new Space(	"	green	",	1	,	false));
        tile3	.addRow2(	new Space(	"	green	",	1	,	false));
        tile3	.addRow2(	new Space(	"	yellow	",	3	,	false));
        tile3	.addRow2(	new Space(	"	yellow	",	1	,	false));
        tile3	.addRow2(	new Space(	"	black	",	0	,	false));
        tile3	.addRow3(	new Space(	"	green	",	1	,	false));
        tile3	.addRow3(	new Space(	"	blue	",	1	,	false));
        tile3	.addRow3(	new Space(	"	green	",	1	,	false));
        tile3	.addRow3(	new Space(	"	black	",	0	,	false));
        tile3	.addRow3(	new Space(	"	yellow	",	3	,	false));
        tile3	.addRow3(	new Space(	"	green	",	1	,	false));
        tile3	.addRow4(	new Space(	"	green	",	2	,	false));
        tile3	.addRow4(	new Space(	"	blue	",	1	,	false));
        tile3	.addRow4(	new Space(	"	blue	",	2	,	false));
        tile3	.addRow4(	new Space(	"	black	",	0	,	false));
        tile3	.addRow4(	new Space(	"	green	",	1	,	false));
        tile3	.addRow4(	new Space(	"	green	",	1	,	false));
        tile3	.addRow4(	new Space(	"	green	",	2	,	false));
        tile3	.addRow5(	new Space(	"	green	",	1	,	false));
        tile3	.addRow5(	new Space(	"	blue	",	1	,	false));
        tile3	.addRow5(	new Space(	"	blue	",	1	,	false));
        tile3	.addRow5(	new Space(	"	blue	",	2	,	false));
        tile3	.addRow5(	new Space(	"	blue	",	1	,	false));
        tile3	.addRow5(	new Space(	"	green	",	1	,	false));
        tile3	.addRow6(	new Space(	"	green	",	1	,	false));
        tile3	.addRow6(	new Space(	"	blue	",	1	,	false));
        tile3	.addRow6(	new Space(	"	blue	",	1	,	false));
        tile3	.addRow6(	new Space(	"	blue	",	1	,	false));
        tile3	.addRow6(	new Space(	"	green	",	1	,	false));
        tile3	.addRow7(	new Space(	"	green	",	1	,	false));
        tile3	.addRow7(	new Space(	"	green	",	1	,	false));
        tile3	.addRow7(	new Space(	"	green	",	1	,	false));
        tile3	.addRow7(	new Space(	"	green	",	2	,	false));

        // Tile H
        MapElement tile4 = new Tile();
        tile4.setNextTilePos(6);
        tile4.setRotation(210);

        tile4	.addRow1(	new Space(	"	blue	",	1	,	false));
        tile4	.addRow1(	new Space(	"	blue	",	2	,	false));
        tile4	.addRow1(	new Space(	"	blue	",	2	,	false));
        tile4	.addRow1(	new Space(	"	blue	",	2	,	false));
        tile4	.addRow2(	new Space(	"	yellow	",	1	,	false));
        tile4	.addRow2(	new Space(	"	blue	",	1	,	false));
        tile4	.addRow2(	new Space(	"	blue	",	1	,	false));
        tile4	.addRow2(	new Space(	"	blue	",	1	,	false));
        tile4	.addRow2(	new Space(	"	blue	",	2	,	false));
        tile4	.addRow3(	new Space(	"	yellow	",	2	,	false));
        tile4	.addRow3(	new Space(	"	yellow	",	2	,	false));
        tile4	.addRow3(	new Space(	"	yellow	",	1	,	false));
        tile4	.addRow3(	new Space(	"	yellow	",	1	,	false));
        tile4	.addRow3(	new Space(	"	blue	",	1	,	false));
        tile4	.addRow3(	new Space(	"	blue	",	2	,	false));
        tile4	.addRow4(	new Space(	"	yellow	",	3	,	false));
        tile4	.addRow4(	new Space(	"	black	",	0	,	false));
        tile4	.addRow4(	new Space(	"	yellow	",	2	,	false));
        tile4	.addRow4(	new Space(	"	yellow	",	2	,	false));
        tile4	.addRow4(	new Space(	"	yellow	",	1	,	false));
        tile4	.addRow4(	new Space(	"	green	",	1	,	false));
        tile4	.addRow4(	new Space(	"	green	",	1	,	false));
        tile4	.addRow5(	new Space(	"	yellow	",	2	,	false));
        tile4	.addRow5(	new Space(	"	yellow	",	2	,	false));
        tile4	.addRow5(	new Space(	"	yellow	",	1	,	false));
        tile4	.addRow5(	new Space(	"	yellow	",	1	,	false));
        tile4	.addRow5(	new Space(	"	green	",	1	,	false));
        tile4	.addRow5(	new Space(	"	green	",	2	,	false));
        tile4	.addRow6(	new Space(	"	yellow	",	1	,	false));
        tile4	.addRow6(	new Space(	"	green	",	1	,	false));
        tile4	.addRow6(	new Space(	"	green	",	1	,	false));
        tile4	.addRow6(	new Space(	"	green	",	1	,	false));
        tile4	.addRow6(	new Space(	"	green	",	2	,	false));
        tile4	.addRow7(	new Space(	"	green	",	1	,	false));
        tile4	.addRow7(	new Space(	"	green	",	2	,	false));
        tile4	.addRow7(	new Space(	"	green	",	2	,	false));
        tile4	.addRow7(	new Space(	"	green	",	2	,	false));

        // Tile E
        MapElement tile5 = new Tile();
        tile5.setRotation(270);
        tile5.setNextTilePos(3);

        tile5	.addRow1(	new Space(	"	red	",	1	,	false));
        tile5	.addRow1(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow1(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow1(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow2(	new Space(	"	green	",	1	,	false));
        tile5	.addRow2(	new Space(	"	green	",	2	,	false));
        tile5	.addRow2(	new Space(	"	green	",	1	,	false));
        tile5	.addRow2(	new Space(	"	black	",	0	,	false));
        tile5	.addRow2(	new Space(	"	yellow	",	1	,	false));
        tile5	.addRow3(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow3(	new Space(	"	green	",	1	,	false));
        tile5	.addRow3(	new Space(	"	black	",	0	,	false));
        tile5	.addRow3(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow3(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow3(	new Space(	"	green	",	1	,	false));
        tile5	.addRow4(	new Space(	"	green	",	1	,	false));
        tile5	.addRow4(	new Space(	"	green	",	2	,	false));
        tile5	.addRow4(	new Space(	"	green	",	3	,	false));
        tile5	.addRow4(	new Space(	"	blue	",	1	,	false));
        tile5	.addRow4(	new Space(	"	green	",	1	,	false));
        tile5	.addRow4(	new Space(	"	green	",	2	,	false));
        tile5	.addRow4(	new Space(	"	green	",	1	,	false));
        tile5	.addRow5(	new Space(	"	green	",	1	,	false));
        tile5	.addRow5(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow5(	new Space(	"	grey	",	3	,	false));
        tile5	.addRow5(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow5(	new Space(	"	black	",	0	,	false));
        tile5	.addRow5(	new Space(	"	green	",	1	,	false));
        tile5	.addRow6(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow6(	new Space(	"	black	",	0	,	false));
        tile5	.addRow6(	new Space(	"	green	",	2	,	false));
        tile5	.addRow6(	new Space(	"	blue	",	2	,	false));
        tile5	.addRow6(	new Space(	"	green	",	1	,	false));
        tile5	.addRow7(	new Space(	"	black	",	0	,	false));
        tile5	.addRow7(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow7(	new Space(	"	grey	",	1	,	false));
        tile5	.addRow7(	new Space(	"	green	",	1	,	false));

        // Tile O
        MapElement tile6 = new TerrainStrip();
        tile6.setNextTilePos(6);
        tile6.setRotation(90);

        tile6	.addRow1(	new Space(	"	yellow	",	2	,	false));
        tile6	.addRow1(	new Space(	"	yellow	",	1	,	false));
        tile6	.addRow1(	new Space(	"	grey	",	0	,	false));
        tile6	.addRow1(	new Space(	"	green	",	2	,	false));
        tile6	.addRow1(	new Space(	"	grey	",	2	,	false));
        tile6	.addRow2(	new Space(	"	yellow	",	1	,	false));
        tile6	.addRow2(	new Space(	"	black	",	0	,	false));
        tile6	.addRow2(	new Space(	"	blue	",	4	,	false));
        tile6	.addRow2(	new Space(	"	black	",	0	,	false));
        tile6	.addRow2(	new Space(	"	black	",	0	,	false));
        tile6	.addRow2(	new Space(	"	grey	",	1	,	false));
        tile6	.addRow3(	new Space(	"	yellow	",	1	,	false));
        tile6	.addRow3(	new Space(	"	blue	",	1	,	false));
        tile6	.addRow3(	new Space(	"	green	",	2	,	false));
        tile6	.addRow3(	new Space(	"	green	",	1	,	false));
        tile6	.addRow3(	new Space(	"	grey	",	1	,	false));

        // Tile K
        MapElement tile7 = new Tile();
        tile7.setRotation(330);
        tile7.setNextTilePos(4);

        tile7	.addRow1(	new Space(	"	red 	",	1	,	false));
        tile7	.addRow1(	new Space(	"	green	",	2	,	false));
        tile7	.addRow1(	new Space(	"	green	",	2	,	false));
        tile7	.addRow1(	new Space(	"	green	",	1	,	false));
        tile7	.addRow2(	new Space(	"	green	",	1	,	false));
        tile7	.addRow2(	new Space(	"	green	",	1	,	false));
        tile7	.addRow2(	new Space(	"	blue	",	3	,	false));
        tile7	.addRow2(	new Space(	"	green	",	1	,	false));
        tile7	.addRow2(	new Space(	"	green	",	2	,	false));
        tile7	.addRow3(	new Space(	"	green	",	1	,	false));
        tile7	.addRow3(	new Space(	"	green	",	2	,	false));
        tile7	.addRow3(	new Space(	"	green	",	1	,	false));
        tile7	.addRow3(	new Space(	"	green	",	3	,	false));
        tile7	.addRow3(	new Space(	"	green	",	1	,	false));
        tile7	.addRow3(	new Space(	"	green	",	2	,	false));
        tile7	.addRow4(	new Space(	"	green	",	2	,	false));
        tile7	.addRow4(	new Space(	"	green	",	1	,	false));
        tile7	.addRow4(	new Space(	"	green	",	3	,	false));
        tile7	.addRow4(	new Space(	"	green	",	1	,	false));
        tile7	.addRow4(	new Space(	"	green	",	3	,	false));
        tile7	.addRow4(	new Space(	"	green	",	1	,	false));
        tile7	.addRow4(	new Space(	"	green	",	2	,	false));
        tile7	.addRow5(	new Space(	"	green	",	2	,	false));
        tile7	.addRow5(	new Space(	"	green	",	1	,	false));
        tile7	.addRow5(	new Space(	"	green	",	3	,	false));
        tile7	.addRow5(	new Space(	"	green	",	1	,	false));
        tile7	.addRow5(	new Space(	"	green	",	2	,	false));
        tile7	.addRow5(	new Space(	"	green	",	1	,	false));
        tile7	.addRow6(	new Space(	"	green	",	2	,	false));
        tile7	.addRow6(	new Space(	"	green	",	1	,	false));
        tile7	.addRow6(	new Space(	"	yellow	",	4	,	false));
        tile7	.addRow6(	new Space(	"	green	",	1	,	false));
        tile7	.addRow6(	new Space(	"	green	",	1	,	false));
        tile7	.addRow7(	new Space(	"	green	",	1	,	false));
        tile7	.addRow7(	new Space(	"	green	",	2	,	false));
        tile7	.addRow7(	new Space(	"	green	",	2	,	false));
        tile7	.addRow7(	new Space(	"	red	    ",	1	,	false));

        //Tile T
        MapElement tile8 = new EndTile();
        tile7.setRotation(135);

        tile7	.addRow1(	new Space(	"	blue	",	1	,	false));
        tile7	.addRow1(	new Space(	"	blue	",	1	,	false));
        tile7	.addRow1(	new Space(	"	blue	",	1	,	false));

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
        mapTiles.add(tile3);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile4);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile5);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile6);
        mapTiles.add(tile7);
        mapTiles.add(tile8);

    }
}
