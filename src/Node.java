import java.util.ArrayList;

//TODO: Should the 'node' be a class? maybe it could be a HashMap?
public class Node {
    private String name;
    private ArrayList<Node> connections = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Node> connections) {
        this.connections = connections;
    }
}
