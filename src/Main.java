public class Main {
    public static void main(String[] args) {
       GraphCommunities graphCommunities = new GraphCommunities();
       NodeManager nodeManager = new NodeManager();
       graphCommunities.setStrategy(CommunityCalculationStrategies.NORMALIZE).getCommunities(nodeManager.getNodes(), 2);
    }
}
