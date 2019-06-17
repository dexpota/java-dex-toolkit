package me.destro.java.toolkit.serialization.moshi;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

public class JodaDateTimeAdapter {
    final DateTimeFormatter dateTimeFormatter;

    public JodaDateTimeAdapter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @ToJson
    String toJson(DateTime dateTime) {
        return dateTimeFormatter.print(dateTime);
    }

    @FromJson
    DateTime fromJson(String dateTime) {
        return dateTimeFormatter.parseDateTime(dateTime);
    }
}
