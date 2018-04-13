package ch.uzh.ifi.seal.soprafs18.entity;

public class DemoMap extends Map {

    public DemoMap{

        //Tile A
        Space a1	=	new Space(	1	,"green",	0,	false);
        Space a2	=	new Space(	2	,"green",	0,	false);
        Space a3	=	new Space(	3	,"green",	0,	false);
        Space a4	=	new Space(	4	,"green",	0,	false);
        Space a5	=	new Space(	5	,"green",	1,	false);
        Space a6	=	new Space(	6	,"green",	1,	false);
        Space a7	=	new Space(	7	,"green",	1,	false);
        Space a8	=	new Space(	8	,"green",	1,	false);
        Space a9	=	new Space(	9	,"green",	1,	false);
        Space a10	=	new Space(	10	,"green",	1,	false);
        Space a11	=	new Space(	11	,"green",	1,	false);
        Space a12	=	new Space(	12	,"yellow",	1,	false);
        Space a13	=	new Space(	13	,"green",	1,	false);
        Space a14	=	new Space(	14	,"blue",	1,	false);
        Space a15	=	new Space(	15	,"green",	1,	false);
        Space a16	=	new Space(	16	,"green",	1,	false);
        Space a17	=	new Space(	17	,"yellow",	1,	false);
        Space a18	=	new Space(	18	,"green",	1,	false);
        Space a19	=	new Space(	19	,"blue",	1,	false);
        Space a20	=	new Space(	20	,"green",	1,	false);
        Space a21	=	new Space(	21	,"yellow",	1,	false);
        Space a22	=	new Space(	22	,"green",	1,	false);
        Space a23	=	new Space(	23	,"green",	1,	false);
        Space a24	=	new Space(	24	,"black",	0,	false);
        Space a25	=	new Space(	25	,"yellow",	1,	false);
        Space a26	=	new Space(	26	,"green",	1,	false);
        Space a27	=	new Space(	27	,"green",	1,	false);
        Space a28	=	new Space(	28	,"green",	1,	false);
        Space a29	=	new Space(	29	,"yellow",	1,	false);
        Space a30	=	new Space(	30	,"green",	1,	false);
        Space a31	=	new Space(	31	,"green",	1,	false);
        Space a32	=	new Space(	32	,"black",	0,	false);
        Space a33	=	new Space(	33	,"blue",	1,	false);
        Space a34	=	new Space(	34	,"green",	1,	false);
        Space a35	=	new Space(	35	,"red",	    0,	false);
        Space a36	=	new Space(	36	,"green",	1,	false);
        Space a37	=	new Space(	37	,"green",	1,	false);
        //Tile T
        Space t583	=	new Space(	583	,"green",	1,	false);
        Space t584	=	new Space(	584	,"green",	1,	false);
        Space t585	=	new Space(	585	,"green",	1,	false);

        //Setting neighbours
        a1	.setNeighbours(	a6	,	a8	,	null	,	null	,	null	,	null	);
        a2	.setNeighbours(	a8	,	a7	,	null	,	null	,	null	,	null	);
        a3	.setNeighbours(	a7	,	a6	,	null	,	null	,	null	,	null	);
        a4	.setNeighbours(	a6	,	a5	,	null	,	null	,	null	,	null	);
        a5	.setNeighbours(	a6	,	a14	,	a15	,	null	,	null	,	null	);
        a6	.setNeighbours(	a7	,	a13	,	a14	,	a5	,	null	,	null	);
        a7	.setNeighbours(	a8	,	a12	,	a13	,	a6	,	null	,	null	);
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
        a29	.setNeighbours(	a30	,	a37	,	t583	,	t584	,	a28	,	a27	);
        a30	.setNeighbours(	a30	,	a36	,	a37	,	a29	,	a27	,	a26	);
        a31	.setNeighbours(	a32	,	a35	,	a36	,	a30	,	a26	,	a25	);
        a32	.setNeighbours(	a33	,	a34	,	a35	,	a31	,	a25	,	a24	);
        a33	.setNeighbours(	null	,	null	,	a34	,	a32	,	a24	,	a23	);
        a34	.setNeighbours(	null	,	null	,	null	,	a35	,	a32	,	a33	);
        a35	.setNeighbours(	a34	,	null	,	null	,	a36	,	a31	,	a32	);
        a36	.setNeighbours(	a35	,	null	,	null	,	a37	,	a30	,	a31	);
        a37	.setNeighbours(	a36	,	null	,	null	,	t583	,	a29	,	a30	);
        //Setting neighbours of T
        t583.setNeighbours(a37,null,null,null,null,a29);
        t584.setNeighbours(a29,t583,null,null,null,a28);
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








    }
}
