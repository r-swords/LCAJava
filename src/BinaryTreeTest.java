import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void LcaTest(){
        BinaryTree testTree = new BinaryTree();
        assertNull(testTree.findLca(1,2), "Search empty tree");
        testTree.root = new Node(1);
        assertEquals(1, testTree.findLca(1,1).data,"Search tree with one node");
        testTree.root.right = new Node(2);
        testTree.root.left = new Node(3);
        testTree.root.right.right = new Node(4);
        testTree.root.right.left = new Node(5);
        assertEquals(2,testTree.findLca(2,5).data, "Search unbalanced tree");
        testTree.root.left.right = new Node(6);
        testTree.root.left.left = new Node(7);
        assertEquals(2, testTree.findLca(4, 5).data, "Search balanced tree");
        assertEquals(1,testTree.findLca(5,7).data, "LCA is root node");
        assertEquals(4, testTree.findLca(4, 4).data, "Search for LCA when both nodes are the same");
        assertNull(testTree.findLca(10,11), "Both nodes are not in the tree");
        assertNull(testTree.findLca(2,11), "Second Node is not in the tree");
        assertNull(testTree.findLca(10,2), "First Node is not in the tree");
    }

}