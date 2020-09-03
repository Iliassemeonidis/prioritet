package ru.idtm.documino;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class RequiredFields {
    private final static String BUTTON = "Выбрать";
    private final static String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private static final String DEPARTMENT1 = "Департамент 1";
    private static final String DEPARTMENT2 = "Департамент 2";
    private static final String DEPARTMENT3 = "Департамент 3";
    private static final String DEPARTMENT4 = "Департамент 4";
    private static final String DEPARTMENT5 = "Департамент 5";
    private static final String AUTOTEST_NAME1 = "Автотест1";
    private static final String AUTOTEST_NAME2 = "Автотест2";
    private static final String AUTOTEST_NAME3 = "Автотест3";
    private static final String AUTOTEST_NAME4 = "Автотест4";
    private static final String AUTOTEST_NAME5 = "Автотест5";
    private static final String AUTOTEST1 = "Автотест1 , Сотрудник, Департамент 1";
    private static final String AUTOTEST2 = "Автотест2 , Сотрудник, Департамент 2";
    private static final String AUTOTEST3 = "Автотест3 , Сотрудник, Департамент 3";
    private static final String AUTOTEST4 = "Автотест4 , Сотрудник, Департамент 4";
    private static final String AUTOTEST5 = "Автотест5 , Сотрудник, Департамент 5";
    private static final String AUTOTEST_ROSSET_TEST1 = "Автотест1, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_TEST2 = "Автотест2, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_TEST3 = "Автотест3, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_TEST4 = "Автотест4, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_TEST5 = "Автотест5, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME1 = "Автотест1 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник1";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME2 = "Автотест2 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник2";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME3 = "Автотест3 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник3";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME4 = "Автотест4 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник4";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME5 = "Автотест5 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник5";
    private static final String AUTOTEST1_AIDI = "Автотест1 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST2_AIDI = "Автотест2 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST3_AIDI = "Автотест3 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST4_AIDI = "Автотест4 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST5_AIDI = "Автотест5 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";

    public static void description(String text) {
        boolean visible = $(byXpath("//*[@id=\"dss_description\"]")).isDisplayed();
        if (visible) {
            $(byXpath("//*[@id=\"dss_description\"]")).setValue(text);
        } else {
            if (!($("#dss_description").is(Condition.visible))) {
                $("#dss_description").scrollIntoView(true);
            }
            $("#dss_description").setValue(text);
        }
        if ($("#dsid_stamp").is(Condition.visible)) {

            String grif = $("#dsid_stamp").getValue();
            if (grif.isEmpty()) {
                $("#dsid_stamp").click();
                sleep(1000);
                $(byText("Общего пользования")).click();
            }
        }
        //String s = $("#dsid_themes").getValue();
        if ($("#dsid_themes").is(Condition.visible)) {
            if ($("#dsid_themes").is(empty)) {
                $("#dsid_themes").setValue("Бизнес-процесс");
                $(byText("Бизнес-процесс")).click();
            }
        }


    }

    public static void addressee(String text) {
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[11]/div/div/div[1]/div/div/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue(text);
        $(byText("Главный специалист"))
                .click();
        $$(PATH).findBy(text(BUTTON)).click();

    }

    public static void addressee(String name, String emploer, String fulleName, String otherName) {

        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[11]/div/div/div[1]/div/div/div/div/div/div/div[1]/button")).is(visible)) {

            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[11]/div/div/div[1]/div/div/div/div/div/div/div[1]/button")).click();

            if (!($(byXpath("//*[@id=\"query\"]")).is(visible))) {
                $(byXpath("//*[@id=\"query\"]")).scrollIntoView(true);
            }
            $(byXpath("//*[@id=\"query\"]")).setValue(name);

            if ($(byText(emploer)).is(visible)) {

                $(byText(emploer)).click();

            } else {
                $("div.form-item-container:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                $("#query").setValue(name);
                sleep(1000);
                $(byText(name)).click();

            }
            $$(PATH).findBy(text(BUTTON)).click();

        }
        else {
            if ($(byXpath("//*[@id=\"drid_addressee_empl\"]")).is(visible)) {
                $(byXpath("//*[@id=\"drid_addressee_empl\"]")).setValue(name);
            } else if ($("#dsid_main_performer_empl").is(visible)) {
                $("#dsid_main_performer_empl").setValue(name);
            } else if (!($("#drid_addressee_empl").is(visible))) {
                $("#drid_addressee_empl").scrollIntoView(true);
                $("#drid_addressee_empl").setValue(name);
            }

            sleep(10000);

            if ($(byText(fulleName)).is(visible)) {
                $(byText(fulleName)).click();
            } else if ($("div.form-item-container:nth-child(9) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(9) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                sleep(1000);
                $("#query").setValue(name);
            } else if ($("div.form-item-container:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                sleep(1000);
                $("#query").setValue(name);
            } else if ($("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                sleep(1000);
                $("#query").setValue(name);
            }
            //$("#query").setValue(name);
            sleep(10000);
            if ($(byText("Тестовый отдел")).is(visible)) {
                $(byText("Тестовый отдел")).click();
                $$(PATH).findBy(text(BUTTON)).click();
            }else if ($(byText("ООО \"Айди-Технологии управления\"")).is(visible)) {
                $(byText("ООО \"Айди-Технологии управления\"")).click();
                $$(PATH).findBy(text(BUTTON)).click();
            } else if ($(byText(name)).is(visible)) {
                $(byText(name)).click();
                $$(PATH).findBy(text(BUTTON)).click();
            }
        }


        if($("#dsdt_control_date").is(visible)){
        $("#dsdt_control_date").click();
        sleep(1000);
        $(byText("15")).click();
    }


}
public static void addressee(String name, String emploer) {

        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[11]/div/div/div[1]/div/div/div/div/div/div/div[1]/button")).is(visible)) {

            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[11]/div/div/div[1]/div/div/div/div/div/div/div[1]/button")).click();

            if (!($(byXpath("//*[@id=\"query\"]")).is(visible))) {
                $(byXpath("//*[@id=\"query\"]")).scrollIntoView(true);
            }
            $(byXpath("//*[@id=\"query\"]")).setValue(name);

            if (!$(byText(emploer)).is(visible)) {
                $("div.form-item-container:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                $("#query").setValue(name);
                sleep(1000);

            }
            $(byText(emploer)).click();

        }
        else {
            if ($(byXpath("//*[@id=\"drid_addressee_empl\"]")).is(visible)) {
                $(byXpath("//*[@id=\"drid_addressee_empl\"]")).setValue(name);
            } else if ($("#dsid_main_performer_empl").is(visible)) {
                $("#dsid_main_performer_empl").setValue(name);
            } else if (!($("#drid_addressee_empl").is(visible))) {
                $("#drid_addressee_empl").scrollIntoView(true);
                $("#drid_addressee_empl").setValue(name);
            }

            sleep(10000);

            if ($(byText(emploer)).is(visible)) {
                $(byText(emploer)).click();
            }
            else if ($("div.form-item-container:nth-child(9) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(9) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                $("#query").setValue(name);

            } else if ($("div.form-item-container:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                $("#query").setValue(name);

            } else if ($("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();

            }
            sleep(10000);
            if ($(byText("Тестовый отдел")).is(visible)) {
                $(byText("Тестовый отдел")).click();
                $$(PATH).findBy(text(BUTTON)).click();
            }else if ($(byText("ООО \"Айди-Технологии управления\"")).is(visible)) {
                $(byText("ООО \"Айди-Технологии управления\"")).click();
                $$(PATH).findBy(text(BUTTON)).click();;
            } else if ($(byText(name)).is(visible)) {
                $(byText(name)).click();
                $$(PATH).findBy(text(BUTTON)).click();
            }
        }


    if($("#dsdt_control_date").is(visible)){
        $("#dsdt_control_date").click();
        sleep(1000);
        $$(byText("15")).last().click();
    }


}

    public static void signatory(String text) {
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[11]/div/div/div[1]/div[1]/div/div/div/div/div[1]/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue(text);
        $(byText("Главный специалист"))
                .click();
        $$(PATH).findBy(text(BUTTON)).click();

    }

    public static void completeFieldsForProactiveAssignments(String name, String fulleName) {
        $("#dsid_main_performer_empl").setValue(name);
        $(byText(fulleName)).click();
        $("#dsdt_control_date").click();
        $$(byText("15")).last().click();
    }

    public static void singer(String name, String fulleName,String scc) {

        Buttons.save();

        if ($("#dsid_for_signature_empl").is(visible)) {
            $("#dsid_for_signature_empl").setValue(name);
        } else if ($("#dsid_signer_empl").is(visible)) {
            $("#dsid_signer_empl").setValue(name);
        }
        sleep(10000);
        if (name.equals(AUTOTEST_NAME2)) {

            if ($(byText(fulleName)).is(visible)) {
                $(byText(fulleName)).click();

            } else {
                $(scc).click();
                $("#query").setValue(AUTOTEST_NAME2);
                sleep(10000);
                if ($(byText(AUTOTEST_NAME2)).is(visible)) {
                    $(byText(AUTOTEST_NAME2)).click();
                } else if ($(byText("Тестовый Филиал")).is(visible)) {
                    $(byText("Тестовый Филиал")).click();
                } else if ($(byText("Сотрудник")).is(visible)) {
                    $(byText("Сотрудник")).click();
                }
                $$(byText("Выбрать")).last().click();
            }
        } else if (name.equals(AUTOTEST_NAME5)) {

            if ($(byText(fulleName)).is(visible)) {
                $(byText(fulleName)).click();

            } else {
                $(scc).click();
                $("#query").setValue(AUTOTEST_NAME5);
                sleep(10000);
                if ($(byText(AUTOTEST_NAME5)).is(visible)) {
                    $(byText(AUTOTEST_NAME5)).click();
                } else if ($(byText("Тестовый Филиал")).is(visible)) {
                    $(byText("Тестовый Филиал")).click();
                } else if ($(byText("Сотрудник")).is(visible)) {
                    $(byText("Сотрудник")).click();
                }
                $$(byText("Выбрать")).last().click();
            }
        }
    }

    public static void checking() {

        if ($(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/div[3]/button[1]")).isDisplayed()) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/div[3]/button[1]")).click();
        } else {
            ElementsCollection el = $$(byText("Добавить этап"));
            el.get(0).click();
        }
        if ($("#term").is(visible)) {
            $("#term").setValue("5");
        }
        $(".layout-icon").click();
        if (!($(byXpath("//*[@id=\"branchId\"]")).has(text("Тестовый Филиал"))) || !($(byXpath("//*[@id=\"branchId\"]")).has(text("Тестовый филиал")))) {

            $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");
            sleep(1000);
            if ($(byText("Тестовый филиал")).is(Condition.visible)) {

                $(byText("Тестовый филиал")).click();
            } else {
                if ($(byText("Тестовый Филиал")).is(Condition.visible)) {

                    $(byText("Тестовый Филиал")).click();
                } else {
                    $(byXpath("//*[@id=\"branchId\"]")).pressEnter();
                }
            }
        }
        sleep(1000);
        $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME3).pressEnter();
        sleep(10000);
        if ($(byText(DEPARTMENT3)).is(Condition.visible)) {
            $(byText(DEPARTMENT3)).click();
        } else if ($(byText("Тестовый отдел")).is(Condition.visible)){
                $(byText("Тестовый отдел")).click();
            } else if ($(byText(AUTOTEST_NAME3)).is(visible)){
                $(byText(AUTOTEST_NAME3)).click();
        }
        $$(PATH).findBy(text(BUTTON)).click();

        if (!$(byText("Добавить")).isDisplayed()) {
            $$(byText("Сохранить")).get($$(byText("Сохранить")).size()-1).click();
        } else $(byText("Добавить")).click();
        sleep(1000);
    }


    public static void counterparty(String name, String scc) {
        $(scc).scrollIntoView(true);
        $(scc).click();
        $("#fio").setValue(name);
        sleep(10000);

        if (name.equals(AUTOTEST_NAME3)) {
            if ($(byText("Автотест3 А. Т.")).is(visible)) {
                $(byText("Автотест3 А. Т.")).click();
            } else if ($(byText("ПАО \"ЛЕНЭНЕРГО\"")).is(visible)) {
                $(byText("ПАО \"ЛЕНЭНЕРГО\"")).click();
            } else if ($(byText("Сотрудник 3")).is(visible)) {
                $(byText("Сотрудник 3")).click();
            }
            $$(byText("Выбрать")).last().click();
        } else if (name.equals(AUTOTEST_NAME1)) {
            if ($(byText("Автотест1")).is(visible)) {
                $(byText("Автотест1")).click();
            } else if ($(byText("Сотрудник")).is(visible)) {
                $(byText("Сотрудник")).click();
            }else if ($(byText("ПАО \"Кубаньэнерго\"")).is(visible)) {
                $(byText("ПАО \"Кубаньэнерго\"")).click();
            }
            $$(byText("Выбрать")).last().click();
        }
    }

    public static void curator(String name, String sccButtn, String cssFio) {
        if (!$("#dsid_curator_empl").is(visible)) {
            $("#dsid_curator_empl").scrollIntoView(true);
        }
        $("#dsid_curator_empl").setValue(name);
        sleep(10000);
        if (name.equals(AUTOTEST_NAME4)) {
            if ($(byText(AUTOTEST4)).is(visible)) {
                $(byText(AUTOTEST4)).click();
            } else if ($(sccButtn).is(visible)) {
                $(sccButtn).click();
                sleep(1000);
                $(cssFio).setValue(name);
                sleep(10000);
                if ($(byText(AUTOTEST_NAME4)).is(visible)) {
                    $(byText(AUTOTEST_NAME4)).click();
                } else if ($(byText("Тестовый Филиал")).is(visible)) {
                    $(byText("Тестовый Филиал")).click();
                } else if ($(byText(DEPARTMENT4)).is(visible)) {
                    $(byText(DEPARTMENT4)).click();
                }
                $$(byText("Выбрать")).last().click();
            }


        }
    }

    public static void agentPerson(String name) {
        // Внешний аресат
        sleep(1000);


        if (!($("#dsid_agent_person").is(visible))) {
            $("#dsid_agent_person").scrollIntoView(true);
        }
        if (name.equals(AUTOTEST_NAME3)) {

            $("#dsid_agent_person").setValue(AUTOTEST_NAME3);

            sleep(1000);

            if ($(byText("Автотест3 А. Т.,ПАО \"ЛЕНЭНЕРГО\",Сотрудник 3")).is(visible)) {
                $$(byText("Автотест3 А. Т.,ПАО \"ЛЕНЭНЕРГО\",Сотрудник 3")).first().click();
            } else if ($(byText("Автотест3 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник3")).is(visible)) {
                $(byText("Автотест3 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник3")).click();
            } else if ($("div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                $("#fio").setValue(AUTOTEST_NAME3);
                sleep(1000);
                $(byText("Сотрудник3")).click();
                $$(PATH).findBy(text(BUTTON)).click();
            } else if ($("div.form-item-container:nth-child(16) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(16) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                $("#fio").setValue(AUTOTEST_NAME1);
                sleep(1000);
                $(byText("Сотрудник1")).click();
                $$(PATH).findBy(text(BUTTON)).click();
            }
        } else if (name.equals(AUTOTEST_NAME1)) {
            $("#dsid_agent_person").setValue(AUTOTEST_NAME1);
            sleep(10000);
            if ($(byText("Автотест1, Сотрудник, ПАО \"Кубаньэнерго\"")).is(visible)) {
                $(byText("Автотест1, Сотрудник, ПАО \"Кубаньэнерго\"")).click();
            }
        }
    }

    public static void addresseeEmpl(String name, String longName) {
        //Внутренний адресат
        if (!$("#drid_addressee_empl").is(visible)) {
            $("#drid_addressee_empl").scrollIntoView(true);
        }
        $("#drid_addressee_empl").setValue(name);
        sleep(10000);
        $(byText(longName)).click();
        //"Автотест4 , Сотрудник, Тестовый отдел"
    }


    public static void secretaryEmpl(String name, String longName) {
        //Ответственный секретарь
        if (!$("#dsid_secretary_empl").is(visible)) {
            $("#dsid_secretary_empl").scrollIntoView(true);
        }
        $("#dsid_secretary_empl").setValue(name);
        sleep(10000);
        $(byText(longName)).click();
        //"Автотест4 , Сотрудник, Тестовый отдел"
    }



}
