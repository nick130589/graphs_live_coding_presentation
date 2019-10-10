import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import util.VariableSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: 10/8/2019 Parametrized tests for dfs, bfs and djus
// TODO: 10/8/2019 wrong realization for some test cases
public class BFSTest {

    private static final int AMOUNT_OF_TESTS = 9;

    private static Supplier<Stream<Arguments>> ARGUMENTS_SUPPLIER = () -> {
        List<Arguments> ans = new ArrayList<>();
        try (Scanner namesScanner = new Scanner(new File("src/test/names.txt"));
             Scanner inScanner = new Scanner(new File("src/test/input.txt"));
             Scanner outScanner = new Scanner(new File("src/test/output.txt"))) {
            for (int i = 0; i < AMOUNT_OF_TESTS; i++) {
                String name = namesScanner.nextLine();
                Map<Integer, Collection<Integer>> graph = GraphBuilder.build(inScanner);
                int from = inScanner.nextInt();
                List<Integer> expectedResult = GraphBuilder.buildExpectedResult(outScanner);
                ans.add(Arguments.of(name, graph, from, expectedResult));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return ans.stream();
    };

    public static Stream<Arguments> ARGUMENTS = ARGUMENTS_SUPPLIER.get();


    @ParameterizedTest
    @VariableSource("ARGUMENTS")
    void test_bfs_order(String name, Map<Integer, Collection<Integer>> graph, int from, List<Integer> expectedAns) {


        //GIVEN
        BSFImpl bsfImpl = new BSFImpl();

        //WHEN
        List<Integer> actualAns = new ArrayList<>();
        bsfImpl.bfs(from, graph, actualAns);

        //THEN
        assertEquals(expectedAns, actualAns);

    }


}
