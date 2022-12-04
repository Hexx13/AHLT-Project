import java.util.*;

public class ParserTreeNode {

    public String getTag() {
        return tag;
    }

    private String tag;
    private ParserTreeNode parent;
    private List<ParserTreeNode> children;
    private Boolean isLeaf;
    private String word;
    public ParserTreeNode(String tag) {
        this.tag = tag;
        this.children = new ArrayList<>();
        this.isLeaf = false;
    }
    public ParserTreeNode(Boolean isLeaf, String tag, String word) {
        this.word = word;
        this.tag = tag;
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
