package lesson_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTreeTest {

    @Test
    void addChild() {
        SimpleTreeNode<String> root = new SimpleTreeNode<>("Root", null);
        SimpleTree<String> simpleTree = new SimpleTree<>(root);
        assertNull(simpleTree.Root.Children);
        assertEquals("Root", simpleTree.Root.NodeValue);
        SimpleTreeNode<String> level1A = new SimpleTreeNode<>("level1A", root);
        SimpleTreeNode<String> level1B = new SimpleTreeNode<>("level1B", root);
        SimpleTreeNode<String> level1C = new SimpleTreeNode<>("level1C", root);
        simpleTree.AddChild(root, level1A);
        assertNotNull(simpleTree.Root.Children);
        assertEquals(1, simpleTree.Root.Children.size());
        assertEquals(level1A, simpleTree.Root.Children.get(0));

        simpleTree.AddChild(root, level1B);
        simpleTree.AddChild(root, level1C);

        assertEquals(3, simpleTree.Root.Children.size());
        assertEquals(level1A, simpleTree.Root.Children.get(0));
        assertEquals(level1B, simpleTree.Root.Children.get(1));
        assertEquals(level1C, simpleTree.Root.Children.get(2));
    }

    @Test
    void deleteNode() {
        SimpleTreeNode<String> root = new SimpleTreeNode<>("Root", null);
        SimpleTree<String> simpleTree = new SimpleTree<>(root);
        SimpleTreeNode<String> level1A = new SimpleTreeNode<>("level1A", root);
        SimpleTreeNode<String> level1B = new SimpleTreeNode<>("level1B", root);
        SimpleTreeNode<String> level1C = new SimpleTreeNode<>("level1C", root);
        SimpleTreeNode<String> level2CA = new SimpleTreeNode<>("level2CA", level1C);
        SimpleTreeNode<String> level2CB = new SimpleTreeNode<>("level2CB", level1C);
        SimpleTreeNode<String> level2CC = new SimpleTreeNode<>("level2CC", level1C);
        SimpleTreeNode<String> level3CCA = new SimpleTreeNode<>("level3CCA", level2CC);
        SimpleTreeNode<String> level3CCB = new SimpleTreeNode<>("level3CCB", level2CC);
        SimpleTreeNode<String> level3CCC = new SimpleTreeNode<>("level3CCC", level2CC);
        simpleTree.AddChild(root, level1A);
        simpleTree.AddChild(root, level1B);
        simpleTree.AddChild(root, level1C);
        simpleTree.AddChild(root, level1C);
        simpleTree.AddChild(root, level1C);
        simpleTree.AddChild(root, level1C);
        simpleTree.AddChild(root, level1C);
        simpleTree.AddChild(level1C, level2CA);
        simpleTree.AddChild(level1C, level2CB);
        simpleTree.AddChild(level1C, level2CC);
        simpleTree.AddChild(level2CC, level3CCA);
        simpleTree.AddChild(level2CC, level3CCB);
        simpleTree.AddChild(level2CC, level3CCC);

        simpleTree.DeleteNode(level1C);
        assertEquals(2, simpleTree.Root.Children.size());
        assertEquals(level1A, simpleTree.Root.Children.get(0));
        assertEquals(level1B, simpleTree.Root.Children.get(1));
        assertNull(level1C.Parent);
    }

    @Test
    void getAllNodes() {
        SimpleTreeNode<String> root = new SimpleTreeNode<>("Root", null);
        SimpleTree<String> simpleTree = new SimpleTree<>(root);
        assertEquals(1, simpleTree.GetAllNodes().size());

        SimpleTreeNode<String> level1A = new SimpleTreeNode<>("level1A", root);
        SimpleTreeNode<String> level1B = new SimpleTreeNode<>("level1B", root);
        SimpleTreeNode<String> level1C = new SimpleTreeNode<>("level1C", root);
        SimpleTreeNode<String> level2CA = new SimpleTreeNode<>("level2CA", level1C);
        SimpleTreeNode<String> level2CB = new SimpleTreeNode<>("level2CB", level1C);
        SimpleTreeNode<String> level2CC = new SimpleTreeNode<>("level2CC", level1C);
        SimpleTreeNode<String> level3CCA = new SimpleTreeNode<>("level3CCA", level2CC);
        SimpleTreeNode<String> level3CCB = new SimpleTreeNode<>("level3CCB", level2CC);
        SimpleTreeNode<String> level3CCC = new SimpleTreeNode<>("level3CCC", level2CC);
        simpleTree.AddChild(root, level1A);
        assertEquals(2, simpleTree.GetAllNodes().size());

        simpleTree.AddChild(root, level1B);
        assertEquals(3, simpleTree.GetAllNodes().size());

        simpleTree.AddChild(root, level1C);
        assertEquals(4, simpleTree.GetAllNodes().size());

        simpleTree.AddChild(level1C, level2CA);
        assertEquals(5, simpleTree.GetAllNodes().size());

        simpleTree.AddChild(level1C, level2CB);
        assertEquals(6, simpleTree.GetAllNodes().size());

        simpleTree.AddChild(level1C, level2CC);
        assertEquals(7, simpleTree.GetAllNodes().size());

        simpleTree.AddChild(level2CC, level3CCA);
        assertEquals(8, simpleTree.GetAllNodes().size());

        simpleTree.AddChild(level2CC, level3CCB);
        assertEquals(9, simpleTree.GetAllNodes().size());

        simpleTree.AddChild(level2CC, level3CCC);
        assertEquals(10, simpleTree.GetAllNodes().size());
    }

    @Test
    void findNodesByValue() {

        SimpleTreeNode<String> root = new SimpleTreeNode<>("Root", null);
        SimpleTree<String> simpleTree = new SimpleTree<>(root);
        SimpleTreeNode<String> level1A = new SimpleTreeNode<>("level1A", root);
        SimpleTreeNode<String> level1B = new SimpleTreeNode<>("level1B", root);
        SimpleTreeNode<String> level1C = new SimpleTreeNode<>("level1C", root);
        SimpleTreeNode<String> level2CA = new SimpleTreeNode<>("level2CA", level1C);
        SimpleTreeNode<String> level2CB = new SimpleTreeNode<>("level2CB", level1C);
        SimpleTreeNode<String> level2CC = new SimpleTreeNode<>("level1C", level1C);
        SimpleTreeNode<String> level3CCA = new SimpleTreeNode<>("level3CCA", level2CC);
        SimpleTreeNode<String> level3CCB = new SimpleTreeNode<>("level3CCB", level2CC);
        SimpleTreeNode<String> level3CCC = new SimpleTreeNode<>("level1C", level2CC);
        simpleTree.AddChild(root, level1A);
        simpleTree.AddChild(root, level1B);
        simpleTree.AddChild(root, level1C);
        simpleTree.AddChild(level1C, level2CA);
        simpleTree.AddChild(level1C, level2CB);
        simpleTree.AddChild(level1C, level2CC);
        simpleTree.AddChild(level2CC, level3CCA);
        simpleTree.AddChild(level2CC, level3CCB);
        simpleTree.AddChild(level2CC, level3CCC);

        assertEquals(0, simpleTree.FindNodesByValue("notFound").size());
        assertEquals(1, simpleTree.FindNodesByValue("Root").size());
        assertEquals(3, simpleTree.FindNodesByValue("level1C").size());
    }

    @Test
    void moveNode() {
        SimpleTreeNode<String> root = new SimpleTreeNode<>("Root", null);
        SimpleTree<String> simpleTree = new SimpleTree<>(root);
        SimpleTreeNode<String> level1A = new SimpleTreeNode<>("level1A", root);
        SimpleTreeNode<String> level1B = new SimpleTreeNode<>("level1B", root);
        SimpleTreeNode<String> level1C = new SimpleTreeNode<>("level1C", root);
        SimpleTreeNode<String> level2CA = new SimpleTreeNode<>("level2CA", level1C);
        SimpleTreeNode<String> level2CB = new SimpleTreeNode<>("level2CB", level1C);
        SimpleTreeNode<String> level2CC = new SimpleTreeNode<>("level2CC", level1C);
        SimpleTreeNode<String> level3CCA = new SimpleTreeNode<>("level3CCA", level2CC);
        SimpleTreeNode<String> level3CCB = new SimpleTreeNode<>("level3CCB", level2CC);
        SimpleTreeNode<String> level3CCC = new SimpleTreeNode<>("level3CCC", level2CC);
        simpleTree.AddChild(root, level1A);
        simpleTree.AddChild(root, level1B);
        simpleTree.AddChild(root, level1C);
        simpleTree.AddChild(level1C, level2CA);
        simpleTree.AddChild(level1C, level2CB);
        simpleTree.AddChild(level1C, level2CC);
        simpleTree.AddChild(level2CC, level3CCA);
        simpleTree.AddChild(level2CC, level3CCB);
        simpleTree.AddChild(level2CC, level3CCC);

        simpleTree.MoveNode(level2CC, root);

        assertEquals(level2CC.Parent, root);
        assertEquals(level2CC, root.Children.get(3));
        assertEquals(4, root.Children.size());

        assertEquals(2, level1C.Children.size());
    }

    @Test
    void count() {
        SimpleTreeNode<String> root = new SimpleTreeNode<>("Root", null);
        SimpleTree<String> simpleTree = new SimpleTree<>(root);
        assertEquals(1, simpleTree.Count());
        SimpleTreeNode<String> level1A = new SimpleTreeNode<>("level1A", root);
        SimpleTreeNode<String> level1B = new SimpleTreeNode<>("level1B", root);
        SimpleTreeNode<String> level1C = new SimpleTreeNode<>("level1C", root);
        SimpleTreeNode<String> level2CA = new SimpleTreeNode<>("level2CA", level1C);
        SimpleTreeNode<String> level2CB = new SimpleTreeNode<>("level2CB", level1C);
        SimpleTreeNode<String> level2CC = new SimpleTreeNode<>("level2CC", level1C);
        SimpleTreeNode<String> level3CCA = new SimpleTreeNode<>("level3CCA", level2CC);
        SimpleTreeNode<String> level3CCB = new SimpleTreeNode<>("level3CCB", level2CC);
        SimpleTreeNode<String> level3CCC = new SimpleTreeNode<>("level3CCC", level2CC);
        simpleTree.AddChild(root, level1A);
        assertEquals(2, simpleTree.Count());

        simpleTree.AddChild(root, level1B);
        assertEquals(3, simpleTree.Count());

        simpleTree.AddChild(root, level1C);
        assertEquals(4, simpleTree.Count());

        simpleTree.AddChild(level1C, level2CA);
        assertEquals(5, simpleTree.Count());

        simpleTree.AddChild(level1C, level2CB);
        assertEquals(6, simpleTree.Count());

        simpleTree.AddChild(level1C, level2CC);
        assertEquals(7, simpleTree.Count());

        simpleTree.AddChild(level2CC, level3CCA);
        assertEquals(8, simpleTree.Count());

        simpleTree.AddChild(level2CC, level3CCB);
        assertEquals(9, simpleTree.Count());

        simpleTree.AddChild(level2CC, level3CCC);
        assertEquals(10, simpleTree.Count());

    }

    @Test
    void leafCount() {

        SimpleTreeNode<String> root = new SimpleTreeNode<>("Root", null);
        SimpleTree<String> simpleTree = new SimpleTree<>(root);
        assertEquals(1, simpleTree.LeafCount());
        SimpleTreeNode<String> level1A = new SimpleTreeNode<>("level1A", root);
        SimpleTreeNode<String> level1B = new SimpleTreeNode<>("level1B", root);
        SimpleTreeNode<String> level1C = new SimpleTreeNode<>("level1C", root);
        SimpleTreeNode<String> level2CA = new SimpleTreeNode<>("level2CA", level1C);
        SimpleTreeNode<String> level2CB = new SimpleTreeNode<>("level2CB", level1C);
        SimpleTreeNode<String> level2CC = new SimpleTreeNode<>("level1C", level1C);
        SimpleTreeNode<String> level3CCA = new SimpleTreeNode<>("level3CCA", level2CC);
        SimpleTreeNode<String> level3CCB = new SimpleTreeNode<>("level3CCB", level2CC);
        SimpleTreeNode<String> level3CCC = new SimpleTreeNode<>("level1C", level2CC);
        simpleTree.AddChild(root, level1A);
        assertEquals(1, simpleTree.LeafCount());

        simpleTree.AddChild(root, level1B);
        assertEquals(2, simpleTree.LeafCount());

        simpleTree.AddChild(root, level1C);
        assertEquals(3, simpleTree.LeafCount());

        simpleTree.AddChild(level1C, level2CA);
        assertEquals(3, simpleTree.LeafCount());

        simpleTree.AddChild(level1C, level2CB);
        assertEquals(4, simpleTree.LeafCount());

        simpleTree.AddChild(level1C, level2CC);
        assertEquals(5, simpleTree.LeafCount());

        simpleTree.AddChild(level2CC, level3CCA);
        assertEquals(5, simpleTree.LeafCount());

        simpleTree.AddChild(level2CC, level3CCB);
        assertEquals(6, simpleTree.LeafCount());

        simpleTree.AddChild(level2CC, level3CCC);
        assertEquals(7, simpleTree.LeafCount());

    }
}