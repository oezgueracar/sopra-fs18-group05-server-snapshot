package ch.uzh.ifi.seal.soprafs18.entity.map;

public class HillsOfGold extends Map {


    private long[] endTile;
    private long[] startSpaces;

    /**
     * Constructor
     */
    public HillsOfGold() {
        setup();
    }

    public HillsOfGold(int i){ testSetup();}

    private void testSetup(){

        //Tile B
        MapElement tile1 = new Tile();
        tile1.setRotation(300);
        tile1.setNextTilePos(6);

        tile1	.addRow1(	new Space(	"green"	,	38	,	1	,	false,	true)	);
        tile1	.addRow1(	new Space(	"blue"	,	39	,	1	,	false,	false)	);
        tile1	.addRow1(	new Space(	"red"	,	40	,	1	,	false,	false)	);
        tile1	.addRow1(	new Space(	"blue"	,	41	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	42	,	1	,	false,	true)	);
        tile1	.addRow2(	new Space(	"green"	,	43	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"yellow"	,	44	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"black"	,	45	,	0	,	false,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	46	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	47	,	1	,	false,	true)	);
        tile1	.addRow3(	new Space(	"yellow"	,	48	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	49	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	50	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	51	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	52	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"blue"	,	53	,	1	,	false,	true)	);
        tile1	.addRow4(	new Space(	"green"	,	54	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"yellow",	55	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	56	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"yellow",	57	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	58	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	59	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	60	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	61	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"blue"	,	62	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	63	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	64	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	65	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	66	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	67	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	68	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	69	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	70	,	1	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	71	,	0	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	72	,	0	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	73	,	0	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	74	,	0	,	false,	false)	);


        //Tile C
        MapElement tile2 = new Tile();
        tile2.setNextTilePos(6);
        tile2.setRotation(0);

        tile2	.addRow1(	new Space(	"green"	,	75	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"green"	,	76	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"grey"	,	77	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"grey"	,	78	,	1	,	false,	true));
        tile2	.addRow2(	new Space(	"green"	,	79	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"yellow"	,	80	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"grey"	,	81	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	82	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	83	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	84	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	85	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"yellow"	,	86	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"yellow"	,	87	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"grey"	,	88	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	89	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"blue"	,	90	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"yellow"	,	91	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"yellow"	,	92	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"black"	,	93	,	0	,	false,	false));
        tile2	.addRow4(	new Space(	"blue"	,	94	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"grey"	,	95	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"grey"	,	96	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	97	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"grey"	,	98	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"blue"	,	99	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"blue"	,	100	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	101	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	102	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	103	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"grey"	,	104	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	105	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	106	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"blue"	,	107	,	1	,	false,	false));
        tile2	.addRow7(	new Space(	"yellow"	,	108	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"yellow"	,	109	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"blue"	,	110	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"blue"	,	111	,	1	,	true,	false));


        //Tile G
        MapElement tile3 = new Tile();
        tile3.setRotation(120);
        tile3.setNextTilePos(2);

        tile3	.addRow1(	new Space(	"green"	,	223	,	1	,	true,	false));
        tile3	.addRow1(	new Space(	"green"	,	224	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"green"	,	225	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"green"	,	226	,	1	,	false,	true));
        tile3	.addRow2(	new Space(	"green"	,	227	,	1	,	true,	false));
        tile3	.addRow2(	new Space(	"green"	,	228	,	2	,	false,	false));
        tile3	.addRow2(	new Space(	"yellow"	,	229	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"black"	,	230	,	0	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	231	,	1	,	false,	true));
        tile3	.addRow3(	new Space(	"yellow"	,	232	,	1	,	true,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	233	,	2	,	false,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	234	,	2	,	false,	false));
        tile3	.addRow3(	new Space(	"grey"	,	235	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	236	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"green"	,	237	,	1	,	false,	true));
        tile3	.addRow4(	new Space(	"black"	,	238	,	0	,	true,	false));
        tile3	.addRow4(	new Space(	"black"	,	239	,	0	,	false,	false));
        tile3	.addRow4(	new Space(	"yellow"	,	240	,	4	,	false,	false));
        tile3	.addRow4(	new Space(	"yellow"	,	241	,	3	,	false,	false));
        tile3	.addRow4(	new Space(	"yellow"	,	242	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	243	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"red"	,	244	,	1	,	false,	true));
        tile3	.addRow5(	new Space(	"yellow"	,	245	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"yellow"	,	246	,	2	,	false,	false));
        tile3	.addRow5(	new Space(	"yellow"	,	247	,	2	,	false,	false));
        tile3	.addRow5(	new Space(	"grey"	,	248	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"yellow"	,	249	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"green"	,	250	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	251	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	252	,	2	,	false,	false));
        tile3	.addRow6(	new Space(	"yellow"	,	253	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"black"	,	254	,	0	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	255	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	256	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	257	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	258	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	259	,	1	,	false,	false));


        //Tile K
        MapElement tile4 = new Tile();
        tile4.setNextTilePos(2);
        tile4.setRotation(300);

        tile4	.addRow1(	new Space(	"red"	,	371	,	1	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	372	,	2	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	373	,	2	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	374	,	1	,	false,	true));
        tile4	.addRow2(	new Space(	"green"	,	375	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	376	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"blue"	,	377	,	3	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	378	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	379	,	2	,	false,	true));
        tile4	.addRow3(	new Space(	"green"	,	380	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	381	,	2	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	382	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	383	,	3	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	384	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	385	,	2	,	false,	true));
        tile4	.addRow4(	new Space(	"green"	,	386	,	2	,	true,	false));
        tile4	.addRow4(	new Space(	"green"	,	387	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	388	,	3	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	389	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	390	,	3	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	391	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	392	,	2	,	false,	true));
        tile4	.addRow5(	new Space(	"green"	,	393	,	2	,	true,	false));
        tile4	.addRow5(	new Space(	"green"	,	394	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	395	,	3	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	396	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	397	,	2	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	398	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	399	,	2	,	true,	false));
        tile4	.addRow6(	new Space(	"green"	,	400	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"yellow",	401	,	4	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	402	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	403	,	1	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	404	,	1	,	true,	false));
        tile4	.addRow7(	new Space(	"green"	,	405	,	2	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	406	,	2	,	false,	false));
        tile4	.addRow7(	new Space(	"red"	,	407	,	1	,	false,	false));


        //Tile J
        MapElement tile5 = new Tile();
        tile5.setRotation(300);
        tile5.setNextTilePos(1);


        tile5	.addRow1(	new Space(	"blue"	,	334	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	335	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	336	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	337	,	1	,	false,	true));
        tile5	.addRow2(	new Space(	"blue"	,	338	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"black"	,	339	,	0	,	false,	false));
        tile5	.addRow2(	new Space(	"blue"	,	340	,	2	,	false,	false));
        tile5	.addRow2(	new Space(	"blue"	,	341	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"grey"	,	342	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"blue"	,	343	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"blue"	,	344	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	345	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	346	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"grey"	,	347	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"grey"	,	348	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"yellow"	,	349	,	1	,	true,	false));
        tile5	.addRow4(	new Space(	"yellow"	,	350	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	351	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"red"	,	352	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	353	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"grey"	,	354	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"grey"	,	355	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"yellow"	,	356	,	1	,	true,	false));
        tile5	.addRow5(	new Space(	"yellow"	,	357	,	2	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	358	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	359	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	360	,	2	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	361	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	362	,	1	,	true,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	363	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	364	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"black"	,	365	,	0	,	false,	false));
        tile5	.addRow6(	new Space(	"grey"	,	366	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	367	,	1	,	true,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	368	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	369	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"grey"	,	370	,	2	,	false,	false));


        //Tile N
        MapElement tile6 = new Tile();
        tile6.setNextTilePos(2);
        tile6.setRotation(120);


        tile6	.addRow1(	new Space(	"green"	,	482	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	483	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	484	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	485	,	1	,	true,	false));
        tile6	.addRow2(	new Space(	"yellow"	,	486	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	487	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	488	,	2	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	489	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"blue"	,	490	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	491	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	492	,	2	,	false,	false));
        tile6	.addRow3(	new Space(	"green"	,	493	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	494	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	495	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	496	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"blue"	,	497	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"blue"	,	498	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	499	,	3	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	500	,	4	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	501	,	3	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	502	,	2	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	503	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	504	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	505	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	506	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"green"	,	507	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	508	,	2	,	false,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	509	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	510	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	511	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	512	,	2	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	513	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	514	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	515	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	516	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	517	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	518	,	1	,	false,	false));


        //Tile U
        MapElement tile7 = new EndTile();
        tile7.setRotation(270);

        tile7	.addRow1(	new Space(	"blue"	,	574	,	1	,	false,	false));
        tile7	.addRow1(	new Space(	"blue"	,	575	,	1	,	false,	false));
        tile7	.addRow1(	new Space(	"blue"	,	576	,	1	,	false,	false));


        //SetNeighbours
        tile1.setNeighbours();
        tile2.setNeighbours();
        tile3.setNeighbours();
        tile4.setNeighbours();
        tile5.setNeighbours();
        tile6.setNeighbours();
        tile7.setNeighbours();

        //Set neighbouring tiles
        tile1.getRow1().get(0).getNeighbours()[4] = tile2.getRow7().get(3).getId();
        tile1.getRow2().get(0).getNeighbours()[4] = tile2.getRow7().get(2).getId();
        tile1.getRow2().get(0).getNeighbours()[5] = tile2.getRow7().get(3).getId();
        tile1.getRow3().get(0).getNeighbours()[4] = tile2.getRow7().get(1).getId();
        tile1.getRow3().get(0).getNeighbours()[5] = tile2.getRow7().get(2).getId();
        tile1.getRow4().get(0).getNeighbours()[4] = tile2.getRow7().get(0).getId();
        tile1.getRow4().get(0).getNeighbours()[5] = tile2.getRow7().get(1).getId();

        tile2.getRow7().get(0).getNeighbours()[2] = tile1.getRow4().get(0).getId();
        tile2.getRow7().get(1).getNeighbours()[3] = tile1.getRow4().get(0).getId();
        tile2.getRow7().get(1).getNeighbours()[2] = tile1.getRow3().get(0).getId();
        tile2.getRow7().get(2).getNeighbours()[3] = tile1.getRow3().get(0).getId();
        tile2.getRow7().get(2).getNeighbours()[2] = tile1.getRow2().get(0).getId();
        tile2.getRow7().get(3).getNeighbours()[3] = tile1.getRow2().get(0).getId();
        tile2.getRow7().get(3).getNeighbours()[2] = tile1.getRow1().get(0).getId();

        tile2.getRow1().get(0).getNeighbours()[0] = tile3.getRow1().get(0).getId();
        tile2.getRow1().get(1).getNeighbours()[5] = tile3.getRow1().get(0).getId();
        tile2.getRow1().get(1).getNeighbours()[0] = tile3.getRow2().get(0).getId();
        tile2.getRow1().get(2).getNeighbours()[5] = tile3.getRow1().get(0).getId();
        tile2.getRow1().get(2).getNeighbours()[0] = tile3.getRow3().get(0).getId();
        tile2.getRow1().get(3).getNeighbours()[5] = tile3.getRow3().get(0).getId();
        tile2.getRow1().get(3).getNeighbours()[0] = tile3.getRow4().get(0).getId();

        tile3.getRow1().get(0).getNeighbours()[5] = tile2.getRow1().get(0).getId();
        tile3.getRow1().get(0).getNeighbours()[4] = tile2.getRow1().get(1).getId();
        tile3.getRow2().get(0).getNeighbours()[5] = tile2.getRow1().get(1).getId();
        tile3.getRow2().get(0).getNeighbours()[4] = tile2.getRow1().get(2).getId();
        tile3.getRow3().get(0).getNeighbours()[5] = tile2.getRow1().get(2).getId();
        tile3.getRow3().get(0).getNeighbours()[4] = tile2.getRow1().get(3).getId();
        tile3.getRow4().get(0).getNeighbours()[5] = tile2.getRow1().get(3).getId();

        tile3.getRow4().get(0).getNeighbours()[3] = tile4.getRow7().get(0).getId();
        tile3.getRow5().get(0).getNeighbours()[4] = tile4.getRow7().get(0).getId();
        tile3.getRow5().get(0).getNeighbours()[3] = tile4.getRow6().get(0).getId();
        tile3.getRow6().get(0).getNeighbours()[4] = tile4.getRow6().get(0).getId();
        tile3.getRow6().get(0).getNeighbours()[3] = tile4.getRow5().get(0).getId();
        tile3.getRow7().get(0).getNeighbours()[4] = tile4.getRow5().get(0).getId();
        tile3.getRow7().get(0).getNeighbours()[3] = tile4.getRow4().get(0).getId();

        tile4.getRow4().get(0).getNeighbours()[3] = tile3.getRow7().get(0).getId();
        tile4.getRow5().get(0).getNeighbours()[4] = tile3.getRow7().get(0).getId();
        tile4.getRow5().get(0).getNeighbours()[3] = tile3.getRow6().get(0).getId();
        tile4.getRow6().get(0).getNeighbours()[4] = tile3.getRow6().get(0).getId();
        tile4.getRow6().get(0).getNeighbours()[3] = tile3.getRow5().get(0).getId();
        tile4.getRow7().get(0).getNeighbours()[4] = tile3.getRow5().get(0).getId();
        tile4.getRow7().get(0).getNeighbours()[3] = tile3.getRow4().get(0).getId();

        tile4.getRow1().get(3).getNeighbours()[1] = tile5.getRow4().get(0).getId();
        tile4.getRow2().get(4).getNeighbours()[0] = tile5.getRow4().get(0).getId();
        tile4.getRow2().get(4).getNeighbours()[1] = tile5.getRow5().get(0).getId();
        tile4.getRow3().get(5).getNeighbours()[0] = tile5.getRow5().get(0).getId();
        tile4.getRow3().get(5).getNeighbours()[1] = tile5.getRow6().get(0).getId();
        tile4.getRow4().get(6).getNeighbours()[0] = tile5.getRow6().get(0).getId();

        tile5.getRow4().get(0).getNeighbours()[4] = tile4.getRow1().get(3).getId();
        tile5.getRow4().get(0).getNeighbours()[3] = tile4.getRow2().get(4).getId();
        tile5.getRow5().get(0).getNeighbours()[4] = tile4.getRow2().get(4).getId();
        tile5.getRow5().get(0).getNeighbours()[3] = tile4.getRow3().get(5).getId();
        tile5.getRow6().get(0).getNeighbours()[4] = tile4.getRow3().get(5).getId();
        tile5.getRow6().get(0).getNeighbours()[3] = tile4.getRow4().get(6).getId();
        tile5.getRow7().get(0).getNeighbours()[4] = tile4.getRow4().get(6).getId();

        tile5.getRow1().get(0).getNeighbours()[0] = tile6.getRow1().get(3).getId();
        tile5.getRow1().get(1).getNeighbours()[5] = tile6.getRow1().get(3).getId();
        tile5.getRow1().get(1).getNeighbours()[0] = tile6.getRow1().get(2).getId();
        tile5.getRow1().get(2).getNeighbours()[5] = tile6.getRow1().get(2).getId();
        tile5.getRow1().get(2).getNeighbours()[0] = tile6.getRow1().get(1).getId();
        tile5.getRow1().get(3).getNeighbours()[5] = tile6.getRow1().get(1).getId();
        tile5.getRow1().get(3).getNeighbours()[0] = tile6.getRow1().get(0).getId();

        tile6.getRow1().get(0).getNeighbours()[0] = tile5.getRow1().get(3).getId();
        tile6.getRow1().get(1).getNeighbours()[5] = tile5.getRow1().get(3).getId();
        tile6.getRow1().get(1).getNeighbours()[0] = tile5.getRow1().get(2).getId();
        tile6.getRow1().get(2).getNeighbours()[5] = tile5.getRow1().get(2).getId();
        tile6.getRow1().get(2).getNeighbours()[0] = tile5.getRow1().get(1).getId();
        tile6.getRow1().get(3).getNeighbours()[5] = tile5.getRow1().get(1).getId();
        tile6.getRow1().get(3).getNeighbours()[0] = tile5.getRow1().get(0).getId();

        tile6.getRow6().get(0).getNeighbours()[3] = tile7.getRow1().get(2).getId();
        tile6.getRow7().get(0).getNeighbours()[4] = tile7.getRow1().get(2).getId();
        tile6.getRow7().get(0).getNeighbours()[3] = tile7.getRow1().get(1).getId();
        tile6.getRow7().get(0).getNeighbours()[2] = tile7.getRow1().get(0).getId();
        tile6.getRow7().get(1).getNeighbours()[3] = tile7.getRow1().get(0).getId();

        tile7.getRow1().get(0).getNeighbours()[3] = tile6.getRow7().get(1).getId();
        tile7.getRow1().get(0).getNeighbours()[2] = tile6.getRow7().get(0).getId();
        tile7.getRow1().get(1).getNeighbours()[3] = tile6.getRow7().get(0).getId();
        tile7.getRow1().get(2).getNeighbours()[3] = tile6.getRow7().get(0).getId();
        tile7.getRow1().get(2).getNeighbours()[2] = tile6.getRow6().get(0).getId();

        //EndTile
        endTile = new long[3];
        endTile[0]= tile7.getRow1().get(0).getId();
        endTile[1]= tile7.getRow1().get(1).getId();
        endTile[2]= tile7.getRow1().get(2).getId();

        //StartPosition
        startSpaces = new long[4];
        startSpaces[0] = tile1.getRow7().get(3).getId();
        startSpaces[1] = tile1.getRow7().get(2).getId();
        startSpaces[2] = tile1.getRow7().get(1).getId();
        startSpaces[3] = tile1.getRow7().get(0).getId();


        //Initializing Blockades
        blockades.add(new Blockade("green", 1, 1));
        blockades.add(new Blockade("yellow", 1, 2));
        blockades.add(new Blockade("grey", 1, 3));
        blockades.add(new Blockade("blue", 1, 4));
        blockades.add(new Blockade("green", 2, 5));
        blockades.add(new Blockade("grey", 2, 6));

        //Filling element of the map in the ArrayList
        mapTiles.add(tile1);
        mapTiles.add(getBlockade());
        mapTiles.add(tile2);
        mapTiles.add(getBlockade());
        mapTiles.add(tile3);
        mapTiles.add(getBlockade());
        mapTiles.add(tile4);
        mapTiles.add(getBlockade());
        mapTiles.add(tile5);
        mapTiles.add(getBlockade());
        mapTiles.add(tile6);
        mapTiles.add(tile7);


    }

    private void setup(){

        //Tile B
        MapElement tile1 = new Tile();
        tile1.setRotation(300);
        tile1.setNextTilePos(6);

        tile1	.addRow1(	new Space(	"green"	,	38	,	1	,	false,	true)	);
        tile1	.addRow1(	new Space(	"blue"	,	39	,	1	,	false,	false)	);
        tile1	.addRow1(	new Space(	"red"	,	40	,	1	,	false,	false)	);
        tile1	.addRow1(	new Space(	"blue"	,	41	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	42	,	1	,	false,	true)	);
        tile1	.addRow2(	new Space(	"green"	,	43	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"yellow"	,	44	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"black"	,	45	,	0	,	false,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	46	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	47	,	1	,	false,	true)	);
        tile1	.addRow3(	new Space(	"yellow"	,	48	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	49	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	50	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	51	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	52	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"blue"	,	53	,	1	,	false,	true)	);
        tile1	.addRow4(	new Space(	"green"	,	54	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"yellow",	55	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	56	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"yellow",	57	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	58	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"green"	,	59	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	60	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	61	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"blue"	,	62	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	63	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	64	,	1	,	false,	false)	);
        tile1	.addRow5(	new Space(	"green"	,	65	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	66	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	67	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	68	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	69	,	1	,	false,	false)	);
        tile1	.addRow6(	new Space(	"green"	,	70	,	1	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	71	,	0	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	72	,	0	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	73	,	0	,	false,	false)	);
        tile1	.addRow7(	new Space(	"green"	,	74	,	0	,	false,	false)	);


        //Tile C
        MapElement tile2 = new Tile();
        tile2.setNextTilePos(6);
        tile2.setRotation(0);

        tile2	.addRow1(	new Space(	"green"	,	75	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"green"	,	76	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"grey"	,	77	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"grey"	,	78	,	1	,	false,	true));
        tile2	.addRow2(	new Space(	"green"	,	79	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"yellow"	,	80	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"grey"	,	81	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	82	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	83	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	84	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	85	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"yellow"	,	86	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"yellow"	,	87	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"grey"	,	88	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	89	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"blue"	,	90	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"yellow"	,	91	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"yellow"	,	92	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"black"	,	93	,	0	,	false,	false));
        tile2	.addRow4(	new Space(	"blue"	,	94	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"grey"	,	95	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"grey"	,	96	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	97	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"grey"	,	98	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"blue"	,	99	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"blue"	,	100	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	101	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	102	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	103	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"grey"	,	104	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	105	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	106	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"blue"	,	107	,	1	,	false,	false));
        tile2	.addRow7(	new Space(	"yellow"	,	108	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"yellow"	,	109	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"blue"	,	110	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"blue"	,	111	,	1	,	true,	false));


        //Tile G
        MapElement tile3 = new Tile();
        tile3.setRotation(120);
        tile3.setNextTilePos(2);

        tile3	.addRow1(	new Space(	"green"	,	223	,	1	,	true,	false));
        tile3	.addRow1(	new Space(	"green"	,	224	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"green"	,	225	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"green"	,	226	,	1	,	false,	true));
        tile3	.addRow2(	new Space(	"green"	,	227	,	1	,	true,	false));
        tile3	.addRow2(	new Space(	"green"	,	228	,	2	,	false,	false));
        tile3	.addRow2(	new Space(	"yellow"	,	229	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"black"	,	230	,	0	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	231	,	1	,	false,	true));
        tile3	.addRow3(	new Space(	"yellow"	,	232	,	1	,	true,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	233	,	2	,	false,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	234	,	2	,	false,	false));
        tile3	.addRow3(	new Space(	"grey"	,	235	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	236	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"green"	,	237	,	1	,	false,	true));
        tile3	.addRow4(	new Space(	"black"	,	238	,	0	,	true,	false));
        tile3	.addRow4(	new Space(	"black"	,	239	,	0	,	false,	false));
        tile3	.addRow4(	new Space(	"yellow"	,	240	,	4	,	false,	false));
        tile3	.addRow4(	new Space(	"yellow"	,	241	,	3	,	false,	false));
        tile3	.addRow4(	new Space(	"yellow"	,	242	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	243	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"red"	,	244	,	1	,	false,	true));
        tile3	.addRow5(	new Space(	"yellow"	,	245	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"yellow"	,	246	,	2	,	false,	false));
        tile3	.addRow5(	new Space(	"yellow"	,	247	,	2	,	false,	false));
        tile3	.addRow5(	new Space(	"grey"	,	248	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"yellow"	,	249	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"green"	,	250	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	251	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	252	,	2	,	false,	false));
        tile3	.addRow6(	new Space(	"yellow"	,	253	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"black"	,	254	,	0	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	255	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	256	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	257	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	258	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	259	,	1	,	false,	false));


        //Tile K
        MapElement tile4 = new Tile();
        tile4.setNextTilePos(2);
        tile4.setRotation(300);

        tile4	.addRow1(	new Space(	"red"	,	371	,	1	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	372	,	2	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	373	,	2	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	374	,	1	,	false,	true));
        tile4	.addRow2(	new Space(	"green"	,	375	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	376	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"blue"	,	377	,	3	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	378	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	379	,	2	,	false,	true));
        tile4	.addRow3(	new Space(	"green"	,	380	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	381	,	2	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	382	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	383	,	3	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	384	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	385	,	2	,	false,	true));
        tile4	.addRow4(	new Space(	"green"	,	386	,	2	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	387	,	1	,	true,	false));
        tile4	.addRow4(	new Space(	"green"	,	388	,	3	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	389	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	390	,	3	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	391	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	392	,	2	,	false,	true));
        tile4	.addRow5(	new Space(	"green"	,	393	,	2	,	true,	false));
        tile4	.addRow5(	new Space(	"green"	,	394	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	395	,	3	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	396	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	397	,	2	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	398	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	399	,	2	,	true,	false));
        tile4	.addRow6(	new Space(	"green"	,	400	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"yellow",	401	,	4	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	402	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	403	,	1	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	404	,	1	,	true,	false));
        tile4	.addRow7(	new Space(	"green"	,	405	,	2	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	406	,	2	,	false,	false));
        tile4	.addRow7(	new Space(	"red"	,	407	,	1	,	false,	false));


        //Tile J
        MapElement tile5 = new Tile();
        tile5.setRotation(300);
        tile5.setNextTilePos(1);


        tile5	.addRow1(	new Space(	"blue"	,	334	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	335	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	336	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	337	,	1	,	false,	true));
        tile5	.addRow2(	new Space(	"blue"	,	338	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"black"	,	339	,	0	,	false,	false));
        tile5	.addRow2(	new Space(	"blue"	,	340	,	2	,	false,	false));
        tile5	.addRow2(	new Space(	"blue"	,	341	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"grey"	,	342	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"blue"	,	343	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"blue"	,	344	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	345	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	346	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"grey"	,	347	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"grey"	,	348	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"yellow"	,	349	,	1	,	true,	false));
        tile5	.addRow4(	new Space(	"yellow"	,	350	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	351	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"red"	,	352	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	353	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"grey"	,	354	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"grey"	,	355	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"yellow"	,	356	,	1	,	true,	false));
        tile5	.addRow5(	new Space(	"yellow"	,	357	,	2	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	358	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	359	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	360	,	2	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	361	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	362	,	1	,	true,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	363	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	364	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"black"	,	365	,	0	,	false,	false));
        tile5	.addRow6(	new Space(	"grey"	,	366	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	367	,	1	,	true,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	368	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	369	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"grey"	,	370	,	2	,	false,	false));


        //Tile N
        MapElement tile6 = new Tile();
        tile6.setNextTilePos(2);
        tile6.setRotation(120);


        tile6	.addRow1(	new Space(	"green"	,	482	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	483	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	484	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	485	,	1	,	true,	false));
        tile6	.addRow2(	new Space(	"yellow"	,	486	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	487	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	488	,	2	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	489	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"blue"	,	490	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	491	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	492	,	2	,	false,	false));
        tile6	.addRow3(	new Space(	"green"	,	493	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	494	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	495	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	496	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"blue"	,	497	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"blue"	,	498	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	499	,	3	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	500	,	4	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	501	,	3	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	502	,	2	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	503	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	504	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	505	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	506	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"green"	,	507	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	508	,	2	,	false,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	509	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	510	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	511	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	512	,	2	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	513	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	514	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	515	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	516	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	517	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	518	,	1	,	false,	false));


        //Tile U
        MapElement tile7 = new EndTile();
        tile7.setRotation(270);

        tile7	.addRow1(	new Space(	"blue"	,	574	,	1	,	false,	false));
        tile7	.addRow1(	new Space(	"blue"	,	575	,	1	,	false,	false));
        tile7	.addRow1(	new Space(	"blue"	,	576	,	1	,	false,	false));


        //SetNeighbours
        tile1.setNeighbours();
        tile2.setNeighbours();
        tile3.setNeighbours();
        tile4.setNeighbours();
        tile5.setNeighbours();
        tile6.setNeighbours();
        tile7.setNeighbours();

        //Set neighbouring tiles
        tile1.getRow1().get(0).getNeighbours()[4] = tile2.getRow7().get(3).getId();
        tile1.getRow2().get(0).getNeighbours()[4] = tile2.getRow7().get(2).getId();
        tile1.getRow2().get(0).getNeighbours()[5] = tile2.getRow7().get(3).getId();
        tile1.getRow3().get(0).getNeighbours()[4] = tile2.getRow7().get(1).getId();
        tile1.getRow3().get(0).getNeighbours()[5] = tile2.getRow7().get(2).getId();
        tile1.getRow4().get(0).getNeighbours()[4] = tile2.getRow7().get(0).getId();
        tile1.getRow4().get(0).getNeighbours()[5] = tile2.getRow7().get(1).getId();

        tile2.getRow7().get(0).getNeighbours()[2] = tile1.getRow4().get(0).getId();
        tile2.getRow7().get(1).getNeighbours()[3] = tile1.getRow4().get(0).getId();
        tile2.getRow7().get(1).getNeighbours()[2] = tile1.getRow3().get(0).getId();
        tile2.getRow7().get(2).getNeighbours()[3] = tile1.getRow3().get(0).getId();
        tile2.getRow7().get(2).getNeighbours()[2] = tile1.getRow2().get(0).getId();
        tile2.getRow7().get(3).getNeighbours()[3] = tile1.getRow2().get(0).getId();
        tile2.getRow7().get(3).getNeighbours()[2] = tile1.getRow1().get(0).getId();

        tile2.getRow1().get(0).getNeighbours()[0] = tile3.getRow1().get(0).getId();
        tile2.getRow1().get(1).getNeighbours()[5] = tile3.getRow1().get(0).getId();
        tile2.getRow1().get(1).getNeighbours()[0] = tile3.getRow2().get(0).getId();
        tile2.getRow1().get(2).getNeighbours()[5] = tile3.getRow1().get(0).getId();
        tile2.getRow1().get(2).getNeighbours()[0] = tile3.getRow3().get(0).getId();
        tile2.getRow1().get(3).getNeighbours()[5] = tile3.getRow3().get(0).getId();
        tile2.getRow1().get(3).getNeighbours()[0] = tile3.getRow4().get(0).getId();

        tile3.getRow1().get(0).getNeighbours()[5] = tile2.getRow1().get(0).getId();
        tile3.getRow1().get(0).getNeighbours()[4] = tile2.getRow1().get(1).getId();
        tile3.getRow2().get(0).getNeighbours()[5] = tile2.getRow1().get(1).getId();
        tile3.getRow2().get(0).getNeighbours()[4] = tile2.getRow1().get(2).getId();
        tile3.getRow3().get(0).getNeighbours()[5] = tile2.getRow1().get(2).getId();
        tile3.getRow3().get(0).getNeighbours()[4] = tile2.getRow1().get(3).getId();
        tile3.getRow4().get(0).getNeighbours()[5] = tile2.getRow1().get(3).getId();

        tile3.getRow4().get(0).getNeighbours()[3] = tile4.getRow7().get(0).getId();
        tile3.getRow5().get(0).getNeighbours()[4] = tile4.getRow7().get(0).getId();
        tile3.getRow5().get(0).getNeighbours()[3] = tile4.getRow6().get(0).getId();
        tile3.getRow6().get(0).getNeighbours()[4] = tile4.getRow6().get(0).getId();
        tile3.getRow6().get(0).getNeighbours()[3] = tile4.getRow5().get(0).getId();
        tile3.getRow7().get(0).getNeighbours()[4] = tile4.getRow5().get(0).getId();
        tile3.getRow7().get(0).getNeighbours()[3] = tile4.getRow4().get(0).getId();

        tile4.getRow4().get(0).getNeighbours()[3] = tile3.getRow7().get(0).getId();
        tile4.getRow5().get(0).getNeighbours()[4] = tile3.getRow7().get(0).getId();
        tile4.getRow5().get(0).getNeighbours()[3] = tile3.getRow6().get(0).getId();
        tile4.getRow6().get(0).getNeighbours()[4] = tile3.getRow6().get(0).getId();
        tile4.getRow6().get(0).getNeighbours()[3] = tile3.getRow5().get(0).getId();
        tile4.getRow7().get(0).getNeighbours()[4] = tile3.getRow5().get(0).getId();
        tile4.getRow7().get(0).getNeighbours()[3] = tile3.getRow4().get(0).getId();

        tile4.getRow1().get(3).getNeighbours()[1] = tile5.getRow4().get(0).getId();
        tile4.getRow2().get(4).getNeighbours()[0] = tile5.getRow4().get(0).getId();
        tile4.getRow2().get(4).getNeighbours()[1] = tile5.getRow5().get(0).getId();
        tile4.getRow3().get(5).getNeighbours()[0] = tile5.getRow5().get(0).getId();
        tile4.getRow3().get(5).getNeighbours()[1] = tile5.getRow6().get(0).getId();
        tile4.getRow4().get(6).getNeighbours()[0] = tile5.getRow6().get(0).getId();

        tile5.getRow4().get(0).getNeighbours()[4] = tile4.getRow1().get(3).getId();
        tile5.getRow4().get(0).getNeighbours()[3] = tile4.getRow2().get(4).getId();
        tile5.getRow5().get(0).getNeighbours()[4] = tile4.getRow2().get(4).getId();
        tile5.getRow5().get(0).getNeighbours()[3] = tile4.getRow3().get(5).getId();
        tile5.getRow6().get(0).getNeighbours()[4] = tile4.getRow3().get(5).getId();
        tile5.getRow6().get(0).getNeighbours()[3] = tile4.getRow4().get(6).getId();
        tile5.getRow7().get(0).getNeighbours()[4] = tile4.getRow4().get(6).getId();

        tile5.getRow1().get(0).getNeighbours()[0] = tile6.getRow1().get(3).getId();
        tile5.getRow1().get(1).getNeighbours()[5] = tile6.getRow1().get(3).getId();
        tile5.getRow1().get(1).getNeighbours()[0] = tile6.getRow1().get(2).getId();
        tile5.getRow1().get(2).getNeighbours()[5] = tile6.getRow1().get(2).getId();
        tile5.getRow1().get(2).getNeighbours()[0] = tile6.getRow1().get(1).getId();
        tile5.getRow1().get(3).getNeighbours()[5] = tile6.getRow1().get(1).getId();
        tile5.getRow1().get(3).getNeighbours()[0] = tile6.getRow1().get(0).getId();

        tile6.getRow1().get(0).getNeighbours()[0] = tile5.getRow1().get(3).getId();
        tile6.getRow1().get(1).getNeighbours()[5] = tile5.getRow1().get(3).getId();
        tile6.getRow1().get(1).getNeighbours()[0] = tile5.getRow1().get(2).getId();
        tile6.getRow1().get(2).getNeighbours()[5] = tile5.getRow1().get(2).getId();
        tile6.getRow1().get(2).getNeighbours()[0] = tile5.getRow1().get(1).getId();
        tile6.getRow1().get(3).getNeighbours()[5] = tile5.getRow1().get(1).getId();
        tile6.getRow1().get(3).getNeighbours()[0] = tile5.getRow1().get(0).getId();

        tile6.getRow6().get(0).getNeighbours()[3] = tile7.getRow1().get(2).getId();
        tile6.getRow7().get(0).getNeighbours()[4] = tile7.getRow1().get(2).getId();
        tile6.getRow7().get(0).getNeighbours()[3] = tile7.getRow1().get(1).getId();
        tile6.getRow7().get(0).getNeighbours()[2] = tile7.getRow1().get(0).getId();
        tile6.getRow7().get(1).getNeighbours()[3] = tile7.getRow1().get(0).getId();

        tile7.getRow1().get(0).getNeighbours()[3] = tile6.getRow7().get(1).getId();
        tile7.getRow1().get(0).getNeighbours()[2] = tile6.getRow7().get(0).getId();
        tile7.getRow1().get(1).getNeighbours()[3] = tile6.getRow7().get(0).getId();
        tile7.getRow1().get(2).getNeighbours()[3] = tile6.getRow7().get(0).getId();
        tile7.getRow1().get(2).getNeighbours()[2] = tile6.getRow6().get(1).getId();

        //EndTile
        endTile = new long[3];
        endTile[0]= tile7.getRow1().get(0).getId();
        endTile[1]= tile7.getRow1().get(1).getId();
        endTile[2]= tile7.getRow1().get(2).getId();

        //StartPosition
        startSpaces = new long[4];
        startSpaces[0] = tile1.getRow7().get(3).getId();
        startSpaces[1] = tile1.getRow7().get(2).getId();
        startSpaces[2] = tile1.getRow7().get(1).getId();
        startSpaces[3] = tile1.getRow7().get(0).getId();


        //Initializing Blockades
        blockades.add(new Blockade("green", 1, 1));
        blockades.add(new Blockade("yellow", 1, 2));
        blockades.add(new Blockade("grey", 1, 3));
        blockades.add(new Blockade("blue", 1, 4));
        blockades.add(new Blockade("green", 2, 5));
        blockades.add(new Blockade("grey", 2, 6));

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
