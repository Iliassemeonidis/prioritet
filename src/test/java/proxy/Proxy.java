package proxy;

import ru.idtm.documino.Buttons;
import ru.idtm.documino.Content;
import ru.idtm.documino.CreateDocument;
import ru.idtm.documino.OpenBrowser;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Proxy {


    private static final String PROXY_DOC = "Доверенность на курьера.png";
    private static String description;
    private static final String DEPARTMENT5 = "Департамент 5";
    private static final String AUTOTEST5 = "Автотест5 , Сотрудник, Департамент 5";
    private static final String AUTOTEST_NAME5 = "Автотест5";
    private static final String BUTTON = "Выбрать";
    private static final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private static final String AUTOTEST5_TNT_EMPLOER = "Автотест5 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST1_TNT_EMPLOER = "Автотест1 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST1 = "Автотест1 , Сотрудник, Департамент 1";
    private static final String AUTOTEST_NAME1 = "Автотест1";
    private static String corentUrl;
    private static String registrationNumber;
    private static String identifier;
    private static String temporaryNumber;

    private static final String AUTOTEST2 = "Автотест2 , Сотрудник, Департамент 2";
    private static final String AUTOTEST_NAME2 = "Автотест2";

    private static final String AUTOTEST_KUBAN1 = "Автотест1 , Сотрудник, Тестовый отдел";
    private static final String AUTOTEST_KUBAN2 = "Автотест2 , Сотрудник, Тестовый отдел";
    private static final String AUTOTEST_KUBAN3 = "Автотест3 , Сотрудник, Тестовый отдел";
    private static final String AUTOTEST_KUBAN4 = "Автотест4 , Сотрудник, Тестовый отдел";
    private static final String AUTOTEST_KUBAN5 = "Автотест5 , Сотрудник, Тестовый отдел";

    public static void createProxy() {
        sleep(10000);
        CreateDocument.create("ДОВЕРЕННОСТЬ", "ДОВЕРЕННОСТИ");
        corentUrl = url();
        sleep(1000);
        Content.contentUpload(PROXY_DOC);
        sleep(1000);

        Buttons.requisites();

        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Доверенность авто-тест");
        sleep(1000);
        description = $(byXpath("//*[@id=\"dss_description\"]")).getValue();


        sleep(1000);
        Buttons.save();
        sleep(1000);


        // создаем кому
        if ($("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)").is(visible)) {

            $("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)").click();
        } else if ($("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
            $("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
        }


// кому
        if ($("#organizationId").is(visible)) {

            String organization = $("#organizationId").getValue();
            sleep(1000);
            if (!organization.equals("ПАО \"Кубаньэнерго\"")) {

                $("#organizationId").setValue("ПАО \"ЛЕНЭНЕРГО\"");
                $(byText("ПАО \"ЛЕНЭНЕРГО\"")).click();
                sleep(1000);

            }

            $(byXpath("//*[@id=\"branchId\"]")).setValue("Тестовый Филиал");

            if ($(byText("Тестовый Филиал")).is(visible)) {
                $(byText("Тестовый Филиал")).click();
            } else if ($(byText("Тестовый филиал")).is(visible)) {
                $(byText("Тестовый филиал")).click();

            }
            sleep(1000);


            $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME5).pressEnter();
            sleep(10000);
            if ($(byText(DEPARTMENT5)).is(visible)) {

                $(byText(DEPARTMENT5)).click();
            }if ($(byText("Тестовый Филиал")).is(visible)) {
                $(byText("Тестовый Филиал")).click();

            } else if ($(byText("Тестовый филиал")).is(visible)) {
                $(byText("Тестовый филиал")).click();

            } else {
                $(byText("Тестовый отдел")).click();
            }
            $$(PATH).findBy(text(BUTTON)).click();
            sleep(1000);
        }  else{
            $("#dsid_to_whom_issued_empl").setValue(AUTOTEST_NAME5);
            sleep(1000);
            if ($(byText(AUTOTEST5_TNT_EMPLOER)).is(visible)) {
                $(byText(AUTOTEST5_TNT_EMPLOER)).click();
            } else if ($(byText(AUTOTEST5)).is(visible)) {
                $(byText(AUTOTEST5)).click();
            }
        }


        // инициатор
        //$("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
        //
        if ($(byXpath("//input[@id='dsid_executor_empl']")).is(empty)) {

            $(byXpath("//input[@id='dsid_executor_empl']")).setValue(AUTOTEST_NAME5);
            if ($(byText("Автотест5 , Сотрудник, Департамент 5")).is(visible)) {

                $$(byText("Автотест5 , Сотрудник, Департамент 5")).first().click();
            }
        }

        // подписант
        $(byXpath("//*[@id=\"dsid_signer_empl\"]")).setValue(AUTOTEST_NAME1);
        sleep(10000);
        if (corentUrl.equals(OpenBrowser.gettNt())) {
            $(byText(AUTOTEST1_TNT_EMPLOER)).click();
        }  else if (corentUrl.equals(OpenBrowser.getKeEnerrgo())) {
            if ($("div.form-item-container:nth-child(15) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)){
                $("div.form-item-container:nth-child(15) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                $(byXpath("//input[@id='query']")).setValue(AUTOTEST_NAME2);
                sleep(10000);
                if ($(byText("ИА-КЭ")).is(visible)) {
                    $(byText("ИА-КЭ")).click();
                }
            } else {
                $(byText(AUTOTEST_NAME2)).click();
            }
            sleep(1000);

            $$(PATH).findBy(text(BUTTON)).click();
        }else {

            if ($(byText("Автотест1 , Сотрудник, Департамент 1")).is(visible)) {
                $(byText("Автотест1 , Сотрудник, Департамент 1")).click();
            } else if ($(byText(AUTOTEST_KUBAN2)).is(visible)) {
                $(byText(AUTOTEST_KUBAN2)).click();
            }else if ($("div.form-item-container:nth-child(20) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(20) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                $("#query").setValue(AUTOTEST_NAME1);
                $(byText(AUTOTEST_NAME1)).click();
                $$(PATH).findBy(text(BUTTON)).click();

            } else if ($("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                sleep(10000);
                if ($(byXpath("//input[@id='query']")).is(visible)) {

                    $(byXpath("//input[@id='query']")).setValue(AUTOTEST_NAME1);

                    $(byText("Тестовый отдел")).click();
                } else {
                    $(byText(AUTOTEST_NAME1)).click();
                }

                $$(PATH).findBy(text(BUTTON)).click();
            }
        }

        sleep(1000);
        Buttons.save();
        sleep(10000);
        Buttons.requisites();
        registrationNumber = $("#dss_reg_number").getValue();
        System.out.println(registrationNumber);




    }


    public static String getRegistrationNumber() {
        return registrationNumber;
    }

    public static String getIdentifier() {
        return identifier;
    }

    public static String getTemporaryNumber() {
        return temporaryNumber;
    }
}
