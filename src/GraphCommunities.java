import java.util.ArrayList;

public class GraphCommunities {
    CommunityCalculationStrategy strategy;
    NodeManager nodeManager;
    public GraphCommunities() {
    }
    public GraphCommunities setStrategy(CommunityCalculationStrategies strategy) {
        //setting the correct communities sortation algorithm
        switch (strategy) {
            case NORMALIZE:
                this.strategy = new NormalizeCommunityCalculationStrategy();
        }
        return this;
    }

    public GraphCommunities getCommunities(ArrayList<Node> nodes, Integer rooms) {
        strategy.calculate(nodes, rooms);
        return this;
    }
}
