package ru.idtm.documino;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class Content {
    public static void contentUpload(String fileName) {

        $$("input")
                .first()
                .uploadFile(new File(fileName));

        //$("input").uploadFile(new File(fileName));
    }
    public static void contentUploadLast(String fileName) {

        $$("input")
                .last()
                .uploadFile(new File(fileName));

        //$("input").uploadFile(new File(fileName));
    }
    public static void contentUploadForAnswer(String fileName) {

      ElementsCollection elements = $$("input");
        if (elements.size() > 3) {
            elements
                    .get(2)
                    .uploadFile(new File(fileName));
        } else {
            elements
                    .get(1)
                    .uploadFile(new File(fileName));
        }


    }
public static void contentUploadMax(String fileName) {

    int count = 0;
    while (!$(".drop-zone-container").has(text("ответ")) && count < $$("input").size()) {
        $$("input").get(count).uploadFile(new File(fileName));
        count++;
    }

    }

}
