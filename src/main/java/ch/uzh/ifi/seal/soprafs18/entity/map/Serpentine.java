package ch.uzh.ifi.seal.soprafs18.entity.map;

public class Serpentine extends Map {

    private long[] endTile;
    private long[] startSpaces;

    /**
     * Constructor
     */
    public Serpentine(){
        setup();
    }

    private void setup(){
        // Tile A
        MapElement tile1 = new Tile();
        tile1.setRotation(300);
        tile1.setNextTilePos(2);

        tile1	.addRow1(	new Space(	"green"	,	1,		1	,	false,	false));
        tile1	.addRow1(	new Space(	"red"	,	2,	1	,	false,	false));
        tile1	.addRow1(	new Space(	"green"	,	3,		1	,	false,	false));
        tile1	.addRow1(	new Space(	"green"	,	4,		1	,	false,	true));
        tile1	.addRow2(	new Space(	"blue"	,	5,		1	,	false,	false));
        tile1	.addRow2(	new Space(	"black"	,	6,		0	,	false,	false));
        tile1	.addRow2(	new Space(	"green"	,	7,		1	,	false,	false));
        tile1	.addRow2(	new Space(	"green"	,	8,		1	,	false,	false));
        tile1	.addRow2(	new Space(	"yellow",	9,		1	,	false,	true));
        tile1	.addRow3(	new Space(	"green"	,	10	,	1	,	false,	false));
        tile1	.addRow3(	new Space(	"black"	,	11	,	0	,	false,	false));
        tile1	.addRow3(	new Space(	"yellow",	12	,	1	,	false,	false));
        tile1	.addRow3(	new Space(	"green"	,	13	,	1	,	false,	false));
        tile1	.addRow3(	new Space(	"green"	,	14	,	1	,	false,	false));
        tile1	.addRow3(	new Space(	"green"	,	15	,	1	,	false,	true));
        tile1	.addRow4(	new Space(	"green"	,	16	,	1	,	false,	false));
        tile1	.addRow4(	new Space(	"yellow",	17	,	1	,	false,	false));
        tile1	.addRow4(	new Space(	"green"	,	18	,	1	,	false,	false));
        tile1	.addRow4(	new Space(	"blue"	,	19	,	1	,	false,	false));
        tile1	.addRow4(	new Space(	"green"	,	20	,	1	,	false,	false));
        tile1	.addRow4(	new Space(	"yellow",	21	,	1	,	false,	true));
        tile1	.addRow4(	new Space(	"green"	,	22	,	1	,	false,	false));
        tile1	.addRow5(	new Space(	"green"	,	23	,	1	,	false,	false));
        tile1	.addRow5(	new Space(	"green"	,	24	,	1	,	false,	false));
        tile1	.addRow5(	new Space(	"yellow",	25	,	1	,	false,	false));
        tile1	.addRow5(	new Space(	"green"	,	26	,	1	,	false,	false));
        tile1	.addRow5(	new Space(	"blue"	,	27	,	1	,	false,	false));
        tile1	.addRow5(	new Space(	"green"	,	28	,	1	,	false,	false));
        tile1	.addRow6(	new Space(	"green"	,	29	,	1	,	false,	false));
        tile1	.addRow6(	new Space(	"green"	,	30	,	1	,	false,	false));
        tile1	.addRow6(	new Space(	"green"	,	31	,	1	,	false,	false));
        tile1	.addRow6(	new Space(	"green"	,	32	,	1	,	false,	false));
        tile1	.addRow6(	new Space(	"green"	,	33	,	1	,	false,	false));
        tile1	.addRow7(	new Space(	"green"	,	34	,	0	,	false,	false));
        tile1	.addRow7(	new Space(	"green"	,	35	,	0	,	false,	false));
        tile1	.addRow7(	new Space(	"green"	,	36	,	0	,	false,	false));
        tile1	.addRow7(	new Space(	"green"	,	37	,	0	,	false,	false));


        // TIle C
        MapElement tile2 = new Tile();
        tile2.setNextTilePos(1);
        tile2.setRotation(120);

        tile2	.addRow1(	new Space(	"green"	,	75	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"green"	,	76	,	1	,	false,	false));
        tile2	.addRow1(	new Space(	"grey"	,	77	,	1	,	false,	false));
        tile2	.addRow1(	new Space(	"grey"	,	78	,	1	,	true,	false));
        tile2	.addRow2(	new Space(	"green"	,	79	,	1	,	false,	true));
        tile2	.addRow2(	new Space(	"yellow",	80	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"grey"	,	81	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	82	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"blue"	,	83	,	1	,	true,	false));
        tile2	.addRow3(	new Space(	"blue"	,	84	,	1	,	false,	true));
        tile2	.addRow3(	new Space(	"blue"	,	85	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"yellow",	86	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"yellow",	87	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"grey"	,	88	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"blue"	,	89	,	1	,	true,	false));
        tile2	.addRow4(	new Space(	"blue"	,	90	,	1	,	false,	true));
        tile2	.addRow4(	new Space(	"yellow",	91	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"yellow",	92	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"black",	93	,	0	,	false,	false));
        tile2	.addRow4(	new Space(	"blue"	,	94	,	1	,	false,	false));
        tile2	.addRow4(	new Space(	"grey"	,	95	,	1	,	true,	false));
        tile2	.addRow4(	new Space(	"grey"	,	96	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow",	97	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"grey"	,	98	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"blue"	,	99	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"blue"	,	100	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow",	101	,	1	,	false,	false));
        tile2	.addRow5(	new Space(	"yellow",	102	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow",	103	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"grey"	,	104	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow",	105	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"yellow",	106	,	1	,	false,	false));
        tile2	.addRow6(	new Space(	"blue"	,	107	,	1	,	false,	false));
        tile2	.addRow7(	new Space(	"yellow",	108	,	1	,	false,	false));
        tile2	.addRow7(	new Space(	"yellow",	109	,	1	,	false,	false));
        tile2	.addRow7(	new Space(	"blue"	,	110	,	1	,	false,	false));
        tile2	.addRow7(	new Space(	"blue"	,	111	,	1	,	false,	false));



        // Tile E
        MapElement tile3 = new Tile();
        tile3.setRotation(270);
        tile3.setNextTilePos(5);

        tile3	.addRow1(	new Space(	"red"	,	149	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"yellow"	,	150	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"yellow"	,	151	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"yellow"	,	152	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	153	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	154	,	2	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	155	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"black"	,	156	,	0	,	false,	false));
        tile3	.addRow2(	new Space(	"yellow"	,	157	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"grey"	,	158	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"green"	,	159	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"black"	,	160	,	0	,	false,	false));
        tile3	.addRow3(	new Space(	"blue"	,	161	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"blue"	,	162	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"green"	,	163	,	1	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	164	,	1	,	false,	true));
        tile3	.addRow4(	new Space(	"green"	,	165	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	166	,	3	,	false,	false));
        tile3	.addRow4(	new Space(	"blue"	,	167	,	1	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	168	,	1	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	169	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	170	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"green"	,	171	,	1	,	false,	true));
        tile3	.addRow5(	new Space(	"grey"	,	172	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"grey"	,	173	,	3	,	false,	false));
        tile3	.addRow5(	new Space(	"grey"	,	174	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"black"	,	175	,	0	,	false,	false));
        tile3	.addRow5(	new Space(	"green"	,	176	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"grey"	,	177	,	1	,	false,	true));
        tile3	.addRow6(	new Space(	"black"	,	178	,	0	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	179	,	2	,	false,	false));
        tile3	.addRow6(	new Space(	"blue"	,	180	,	2	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	181	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"black"	,	182	,	0	,	true,	true));
        tile3	.addRow7(	new Space(	"grey"	,	183	,	1	,	true,	false));
        tile3	.addRow7(	new Space(	"grey"	,	184	,	1	,	true,	false));
        tile3	.addRow7(	new Space(	"green"	,	185	,	1	,	true,	false));


        // Tile G
        MapElement tile4 = new Tile();
        tile4.setNextTilePos(1);
        tile4.setRotation(180);

        tile4	.addRow1(	new Space(	"green"	,	223	,	1	,	true,	false));
        tile4	.addRow1(	new Space(	"green"	,	224	,	1	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	225	,	1	,	false,	false));
        tile4	.addRow1(	new Space(	"green"	,	226	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	227	,	1	,	true,	false));
        tile4	.addRow2(	new Space(	"green"	,	228	,	2	,	false,	false));
        tile4	.addRow2(	new Space(	"yellow",	229	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"black"	,	230	,	0	,	false,	false));
        tile4	.addRow2(	new Space(	"green"	,	231	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"yellow",	232	,	1	,	true,	false));
        tile4	.addRow3(	new Space(	"yellow",	233	,	2	,	false,	false));
        tile4	.addRow3(	new Space(	"yellow",	234	,	2	,	false,	false));
        tile4	.addRow3(	new Space(	"grey"	,	235	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"yellow",	236	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"green"	,	237	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"black"	,	238	,	0	,	true,	true));
        tile4	.addRow4(	new Space(	"black"	,	239	,	0	,	false,	false));
        tile4	.addRow4(	new Space(	"yellow",	240	,	4	,	false,	false));
        tile4	.addRow4(	new Space(	"yellow",	241	,	3	,	false,	false));
        tile4	.addRow4(	new Space(	"yellow",	242	,	2	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	243	,	2	,	false,	false));
        tile4	.addRow4(	new Space(	"red"	,	244	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"yellow",	245	,	1	,	false,	true));
        tile4	.addRow5(	new Space(	"yellow",	246	,	2	,	false,	false));
        tile4	.addRow5(	new Space(	"yellow",	247	,	2	,	false,	false));
        tile4	.addRow5(	new Space(	"grey"	,	248	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"yellow",	249	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	250	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	251	,	1	,	false,	true));
        tile4	.addRow6(	new Space(	"green"	,	252	,	2	,	false,	false));
        tile4	.addRow6(	new Space(	"yellow",	253	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"black"	,	254	,	0	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	255	,	1	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	256	,	1	,	false,	true));
        tile4	.addRow7(	new Space(	"green"	,	257	,	1	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	258	,	1	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	259	,	1	,	false,	false));


        // TIle J
        MapElement tile5 = new Tile();
        tile5.setRotation(180);
        tile5.setNextTilePos(2);

        tile5	.addRow1(	new Space(	"blue"	,	334	,	1	,	false,	true));
        tile5	.addRow1(	new Space(	"blue"	,	335	,	1	,	false,	false));
        tile5	.addRow1(	new Space(	"blue"	,	336	,	1	,	false,	false));
        tile5	.addRow1(	new Space(	"blue"	,	337	,	1	,	true,	false));
        tile5	.addRow2(	new Space(	"blue"	,	338	,	1	,	false,	true));
        tile5	.addRow2(	new Space(	"black"	,	339	,	0	,	false,	false));
        tile5	.addRow2(	new Space(	"blue"	,	340	,	2	,	false,	false));
        tile5	.addRow2(	new Space(	"blue"	,	341	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"grey"	,	342	,	2	,	true,	false));
        tile5	.addRow3(	new Space(	"blue"	,	343	,	1	,	false,	true));
        tile5	.addRow3(	new Space(	"blue"	,	344	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	345	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	346	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"grey"	,	347	,	2	,	false,	false));
        tile5	.addRow3(	new Space(	"grey"	,	348	,	1	,	true,	false));
        tile5	.addRow4(	new Space(	"yellow"	,	349	,	1	,	false,	true));
        tile5	.addRow4(	new Space(	"yellow"	,	350	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	351	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"red"	,	352	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	353	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"grey"	,	354	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"grey"	,	355	,	1	,	true,	false));
        tile5	.addRow5(	new Space(	"yellow"	,	356	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"yellow"	,	357	,	2	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	358	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	359	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	360	,	2	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	361	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	362	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	363	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"yellow"	,	364	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"black"	,	365	,	0	,	false,	false));
        tile5	.addRow6(	new Space(	"grey"	,	366	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	367	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	368	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"yellow"	,	369	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"grey"	,	370	,	2	,	false,	false));




        // Tile M
        MapElement tile6 = new Tile();
        tile6.setRotation(60);
        tile6.setNextTilePos(3);

        tile6	.addRow1(	new Space(	"green"	,	445	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	446	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"green"	,	447	,	1	,	true,	false));
        tile6	.addRow1(	new Space(	"red"	,	448	,	1	,	true,	false));
        tile6	.addRow2(	new Space(	"green"	,	449	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"yellow"	,	450	,	4	,	false,	false));
        tile6	.addRow2(	new Space(	"black"	,	451	,	0	,	false,	false));
        tile6	.addRow2(	new Space(	"black"	,	452	,	0	,	false,	false));
        tile6	.addRow2(	new Space(	"blue"	,	453	,	4	,	false,	false));
        tile6	.addRow3(	new Space(	"green"	,	454	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	455	,	2	,	false,	false));
        tile6	.addRow3(	new Space(	"green"	,	456	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"green"	,	457	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"blue"	,	458	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"black"	,	459	,	0	,	false,	false));
        tile6	.addRow4(	new Space(	"black"	,	460	,	0	,	false,	false));
        tile6	.addRow4(	new Space(	"green"	,	461	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"green"	,	462	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"grey"	,	463	,	2	,	false,	false));
        tile6	.addRow4(	new Space(	"green"	,	464	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"green"	,	465	,	1	,	false,	false));
        tile6	.addRow4(	new Space(	"black"	,	466	,	0	,	false,	false));
        tile6	.addRow5(	new Space(	"green"	,	467	,	0	,	false,	false));
        tile6	.addRow5(	new Space(	"green"	,	468	,	0	,	false,	false));
        tile6	.addRow5(	new Space(	"green"	,	469	,	0	,	false,	false));
        tile6	.addRow5(	new Space(	"green"	,	470	,	0	,	false,	false));
        tile6	.addRow5(	new Space(	"grey"	,	471	,	2	,	false,	false));
        tile6	.addRow5(	new Space(	"green"	,	472	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	473	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	474	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	475	,	1	,	false,	false));
        tile6	.addRow6(	new Space(	"grey"	,	476	,	2	,	false,	false));
        tile6	.addRow6(	new Space(	"green"	,	477	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"blue"	,	478	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"blue"	,	479	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	480	,	1	,	false,	false));
        tile6	.addRow7(	new Space(	"green"	,	481	,	1	,	false,	false));



        //Tile T
        MapElement tile7 = new EndTile();
        tile7.setRotation(225);

        tile7	.addRow1(	new Space(	"blue"	,	583	,	1	,	false,	false));
        tile7	.addRow1(	new Space(	"blue"	,	584	,	1	,	false,	false));
        tile7	.addRow1(	new Space(	"blue"	,	585	,	1	,	false,	false));


        // EndTile
        endTile = new long[3];
        endTile[0] = tile7.getRow1().get(0).getId();
        endTile[1] = tile7.getRow1().get(1).getId();
        endTile[2] = tile7.getRow1().get(2).getId();

        // StartPosition
        startSpaces = new long[4];
        startSpaces[0] = tile1.getRow7().get(3).getId();
        startSpaces[1] = tile1.getRow7().get(2).getId();
        startSpaces[2] = tile1.getRow7().get(1).getId();
        startSpaces[3] = tile1.getRow7().get(0).getId();

        // Initializing Blockades
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
