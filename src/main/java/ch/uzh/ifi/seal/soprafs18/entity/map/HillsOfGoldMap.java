package ch.uzh.ifi.seal.soprafs18.entity.map;

public class HillsOfGoldMap extends Map {

    private long[] endTile;
    private long[] startSpaces;

    public HillsOfGoldMap() {
        setup();
    }

    private void setup(){
        //Tile B
        MapElement tile1 = new Tile();
        tile1.setRotation(300);
        tile1.setNextTilePos(5);
        tile1	.addRow1(	new Space(	"green"	,	29	,	1	,	false,	true)	);
        tile1	.addRow1(	new Space(	"blue"	,	30	,	1	,	false,	true)	);
        tile1	.addRow1(	new Space(	"red"	,	31	,	1	,	false,	true)	);
        tile1	.addRow1(	new Space(	"blue"	,	32	,	1	,	false,	true)	);
        tile1	.addRow2(	new Space(	"green"	,	33	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	34	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"yellow"	,	35	,	1	,	false,	false)	);
        tile1	.addRow2(	new Space(	"black"	,	36	,	0	,	false,	false)	);
        tile1	.addRow2(	new Space(	"green"	,	37	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	38	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"yellow"	,	39	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	40	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	41	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	42	,	1	,	false,	false)	);
        tile1	.addRow3(	new Space(	"green"	,	43	,	1	,	false,	false)	);
        tile1	.addRow4(	new Space(	"blue"	,	44	,	1	,	false,	false)	);
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




        // Tile C
        MapElement tile2 = new Tile();
        tile2.setNextTilePos(6);
        tile2.setRotation(0);

        tile2	.addRow1(	new Space(	"green"	,	66	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"green"	,	67	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"grey"	,	68	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"grey"	,	69	,	1	,	false,	true));
        tile2	.addRow2(	new Space(	"green"	,	70	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"yellow"	,	71	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"grey"	,	72	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	73	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	74	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	75	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	76	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"yellow"	,	77	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"yellow"	,	78	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"grey"	,	79	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	80	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"blue"	,	81	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"yellow"	,	82	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"yellow"	,	83	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"yellow"	,	84	,	0	,	false,	false));
        tile2	.addRow4(	new Space(	"blue"	,	85	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"grey"	,	86	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"grey"	,	87	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	88	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"grey"	,	89	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"blue"	,	90	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"blue"	,	91	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	92	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow"	,	93	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	94	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"grey"	,	95	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	96	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow"	,	97	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"blue"	,	98	,	1	,	false,	false));
        tile2	.addRow7(	new Space(	"yellow"	,	99	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"yellow"	,	100	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"blue"	,	101	,	1	,	true,	false));
        tile2	.addRow7(	new Space(	"blue"	,	102	,	1	,	true,	false));


        //Tile G
        MapElement tile3 = new Tile();
        tile3.setRotation(120);
        tile3.setNextTilePos(4);

        tile3	.addRow1(	new Space(	"green"	,	214	,	1	,	true,	false));
        tile3	.addRow1(	new Space(	"green"	,	215	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"green"	,	216	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"green"	,	217	,	1	,	false,	true));
        tile3	.addRow2(	new Space(	"green"	,	218	,	1	,	true,	false));
        tile3	.addRow2(	new Space(	"green"	,	219	,	2	,	false,	false));
        tile3	.addRow2(	new Space(	"yellow"	,	220	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"black"	,	221	,	0	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	222	,	1	,	false,	true));
        tile3	.addRow3(	new Space(	"yellow"	,	223	,	1	,	true,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	224	,	2	,	false,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	225	,	2	,	false,	false));
        tile3	.addRow3(	new Space(	"grey"	,	226	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	227	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"green"	,	228	,	1	,	false,	true));
        tile3	.addRow4(	new Space(	"black"	,	229	,	0	,	true,	false));
        tile3	.addRow4(	new Space(	"black"	,	230	,	0	,	false,	false));
        tile3	.addRow4(	new Space(	"yellow"	,	231	,	4	,	false,	false));
        tile3	.addRow4(	new Space(	"yellow"	,	232	,	3	,	false,	false));
        tile3	.addRow4(	new Space(	"yellow"	,	233	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	234	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"red"	,	235	,	1	,	false,	true));
        tile3	.addRow5(	new Space(	"yellow"	,	236	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"yellow"	,	237	,	2	,	false,	false));
        tile3	.addRow5(	new Space(	"yellow"	,	238	,	2	,	false,	false));
        tile3	.addRow5(	new Space(	"grey"	,	239	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"yellow"	,	240	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"green"	,	241	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	242	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	243	,	2	,	false,	false));
        tile3	.addRow6(	new Space(	"yellow"	,	244	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"black"	,	245	,	0	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	246	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	247	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	248	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	249	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	250	,	1	,	false,	false));


        //Tile K
        MapElement tile4 = new Tile();
        tile4.setNextTilePos(1);
        tile4.setRotation(300);

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



        // Tile J
        MapElement tile5 = new Tile();
        tile5.setRotation(300);
        tile5.setNextTilePos(6);

        tile5	.addRow1(	new Space(	"blue"	,	325	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	326	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	327	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	328	,	1	,	false,	true));
        tile5	.addRow2(	new Space(	"blue"	,	329	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"black"	,	330	,	0	,	false,	false));
        tile5	.addRow2(	new Space(	"blue"	,	331	,	2	,	false,	false));
        tile5	.addRow2(	new Space(	"blue"	,	332	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"grey"	,	333	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"blue"	,	334	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"blue"	,	335	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	336	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	337	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"grey"	,	338	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"grey"	,	339	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"yellow"	,	340	,	1	,	true,	false));
        tile5	.addRow4(	new Space(	"yellow"	,	341	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	342	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"red"	,	343	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	344	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"grey"	,	345	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"grey"	,	346	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"yellow"	,	347	,	1	,	true,	false));
        tile5	.addRow5(	new Space(	"yellow"	,	348	,	2	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	349	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	350	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	351	,	2	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	352	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	353	,	1	,	true,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	354	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	355	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"black"	,	356	,	0	,	false,	false));
        tile5	.addRow6(	new Space(	"grey"	,	357	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	358	,	1	,	true,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	359	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	360	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"grey"	,	361	,	2	,	false,	false));


        // Tile N
        MapElement tile6 = new Tile();
        tile6.setNextTilePos(4);
        tile6.setRotation(120);

        tile6	.addRow1(	new Space(	"green"	,	473	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	474	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	475	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	476	,	1	,	true,	false));
        tile6	.addRow2(	new Space(	"yellow"	,	477	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	478	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	479	,	2	,	false,	false));
        tile6	.addRow2(	new Space(	"green"	,	480	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"blue"	,	481	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	482	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	483	,	2	,	false,	false));
        tile6	.addRow3(	new Space(	"green"	,	484	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	485	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	486	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	487	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"blue"	,	488	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"blue"	,	489	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	490	,	3	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	491	,	4	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	492	,	3	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	493	,	2	,	false,	false));
        tile6	.addRow4(	new Space(	"yellow"	,	494	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	495	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	496	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"blue"	,	497	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"green"	,	498	,	1	,	false,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	499	,	2	,	false,	false));
        tile6	.addRow5(	new Space(	"yellow"	,	500	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	501	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	502	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	503	,	2	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	504	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	505	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	506	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	507	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	508	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	509	,	1	,	false,	false));



        // Tile U
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
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile4);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile5);
        mapTiles.add(getRandomBlockade());
        mapTiles.add(tile6);
        mapTiles.add(tile7);

        // Set tile neighbours

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
