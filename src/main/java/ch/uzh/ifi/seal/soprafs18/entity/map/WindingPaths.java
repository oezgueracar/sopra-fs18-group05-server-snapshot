package ch.uzh.ifi.seal.soprafs18.entity.map;

public class WindingPaths extends Map {

    private long[] endTile;
    private long[] startSpaces;

    public WindingPaths(){
        setup();
    }

        private void setup(){

        // TileB
        MapElement tile1 = new Tile();
        tile1.setRotation(270);
        tile1.setNextTilePos(5);

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
            tile1	.addRow4(	new Space(	"yellow"	,	55	,	1	,	false,	false)	);
            tile1	.addRow4(	new Space(	"green"	,	56	,	1	,	false,	false)	);
            tile1	.addRow4(	new Space(	"yellow"	,	57	,	1	,	false,	false)	);
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



            //Tile I
        MapElement tile2 = new Tile();
        tile2.setRotation(150);
        tile2.setNextTilePos(4);

            tile2	.addRow1(	new Space(	"green"	,	297	,	1	,	false,	false));
            tile2	.addRow1(	new Space(	"green"	,	298	,	1	,	false,	false));
            tile2	.addRow1(	new Space(	"green"	,	299	,	1	,	false,	false));
            tile2	.addRow1(	new Space(	"green"	,	300	,	1	,	false,	false));
            tile2	.addRow2(	new Space(	"yellow"	,	301	,	1	,	false,	false));
            tile2	.addRow2(	new Space(	"green"	,	302	,	1	,	false,	false));
            tile2	.addRow2(	new Space(	"black"	,	303	,	0	,	false,	false));
            tile2	.addRow2(	new Space(	"green"	,	304	,	1	,	false,	false));
            tile2	.addRow2(	new Space(	"green"	,	305	,	1	,	false,	false));
            tile2	.addRow3(	new Space(	"yellow"	,	306	,	1	,	false,	false));
            tile2	.addRow3(	new Space(	"yellow"	,	307	,	2	,	false,	false));
            tile2	.addRow3(	new Space(	"green"	,	308	,	1	,	false,	false));
            tile2	.addRow3(	new Space(	"black"	,	309	,	0	,	false,	false));
            tile2	.addRow3(	new Space(	"green"	,	310	,	2	,	false,	false));
            tile2	.addRow3(	new Space(	"green"	,	311	,	1	,	false,	false));
            tile2	.addRow4(	new Space(	"yellow"	,	312	,	1	,	false,	false));
            tile2	.addRow4(	new Space(	"yellow"	,	313	,	2	,	false,	false));
            tile2	.addRow4(	new Space(	"green"	,	314	,	1	,	false,	false));
            tile2	.addRow4(	new Space(	"green"	,	315	,	2	,	false,	false));
            tile2	.addRow4(	new Space(	"red"	,	316	,	3	,	false,	false));
            tile2	.addRow4(	new Space(	"black"	,	317	,	0	,	false,	false));
            tile2	.addRow4(	new Space(	"black"	,	318	,	0	,	false,	false));
            tile2	.addRow5(	new Space(	"yellow"	,	319	,	2	,	false,	false));
            tile2	.addRow5(	new Space(	"grey"	,	320	,	3	,	false,	false));
            tile2	.addRow5(	new Space(	"black"	,	321	,	0	,	false,	false));
            tile2	.addRow5(	new Space(	"black"	,	322	,	0	,	false,	false));
            tile2	.addRow5(	new Space(	"green"	,	323	,	2	,	false,	false));
            tile2	.addRow5(	new Space(	"green"	,	324	,	1	,	false,	false));
            tile2	.addRow6(	new Space(	"blue"	,	325	,	2	,	false,	false));
            tile2	.addRow6(	new Space(	"blue"	,	326	,	1	,	false,	false));
            tile2	.addRow6(	new Space(	"blue"	,	327	,	1	,	false,	false));
            tile2	.addRow6(	new Space(	"green"	,	328	,	1	,	false,	false));
            tile2	.addRow6(	new Space(	"green"	,	329	,	1	,	false,	false));
            tile2	.addRow7(	new Space(	"blue"	,	330	,	2	,	false,	false));
            tile2	.addRow7(	new Space(	"blue"	,	331	,	2	,	false,	false));
            tile2	.addRow7(	new Space(	"blue"	,	332	,	1	,	false,	false));
            tile2	.addRow7(	new Space(	"green"	,	333	,	1	,	false,	false));


            // Tile F
        MapElement tile3 = new Tile();
        tile3.setNextTilePos(5);
        tile3.setRotation(150);

            tile3	.addRow1(	new Space(	"green"	,	186	,	1	,	false,	false));
            tile3	.addRow1(	new Space(	"black"	,	187	,	0	,	false,	false));
            tile3	.addRow1(	new Space(	"black"	,	188	,	0	,	false,	false));
            tile3	.addRow1(	new Space(	"blue"	,	189	,	1	,	false,	false));
            tile3	.addRow2(	new Space(	"green"	,	190	,	2	,	false,	false));
            tile3	.addRow2(	new Space(	"green"	,	191	,	1	,	false,	false));
            tile3	.addRow2(	new Space(	"black"	,	192	,	0	,	false,	false));
            tile3	.addRow2(	new Space(	"blue"	,	193	,	1	,	false,	false));
            tile3	.addRow2(	new Space(	"blue"	,	194	,	1	,	false,	false));
            tile3	.addRow3(	new Space(	"grey"	,	195	,	1	,	false,	false));
            tile3	.addRow3(	new Space(	"green"	,	196	,	1	,	false,	false));
            tile3	.addRow3(	new Space(	"blue"	,	197	,	2	,	false,	false));
            tile3	.addRow3(	new Space(	"blue"	,	198	,	3	,	false,	false));
            tile3	.addRow3(	new Space(	"blue"	,	199	,	1	,	false,	false));
            tile3	.addRow3(	new Space(	"grey"	,	200	,	1	,	false,	false));
            tile3	.addRow4(	new Space(	"grey"	,	201	,	1	,	false,	false));
            tile3	.addRow4(	new Space(	"yellow"	,	202	,	1	,	false,	false));
            tile3	.addRow4(	new Space(	"yellow"	,	203	,	2	,	false,	false));
            tile3	.addRow4(	new Space(	"black"	,	204	,	0	,	false,	false));
            tile3	.addRow4(	new Space(	"green"	,	205	,	2	,	false,	false));
            tile3	.addRow4(	new Space(	"green"	,	206	,	1	,	false,	false));
            tile3	.addRow4(	new Space(	"grey"	,	207	,	1	,	false,	false));
            tile3	.addRow5(	new Space(	"grey"	,	208	,	1	,	false,	false));
            tile3	.addRow5(	new Space(	"yellow"	,	209	,	1	,	false,	false));
            tile3	.addRow5(	new Space(	"grey"	,	210	,	2	,	false,	false));
            tile3	.addRow5(	new Space(	"green"	,	211	,	1	,	false,	false));
            tile3	.addRow5(	new Space(	"green"	,	212	,	1	,	false,	false));
            tile3	.addRow5(	new Space(	"grey"	,	213	,	1	,	false,	false));
            tile3	.addRow6(	new Space(	"green"	,	214	,	1	,	false,	false));
            tile3	.addRow6(	new Space(	"green"	,	215	,	3	,	false,	false));
            tile3	.addRow6(	new Space(	"green"	,	216	,	1	,	false,	false));
            tile3	.addRow6(	new Space(	"blue"	,	217	,	2	,	false,	false));
            tile3	.addRow6(	new Space(	"blue"	,	218	,	2	,	false,	false));
            tile3	.addRow7(	new Space(	"rot"	,	219	,	1	,	false,	false));
            tile3	.addRow7(	new Space(	"green"	,	220	,	2	,	false,	false));
            tile3	.addRow7(	new Space(	"grey"	,	221	,	1	,	false,	false));
            tile3	.addRow7(	new Space(	"rot"	,	222	,	2	,	false,	false));


            // Tile G
        MapElement tile4 = new Tile();
        tile4.setNextTilePos(5);
        tile4.setRotation(270);

            tile4	.addRow1(	new Space(	"green"	,	223	,	1	,	false,	false));
            tile4	.addRow1(	new Space(	"green"	,	224	,	1	,	false,	false));
            tile4	.addRow1(	new Space(	"green"	,	225	,	1	,	false,	false));
            tile4	.addRow1(	new Space(	"green"	,	226	,	1	,	false,	false));
            tile4	.addRow2(	new Space(	"green"	,	227	,	1	,	false,	false));
            tile4	.addRow2(	new Space(	"green"	,	228	,	2	,	false,	false));
            tile4	.addRow2(	new Space(	"yellow"	,	229	,	1	,	false,	false));
            tile4	.addRow2(	new Space(	"black"	,	230	,	0	,	false,	false));
            tile4	.addRow2(	new Space(	"green"	,	231	,	1	,	false,	false));
            tile4	.addRow3(	new Space(	"yellow"	,	232	,	1	,	false,	false));
            tile4	.addRow3(	new Space(	"yellow"	,	233	,	2	,	false,	false));
            tile4	.addRow3(	new Space(	"yellow"	,	234	,	2	,	false,	false));
            tile4	.addRow3(	new Space(	"grey"	,	235	,	1	,	false,	false));
            tile4	.addRow3(	new Space(	"yellow"	,	236	,	1	,	false,	false));
            tile4	.addRow3(	new Space(	"green"	,	237	,	1	,	false,	false));
            tile4	.addRow4(	new Space(	"black"	,	238	,	0	,	false,	false));
            tile4	.addRow4(	new Space(	"black"	,	239	,	0	,	false,	false));
            tile4	.addRow4(	new Space(	"yellow"	,	240	,	4	,	false,	false));
            tile4	.addRow4(	new Space(	"yellow"	,	241	,	3	,	false,	false));
            tile4	.addRow4(	new Space(	"yellow"	,	242	,	2	,	false,	false));
            tile4	.addRow4(	new Space(	"green"	,	243	,	2	,	false,	false));
            tile4	.addRow4(	new Space(	"red"	,	244	,	1	,	false,	false));
            tile4	.addRow5(	new Space(	"yellow"	,	245	,	1	,	false,	false));
            tile4	.addRow5(	new Space(	"yellow"	,	246	,	2	,	false,	false));
            tile4	.addRow5(	new Space(	"yellow"	,	247	,	2	,	false,	false));
            tile4	.addRow5(	new Space(	"grey"	,	248	,	1	,	false,	false));
            tile4	.addRow5(	new Space(	"yellow"	,	249	,	1	,	false,	false));
            tile4	.addRow5(	new Space(	"green"	,	250	,	1	,	false,	false));
            tile4	.addRow6(	new Space(	"green"	,	251	,	1	,	false,	false));
            tile4	.addRow6(	new Space(	"green"	,	252	,	2	,	false,	false));
            tile4	.addRow6(	new Space(	"yellow"	,	253	,	1	,	false,	false));
            tile4	.addRow6(	new Space(	"black"	,	254	,	0	,	false,	false));
            tile4	.addRow6(	new Space(	"green"	,	255	,	1	,	false,	false));
            tile4	.addRow7(	new Space(	"green"	,	256	,	1	,	false,	false));
            tile4	.addRow7(	new Space(	"green"	,	257	,	1	,	false,	false));
            tile4	.addRow7(	new Space(	"green"	,	258	,	1	,	false,	false));
            tile4	.addRow7(	new Space(	"green"	,	259	,	1	,	false,	false));


            // Tile C
        MapElement tile5 = new Tile();
        tile5.setRotation(330);
        tile5.setNextTilePos(1);

            tile5	.addRow1(	new Space(	"green"	,	75	,	1	,	false,	false));
            tile5	.addRow1(	new Space(	"green"	,	76	,	1	,	false,	false));
            tile5	.addRow1(	new Space(	"grey"	,	77	,	1	,	false,	false));
            tile5	.addRow1(	new Space(	"grey"	,	78	,	1	,	false,	false));
            tile5	.addRow2(	new Space(	"green"	,	79	,	1	,	false,	false));
            tile5	.addRow2(	new Space(	"yellow"	,	80	,	1	,	false,	false));
            tile5	.addRow2(	new Space(	"grey"	,	81	,	1	,	false,	false));
            tile5	.addRow2(	new Space(	"blue"	,	82	,	1	,	false,	false));
            tile5	.addRow2(	new Space(	"blue"	,	83	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"blue"	,	84	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"blue"	,	85	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"yellow"	,	86	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"yellow"	,	87	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"grey"	,	88	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"blue"	,	89	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"blue"	,	90	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"yellow"	,	91	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"yellow"	,	92	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"yellow"	,	93	,	0	,	false,	false));
            tile5	.addRow4(	new Space(	"blue"	,	94	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"grey"	,	95	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"grey"	,	96	,	1	,	false,	false));
            tile5	.addRow5(	new Space(	"yellow"	,	97	,	1	,	false,	false));
            tile5	.addRow5(	new Space(	"grey"	,	98	,	1	,	false,	false));
            tile5	.addRow5(	new Space(	"blue"	,	99	,	1	,	false,	false));
            tile5	.addRow5(	new Space(	"blue"	,	100	,	1	,	false,	false));
            tile5	.addRow5(	new Space(	"yellow"	,	101	,	1	,	false,	false));
            tile5	.addRow5(	new Space(	"yellow"	,	102	,	1	,	false,	false));
            tile5	.addRow6(	new Space(	"yellow"	,	103	,	1	,	false,	false));
            tile5	.addRow6(	new Space(	"grey"	,	104	,	1	,	false,	false));
            tile5	.addRow6(	new Space(	"yellow"	,	105	,	1	,	false,	false));
            tile5	.addRow6(	new Space(	"yellow"	,	106	,	1	,	false,	false));
            tile5	.addRow6(	new Space(	"blue"	,	107	,	1	,	false,	false));
            tile5	.addRow7(	new Space(	"yellow"	,	108	,	1	,	false,	false));
            tile5	.addRow7(	new Space(	"yellow"	,	109	,	1	,	false,	false));
            tile5	.addRow7(	new Space(	"blue"	,	110	,	1	,	false,	false));
            tile5	.addRow7(	new Space(	"blue"	,	111	,	1	,	false,	false));


            // Tile N
        MapElement tile6 = new Tile();
        tile6.setNextTilePos(3);
        tile6.setRotation(90);

            tile6	.addRow1(	new Space(	"green"	,	482	,	1	,	false,	false));
            tile6	.addRow1(	new Space(	"green"	,	483	,	1	,	false,	false));
            tile6	.addRow1(	new Space(	"green"	,	484	,	1	,	false,	false));
            tile6	.addRow1(	new Space(	"green"	,	485	,	1	,	false,	false));
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


        //Tile T
        MapElement tile7 = new EndTile();
        tile7.setRotation(315);

        tile7	.addRow1(	new Space(	"blue"	,	583	,	1	,false,	false));
        tile7	.addRow1(	new Space(	"blue"	,	584	,	1	,false,	false));
        tile7	.addRow1(	new Space(	"blue"	,	585	,	1	,false,	false));

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
