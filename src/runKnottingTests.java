public class runKnottingTests {

    //Main function to run tests:
    // - nV is the number of Vertices,
    // - nE is the number of Edges.
    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            /*        BASIC GRAPHS, parameters: String algorithm: algorithm type */
//            testBasicCases.runBasicTests("Knotting");


            /* ------------------------Vertex----------------------------*/

            /* Test general variation in vertices */
            int seedRandom = 1;
            for (int nV = 2; nV <= 1000; nV ++){
                    testRandomGraph.run("Knotting", nV, 1, seedRandom);
                    seedRandom++;
            }

            /* BIPARTITE EVEN PARTITION: */
//            for (int nV = 2; nV <= 32; nV++){
//                testBipartiteGraph.run("Knotting", nV, 1, 2);
//            }
////
//            /* BIPARTITE 1/3 PARTITION: */
//            for (int nV = 3; nV <= 32; nV++){
//                testBipartiteGraph.run("Knotting", nV, 1, 3);
//            }
////
////            /* BIPARTITE 1/4 PARTITION: */
//            for (int nV = 4; nV <= 32; nV++){
//                testBipartiteGraph.run("Knotting", nV, 1, 4);
//            }
////
////
//            /* BIPARTITE 1/10 PARTITION: */
//            for (int nV = 10; nV <= 100; nV+=10){
//                testBipartiteGraph.run("Knotting", nV, 1, 10);
//            }
//
//            /* BIPARTITE 1/100 PARTITION: */
//            for (int nV = 100; nV <= 1000; nV += 100) {
//                testBipartiteGraph.run("Knotting", nV, 1, 100);
//            }

            /* Test reflexive graph */
//            int seedReflexive = 1;
//            for (int nV = 2; nV <= 64; nV++) {
//                testReflexiveGraph.run("Knotting", nV, 1, seedReflexive);
//                seedReflexive++;
//            }
//
//
//
//            int seedSymmetric = 1;
//            for (int nV = 2; nV <= 64; nV++) {
//                testSymmetricGraph.run("Knotting", nV, 1, seedSymmetric);
//                seedSymmetric++;
//            }

            /* ------------------------Edge----------------------------*/

            /* Test general variation in edges */
//            int seedRandom2 = 1;
//            for (int nE = 0; nE <= (32*(32-1))/2; nE++){
//                testRandomGraph.run("Knotting", 32, nE, seedRandom2);
//                seedRandom2++;
//            }

            /* BIPARTITE EVEN PARTITION: */
//            for (int nE = 1; nE <= (32*(32-1))/4; nE++){
//                testBipartiteGraph.run("Knotting", 32, nE, 2);
//            }
////
//            /* BIPARTITE 1/3 PARTITION: */
//            for (int nE = 1; nE <= (32*(32-1))/6; nE++){
//                testBipartiteGraph.run("Knotting", 32, nE, 3);
//            }
//////
//////            /* BIPARTITE 1/4 PARTITION: */
//            for (int nE = 1; nE <= (32*(32-1))/8; nE+=2){
//                testBipartiteGraph.run("Knotting", 32, nE, 4);
//            }
//////
//////
////            /* BIPARTITE 1/10 PARTITION: */
//            for (int nE = 1; nE <= (50*(50-1))/20; nE++){
//                testBipartiteGraph.run("Knotting", 50, nE, 10);
//            }
//////
//
////
////            /* Test reflexive graph */
//            int seedReflexive = 1;
//            for (int nE = 1; nE <= (16*(16-1))/2; nE++){
//                testReflexiveGraph.run("Knotting", 16, nE, seedReflexive);
//                seedReflexive++;
//            }
//////
//////
//////
//            int seedSymmetric = 1;
//            for (int nE = 1; nE <= (16*(16-1))/2; nE++){
//                testSymmetricGraph.run("Knotting", 16, nE, seedSymmetric);
//                seedSymmetric++;
//            }



            /* ------------------------V/E----------------------------*/

            /* Test general cases*/

            /*              COMPLETE graph test*/
//            for (int v = 0; v <= 50; v++) {
//                testCompleteGraph.run("Knotting", v);
//            }

            /*             Grid graph N * N:        */
//            for (int row = 2; row <= 15; row++) {
//                testGridGraph.run("Knotting", row, row);
//            }

//            /* Grid graph N * M, M is small = 4 */
//            for (int col = 2; col <= 15; col++) {
//                testGridGraph.run("Knotting", 4, col);
//            }

//            /* Grid graph N * M, M is large = 40*/
//            for (int col = 2; col <= 15; col++) {
//                testGridGraph.run("Knotting", 20, col);
//            }


            /*             Grid Variation graph N * N:        */
//            for (int row = 2; row <= 15; row++) {
//                testGridGraphVariation.run("Knotting", row, row);
//            }

            /* Grid graph N * M, M is small = 4 */
//            for (int col = 2; col <= 15; col++) {
//                testGridGraphVariation.run("Knotting", 4, col);
//            }
//
            /* Grid graph N * M, M is large = 40*/
//            for (int col = 2; col <= 15; col++) {
//                testGridGraphVariation.run("Knotting", 20, col);
//            }

            /* BIPARTITE EVEN PARTITION: */
//            for (int nV = 10; nV <= 25; nV+=2){
//                for (int nE = 0; nE < (nV*nV)/4; nE+=10) {
//                    testBipartiteGraph.run("Knotting", nV, nE, 2);
//                }
//            }

            /* BIPARTITE 1/3 PARTITION: */
//            for (int nV = 15; nV <= 25; nV+=3){
//                for (int nE = 0; nE < (nV*nV)/9; nE+=10) {
//                    testBipartiteGraph.run("Knotting", nV, nE, 3);
//                }
//            }

            /* BIPARTITE 1/4 PARTITION: */
//            for (int nV = 16; nV <= 30; nV++){
//                for (int nE = 0; nE < (nV*nV)/16; nE+=10) {
//                    testBipartiteGraph.run("Knotting", nV, nE, 4);
//                }
//            }


            /* BIPARTITE 1/10 PARTITION: */
//            for (int nV = 10; nV <= 80; nV++){
//                for (int nE = 0; nE < (nV*nV)/100; nE+=10) {
//                    testBipartiteGraph.run("Knotting", nV, nE, 10);
//                }
//            }
//
//            /* BIPARTITE 1/100 PARTITION: */
//            for (int nV = 0; nV <= 300; nV += 50) {
//                for (int nE = 0; nE < (nV * nV) / 1000; nE += 10) {
//                    testBipartiteGraph.run("Knotting", nV, nE, 100);
//                }
//            }


            /* Test edge cases */
            //Test empty graphs, parameters: String algorithm: algorithm type, Int nV: number of vertices
//            testEmptyGraph.run("Knotting", 32);

            //Test singleton graph: parameter: String algorithm: algorithm type
//            testSingletonGraph.run("Knotting");
//

//            /* Test random variation in V/E */
////            int seedRandom3 = 1;
////            for (int nV=0; nV<=16; nV++){
////                for (int nE=0; nE<= (nV*(nV-1)/2); nE++){
////                    testRandomGraph.run("Knotting", nV, nE, seedRandom3);
////                }
////            }


            /* Test reflexive graph */
//            int seedReflexive = 0;
//            for (int nV = 2; nV <= 16; nV *= 2) {
//                for (int nE = 1; nE <= (nV * (nV - 1) / 2); nE++) {
//                    testReflexiveGraph.run("Knotting", nV, nE, seedReflexive);
//                    seedReflexive++;
//                }
//            }
////
//////            Test symmetric graph
//            int seedSymmetric = 0;
//            for (int nV = 2; nV <= 16; nV *= 2) {
//                for (int nE = 1; nE <= (nV * (nV - 1) / 2); nE++) {
//                    testSymmetricGraph.run("Knotting", nV, nE, seedSymmetric);
//                    seedSymmetric++;
//                }
//            }

        }
    }
}
