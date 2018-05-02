package ch.uzh.ifi.seal.soprafs18.entity.map;

public class WitchsCauldron extends Map {

    private long[] endTile;
    private long[] startSpaces;

    /**
     * Constructor
     */
    public WitchsCauldron(){
        setup();
    }

        private void setup(){

        //Tile A
        MapElement tile1 = new Tile();
        tile1.setRotation(330);
        tile1.setNextTilePos(1);

            tile1	.addRow1(	new Space(	"green"	,	1	,	1	,	false,	false));
            tile1	.addRow1(	new Space(	"red"	,	2	,	1	,	false,	false));
            tile1	.addRow1(	new Space(	"green"	,	3	,	1	,	false,	false));
            tile1	.addRow1(	new Space(	"green"	,	4	,	1	,	false,	true));
            tile1	.addRow2(	new Space(	"blue"	,	5	,	1	,	false,	false));
            tile1	.addRow2(	new Space(	"black"	,	6	,	0	,	false,	false));
            tile1	.addRow2(	new Space(	"green"	,	7	,	1	,	false,	false));
            tile1	.addRow2(	new Space(	"green"	,	8	,	1	,	false,	false));
            tile1	.addRow2(	new Space(	"yellow"	,	9	,	1	,	false,	true));
            tile1	.addRow3(	new Space(	"green"	,	10	,	1	,	false,	false));
            tile1	.addRow3(	new Space(	"black"	,	11	,	0	,	false,	false));
            tile1	.addRow3(	new Space(	"yellow"	,	12	,	1	,	false,	false));
            tile1	.addRow3(	new Space(	"green"	,	13	,	1	,	false,	false));
            tile1	.addRow3(	new Space(	"green"	,	14	,	1	,	false,	false));
            tile1	.addRow3(	new Space(	"green"	,	15	,	1	,	false,	true));
            tile1	.addRow4(	new Space(	"green"	,	16	,	1	,	false,	false));
            tile1	.addRow4(	new Space(	"yellow"	,	17	,	1	,	false,	false));
            tile1	.addRow4(	new Space(	"green"	,	18	,	1	,	false,	false));
            tile1	.addRow4(	new Space(	"blue"	,	19	,	1	,	false,	false));
            tile1	.addRow4(	new Space(	"green"	,	20	,	1	,	false,	false));
            tile1	.addRow4(	new Space(	"yellow"	,	21	,	1	,	false,	false));
            tile1	.addRow4(	new Space(	"green"	,	22	,	1	,	false,	true));
            tile1	.addRow5(	new Space(	"green"	,	23	,	1	,	false,	false));
            tile1	.addRow5(	new Space(	"green"	,	24	,	1	,	false,	false));
            tile1	.addRow5(	new Space(	"yellow"	,	25	,	1	,	false,	false));
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



            // TIle L
        MapElement tile2 = new Tile();
        tile2.setNextTilePos(2);
        tile2.setRotation(30);

            tile2	.addRow1(	new Space(	"blue"	,	408	,	1	,	true,	false));
            tile2	.addRow1(	new Space(	"red"	,	409	,	1	,	false,	false));
            tile2	.addRow1(	new Space(	"red"	,	410	,	1	,	false,	false));
            tile2	.addRow1(	new Space(	"green"	,	411	,	3	,	false,	false));
            tile2	.addRow2(	new Space(	"green"	,	412	,	1	,	true,	false));
            tile2	.addRow2(	new Space(	"blue"	,	413	,	1	,	false,	false));
            tile2	.addRow2(	new Space(	"blue"	,	414	,	1	,	false,	false));
            tile2	.addRow2(	new Space(	"green"	,	415	,	3	,	false,	false));
            tile2	.addRow2(	new Space(	"green"	,	416	,	1	,	false,	false));
            tile2	.addRow3(	new Space(	"green"	,	417	,	2	,	true,	false));
            tile2	.addRow3(	new Space(	"green"	,	418	,	1	,	false,	false));
            tile2	.addRow3(	new Space(	"green"	,	419	,	1	,	false,	false));
            tile2	.addRow3(	new Space(	"green"	,	420	,	3	,	false,	false));
            tile2	.addRow3(	new Space(	"green"	,	421	,	1	,	false,	false));
            tile2	.addRow3(	new Space(	"green"	,	422	,	2	,	false,	false));
            tile2	.addRow4(	new Space(	"green"	,	423	,	2	,	true,	false));
            tile2	.addRow4(	new Space(	"green"	,	424	,	1	,	false,	false));
            tile2	.addRow4(	new Space(	"black"	,	425	,	0	,	false,	false));
            tile2	.addRow4(	new Space(	"green"	,	426	,	1	,	false,	false));
            tile2	.addRow4(	new Space(	"black"	,	427	,	0	,	false,	false));
            tile2	.addRow4(	new Space(	"green"	,	428	,	1	,	false,	false));
            tile2	.addRow4(	new Space(	"green"	,	429	,	2	,	false,	true));
            tile2	.addRow5(	new Space(	"green"	,	430	,	1	,	false,	false));
            tile2	.addRow5(	new Space(	"green"	,	431	,	2	,	false,	false));
            tile2	.addRow5(	new Space(	"green"	,	432	,	2	,	false,	false));
            tile2	.addRow5(	new Space(	"green"	,	433	,	1	,	false,	false));
            tile2	.addRow5(	new Space(	"green"	,	434	,	2	,	false,	false));
            tile2	.addRow5(	new Space(	"green"	,	435	,	1	,	false,	true));
            tile2	.addRow6(	new Space(	"green"	,	436	,	2	,	false,	false));
            tile2	.addRow6(	new Space(	"green"	,	437	,	2	,	false,	false));
            tile2	.addRow6(	new Space(	"green"	,	438	,	2	,	false,	false));
            tile2	.addRow6(	new Space(	"green"	,	439	,	1	,	false,	false));
            tile2	.addRow6(	new Space(	"green"	,	440	,	1	,	false,	true));
            tile2	.addRow7(	new Space(	"yellow"	,	441	,	2	,	false,	false));
            tile2	.addRow7(	new Space(	"red"	,	442	,	2	,	false,	false));
            tile2	.addRow7(	new Space(	"yellow"	,	443	,	1	,	false,	false));
            tile2	.addRow7(	new Space(	"black"	,	444	,	0	,	false,	true));



            // Tile G
        MapElement tile3 = new Tile();
        tile3.setRotation(90);;
        tile3.setNextTilePos(4);

            tile3	.addRow1(	new Space(	"green"	,	223	,	1	,	true,	false));
            tile3	.addRow1(	new Space(	"green"	,	224	,	1	,	true,	false));
            tile3	.addRow1(	new Space(	"green"	,	225	,	1	,	true,	false));
            tile3	.addRow1(	new Space(	"green"	,	226	,	1	,	true,	false));
            tile3	.addRow2(	new Space(	"green"	,	227	,	1	,	false,	false));
            tile3	.addRow2(	new Space(	"green"	,	228	,	2	,	false,	false));
            tile3	.addRow2(	new Space(	"yellow"	,	229	,	1	,	false,	false));
            tile3	.addRow2(	new Space(	"black"	,	230	,	0	,	false,	false));
            tile3	.addRow2(	new Space(	"green"	,	231	,	1	,	false,	false));
            tile3	.addRow3(	new Space(	"yellow"	,	232	,	1	,	false,	false));
            tile3	.addRow3(	new Space(	"yellow"	,	233	,	2	,	false,	false));
            tile3	.addRow3(	new Space(	"yellow"	,	234	,	2	,	false,	false));
            tile3	.addRow3(	new Space(	"grey"	,	235	,	1	,	false,	false));
            tile3	.addRow3(	new Space(	"yellow"	,	236	,	1	,	false,	false));
            tile3	.addRow3(	new Space(	"green"	,	237	,	1	,	false,	false));
            tile3	.addRow4(	new Space(	"black"	,	238	,	0	,	false,	false));
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
            tile3	.addRow5(	new Space(	"green"	,	250	,	1	,	false,	true));
            tile3	.addRow6(	new Space(	"green"	,	251	,	1	,	false,	false));
            tile3	.addRow6(	new Space(	"green"	,	252	,	2	,	false,	false));
            tile3	.addRow6(	new Space(	"yellow"	,	253	,	1	,	false,	false));
            tile3	.addRow6(	new Space(	"black"	,	254	,	0	,	false,	false));
            tile3	.addRow6(	new Space(	"green"	,	255	,	1	,	false,	true));
            tile3	.addRow7(	new Space(	"green"	,	256	,	1	,	false,	false));
            tile3	.addRow7(	new Space(	"green"	,	257	,	1	,	false,	false));
            tile3	.addRow7(	new Space(	"green"	,	258	,	1	,	false,	false));
            tile3	.addRow7(	new Space(	"green"	,	259	,	1	,	false,	true));




            // Tile D
        MapElement tile4 = new Tile();
        tile4.setNextTilePos(5);
        tile4.setRotation(90);

            tile4	.addRow1(	new Space(	"green"	,	112	,	1	,	false,	true));
            tile4	.addRow1(	new Space(	"green"	,	113	,	1	,	false,	false));
            tile4	.addRow1(	new Space(	"black"	,	114	,	0	,	false,	false));
            tile4	.addRow1(	new Space(	"blue"	,	115	,	3	,	true,	false));
            tile4	.addRow2(	new Space(	"green"	,	116	,	1	,	false,	true));
            tile4	.addRow2(	new Space(	"green"	,	117	,	1	,	false,	false));
            tile4	.addRow2(	new Space(	"yellow"	,	118	,	3	,	false,	false));
            tile4	.addRow2(	new Space(	"yellow"	,	119	,	1	,	false,	false));
            tile4	.addRow2(	new Space(	"black"	,	120	,	0	,	true,	false));
            tile4	.addRow3(	new Space(	"green"	,	121	,	1	,	false,	true));
            tile4	.addRow3(	new Space(	"blue"	,	122	,	1	,	false,	false));
            tile4	.addRow3(	new Space(	"green"	,	123	,	1	,	false,	false));
            tile4	.addRow3(	new Space(	"black"	,	124	,	0	,	false,	false));
            tile4	.addRow3(	new Space(	"yellow"	,	125	,	3	,	false,	false));
            tile4	.addRow3(	new Space(	"green"	,	126	,	1	,	true,	false));
            tile4	.addRow4(	new Space(	"green"	,	127	,	2	,	false,	true));
            tile4	.addRow4(	new Space(	"blue"	,	128	,	1	,	false,	false));
            tile4	.addRow4(	new Space(	"blue"	,	129	,	2	,	false,	false));
            tile4	.addRow4(	new Space(	"black"	,	130	,	0	,	false,	false));
            tile4	.addRow4(	new Space(	"green"	,	131	,	1	,	false,	false));
            tile4	.addRow4(	new Space(	"green"	,	132	,	1	,	false,	false));
            tile4	.addRow4(	new Space(	"green"	,	133	,	2	,	true,	false));
            tile4	.addRow5(	new Space(	"green"	,	134	,	1	,	false,	false));
            tile4	.addRow5(	new Space(	"blue"	,	135	,	1	,	false,	false));
            tile4	.addRow5(	new Space(	"blue"	,	136	,	1	,	false,	false));
            tile4	.addRow5(	new Space(	"blue"	,	137	,	2	,	false,	false));
            tile4	.addRow5(	new Space(	"blue"	,	138	,	1	,	false,	false));
            tile4	.addRow5(	new Space(	"green"	,	139	,	1	,	false,	false));
            tile4	.addRow6(	new Space(	"green"	,	140	,	1	,	false,	false));
            tile4	.addRow6(	new Space(	"blue"	,	141	,	1	,	false,	false));
            tile4	.addRow6(	new Space(	"blue"	,	142	,	1	,	false,	false));
            tile4	.addRow6(	new Space(	"blue"	,	143	,	1	,	false,	false));
            tile4	.addRow6(	new Space(	"green"	,	144	,	1	,	false,	false));
            tile4	.addRow7(	new Space(	"green"	,	145	,	1	,	false,	false));
            tile4	.addRow7(	new Space(	"green"	,	146	,	1	,	false,	false));
            tile4	.addRow7(	new Space(	"green"	,	147	,	1	,	false,	false));
            tile4	.addRow7(	new Space(	"green"	,	148	,	2	,	false,	false));


            // Tile M
        MapElement tile5 = new Tile();
        tile5.setRotation(330);
        tile5.setNextTilePos(4);

            tile5	.addRow1(	new Space(	"green"	,	445	,	1	,	true,	false));
            tile5	.addRow1(	new Space(	"green"	,	446	,	1	,	true,	false));
            tile5	.addRow1(	new Space(	"green"	,	447	,	1	,	true,	false));
            tile5	.addRow1(	new Space(	"red"	,	448	,	1	,	true,	false));
            tile5	.addRow2(	new Space(	"green"	,	449	,	1	,	false,	false));
            tile5	.addRow2(	new Space(	"yellow"	,	450	,	4	,	false,	false));
            tile5	.addRow2(	new Space(	"black"	,	451	,	0	,	false,	false));
            tile5	.addRow2(	new Space(	"black"	,	452	,	0	,	false,	false));
            tile5	.addRow2(	new Space(	"blue"	,	453	,	4	,	false,	false));
            tile5	.addRow3(	new Space(	"green"	,	454	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"yellow"	,	455	,	2	,	false,	false));
            tile5	.addRow3(	new Space(	"green"	,	456	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"green"	,	457	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"blue"	,	458	,	1	,	false,	false));
            tile5	.addRow3(	new Space(	"black"	,	459	,	0	,	false,	false));
            tile5	.addRow4(	new Space(	"black"	,	460	,	0	,	false,	true));
            tile5	.addRow4(	new Space(	"green"	,	461	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"green"	,	462	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"grey"	,	463	,	2	,	false,	false));
            tile5	.addRow4(	new Space(	"green"	,	464	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"green"	,	465	,	1	,	false,	false));
            tile5	.addRow4(	new Space(	"black"	,	466	,	0	,	false,	false));
            tile5	.addRow5(	new Space(	"green"	,	467	,	0	,	false,	true));
            tile5	.addRow5(	new Space(	"green"	,	468	,	0	,	false,	false));
            tile5	.addRow5(	new Space(	"green"	,	469	,	0	,	false,	false));
            tile5	.addRow5(	new Space(	"green"	,	470	,	0	,	false,	false));
            tile5	.addRow5(	new Space(	"grey"	,	471	,	2	,	false,	false));
            tile5	.addRow5(	new Space(	"green"	,	472	,	1	,	false,	false));
            tile5	.addRow6(	new Space(	"green"	,	473	,	1	,	false,	true));
            tile5	.addRow6(	new Space(	"green"	,	474	,	1	,	false,	false));
            tile5	.addRow6(	new Space(	"green"	,	475	,	1	,	false,	false));
            tile5	.addRow6(	new Space(	"grey"	,	476	,	2	,	false,	false));
            tile5	.addRow6(	new Space(	"green"	,	477	,	1	,	false,	false));
            tile5	.addRow7(	new Space(	"blue"	,	478	,	1	,	false,	true));
            tile5	.addRow7(	new Space(	"blue"	,	479	,	1	,	false,	false));
            tile5	.addRow7(	new Space(	"green"	,	480	,	1	,	false,	false));
            tile5	.addRow7(	new Space(	"green"	,	481	,	1	,	false,	false));


            // Tile I
        MapElement tile6 = new Tile();
        tile6.setNextTilePos(6);
        tile6.setRotation(30);

            tile6	.addRow1(	new Space(	"green"	,	297	,	1	,	false,	false));
            tile6	.addRow1(	new Space(	"green"	,	298	,	1	,	false,	false));
            tile6	.addRow1(	new Space(	"green"	,	299	,	1	,	false,	false));
            tile6	.addRow1(	new Space(	"green"	,	300	,	1	,	false,	false));
            tile6	.addRow2(	new Space(	"yellow"	,	301	,	1	,	false,	false));
            tile6	.addRow2(	new Space(	"green"	,	302	,	1	,	false,	false));
            tile6	.addRow2(	new Space(	"black"	,	303	,	0	,	false,	false));
            tile6	.addRow2(	new Space(	"green"	,	304	,	1	,	false,	false));
            tile6	.addRow2(	new Space(	"green"	,	305	,	1	,	false,	false));
            tile6	.addRow3(	new Space(	"yellow"	,	306	,	1	,	false,	false));
            tile6	.addRow3(	new Space(	"yellow"	,	307	,	2	,	false,	false));
            tile6	.addRow3(	new Space(	"green"	,	308	,	1	,	false,	false));
            tile6	.addRow3(	new Space(	"black"	,	309	,	0	,	false,	false));
            tile6	.addRow3(	new Space(	"green"	,	310	,	2	,	false,	false));
            tile6	.addRow3(	new Space(	"green"	,	311	,	1	,	false,	false));
            tile6	.addRow4(	new Space(	"yellow"	,	312	,	1	,	false,	false));
            tile6	.addRow4(	new Space(	"yellow"	,	313	,	2	,	false,	false));
            tile6	.addRow4(	new Space(	"green"	,	314	,	1	,	false,	false));
            tile6	.addRow4(	new Space(	"green"	,	315	,	2	,	false,	false));
            tile6	.addRow4(	new Space(	"red"	,	316	,	3	,	false,	false));
            tile6	.addRow4(	new Space(	"black"	,	317	,	0	,	false,	false));
            tile6	.addRow4(	new Space(	"black"	,	318	,	0	,	true,	false));
            tile6	.addRow5(	new Space(	"yellow"	,	319	,	2	,	false,	false));
            tile6	.addRow5(	new Space(	"grey"	,	320	,	3	,	false,	false));
            tile6	.addRow5(	new Space(	"black"	,	321	,	0	,	false,	false));
            tile6	.addRow5(	new Space(	"black"	,	322	,	0	,	false,	false));
            tile6	.addRow5(	new Space(	"green"	,	323	,	2	,	false,	false));
            tile6	.addRow5(	new Space(	"green"	,	324	,	1	,	true,	false));
            tile6	.addRow6(	new Space(	"blue"	,	325	,	2	,	false,	false));
            tile6	.addRow6(	new Space(	"blue"	,	326	,	1	,	false,	false));
            tile6	.addRow6(	new Space(	"blue"	,	327	,	1	,	false,	false));
            tile6	.addRow6(	new Space(	"green"	,	328	,	1	,	false,	false));
            tile6	.addRow6(	new Space(	"green"	,	329	,	1	,	true,	false));
            tile6	.addRow7(	new Space(	"blue"	,	330	,	2	,	false,	false));
            tile6	.addRow7(	new Space(	"blue"	,	331	,	2	,	false,	false));
            tile6	.addRow7(	new Space(	"blue"	,	332	,	1	,	false,	false));
            tile6	.addRow7(	new Space(	"green"	,	333	,	1	,	true,	false));


            //Tile T
        MapElement tile7 = new EndTile();
        tile7.setRotation(45);

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
