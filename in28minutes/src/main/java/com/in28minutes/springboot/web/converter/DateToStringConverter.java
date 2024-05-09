package com.in28minutes.springboot.web.converter;
import org.springframework.core.convert.converter.Converter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStringConverter implements Converter<Date, String> {

    @Override
    public String convert(Date source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(source);
    }
}
