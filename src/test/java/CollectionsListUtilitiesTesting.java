import me.destro.java.toolkit.collections.ListUtilities;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CollectionsListUtilitiesTesting {

    @Test
    public void testListUtilities() {
        Integer[] left = {1, 2, 3};
        Integer[] right = ListUtilities.asArray(Arrays.asList(left), Integer[].class);
        Assert.assertArrayEquals(left, right);
    }
}
