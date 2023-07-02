package ru.jiehk.utils;

import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static List<String> monthsList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December");

    public String getRandomDay(String year, String month) {
        YearMonth yearMonthObject = YearMonth.of(Integer.parseInt(year), monthsList.indexOf(month) + 1);
        int newDay = ThreadLocalRandom.current().nextInt(1, yearMonthObject.lengthOfMonth() + 1);
        return String.format("%02d", newDay);
    }
}
