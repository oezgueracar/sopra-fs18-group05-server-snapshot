package ch.uzh.ifi.seal.soprafs18.entity.map;

public class HomeStretch extends Map {

    private long[] endTile;
    private long[] startSpaces;

    /**
     * Constructor
     */
    public HomeStretch(){
        setup();
    }

    private void setup(){ // TODO: Check if IDs are wrong but it should not matter (check if it matters!)

        // TileB
        MapElement tile1 = new Tile();
        tile1.setRotation(270);
        tile1.setNextTilePos(1);

        tile1	.addRow1(	new Space(	"green"	,	29	,	1	,	false,	true)	);
        tile1	.addRow1(	new Space(	"blue"	,	30	,	1	,	false,	false)	);
        tile1	.addRow1(	new Space(	"red"	,	31	,	1	,	false,	false)	);
        tile1	.addRow1(	new Space(	"blue"	,	32	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	33	,	1	,	false,	true)	);
        tile1	.addRow2(	new Space(	"green"	,	34	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"yellow"	,	35	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"black"	,	36	,	0	,	false,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	37	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	38	,	1	,	false,	true)	);
        tile1	.addRow3(	new Space(	"yellow"	,	39	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	40	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	41	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	42	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	43	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"blue"	,	44	,	1	,	false,	true)	);
        tile1	.addRow4(	new Space(	"green"	,	45	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"yellow"	,	46	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	47	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"yellow"	,	48	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	49	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	50	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	51	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	52	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"blue"	,	53	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	54	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	55	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	56	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	57	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	58	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	59	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	60	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	61	,	1	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	62	,	0	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	63	,	0	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	64	,	0	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	65	,	0	,	false,	false)	);




        // TIle J
        MapElement tile2 = new Tile();
        tile2.setRotation(30);
        tile2.setNextTilePos(2);

        tile2	.addRow1(	new Space(	"blue"	,	334	,	1	,	false,	false));
        tile2	.addRow1(	new Space(	"blue"	,	335	,	1	,	false,	false));
        tile2	.addRow1(	new Space(	"blue"	,	336	,	1	,	false,	false));
        tile2	.addRow1(	new Space(	"blue"	,	337	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	338	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"black"	,	339	,	0	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	340	,	2	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	341	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"grey"	,	342	,	2	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	343	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	344	,	2	,	false,	false));
        tile2	.addRow3(	new Space(	"green"	,	345	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"green"	,	346	,	2	,	false,	false));
        tile2	.addRow3(	new Space(	"grey"	,	347	,	2	,	false,	false));
        tile2	.addRow3(	new Space(	"grey"	,	348	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"yellow",	349	,	1	,	true,	false));
        tile2	.addRow4(	new Space(	"yellow",	350	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"green"	,	351	,	2	,	false,	false));
        tile2	.addRow4(	new Space(	"red"	,	352	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"green"	,	353	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"grey"	,	354	,	2	,	false,	false));
        tile2	.addRow4(	new Space(	"grey"	,	355	,	1	,	false,	true));
        tile2	.addRow5(	new Space(	"yellow",	356	,	1	,	true,	false));
        tile2	.addRow5(	new Space(	"yellow",	357	,	2	,	false,	false));
        tile2	.addRow5(	new Space(	"green"	,	358	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"green"	,	359	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"grey"	,	360	,	2	,	false,	false));
        tile2	.addRow5(	new Space(	"grey"	,	361	,	1	,	false,	true));
        tile2	.addRow6(	new Space(	"yellow",	362	,	1	,	true,	false));
        tile2	.addRow6(	new Space(	"yellow",	363	,	2	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow",	364	,	2	,	false,	false));
        tile2	.addRow6(	new Space(	"black"	,	365	,	0	,	false,	false));
        tile2	.addRow6(	new Space(	"grey"	,	366	,	1	,	false,	true));
        tile2	.addRow7(	new Space(	"yellow",	367	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"yellow",	368	,	1	,	false,	false));
        tile2	.addRow7(	new Space(	"yellow",	369	,	1	,	false,	false));
        tile2	.addRow7(	new Space(	"grey"	,	370	,	2	,	false,	true));




        // Tile Q
        MapElement tile3 = new TerrainStrip();
        tile3.setNextTilePos(2);
        tile3.setRotation(90);

        tile3	.addRow1(	new Space(	"grey"	,	542	,	1	,	true,	false));
        tile3	.addRow1(	new Space(	"yellow"	,	543	,	1	,	true,	false));
        tile3	.addRow1(	new Space(	"yellow"	,	544	,	1	,	true,	false));
        tile3	.addRow1(	new Space(	"blue"	,	545	,	1	,	true,	false));
        tile3	.addRow1(	new Space(	"green"	,	546	,	3	,	true,	false));
        tile3	.addRow2(	new Space(	"green"	,	547	,	2	,	false,	false));
        tile3	.addRow2(	new Space(	"grey"	,	548	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	549	,	2	,	false,	false));
        tile3	.addRow2(	new Space(	"yellow"	,	550	,	3	,	false,	false));
        tile3	.addRow2(	new Space(	"blue"	,	551	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	552	,	2	,	false,	false));
        tile3	.addRow3(	new Space(	"green"	,	553	,	1	,	false,	true));
        tile3	.addRow3(	new Space(	"grey"	,	554	,	3	,	false,	true));
        tile3	.addRow3(	new Space(	"green"	,	555	,	1	,	false,	true));
        tile3	.addRow3(	new Space(	"green"	,	556	,	1	,	false,	true));
        tile3	.addRow3(	new Space(	"blue"	,	557	,	2	,	false,	true));




        // Tile K
        MapElement tile4 = new Tile();
        tile4.setRotation(330);
        tile4.setNextTilePos(2);

        tile4	.addRow1(	new Space(	"red"	,	362	,	1	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	363	,	2	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	364	,	2	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	365	,	1	,	false,	true));
        tile4	.addRow2(	new Space(	"green"	,	366	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	367	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"blue"	,	368	,	3	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	369	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	370	,	2	,	false,	true));
        tile4	.addRow3(	new Space(	"green"	,	371	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	372	,	2	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	373	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	374	,	3	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	375	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	376	,	2	,	false,	true));
        tile4	.addRow4(	new Space(	"green"	,	377	,	2	,	true,	false));
        tile4	.addRow4(	new Space(	"green"	,	378	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	379	,	3	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	380	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	381	,	3	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	382	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	383	,	2	,	false,	true));
        tile4	.addRow5(	new Space(	"green"	,	384	,	2	,	true,	false));
        tile4	.addRow5(	new Space(	"green"	,	385	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	386	,	3	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	387	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	388	,	2	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	389	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	390	,	2	,	true,	false));
        tile4	.addRow6(	new Space(	"green"	,	391	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"yellow"	,	392	,	4	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	393	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	394	,	1	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	395	,	1	,	true,	false));
        tile4	.addRow7(	new Space(	"green"	,	396	,	2	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	397	,	2	,	false,	false));
        tile4	.addRow7(	new Space(	"red"	,	398	,	1	,	false,	false));




        // Tile M
        MapElement tile5 = new Tile();
        tile5.setNextTilePos(2);
        tile5.setRotation(90);

        tile5	.addRow1(	new Space(	"green"	,	436	,	1	,	true,	false));
        tile5	.addRow1(	new Space(	"green"	,	437	,	1	,	true,	false));
        tile5	.addRow1(	new Space(	"green"	,	438	,	1	,	true,	false));
        tile5	.addRow1(	new Space(	"red"	,	439	,	1	,	true,	false));
        tile5	.addRow2(	new Space(	"green"	,	440	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"yellow"	,	441	,	4	,	false,	false));
        tile5	.addRow2(	new Space(	"black"	,	442	,	0	,	false,	false));
        tile5	.addRow2(	new Space(	"black"	,	443	,	0	,	false,	false));
        tile5	.addRow2(	new Space(	"blue"	,	444	,	4	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	445	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"yellow"	,	446	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	447	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	448	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"blue"	,	449	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"black"	,	450	,	0	,	false,	false));
        tile5	.addRow4(	new Space(	"black"	,	451	,	0	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	452	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	453	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"grey"	,	454	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	455	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	456	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"black"	,	457	,	0	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	458	,	0	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	459	,	0	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	460	,	0	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	461	,	0	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	462	,	2	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	463	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"green"	,	464	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"green"	,	465	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"green"	,	466	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"grey"	,	467	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"green"	,	468	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"blue"	,	469	,	1	,	false,	true));
        tile5	.addRow7(	new Space(	"blue"	,	470	,	1	,	false,	true));
        tile5	.addRow7(	new Space(	"green"	,	471	,	1	,	false,	true));
        tile5	.addRow7(	new Space(	"green"	,	472	,	1	,	false,	true));




        //Tile C
        MapElement tile6 = new Tile();
        tile6.setRotation(330);
        tile6.setNextTilePos(2);

        tile6	.addRow1(	new Space(	"green"	,	66	,	1	,	false,	false));
        tile6	.addRow1(	new Space(	"green"	,	67	,	1	,	false,	false));
        tile6	.addRow1(	new Space(	"grey"	,	68	,	1	,	false,	false));
        tile6	.addRow1(	new Space(	"grey"	,	69	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	70	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"yellow"	,	71	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"grey"	,	72	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"blue"	,	73	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"blue"	,	74	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	75	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	76	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	77	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	78	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"grey"	,	79	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	80	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"blue"	,	81	,	1	,	true,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	82	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	83	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"black"	,	84	,	0	,	false,	false));
        tile6	.addRow4(	new Space(	"blue"	,	85	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"grey"	,	86	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"grey"	,	87	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	88	,	1	,	true,	false));
        tile6	.addRow5(	new Space(	"grey"	,	89	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	90	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	91	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	92	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	93	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"yellow"	,	94	,	1	,	true,	false));
        tile6	.addRow6(	new Space(	"grey"	,	95	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"yellow"	,	96	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"yellow"	,	97	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"blue"	,	98	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"yellow"	,	99	,	1	,	true,	false));
        tile6	.addRow7(	new Space(	"yellow"	,	100	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"blue"	,	101	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"blue"	,	102	,	1	,	false,	false));



        // Tile U
        MapElement tile7 = new EndTile();
        tile7.setRotation(315);

        tile7	.addRow1(	new Space(	"green"	,	577	,	1	,	false,	false));
        tile7	.addRow1(	new Space(	"green"	,	578	,	1	,	false,	false));
        tile7	.addRow1(	new Space(	"green"	,	579	,	1	,	false,	false));


        //SetNeighbourss
        tile1.setNeighbours();
        tile2.setNeighbours();
        tile3.setNeighbours();
        tile4.setNeighbours();
        tile5.setNeighbours();
        tile6.setNeighbours();
        tile7.setNeighbours();

        // Set neighbouring tiles
        tile1.getRow1().get(0).getNeighbours()[5] = tile2.getRow7().get(0).getId();
        tile1.getRow1().get(0).getNeighbours()[4] = tile2.getRow6().get(0).getId();
        tile1.getRow2().get(0).getNeighbours()[5] = tile2.getRow6().get(0).getId();
        tile1.getRow2().get(0).getNeighbours()[4] = tile2.getRow5().get(0).getId();
        tile1.getRow3().get(0).getNeighbours()[5] = tile2.getRow5().get(0).getId();
        tile1.getRow3().get(0).getNeighbours()[4] = tile2.getRow4().get(0).getId();
        tile1.getRow4().get(0).getNeighbours()[5] = tile2.getRow4().get(0).getId();

        tile2.getRow4().get(0).getNeighbours()[4] = tile1.getRow4().get(0).getId();
        tile2.getRow4().get(0).getNeighbours()[3] = tile1.getRow3().get(0).getId();
        tile2.getRow5().get(0).getNeighbours()[4] = tile1.getRow3().get(0).getId();
        tile2.getRow5().get(0).getNeighbours()[3] = tile1.getRow2().get(0).getId();
        tile2.getRow6().get(0).getNeighbours()[4] = tile1.getRow2().get(0).getId();
        tile2.getRow6().get(0).getNeighbours()[3] = tile1.getRow1().get(0).getId();
        tile2.getRow7().get(0).getNeighbours()[4] = tile1.getRow1().get(0).getId();

        tile2.getRow1().get(3).getNeighbours()[0] = tile3.getRow1().get(4).getId();
        tile2.getRow1().get(3).getNeighbours()[1] = tile3.getRow1().get(3).getId();
        tile2.getRow2().get(4).getNeighbours()[0] = tile3.getRow1().get(3).getId();
        tile2.getRow2().get(4).getNeighbours()[1] = tile3.getRow1().get(2).getId();
        tile2.getRow3().get(5).getNeighbours()[0] = tile3.getRow1().get(2).getId();
        tile2.getRow3().get(5).getNeighbours()[1] = tile3.getRow1().get(1).getId();
        tile2.getRow4().get(6).getNeighbours()[0] = tile3.getRow1().get(1).getId();
        tile2.getRow4().get(6).getNeighbours()[1] = tile3.getRow1().get(0).getId();

        tile3.getRow1().get(4).getNeighbours()[5] = tile2.getRow1().get(3).getId();
        tile3.getRow1().get(3).getNeighbours()[0] = tile2.getRow1().get(3).getId();
        tile3.getRow1().get(3).getNeighbours()[5] = tile2.getRow2().get(4).getId();
        tile3.getRow1().get(2).getNeighbours()[0] = tile2.getRow2().get(4).getId();
        tile3.getRow1().get(2).getNeighbours()[5] = tile2.getRow3().get(5).getId();
        tile3.getRow1().get(1).getNeighbours()[0] = tile2.getRow3().get(5).getId();
        tile3.getRow1().get(1).getNeighbours()[5] = tile2.getRow4().get(6).getId();
        tile3.getRow1().get(0).getNeighbours()[0] = tile2.getRow4().get(6).getId();

        tile3.getRow3().get(0).getNeighbours()[2] = tile4.getRow7().get(0).getId();
        tile3.getRow3().get(1).getNeighbours()[3] = tile4.getRow7().get(0).getId();
        tile3.getRow3().get(1).getNeighbours()[2] = tile4.getRow6().get(0).getId();
        tile3.getRow3().get(2).getNeighbours()[3] = tile4.getRow6().get(0).getId();
        tile3.getRow3().get(2).getNeighbours()[2] = tile4.getRow5().get(0).getId();
        tile3.getRow3().get(3).getNeighbours()[3] = tile4.getRow5().get(0).getId();
        tile3.getRow3().get(3).getNeighbours()[2] = tile4.getRow4().get(0).getId();
        tile3.getRow3().get(4).getNeighbours()[3] = tile4.getRow4().get(0).getId();

        tile4.getRow4().get(0).getNeighbours()[4] = tile3.getRow3().get(4).getId();
        tile4.getRow4().get(0).getNeighbours()[3] = tile3.getRow3().get(3).getId();
        tile4.getRow5().get(0).getNeighbours()[4] = tile3.getRow3().get(3).getId();
        tile4.getRow5().get(0).getNeighbours()[3] = tile3.getRow3().get(2).getId();
        tile4.getRow6().get(0).getNeighbours()[4] = tile3.getRow3().get(2).getId();
        tile4.getRow6().get(0).getNeighbours()[3] = tile3.getRow3().get(1).getId();
        tile4.getRow7().get(0).getNeighbours()[4] = tile3.getRow3().get(1).getId();
        tile4.getRow7().get(0).getNeighbours()[3] = tile3.getRow3().get(0).getId();

        tile4.getRow1().get(3).getNeighbours()[0] = tile5.getRow1().get(3).getId();
        tile4.getRow1().get(3).getNeighbours()[1] = tile5.getRow1().get(2).getId();
        tile4.getRow2().get(4).getNeighbours()[0] = tile5.getRow1().get(2).getId();
        tile4.getRow2().get(4).getNeighbours()[1] = tile5.getRow1().get(1).getId();
        tile4.getRow3().get(5).getNeighbours()[0] = tile5.getRow1().get(1).getId();
        tile4.getRow3().get(5).getNeighbours()[1] = tile5.getRow1().get(0).getId();
        tile4.getRow4().get(6).getNeighbours()[0] = tile5.getRow1().get(0).getId();

        tile5.getRow1().get(0).getNeighbours()[5] = tile4.getRow4().get(6).getId();
        tile5.getRow1().get(0).getNeighbours()[0] = tile4.getRow3().get(5).getId();
        tile5.getRow1().get(1).getNeighbours()[5] = tile4.getRow3().get(5).getId();
        tile5.getRow1().get(1).getNeighbours()[0] = tile4.getRow2().get(4).getId();
        tile5.getRow1().get(2).getNeighbours()[5] = tile4.getRow2().get(4).getId();
        tile5.getRow1().get(2).getNeighbours()[0] = tile4.getRow1().get(3).getId();
        tile5.getRow1().get(3).getNeighbours()[5] = tile4.getRow1().get(3).getId();

        tile5.getRow7().get(3).getNeighbours()[3] = tile6.getRow4().get(0).getId();
        tile5.getRow7().get(2).getNeighbours()[2] = tile6.getRow4().get(0).getId();
        tile5.getRow7().get(2).getNeighbours()[3] = tile6.getRow5().get(0).getId();
        tile5.getRow7().get(1).getNeighbours()[2] = tile6.getRow5().get(0).getId();
        tile5.getRow7().get(1).getNeighbours()[3] = tile6.getRow6().get(0).getId();
        tile5.getRow7().get(0).getNeighbours()[2] = tile6.getRow6().get(0).getId();
        tile5.getRow7().get(0).getNeighbours()[3] = tile6.getRow7().get(0).getId();

        tile6.getRow4().get(0).getNeighbours()[4] = tile5.getRow7().get(3).getId();
        tile6.getRow4().get(0).getNeighbours()[3] = tile5.getRow7().get(2).getId();
        tile6.getRow5().get(0).getNeighbours()[4] = tile5.getRow7().get(2).getId();
        tile6.getRow5().get(0).getNeighbours()[3] = tile5.getRow7().get(1).getId();
        tile6.getRow6().get(0).getNeighbours()[4] = tile5.getRow7().get(1).getId();
        tile6.getRow6().get(0).getNeighbours()[3] = tile5.getRow7().get(0).getId();
        tile6.getRow7().get(0).getNeighbours()[4] = tile5.getRow7().get(0).getId();

        tile6.getRow1().get(2).getNeighbours()[0] = tile7.getRow1().get(0).getId();
        tile6.getRow1().get(3).getNeighbours()[5] = tile7.getRow1().get(0).getId();
        tile6.getRow1().get(3).getNeighbours()[0] = tile7.getRow1().get(1).getId();
        tile6.getRow1().get(2).getNeighbours()[1] = tile7.getRow1().get(2).getId();
        tile6.getRow2().get(4).getNeighbours()[0] = tile7.getRow1().get(2).getId();

        tile6.getRow1().get(0).getNeighbours()[3] = tile6.getRow1().get(2).getId();
        tile6.getRow1().get(0).getNeighbours()[2] = tile6.getRow1().get(3).getId();
        tile6.getRow1().get(1).getNeighbours()[3] = tile6.getRow1().get(3).getId();
        tile6.getRow1().get(2).getNeighbours()[3] = tile6.getRow1().get(2).getId();
        tile6.getRow1().get(2).getNeighbours()[2] = tile6.getRow2().get(4).getId();



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
