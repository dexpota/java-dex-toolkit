import me.destro.java.toolkit.miscellanies.Youtube;
import org.junit.Assert;
import org.junit.Test;

public class YoutubeUtilitiesTesting {
    @Test
    public void testIdExtraction() {
        Assert.assertEquals("M7lc1UVf-VE", Youtube.extractIdFromUrl("https://www.youtube.com/embed/M7lc1UVf-VE"));
        Assert.assertEquals("-wtIMTCHWuI", Youtube.extractIdFromUrl("http://www.youtube.com/v/-wtIMTCHWuI?version=3&autohide=1"));
        Assert.assertEquals("iwGFalTRHDA", Youtube.extractIdFromUrl("http://youtube.com/watch?v=iwGFalTRHDA"));
        Assert.assertEquals("iwGFalTRHDA", Youtube.extractIdFromUrl("http://www.youtube.com/watch?v=iwGFalTRHDA&feature=related"));
        Assert.assertEquals("t-ZRX8984sc", Youtube.extractIdFromUrl("http://www.youtube.com/watch?v=t-ZRX8984sc"));
        Assert.assertEquals("t-ZRX8984sc", Youtube.extractIdFromUrl("http://youtu.be/t-ZRX8984sc"));
        Assert.assertEquals("r5nB9u4jjy4", Youtube.extractIdFromUrl("http://www.youtube.com/embed/watch?feature=player_embedded&v=r5nB9u4jjy4"));
    }

}
