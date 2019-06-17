package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import me.destro.java.toolkit.serialization.gson.JavaLocalDateTimeDeserializer;
import me.destro.java.toolkit.serialization.gson.JavaLocalDateTimeSerializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;


public class GsonSerializerTesting {

    private Gson gson;

    @Before
    public void setUp() {
        JsonSerializer<LocalDateTime> serializer = new JavaLocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME);
        JsonDeserializer<LocalDateTime> deserializer = new JavaLocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME);

        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, serializer)
                .registerTypeAdapter(LocalDateTime.class, deserializer);

        gson = gsonBuilder.create();
    }

    @Test
    public void serialization() {
        TestDateTime testDateTime = new TestDateTime();

        testDateTime.dateTimeCustom = LocalDateTime.now();
        testDateTime.dateTimeDefault = LocalDateTime.now();

        String json = gson.toJson(testDateTime);

        Assert.assertFalse(json.isEmpty());
    }

    @Test
    public void deserialization() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 06, 17, 13, 34, 39);

        String json = "{\"dateTimeCustom\": \"2019-06-17T13:34:39\", \"dateTimeDefault\": \"2019-06-17T13:34:39.000000\"}";

        TestDateTime dateTime = gson.fromJson(json, TestDateTime.class);

        Assert.assertNotNull(dateTime);

        assertThat(dateTime.dateTimeCustom).isEqualTo(localDateTime);
    }

    static class TestDateTime {
        LocalDateTime dateTimeCustom;
        LocalDateTime dateTimeDefault;
    }

}
