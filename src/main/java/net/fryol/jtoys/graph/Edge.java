package net.fryol.jtoys.graph;

import java.util.Objects;

/**
 Edge implementation is as follows:
  * every Edge has has two properties: endVertex (where the edge ends), 
    and a next pointer, to the next Edge object (if needed), like in a 
    linked list
  * for startVertex: every Edge's start vertex is basically the index 
    of the net.fryol.jtoys.graph.Graph.HashMap<Integer Index, Edge this>
    and hence there is no representation for startVertex here to keep 
    things simple
  * 
*/

public class Edge {
    /**
      this is where the edge ends, the edge begins at the [index] number in
      the net.fryol.jtoys.graph.Graph class' HashMap<Int index, Edge this>
    */
    private int endVertex;

    /** 
     this is to indicate that there is a possibility of more than one edges
     and the Edge class is inherently a linked-list of such edges
    */
    Edge next; 

    public Edge(int j) {
        this.endVertex = j;
        this.next = null;
    }

    public int getEnd() {
        return this.endVertex;
    }

    /**
       A protected method to add an edge to a vertex that already has an edge(s).   

       Implementation Detail: there is another implementation of this (addEdge) in 
       the Graph class where you can call Graph.addNextEdge(startVertex, edge) - 
       which will find the appropriate vertex's_edge first, and then iterate until 
       it comes to a null, and then add it.
    */
    protected void addNextEdge(Edge e) {
        try {
            Edge currEdge = this.next;
            if(currEdge != null) {
                while(currEdge.next != null) {
                    currEdge = currEdge.next;
                }
                currEdge.next = e;
            }
            else {
                this.next = e;
            }
        } catch(Exception exc) {
            System.out.println("Exception: " + e);
        }
    }

    public Edge getNext() {
        return this.next;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Edge e = (Edge) obj;

        return this.endVertex == e.endVertex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(endVertex);
    }
}
