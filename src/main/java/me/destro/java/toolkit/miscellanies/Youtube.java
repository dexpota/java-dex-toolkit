package me.destro.java.toolkit.miscellanies;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Youtube {
    public static String extractIdFromUrl(String url) {
        String pattern = "(?:youtube(?:-nocookie)?\\.com\\/(?:[^\\/\\n\\s]+\\/\\S+\\/|(?:v|e(?:mbed)?)\\/|\\S*?[?&]v=)|youtu\\.be\\/)([a-zA-Z0-9_-]{11})";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(url); //url is youtube url for which you want to extract the id.
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public static String thumbnailUrl(String id) {
        return "http://i.ytimg.com/vi/" + id +"/hqdefault.jpg";
    }
}
