package net.fryol.jtoys.graph;

import java.util.Objects;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEdge {
    @Test
    void testEdgeEquals() {
        Edge edge2 = new Edge(1);
        Edge edge3 = new Edge(1);
        Edge edge4 = new Edge(2);
        Edge edge5 = edge3;
        
        int edge4Hash = Objects.hash(edge4.getEnd());

        // testing equals() -  param equality
        assertEquals(edge2, edge3);

        // testing equals() - obj reference eq
        assertEquals(edge3, edge5);

        // testing hashCode()
        assertEquals(edge4Hash, edge4.hashCode());
    }

    @Test
    void testEdgeAddNextEgde() {
        Edge edge = new Edge(0);
        Edge edge2 = new Edge(1);
                
        // testing addNextEdge()
        edge.addNextEdge(edge2);
        while(edge.next != null) {
            edge = edge.getNext();
        }
        assertEquals(1, edge.getEnd());
    }    
}
