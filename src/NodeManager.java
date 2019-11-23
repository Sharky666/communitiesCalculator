import java.util.ArrayList;

public class NodeManager {
    private ArrayList<Node> nodes = new ArrayList<>();

    public NodeManager() {}

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    //TODO: Should the nodes be generated here?
    public void generateNodes(int nodesNum, int nodeConnections) {
        for (int i = 0; i < nodesNum; i++) {
            System.out.println(i);
        }
    }
}
