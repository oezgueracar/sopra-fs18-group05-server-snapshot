package ch.uzh.ifi.seal.soprafs18.entity.map;

public class Swamplands extends Map {

    private long[] endTile;
    private long[] startSpaces;

    /**
     * Constructor
     */
    public Swamplands(){
        setup();
    }

    private void setup(){

        //Tile A
        MapElement tile1 = new Tile();
        tile1.setNextTilePos(2);
        tile1.setNextTilePos(330);

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



        //Tile R
        MapElement tile2 = new TerrainStrip();
        tile2.setNextTilePos(2);
        tile2.setRotation(270);

        tile2	.addRow1(	new Space(	"green"	,	567	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"green"	,	568	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"black"	,	569	,	0	,	false,	true));
        tile2	.addRow1(	new Space(	"yellow"	,	570	,	1	,	false,	true));
        tile2	.addRow1(	new Space(	"yellow"	,	571	,	1	,	false,	true));
        tile2	.addRow2(	new Space(	"green"	,	572	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"green"	,	573	,	3	,	false,	false));
        tile2	.addRow2(	new Space(	"black"	,	574	,	0	,	false,	false));
        tile2	.addRow2(	new Space(	"yellow"	,	575	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"red"	,	576	,	1	,	false,	false));
        tile2	.addRow2(	new Space(	"yellow"	,	577	,	1	,	false,	false));
        tile2	.addRow3(	new Space(	"green"	,	578	,	1	,	true,	false));
        tile2	.addRow3(	new Space(	"green"	,	579	,	1	,	true,	false));
        tile2	.addRow3(	new Space(	"black"	,	580	,	0	,	true,	false));
        tile2	.addRow3(	new Space(	"yellow"	,	581	,	1	,	true,	false));
        tile2	.addRow3(	new Space(	"yellow"	,	582	,	1	,	true,	false));


        //Tile D
        MapElement tile3 = new Tile();
        tile3.setRotation(210);
        tile3.setNextTilePos(3);

        tile3	.addRow1(	new Space(	"green"	,	112	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"green"	,	113	,	1	,	false,	false));
        tile3	.addRow1(	new Space(	"black"	,	114	,	0	,	false,	false));
        tile3	.addRow1(	new Space(	"blue"	,	115	,	3	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	116	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"green"	,	117	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"yellow"	,	118	,	3	,	false,	false));
        tile3	.addRow2(	new Space(	"yellow"	,	119	,	1	,	false,	false));
        tile3	.addRow2(	new Space(	"black"	,	120	,	0	,	false,	false));
        tile3	.addRow3(	new Space(	"green"	,	121	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"blue"	,	122	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"green"	,	123	,	1	,	false,	false));
        tile3	.addRow3(	new Space(	"black"	,	124	,	0	,	false,	false));
        tile3	.addRow3(	new Space(	"yellow"	,	125	,	3	,	false,	false));
        tile3	.addRow3(	new Space(	"green"	,	126	,	1	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	127	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"blue"	,	128	,	1	,	false,	false));
        tile3	.addRow4(	new Space(	"blue"	,	129	,	2	,	false,	false));
        tile3	.addRow4(	new Space(	"black"	,	130	,	0	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	131	,	1	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	132	,	1	,	false,	false));
        tile3	.addRow4(	new Space(	"green"	,	133	,	2	,	true,	false));
        tile3	.addRow5(	new Space(	"green"	,	134	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"blue"	,	135	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"blue"	,	136	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"blue"	,	137	,	2	,	false,	false));
        tile3	.addRow5(	new Space(	"blue"	,	138	,	1	,	false,	false));
        tile3	.addRow5(	new Space(	"green"	,	139	,	1	,	true,	false));
        tile3	.addRow6(	new Space(	"green"	,	140	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"blue"	,	141	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"blue"	,	142	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"blue"	,	143	,	1	,	false,	false));
        tile3	.addRow6(	new Space(	"green"	,	144	,	1	,	true,	false));
        tile3	.addRow7(	new Space(	"green"	,	145	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	146	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	147	,	1	,	false,	false));
        tile3	.addRow7(	new Space(	"green"	,	148	,	2	,	true,	false));


        //Tile H
        MapElement tile4 = new Tile();
        tile4.setNextTilePos(3);
        tile4.setRotation(210);

        tile4	.addRow1(	new Space(	"blue"	,	260	,	1	,	false,	true));
        tile4	.addRow1(	new Space(	"blue"	,	261	,	2	,	false,	true));
        tile4	.addRow1(	new Space(	"blue"	,	262	,	2	,	false,	true));
        tile4	.addRow1(	new Space(	"blue"	,	263	,	2	,	false,	true));
        tile4	.addRow2(	new Space(	"yellow"	,	264	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"blue"	,	265	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"blue"	,	266	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"blue"	,	267	,	1	,	false,	false));
        tile4	.addRow2(	new Space(	"blue"	,	268	,	2	,	false,	false));
        tile4	.addRow3(	new Space(	"yellow"	,	269	,	2	,	false,	false));
        tile4	.addRow3(	new Space(	"yellow"	,	270	,	2	,	false,	false));
        tile4	.addRow3(	new Space(	"yellow"	,	271	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"yellow"	,	272	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"blue"	,	273	,	1	,	false,	false));
        tile4	.addRow3(	new Space(	"blue"	,	274	,	2	,	false,	false));
        tile4	.addRow4(	new Space(	"yellow"	,	275	,	3	,	false,	false));
        tile4	.addRow4(	new Space(	"black"	,	276	,	0	,	false,	false));
        tile4	.addRow4(	new Space(	"yellow"	,	277	,	2	,	false,	false));
        tile4	.addRow4(	new Space(	"yellow"	,	278	,	2	,	false,	false));
        tile4	.addRow4(	new Space(	"yellow"	,	279	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	280	,	1	,	false,	false));
        tile4	.addRow4(	new Space(	"green"	,	281	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"yellow"	,	282	,	2	,	false,	false));
        tile4	.addRow5(	new Space(	"yellow"	,	283	,	2	,	false,	false));
        tile4	.addRow5(	new Space(	"yellow"	,	284	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"yellow"	,	285	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	286	,	1	,	false,	false));
        tile4	.addRow5(	new Space(	"green"	,	287	,	2	,	false,	false));
        tile4	.addRow6(	new Space(	"yellow"	,	288	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	289	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	290	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	291	,	1	,	false,	false));
        tile4	.addRow6(	new Space(	"green"	,	292	,	2	,	false,	false));
        tile4	.addRow7(	new Space(	"green"	,	293	,	1	,	true,	false));
        tile4	.addRow7(	new Space(	"green"	,	294	,	2	,	true,	false));
        tile4	.addRow7(	new Space(	"green"	,	295	,	2	,	true,	false));
        tile4	.addRow7(	new Space(	"green"	,	296	,	2	,	true,	false));


        //Tile E
        MapElement tile5 = new Tile();
        tile5.setRotation(270);
        tile5.setNextTilePos(5);

        tile5	.addRow1(	new Space(	"red"	,	149	,	1	,	false,	false));
        tile5	.addRow1(	new Space(	"yellow"	,	150	,	1	,	false,	false));
        tile5	.addRow1(	new Space(	"yellow"	,	151	,	1	,	false,	false));
        tile5	.addRow1(	new Space(	"yellow"	,	152	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"green"	,	153	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"green"	,	154	,	2	,	false,	false));
        tile5	.addRow2(	new Space(	"green"	,	155	,	1	,	false,	false));
        tile5	.addRow2(	new Space(	"black"	,	156	,	0	,	false,	false));
        tile5	.addRow2(	new Space(	"yellow"	,	157	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"grey"	,	158	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	159	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"black"	,	160	,	0	,	false,	false));
        tile5	.addRow3(	new Space(	"blue"	,	161	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"blue"	,	162	,	1	,	false,	false));
        tile5	.addRow3(	new Space(	"green"	,	163	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	164	,	1	,	true,	false));
        tile5	.addRow4(	new Space(	"green"	,	165	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	166	,	3	,	false,	false));
        tile5	.addRow4(	new Space(	"blue"	,	167	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	168	,	1	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	169	,	2	,	false,	false));
        tile5	.addRow4(	new Space(	"green"	,	170	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	171	,	1	,	true,	false));
        tile5	.addRow5(	new Space(	"grey"	,	172	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	173	,	3	,	false,	false));
        tile5	.addRow5(	new Space(	"grey"	,	174	,	1	,	false,	false));
        tile5	.addRow5(	new Space(	"black"	,	175	,	0	,	false,	false));
        tile5	.addRow5(	new Space(	"green"	,	176	,	1	,	false,	false));
        tile5	.addRow6(	new Space(	"grey"	,	177	,	1	,	true,	false));
        tile5	.addRow6(	new Space(	"black"	,	178	,	0	,	false,	false));
        tile5	.addRow6(	new Space(	"green"	,	179	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"blue"	,	180	,	2	,	false,	false));
        tile5	.addRow6(	new Space(	"green"	,	181	,	1	,	false,	false));
        tile5	.addRow7(	new Space(	"black"	,	182	,	0	,	true,	true));
        tile5	.addRow7(	new Space(	"grey"	,	183	,	1	,	false,	true));
        tile5	.addRow7(	new Space(	"grey"	,	184	,	1	,	false,	true));
        tile5	.addRow7(	new Space(	"green"	,	185	,	1	,	false,	true));


        //Tile O
        MapElement tile6 = new TerrainStrip();
        tile6.setNextTilePos(5);
        tile6.setRotation(90);

        tile6	.addRow1(	new Space(	"yellow"	,	519	,	2	,	false,	true));
        tile6	.addRow1(	new Space(	"yellow"	,	520	,	1	,	false,	true));
        tile6	.addRow1(	new Space(	"grey"	,	521	,	0	,	false,	true));
        tile6	.addRow1(	new Space(	"green"	,	522	,	2	,	false,	true));
        tile6	.addRow1(	new Space(	"grey"	,	523	,	2	,	false,	true));
        tile6	.addRow2(	new Space(	"yellow"	,	524	,	1	,	false,	false));
        tile6	.addRow2(	new Space(	"black"	,	525	,	0	,	false,	false));
        tile6	.addRow2(	new Space(	"blue"	,	526	,	4	,	false,	false));
        tile6	.addRow2(	new Space(	"black"	,	527	,	0	,	false,	false));
        tile6	.addRow2(	new Space(	"black"	,	528	,	0	,	false,	false));
        tile6	.addRow2(	new Space(	"grey"	,	529	,	1	,	false,	false));
        tile6	.addRow3(	new Space(	"yellow"	,	530	,	1	,	true,	false));
        tile6	.addRow3(	new Space(	"blue"	,	531	,	1	,	true,	false));
        tile6	.addRow3(	new Space(	"green"	,	532	,	2	,	true,	false));
        tile6	.addRow3(	new Space(	"green"	,	533	,	1	,	true,	false));
        tile6	.addRow3(	new Space(	"grey"	,	534	,	1	,	true,	false));




        //Tile K
        MapElement tile7 = new Tile();
        tile7.setRotation(330);
        tile7.setNextTilePos(5);

        tile7	.addRow1(	new Space(	"red"	,	371	,	1	,	false,	false));
        tile7	.addRow1(	new Space(	"green"	,	372	,	2	,	false,	false));
        tile7	.addRow1(	new Space(	"green"	,	373	,	2	,	false,	false));
        tile7	.addRow1(	new Space(	"green"	,	374	,	1	,	true,	false));
        tile7	.addRow2(	new Space(	"green"	,	375	,	1	,	false,	false));
        tile7	.addRow2(	new Space(	"green"	,	376	,	1	,	false,	false));
        tile7	.addRow2(	new Space(	"blue"	,	377	,	3	,	false,	false));
        tile7	.addRow2(	new Space(	"green"	,	378	,	1	,	false,	false));
        tile7	.addRow2(	new Space(	"green"	,	379	,	2	,	true,	false));
        tile7	.addRow3(	new Space(	"green"	,	380	,	1	,	false,	false));
        tile7	.addRow3(	new Space(	"green"	,	381	,	2	,	false,	false));
        tile7	.addRow3(	new Space(	"green"	,	382	,	1	,	false,	false));
        tile7	.addRow3(	new Space(	"green"	,	383	,	3	,	false,	false));
        tile7	.addRow3(	new Space(	"green"	,	384	,	1	,	false,	false));
        tile7	.addRow3(	new Space(	"green"	,	385	,	2	,	true,	false));
        tile7	.addRow4(	new Space(	"green"	,	386	,	2	,	false,	false));
        tile7	.addRow4(	new Space(	"green"	,	387	,	1	,	false,	false));
        tile7	.addRow4(	new Space(	"green"	,	388	,	3	,	false,	false));
        tile7	.addRow4(	new Space(	"green"	,	389	,	1	,	false,	false));
        tile7	.addRow4(	new Space(	"green"	,	390	,	3	,	false,	false));
        tile7	.addRow4(	new Space(	"green"	,	391	,	1	,	false,	false));
        tile7	.addRow4(	new Space(	"green"	,	392	,	2	,	true,	false));
        tile7	.addRow5(	new Space(	"green"	,	393	,	2	,	false,	false));
        tile7	.addRow5(	new Space(	"green"	,	394	,	1	,	false,	false));
        tile7	.addRow5(	new Space(	"green"	,	395	,	3	,	false,	false));
        tile7	.addRow5(	new Space(	"green"	,	396	,	1	,	false,	false));
        tile7	.addRow5(	new Space(	"green"	,	397	,	2	,	false,	false));
        tile7	.addRow5(	new Space(	"green"	,	398	,	1	,	false,	false));
        tile7	.addRow6(	new Space(	"green"	,	399	,	2	,	false,	false));
        tile7	.addRow6(	new Space(	"green"	,	400	,	1	,	false,	false));
        tile7	.addRow6(	new Space(	"yellow"	,	401	,	4	,	false,	false));
        tile7	.addRow6(	new Space(	"green"	,	402	,	1	,	false,	false));
        tile7	.addRow6(	new Space(	"green"	,	403	,	1	,	false,	false));
        tile7	.addRow7(	new Space(	"green"	,	404	,	1	,	false,	false));
        tile7	.addRow7(	new Space(	"green"	,	405	,	2	,	false,	false));
        tile7	.addRow7(	new Space(	"green"	,	406	,	2	,	false,	false));
        tile7	.addRow7(	new Space(	"red"	,	407	,	1	,	false,	false));


        //Tile T
        MapElement tile8 = new EndTile();
        tile7.setRotation(135);

        tile8	.addRow1(	new Space(	"blue"	,	583	,	1	,false,	false));
        tile8	.addRow1(	new Space(	"blue"	,	584	,	1	,false,	false));
        tile8	.addRow1(	new Space(	"blue"	,	585	,	1	,false,	false));

        //SetNeighbours
        tile1.setNeighbours();
        tile2.setNeighbours();
        tile3.setNeighbours();
        tile4.setNeighbours();
        tile5.setNeighbours();
        tile6.setNeighbours();
        tile7.setNeighbours();
        tile8.setNeighbours();

        //Set neighbouring tiles
        tile1.getRow1().get(3).getNeighbours()[0] = tile2.getRow3().get(0).getId();
        tile1.getRow1().get(3).getNeighbours()[1] = tile2.getRow3().get(1).getId();
        tile1.getRow2().get(4).getNeighbours()[0] = tile2.getRow3().get(1).getId();
        tile1.getRow2().get(4).getNeighbours()[1] = tile2.getRow3().get(2).getId();
        tile1.getRow3().get(5).getNeighbours()[0] = tile2.getRow3().get(2).getId();
        tile1.getRow3().get(5).getNeighbours()[1] = tile2.getRow3().get(3).getId();
        tile1.getRow4().get(6).getNeighbours()[0] = tile2.getRow3().get(3).getId();
        tile1.getRow4().get(6).getNeighbours()[1] = tile2.getRow3().get(4).getId();

        tile2.getRow3().get(0).getNeighbours()[2] = tile1.getRow1().get(3).getId();
        tile2.getRow3().get(1).getNeighbours()[3] = tile1.getRow1().get(3).getId();
        tile2.getRow3().get(1).getNeighbours()[2] = tile1.getRow2().get(4).getId();
        tile2.getRow3().get(2).getNeighbours()[3] = tile1.getRow2().get(4).getId();
        tile2.getRow3().get(2).getNeighbours()[2] = tile1.getRow3().get(5).getId();
        tile2.getRow3().get(3).getNeighbours()[3] = tile1.getRow3().get(5).getId();
        tile2.getRow3().get(3).getNeighbours()[2] = tile1.getRow4().get(6).getId();
        tile2.getRow3().get(4).getNeighbours()[3] = tile1.getRow4().get(6).getId();

        tile2.getRow1().get(0).getNeighbours()[0] = tile3.getRow7().get(3).getId();
        tile2.getRow1().get(1).getNeighbours()[5] = tile3.getRow7().get(3).getId();
        tile2.getRow1().get(1).getNeighbours()[0] = tile3.getRow6().get(4).getId();
        tile2.getRow1().get(2).getNeighbours()[5] = tile3.getRow6().get(4).getId();
        tile2.getRow1().get(2).getNeighbours()[0] = tile3.getRow5().get(5).getId();
        tile2.getRow1().get(3).getNeighbours()[5] = tile3.getRow5().get(5).getId();
        tile2.getRow1().get(3).getNeighbours()[0] = tile3.getRow4().get(6).getId();
        tile2.getRow1().get(4).getNeighbours()[5] = tile3.getRow4().get(6).getId();

        tile3.getRow7().get(3).getNeighbours()[3] = tile2.getRow1().get(0).getId();
        tile3.getRow7().get(3).getNeighbours()[2] = tile2.getRow1().get(1).getId();
        tile3.getRow6().get(4).getNeighbours()[3] = tile2.getRow1().get(1).getId();
        tile3.getRow6().get(4).getNeighbours()[2] = tile2.getRow1().get(2).getId();
        tile3.getRow5().get(5).getNeighbours()[3] = tile2.getRow1().get(2).getId();
        tile3.getRow5().get(5).getNeighbours()[2] = tile2.getRow1().get(3).getId();
        tile3.getRow4().get(6).getNeighbours()[3] = tile2.getRow1().get(3).getId();
        tile3.getRow4().get(6).getNeighbours()[2] = tile2.getRow1().get(4).getId();

        tile3.getRow1().get(0).getNeighbours()[0] = tile4.getRow7().get(0).getId();
        tile3.getRow1().get(1).getNeighbours()[5] = tile4.getRow7().get(0).getId();
        tile3.getRow1().get(1).getNeighbours()[0] = tile4.getRow7().get(1).getId();
        tile3.getRow1().get(2).getNeighbours()[5] = tile4.getRow7().get(1).getId();
        tile3.getRow1().get(2).getNeighbours()[0] = tile4.getRow7().get(2).getId();
        tile3.getRow1().get(3).getNeighbours()[5] = tile4.getRow7().get(2).getId();
        tile3.getRow1().get(3).getNeighbours()[0] = tile4.getRow7().get(3).getId();

        tile4.getRow7().get(3).getNeighbours()[3] = tile3.getRow1().get(0).getId();
        tile4.getRow7().get(3).getNeighbours()[2] = tile3.getRow1().get(1).getId();
        tile4.getRow7().get(2).getNeighbours()[3] = tile3.getRow1().get(1).getId();
        tile4.getRow7().get(2).getNeighbours()[2] = tile3.getRow1().get(2).getId();
        tile4.getRow7().get(1).getNeighbours()[3] = tile3.getRow1().get(2).getId();
        tile4.getRow7().get(1).getNeighbours()[2] = tile3.getRow1().get(3).getId();
        tile4.getRow7().get(0).getNeighbours()[3] = tile3.getRow1().get(3).getId();

        tile4.getRow1().get(0).getNeighbours()[0] = tile5.getRow4().get(0).getId();
        tile4.getRow1().get(1).getNeighbours()[5] = tile5.getRow4().get(0).getId();
        tile4.getRow1().get(1).getNeighbours()[0] = tile5.getRow5().get(0).getId();
        tile4.getRow1().get(2).getNeighbours()[5] = tile5.getRow5().get(0).getId();
        tile4.getRow1().get(2).getNeighbours()[0] = tile5.getRow6().get(0).getId();
        tile4.getRow1().get(3).getNeighbours()[5] = tile5.getRow6().get(0).getId();
        tile4.getRow1().get(3).getNeighbours()[0] = tile5.getRow7().get(0).getId();

        tile5.getRow4().get(0).getNeighbours()[4] = tile4.getRow1().get(0).getId();
        tile5.getRow4().get(0).getNeighbours()[3] = tile4.getRow1().get(1).getId();
        tile5.getRow5().get(0).getNeighbours()[4] = tile4.getRow1().get(1).getId();
        tile5.getRow5().get(0).getNeighbours()[3] = tile4.getRow1().get(2).getId();
        tile5.getRow6().get(0).getNeighbours()[4] = tile4.getRow1().get(2).getId();
        tile5.getRow6().get(0).getNeighbours()[3] = tile4.getRow1().get(3).getId();
        tile5.getRow7().get(0).getNeighbours()[4] = tile4.getRow1().get(3).getId();

        tile5.getRow7().get(0).getNeighbours()[2] = tile6.getRow3().get(4).getId();
        tile5.getRow7().get(1).getNeighbours()[3] = tile6.getRow3().get(4).getId();
        tile5.getRow7().get(1).getNeighbours()[2] = tile6.getRow3().get(3).getId();
        tile5.getRow7().get(2).getNeighbours()[3] = tile6.getRow3().get(3).getId();
        tile5.getRow7().get(2).getNeighbours()[2] = tile6.getRow3().get(2).getId();
        tile5.getRow7().get(3).getNeighbours()[3] = tile6.getRow3().get(2).getId();
        tile5.getRow7().get(4).getNeighbours()[2] = tile6.getRow3().get(1).getId();

        tile6.getRow3().get(4).getNeighbours()[2] = tile5.getRow7().get(0).getId();
        tile6.getRow3().get(4).getNeighbours()[3] = tile5.getRow7().get(1).getId();
        tile6.getRow3().get(3).getNeighbours()[2] = tile5.getRow7().get(1).getId();
        tile6.getRow3().get(3).getNeighbours()[3] = tile5.getRow7().get(2).getId();
        tile6.getRow3().get(2).getNeighbours()[2] = tile5.getRow7().get(2).getId();
        tile6.getRow3().get(2).getNeighbours()[3] = tile5.getRow7().get(3).getId();
        tile6.getRow3().get(1).getNeighbours()[2] = tile5.getRow7().get(3).getId();

        tile6.getRow1().get(0).getNeighbours()[0] = tile7.getRow4().get(6).getId();
        tile6.getRow1().get(1).getNeighbours()[5] = tile7.getRow4().get(6).getId();
        tile6.getRow1().get(1).getNeighbours()[0] = tile7.getRow3().get(5).getId();
        tile6.getRow1().get(2).getNeighbours()[5] = tile7.getRow3().get(5).getId();
        tile6.getRow1().get(2).getNeighbours()[0] = tile7.getRow2().get(4).getId();
        tile6.getRow1().get(3).getNeighbours()[5] = tile7.getRow2().get(4).getId();
        tile6.getRow1().get(3).getNeighbours()[0] = tile7.getRow1().get(3).getId();
        tile6.getRow1().get(4).getNeighbours()[5] = tile7.getRow1().get(3).getId();

        tile7.getRow1().get(3).getNeighbours()[0] = tile6.getRow1().get(4).getId();
        tile7.getRow1().get(3).getNeighbours()[1] = tile6.getRow1().get(3).getId();
        tile7.getRow2().get(4).getNeighbours()[0] = tile6.getRow1().get(3).getId();
        tile7.getRow2().get(4).getNeighbours()[1] = tile6.getRow1().get(2).getId();
        tile7.getRow3().get(5).getNeighbours()[0] = tile6.getRow1().get(2).getId();
        tile7.getRow3().get(5).getNeighbours()[1] = tile6.getRow1().get(1).getId();
        tile7.getRow1().get(6).getNeighbours()[0] = tile6.getRow1().get(1).getId();
        tile7.getRow4().get(6).getNeighbours()[1] = tile6.getRow1().get(0).getId();

        tile7.getRow6().get(0).getNeighbours()[2] = tile8.getRow1().get(2).getId();
        tile7.getRow7().get(0).getNeighbours()[2] = tile8.getRow1().get(0).getId();
        tile7.getRow7().get(0).getNeighbours()[3] = tile8.getRow1().get(1).getId();
        tile7.getRow7().get(0).getNeighbours()[4] = tile8.getRow1().get(2).getId();
        tile7.getRow7().get(1).getNeighbours()[2] = tile8.getRow1().get(0).getId();

        tile8.getRow1().get(0).getNeighbours()[3] = tile7.getRow7().get(1).getId();
        tile8.getRow1().get(0).getNeighbours()[2] = tile7.getRow7().get(0).getId();
        tile8.getRow1().get(1).getNeighbours()[3] = tile7.getRow7().get(0).getId();
        tile8.getRow1().get(2).getNeighbours()[3] = tile7.getRow7().get(0).getId();
        tile8.getRow1().get(2).getNeighbours()[2] = tile7.getRow6().get(1).getId();


        //EndTile
        endTile = new long[3];
        endTile[0]= tile8.getRow1().get(0).getId();
        endTile[1]= tile8.getRow1().get(1).getId();
        endTile[2]= tile8.getRow1().get(2).getId();

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

    @Override
    public long[] getEndTile(){
        return endTile;
    }
    @Override
    public  long[] getStartingSpaces(){
        return  startSpaces;
    }
}
