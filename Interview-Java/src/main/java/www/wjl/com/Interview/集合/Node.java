package www.wjl.com.Interview.集合;

import java.util.ArrayList;
import java.util.List;

/*
 * @desc 树
 * @author wjl
 * @date 2018/6/12 0012
 */
public class Node {
    private String name;
    private List<Node> children = new ArrayList<Node>();
    private Node parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
