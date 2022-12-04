import java.util.List;
 public interface ITree<T> {
        T Root();
        boolean isLeaf();
        int numberSubTrees();
        ITree<T> getSubTree(int i);
        void addSubTree(ITree<T> subtree);
        List<T> preorder();
        List<T> inorder();
        List<T> postorder();
        int Height();

}
