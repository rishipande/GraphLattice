package net.fryol.jtoys.lattice;

import net.fryol.jtoys.graph.Edge;
import net.fryol.jtoys.graph.Graph;


/**
 Lattice implementation is as follows:
  * basic property of a lattice is gridSize, because a lattice is a fancy name for a Grid
    visually, see: https://docs.google.com/spreadsheets/d/1IaD4jDjxDSilfn8B5lSHbYpKknjy5VBxxdLwEnrp10M
  * a lattice is a graph, so this is basically extending the net.fryol.jtoys.graph.Graph class.
  * the critical implementation here is in the initLattice() method, which creates all the
    vertices and the edges
  * every vertex (starting at 0), has two edges at most (except for the right most vertices,
    which have only one edge)
  * one edge connects horizontally to the next vertex, and one vertically down to the next
    vertex
  * a lattice is basically a directed graph, that only flows in one direction, from 0 to 1, 
    1 to 2, and so on; it cannot flow in the other direction (like 1 to 0)
  * the only overriden method is toString(), that can be used to examine the lattice if 
    you like
*/

public class Lattice extends Graph {
    private int gridSize; 

    Lattice(int gridSize) {
        super((int) Math.pow(((double)gridSize+1),2));
        this.gridSize = gridSize;
        initLattice();
    }

    private void initLattice() {
        int numVertices = super.getNumVertices();

        int additive = this.gridSize + 1;
        for(int i = 0; i < numVertices; i++) { 
            for(int j = i+1; j < numVertices; j++) {
                if( (j == (i+1) && !isRightMost(i, this.gridSize)) || (i+additive) < numVertices && j == (i+additive)) {
                    super.addEdge(i, new Edge(j));
                }
            }
        }
    }    

    private static boolean isRightMost(int vertex, int gridSize) {
        for(int i = vertex/gridSize; i<=gridSize; i++) {
            int rightMost = (gridSize+1) * i - 1;
            if(rightMost == vertex) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder latticeString = new StringBuilder();

        latticeString.append("Number of vertices: " + super.getNumVertices());
        latticeString.append(System.lineSeparator());
        latticeString.append("Number of edges: " + super.getNumEdges());
        //latticeString.append(allEdgesString());

        return latticeString.toString();
    }

    // another example of code that is untestable, will leave this here
    // to see if someone refactors this and sends a PR at some point
    @SuppressWarnings("unused")
    private String allEdgesString() {
        StringBuilder latticeString = new StringBuilder();

        for (Integer start : super.getEdges().keySet()) {
            Edge edge = super.getEdges().get(start);
            while(edge!=null) {
                latticeString.append(start);
                latticeString.append(" -> ");
                latticeString.append(edge.getEnd());
                latticeString.append(System.lineSeparator());
                edge = edge.getNext();
            }
        }
        return latticeString.toString();
    }
}
