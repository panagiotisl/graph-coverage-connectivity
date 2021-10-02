package gr.uoa.di.gcc;

import com.twitter.cassovary.graph.ArrayBasedDirectedGraph;
import com.twitter.cassovary.util.NodeNumberer;
import com.twitter.cassovary.util.SequentialNodeNumberer;
import com.twitter.cassovary.util.io.AdjacencyListGraphReader;

import scala.Function1;
import scala.runtime.AbstractFunction1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(final String[] args) {


        NodeNumberer<Integer> nodeNumberer = new SequentialNodeNumberer<>();

        Function1<String, Integer> f = new AbstractFunction1<String, Integer>() {
            @Override
            public Integer apply(final String string) {
                return Integer.parseInt(string);
            }
        };

        ArrayBasedDirectedGraph graph = new AdjacencyListGraphReader<Integer>("src/main/resources/", "example",
                nodeNumberer, f).toArrayBasedDirectedGraph();

        LOGGER.info("Nodes: {}", graph.nodeCount());
        LOGGER.info("Edges: {}", graph.edgeCount());
    }
}
