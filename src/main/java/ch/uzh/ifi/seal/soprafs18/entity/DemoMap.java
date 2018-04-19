package ch.uzh.ifi.seal.soprafs18.entity;

import java.util.ArrayList;

public class DemoMap extends Map {

    ArrayList<MapElement> mapTiles;

    public DemoMap(){

        //Tile A
        MapElement tile1 = new Tile();
        tile1.setNextTilePos(1);
        tile1.setRotation(-60);
        mapTiles.add(tile1);

        tile1	.addRow1(	new Space(	"	green	",	1	,	false)	);
            tile1	.addRow1(	new Space(	"	red	    ",	1	,	false)	);
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


            //Tile C
        MapElement tile2 = new Tile();
        tile2.setNextTilePos(1);
        tile2.setRotation(-240);
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

    }

        //Getter
        public ArrayList getMapTiles(){
            return mapTiles;
        }
}
