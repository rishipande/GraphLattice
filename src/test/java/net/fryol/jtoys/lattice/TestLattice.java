package net.fryol.jtoys.lattice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestLattice {
    @Test
    void testLatticeConstruction() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lattice(-1);
        }, "Lattice(-1) should throw an IllegalArgumentException.");
    }
}