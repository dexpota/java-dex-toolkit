package me.destro.java.toolkit.serialization;

import com.google.gson.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

import java.lang.reflect.Type;

public class JodaDateTimeDeserializer implements JsonDeserializer<DateTime> {
    public final DateTimeFormatter dateTimeFormatter;

    public JodaDateTimeDeserializer(DateTimeFormatter formatter) { dateTimeFormatter = formatter; }

    @Override
    public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return dateTimeFormatter.parseDateTime(json.getAsString());
    }
}
