package net.fryol.jtoys.lattice;

import net.fryol.jtoys.graph.Edge;
import java.util.ArrayList;
import java.util.List;


public class LatticeBuilder {
    public static void main(String[] a) {

        /** 
         This is where you modify the grid size: Lattice(gridSize).
        */
        Lattice newLattice = new Lattice(8);

        System.out.println(newLattice.toString());

        System.out.println("Possible paths: " + latticePaths(newLattice));
    }

    /**
     Calculates all the paths possible from the starting vertex (0), to
     the end of a lattice (or a grid)

     @param lattice
     @return int numberOfPathsPossible
    */
    public static int latticePaths(Lattice lattice) {
        int start = 0;

        List<Edge> stack = new ArrayList<>();
        List<Edge> edges = lattice.getEdges(start);
        Integer lastVertex = lattice.getNumVertices() - 1;
        Integer paths = 0;
        
        for (Edge edge : edges) {
            stack.add(edge);
        }
        
        while(!stack.isEmpty())
        {
            Edge e = stack.removeFirst();
            Integer nextVertex = e.getEnd();

            if(nextVertex.equals(lastVertex)) {
                paths++;
            } else {
                List<Edge> edges2 = lattice.getEdges(nextVertex);
                for (Edge edge : edges2) {
                    stack.add(edge);
                }
            }
        }
        return paths;
    }
}