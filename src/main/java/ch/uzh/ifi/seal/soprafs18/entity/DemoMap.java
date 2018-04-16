package ch.uzh.ifi.seal.soprafs18.entity;

public class DemoMap extends Map {

    public DemoMap(){

        //Tile A
        Tile tile1 = new Tile();
        tile1.setNextTilePos(1);
        tile1.setRotarion(-60);

<<<<<<< HEAD
        //Setting neighbours
        a1	.setNeighbours(	a6	,	a8	,	null	,	null	,	null	,	null	);
        a2	.setNeighbours(	a8	,	a7	,	null	,	null	,	null	,	null	);
        a3	.setNeighbours(	a7	,	a6	,	null	,	null	,	null	,	null	);
        a4	.setNeighbours(	a6	,	a5	,	null	,	null	,	null	,	null	);
        a5	.setNeighbours(	a6	,	a14	,	a15	,	null	,	null	,	null	);
        a6	.setNeighbours(	a7	,	a13	,	a14	,	a5	,	null	,	null	);
        a7	.setNeighbours(	a8	,	a12	,	a13	,	a6	,	null	,	null    );
        a8	.setNeighbours(	a9	,	a11	,	a12	,	a7	,	null	,	null	);
        a9	.setNeighbours(	null	,	a10	,	a11	,	a8	,	null	,	null	);
        a10	.setNeighbours(	null	,	a22	,	a21	,	a11	,	a9	,	null	);
        a11	.setNeighbours(	a10	,	a21	,	a20	,	a12	,	a8	,	a9	);
        a12	.setNeighbours(	a11	,	a20	,	a19	,	a13	,	a7	,	a8	);
        a13	.setNeighbours(	a12	,	a19	,	a18	,	a14	,	a6	,	a7	);
        a14	.setNeighbours(	a13	,	a18	,	a17	,	a15	,	a5	,	a6	);
        a15	.setNeighbours(	a14	,	a17	,	a16	,	null	,	null	,	a5	);
        a16	.setNeighbours(	a17	,	a18	,	t585	,	null	,	null	,	a15	);
        a17	.setNeighbours(	a18	,	a27	,	a28	,	a16	,	a15	,	a14	);
        a18	.setNeighbours(	a19	,	a26	,	a27	,	a17	,	a14	,	a13	);
        a19	.setNeighbours(	a20	,	a25	,	a26	,	a18	,	a13	,	a12	);
        a20	.setNeighbours(	a21	,	a24	,	a25	,	a19	,	a12	,	a11	);
        a21	.setNeighbours(	a22	,	a23	,	a24	,	a20	,	a11	,	a10	);
        a22	.setNeighbours(	null	,	null	,	a23	,	a21	,	a10	,	null	);
        a23	.setNeighbours(	null	,	null	,	a33	,	a24	,	a21	,	a22	);
        a24	.setNeighbours(	a23	,	a33	,	a32	,	a25	,	a20	,	a21	);
        a25	.setNeighbours(	a24	,	a32	,	a31	,	a26	,	a19	,	a20	);
        a26	.setNeighbours(	a25	,	a31	,	a30	,	a27	,	a18	,	a19	);
        a27	.setNeighbours(	a26	,	a30	,	a29	,	a28	,	a17	,	a18	);
        a28	.setNeighbours(	a27	,	a29	,	t584	,	t585	,	a16	,	a17	);
        a29	.setNeighbours(	a30	,	a37	,	null	,	t584	,	a28	,	a27	);
        a30	.setNeighbours(	a30	,	a36	,	a37	,	a29	,	a27	,	a26	);
        a31	.setNeighbours(	a32	,	a35	,	a36	,	a30	,	a26	,	a25	);
        a32	.setNeighbours(	a33	,	a34	,	a35	,	a31	,	a25	,	a24	);
        a33	.setNeighbours(	null	,	null	,	a34	,	a32	,	a24	,	a23	);
        a34	.setNeighbours(	null	,	null	,	null	,	a35	,	a32	,	a33	);
        a35	.setNeighbours(	a34	,	null	,	null	,	a36	,	a31	,	a32	);
        a36	.setNeighbours(	a35	,	null	,	null	,	a37	,	a30	,	a31	);
        a37	.setNeighbours(	a36	,	null	,	null	,	null	,	a29	,	a30	);
        //Setting neighbours of T
        t584.setNeighbours(a29,null,null,null,null,a28);
        t585.setNeighbours(a28,t584,null,null,null,a16);

        //Filling spaces in arraylist "spaces"
        spaces.add(	 a1	);
        spaces.add(	 a2	);
        spaces.add(	 a3	);
        spaces.add(	 a4	);
        spaces.add(	 a5	);
        spaces.add(	 a6	);
        spaces.add(	 a7	);
        spaces.add(	 a8	);
        spaces.add(	 a9	);
        spaces.add(	 a10	);
        spaces.add(	 a11	);
        spaces.add(	 a12	);
        spaces.add(	 a13	);
        spaces.add(	 a14	);
        spaces.add(	 a15	);
        spaces.add(	 a16	);
        spaces.add(	 a17	);
        spaces.add(	 a18	);
        spaces.add(	 a19	);
        spaces.add(	 a20	);
        spaces.add(	 a21	);
        spaces.add(	 a22	);
        spaces.add(	 a23	);
        spaces.add(	 a24	);
        spaces.add(	 a25	);
        spaces.add(	 a26	);
        spaces.add(	 a27	);
        spaces.add(	 a28	);
        spaces.add(	 a29	);
        spaces.add(	 a30	);
        spaces.add(	 a31	);
        spaces.add(	 a32	);
        spaces.add(	 a33	);
        spaces.add(	 a34	);
        spaces.add(	 a35	);
        spaces.add(	 a36	);
        spaces.add(	 a37	);

        //setting StartingSpaces
        startingSpaceP1 = a1;
        startingSpaceP2 = a2;
        startingSpaceP3 = a3;
        startingSpaceP4 = a4;







=======
        Space	a1	=	new Space(	"	green	",	1	,	false);
        Space	a2	=	new Space(	"	red	    ",	1	,	false);
        Space	a3	=	new Space(	"	green	",	1	,	false);
        Space	a4	=	new Space(	"	green	",	1	,	false);
        Space	a5	=	new Space(	"	blue	",	1	,	false);
        Space	a6	=	new Space(	"	black	",	0	,	false);
        Space	a7	=	new Space(	"	green	",	1	,	false);
        Space	a8	=	new Space(	"	green	",	1	,	false);
        Space	a9	=	new Space(	"	yellow	",	1	,	false);
        Space	a10	=	new Space(	"	green	",	1	,	false);
        Space	a11	=	new Space(	"	black	",	0	,	false);
        Space	a12	=	new Space(	"	yellow	",	1	,	false);
        Space	a13	=	new Space(	"	green	",	1	,	false);
        Space	a14	=	new Space(	"	green	",	1	,	false);
        Space	a15	=	new Space(	"	green	",	1	,	false);
        Space	a16	=	new Space(	"	green	",	1	,	false);
        Space	a17	=	new Space(	"	yellow	",	1	,	false);
        Space	a18	=	new Space(	"	green	",	1	,	false);
        Space	a19	=	new Space(	"	blue	",	1	,	false);
        Space	a20	=	new Space(	"	green	",	1	,	false);
        Space	a21	=	new Space(	"	yellow	",	1	,	false);
        Space	a22	=	new Space(	"	green	",	1	,	false);
        Space	a23	=	new Space(	"	green	",	1	,	false);
        Space	a24	=	new Space(	"	green	",	1	,	false);
        Space	a25	=	new Space(	"	yellow	",	1	,	false);
        Space	a26	=	new Space(	"	green	",	1	,	false);
        Space	a27	=	new Space(	"	blue	",	1	,	false);
        Space	a28	=	new Space(	"	green	",	1	,	false);
        Space	a29	=	new Space(	"	green	",	1	,	false);
        Space	a30	=	new Space(	"	green	",	1	,	false);
        Space	a31	=	new Space(	"	green	",	1	,	false);
        Space	a32	=	new Space(	"	green	",	1	,	false);
        Space	a33	=	new Space(	"	green	",	1	,	false);
        Space	a34	=	new Space(	"	green	",	0	,	false);
        Space	a35	=	new Space(	"	green	",	0	,	false);
        Space	a36	=	new Space(	"	green	",	0	,	false);
        Space	a37	=	new Space(	"	green	",	0	,	false);
        //fill rows
        tile1	.addRow1(	a1	);
        tile1	.addRow1(	a2	);
        tile1	.addRow1(	a3	);
        tile1	.addRow1(	a4	);
        tile1	.addRow2(	a5	);
        tile1	.addRow2(	a6	);
        tile1	.addRow2(	a7	);
        tile1	.addRow2(	a8	);
        tile1	.addRow2(	a9	);
        tile1	.addRow3(	a10	);
        tile1	.addRow3(	a11	);
        tile1	.addRow3(	a12	);
        tile1	.addRow3(	a13	);
        tile1	.addRow3(	a14	);
        tile1	.addRow3(	a15	);
        tile1	.addRow4(	a16	);
        tile1	.addRow4(	a17	);
        tile1	.addRow4(	a18	);
        tile1	.addRow4(	a19	);
        tile1	.addRow4(	a20	);
        tile1	.addRow4(	a21	);
        tile1	.addRow4(	a22	);
        tile1	.addRow5(	a23	);
        tile1	.addRow5(	a24	);
        tile1	.addRow5(	a25	);
        tile1	.addRow5(	a26	);
        tile1	.addRow5(	a27	);
        tile1	.addRow5(	a28	);
        tile1	.addRow6(	a29	);
        tile1	.addRow6(	a30	);
        tile1	.addRow6(	a31	);
        tile1	.addRow6(	a32	);
        tile1	.addRow6(	a33	);
        tile1	.addRow7(	a34	);
        tile1	.addRow7(	a35	);
        tile1	.addRow7(	a36	);
        tile1	.addRow7(	a37	);

        //Tile C
        Tile tile2 = new Tile();
        tile2.setNextTilePos(1);
        tile2.setRotarion(-240);

        Space 	c1	=	new Space(	"	green	",	1	,	false);
        Space 	c2	=	new Space(	"	green	",	1	,	false);
        Space 	c3	=	new Space(	"	grey	",	1	,	false);
        Space 	c4	=	new Space(	"	grey	",	1	,	false);
        Space 	c5	=	new Space(	"	green	",	1	,	false);
        Space 	c6	=	new Space(	"	yellow	",	1	,	false);
        Space 	c7	=	new Space(	"	grey	",	1	,	false);
        Space 	c8	=	new Space(	"	blue	",	1	,	false);
        Space 	c9	=	new Space(	"	blue	",	1	,	false);
        Space 	c10	=	new Space(	"	blue	",	1	,	false);
        Space 	c11	=	new Space(	"	blue	",	1	,	false);
        Space 	c12	=	new Space(	"	yellow	",	1	,	false);
        Space 	c13	=	new Space(	"	yellow	",	1	,	false);
        Space 	c14	=	new Space(	"	grey	",	1	,	false);
        Space 	c15	=	new Space(	"	blue	",	1	,	false);
        Space 	c16	=	new Space(	"	blue	",	1	,	false);
        Space 	c17	=	new Space(	"	yellow	",	1	,	false);
        Space 	c18	=	new Space(	"	yellow	",	1	,	false);
        Space 	c19	=	new Space(	"	yellow	",	0	,	false);
        Space 	c20	=	new Space(	"	blue	",	1	,	false);
        Space 	c21	=	new Space(	"	grey	",	1	,	false);
        Space 	c22	=	new Space(	"	grey	",	1	,	false);
        Space 	c23	=	new Space(	"	yellow	",	1	,	false);
        Space 	c24	=	new Space(	"	grey	",	1	,	false);
        Space 	c25	=	new Space(	"	blue	",	1	,	false);
        Space 	c26	=	new Space(	"	blue	",	1	,	false);
        Space 	c27	=	new Space(	"	yellow	",	1	,	false);
        Space 	c28	=	new Space(	"	yellow	",	1	,	false);
        Space 	c29	=	new Space(	"	yellow	",	1	,	false);
        Space 	c30	=	new Space(	"	grey	",	1	,	false);
        Space 	c31	=	new Space(	"	yellow	",	1	,	false);
        Space 	c32	=	new Space(	"	yellow	",	1	,	false);
        Space 	c33	=	new Space(	"	blue	",	1	,	false);
        Space 	c34	=	new Space(	"	yellow	",	1	,	false);
        Space 	c35	=	new Space(	"	yellow	",	1	,	false);
        Space 	c36	=	new Space(	"	blue	",	1	,	false);
        Space 	c37	=	new Space(	"	blue	",	1	,	false);
        //fill rows
        tile2	.addRow1(	c1	);
        tile2	.addRow1(	c2	);
        tile2	.addRow1(	c3	);
        tile2	.addRow1(	c4	);
        tile2	.addRow2(	c5	);
        tile2	.addRow2(	c6	);
        tile2	.addRow2(	c7	);
        tile2	.addRow2(	c8	);
        tile2	.addRow2(	c9	);
        tile2	.addRow3(	c10	);
        tile2	.addRow3(	c11	);
        tile2	.addRow3(	c12	);
        tile2	.addRow3(	c13	);
        tile2	.addRow3(	c14	);
        tile2	.addRow3(	c15	);
        tile2	.addRow4(	c16	);
        tile2	.addRow4(	c17	);
        tile2	.addRow4(	c18	);
        tile2	.addRow4(	c19	);
        tile2	.addRow4(	c20	);
        tile2	.addRow4(	c21	);
        tile2	.addRow4(	c22	);
        tile2	.addRow5(	c23	);
        tile2	.addRow5(	c24	);
        tile2	.addRow5(	c25	);
        tile2	.addRow5(	c26	);
        tile2	.addRow5(	c27	);
        tile2	.addRow5(	c28	);
        tile2	.addRow6(	c29	);
        tile2	.addRow6(	c30	);
        tile2	.addRow6(	c31	);
        tile2	.addRow6(	c32	);
        tile2	.addRow6(	c33	);
        tile2	.addRow7(	c34	);
        tile2	.addRow7(	c35	);
        tile2	.addRow7(	c36	);
        tile2	.addRow7(	c37	);
>>>>>>> Map

    }
}
