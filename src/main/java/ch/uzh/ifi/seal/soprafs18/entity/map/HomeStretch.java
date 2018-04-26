package ch.uzh.ifi.seal.soprafs18.entity.map;

public class HomeStretch extends Map {

    private long[] endTile;
    private long[] startSpaces;

    public HomeStretch(){

        // TileB
        MapElement tile1 = new Tile();
        tile1.setRotation(270);
        tile1.setNextTilePos(5);
        mapTiles.add(tile1);

        tile1	.addRow1(	new Space(	"green"	,	38	,	1	,	false)	);
        tile1	.addRow1(	new Space(	"blue"	,	39	,	1	,	false)	);
        tile1	.addRow1(	new Space(	"red"	,	40	,	1	,	false)	);
        tile1	.addRow1(	new Space(	"blue"	,	41	,	1	,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	42	,	1	,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	43	,	1	,	false)	);
        tile1	.addRow2(	new Space(	"yellow"	,	44	,	1	,	false)	);
        tile1	.addRow2(	new Space(	"black"	,	45	,	0	,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	46	,	1	,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	47	,	1	,	false)	);
        tile1	.addRow3(	new Space(	"yellow"	,	48	,	1	,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	49	,	1	,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	50	,	1	,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	51	,	1	,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	52	,	1	,	false)	);
        tile1	.addRow4(	new Space(	"blue"	,	53	,	1	,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	54	,	1	,	false)	);
        tile1	.addRow4(	new Space(	"yellow"	,	55	,	1	,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	56	,	1	,	false)	);
        tile1	.addRow4(	new Space(	"yellow"	,	57	,	1	,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	58	,	1	,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	59	,	1	,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	60	,	1	,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	61	,	1	,	false)	);
        tile1	.addRow5(	new Space(	"blue"	,	62	,	1	,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	63	,	1	,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	64	,	1	,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	65	,	1	,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	66	,	1	,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	67	,	1	,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	68	,	1	,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	69	,	1	,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	70	,	1	,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	71	,	0	,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	72	,	0	,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	73	,	0	,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	74	,	0	,	false)	);



        // TIle J
        MapElement tile2 = new Tile();
        tile2.setRotation(30);
        tile2.setNextTilePos(2);

        tile2	.addRow1(	new Space(	"blue"	,	334	,	1	,	false));
        tile2	.addRow1(	new Space(	"blue"	,	335	,	1	,	false));
        tile2	.addRow1(	new Space(	"blue"	,	336	,	1	,	false));
        tile2	.addRow1(	new Space(	"blue"	,	337	,	1	,	false));
        tile2	.addRow2(	new Space(	"blue"	,	338	,	1	,	false));
        tile2	.addRow2(	new Space(	"black"	,	339	,	0	,	false));
        tile2	.addRow2(	new Space(	"blue"	,	340	,	2	,	false));
        tile2	.addRow2(	new Space(	"blue"	,	341	,	1	,	false));
        tile2	.addRow2(	new Space(	"grey"	,	342	,	2	,	false));
        tile2	.addRow3(	new Space(	"blue"	,	343	,	1	,	false));
        tile2	.addRow3(	new Space(	"blue"	,	344	,	2	,	false));
        tile2	.addRow3(	new Space(	"green"	,	345	,	1	,	false));
        tile2	.addRow3(	new Space(	"green"	,	346	,	2	,	false));
        tile2	.addRow3(	new Space(	"grey"	,	347	,	2	,	false));
        tile2	.addRow3(	new Space(	"grey"	,	348	,	1	,	false));
        tile2	.addRow4(	new Space(	"yellow"	,	349	,	1	,	false));
        tile2	.addRow4(	new Space(	"yellow"	,	350	,	1	,	false));
        tile2	.addRow4(	new Space(	"green"	,	351	,	2	,	false));
        tile2	.addRow4(	new Space(	"red"	,	352	,	1	,	false));
        tile2	.addRow4(	new Space(	"green"	,	353	,	1	,	false));
        tile2	.addRow4(	new Space(	"grey"	,	354	,	2	,	false));
        tile2	.addRow4(	new Space(	"grey"	,	355	,	1	,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	356	,	1	,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	357	,	2	,	false));
        tile2	.addRow5(	new Space(	"green"	,	358	,	1	,	false));
        tile2	.addRow5(	new Space(	"green"	,	359	,	1	,	false));
        tile2	.addRow5(	new Space(	"grey"	,	360	,	2	,	false));
        tile2	.addRow5(	new Space(	"grey"	,	361	,	1	,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	362	,	1	,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	363	,	2	,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	364	,	2	,	false));
        tile2	.addRow6(	new Space(	"black"	,	365	,	0	,	false));
        tile2	.addRow6(	new Space(	"grey"	,	366	,	1	,	false));
        tile2	.addRow7(	new Space(	"yellow"	,	367	,	1	,	false));
        tile2	.addRow7(	new Space(	"yellow"	,	368	,	1	,	false));
        tile2	.addRow7(	new Space(	"yellow"	,	369	,	1	,	false));
        tile2	.addRow7(	new Space(	"grey"	,	370	,	2	,	false));


        // Tile Q
        MapElement tile3 = new TerrainStrip();
        tile3.setNextTilePos(3);
        tile3.setRotation(90);
        mapTiles.add(tile3);

        tile3	.addRow1(	new Space(	"grey"	,	551	,	1	,	false));
        tile3	.addRow1(	new Space(	"yellow"	,	552	,	1	,	false));
        tile3	.addRow1(	new Space(	"yellow"	,	553	,	1	,	false));
        tile3	.addRow1(	new Space(	"blue"	,	554	,	1	,	false));
        tile3	.addRow1(	new Space(	"green"	,	555	,	3	,	false));
        tile3	.addRow2(	new Space(	"green"	,	556	,	2	,	false));
        tile3	.addRow2(	new Space(	"grey"	,	557	,	1	,	false));
        tile3	.addRow2(	new Space(	"green"	,	558	,	2	,	false));
        tile3	.addRow2(	new Space(	"yellow"	,	559	,	3	,	false));
        tile3	.addRow2(	new Space(	"blue"	,	560	,	1	,	false));
        tile3	.addRow2(	new Space(	"green"	,	561	,	2	,	false));
        tile3	.addRow3(	new Space(	"green"	,	562	,	1	,	false));
        tile3	.addRow3(	new Space(	"grey"	,	563	,	3	,	false));
        tile3	.addRow3(	new Space(	"green"	,	564	,	1	,	false));
        tile3	.addRow3(	new Space(	"green"	,	565	,	1	,	false));
        tile3	.addRow3(	new Space(	"blue"	,	566	,	2	,	false));



        // Tile K
        MapElement tile4 = new Tile();
        tile4.setRotation(330);
        tile4.setNextTilePos(1);
        mapTiles.add(tile4);

        tile4	.addRow1(	new Space(	"red"	,	371	,	1	,	false));
        tile4	.addRow1(	new Space(	"green"	,	372	,	2	,	false));
        tile4	.addRow1(	new Space(	"green"	,	373	,	2	,	false));
        tile4	.addRow1(	new Space(	"green"	,	374	,	1	,	false));
        tile4	.addRow2(	new Space(	"green"	,	375	,	1	,	false));
        tile4	.addRow2(	new Space(	"green"	,	376	,	1	,	false));
        tile4	.addRow2(	new Space(	"blue"	,	377	,	3	,	false));
        tile4	.addRow2(	new Space(	"green"	,	378	,	1	,	false));
        tile4	.addRow2(	new Space(	"green"	,	379	,	2	,	false));
        tile4	.addRow3(	new Space(	"green"	,	380	,	1	,	false));
        tile4	.addRow3(	new Space(	"green"	,	381	,	2	,	false));
        tile4	.addRow3(	new Space(	"green"	,	382	,	1	,	false));
        tile4	.addRow3(	new Space(	"green"	,	383	,	3	,	false));
        tile4	.addRow3(	new Space(	"green"	,	384	,	1	,	false));
        tile4	.addRow3(	new Space(	"green"	,	385	,	2	,	false));
        tile4	.addRow4(	new Space(	"green"	,	386	,	2	,	false));
        tile4	.addRow4(	new Space(	"green"	,	387	,	1	,	false));
        tile4	.addRow4(	new Space(	"green"	,	388	,	3	,	false));
        tile4	.addRow4(	new Space(	"green"	,	389	,	1	,	false));
        tile4	.addRow4(	new Space(	"green"	,	390	,	3	,	false));
        tile4	.addRow4(	new Space(	"green"	,	391	,	1	,	false));
        tile4	.addRow4(	new Space(	"green"	,	392	,	2	,	false));
        tile4	.addRow5(	new Space(	"green"	,	393	,	2	,	false));
        tile4	.addRow5(	new Space(	"green"	,	394	,	1	,	false));
        tile4	.addRow5(	new Space(	"green"	,	395	,	3	,	false));
        tile4	.addRow5(	new Space(	"green"	,	396	,	1	,	false));
        tile4	.addRow5(	new Space(	"green"	,	397	,	2	,	false));
        tile4	.addRow5(	new Space(	"green"	,	398	,	1	,	false));
        tile4	.addRow6(	new Space(	"green"	,	399	,	2	,	false));
        tile4	.addRow6(	new Space(	"green"	,	400	,	1	,	false));
        tile4	.addRow6(	new Space(	"yellow"	,	401	,	4	,	false));
        tile4	.addRow6(	new Space(	"green"	,	402	,	1	,	false));
        tile4	.addRow6(	new Space(	"green"	,	403	,	1	,	false));
        tile4	.addRow7(	new Space(	"green"	,	404	,	1	,	false));
        tile4	.addRow7(	new Space(	"green"	,	405	,	2	,	false));
        tile4	.addRow7(	new Space(	"green"	,	406	,	2	,	false));
        tile4	.addRow7(	new Space(	"red"	,	407	,	1	,	false));



        // Tile M
        MapElement tile5 = new Tile();
        tile5.setNextTilePos(3);
        tile5.setRotation(90);
        mapTiles.add(tile5);

        tile5	.addRow1(	new Space(	"green"	,	445	,	1	,	false));
        tile5	.addRow1(	new Space(	"green"	,	446	,	1	,	false));
        tile5	.addRow1(	new Space(	"green"	,	447	,	1	,	false));
        tile5	.addRow1(	new Space(	"red"	,	448	,	1	,	false));
        tile5	.addRow2(	new Space(	"green"	,	449	,	1	,	false));
        tile5	.addRow2(	new Space(	"yellow"	,	450	,	4	,	false));
        tile5	.addRow2(	new Space(	"black"	,	451	,	0	,	false));
        tile5	.addRow2(	new Space(	"black"	,	452	,	0	,	false));
        tile5	.addRow2(	new Space(	"blue"	,	453	,	4	,	false));
        tile5	.addRow3(	new Space(	"green"	,	454	,	1	,	false));
        tile5	.addRow3(	new Space(	"yellow"	,	455	,	2	,	false));
        tile5	.addRow3(	new Space(	"green"	,	456	,	1	,	false));
        tile5	.addRow3(	new Space(	"green"	,	457	,	1	,	false));
        tile5	.addRow3(	new Space(	"blue"	,	458	,	1	,	false));
        tile5	.addRow3(	new Space(	"black"	,	459	,	0	,	false));
        tile5	.addRow4(	new Space(	"black"	,	460	,	0	,	false));
        tile5	.addRow4(	new Space(	"green"	,	461	,	1	,	false));
        tile5	.addRow4(	new Space(	"green"	,	462	,	1	,	false));
        tile5	.addRow4(	new Space(	"grey"	,	463	,	2	,	false));
        tile5	.addRow4(	new Space(	"green"	,	464	,	1	,	false));
        tile5	.addRow4(	new Space(	"green"	,	465	,	1	,	false));
        tile5	.addRow4(	new Space(	"black"	,	466	,	0	,	false));
        tile5	.addRow5(	new Space(	"green"	,	467	,	0	,	false));
        tile5	.addRow5(	new Space(	"green"	,	468	,	0	,	false));
        tile5	.addRow5(	new Space(	"green"	,	469	,	0	,	false));
        tile5	.addRow5(	new Space(	"green"	,	470	,	0	,	false));
        tile5	.addRow5(	new Space(	"grey"	,	471	,	2	,	false));
        tile5	.addRow5(	new Space(	"green"	,	472	,	1	,	false));
        tile5	.addRow6(	new Space(	"green"	,	473	,	1	,	false));
        tile5	.addRow6(	new Space(	"green"	,	474	,	1	,	false));
        tile5	.addRow6(	new Space(	"green"	,	475	,	1	,	false));
        tile5	.addRow6(	new Space(	"grey"	,	476	,	2	,	false));
        tile5	.addRow6(	new Space(	"green"	,	477	,	1	,	false));
        tile5	.addRow7(	new Space(	"blue"	,	478	,	1	,	false));
        tile5	.addRow7(	new Space(	"blue"	,	479	,	1	,	false));
        tile5	.addRow7(	new Space(	"green"	,	480	,	1	,	false));
        tile5	.addRow7(	new Space(	"green"	,	481	,	1	,	false));



        //Tile C
        MapElement tile6 = new Tile();
        tile6.setRotation(330);
        tile6.setNextTilePos(1);
        mapTiles.add(tile6);

        tile6	.addRow1(	new Space(	"green"	,	75	,	1	,	false));
        tile6	.addRow1(	new Space(	"green"	,	76	,	1	,	false));
        tile6	.addRow1(	new Space(	"grey"	,	77	,	1	,	false));
        tile6	.addRow1(	new Space(	"grey"	,	78	,	1	,	false));
        tile6	.addRow2(	new Space(	"green"	,	79	,	1	,	false));
        tile6	.addRow2(	new Space(	"yellow"	,	80	,	1	,	false));
        tile6	.addRow2(	new Space(	"grey"	,	81	,	1	,	false));
        tile6	.addRow2(	new Space(	"blue"	,	82	,	1	,	false));
        tile6	.addRow2(	new Space(	"blue"	,	83	,	1	,	false));
        tile6	.addRow3(	new Space(	"blue"	,	84	,	1	,	false));
        tile6	.addRow3(	new Space(	"blue"	,	85	,	1	,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	86	,	1	,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	87	,	1	,	false));
        tile6	.addRow3(	new Space(	"grey"	,	88	,	1	,	false));
        tile6	.addRow3(	new Space(	"blue"	,	89	,	1	,	false));
        tile6	.addRow4(	new Space(	"blue"	,	90	,	1	,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	91	,	1	,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	92	,	1	,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	93	,	0	,	false));
        tile6	.addRow4(	new Space(	"blue"	,	94	,	1	,	false));
        tile6	.addRow4(	new Space(	"grey"	,	95	,	1	,	false));
        tile6	.addRow4(	new Space(	"grey"	,	96	,	1	,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	97	,	1	,	false));
        tile6	.addRow5(	new Space(	"grey"	,	98	,	1	,	false));
        tile6	.addRow5(	new Space(	"blue"	,	99	,	1	,	false));
        tile6	.addRow5(	new Space(	"blue"	,	100	,	1	,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	101	,	1	,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	102	,	1	,	false));
        tile6	.addRow6(	new Space(	"yellow"	,	103	,	1	,	false));
        tile6	.addRow6(	new Space(	"grey"	,	104	,	1	,	false));
        tile6	.addRow6(	new Space(	"yellow"	,	105	,	1	,	false));
        tile6	.addRow6(	new Space(	"yellow"	,	106	,	1	,	false));
        tile6	.addRow6(	new Space(	"blue"	,	107	,	1	,	false));
        tile6	.addRow7(	new Space(	"yellow"	,	108	,	1	,	false));
        tile6	.addRow7(	new Space(	"yellow"	,	109	,	1	,	false));
        tile6	.addRow7(	new Space(	"blue"	,	110	,	1	,	false));
        tile6	.addRow7(	new Space(	"blue"	,	111	,	1	,	false));



        // Tile U
        MapElement tile7 = new EndTile();
        tile7.setRotation(315);

        tile7	.addRow1(	new Space(	"green"	,	586	,	1	,	false));
        tile7	.addRow1(	new Space(	"green"	,	587	,	1	,	false));
        tile7	.addRow1(	new Space(	"green"	,	588	,	1	,	false));

        // EndTile
        endTile = new long[3];
        endTile[0]= tile7.getRow1().get(0).getId();
        endTile[1]= tile7.getRow1().get(1).getId();
        endTile[2]= tile7.getRow1().get(2).getId();

        // StartPosition
        startSpaces = new long[4];
        startSpaces[0] = tile1.getRow7().get(3).getId();
        startSpaces[1] = tile1.getRow7().get(2).getId();
        startSpaces[2] = tile1.getRow7().get(1).getId();
        startSpaces[3] = tile1.getRow7().get(0).getId();

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
        mapTiles.add(tile4);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile5);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile6);
        mapTiles.add(tile7);
    }

    @Override
    public long[] getEndTile(){
        return endTile;
    }
    @Override
    public  long[] getStartingSpaces(){
        return  startSpaces;
    }

}
