package ru.jiehk.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {

    private SelenideElement resultsModal = $(".modal-dialog"),
            resultsModalTitle = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive table");

    private final static String TITLE_TEXT = "Thanks for submitting the form";

    public ResultsModal checkVisible() {
        resultsModal.should(appear);
        resultsModalTitle.shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultsModal checkResult(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

}
