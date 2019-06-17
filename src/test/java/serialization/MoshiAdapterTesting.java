package serialization;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import me.destro.java.toolkit.serialization.moshi.JavaLocalDateTimeAdapter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;


public class MoshiAdapterTesting {

    static class TestDateTime {
        LocalDateTime dateTimeCustom;
        LocalDateTime dateTimeDefault;
    }

    private Moshi moshi;
    private JsonAdapter<TestDateTime> adapter;

    @Before
    public void setUp() {
        moshi = new Moshi.Builder()
                .add(new JavaLocalDateTimeAdapter(DateTimeFormatter.ISO_DATE_TIME))
                .build();

        adapter = moshi.adapter(TestDateTime.class);
    }

    @Test
    public void serialization() {
        TestDateTime testDateTime = new TestDateTime();

        testDateTime.dateTimeCustom = LocalDateTime.now();
        testDateTime.dateTimeDefault = LocalDateTime.now();

        String json = adapter.toJson(testDateTime);
        Assert.assertFalse(json.isEmpty());
    }

    @Test
    public void deserialization() throws IOException {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 06, 17, 13, 34, 39);

        String json = "{\"dateTimeCustom\": \"2019-06-17T13:34:39\", \"dateTimeDefault\": \"2019-06-17T13:34:39.000000\"}";

        TestDateTime dateTime = adapter.fromJson(json);

        Assert.assertNotNull(dateTime);

        assertThat(dateTime.dateTimeCustom).isEqualTo(localDateTime);
    }
}