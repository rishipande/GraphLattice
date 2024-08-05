package net.fryol.jtoys.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Graph implementation is as follows:
  * vertex is represented by an integer, and is expected to start at 0
    every vertex will have an edge associated w/ it, which can be null
    or it can be a Edge object, which is a linked list of edges, to 
    account for the possibility of more than one edges from a vertex
  * edges are represented by the net.fryol.jtoys.graph.Edge class, which 
    has two properties: endVertex (where the edge ends), and a next 
    pointer, to the next Edge object (if needed), like in a linked list
  * a HashMap<Int, Edge> called edges is basically what this graph
    class contains, where every Int (key) points to a vertex, and every
    Edge (value), is that vertex's (key's) linked list of edges
  * a basic constructor and a more useful constructor that takes the 
    the numberOfVertices that this graph will have are supplied
  * two getEdges() methods are supplied: one that takes no parameters
    and just returns the entire HashMap (not very useful really) and
    a getEdges(int vertex) method, that is more useful because it
    returns a list of all Edges for that vertex
  * getNumVertice() method to get the number of vertices
  * getNumEdges() method to get the number of edges - both these are
    fun to see for large graphs
  * intended use of this class is to basically use it for extending other
    more sophisticated use-cases
*/

public class Graph {
    private HashMap<Integer, Edge> edges;
    private int numVertices;
    private int numEdges;

    public Graph() {
        this.edges = new HashMap<>();
        this.numVertices = 1;
        this.numEdges = 0;
    }

    public Graph(int numberOfVertices) {
        if(numberOfVertices <= 0) {
            throw new IllegalArgumentException("Number of vertices (grid size) cannot be zero or less than zero.");
        }
        this.edges = new HashMap<>();
        this.numVertices = numberOfVertices;
        this.numEdges = 0;

        initGraph();
    }

    /** 
    Adds an Edge e for a vertex v to the Graph's HashMap

    Implementation detail: the edge is added as soon as 
    putIfAbsent is called which returns null if there
    was already an edges at the index = vertex here, and
    if so, we enter the conditional branch..   
    */ 
    public void addEdge(int vertex, Edge e) {

        if(this.edges.putIfAbsent(vertex, e) != null) {
            /**  
             ..this is to add additional edges for vertices
             that have more than one edges going out, and
             this calls the implementation in the Edge class
            */
            Edge edge = this.edges.get(vertex);
            edge.addNextEdge(e);
        }
        this.numEdges++;
    }

    public int getNumEdges() {
        return this.numEdges;
    }

    public int getNumVertices() {
        return this.numVertices;
    }

    public Map<Integer, Edge> getEdges() {
        return this.edges;
    }

    public List<Edge> getEdges(int vertex) {
        Edge currEdge = edges.get(vertex);
        List<Edge> edgeList = new ArrayList<>();

        while(currEdge!=null) {
            edgeList.add(currEdge);
            currEdge = currEdge.next;
        }
        return edgeList;
    }

    public List<Integer> getNeighbors(int vertex) {
        
        List<Integer> neighbors = new ArrayList<>();
        List<Edge> edgeList = getEdges(vertex);

        for (Edge edge : edgeList) {
            neighbors.add(edge.getEnd());
        }

        return neighbors;
    }

    private void initGraph() {
        for(int i=0; i<numVertices; i++) {
            edges.put(i, null);
        }
        this.setNumEdges();
    }

    private void setNumEdges() {
        int nEdges = 0;
        for (Integer start : this.getEdges().keySet()) {
            Edge edge = this.getEdges().get(start);
            while(edge!=null) {
                nEdges++;
            }
        }
        this.numEdges = nEdges;
    }

}

