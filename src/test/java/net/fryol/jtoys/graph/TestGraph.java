package net.fryol.jtoys.graph;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestGraph {
    @Test
    void testGraphConstructorBlank(){
        // testing everything in the default container
        Graph grph = new Graph();
        assertEquals(new HashMap<>(), grph.getEdges());
        assertEquals(0, grph.getNumEdges());
        assertEquals(1, grph.getNumVertices());
    }
}

