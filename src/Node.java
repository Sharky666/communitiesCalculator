import java.util.ArrayList;

//TODO: Should the 'node' be a class? maybe it could be a HashMap?
public class Node {
    private String name;
    private ArrayList<String> connections = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<String> connections) {
        this.connections = connections;
    }
}
