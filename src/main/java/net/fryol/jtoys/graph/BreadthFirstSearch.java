package net.fryol.jtoys.graph;

import net.fryol.jtoys.lattice.Lattice;
import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {

    BreadthFirstSearch() {
        // dummy constructor
    }

    public static void bfs(Lattice lattice, Integer startVertex) {
        List<Integer> queue = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        Integer current;

        queue.add(startVertex);
        visited.add(startVertex);

        while(!queue.isEmpty()) {
            current = queue.removeLast();

            processVertex(current, lattice);

            for(Integer n: lattice.getNeighbors(current)) {
                if(!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }

    }

    private static void processVertex(int current, Lattice lattice) {
        
        // printing out all the edges in order from this current vertex
        StringBuilder latticeString = new StringBuilder();
        
        latticeString.append(current + " -> ");
        for(Edge e : lattice.getEdges(current)) {
            while(e!=null) {
                latticeString.append(e.getEnd() + " -> ");
                e = e.getNext();
            }
            latticeString.append("." + System.lineSeparator());
        }
        System.out.println(latticeString);
    }
}