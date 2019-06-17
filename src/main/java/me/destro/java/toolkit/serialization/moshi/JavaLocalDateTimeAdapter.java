package me.destro.java.toolkit.serialization.moshi;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaLocalDateTimeAdapter {
    final DateTimeFormatter dateTimeFormatter;

    public JavaLocalDateTimeAdapter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @ToJson
    String toJson(LocalDateTime localDateTime) {
        return dateTimeFormatter.format(localDateTime);
    }

    @FromJson
    LocalDateTime fromJson(String localDateTime) {
        return LocalDateTime.parse(localDateTime, dateTimeFormatter);
    }
}
