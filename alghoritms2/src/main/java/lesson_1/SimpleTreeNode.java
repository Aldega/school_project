package lesson_1;

import java.util.*;

public class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        if (NewChild != null) {
            if (ParentNode.Children == null) {
                ParentNode.Children = new ArrayList<SimpleTreeNode<T>>();
            }
            ParentNode.Children.add(NewChild);
            NewChild.Parent = ParentNode;
        }
        // ваш код добавления нового дочернего узла существующему ParentNode
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {

        List<SimpleTreeNode<T>> childrens = NodeToDelete.Parent.Children;
        for (int i = 0; i < childrens.size(); i++) {
            if (childrens.get(i).equals(NodeToDelete) && childrens.get(i).hashCode() == NodeToDelete.hashCode()) {
                childrens.remove(i);
            }
        }
        NodeToDelete.Parent = null;
        // ваш код удаления существующего узла NodeToDelete
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        // ваш код выдачи всех узлов дерева в определённом порядке
        List<SimpleTreeNode<T>> result = new ArrayList<>();

        addNodeAndChildrenToList(result, Root);
        return result;
    }



    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        // ваш код поиска узлов по значению
        return GetAllNodes().stream().filter(node -> node.NodeValue.equals(val)).collect(java.util.stream.Collectors.toList());
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        // ваш код перемещения узла вместе с его поддеревом --
        // в качестве дочернего для узла NewParent
        DeleteNode(OriginalNode);
        AddChild(NewParent, OriginalNode);
    }

    public int Count()
    {
        // количество всех узлов в дереве
        return GetAllNodes().size();
    }

    public int LeafCount()
    {
        // количество листьев в дереве
        return (int) GetAllNodes().stream().filter(node -> node.Children == null).count();
    }

    private void addNodeAndChildrenToList(List<SimpleTreeNode<T>> result, SimpleTreeNode<T> node) {
        if (node == null) {
            return;
        }
        result.add(node);
        List<SimpleTreeNode<T>> childrens = node.Children;
        if (childrens != null) {
            childrens.forEach(children -> addNodeAndChildrenToList(result, children));
        }
    }
}