import java.util.*;

public class ParserTreeNode {

    private POS pos;
    private ParserTreeNode parent;
    private List<ParserTreeNode> children;
    private Boolean isLeaf;
    private String word;
    public ParserTreeNode(POS pos) {
        this.pos = pos;
        this.children = new ArrayList<>();
        this.isLeaf = false;
    }
    public ParserTreeNode(Boolean isLeaf, POS pos, String word) {
        this.word = word;
        this.pos = pos;
        this.children = new ArrayList<>();
        this.isLeaf = isLeaf;
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
