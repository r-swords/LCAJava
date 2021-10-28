import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DAGTest {

    @Test
    void testEmptyGraph(){
        DAG graph = new DAG(0);
        assertNull(graph.findLCA(0, 0));
    }

    @Test
    void testUnconnectedGraph(){
        DAG graph = new DAG(7);
        assertNull(graph.findLCA(2, 5));
    }

    @Test
    void testBinaryTree(){
        DAG graph = new DAG(7);
        graph.addEdge(0, 1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(2,6);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1);
        assertEquals(answer, graph.findLCA(3,4));
        answer.set(0,0);
        assertEquals(answer, graph.findLCA(6,1));
    }

    @Test
    void testDAG(){
        DAG graph = new DAG(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0);
        assertEquals(answer, graph.findLCA(1,2));
        answer.add(2);
        assertEquals(answer, graph.findLCA(3,4));
        assertNull(graph.findLCA(-1,-2));
        assertNull(graph.findLCA(5,6));
        assertNull(graph.findLCA(4,4));
    }

}