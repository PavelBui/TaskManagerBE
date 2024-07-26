package com.epam.learning.utils;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Objects;

@UtilityClass
public class DateTimeUtils {

    public Long convertDateToTimestamp(LocalDateTime localDateTime) {
        if (Objects.nonNull(localDateTime)) {
            OffsetDateTime odt = localDateTime.atZone(ZoneId.systemDefault()).toOffsetDateTime();
            return localDateTime.toInstant(odt.getOffset()).toEpochMilli();
        } else {
            return null;
        }
    }

    public LocalDateTime convertTimestampToDate(Long timestampLong) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestampLong), ZoneId.systemDefault());
    }
}
