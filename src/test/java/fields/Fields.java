package fields;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class Fields {
    private static final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private static final String BUTTON = "Выбрать";
    private static boolean visible;

    public static void agreement(String shortName, String department, String longName) {
        // Согласующий
        visible = $(byXpath("//div[@class='column-container']//div[4]//div[2]//div[1]//div[1]//div[3]//button[1]//div[1]//*[local-name()='svg']")).is(Condition.visible);

        if (visible) {
            $(byXpath("//div[@class='column-container']//div[4]//div[2]//div[1]//div[1]//div[3]//button[1]//div[1]//*[local-name()='svg']")).click();

            visible = $(byXpath("//div[contains(@class,'input-wrapper')]//div[contains(@class,'user-list-container')]//div//div[@class='el-tooltip']//*[local-name()='svg']")).is(Condition.visible);

            if (visible) {

                $(byXpath("//div[contains(@class,'input-wrapper')]//div[contains(@class,'user-list-container')]//div//div[@class='el-tooltip']//*[local-name()='svg']")).click();
            }
            boolean dis = $(byXpath("//*[@id=\"branchId\"]")).isDisplayed();
            if (dis) {
                $(byXpath("//*[@id=\"branchId\"]")).click();
                $(byText("Тестовый Филиал")).click();
                sleep(1000);
            }
            dis = $(byXpath("//*[@id=\"query\"]")).isDisplayed();

            if (dis) {
                $(byXpath("//*[@id=\"query\"]")).setValue(shortName).pressEnter();
                $(byText(department)).click();
                sleep(1000);
                $$(PATH).findBy(text(BUTTON)).click();
            } else {
                $$(PATH).findBy(text(BUTTON)).click();
                $("#selectedUsers").setValue(shortName);
                sleep(10000);
                $(byText(longName)).click();
            }
            $(byText("Добавить")).click();

        } else {
            if ($("#approvers").is(Condition.visible)) {
                $("#approvers").setValue(shortName);
                sleep(10000);
                if ($(byText(longName)).is(Condition.visible)) {
                    sleep(1000);
                    $(byText(longName)).click();
                } else {
                    $(".layout-icon").click();
                    sleep(1000);
                    $(byXpath("//*[@id=\"query\"]")).setValue(shortName).pressEnter();
                    sleep(10000);
                    if (!($(byText(shortName)).is(Condition.visible))) {
                        $(byText(shortName)).scrollIntoView(true);
                    }
                    $(byText(shortName)).click();
                    sleep(10000);
                    $$(PATH).findBy(text(BUTTON)).click();
                }
            }
        }
        sleep(1000);
        $$(byText("Сохранить")).get($$(byText("Сохранить")).size()-1).click();
        sleep(1000);

    }


    public static void checking(String shortName, String department) {
        // прверяющий
        visible = $("#term").is(Condition.visible);
        if (visible) {
            $("#term").setValue("2");
        }
        $(".layout-icon").click();
        $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
        sleep(10000);
        if ($(byText("Тестовый Филиал")).is(Condition.visible)) {

            $(byText("Тестовый Филиал")).click();
        } else {
            if ($(byText("Тестовый филиал")).is(Condition.visible)) {

                $(byText("Тестовый филиал")).click();
            } else $(byXpath("//*[@id=\"branchId\"]")).pressEnter();
        }
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue(shortName).pressEnter();
        sleep(1000);
        if ($(byText(department)).is(Condition.visible)) {

            $(byText(department)).click();
        } else {
            $(byText(shortName)).click();
        }
        $$(PATH).findBy(text(BUTTON)).click();
    }


    public static void singer(String shortName, String department, String longName, String visibleName, String nameRossetLong) {

        boolean visible = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div/div[1]/div/div/div/div/div[1]/button")).isDisplayed();
        if (visible) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div/div[1]/div/div/div/div/div[1]/button")).click();
            $("div.input-select-container:nth-child(3) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)").click();
            sleep(1000);
            $(byXpath("//*[@id=\"query\"]")).setValue(shortName);
            sleep(1000);

            if (!($(byXpath("//*[@id=\"branchId\"]")).has(text("Тестовый Филиал"))) || !($(byXpath("//*[@id=\"branchId\"]")).has(text("Тестовый филиал")))) {

                $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
                if ($(byXpath("//*[@id=\"branchId\"]")).has(text("Тестовый Филиал"))) {

                    $(byText("Тестовый Филиал")).click();
                } else {
                    $(byText("Тестовый филиал")).click();
                }
            }
            $(byText(department)).click();
            $$(PATH).findBy(text(BUTTON)).click();
        } else {
            if (!($("#dsid_signer_empl").is(Condition.visible))) {

                $("#dsid_signer_empl").scrollIntoView(true);
            }
            $("#dsid_signer_empl").setValue(shortName);
            sleep(10000);
            if (!($(byText(longName)).is(Condition.visible))) {
                sleep(1000);
                if ($(byText(visibleName)).is(Condition.visible)) {
                    sleep(1000);
                    $(byText(visibleName)).click();
                } else {
                    if ($(byText(nameRossetLong)).is(Condition.visible)) {

                        $(byText(nameRossetLong)).click();
                    } else {
                        if ($("div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(Condition.visible)) {

                            $("div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                        } else {
                            sleep(10000);
                            if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[10]/div/div/div[1]/div/div/div/div/div/div[1]/button")).is(Condition.visible)) {

                                $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[10]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
                            } else {
                                $("div.form-item-container:nth-child(15) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                            }
                        }
                        $("#query").setValue(shortName);
                        sleep(10000);
                        if ($(byText("Тестовый отдел")).is(Condition.visible)) {

                            $(byText("Тестовый отдел")).click();
                        } else {
                            $(byText(shortName)).click();
                        }
                        $$(PATH).findBy(text(BUTTON)).click();
                    }
                }
            } else {
                $(byText(longName)).click();
            }
        }
    }

    public static void singer(String shortName, String longName) {

        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div/div[1]/div/div/div/div/div[1]/button")).isDisplayed()) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div/div[1]/div/div/div/div/div[1]/button")).click();
            $("div.input-select-container:nth-child(3) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)").click();
            sleep(1000);
            $(byXpath("//*[@id=\"query\"]")).setValue(shortName);
            sleep(1000);

            if (!($(byXpath("//*[@id=\"branchId\"]")).has(text("Тестовый Филиал"))) || !($(byXpath("//*[@id=\"branchId\"]")).has(text("Тестовый филиал")))) {

                $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
                if ($(byXpath("//*[@id=\"branchId\"]")).has(text("Тестовый Филиал"))) {

                    $(byText("Тестовый Филиал")).click();
                } else {
                    $(byText("Тестовый филиал")).click();
                }
            }
            $$(PATH).findBy(text(BUTTON)).click();
        } else {
            if (!($("#dsid_signer_empl").is(Condition.visible))) {

                $("#dsid_signer_empl").scrollIntoView(true);
            }
            $("#dsid_signer_empl").setValue(shortName);
            sleep(10000);
            if (!($(byText(longName)).is(Condition.visible))) {
                sleep(1000);

                if ($("div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(Condition.visible)) {

                    $("div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                } else {
                    sleep(10000);
                    if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[10]/div/div/div[1]/div/div/div/div/div/div[1]/button")).is(Condition.visible)) {

                        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[10]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
                    } else {
                        $("div.form-item-container:nth-child(15) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                    }
                }
                $("#query").setValue(shortName);
                sleep(10000);
                if ($(byText("Тестовый отдел")).is(Condition.visible)) {

                    $(byText("Тестовый отдел")).click();
                } else {
                    $(byText(shortName)).click();
                }
                $$(PATH).findBy(text(BUTTON)).click();
            }
            else $(byText(longName)).click();


        }

    }
}