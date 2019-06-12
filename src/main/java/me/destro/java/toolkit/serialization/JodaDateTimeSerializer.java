package me.destro.java.toolkit.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

import java.lang.reflect.Type;

public class JodaDateTimeSerializer implements JsonSerializer<DateTime> {
    public final DateTimeFormatter dateTimeFormatter;

    public JodaDateTimeSerializer(DateTimeFormatter formatter) { dateTimeFormatter = formatter; }

    @Override
    public JsonElement serialize(DateTime dateTime, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(dateTimeFormatter.print(dateTime));
    }
}