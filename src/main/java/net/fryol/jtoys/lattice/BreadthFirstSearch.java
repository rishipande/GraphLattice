package net.fryol.jtoys.lattice;

import net.fryol.jtoys.graph.Edge;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {

    BreadthFirstSearch() {
        // dummy constructor
    }

    public static boolean bfs(Lattice lattice, Integer startVertex, Integer srch) {
        List<Integer> queue = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        Integer current;

        queue.add(startVertex);
        visited.add(startVertex);

        while(!queue.isEmpty()) {
            current = queue.removeLast();

            if(found(current, srch)) {
                return true;
            }

            for(Integer n: lattice.getNeighbors(current)) {
                if(!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
        return false;
    }

    private static boolean found(Integer curr, Integer srch) {
        return curr.equals(srch);
    }


    // this is an excellent example of badly written, untestable code
    // will leave this here for the future to see if someone sees this
    // and sends a PR on it, to refactor this so that it is testable
    @SuppressWarnings("unused")
    private static void printEdges(int current, Lattice lattice) {
        
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