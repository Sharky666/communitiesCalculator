import java.util.ArrayList;
import java.util.HashMap;

public class NormalizeCommunityCalculationStrategy implements CommunityCalculationStrategy {
    @Override
    public void calculate(ArrayList<Node> nodes, Integer roomCapacity) {
        ArrayList<Node> unassignedNodes = new ArrayList<>(nodes);
        final Integer numOfRooms = (int) Math.ceil(nodes.size() / roomCapacity);
        //TODO: implement the algorithm! :)
        //Initializing the rooms.
        //TODO: there's probably a better way to do it
        //TODO: we will probably have to implement it (the rooms initialization) in the beginning of every calculate function, so maybe make it a function in the base class
        //TODO: it's most likely better to initialize the rooms with a fixed capacity
        //TODO: Maybe a 'room' should be a class because we might need to save it's connections and weights
        ArrayList<ArrayList<Node>> rooms = new ArrayList<ArrayList<Node>>();
        for (Integer i = 0; i < numOfRooms; i++) {
            rooms.add(new ArrayList<Node>());
        }
        HashMap<ArrayList<Node>, ArrayList<Node>> satisfiedNodesPerRoom = new HashMap<>();
        rooms.forEach(room -> {
            satisfiedNodesPerRoom.put(room, new ArrayList<>());
            for (Integer i = 0; i < roomCapacity; i++) {
                if (room.isEmpty()) {
                    //cut a random node from the 'nodes' and add it to the room
                    Node cutNode = unassignedNodes.remove((int) Math.floor(Math.random() * unassignedNodes.size()) + 1);
                    //TODO: concat the 'cutNode's connection into the room's connections~
                    room.add(cutNode);
                } else {
                    // TODO: Iterate every node in the current room until you find a node that isn't in the satisfied nodes array
                    //TODO: add a node from the 'nodes' list according to the room's connection and add it's connection to the room's connection
                }
            }
        });
    }
}
