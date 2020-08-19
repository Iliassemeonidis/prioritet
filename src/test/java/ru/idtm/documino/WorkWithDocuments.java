package ru.idtm.documino;

import com.codeborne.selenide.Condition;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class WorkWithDocuments {

    public static void tryToFindDocWithDescription(String description) {
        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).is(Condition.visible)) {

            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
            $(byXpath("//*[@id=\"desc\"]")).setValue(description);
            sleep(10000);
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
            sleep(1000);
        } else if ($("#desc").is(Condition.visible)) {
            $("#desc").setValue(description);
            sleep(10000);
        }


        if ($(byText("Распорядительные документы")).is(Condition.visible)) {

            $$(byText("Распорядительные документы"))
                    .first()
                    .click();
        } else if ($(byText("ОРД")).is(Condition.visible)) {
            $$(byText("ОРД"))
                    .first()
                    .click();
        } else if ($(byText("Материалы")).is(Condition.visible)) {
            $$(byText("Материалы"))
                    .first()
                    .click();
        } else if ($(byText("Договоры (ВОЛС)")).is(Condition.visible)) {
            $$(byText("Договоры (ВОЛС)"))
                    .first()
                    .click();
        } else if ($(byText("Дополнительное соглашение (ВОЛС)")).is(Condition.visible)) {
            $$(byText("Дополнительное соглашение (ВОЛС)"))
                    .first()
                    .click();
        } else if ($(byText("Первичная документация")).is(Condition.visible)) {
            $$(byText("Первичная документация"))
                    .first()
                    .click();
        } else if ($(byText("Приказы о командировании")).is(Condition.visible)) {
            $$(byText("Приказы о командировании"))
                    .first()
                    .click();
        }else if ($(byText("Договор (КЭ)")).is(Condition.visible)) {
            $$(byText("Договор (КЭ)"))
                    .first()
                    .click();
        }else if ($(byText("Договоры")).is(Condition.visible)) {
            $$(byText("Договоры"))
                    .first()
                    .click();
        }else if ($(byText("Дополнительное соглашение (КЭ)")).is(Condition.visible)) {
            $$(byText("Дополнительное соглашение (КЭ)"))
                    .first()
                    .click();
        }else if ($(byText("Дополнительное соглашение")).is(Condition.visible)) {
            $$(byText("Дополнительное соглашение"))
                    .first()
                    .click();
        }else if ($(byText("Выписка из протоколов")).is(Condition.visible)) {
            $$(byText("Выписка из протоколов"))
                    .first()
                    .click();
        }else if ($(byText("Протокол")).is(Condition.visible)) {
            $$(byText("Протокол"))
                    .first()
                    .click();
        } else if ($(byText("Протоколы органов управления")).is(Condition.visible)) {
            $$(byText("Протоколы органов управления"))
                    .first()
                    .click();
        } else if ($(byText("Материалы органов управления")).is(Condition.visible)) {
            $$(byText("Материалы органов управления"))
                    .first()
                    .click();
        }else if ($(byText("Выписки из протоколов органов управления")).is(Condition.visible)) {
            $$(byText("Выписки из протоколов органов управления"))
                    .first()
                    .click();
        }

    }

    public static void tryToFindDocWithRegNumber(String regNumber) {
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
        $(byXpath("//*[@id=\"desc\"]")).setValue(regNumber);
        sleep(10000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
        sleep(1000);
        $$(byText("Распорядительные документы"))
                .first()
                .click();

    }


    public static void tryToFindDocWithSinger(String singer) {
        // ием по подписанту
        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).is(Condition.visible)) {

            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
            $(byXpath("//*[@id=\"desc\"]")).setValue(singer);
            sleep(10000);
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
            sleep(1000);
            if ($(byText("Распорядительные документы")).is(Condition.visible)) {

                $$(byText("Распорядительные документы"))
                        .first()
                        .click();
            } else {
                $$(byText("ОРД"))
                        .first()
                        .click();
            }
        } else if ($("#desc").is(Condition.visible)) {
            $("#desc").setValue(singer);
            sleep(10000);

            if ($(byText("Распорядительные документы")).is(Condition.visible)) {

                $$(byText("Распорядительные документы"))
                        .first()
                        .click();
            } else {
                $$(byText("ОРД"))
                        .first()
                        .click();
            }
        }

    }


    public static void tryToFindDoc(String text) {
        // ием по подписанту
        if (!$(byText("Все задания")).isDisplayed()) {
            $(byText("Мои задания")).click();
        }
        $(byText("Все задания")).click();
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
        $(byXpath("//*[@id=\"desc\"]")).setValue(text);
        sleep(10000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
        sleep(1000);
        $$(byText(text))
                .first()
                .click();

    }

    public static void tryToFindDoc(String text, String description) {
        // ием по подписанту
        if (!($(byText("Все задания")).isDisplayed())) {
            $(byText("Мои задания")).click();
        }
        $(byText("Все задания")).click();
        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).is(Condition.visible)) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/button")).click();
            $(byXpath("//*[@id=\"desc\"]")).setValue(text);
            sleep(10000);
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/div[1]/div[1]/div/div[4]/div[2]/button")).click();
            sleep(1000);
            $$(byText(description))
                    .first()
                    .click();
        } else if ($("#desc").is(Condition.visible)) {
            $("#desc").setValue(text);
            sleep(10000);
            $$(byText(description))
                    .first()
                    .click();
        }

    }

    public static void visibleElement(String element) {
        boolean visible = $(byText(element)).isDisplayed();

        if (!visible) {
            $(byText("Мои задания")).click();
        }
    }

    public static void visibleElementWithText(String element, String text) {
        boolean visible = $(byText(element)).is(Condition.visible);

        if (!visible) {
            $(byText(text)).click();
        } else $(byText(element)).click();
    }

    public static void visibleElementWithXpath(String element, String text) {
        boolean visible = $(byXpath(element)).is(Condition.visible);

        if (!visible) {
            $(byXpath(text)).click();
        } else $(byXpath(element)).click();
    }

    public static void visibleElementWithXpathAndCss(String element, String text) {
        boolean visible = $(byXpath(element)).is(Condition.visible);
        if (visible) {
            $(byXpath(text)).click();

        } else $(element).click();
    }


    public static void accept(String registrationNumber) {
        // подтверждаем
        Buttons.allTasks();
        sleep(10000);
        WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
        sleep(1000);
        Buttons.accept();
        sleep(1000);
        Buttons.allTasks();
        sleep(10000);
        WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
    }

    public static void rejectSociety(String registrationNumber, String fileName) {

        Buttons.allTasks();
        sleep(10000);
        WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
        sleep(10000);
        Buttons.rejectSociety();
        sleep(1000);
        $("#reportText").setValue("Правки по тексту");
        sleep(1000);
        Content.contentUploadLast(fileName);
        sleep(1000);
        $$(byText("Отклонён обществом")).last().click();
    }

    public static void signedBySociety(String fileName) {

        // принятие обществом
        sleep(1000);
        Buttons.signedBySociety();
        System.out.println($$("input").size());
        int count = 0;
        while (!$(".drop-zone-container").has(text("ответ")) && count < $$("input").size()) {
            $$("input").get(count).uploadFile(new File(fileName));
            count++;
        }
        sleep(1000);
        $$(byText("Сохранить")).last().click();
        sleep(10000);

    }

    public static void contragent(String registrationNumber) {

        Buttons.allTasks();
        sleep(10000);
        WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
        sleep(1000);

        Buttons.singedCoutragent();
        $$(byText("Подписать")).last().click();
        sleep(10000);
    }

    public static void documentCheck(String identifier, String description ) {
        sleep(10000);
        Buttons.searchIcon();
        $(byText("По документам")).click();
        $(byText("Идентификатор")).scrollIntoView(true);
        $("div.input-field-container:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue(identifier);
        sleep(1000);
        Buttons.search();
        sleep(10000);
        if ($(byText("Зарегистрирован")).is(Condition.visible)) {
            $(byText("Зарегистрирован")).click();
        } else if ($(byText(description)).is(Condition.visible)) {
            $(byText(description)).click();
        }
        sleep(1000);
        Buttons.history();
        sleep(1000);
        $(byText("Зарегистрировано")).shouldBe(Condition.visible);

         Buttons.content();
        sleep(10000);
        $("div.scroll-bar:nth-child(1)").shouldHave(Condition.text("ответ"));
    }


}
