package net.fryol.jtoys.lattice;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestLattice {
    @Test
    void testLatticeConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lattice(-1);
        }, "Lattice(-1) should throw an IllegalArgumentException.");
    }

    @Test
    void testLatticeGetNeighbors() {
        Lattice lattice = new Lattice(2);
        List<Integer> neighbors = lattice.getNeighbors(1);

        assertEquals(2, neighbors.get(0));
        assertEquals(4, neighbors.get(1));
    }

    @Test
    void testLatticeToString() {
        Lattice lattice = new Lattice(2);
        StringBuilder cString = new StringBuilder();
        cString.append("Number of vertices: 9" + System.lineSeparator());
        cString.append("Number of edges: 12");

        assertEquals(cString.toString(), lattice.toString());
    }
}