import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTest {

@Test
    void testInsertAndSearch() {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        tree.insert(new Association<>("dog", "perro"));
        tree.insert(new Association<>("house", "casa"));

        Association<String, String> result =
            tree.search(new Association<>("dog", null));

        assertNotNull(result);
        assertEquals("perro", result.getValue());
}
@Test
void testInsertMultiple() {
    BinaryTree<Association<String, String>> tree = new BinaryTree<>();

    tree.insert(new Association<>("m", "m"));
    tree.insert(new Association<>("a", "a"));
    tree.insert(new Association<>("z", "z"));

    assertNotNull(tree.search(new Association<>("a", null)));
    assertNotNull(tree.search(new Association<>("z", null)));
}
}

