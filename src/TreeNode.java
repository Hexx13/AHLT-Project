import java.util.List;

/**
 *
 */
public class TreeNode {

    Word word;
    POS pos;
    List<TreeNode> children;
    TreeNode parent;

    //leaf
    public TreeNode(Word word){
        this.word = word;
        this.pos = word.getPos();
    }
    //not leaf
    TreeNode(POS pos, List<TreeNode> children, TreeNode parent){
        this.pos = pos;
        this.children = children;
        this.parent = parent;
    }

    public boolean isLeaf(){
        return children != null;
    }
//    public boolean addChild(Word n) {
//        return childrenList.add(n);
//        //return children.add(n);
//    }
//    public boolean removeChild(TreeNode n) {
//        return true;
//    }

//    public Word getChild(int n) {
//        return childrenList.get(n);
//    }
//    public Iterator<TreeNode> iterator() {
//        return children.iterator();
//    }

}
