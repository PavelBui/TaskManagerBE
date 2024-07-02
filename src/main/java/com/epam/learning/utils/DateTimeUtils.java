package com.epam.learning.utils;

import com.epam.learning.exeption.InvalidValidationException;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@UtilityClass
public class DateTimeUtils {

    public String convertDateToString(LocalDateTime now) {
        if (Objects.nonNull(now)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return now.format(formatter);
        } else {
            return null;
        }
    }

    public LocalDateTime convertStringToDate(String str) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            return LocalDateTime.parse(str, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidValidationException("Date should be in form (yyyy-MM-dd HH:mm)");
        }
    }
}
