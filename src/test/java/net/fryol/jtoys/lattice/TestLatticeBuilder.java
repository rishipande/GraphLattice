package net.fryol.jtoys.lattice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestLatticeBuilder {
    @Test
    void testLatticePaths() {
        // for testing Lattice(-1), see TestLattice
        assertEquals(0, LatticeBuilder.latticePaths(new Lattice(0)), "latticePaths(Lattice(0)) should return 0 possible paths.");
        assertEquals(2, LatticeBuilder.latticePaths(new Lattice(1)), "latticePaths(Lattice(2)) should return 1 possible path.");
        assertEquals(6, LatticeBuilder.latticePaths(new Lattice(2)), "latticePaths(Lattice(2)) should return 6 possible paths.");
        assertEquals(20, LatticeBuilder.latticePaths(new Lattice(3)), "latticePaths(Lattice(3)) should return 20 possible paths.");
        assertEquals(70, LatticeBuilder.latticePaths(new Lattice(4)), "latticePaths(Lattice(4)) should return 70 possible paths.");
    }
}