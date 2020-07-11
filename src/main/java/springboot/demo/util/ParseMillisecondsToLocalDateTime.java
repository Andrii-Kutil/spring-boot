package springboot.demo.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.util.CsvContext;

public class ParseMillisecondsToLocalDateTime extends CellProcessorAdaptor {

    public ParseMillisecondsToLocalDateTime() {
        super();
    }

    @Override
    public LocalDateTime execute(Object value, CsvContext csvContext) {
        validateInputNotNull(value, csvContext);
        String milliseconds = String.valueOf(value);
        return LocalDateTime
                .ofInstant(Instant
                        .ofEpochMilli(Long.parseLong(milliseconds)), ZoneId.systemDefault());
    }
}
