package me.destro.java.toolkit.stream;

import java.util.stream.Stream;

public final class CodePointStream {

    public static Stream<char[]> build(String string) {
        // TODO consider an alternative implementation using: string.codePoints().mapToObj(Character::toChars);
        int offset = 0;

        Stream.Builder<char[]> builder = Stream.builder();
        while (offset < string.length()) {
            int character = string.codePointAt(offset);
            builder.add(Character.toChars(character));

            offset += Character.charCount(character);
        }
        return builder.build();
    }
}
