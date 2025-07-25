public class runGammaTests {

    //Main function to run tests:
    // - nV is the number of Vertices,
    // - nE is the number of Edges.
    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {

            /*        BASIC GRAPHS, parameters: String algorithm: algorithm type */
//            testBasicCases.runBasicTests("Gamma");

//            /* Test variation in vertices */
//            int seedRandom = 1;
//            for (int nV = 0; nV <= 1000; nV ++){
//                    testRandomGraph.run("Gamma", nV, 0, seedRandom);
//                    seedRandom++;
//            }

            /* Test variation in edges */
            int seedRandom2 = 1;
            for (int nE = 0; nE <= (32*(32-1))/2; nE++){
                testRandomGraph.run("Gamma", 100, nE, seedRandom2);
                seedRandom2++;
            }


            /* Test the general cases*/


/*              COMPLETE graph test*/
//            for (int v = 0; v <= 100; v++) {
//                testCompleteGraph.run("Gamma", v);
//            }



/*             Grid graph N * N:        */
//            for (int row = 2; row <= 25; row++) {
//                testGridGraph.run("Gamma", row, row);
//            }
//            /* Grid graph N * M, M is small = 4 */
//            for (int col = 2; col <= 25; col++) {
//                testGridGraph.run("Gamma", 4, col);
//            }
//            /* Grid graph N * M, M is large = 40*/
//            for (int col = 2; col <= 25; col++) {
//                testGridGraph.run("Gamma", 40, col);
//            }



            /*             Grid Variation graph N * N:        */
//            for (int row = 2; row <= 25; row++) {
//                testGridGraphVariation.run("Gamma", row, row);
//            }

            /* Grid graph N * M, M is small = 4 */
//            for (int col = 2; col <= 25; col++) {
//                testGridGraphVariation.run("Gamma", 4, col);
//            }

            /* Grid graph N * M, M is large = 40*/
//            for (int col = 2; col <= 25; col++) {
//                testGridGraphVariation.run("Gamma", 40, col);
//            }




/*        RANDOM graphs, parameters: String algorithm: algorithm type, Int nV: number of vertices, Int nE: number of edges */
//            int seedRandom = 1;
//            for (int nV = 2; nV <= 60; nV *= 2) {
//                for (int nE = 1; nE <= (nV * (nV - 1) / 2); nE++) {
//                    testRandomGraph.run("Gamma", nV, nE, seedRandom);
//                    seedRandom++;
//                }
//            }



            /* BIPARTITE EVEN PARTITION: */
//            for (int nV = 26; nV <= 50; nV+=2){
//                for (int nE = 0; nE < (nV*nV)/4; nE+=10) {
//                    testBipartiteGraph.run("Gamma", nV, nE, 2);
//                }
//            }

            /* BIPARTITE 1/3 PARTITION: */
//            for (int nV = 15; nV <= 60; nV+=3){
//                for (int nE = 0; nE < (nV*nV)/9; nE+=10) {
//                    testBipartiteGraph.run("Gamma", nV, nE, 3);
//                }
//            }

            /* BIPARTITE 1/4 PARTITION: */
//            for (int nV = 16; nV <= 72; nV++){
//                for (int nE = 0; nE < (nV*nV)/16; nE+=10) {
//                    testBipartiteGraph.run("Gamma", nV, nE, 4);
//                }
//            }

            /* BIPARTITE 1/10 PARTITION: */
//            for (int nV = 10; nV <= 100; nV++){
//                for (int nE = 0; nE < (nV*nV)/100; nE+=10) {
//                    testBipartiteGraph.run("Gamma", nV, nE, 10);
//                }
//            }
//
//            /* BIPARTITE 1/100 PARTITION: */
//            for (int nV = 1; nV <= 1000; nV+=100){
//                for (int nE = 0; nE < (nV*nV)/1000; nE+=10) {
//                    testBipartiteGraph.run("Gamma", nV, nE, 100);
//                }
//            }




            /* Test edge cases */
//            //Test empty graphs, parameters: String algorithm: algorithm type, Int nV: number of vertices
//            testEmptyGraph.run("Gamma", 32);
//
//            //Test singleton graph: parameter: String algorithm: algorithm type
//            testSingletonGraph.run("Gamma");
//
//
              /* Test reflexive graph */
//            int seedReflexive = 1;
//            for (int nV = 2; nV <= 60; nV *= 2) {
//                for (int nE = 1; nE <= (nV * (nV - 1) / 2); nE++) {
//                    testReflexiveGraph.run("Gamma", nV, nE, seedReflexive);
//                    seedReflexive++;
//                }
//            }
////
////            Test symmetric graph
//            int seedSymmetric = 1;
//            for (int nV = 2; nV <= 60; nV *= 2) {
//                for (int nE = 1; nE <= (nV * (nV - 1) / 2); nE++) {
//                    testSymmetricGraph.run("Gamma", nV, nE, seedSymmetric);
//                    seedSymmetric++;
//                }
//            }
        }
    }
}
