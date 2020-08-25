package ru.idtm.documino;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CreateDocument {

    public static void create(String documentName) {
        if (!$(byText("Создать документ")).is(Condition.visible)) {
            UserChange.exit();
            UserChange.comInAutotest1();
        }

        $(byText("Создать документ")).click();
        sleep(1000);
        boolean visible = $(byText(documentName)).isDisplayed();
        if (visible) {
            $(byText(documentName)).click();

        } else {
            // $(byText("Создать документ")).click();
            $("html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog div.el-dialog__body div div.dialogue-container div.items-container div.scroll-wrap div.search-input-wrapper div.input-with-select.el-input input.el-input__inner").setValue(documentName);
            $$(byText(documentName)).first().click();
            sleep(10000);
        }

        if (!$(byText("Создать")).is(Condition.visible)) {

            $(byText("Создать")).scrollIntoView(true);
        }
        $(byText("Создать")).click();
    }

    public static void createDoc(String documentName, String otherNAme) {
        if (!$(byText("Создать документ")).is(Condition.visible)) {
            UserChange.exit();
            UserChange.comInAutotest1();
        }

        $(byText("Создать документ")).click();

        sleep(1000);

        if ($(byText(documentName)).is(Condition.visible)) {
            $(byText(documentName)).click();

            sleep(1000);
            if ($$(byText(otherNAme)).size() > 3) {

                $(byText(otherNAme)).click();
            }
        } else {

            $("html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog div.el-dialog__body div div.dialogue-container div.items-container div.scroll-wrap div.search-input-wrapper div.input-with-select.el-input input.el-input__inner").setValue(documentName);

            sleep(10000);

            $(byText(documentName)).click();

            if ($(byText(otherNAme)).is(Condition.visible)) {

                $(byText(otherNAme)).click();
            }
            sleep(10000);
        }
        if (!($(byText("Создать")).is(Condition.visible))) {
            $(byText("Создать")).scrollIntoView(true);
        }
        $(byText("Создать")).click();
    }

    public static void create(String documentName, String otherNAme) {
        if (!$(byText("Создать документ")).is(Condition.visible)) {
            UserChange.exit();
            UserChange.comInAutotest1();
        }
        $(byText("Создать документ")).click();
        sleep(10000);
        if ($(byText(documentName)).is(Condition.visible)) {
            $(byText(documentName)).click();
        } else {
            $("html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog div.el-dialog__body div div.dialogue-container div.items-container div.scroll-wrap div.search-input-wrapper div.input-with-select.el-input input.el-input__inner").setValue(documentName);
            if ($(byText(documentName)).is(Condition.visible)) {
                $$(byText(documentName)).first().click();

            } else {
                $("html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog div.el-dialog__body div div.dialogue-container div.items-container div.scroll-wrap div.search-input-wrapper div.input-with-select.el-input input.el-input__inner").setValue(otherNAme);
                $(byText(otherNAme)).click();
            }
            sleep(10000);
        }
        if ($(byText(otherNAme)).is(Condition.visible)) {
            $(byText(otherNAme)).click();
        }
        if (!($(byText("Создать")).is(Condition.visible))) {
            $(byText("Создать")).scrollIntoView(true);
        }
        $(byText("Создать")).click();
    }

    public static void createGovernanceDocuments(String groupName, String protocolGroup, String protocol) {

        if (!$(byText("Создать документ")).is(Condition.visible)) {
            UserChange.exit();
            UserChange.comInAutotest1();
        }

        $(byText("Создать документ")).click();

        sleep(1000);
        if (!$(byText(groupName)).is(Condition.visible)) {
            $(byText(groupName)).scrollIntoView(true);
        }

        if ($$(byText(groupName)).size() > 1) {
            $$(byText(groupName)).first().click();
        } else {

            $(byText(groupName)).click();
        }
        sleep(1000);
        if (!$(byText(protocolGroup)).is(Condition.visible)) {
            $(byText(protocolGroup)).scrollIntoView(true);
        }
        if ($$(byText(protocolGroup)).size() > 1) {

            $$(byText(protocolGroup)).last().click();
        } else {

            $(byText(protocolGroup)).click();
        }
        sleep(10000);
        if (!$(byText(protocol)).is(Condition.visible)) {
            $(byText(protocol)).scrollIntoView(true);
        }
        $$(byText(protocol)).last().click();


        if (!($(byText("Создать")).is(Condition.visible))) {
            $(byText("Создать")).scrollIntoView(true);
        }
        $(byText("Создать")).click();
    }

    public static void createForeGovernanceDocuments(String groupName, String protocolGroup, String protocol, String name) {

        if (!$(byText("Создать документ")).is(Condition.visible)) {
            UserChange.exit();
            UserChange.comInAutotest1();
        }


        $(byText("Создать документ")).click();
        sleep(1000);
        if (!$(byText(groupName)).is(Condition.visible)) {
            $(byText(groupName)).scrollIntoView(true);
        }

        if ($$(byText(groupName)).size() > 1) {
            $$(byText(groupName)).first().click();
        } else {

            $(byText(groupName)).click();
        }
        sleep(1000);
        if (!$(byText(protocolGroup)).is(Condition.visible)) {
            $(byText(protocolGroup)).scrollIntoView(true);
        }
        if ($$(byText(protocolGroup)).size() > 1) {

            $$(byText(protocolGroup)).last().click();
        } else {

            $(byText(protocolGroup)).click();
        }
        sleep(10000);
        if (!$(byText(protocol)).is(Condition.visible)) {
            $(byText(protocol)).scrollIntoView(true);
        }
        $$(byText(protocol)).last().click();
        if (!$(byText(name)).is(Condition.visible)) {
            $(byText(name)).scrollIntoView(true);
        }
        $$(byText(name)).last().click();


        if (!($(byText("Создать")).is(Condition.visible))) {
            $(byText("Создать")).scrollIntoView(true);
        }
        $(byText("Создать")).click();
    }


    public static void createWithTowNames(String documentName, String otherNAme) {
        if (!$(byText("Создать документ")).is(Condition.visible)) {
            UserChange.exit();
            UserChange.comInAutotest1();
        }
        $(byText("Создать документ")).click();

        if (!$(byText(documentName)).is(Condition.visible)) {
            $(byText(documentName)).scrollIntoView(true);
        }
        $(byText(documentName)).click();
        sleep(1000);
        $(byText(otherNAme)).click();


        if (!($(byText("Создать")).is(Condition.visible))) {
            $(byText("Создать")).scrollIntoView(true);
        }
        $(byText("Создать")).click();
    }


}
