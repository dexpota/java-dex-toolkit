import me.destro.java.toolkit.stream.CodePointStream;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class StreamTesting {
    @Test
    public void codePointStreamCreation() {
        String poo = "A pile of poo: 💩";

        Stream<char[]> stream = CodePointStream.build(poo);
        Assert.assertNotNull(stream);
    }

    @Test
    public void codePointStreamCount() {
        String poo = "A pile of poo: 💩";

        Stream<char[]> stream = CodePointStream.build(poo);
        Assert.assertEquals(stream.count(), poo.codePointCount(0, poo.length()));
    }

    @Test
    public void codePointStream() {
        String poo = "A pile of poo: 💩";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        Stream<char []> stream = CodePointStream.build(poo);
        stream.forEach(printStream::print);

        Assert.assertEquals(poo, outputStream.toString());
    }
}
