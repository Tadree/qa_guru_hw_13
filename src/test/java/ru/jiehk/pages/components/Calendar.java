package ru.jiehk.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {

    private SelenideElement yearSelector = $(".react-datepicker__year-select"),
            monthSelector = $(".react-datepicker__month-select");

    public Calendar setDate(String year, String month, String day) {
        yearSelector.selectOption(year);
        monthSelector.selectOption(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }
}
