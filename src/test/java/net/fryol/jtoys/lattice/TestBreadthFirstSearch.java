package net.fryol.jtoys.lattice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestBreadthFirstSearch {
    @Test
    void testBFS() {
        Lattice lattice = new Lattice(2);

        assertEquals(true, BreadthFirstSearch.bfs(lattice, 0, 3));
        assertEquals(false, BreadthFirstSearch.bfs(lattice, 0, 9));
    }
}