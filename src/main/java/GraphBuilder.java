import java.util.*;

public class GraphBuilder {
    public static void main(String[] args) {
        // TODO: 10/8/2019 implement logic here
    }

    public static Map<Integer, Collection<Integer>> build(Scanner scanner){
        // TODO: 10/9/2019 build graph from file
        return null;
    }

    public static List<Integer> buildExpectedResult(Scanner scanner){
        List<Integer> ans = new ArrayList<>();
        int n = scanner.nextInt();
        while (n-- > 0) ans.add(scanner.nextInt());
        return ans;
    }
}
