package me.destro.java.toolkit.miscellanies;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Youtube {
    public static String extractIdFromUrl(String url) {
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(url); //url is youtube url for which you want to extract the id.
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public static String thumbnailUrl(String id) {
        return "http://i.ytimg.com/vi/" + id +"/hqdefault.jpg";
    }
}