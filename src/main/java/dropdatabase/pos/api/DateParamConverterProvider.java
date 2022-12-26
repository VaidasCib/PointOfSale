package dropdatabase.pos.api;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Provider
public class DateParamConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType != Date.class) {
            return null;
        }
        return new ParamConverter<T>() {
            final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            @Override
            public T fromString(String value) {
                try {
                    return rawType.cast(parse(value));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override
            public String toString(T value) {
                return dateFormat.format((Date) value);
            }
        };
    }

    public static Date parse(String dateString) throws ParseException {
        // Try parsing the date string with various date formats
        String[] formats = {
                "yyyy-MM-dd'T'HH:mm:ss'Z'", // ISO 8601
                "yyyy-MM-dd HH:mm:ss", // MySQL
                "yyyy-MM-dd", // Simple date
                "EEEE, MMMM d, yyyy", // Long date
                "MM/dd/yyyy", // Short date
                "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" // ISO 8601 with milliseconds and time zone
        };

        for (String format : formats) {
            try {
                // Try parsing the date string with the current format
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
                sdf.setLenient(false);
                return sdf.parse(dateString);
            } catch (ParseException e) {
                // Ignore the exception and try the next format
            }
        }

        // If all formats have been tried and none worked, throw an exception
        throw new ParseException("Unable to parse date: " + dateString, 0);
    }
}