import java.util.ArrayList;
import java.util.HashMap;

public class NormalizeCommunityCalculationStrategy implements CommunityCalculationStrategy {
    @Override
    public void calculate(ArrayList<Node> nodes, Integer roomCapacity) {
        ArrayList<Node> unassignedNodes = new ArrayList<>(nodes);
        ArrayList<Node> loserNodes = new ArrayList<>(nodes);
        final Integer numOfRooms = (int) Math.ceil(nodes.size() / roomCapacity);
        HashMap<ArrayList<Node>, ArrayList<Node>> satisfiedNodesPerRoom = new HashMap<>();
        //initializing the rooms.
        ArrayList<ArrayList<Node>> rooms = new ArrayList<ArrayList<Node>>();
        for (Integer i = 0; i < numOfRooms; i++) {
            rooms.add(new ArrayList<Node>());
        }

        rooms.forEach(room -> {
            satisfiedNodesPerRoom.put(room, new ArrayList<>());
            for (Integer i = 0; i < roomCapacity; i++) {
                if (room.isEmpty()) {
                    //cut a random node from the 'nodes' and add it to the room
                    Node cutNode = unassignedNodes.remove((int) Math.floor(Math.random() * unassignedNodes.size()) + 1);
                    room.add(cutNode);
                } else {
                    //Iterate every node in the current room until you find a node that isn't in the satisfied nodes array
                    room.forEach(node -> {
                        if (!satisfiedNodesPerRoom.get(room).contains(node)) {
                            //iterate though every current node's connection interest
                            for (int j = 0; j < node.getConnections().size(); j++) {
                                Node currentNode = node.getConnections().get(j);
                                if (unassignedNodes.contains(currentNode)) {
                                    //add the currentNode to the room and quit the node's loop (for each)
                                    //TODO: there's probably a prettier way to do it
                                    room.add(unassignedNodes.remove(unassignedNodes.indexOf(currentNode)));
                                    satisfiedNodesPerRoom.get(room).add(node);
                                    return;
                                }
                                else {
                                    //if the node couldn't find any available connections, cut it from the room to the loserNodes
                                    loserNodes.add(room.remove(room.indexOf(node)));
                                }
                            }
                        }
                    });
                }
            }
        });
        //TODO: figure out if it will actually work, might want to make it recursive.
        loserNodes.forEach(loserNode -> {
            for (Node wantedNode : loserNode.getConnections()) {
                for (ArrayList<Node> room : rooms) {
                    if (room.contains(wantedNode)) {
                        // loop through the room that the wantedNode is at
                        for (Node nodeInWantedRoom : room) {
                            // if the room isn't full add the loserNode to it and return
                            if (room.size() < roomCapacity) {
                                room.add(loserNodes.remove(loserNodes.indexOf(loserNode)));
                                return;
                            //    for each node in the room that isn't the 'wantedNode' try and find a different room for it
                            } else if (nodeInWantedRoom != wantedNode) {
                                for (Node unwantedNodeConnectionNode : nodeInWantedRoom.getConnections()) {
                                    for (ArrayList<Node> room1 : rooms) {
                                        // if an available room is found, put the 'nodeInWantedRoom' in it and the loserNode instead of the 'nodeInWantedRoom', return.
                                        if (room1.contains(unwantedNodeConnectionNode) && room1.size() < roomCapacity) {
                                            room1.add(room.remove(room.indexOf(nodeInWantedRoom)));
                                            room.add(loserNodes.remove(loserNodes.indexOf(loserNode)));
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }
}
