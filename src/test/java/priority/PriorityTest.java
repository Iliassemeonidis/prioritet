package priority;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.junit.ScreenShooter;
import createResolution.CreateResolution;
import fields.Fields;
import org.junit.Rule;
import org.junit.Test;
import proxy.Proxy;
import ru.idtm.documino.*;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PriorityTest {

    private final String BUTTON = "Выбрать";
    private final String PATH = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
    private final String CONTENT = "Контент";
    private final String INPUTDOCUMENT = "ВХОДЯЩИЕ ДОКУМЕНТЫ";
    private final String OUTPUTDOCUMENT = "ИСХОДЯЩИЕ ДОКУМЕНТЫ";
    private final String OUTPUTDOCUMENT1 = "Исходящие документы";
    private final String OUTPUTDOCUMENT_MESSAGE = "Исходящий документ (письмо)";
    private final String INTERNAL_DOCUMENTS = "ВНУТРЕННИЕ ДОКУМЕНТЫ";
    private final String ERRAND = "ИНИЦИАТИВНОЕ ПОРУЧЕНИЕ";
    private final String ERRAND1 = "ИНИЦИАТИВНЫЕ ПОРУЧЕНИЯ";
    private final String MEMORANDUM_TEST = "C3(тест)";
    private final String MEMORANDUM_TEXT1 = "Служебная записка";
    private final String BOSS = "Босс11";
    private final String INPUT_DOC = "Входящий документ.docx";
    private final String OUTPUT_DOC = "Договор поставки.doc";
    private final String ORDER_DOC = "Приказ об изменении орг-штатной структуры.docx";
    private final String MEMORANDUM_DOC = "СЗ.txt";
    private final String ERRAND_DOC = "Распоряжение_.gif";
    private final String PROXY_DOC = "Доверенность на курьера.png";
    private final String ANSWER = "ответ.txt";
    private final String REGULATORY_DOCUMENTS = "РАСПОРЯДИТЕЛЬНЫЕ ДОКУМЕНТЫ";
    private final String ORDER_DOCUMENTS = "Приказ (пустая форма)";
    private final String ORDER_DOCUMENTS1 = "Приказ (общий)";
    private final String ORDER = "Приказ";
    private static String registrationNumber;
    private static String identifier;
    private static String temporaryNumber;
    private static String description;
    private static String singer;
    private static String organization;
    private static String department;
    private static final String AUTOTEST1 = "Автотест1 , Сотрудник, Департамент 1";
    private static final String DEPARTMENT1 = "Департамент 1";
    private static final String DEPARTMENT2 = "Департамент 2";
    private static final String DEPARTMENT3 = "Департамент 3";
    private static final String DEPARTMENT4 = "Департамент 4";
    private static final String DEPARTMENT5 = "Департамент 5";
    private static final String AUTOTEST_NAME1 = "Автотест1";
    private static final String AUTOTEST2 = "Автотест2 , Сотрудник, Департамент 2";
    private static final String AUTOTEST_NAME2 = "Автотест2";
    private static final String AUTOTEST3 = "Автотест3 , Сотрудник, Департамент 3";
    private static final String AUTOTEST_NAME3 = "Автотест3";
    private static final String AUTOTEST4 = "Автотест4 , Сотрудник, Департамент 4";
    private static final String AUTOTEST_NAME4 = "Автотест4";
    private static final String AUTOTEST5 = "Автотест5 , Сотрудник, Департамент 5";
    private static final String AUTOTEST_NAME5 = "Автотест5";
    private static final String AUTOTEST_ROSSET_NAME1 = "Автотест1, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_NAME2 = "Автотест2, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_NAME3 = "Автотест3, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_NAME4 = "Автотест4, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_NAME5 = "Автотест5, зам. начальника отдела, Тестовый отдел";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME1 = "Автотест1 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник1";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME2 = "Автотест2 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник2";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME3 = "Автотест3 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник3";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME4 = "Автотест4 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник4";
    private static final String AUTOTEST_ROSSET_ORGAN_NAME5 = "Автотест5 А. Т.,ПАО \"Кубаньэнерго\",Сотрудник5";
    private static final String AUTOTEST1_TNT = "Автотест1 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник1";
    private static final String AUTOTEST2_TNT = "Автотест2 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник2";
    private static final String AUTOTEST3_TNT = "Автотест3 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник3";
    private static final String AUTOTEST4_TNT = "Автотест4 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник4";
    private static final String AUTOTEST5_TNT = "Автотест5 А. Т.,ООО \"Айди-Технологии управления\",Сотрудник5";
    private static final String AUTOTEST1_TNT_EMPLOER = "Автотест1 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST2_TNT_EMPLOER = "Автотест2 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST3_TNT_EMPLOER = "Автотест3 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST4_TNT_EMPLOER = "Автотест4 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static final String AUTOTEST5_TNT_EMPLOER = "Автотест5 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"";
    private static String corentUrl;
    public static String inWork = "В работу";
    public static String forWork = "Для учета в работе";
    public static String forInformation = "Для информации";
    public static String execute = "К исполнению";
    public static String six = "зн_6";
    public static String seven = "зн_7";
    public static String ate = "зн_8";
    public static String nain = "зн_9";
    public static String ten = "зн_10";
    public static String naw = "К исполнению срочно";
    public static String fastOneDay = "Незамедлительно: (+ 1 день)";
    public static String fastThreeDays = "Срочно: (+3 дня)";
    public static String fastTenDays = "Оперативно: (+10 дней)";
    public static String data = "Указать дату исполнения";
    public static String control = "Периодический контроль";
    public static String noSrok = "Без срока";
    public static String director1 = "Директор1 . ., Директор, Департамент 1";
    public static String director2 = "Директор2 , Директор, Департамент 2";
    public static String director3 = "Директор3 , Директор, Департамент 3";
    public static String director4 = "Директор4 , Директор4, Департамент 4";
    public static String boss11 = "Босс11 , Начальник 1, Департамент 2";
    public static String boss12 = "Босс12 , Начальник 2, Департамент 1";
    public static String boss21 = "Босс21 , Начальник 1, Департамент 2";
    public static String boss22 = "Босс22 , Начальник 2, Департамент 2";
    public static String chief1 = "Начальник 1";
    public static String chief2 = "Начальник 2";
    public static String delDep = "Del Dep 22222222, del dep 2 dephead, Тест2";
    public static String filial = "Тестовый Филиал";
    public static String GOVERNANCE_DOCUMENTS = "ДОКУМЕНТЫ ОРГАНОВ УПРАВЛЕНИЯ";

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests().succeededTests();

    @Test
    public void tess_90() {
        //Configuration.headless = true;
        //Configuration.startMaximized = true;
        OpenBrowser.openLeTest();
        corentUrl = url();
        /// sleep(10000);
        UserChange.comInAutotest1();
    }

    @Test
    public void tess_91() {
        $(byText("Мои задания")).shouldBe(visible);

        if (!$(byText("Все задания")).is(visible)) {
            $(byText("Мои задания")).click();
        }
        $(byText("Все задания")).shouldBe(visible);
        $(byText("Срок прошел")).shouldBe(visible);
        $(byText("Срок сегодня")).shouldBe(visible);
        $(byText("Срок через 1-3 дня")).shouldBe(visible);
        $(byText("Срок через 4-7 дней")).shouldBe(visible);
        $(byText("Срок больше недели")).shouldBe(visible);


        if (!$("li.sublist-item:nth-child(1) > button:nth-child(1) > div:nth-child(2)").getText().equals("0")) {
            $(".table-scroll-bar").shouldNotHave(text("Нет данных для отображения"));
        }

    }

    @Test
    public void tess_92() {
        if (!$(byText("Все документы")).is(visible)) {
            $(byText("Все документы")).scrollIntoView(true);
        }
        $(byText("Все документы")).shouldBe(visible);
    }

    @Test
    public void tess_93() {
        if (!$(byText("Недавние документы")).is(visible)) {
            $(byText("Недавние документы")).scrollIntoView(true);
        }
        $(byText("Недавние документы")).shouldBe(visible);
    }

    @Test
    public void tess_94() {
        $(byText("Резолюции")).shouldBe(visible);
        $(byText("Резолюции мне")).shouldBe(visible);
        $(byText("Резолюции от меня")).shouldBe(visible);
        $(byText("Я контролер")).shouldBe(visible);
    }

    @Test
    public void tess_95() {
        if (!$(byText("Созданные мной")).is(visible)) {
            $(byText("Созданные мной")).scrollIntoView(true);
        }
        $(byText("Созданные мной")).shouldBe(visible);
        $(byText("Созданные мной")).click();
        if (corentUrl.equals(OpenBrowser.getLeTest())) {
            $("li.list-item-container:nth-child(9) > ul:nth-child(2)").shouldNotBe(empty);
        } else if (corentUrl.equals(OpenBrowser.getLeProd())) {
            $("li.list-item-container:nth-child(8) > ul:nth-child(2)").shouldNotBe(empty);
        }


    }

    @Test
    public void tess_96() {
        // проверка поиска по рег номеру
        $(byText("Мои задания")).scrollIntoView(true);
        if (!$(byText("Все задания")).is(visible)) {
            $(byText("Мои задания")).click();
        }

        $(byText("Все задания")).click();
        sleep(1000);
        if ($(byText("Система")).is(visible)) {
            $$(byText("Система")).first().click();
        } else if ($(byText("СЭДО")).is(visible)) {
            $$(byText("СЭДО")).first().click();
        } else if ($(byText("Автотест1")).is(visible)) {
            $$(byText("Автотест1")).first().click();
        }
        sleep(10000);

        Buttons.requisites();
        registrationNumber = $(byXpath("//*[@id=\"dss_reg_number\"]")).getValue();
        sleep(1000);
        System.out.println(registrationNumber);
        temporaryNumber = $(byXpath("//*[@id=\"dss_work_number\"]")).getValue();
        System.out.println(temporaryNumber);

    }

    @Test
    public void tess_97() {
        Buttons.searchIcon();
        $(byText("По документам")).click();
        sleep(1000);
        if (corentUrl.equals(OpenBrowser.getLeTest())) {
            $("div.input-field-container:nth-child(5) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue(registrationNumber);
        }
        sleep(10000);
        $(byText("Искать")).click();
        sleep(1000);
        $(".table-scroll-bar").shouldNotHave(text("Нет данных для отображения"));

    }

    @Test
    public void tess_98() {
        $(byText("По документам")).click();

        if (corentUrl.equals(OpenBrowser.getLeTest())) {
            $("div.input-field-container:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue(temporaryNumber);
        }
        $(byText("Искать")).click();
        sleep(1000);
        $(".table-scroll-bar").shouldNotHave(text("Нет данных для отображения"));

    }

    @Test
    public void tess_99() {
// поиск по датам
        //Buttons.searchIcon();
        $(byText("По документам")).click();
        if (corentUrl.equals(OpenBrowser.getLeTest())) {
            $("div.input-field-container:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)").click();
            sleep(1000);
            int val = $$(byText("1")).size();
            $$(byText("1")).get(val - 2).click();
            sleep(1000);
            $("div.input-field-container:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > input:nth-child(1)").click();
            sleep(1000);
            val = $$(byText("5")).size();

            $$(byText("5")).get(val - 2).click();
        }
        $(byText("Искать")).click();
        sleep(10000);
        $(".table-scroll-bar").shouldNotHave(text("Нет данных для отображения"));
    }


    //    ///////////////////// приказ
    @Test
    public void test_125() {
        //  CreateDocument.createInDoc(REGULATORY_DOCUMENTS, ORDER_DOCUMENTS);
        if (!$(byText("Создать документ")).is(Condition.visible)) {
            UserChange.exit();
            UserChange.comInAutotest1();
        }
        $(byText("Создать документ")).click();

        $(byText(REGULATORY_DOCUMENTS)).click();

        if (($(byText(ORDER_DOCUMENTS)).is(visible))) {
            $(byText(ORDER_DOCUMENTS)).click();
        } else if ($(byText(ORDER_DOCUMENTS1)).is(visible)) {
            $(byText(ORDER_DOCUMENTS1)).click();
        } else if ($(byText(ORDER)).is(visible)) {
            $(byText(ORDER)).click();
        }


        $(byText("Создать")).click();
    }

    @Test
    public void test_126() {
        // создаем приказ
        Buttons.requisites();
    }


    //////заполняем обязательные поле описание
    @Test
    public void test_127() {
        RequiredFields.description("Auto-test777");


    }

    //////// поле подписант
    @Test
    public void test_128() {
// заполняем поле подписант
        if (corentUrl.equals(OpenBrowser.gettNt())) {
            Fields.singer(AUTOTEST_NAME2, AUTOTEST2_TNT_EMPLOER);
        }
        Fields.singer(AUTOTEST_NAME2, DEPARTMENT2, AUTOTEST2, AUTOTEST_ROSSET_NAME2, AUTOTEST_ROSSET_ORGAN_NAME2);
    }

    // переходим в контент
    @Test
    public void test_129() {
        Buttons.content();
    }

    //
//    // загружаем док
    @Test
    public void test_130() {
        Content.contentUpload(ORDER_DOC);
        sleep(1000);
    }

    //
//    // сохранякм и ждем
    @Test
    public void test_131() {
        Buttons.save();
        sleep(10000);
        if ($("#dsid_themes").is(visible)) {

            if ($("#dsid_themes").is(empty)) {
                $("#dsid_themes").setValue("Бизнес-процесс");
                $(byText("Бизнес-процесс")).click();
            }
        }
        sleep(1000);
        Buttons.save();

    }

    @Test
    public void test_132() {
        Buttons.requisites();
        sleep(1000);
    }

    @Test
    public void test_133() {
        // получаем рег набр
        registrationNumber = $(byXpath("//*[@id=\"dss_reg_number\"]")).getValue();
        System.out.println(registrationNumber);
    }

    @Test
    public void test_134() {
        // получаем временный номер
        temporaryNumber = $(byXpath("//*[@id=\"dss_work_number\"]")).getValue();
        System.out.println(temporaryNumber);
    }

    @Test
    public void test_135() {
        // получаем краткое описание
        description = $(byXpath("//*[@id=\"dss_description\"]")).getValue();
        System.out.println(description);
    }

    @Test
    public void test_136() {
        // получаем подписанта
        singer = $(byXpath("//*[@id=\"dsid_signer_empl\"]")).getValue();
        System.out.println(singer);
    }


    @Test
    public void test_137() {
        // нажимаем на вкладку соласование и подписание
        $(byText("Согласование и подписание")).click();
        sleep(10000);
        $(byXpath("//input[@id='completeCondition']")).click();
        $(byText("Ждать визы всех")).click();
    }


    // заполняем этапы  проверка оформления
    @Test
    public void test_138() {
        // добавляем проверка оформления
        boolean visible = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/div[3]/button[1]")).isDisplayed();
        if (visible) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[5]/div[3]/div[2]/div/div[1]/div[3]/button[1]")).click();
        } else {
            ElementsCollection el = $$(byText("Добавить этап"));
            el.get(0).click();
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
        } else {
            if ($(byText("Тестовый отдел")).is(Condition.visible)) {

                $(byText("Тестовый отдел")).click();
            } else {
                $(byText(AUTOTEST_NAME3)).click();
            }
        }
        $$(PATH).findBy(text(BUTTON)).click();
        boolean b = $(byText("Добавить")).isDisplayed();
        if (!b) {
            $$(byText("Сохранить")).shouldHaveSize(7)
                    .get(6)
                    .click();
        } else $(byText("Добавить")).click();
        sleep(1000);
    }


    @Test
    public void test_139() {
        // добавдяем этап
        boolean visible = $(byText("Добавить этап")).isDisplayed();
        if (!visible) {
            ElementsCollection el = $$(byText("Добавить этап"));
            el.get(0).click();
        } else {
            $(byText("Добавить этап")).click();
        }

        if ($(byXpath("//*[@id=\"term\"]")).is(Condition.visible)) {

            $(byXpath("//*[@id=\"term\"]")).setValue("3");
        }

    }

    // заполняем согласующего
    @Test
    public void test_140() {
        // согласующий
        Fields.agreement(AUTOTEST_NAME4, DEPARTMENT4, AUTOTEST4);
    }

    @Test
    public void test_141() {
        // еще один согласуюющий
        $(byXpath("//div[@class='column-container']//div[4]//div[2]//div[1]//div[1]//div[3]//button[1]//div[1]//*[local-name()='svg']")).click();
        $(byXpath("//div[contains(@class,'input-wrapper')]//div[contains(@class,'user-list-container')]//div//div[@class='el-tooltip']//*[local-name()='svg']")).click();

        boolean dis = $(byXpath("//*[@id=\"branchId\"]")).isDisplayed();
        if (dis) {
            $(byXpath("//*[@id=\"branchId\"]")).click();
            $(byText("Тестовый Филиал")).click();
            sleep(1000);
        }
        dis = $(byXpath("//*[@id=\"query\"]")).isDisplayed();

        if (dis) {
            $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME5).pressEnter();
            sleep(1000);
            $(byText("Департамент 5")).click();
            $$(PATH).findBy(text(BUTTON)).click();
        } else {
            $$(PATH).findBy(text(BUTTON)).click();
            $("#selectedUsers").setValue(AUTOTEST_NAME5);
            if ($(byText(AUTOTEST5)).is(visible)) {

                $(byText(AUTOTEST5)).click();
            } else {
                $(".input-wrapper > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                sleep(1000);
                $("#selectedUsers").setValue(AUTOTEST_NAME5);
                $(byText(AUTOTEST_NAME5)).click();
                $$(PATH).findBy(text(BUTTON)).click();
            }
        }

        $(byText("Добавить")).click();

    }


    // нажимаем кнопку на согласование
    @Test
    public void test_142() {
        // согласовать
        sleep(10000);
        $(byXpath("//button[@class='action-button full-flex-sizes #ffd700']")).click();
        sleep(1000);
    }

    //// идем к проверяющему оформления и подтвержаем проверку оформления
    @Test
    public void test_143() {
        //выходитм из автотест1
        UserChange.exit();
    }

    @Test
    public void test_144() {
        // заходим под автотест3
        UserChange.comInAutotest3();
    }

    @Test
    public void test_145() {
        boolean b = $(byText("Все задания")).isDisplayed();

        if (!b) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();

    }

    @Test
    public void test_146() {
        // находим наш док по рег номеру
        WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
    }

    @Test
    public void test_147() {
        // подверждаем что все все ок
        Buttons.complete();
    }


    @Test
    public void test_148() {
        ////выходим из автотест3
        UserChange.exit();
    }

    @Test
    public void test_149() {
        // заходим к автотесту4 на этап согласования
        UserChange.comInAutotest4();
    }

    @Test
    public void test_150() {
        boolean b = $(byText("Все задания")).isDisplayed();
        if (!b) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();
    }

    @Test
    public void test_151() {
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    ////
////    //    //    @Test
////////    public void test_152() { // нужно его доработать
////////        // редактируем контент
////////      /*  Buttons.content();
////////        $("div.content-action-icon:nth-child(5)").click();
////////        sleep(10000);
////////        /// временный блок так как нужно понять как реально редактировать
////////        if ($(byText("Для работы функции редактирования необходимо установить dws")).is(visible)) {
////////            $(byText("Закрыть")).click();
////////        }
////////        $("div.content-action-icon:nth-child(6)").click();
////////        sleep(10000);
////////*/
////////    }
////////
    @Test
    public void test_153() {
        // отклоняем наш док
        sleep(1000);
        Buttons.reject();
    }

    @Test
    public void test_154() {
        // описание
        $(byXpath("//*[@id=\"reportText\"]")).setValue("Отклоняем для автотеста");
    }

    @Test
    public void test_155() {
        // загружаем док
        Content.contentUploadForAnswer(ANSWER);
        sleep(10000);
    }

    @Test
    public void test_156() {
        // нажимаем отклонить
        sleep(1000);
        $(byXpath("/html/body/div[2]/div/div[3]/span/button[1]")).click();
    }


    @Test
    public void test_157() {
        // выходим из согласующего
        UserChange.exit();
    }

    // идем к след согласующему
    @Test
    public void test_158() {
        // заходим к след согласующему(он исполняющий обязанности босса32)
        UserChange.comInAutotest5();
    }


    @Test
    public void test_159() {
        // все задания

        if (!$(byText("Все задания")).isDisplayed()) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();
    }

    @Test
    public void test_160() {
        // находим док по описанию
        WorkWithDocuments.tryToFindDocWithDescription(description);

    }

    @Test
    public void test_161() {
        // согласовываем
        $(".bg-color-green1").click();
    }


    @Test
    public void test_162() {
        // выходим из согласующего автотест5
        UserChange.exit();
    }

    @Test
    public void test_163() {
        // заходим под автотест1
        UserChange.comInAutotest1();
    }

    @Test
    public void test_164() {
        // все задачи
        WorkWithDocuments.visibleElementWithText("Все задания", "Мои задания");


    }

    @Test
    public void test_165() {
        // находим наш док по описанию
        sleep(1000);
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    @Test
    public void test_166() {
        // Всем, кто не согласовал на текущем этапе
        Buttons.forAllWhoAreNot();
    }

    @Test
    public void test_167() {
        //выходим из автотест1
        UserChange.exit();
    }

    @Test
    public void test_168() {
        //заходим к согласующему атотест4
        UserChange.comInAutotest4();
    }

    @Test
    public void test_169() {

        if (!$(byText("Все задания")).isDisplayed()) {
            $(byText("Мои задания")).click();

        }

        Buttons.allTasks();
    }

    @Test
    public void test_170() {
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    @Test
    public void test_171() {
        // согласовываем
        Buttons.approve();
    }

    // далее идем к подписанту
    @Test
    public void test_172() {
        //выходим из вторго согласующего
        UserChange.exit();
    }

    // идем к подписанту автотест2
    @Test
    public void test_173() {
        // подписант босс21
        UserChange.comInAutotest2();
    }

    @Test
    public void test_174() {

        if (!$(byText("Все задания")).isDisplayed()) {
            $(byText("Мои задания")).click();
        }
        Buttons.allTasks();
    }

    @Test
    public void test_175() {
        WorkWithDocuments.tryToFindDocWithSinger(description);
    }

    @Test
    public void test_176() {
        //отклоняем с подписания
        Buttons.reject();
    }

    @Test
    public void test_177() {
        $(byXpath("//*[@id=\"reportText\"]")).setValue("авто-отклонение тест");
    }

    @Test
    public void test_178() {
        Content.contentUploadForAnswer(ANSWER);
        sleep(1000);
    }

    @Test
    public void test_179() {
        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(1)").click();
        sleep(1000);
    }

    @Test
    public void test_180() {
        // выходим из подписанта автотеста2
        UserChange.exit();
    }

    @Test
    public void test_181() {
        // заходим к автотест1
        UserChange.comInAutotest1();
    }


    @Test
    public void test_182() {
        // все задачи
        WorkWithDocuments.visibleElementWithText("Все задания", "Мои задания");
        Buttons.allTasks();

    }

    @Test
    public void test_183() {
        // находим наш док
        WorkWithDocuments.tryToFindDocWithSinger(description);
    }

    @Test
    public void test_184() {
        // отправляесм еще раз на подписание
        Buttons.toSing();
    }

    @Test
    public void test_185() {
        //выходим из автора автотеста1
        UserChange.exit();
    }

    @Test
    public void test_186() {
        //заходим к подписанту автотест2
        UserChange.comInAutotest2();
    }


    @Test
    public void test_187() {
        // все задачи
        WorkWithDocuments.visibleElementWithText("Все задания", "Мои задания");
    }

    @Test
    public void test_188() {
        // находим наш док
        description = "Auto-test777";
        WorkWithDocuments.tryToFindDocWithDescription(description);
        sleep(10000);

    }

    @Test
    public void test_189() {
        // заходим в реквизиты чтоб скопировать значение рег номера
        sleep(10000);
        Buttons.requisites();
        sleep(10000);
        registrationNumber = $(byXpath("//*[@id=\"dss_reg_number\"]")).getValue();
    }

    @Test
    public void test_190() {
        // подписываем
        sleep(10000);
        Buttons.sing();
    }

    //
//    //
//////        //////// резолюция
    @Test
    public void test_191() {
////        sleep(1000);
////        $(byText("Завершенные задания")).click();
////        sleep(10000);
////        $("#taskTypes").setValue("Подписание");
////        sleep(1000);
////        $(byText("Подписание (повторно)")).click();
////        sleep(1000);
////        $$(byText("Подписание (повторно)")).first().click();
//        // создаем резолюцию
        sleep(10000);
        Buttons.createResolution();
        // инициатор
//        $("#dsidInitiatorEmpl").setValue(AUTOTEST_NAME2);
//        $(byText(AUTOTEST2)).click();
//                исполнитель
        $("#performers").setValue(AUTOTEST_NAME5);
        sleep(1000);
        $(byText(AUTOTEST5)).click();
        // контрольный срок
        $("#period").click();
        sleep(1000);
        $(byText(fastOneDay)).click();
        // описание
        $(byText(inWork)).click();
        // контролер
        $("div.input-field-container:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > small:nth-child(1)").click();
        sleep(1000);
        $("#dsidControllerEmpl").setValue(AUTOTEST_NAME4);
        sleep(1000);
        $(byText(AUTOTEST4)).click();


        if ($("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").is(Condition.visible)) {
            $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").scrollIntoView(true);
        }

        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").click();
        sleep(1000);

        $(byText("Не удалось создать резолюцию")).shouldNotBe(visible);
    }
//
    @Test
    public void test_192() {
//        // резолюция с федеративным пользаком
//
        sleep(10000);
        Buttons.createResolution();
        // инициатор
        $("#dsidInitiatorEmpl").setValue(AUTOTEST_NAME3);
        $(byText(AUTOTEST3)).click();
//                исполнитель
        $("div.input-field-container:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
        sleep(1000);
        $("div.user-select-dialogue-filter:nth-child(2) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)").click();
        sleep(1000);
        $("#query").setValue("Del Dep");
        sleep(10000);
        if ($(byText("Del Dep")).is(visible)) {
            $(byText("Del Dep")).click();
        } else if ($(byText("Тестовый филиал")).is(visible)) {
            $(byText("Тестовый филиал")).click();
        } else if ($(byText("Тест2")).is(visible)) {
            $(byText("Тест2")).click();
        }
        $$(PATH).findBy(text(BUTTON)).click();
        // контрольный срок
        $("#period").click();
        sleep(1000);
        $(byText(fastOneDay)).click();
        // описание
        $(byText(inWork)).click();
        // контролер
//        $("#dsidControllerEmpl").setValue("Директор3");
//        sleep(1000);
//        $(byText(director3)).click();


        if ($("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").is(Condition.visible)) {
            $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").scrollIntoView(true);
        }

        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").click();
        sleep(1000);

        $(byText("Не удалось создать резолюцию")).shouldNotBe(visible);

    }

    @Test
    public void test_193() {

        sleep(1000);
        $(byText("Завершенные задания")).click();
        sleep(10000);
        $("#taskTypes").setValue("Подписание");
        sleep(1000);
        if ($(byText("Подписание (повторно)")).is(visible)) {

            $(byText("Подписание (повторно)")).click();
            sleep(1000);
            $$(byText("Подписание (повторно)")).first().click();
        } else {
            $(byText("Подписание")).click();
            sleep(1000);
            $$(byText("Подписание")).first().click();
        }

        //  проверка фильров на вкладкк резолюция по организации
        sleep(10000);
        System.out.println($$(byText("Резолюции")).size());
        $$(byText("Резолюции")).last().click();

        sleep(10000);
        $(".delete").click();
        sleep(10000);

        $("div.filter-item:nth-child(1) > div:nth-child(1)").click();
        sleep(1000);
        $(byText("ПАО \"Россети\"")).click();
        $(byText("ПАО \"Россети\"")).click();
        sleep(10000);
        $$(".resolutions-node-container").shouldHaveSize(1);
        sleep(1000);
    }


    @Test
    public void test_194() {
        $(".delete").click();
        sleep(10000);
        $("div.filter-item:nth-child(1) > div:nth-child(1)").click();
        sleep(1000);
        $(byText("ПАО \"ЛЕНЭНЕРГО\"")).click();
        $(byText("ПАО \"ЛЕНЭНЕРГО\"")).click();
        sleep(10000);
        $$(".resolutions-node-container").shouldHaveSize(1);
        sleep(1000);
        $(".delete").click();
    }


    @Test
    public void test_195() {
        // по инициатору
        $("#initiatorId").setValue(AUTOTEST_NAME2);
        sleep(10000);
        if (!$(byText("Автотест2 , Сотрудник")).is(visible)) {

            $("div.filter-item:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
            sleep(1000);
            $("#query").setValue(AUTOTEST_NAME2);
            sleep(10000);
            if ($(byText(AUTOTEST_NAME2)).is(visible)) {
                $(byText(AUTOTEST_NAME2)).click();
            } else if ($(byText(DEPARTMENT2)).is(visible)) {
                $(byText(DEPARTMENT2)).click();
            } else if ($(byText("Тестовый Филиал")).is(visible)) {
                $(byText("Тестовый Филиал")).click();
            }
            $$(byText("Выбрать")).last().click();
        } else {

            $(byText("Автотест2 , Сотрудник")).click();
        }
        $$(".resolutions-node-container").shouldHaveSize(1);
    }


    @Test
    public void test_196() {
        // по инициатору
        $(".delete").click();
        $("#initiatorId").setValue(AUTOTEST_NAME3);
        sleep(10000);
        $(byText("Автотест3 , Сотрудник")).click();
        sleep(1000);
        $$(".resolutions-node-container").shouldHaveSize(1);

    }


    @Test
    public void test_197() {
        //  по исполнителю федеративному
        $(".delete").click();
        $("#performerId").click();
        sleep(10000);
        $(byText("Del Dep 22222222, Del dep 2222222")).click();
        sleep(1000);
        $$(".resolutions-node-container").shouldHaveSize(1);
        sleep(10000);
    }

    @Test
    public void test_198() {
        //  по исполнителю обычному
        $(".delete").click();
        sleep(1000);
        $("#performerId").click();
        sleep(1000);
        $(byText("Автотест5 , Сотрудник")).click();
        $$(".resolutions-node-container").shouldHaveSize(1);
    }

    @Test
    public void test_199() {
        // идем к исполнителю и ищем у него нашу резолюцию и создаем под резолюцию
        UserChange.exit();
        UserChange.comInAutotest5();
        WorkWithDocuments.visibleElementWithText("Все задания", "Мои задания");
        WorkWithDocuments.tryToFindDocWithDescription(description);
    }

    @Test
    public void test_200() {

        //// идем к исполнителю и ищем у него нашу резолюцию и создаем под резолюцию
        sleep(1000);
        Buttons.requisites();
        $("#id").scrollIntoView(true);
        identifier = $("#id").getValue();
        sleep(10000);
        Buttons.createOnResolution();
        sleep(1000);
        CreateResolution.createUnderResolution();
        $(byText("Резолюция создана")).shouldBe(visible);
        sleep(10000);

    }


    @Test
    public void test_201() {

        Buttons.execute();
        sleep(1000);
        $("#reportText").setValue("Test");
        if ($(byText("Отправить")).is(visible)) {
            $(byText("Отправить")).click();
        } else {
            $("button.empty-purple:nth-child(4)").click();
        }

        $(byText("Исполнение резолюции")).shouldBe(visible);
        sleep(1000);
        $(byText("Продолжить с отзывом")).click();

    }


    @Test
    public void test_202() {
        sleep(1000);
        $(byText("Задание завершено")).shouldBe(visible);
    }

    @Test
    public void test_203() {
        // находим наш документ и проверяем что пдрезолюция в статусе Отозвана
        sleep(10000);
        Buttons.searchIcon();
        sleep(1000);
        $(byText("По документам")).click();
        $("div.input-field-container:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").scrollIntoView(true);
        $("div.input-field-container:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue(identifier);
        sleep(1000);
        Buttons.search();
        sleep(10000);
        if ($(byText("Auto-test777")).is(visible)) {
            $$(byText("Auto-test777")).first().click();
        } else if ($(byText(AUTOTEST_NAME2)).is(visible)) {
            $$(byText(AUTOTEST_NAME2)).first().click();
        }

        sleep(10000);

        $$(byText("Резолюции")).last().click();
        sleep(10000);
        $(".m-r-4").click();
        sleep(100);
        $(byText("Отозвана")).shouldBe(visible);
    }


//    ///////////// чать 2 Исх, Вх, Внутр, ИП////////////////////////


    @Test
    public void test_229() {
        UserChange.exit();
    }

    @Test
    public void test_230() {
        // автотест1
        UserChange.comInAutotest1();
    }

    @Test
    public void test_231() {
        // исходящий документ
        System.out.println(corentUrl);
        if (corentUrl.equals(OpenBrowser.getLeProd())) {
            CreateDocument.create(OUTPUTDOCUMENT, OUTPUTDOCUMENT_MESSAGE);
        } else {
            CreateDocument.createDoc(OUTPUTDOCUMENT, OUTPUTDOCUMENT1);

        }
    }

    @Test
    public void test_232() {
        // добавляем контент
        sleep(1000);
        Content.contentUpload(OUTPUT_DOC);
        sleep(1000);
    }

    @Test
    public void test_233() {
        // переходим в реквизиты
        Buttons.requisites();
    }


    @Test
    public void test_234() {
        // Краткое содержание
        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Auto-test777");

        String str = $("#dsid_document_kind").getValue();
        if (str.isEmpty()) {
            $("#dsid_document_kind").setValue("Письмо");
            sleep(1000);
            $(byText("Письмо")).click();
        }

    }

    //заполняем обязательные поля
    @Test
    public void test_235() {
        //Подписант
//       Fields.singer();
        boolean visble = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div[1]/div/div/div/div/div/div[1]/button")).isDisplayed();
        if (visble) {

            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div[1]/div/div/div/div/div/div[1]/button")).click();
            $(byXpath("//*[@id=\"query\"]")).setValue(AUTOTEST_NAME1);
            $(byText("Департамент 1")).click();
            //путь к кнопке выбрать подписанта
            $$(PATH).findBy(text(BUTTON)).click();
        } else {
            $("#dsid_signer_empl").setValue(AUTOTEST_NAME1);
            sleep(10000);
            if ($(byText(AUTOTEST1)).is(visible)) {
                $(byText(AUTOTEST1)).click();
            } else {
                if ($(byText("Автотест1 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"")).is(visible)) {
                    $(byText("Автотест1 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"")).click();
                } else {

                    $("div.form-item-container:nth-child(10) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                    $("#query").setValue(AUTOTEST_NAME1);
                    sleep(1000);
                    if ($(byText("Тестовый отдел")).is(visible)) {
                        $(byText("Тестовый отдел")).click();
                    } else if ($(byText("ООО \"Айди-Технологии управления\"")).is(visible)) {
                        $(byText("ООО \"Айди-Технологии управления\"")).click();
                    } else if ($(byText(AUTOTEST_NAME1)).is(visible)) {
                        $(byText(AUTOTEST_NAME1)).click();
                    } else if ($(byText("Тестовый Филиал")).is(visible)) {
                        $(byText("Тестовый Филиал")).click();
                    }
                    sleep(1000);
                    $$(PATH).findBy(text("Выбрать")).click();
                }
            }
        }

        String grif = $("#dsid_stamp").getValue();

        if (grif.isEmpty()) {
            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();
        }
    }

    //    //
//////    @Test
//////    public void test_236() {
//////
//////    }
////
    @Test
    public void test_237() {
        // внутренним аресат
        // определяем что адресат будет внутренним
        if (!$("#dsid_addresse_type").is(visible)) {
            $("#dsid_addresse_type").scrollIntoView(true);
        }
        $("#dsid_addresse_type").click();
        sleep(10000);
        if ($(byText("Внутренний адресат (ГК \"Россети\")")).is(visible)) {
            $(byText("Внутренний адресат (ГК \"Россети\")")).click();
        } else if ($(byText("Внутренний адресат (Группа компаний \"Россети\")")).is(visible)) {
            $(byText("Внутренний адресат (Группа компаний \"Россети\")")).click();
        }
        sleep(10000);


// заполняем обычного адресата
        if (!($("#drid_addressee_empl").is(visible))) {
            $("#drid_addressee_empl").scrollIntoView(true);
        }

        $$(" #drid_addressee_empl").get(0).setValue(AUTOTEST_NAME3);
        sleep(10000);
        if ($(byText(AUTOTEST3)).is(visible)) {
            $(byText(AUTOTEST3)).click();
        } else if ($(byText("Автотест3 А. Т.,ПАО \"ЛЕНЭНЕРГО\",Сотрудник 3")).is(visible)) {
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
            $("#fio").setValue(AUTOTEST_NAME3);
            sleep(1000);
            $(byText("Сотрудник3")).click();
            $$(PATH).findBy(text(BUTTON)).click();
        } else if ($("div.form-item-container:nth-child(16) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
            $("div.form-item-container:nth-child(16) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
            $("#query").setValue(AUTOTEST_NAME3);
            sleep(1000);
            if ($(byText("Сотрудник3")).is(visible)) {
                $(byText("Сотрудник3")).click();
            } else if ($(byText("Сотрудник")).is(visible)) {
                $(byText("Сотрудник")).click();
            }
            $$(PATH).findBy(text(BUTTON)).click();
        }


        // добавляем поле для федеративного адресата
        $("button.m-l-10").click();
        sleep(1000);
/// заполняем федеративного
        $("div.user-compendium-select-container:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
        $("#organizationId").setValue("Россети");
        sleep(1000);
        $(byText("ПАО \"Россети\"")).click();
        $("#branchId").setValue("Тестовый Филиал");
        sleep(1000);
        if ($(byText("Тестовый Филиал")).is(visible)) {
            $(byText("Тестовый Филиал")).click();
        } else $(byText("Тестовый филиал")).click();
        sleep(10000);
        $("#query").setValue("Волков");
        sleep(10000);
        if ($(byText("Волков В")).is(visible)) {
            $(byText("Волков В")).click();
        } else if ($(byText("Первый заместитель исполнительного директора")).is(visible)) {
            $(byText("Первый заместитель исполнительного директора")).click();
        }
        sleep(10000);
        $$(PATH).findBy(text(BUTTON)).click();


    }

    //
    @Test
    public void test_238() {
        // сохраняем и регистрируем
        sleep(10000);
        Buttons.save();
        sleep(10000);
        Buttons.registerApproved();
        sleep(10000);
        $(byText("Отправить внутренним адресатам")).shouldBe(visible);
    }

    @Test
    public void test_239() {
        // проверяем что заполнились Регистрационный номер, Временный номер
        Buttons.requisites();
        sleep(1000);
        $(byXpath("//*[@id=\"dss_reg_number\"]")).shouldNotBe(empty);
    }

    @Test
    public void test_240() {
        // добавляем доп контент
        Buttons.content();
        $("button.rounded-button:nth-child(4)").click();
        Content.contentUploadLast("test.txt");
        $("#dsid_content_type").click();
        sleep(1000);
        $(byText("Сканированный образ")).click();
        $$(byText("Сохранить")).last().click();

    }


    //    /// переходим к проверке оформления
////    @Test
////    public void test_241() {}
////    @Test
////    public void test_242() {}
////    @Test
////    public void test_243() {}
////    @Test
////    public void test_244() {}
////    @Test
////    public void test_245() {}
////    @Test
////    public void test_246() {}
////    @Test
////    public void test_249() {}
////    @Test
////    public void test_250() {}
////    @Test
////    public void test_251() {}
////    @Test
////    public void test_252() {}
//
//    //
//////    ///// //////// Входящий документ
    @Test
    public void test_254() {
        CreateDocument.create(INPUTDOCUMENT);
    }

    @Test
    public void test_255() {
        //Проверка на дубли
        Random rd = new Random();

        System.out.println(corentUrl);
        if (OpenBrowser.gettNt().equals(corentUrl)) {
            $("#dsid_agent_person").setValue(AUTOTEST_NAME3);
            sleep(1000);
            $(byText(AUTOTEST3_TNT)).click();
        }/// сделать тоже самое для всех площадок такой же ифчик
        else {
            $(".layout-icon").click();
            $("html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__body div.user-select-dialogue-container div.user-selected-user-list-container div.tabs-wrapper div.column-container.tab-content-wrapper div.user-select-dialogue-wrapper div.table-container div.list-table.bg-color-white div.flex.flex-column.full-flex-sizes.p-r-16.table-header-container div.flex.ai-center.m-b-8 div.m-r-8.w-100.flex div.filter-container div.flex.full-with.filter-field.p-b-0 input#fio.base-input.full-with.fs-12").setValue(AUTOTEST_NAME3);
            sleep(1000);
            if ($(byText("Сотрудник 3")).is(visible)) {

                $$(byText("Сотрудник 3")).first().click();
            } else {
                $(byText("Сотрудник3")).click();
            }
            $$(PATH).findBy(text(BUTTON)).click();
        }
        $(byXpath("//*[@id=\"dss_crsp_reg_number\"]")).setValue(String.valueOf(rd.nextInt(201) + 10));
        $(byXpath("//*[@id=\"dsdt_crsp_reg_date\"]")).click();
        boolean visible = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div[12]")).isDisplayed();
        if (visible) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div[12]")).click();
        } else {
            $(byText("15")).click();
        }


    }

    @Test
    public void test_256() {
        //Жмем кнопку далее
        $(byText("Далее")).click();
        sleep(10000);
        if ($(byText("Проверка на дубли")).is(Condition.visible)) {
            Buttons.clickContinue();
        }
    }


    @Test
    public void test_257() {
        // заполняем обязательные поля
        Buttons.requisites();
        sleep(10000);
        RequiredFields.description("Auto-test");
        if (corentUrl.equals(OpenBrowser.gettNt())) {
            RequiredFields.addressee(AUTOTEST_NAME1, AUTOTEST1_TNT_EMPLOER);
        } else {
            RequiredFields.addressee(AUTOTEST_NAME1, DEPARTMENT1, AUTOTEST1, "Автотест1 , Зам. начальник отдела, ООО \"Айди-Технологии управления\"");
        }
        if ($("#dsid_document_kind").is(visible)) {

            $("#dsid_document_kind").setValue("Вход");
            sleep(1000);
            $(byText("Входящие документы")).click();
        }
    }

    @Test
    public void test_258() {
        // контент загружаем
        $(byText(CONTENT)).click();
        Content.contentUpload(INPUT_DOC);
        sleep(1000);

    }

    @Test
    public void test_259() {
        //Жмем кнопку зарегистрировать
        sleep(1000);
        Buttons.save();
        //$(byText("Зарегистрировать")).click();
        sleep(1000);
    }

    @Test
    public void test_260() {
        //Жмем кнопку зарегистрировать
//        Buttons.register();
        sleep(1000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        //$(byText("Зарегистрировать")).click();
        sleep(1000);
    }

    @Test
    public void test_261() {
        // На Рассмотрение
        sleep(10000);
        if ($(".\\#ffd700").isDisplayed()) {
            $(".\\#ffd700").click();
        } else if ($(byText("На Рассмотрение")).isDisplayed()) {
            Buttons.review();

        } else if ($(byXpath("//button[@class='action-button full-flex-sizes #ffd700']")).isDisplayed()) {
            $(byXpath("//button[@class='action-button full-flex-sizes #ffd700']")).click();
        }


        sleep(10000);

    }


    //////////////////////////////////////////  вх док на резолюцию
    @Test
    public void test_264() {
        CreateDocument.create(INPUTDOCUMENT);
    }

    @Test
    public void test_265() {
        Random rd = new Random();
        $(".layout-icon").click();
        $("html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__body div.user-select-dialogue-container div.user-selected-user-list-container div.tabs-wrapper div.column-container.tab-content-wrapper div.user-select-dialogue-wrapper div.table-container div.list-table.bg-color-white div.flex.flex-column.full-flex-sizes.p-r-16.table-header-container div.flex.ai-center.m-b-8 div.m-r-8.w-100.flex div.filter-container div.flex.full-with.filter-field.p-b-0 input#fio.base-input.full-with.fs-12").setValue(AUTOTEST_NAME3);
        sleep(1000);
        if (!($(byText("Сотрудник 3")).is(visible))) {

            $(byText("Сотрудник3")).click();
        } else {
            $(byText("Сотрудник 3")).click();
        }
        $$(PATH).findBy(text(BUTTON)).click();

        $(byXpath("//*[@id=\"dss_crsp_reg_number\"]")).setValue(String.valueOf(rd.nextInt(401) + 100));
        $(byXpath("//*[@id=\"dsdt_crsp_reg_date\"]")).click();
        boolean visible = $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div[12]")).isDisplayed();
        if (visible) {
            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div[12]")).click();
        } else {
            sleep(1000);
            $(byText("15")).click();
        }

    }

    @Test
    public void test_266() {
        $(byText("Далее")).click();
        sleep(10000);
        if ($(byText("Проверка на дубли")).is(Condition.visible)) {
            Buttons.clickContinue();
        }
    }

    @Test
    public void test_267() {
        Buttons.requisites();
        sleep(10000);
        RequiredFields.description("Auto-test");
        RequiredFields.addressee(AUTOTEST_NAME1, DEPARTMENT1, AUTOTEST1, AUTOTEST_ROSSET_NAME1);
        if ($("#dsid_document_kind").is(visible)) {

            $("#dsid_document_kind").setValue("Вход");
            sleep(1000);
            $(byText("Входящие документы")).click();
        }
    }

    @Test
    public void test_268() {
        $(byText(CONTENT)).click();
        Content.contentUpload(INPUT_DOC);
        sleep(1000);
    }

    @Test
    public void test_269() {
        Buttons.save();
        sleep(1000);
    }

    @Test
    public void test_270() {
        sleep(1000);
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        sleep(10000);
    }


    @Test
    public void test_271() {
        // На резолюцию
        sleep(1000);
        if ($(byText("На резолюцию")).is(visible)) {
            Buttons.inResolution();
        } else {

            $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li[1]/button")).click();
        }
        sleep(1000);
        $(byText("Документ обновлен")).shouldBe(visible);
    }

    ////
////    //    @Test
//////    public void test_272() {
//////    }
//////
//////    @Test
//////    public void test_273() {
//////
//////    }
//////
//////    //////////   служебная записка///////////////
    @Test
    public void test_274() {
//        CreateDocument.createInDoc(INTERNAL_DOCUMENTS,MEMORANDUM_TEXT);
        $(byText("Создать документ")).click();
        $(byText(INTERNAL_DOCUMENTS)).click();
        sleep(1000);

        if ($(byText(MEMORANDUM_TEST)).is(visible)) {
            $(byText(MEMORANDUM_TEST)).click();
        } else {
            $(byText(MEMORANDUM_TEXT1)).click();
        }
        $(byText("Создать")).click();

    }

    @Test
    public void test_275() {
        // реквизиты
        sleep(10000);
        Buttons.requisites();


    }

    @Test
    public void test_276() {
        //
        $$(byXpath("//*[@id=\"dsid_stamp\"]"))
                .first()
                .click();
        $(byText("Общего пользования")).click();

    }

    @Test
    public void test_277() {
        // описание
        RequiredFields.description("Служебка");
        description = $(byXpath("//*[@id=\"dss_description\"]")).getValue();

        if ($("#dsid_document_kind").is(empty)) {

            $("#dsid_document_kind").setValue("Указание");
            if ($(byText("Указание")).is(visible)) {

                $(byText("Указание")).click();
            } else {

                $("#dsid_document_kind").setValue("Служебная");
                $(byText("Служебная записка")).click();

            }

        }
    }

    @Test
    public void test_278() {
        // адресат
        if (corentUrl.equals(OpenBrowser.gettNt())) {
            RequiredFields.addressee(AUTOTEST_NAME2, AUTOTEST2_TNT_EMPLOER);
        } else {

            RequiredFields.addressee(AUTOTEST_NAME2, DEPARTMENT2, AUTOTEST2, AUTOTEST_ROSSET_NAME2);
        }

        $(byText(CONTENT)).click();
        Content.contentUpload(MEMORANDUM_DOC);
        sleep(1000);
        Buttons.save();
    }


    @Test
    public void test_279() {
        // подписант
        if (corentUrl.equals(OpenBrowser.gettNt())) {
            Fields.singer(AUTOTEST_NAME1, AUTOTEST1_TNT_EMPLOER);
        } else {

            Fields.singer(AUTOTEST_NAME1, DEPARTMENT1, AUTOTEST1, AUTOTEST_ROSSET_ORGAN_NAME1, AUTOTEST_ROSSET_NAME1);
        }


    }


    @Test
    public void test_280() {
        Buttons.save();
        sleep(1000);
        Buttons.registerApproved();
        sleep(1000);

    }

    @Test
    public void test_281() {
        $(byText("Адресаты")).click();
        sleep(1000);
        $(byText("На рассмотрении")).shouldBe(visible);
    }

    ////
//////    @Test
//////    public void test_282() {
////////
//////    }
//////
////
//////    //////  Создание Инициаивное поручения
////
    @Test
    public void test_283() {
        // Configuration.headless = true;
        sleep(10000);
        CreateDocument.create(ERRAND, ERRAND1);
    }

    @Test
    public void test_284() {
        Buttons.content();
        Content.contentUpload(ERRAND_DOC);
    }

    //
    @Test
    public void test_285() {
        // заполняем поля
        Buttons.requisites();
        if (corentUrl.equals(OpenBrowser.gettNt())) {
            RequiredFields.completeFieldsForProactiveAssignments(AUTOTEST_NAME1, AUTOTEST1_TNT_EMPLOER);
        } else {

            RequiredFields.completeFieldsForProactiveAssignments(AUTOTEST_NAME1, AUTOTEST1);
        }
        RequiredFields.description("Auto-test777");


    }


    @Test
    public void test_286() {
        // Configuration.headless = true;
        sleep(1000);
        Buttons.save();
        if ($("#dsi_number_of_page").is(empty)) {
            $("#dsi_number_of_page").setValue("1");
        }
        sleep(1000);
        Buttons.save();
        sleep(10000);
        Buttons.register();
        sleep(10000);

        /* проверить после починки отображения резолюции
        выбрать созданную резолюцию и нажать отправить
         */

    }


    //        //////////// Доверенность
    @Test
    public void test_287() {
        sleep(10000);
        CreateDocument.create("ДОВЕРЕННОСТЬ", "ДОВЕРЕННОСТИ");
    }

    @Test
    public void test_288() {
        sleep(1000);
        Content.contentUpload(PROXY_DOC);
        sleep(1000);
    }

    @Test
    public void test_289() {
        Buttons.requisites();
    }

    @Test
    public void test_290() {
        // содержание
        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Доверенность авто-тест");
        sleep(1000);
        description = $(byXpath("//*[@id=\"dss_description\"]")).getValue();
    }

    @Test
    public void test_291() {
        // содержание
        sleep(1000);
        Buttons.save();
        sleep(1000);

    }


    @Test
    public void test_292() {
        // создаем кому
        if ($("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)").is(visible)) {

            $("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)").click();
        } else if ($("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
            $("div.form-item-container:nth-child(11) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
        }
    }

    @Test
    public void test_293() {
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
            sleep(1000);
            if ($(byText(DEPARTMENT5)).is(visible)) {

                $(byText(DEPARTMENT5)).click();
            } else {
                $(byText("Тестовый отдел")).click();
            }
            $$(PATH).findBy(text(BUTTON)).click();
            sleep(1000);
        } else {
            $("#dsid_to_whom_issued_empl").setValue(AUTOTEST_NAME5);
            $(byText(AUTOTEST5_TNT_EMPLOER)).click();
        }
    }

    @Test
    public void test_294() {
        // инициатор
        //$("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
        //
        if ($(byXpath("//input[@id='dsid_executor_empl']")).is(empty)) {

            $(byXpath("//input[@id='dsid_executor_empl']")).setValue(AUTOTEST_NAME5);
            if ($(byText("Автотест5 , Сотрудник, Департамент 5")).is(visible)) {

                $$(byText("Автотест5 , Сотрудник, Департамент 5")).first().click();
            }
        }

    }

    @Test
    public void test_295() {
        // подписант
        $(byXpath("//*[@id=\"dsid_signer_empl\"]")).setValue(AUTOTEST_NAME1);
        sleep(10000);
        if (corentUrl.equals(OpenBrowser.gettNt())) {
            $(byText(AUTOTEST1_TNT_EMPLOER)).click();
        } else {

            if ($(byText("Автотест1 , Сотрудник, Департамент 1")).is(visible)) {
                $(byText("Автотест1 , Сотрудник, Департамент 1")).click();
            } else if ($("div.form-item-container:nth-child(20) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(20) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
                $("#query").setValue(AUTOTEST_NAME1);
                $(byText(AUTOTEST_NAME1)).click();
                $$(PATH).findBy(text(BUTTON)).click();

            } else if ($("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(visible)) {
                $("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)")
                        .click();
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

    }

    //
    @Test
    public void test_296() {
        // содержание
        sleep(1000);
        Buttons.save();
        sleep(10000);
        Buttons.requisites();
        registrationNumber = $("#dss_reg_number").getValue();
        System.out.println(registrationNumber);


    }

    @Test
    public void test_297() {
        // отправить на рассмотерни
        sleep(1000);
        Buttons.agreement();
        sleep(10000);
    }

    @Test
    public void test_299() {
        // находим и подписываем док
        Buttons.allTasks();
        sleep(10000);
        WorkWithDocuments.tryToFindDoc(registrationNumber, "Подписание");
        sleep(1000);
        Buttons.sing();


        // не уверен, но вроде этот блок не нужен
//        sleep(1000);
//        $(byText("Удалить")).shouldBe(visible);


    }

    @Test
    public void test_300() {
//////Смена состояния доверенности с Действует на Отменена
        Buttons.requisites();
        sleep(1000);
        $("#id").scrollIntoView(true);
        temporaryNumber = $("#id").getValue();
        System.out.println(temporaryNumber);
        sleep(1000);

        $(".wrapper > button:nth-child(2)").click();
        $("#status").click();
        sleep(1000);
        if ($(byText("Отменена")).is(visible)) {
            $(byText("Отменена")).click();
        } else if ($(byText("Отменен")).is(visible)) {
            $(byText("Отменен")).click();
        }
        $(".doc-picker-input-wrapper > button:nth-child(2)").click();
        $(byText("По документам")).click();
        sleep(1000);
        $("#types").setValue("Распорядительные");
        sleep(1000);
        $(byText("Распорядительные документы")).click();
        sleep(10000);

        if (corentUrl.equals(OpenBrowser.getLeProd())) {
            if ($("#types").is(empty)) {
                $("div.input-field-container:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").scrollIntoView(true);
                sleep(1000);
                $("div.input-field-container:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue("Auto-test777");
            } else {
                $("div.input-field-container:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").scrollIntoView(true);
                sleep(1000);
                $("div.input-field-container:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue("Auto-test777");
            }
            sleep(10000);
        } else if (corentUrl.equals(OpenBrowser.getLeTest())) {
            $("div.input-field-container:nth-child(12) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").scrollIntoView(true);
            sleep(1000);
            $("div.input-field-container:nth-child(12) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue("Auto-test777");
            sleep(10000);
        }
        Buttons.search();
        sleep(28000);

        $("div.check-box-container:nth-child(2) > div:nth-child(1)").click();
        $$(byText("Выбрать")).last().click();

        $("#reason").setValue("Проверка работы изменения статуса");
        $$(byText("Сохранить")).last().click();
        sleep(1000);
        if (corentUrl.equals(OpenBrowser.getLeTest())) {

            $(byText("Состояние документа успешно обновлено")).shouldBe(visible);
        } else if (corentUrl.equals(OpenBrowser.getLeProd())) {
            $(byText("Статус ОРД успешно обновлен")).shouldBe(visible);
        }
        sleep(10000);

        ////// дописать проверку что есть значение отмена
//        $(byText("Отменена")).shouldBe(visible);
    }


    @Test
    public void test_301() {
        Buttons.printCart();
        sleep(1000);
        $(byText("Произошла ошибка при формировании документа")).shouldNotBe(visible);

    }

    @Test
    public void test_302() {
        /// скачиваем контент
        sleep(1000);
        Buttons.content();
        sleep(1000);
        $("div.content-action-icon:nth-child(2)").click();
        sleep(10000);
    }

    @Test
    public void test_303() {
        // печатем контент
        $("div.content-action-icon:nth-child(3)").click();
        sleep(10000);
    }

    @Test
    public void test_304() {
        // удаляем доверенность

        Proxy.createProxy();

        sleep(10000);
        Buttons.delete();
        $(byText("Удалить документ")).shouldBe(visible);
        $$(byText("Удалить")).last().click();

        $(byText("Документ помещен в корзину")).shouldBe(visible);
        sleep(10000);

        Buttons.history();
        sleep(100);
        $(byText("Документ помещен в корзину")).shouldBe(visible);
    }

// протокол правления

    @Test
    public void test_305() {
        // создаем протокол
        CreateDocument.createGovernanceDocuments("ДОКУМЕНТЫ ОРГАНОВ УПРАВЛЕНИЯ", "Протоколы", "Протокол Правления");
    }

    @Test
    public void test_306() {
        // загружаем док
        Buttons.content();
        Content.contentUpload(ORDER_DOC);
        sleep(10000);
    }

    @Test
    public void test_307() {
        // переходим к заполенеию реквизитов
        Buttons.requisites();

        Random rd = new Random();
        registrationNumber = String.valueOf(rd.nextInt(999) + 12);
        System.out.println(registrationNumber);
        // рег номер
        $("#dss_reg_number").setValue(registrationNumber);

        // дата регистрации
        if (corentUrl.equals(OpenBrowser.getLeProd())) {
            $("#dsdt_reg_date").click();

        } else if (corentUrl.equals(OpenBrowser.getLeTest())) {

            $("div.form-item-container:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").click();
        }
        sleep(1000);
        $(byText("7")).click();


        $("#dss_description").setValue("Протокол Правления");
        sleep(1000);
        description = $("#dss_description").getText();
        sleep(1000);
        RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


        // сохраняем док
        Buttons.save();
        sleep(100);
        $(byText("Документ создан")).shouldBe(visible);
    }


    @Test
    public void test_308() {
        // Зарегистрировать (ручная регистрация)
        Buttons.manualRegistration();
        sleep(100);
        $(byText("Документ зарегистрирован")).shouldBe(visible);
        sleep(10000);
    }

    //

    @Test
    public void test_309() {
        // рассылка на ознакомление
        // бага заведена пок что не работет это кейс
        //  на проде рк закрывается

        $(byText("Рассылка")).click();
        sleep(1000);

        $(byText("Добавить участников")).click();
        sleep(1000);
        $("#selectedUsers").setValue(AUTOTEST_NAME3);
        sleep(1000);
        $(byText(AUTOTEST3)).click();
        sleep(1000);
        $$(byText("Добавить")).last().click();
        $(".tr").shouldBe(visible);

    }

    ////    @Test
////    public void test_311() {
////        //
////
////    }@Test
////    public void test_312() {
////        //
////    }
////    @Test
////    public void test_313() {
////        //
////    }
//

    @Test
    public void test_314() {
        //Выписка из протокола правления
        CreateDocument.createGovernanceDocuments(GOVERNANCE_DOCUMENTS, "Выписки из протоколов", "Выписка из протоколов Правления");


    }

    @Test
    public void test_315() {
        //upload content
        Content.contentUpload(ORDER_DOC);
        sleep(1000);

    }

    @Test
    public void test_316() {
        //requisites
        Buttons.requisites();

        $("#dsdt_reg_date").click();
        sleep(1000);
        $(byText("15")).click();
        sleep(100);

        $("#dss_description").setValue("Выписка из протоколов Правления");


        RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(15) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


        Buttons.save();
        sleep(10000);
    }

    @Test
    public void test_317() {
        // Зарегистрировать (ручная регистрация)
        Buttons.manualRegistration();
        sleep(100);
        $(byText("Документ зарегистрирован")).shouldBe(visible);
        sleep(10000);
    }

    @Test
    public void test_318() {
        // рассылка на ознакомление
        // бага заведена пок что не работет это кейс!!!!!!!!!
        $(byText("Рассылка")).click();
        sleep(1000);

        $(byText("Добавить участников")).click();
        sleep(1000);
        $("#selectedUsers").setValue(AUTOTEST_NAME3);
        sleep(1000);
        $(byText(AUTOTEST3)).click();
        sleep(1000);
        $$(byText("Добавить")).last().click();
        $(".tr").shouldBe(visible);
    }

    @Test
    public void test_319() {
        // создание материалов правления
        CreateDocument.createGovernanceDocuments(GOVERNANCE_DOCUMENTS, "Материалы", "Материалы Правления");

    }

    @Test
    public void test_320() {
        // контент
        Content.contentUpload(ORDER_DOC);
        sleep(1000);
    }

    @Test
    public void test_321() {
        // обязательные поля
        Buttons.requisites();
        $("#dss_description").setValue("Материалы Правления");
        description = "Материалы Правления";
        sleep(1000);

        // подписант
        RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


    }


    @Test
    public void test_322() {
        // сохраняем док
        Buttons.save();
        sleep(100);
        $(byText("Документ создан")).shouldBe(visible);
        sleep(1000);
        $(byText("Согласование и подписание")).click();
        sleep(10000);


    }


    @Test
    public void test_323() {
        // провеяющий
        RequiredFields.checking();
        Buttons.agreement();
    }

    @Test
    public void test_324() {
        // идм к подписанту
        UserChange.exit();
        UserChange.comInAutotest3();
        WorkWithDocuments.visibleElementWithText("Все задания", "Мои задания");
        WorkWithDocuments.tryToFindDocWithDescription(description);
        sleep(10000);
        Buttons.complete();

    }

    @Test
    public void test_325() {
        // идм к подписанту
        UserChange.exit();
        UserChange.comInAutotest2();
        WorkWithDocuments.visibleElementWithText("Все задания", "Мои задания");
        WorkWithDocuments.tryToFindDocWithDescription(description);
        Buttons.sing();
        sleep(1000);

        Buttons.history();

        $(byText("Зарегистрировано")).shouldBe(visible);

    }


    @Test
    public void test_326() {
        // матераилы комитетов
        CreateDocument.createGovernanceDocuments(GOVERNANCE_DOCUMENTS, "Материалы", "Материалы заседаний Комитетов");
        Buttons.content();
        sleep(1000);
        Content.contentUpload(ORDER_DOC);
        sleep(1000);
        Buttons.requisites();
    }

    //
    @Test
    public void test_327() {
        //обязательные поля
        $("#dsid_commitees").click();
        sleep(1000);
        $(byText("Комитет по стратегии")).click();

        // description

        $("#dss_description").setValue("Материалы заседаний Комитетов");


        // singer

        RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(15) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


    }

    @Test
    public void test_328() {
        Buttons.save();
        sleep(10000);
    }

    @Test
    public void test_329() {
        Buttons.registerApproved();
        sleep(10000);
    }

    //
////
////    ///// подумать как проверять рег номер на наличае соответвующих букв
////    @Test
////    public void test_330() {
////        // проверка рег номера
////
////        if (!$("#dss_reg_number").is(visible)) {
////            $("#dss_reg_number").scrollIntoView(true);
////        }
////
////
////    }
//////////  сдеть проверку да лругие пять мкомиттетов
//////    @Test
//////    public void test_331() {
//////        //обязательные поля
//////
//////    }@Test
//////    public void test_332() {
//////        //обязательные поля
//////
//////    }@Test
//////    public void test_333() {
//////        //обязательные поля
//////
//////    }@Test
//////    public void test_334() {
//////        //обязательные поля
//////
//////    }       //обязательные поля
//////
//////    }@Test
//////    public void test_335() {
//////        //обязательные поля
//////
//////    }       //обязательные поля
//////
//////    }@Test
//////    public void test_336() {
//////        //обязательные поля
//////
//////    }       //обязательные поля
//////
//////    }@Test
//////    public void test_337() {
//////        //обязательные поля
//////
//////    }
////
//    /////// авансоавый отчет//////////
    @Test
    public void test_337() {
        /// харкод на время лe прода
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {

            CreateDocument.createGovernanceDocuments("ДОГОВОРНАЯ РАБОТА (ВОЛС)", "Первичная документация", "Авансовый отчет");
            sleep(1000);
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
            Buttons.requisites();
        }

    }

    @Test
    public void test_338() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            ///  гриф

            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();


            // description
            $("#dss_description").setValue("Авансовый отчет");

            /// контрагент
            $("div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").scrollIntoView(true);
            $("div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
            $("#fio").setValue(AUTOTEST_NAME3);
            sleep(10000);
            if ($(byText("Автотест3 А. Т.")).is(visible)) {
                $(byText("Автотест3 А. Т.")).click();
            } else if ($(byText(" ПАО \"ЛЕНЭНЕРГО\"")).is(visible)) {
                $(byText(" ПАО \"ЛЕНЭНЕРГО\"")).click();
            } else if ($(byText("Сотрудник 3")).is(visible)) {
                $(byText("Сотрудник 3")).click();
            }
            $$(byText("Выбрать")).last().click();


            /// ЦФО Куратора
            $("#dsid_cfo").click();
            sleep(1000);
            $(byText("АД")).click();
        }
    }

    @Test
    public void test_339() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.save();
            sleep(1000);
        }
    }

    @Test
    public void test_340() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.registerApproved();
            sleep(1000);
            $(byText("Документ обновлен")).shouldBe(visible);
        }
    }

    /////////////////// Договор (Волс)
    @Test
    public void test_341() {
        // временно
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {


            CreateDocument.createWithTowNames("ДОГОВОРНАЯ РАБОТА (ВОЛС)", "Договоры");


            Buttons.content();
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
            Buttons.requisites();
        }

    }

    @Test
    public void test_342() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  обязательные поля

            // grif
            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();


            //Предмет договора
            $("#dss_description").setValue("Догвор поставки");
            description = "Догвор поставки";

            // исполниетель

            $("#dsid_author_empl").scrollIntoView(true);
            $("div.form-item-container:nth-child(12) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)").click();
            sleep(1000);
            $("#dsid_author_empl").setValue(AUTOTEST_NAME2);
            sleep(1000);
            $(byText(AUTOTEST2)).click();
            // singer society
            RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, ".has-error > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");

            //Контрагент
            RequiredFields.counterparty(AUTOTEST_NAME3, "div.form-item-container:nth-child(21) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


            //Куратор
            RequiredFields.curator(AUTOTEST_NAME4, ".has-error > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)", "body > div:nth-child(12) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)");
        }

    }

    @Test
    public void test_343() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  сохраняем
            Buttons.save();
            sleep(1000);
            $(byText("Документ создан")).shouldBe(Condition.visible);
            sleep(1000);
            Buttons.requisites();
            $("#id").scrollIntoView(true);
            identifier = $("#id").getValue();
        }
    }

    //
    @Test
    public void test_344() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  подпись и согласование
            Buttons.approveSingin();
            sleep(100);
            RequiredFields.checking();
        }
    }

    @Test
    public void test_345() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  на согласование
            sleep(10000);
            Buttons.agreement();
        }
    }

    @Test
    public void test_346() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  идем к согласовывающему лицу
            UserChange.exit();
            UserChange.comInAutotest3();
        }
    }

    @Test
    public void test_347() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  find our document
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }
    }

    @Test
    public void test_348() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  approve
            sleep(1000);
            Buttons.approve();
        }
    }

    @Test
    public void test_349() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  go to the singer
            UserChange.exit();
            UserChange.comInAutotest2();
        }
    }

    @Test
    public void test_350() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  find our document
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }
    }

    @Test
    public void test_351() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  reject
            sleep(1000);
            Buttons.rejectContragent();

            sleep(1000);
            $(byText("Правки по тексту")).click();
            Content.contentUploadLast(OUTPUT_DOC);
            sleep(1000);
            $$(byText("Отклонён контрагентом")).last().click();

        }
    }

    @Test
    public void test_352() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  to go maker
            UserChange.exit();
            UserChange.comInAutotest1();
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }
    }

    @Test
    public void test_353() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
//        sleep(1000);
//        Buttons.complete_tasks();
//$$(byText("Доработка")).first().click();
//sleep(10000);

            // связываем док
            $(byText("Связанные документы")).click();
            $(byText("Связать")).click();
            sleep(1000);
            $("#types").setValue("Распорядительные");
            sleep(1000);
            $(byText("Распорядительные документы")).click();
            sleep(1000);
            $("div.input-container:nth-child(11) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").scrollIntoView(true);
            $("div.input-container:nth-child(11) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue("Auto-test777");
            $("#dss_status").scrollIntoView(true);
            sleep(1000);
            $("#dss_status").setValue("Зареги");
            sleep(1000);
            $(byText("Зарегистрирован")).click();
            sleep(1000);
            Buttons.search();
            sleep(20000);
            $("div.tr:nth-child(1) > div:nth-child(2) > div:nth-child(1)").click();
            sleep(10000);
            $(byText("Связать")).click();
            sleep(10000);
            if ($("div.input-select-container:nth-child(1) > div:nth-child(1) > input:nth-child(1)").is(Condition.visible)) {

                $("div.input-select-container:nth-child(1) > div:nth-child(1) > input:nth-child(1)").click();
            } else if ($("div.tr:nth-child(1) > div:nth-child(2) > div:nth-child(1)").is(Condition.visible)) {
                $("div.tr:nth-child(1) > div:nth-child(2) > div:nth-child(1)").click();
            }

            sleep(1000);
            $(byText("Для отправки")).click();
            $(".base-input").setValue("Для отправки");
            $$(byText("Связать")).last().click();
            sleep(100);
            $(byText("Документ успешно связан")).shouldBe(Condition.visible);

        }
    }

    @Test
    public void test_354() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  на подписание контрагентом
            sleep(1000);
            Buttons.toSingCoutragent();
            sleep(10000);

        }
    }

    @Test
    public void test_355() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  идем к подписанту
            UserChange.exit();
            UserChange.comInAutotest2();
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }
    }

    @Test
    public void test_356() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  идем к подписанту
            sleep(1000);
            Buttons.singedCoutragent();
            $(".base-input").click();
            $$(byText("15")).last().click();
            $$(byText("Подписать")).last().click();
            sleep(100);
            $(byText("Задание завершено")).shouldBe(Condition.visible);
            sleep(10000);

        }
    }

    @Test
    public void test_357() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  идем к подписант общесвом
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }
    }

    @Test
    public void test_358() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // принять
            sleep(1000);
            Buttons.accept();
            sleep(10000);
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }
    }

    @Test
    public void test_359() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // sing society
            sleep(1000);
            Buttons.signedBySociety();

            $$("input").get(2).uploadFile(new File(ANSWER));
            sleep(1000);
            $$(byText("Сохранить")).last().click();
            sleep(10000);
        }
    }

    @Test
    public void test_360() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // проверка что док зареган и что поменялся контент
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
            } else if ($(byText("Догвор поставки")).is(Condition.visible)) {
                $(byText("Догвор поставки")).click();
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

    //////// доп соглашение восл

    @Test
    public void test_361() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // создаем
            CreateDocument.createGovernanceDocuments("ДОГОВОРНАЯ РАБОТА (ВОЛС)", "Доп. соглашение", "Нетиповой");
            Buttons.content();
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
            Buttons.requisites();
        }
    }

    @Test
    public void test_362() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // обязательные поля

            // grif
            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();

            // предмет договор
            $("#dss_description").setValue("Доп. соглашение");
            description = "Доп. соглашение";


            // singer society
            $("#dsid_for_signature_empl").scrollIntoView(true);
            $("#dsid_for_signature_empl").setValue(AUTOTEST_NAME2);
            sleep(10000);
            if ($(byText(AUTOTEST2)).is(visible)) {
                $(byText(AUTOTEST2)).click();

            } else {
                $("div.form-item-container:nth-child(16) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
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
            //Контрагент

            $("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").scrollIntoView(true);
            $("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
            $("#fio").setValue(AUTOTEST_NAME3);
            sleep(10000);
            if ($(byText("Автотест3 А. Т.")).is(visible)) {
                $(byText("Автотест3 А. Т.")).click();
            } else if ($(byText(" ПАО \"ЛЕНЭНЕРГО\"")).is(visible)) {
                $(byText(" ПАО \"ЛЕНЭНЕРГО\"")).click();
            } else if ($(byText("Сотрудник 3")).is(visible)) {
                $(byText("Сотрудник 3")).click();
            }
            $$(byText("Выбрать")).last().click();

        }
    }

    @Test
    public void test_363() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  сохраняем
            Buttons.save();
            sleep(1000);
            $(byText("Документ создан")).shouldBe(Condition.visible);
            sleep(1000);
            Buttons.requisites();

            registrationNumber = $("#dss_reg_number").getValue();
            sleep(1000);

            $("#id").scrollIntoView(true);
            identifier = $("#id").getValue();
            System.out.println(identifier);

        }
    }

    @Test
    public void test_364() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  на рассмотерние
            sleep(1000);
            Buttons.agreement();
            sleep(10000);
        }
    }

    @Test
    public void test_365() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  подпись контрагентом
            Buttons.allTasks();
            sleep(1000);
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
            sleep(1000);
            Buttons.singedCoutragent();
            $$(byText("Подписать")).last().click();
            sleep(10000);
        }
    }

    @Test
    public void test_366() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  принимаем

            Buttons.allTasks();
            sleep(1000);
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
            sleep(1000);
            Buttons.accept();
            sleep(1000);
        }
    }

    @Test
    public void test_367() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  отклонение обществои
            Buttons.allTasks();
            sleep(10000);
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
            sleep(10000);
            Buttons.rejectSociety();
            sleep(1000);
            $(byText("Правки по тексту")).click();
            Content.contentUploadLast(ANSWER);
            sleep(1000);
            $$(byText("Отклонён обществом")).last().click();

        }
    }

    @Test
    public void test_368() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // доработка
            Buttons.allTasks();
            sleep(10000);
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
            sleep(10000);
            Buttons.toSingCoutragent();
            sleep(1000);

        }
    }

    @Test
    public void test_369() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // доработка
            Buttons.allTasks();
            sleep(10000);
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);

            Buttons.singedCoutragent();
            $$(byText("Подписать")).last().click();
            sleep(10000);
        }
    }

    @Test
    public void test_370() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // принятие обществом
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
    }

    @Test
    public void test_371() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // это для проверрки
//        Buttons.allTasks();sleep(10000);
//       if ($(byText("Дополнительное соглашение (ВОЛС)")).is(Condition.visible)) {
//            $$(byText("Дополнительное соглашение (ВОЛС)"))
//                    .first()
//                    .click();
//        }
            // принятие обществом
            sleep(1000);
            Buttons.signedBySociety();
            System.out.println($$("input").size());
            int count = 0;
            while (!$(".drop-zone-container").has(text("ответ")) && count < $$("input").size()) {
                $$("input").get(count).uploadFile(new File(ANSWER));
                count++;
            }
            sleep(1000);
            $$(byText("Сохранить")).last().click();
            sleep(10000);
        }
    }

    @Test
    public void test_372() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // проверка что док зареган и что поменялся контент
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

    @Test
    public void test_373() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // рузная регистрация
            CreateDocument.createGovernanceDocuments("ДОГОВОРНАЯ РАБОТА (ВОЛС)", "Доп. соглашение", "Нетиповой");
            Buttons.content();
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
            Buttons.requisites();

            // grif
            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();


            ///Дата регистрации
            $("#dsdt_reg_date").click();
            sleep(1000);
            $(byText("20")).click();


            // предмет договор
            $("#dss_description").setValue("Доп. соглашение");
            description = "Доп. соглашение";


            // singer society
            $("#dsid_for_signature_empl").scrollIntoView(true);
            $("#dsid_for_signature_empl").setValue(AUTOTEST_NAME2);
            sleep(10000);
            if ($(byText(AUTOTEST2)).is(visible)) {
                $(byText(AUTOTEST2)).click();

            } else {
                $("div.form-item-container:nth-child(16) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
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
            //Контрагент

            $("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").scrollIntoView(true);
            $("div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
            $("#fio").setValue(AUTOTEST_NAME3);
            sleep(10000);
            if ($(byText("Автотест3 А. Т.")).is(visible)) {
                $(byText("Автотест3 А. Т.")).click();
            } else if ($(byText(" ПАО \"ЛЕНЭНЕРГО\"")).is(visible)) {
                $(byText(" ПАО \"ЛЕНЭНЕРГО\"")).click();
            } else if ($(byText("Сотрудник 3")).is(visible)) {
                $(byText("Сотрудник 3")).click();
            }
            $$(byText("Выбрать")).last().click();

            Buttons.save();
            sleep(1000);
            $(byText("Документ создан")).shouldBe(Condition.visible);
            sleep(1000);
            Buttons.requisites();
            registrationNumber = $("#dss_reg_number").getValue();
            sleep(1000);

            Buttons.manualRegistration();
            sleep(1000);
            $(byText("Документ зарегистрирован")).shouldBe(visible);
            sleep(10000);
            // уточнить косательно изменения номера
//       Buttons.content();
//        Buttons.requisites();
//        $("#dss_reg_number").shouldNotBe(text(registrationNumber));
        }
    }

    //    ////////Первичная документация (ВОЛС)/////////
    @Test
    public void test_374() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            CreateDocument.createGovernanceDocuments("ДОГОВОРНАЯ РАБОТА (ВОЛС)", "Первичная документация", "Авансовый отчет");
            Buttons.content();

        }
    }

    @Test
    public void test_375() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // content
            sleep(1000);
            Content.contentUpload(ORDER_DOC);
            sleep(10000);
            Buttons.requisites();

        }
    }

    @Test
    public void test_376() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // заполняем поля
// grif
            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();

// предмет договор
            $("#dss_description").setValue("Авансовый отчет");
            description = "Авансовый отчет";


        }
    }

    @Test
    public void test_377() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            /// контрагент
            RequiredFields.counterparty(AUTOTEST_NAME3, "div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");

            ///ЦФО Куратора
            $("#dsid_cfo").click();
            sleep(1000);
            $(byText("АД")).click();

        }
    }

    @Test
    public void test_378() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            sleep(1000);
            Buttons.save();
            sleep(10000);

            Buttons.requisites();
            registrationNumber = $("#dss_reg_number").getValue();
            sleep(1000);
            $("#id").scrollIntoView(true);
            sleep(1000);
            temporaryNumber = $("#id").getValue();

        }
    }


    @Test
    public void test_379() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.approveSingin();
            sleep(1000);
            RequiredFields.checking();
        }
    }


    @Test
    public void test_380() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            sleep(10000);
            Buttons.agreement();
            sleep(10000);
        }
    }

    @Test
    public void test_381() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
// отзываем на доработку
            sleep(1000);
            Buttons.recallForRevision();
            sleep(10000);

        }
    }

    @Test
    public void test_382() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
        }

    }

    @Test
    public void test_383() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // на след стадию документ процесса
            sleep(1000);
            Buttons.toTheNextStageOfDocumentProcessing();
            sleep(1000);
            $(byText("Задание завершено")).shouldBe(visible);
            sleep(10000);
        }
    }


    @Test
    public void test_384() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // подписываем контрагентом
            WorkWithDocuments.contragent(registrationNumber);
        }
    }

    @Test
    public void test_385() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //  accept
            WorkWithDocuments.accept(registrationNumber);
        }
    }

    @Test
    public void test_386() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // отклоняем обществом
            WorkWithDocuments.rejectSociety(registrationNumber, ANSWER);
        }
    }

    @Test
    public void test_387() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // доработка и отправка на согласование
            Buttons.allTasks();
            sleep(10000);
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
            sleep(1000);
            Buttons.agreement();
            sleep(100);
            $(byText("Задание завершено")).shouldBe(visible);
            sleep(10000);
        }
    }

    @Test
    public void test_388() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
// меняем юзеров для согласования
            UserChange.exit();
            UserChange.comInAutotest3();
            if (!$(byText("Все задания")).isDisplayed()) {
                $(byText("Мои задания")).click();
            }
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
        }
    }

    @Test
    public void test_389() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            sleep(1000);
            Buttons.approve();
            sleep(10000);
        }
    }


    @Test
    public void test_390() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // возвращаемся обратно к обществу
            UserChange.exit();
            UserChange.comInAutotest1();
            if (!$(byText("Все задания")).isDisplayed()) {
                $(byText("Мои задания")).click();
            }

        }
    }

    @Test
    public void test_391() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            WorkWithDocuments.contragent(registrationNumber);
        }
    }

    @Test
    public void test_392() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            WorkWithDocuments.accept(registrationNumber);
        }
    }

    @Test
    public void test_393() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            WorkWithDocuments.signedBySociety(ANSWER);
        }
    }

    @Test
    public void test_394() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            WorkWithDocuments.documentCheck(temporaryNumber, description);
        }
    }

    @Test
    public void test_395() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // создаем резолюцию
            CreateResolution.createRes();
        }
    }

    @Test
    public void test_396() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // идем к исполнителю резолюции
            UserChange.exit();
            UserChange.comInAutotest2();

            if (!$(byText("Все задания")).isDisplayed()) {
                $(byText("Мои задания")).click();
            }
            Buttons.allTasks();
            sleep(1000);
            $$(byText("Первичная документация"))
                    .first()
                    .click();

        }
    }

    @Test
    public void test_397() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            sleep(10000);
            Buttons.execute();
            $("#reportText").setValue("The end").pressEnter();
            Content.contentUpload(ANSWER);
            sleep(10000);
            $("button.empty-purple:nth-child(4)").click();
        }
    }

    @Test
    public void test_398() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            sleep(10000);
            Buttons.searchIcon();
            while ($(".table-scroll-bar").has(text("Нет данных для отображения"))) {

                $(byText("По документам")).click();
                $(byText("Идентификатор")).scrollIntoView(true);
                $("div.input-field-container:nth-child(9) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue(temporaryNumber);
                sleep(1000);
                Buttons.search();
                sleep(10000);
            }
            if ($(byText("Зарегистрирован")).is(Condition.visible)) {
                $(byText("Зарегистрирован")).click();
            } else if ($(byText(description)).is(Condition.visible)) {
                $(byText(description)).click();
            } else if ($(byText(AUTOTEST_NAME1)).is(visible)) {
                $(byText(AUTOTEST_NAME1)).click();
            }

            Buttons.requisites();
            sleep(10000);
            $("#dss_status").shouldHave(value("В деле"));
        }
    }
//////////////////Проектная документация (ВОЛС, Кубаньэнерго)


    @Test
    public void test_399() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            ///Проектная документация
            CreateDocument.create("ПРОЕКТНАЯ ДОКУМЕНТАЦИЯ");
            Buttons.content();
        }
    }

    @Test
    public void test_400() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
        }
    }

    @Test
    public void test_401() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.requisites();
            ////grif
            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();

// предмет договор
            $("#dss_description").setValue("Проектная документация");
            description = "Проектная документация";


            /// singer

            RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(10) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");

        }
    }

    @Test
    public void test_402() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.save();
            sleep(10000);
        }
    }

    @Test
    public void test_403() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.registerApproved();
            sleep(10000);
        }
    }

    @Test
    public void test_404() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.content();
            $("div.content-action-icon:nth-child(2)").click();
            sleep(10000);
        }

    }

    @Test
    public void test_405() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            $("div.content-action-icon:nth-child(3)").click();
            sleep(10000);
        }
    }


    //    //// доработать почему то не нахходит кнопку для создания резолюции!!!!!!!!!!!!!!!!
//    @Test
//    public void test_406() {
//        CreateResolution.createRes();
//        sleep(1000);
//    }
//
//    //// приказы о командировании
    @Test
    public void test_407() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            CreateDocument.create("ПРИКАЗЫ О КОМАНДИРОВАНИИ");
            Buttons.content();
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
        }
    }

    @Test
    public void test_408() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.requisites();
            ////grif
            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();

// предмет договор
            $("#dss_description").setValue("Приказы о командировании");
            description = "Приказы о командировании";


            /// singer

            RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(10) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


        }
    }

    @Test
    public void test_409() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.save();
            sleep(10000);
            Buttons.content();
            Buttons.requisites();

            registrationNumber = $("#dss_reg_number").getValue();
            sleep(1000);
        }
    }

    @Test
    public void test_410() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.agreement();
            sleep(10000);
        }
    }


    @Test
    public void test_411() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            UserChange.exit();
            UserChange.comInAutotest2();
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);

        }
    }

    @Test
    public void test_412() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.sing();
            sleep(10000);
        }
    }


    @Test
    public void test_413() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // скачиваем
            Buttons.content();
            $("div.content-action-icon:nth-child(2)").click();
            sleep(10000);
        }
    }


    @Test
    public void test_414() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // печатаем
            $("div.content-action-icon:nth-child(3)").click();
            sleep(10000);

        }
    }

    @Test
    public void test_415() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.history();
            $(byText("Зарегистрировано")).shouldBe(visible);
        }
    }

    //    ////////////// ДОКУМЕНТЫ ОРГАНОВ УПРАВЛЕНИЯ(протокол)
    @Test
    public void test_416() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            CreateDocument.createGovernanceDocuments("ДОКУМЕНТЫ ОРГАНОВ УПРАВЛЕНИЯ", "Протоколы", "Протокол Правления");
            Buttons.content();
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
        }
    }

    @Test
    public void test_417() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.requisites();
            // reg number
            Random rnd = new Random();
            registrationNumber = String.valueOf(rnd.nextInt(5555) + 10);

            $("#dss_reg_number").setValue(registrationNumber);

            // Дата регистрации
            $("div.form-item-container:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").click();
            sleep(1000);
            $(byText("20")).click();

//        ////grif
            if ($("#dsid_stamp").is(empty)) {
                $("#dsid_stamp").click();
                sleep(1000);
                $(byText("Общего пользования")).click();
            }

// предмет договор
            $("#dss_description").setValue("Документы органов управления");
            description = "Документы органов управления";
// singer
            RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


            //Ответственный секретарь
            if ($("#dsid_secretary_empl").is(empty)) {
                $("#dsid_secretary_empl").setValue(AUTOTEST_NAME1);
                sleep(10000);
                $(byText(AUTOTEST1)).click();
            }

        }
    }


    @Test
    public void test_418() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.save();
            sleep(10000);
        }

    }


    @Test
    public void test_419() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.approveSingin();
        }
    }

    @Test
    public void test_420() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.agreement();
            sleep(1000);
        }
    }

//    @Test
//    public void test_421() {
//
//    }
//
//    @Test
//    public void test_422() {
//
//    }


    @Test
    public void test_423() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            UserChange.exit();
            UserChange.comInAutotest2();
            sleep(1000);
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
        }
    }

    @Test
    public void test_424() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.sing();
            sleep(10000);
            Buttons.history();
            sleep(1000);
            $(byText("Зарегистрировано")).shouldBe(visible);
        }
    }

////
//
////////////// Материалы Правления (ВОЛС, Кубаньэнерго)


    @Test
    public void test_425() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            CreateDocument.createGovernanceDocuments("ДОКУМЕНТЫ ОРГАНОВ УПРАВЛЕНИЯ", "Материалы", "Материалы Правления");
            Buttons.content();

        }
    }


    @Test
    public void test_426() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Content.contentUpload(ORDER_DOC);
            sleep(10000);
            Buttons.requisites();
        }
    }


    @Test
    public void test_427() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {

// предмет договор
            $("#dss_description").setValue("Материалы Правления");
            description = "Материалы Правления";
// singer
            RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


        }
    }

    @Test
    public void test_428() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {

            Buttons.save();
            sleep(100);
            $(byText("Документ создан")).shouldBe(visible);
        }
    }


    @Test
    public void test_429() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // добавляем проверяющего
            Buttons.approveSingin();
            RequiredFields.checking();
        }
    }

    @Test
    public void test_430() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // на согласование
            Buttons.agreement();
            sleep(1000);
            $(byText("Произошла ошибка при завершении задания")).shouldNotBe(visible);
            sleep(1000);

        }
    }

    @Test
    public void test_431() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            UserChange.exit();
            UserChange.comInAutotest3();
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }
    }

    @Test
    public void test_432() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.complete();
            sleep(1000);
            $(byText("Произошла ошибка при завершении задания")).shouldNotBe(visible);
            sleep(10000);
        }
    }

    @Test
    public void test_433() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            UserChange.exit();
            UserChange.comInAutotest2();
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }
    }

    @Test
    public void test_434() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.sing();
            sleep(100);
            $(byText("Произошла ошибка при завершении задания")).shouldNotBe(visible);
            sleep(10000);
        }
    }


    @Test
    public void test_435() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.history();
            sleep(1000);
            $(byText("Зарегистрировано")).shouldBe(visible);
        }
    }

    //    ///////////// Выписки из протоколов (ВОЛС, Кубаньэнерго) узнать что с ними
    @Test
    public void test_436() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            CreateDocument.create("ВЫПИСКИ ИЗ ПРОТОКОЛОВ");
            Buttons.content();
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
        }
    }

    @Test
    public void test_437() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.requisites();
            ////grif
            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();

// предмет договор
            $("#dss_description").setValue("Выписки из протоколов");
            description = "Выписки из протоколов";
// singer
            RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(15) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");

        }
    }

    @Test
    public void test_438() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.save();
            sleep(10000);
            Buttons.requisites();
            registrationNumber = $("#dss_reg_number").getValue();
            sleep(1000);
        }

    }

    @Test
    public void test_439() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.agreement();
            sleep(10000);

        }
    }


    @Test
    public void test_440() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            UserChange.exit();
            UserChange.comInAutotest2();
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);

        }
    }


    @Test
    public void test_441() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.sing();
            sleep(10000);
        }
    }

    @Test
    public void test_442() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {

            $(byText("Завершенные задания")).click();

            sleep(10000);

            $$(byText(description)).first().click();
        }
    }

    @Test
    public void test_443() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.history();

            sleep(1000);
            $(byText("Зарегистрировано")).shouldBe(visible);
        }
    }

//    @Test
//    public void test_444() {
//    }
//
//
//    @Test
//    public void test_445() {
//    }
//
//
//    @Test
//    public void test_446() {
//    }
//////////////////////Договоры (Кубаньэнерго)///////


    @Test
    public void test_447() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            CreateDocument.createGovernanceDocuments("ДОГОВОРНЫЕ ДОКУМЕНТЫ (КЭ)", "Договоры", "Типовой");
        }
    }

    @Test
    public void test_448() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            $("#dsid_policy").click();
            sleep(1000);
            $(byText("Договоры: договор контрагента")).click();
        }
    }

    @Test
    public void test_449() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // далее
            Buttons.further();
            sleep(10000);
            Buttons.content();
        }
    }


    @Test
    public void test_450() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
            Buttons.requisites();
        }
    }


    @Test
    public void test_451() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // обязательные поля

            //описание
            $("#dss_description").setValue("Кубаньэнерго");
            description = "Кубаньэнерго";

            //Куратор
            RequiredFields.curator(AUTOTEST_NAME4, "div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)", "#query");


            //Контакты исполнителя
            if (!$("#dss_contacts").is(visible)) {
                $("#dss_contacts").scrollIntoView(true);
            }
            $("#dss_contacts").setValue("12345");


            // singer
            RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");

            // contragent
            RequiredFields.counterparty(AUTOTEST_NAME3, "div.form-item-container:nth-child(18) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


        }
    }


    @Test
    public void test_452() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.save();
            $(byText("Документ создан")).shouldBe(visible);
            sleep(10000);
        }
    }


    @Test
    public void test_453() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.agreement();
            $(byText("Документ обновлен")).shouldBe(visible);
            sleep(10000);
            Buttons.requisites();
            registrationNumber = $("#dss_reg_number").getValue();
            sleep(100);
        }
    }

    @Test
    public void test_454() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // принимаем
            WorkWithDocuments.accept(registrationNumber);
        }
    }

    @Test
    public void test_455() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // завершаем обществоим
            Buttons.complete();
            // sleep(100);
            //$(byText("Задание завершено")).shouldBe(visible);
            sleep(10000);

        }
    }

    @Test
    public void test_456() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //
            Buttons.allTasks();
            sleep(10000);
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);
            Buttons.complete();
            sleep(1000);
        }

    }
//
    @Test
    public void test_457() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // завершаем регистрацию
            Buttons.allTasks();
            sleep(10000);
            WorkWithDocuments.tryToFindDocWithDescription(registrationNumber);

        }
    }

    @Test
    public void test_458() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            ////  доработать
            Random random = new Random();
            registrationNumber = String.valueOf(random.nextInt(550) + 10);
            Buttons.complete();
            sleep(1000);
            $("#regNumber").setValue(registrationNumber);
            sleep(1000);
            $("#regDate").click();
            sleep(1000);
            System.out.println($$(byText("5")).size());
            if ($$(byText("5")).size() > 1) {

                $$(byText("5")).get(1).click();
            } else {
                $(byText("5")).click();
            }
            sleep(1000);

            System.out.println($$("input").size());

            int size = $$("input").size();
            if (size == 5) {
                $$("input").get(2).uploadFile(new File(ANSWER));
            } else if (size==6){
                $$("input").get(3).uploadFile(new File(ANSWER));
            }


            sleep(10000);
            $$(byText("Сохранить")).last().click();
        }
    }

    @Test
    public void test_459() {

        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            sleep(20000);
            Buttons.complete_tasks();
            sleep(1000);
            $$(byText("Регистрация")).first().click();
            sleep(10000);

        }
    }

    @Test
    public void test_460() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.requisites();
            sleep(1000);
            $("#dss_reg_number").shouldHave(value(registrationNumber));

        }
    }

    @Test
    public void test_461() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.content();
            sleep(10000);
            $("div.scroll-bar:nth-child(1)").shouldHave(Condition.text("ответ"));
        }
    }

    /////////////Дополнительные соглашения (Кубаньэнерго)////////////

    @Test
    public void test_462() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            CreateDocument.createGovernanceDocuments("ДОГОВОРНЫЕ ДОКУМЕНТЫ (КЭ)", "Доп. соглашение", "Типовой");
        }
    }

    @Test
    public void test_463() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            $("#dsid_policy").click();
            sleep(1000);
            $(byText("Доп. соглашение: подписание Обществом первично")).click();
        }
    }

    @Test
    public void test_464() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.further();
            sleep(10000);
        }
    }

    @Test
    public void test_465() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.content();
            Content.contentUpload(ORDER_DOC);
            sleep(1000);
        }
    }

    @Test
    public void test_466() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            /// заполняем обязаетльные поля
            Buttons.requisites();
//Договор-основание
            $("button.user-select-form-button:nth-child(2)").click();
            sleep(100);
            Buttons.search();
            sleep(10000);

            $("div.tr:nth-child(1) > div:nth-child(2) > div:nth-child(1)").click();
            sleep(1000);
            $$(byText("Выбрать")).last().click();
            sleep(1000);

            // грифф
            $("#dsid_stamp").click();
            sleep(1000);
            $(byText("Общего пользования")).click();
            //Контакты исполнителя
            $("#dss_contacts").setValue("54321");
            //Краткое содержание
            $("#dss_description").setValue("Доп. соглашение Кубаньэнерго");
            description = "Доп. соглашение Кубаньэнерго";

            //Подписант
            RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(16) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");
            //Контрагент
            RequiredFields.counterparty(AUTOTEST_NAME3, "div.form-item-container:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


            Buttons.save();
            sleep(10000);
        }

    }

    @Test
    public void test_467() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // на согласование
            Buttons.agreement();
            sleep(10000);
        }
    }

    @Test
    public void test_468() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // находим док и согласовываем
            sleep(1000);
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }
    }

    @Test
    public void test_469() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            //// принять
            sleep(1000);
            Buttons.accept();
            sleep(10000);
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(description);
        }

    }

    @Test
    public void test_470() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            // завершаем на печати
            Buttons.complete();
            sleep(10000);
        }

    }

    @Test
    public void test_471() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            /// Завершаем обществом
            sleep(10000);
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(description);
            Buttons.complete();
            sleep(10000);

        }
    }

    @Test
    public void test_472() {
///Завершить задание, не прикрепляя документа и не указывая даты (атрибуты не обязательны для заполнения при завершении задания).
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(description);
            Buttons.complete();
            sleep(1000);
            $$(byText("Сохранить")).last().click();


        }
    }

    @Test
    public void test_473() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            /// Подписание контрагента
            sleep(10000);
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(description);
            Buttons.complete();
            sleep(100);
//        $(byText("Задание завершено")).shouldBe(visible);

        }
    }

    @Test
    public void test_474() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
// находим док завершаем регитсрацию но предварительно проверяем то поля рег номер и дата обязательык заполнению
            sleep(10000);
            Buttons.allTasks();
            WorkWithDocuments.tryToFindDocWithDescription(description);

            Buttons.complete();

            $$(byText("Сохранить")).last().click();

            sleep(1000);

            $(byText("Прикрепите скан договора/доп. соглашения")).shouldBe(visible);

        }

    }

    @Test
    public void test_475() {
        // заполняем и сораняем
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Random random = new Random();
            registrationNumber = String.valueOf(random.nextInt(550) + 10);
            sleep(1000);
            $("#regNumber").setValue(registrationNumber);
            sleep(1000);
            $("#regDate").click();
            sleep(1000);
            System.out.println($$(byText("5")).size());
            if ($$(byText("5")).size() > 1) {

                $$(byText("5")).get(1).click();
            } else {
                $(byText("5")).click();
            }
            sleep(1000);
            int size = $$("input").size();
            if (size == 5) {
                $$("input").get(2).uploadFile(new File(ANSWER));
            } else if (size==6){
                $$("input").get(3).uploadFile(new File(ANSWER));
            }
            sleep(10000);
            $$(byText("Сохранить")).last().click();

        }
    }

    @Test
    public void test_476() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            sleep(10000);
            Buttons.searchIcon();
            $(byText("По документам")).click();
            $("#types").setValue("Доп");
            sleep(1000);
            $(byText("Дополнительное соглашение (КЭ)")).click();
            $("div.input-field-container:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)").setValue(registrationNumber);

            Buttons.search();
            sleep(10000);
            if ($(".table-scroll-bar").has(text("Нет данных для отображения"))) {
                $("li.list-item-container:nth-child(3) > button:nth-child(1)").click();
            }
            $$(byText(description)).first().click();
        }

    }

    @Test
    public void test_477() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.requisites();
            $("#dss_reg_number").shouldHave(value(registrationNumber));
        }
    }

    @Test
    public void test_478() {
        if (corentUrl.equals(OpenBrowser.getLeTest()) || corentUrl.equals(OpenBrowser.getVolsSt())) {
            Buttons.content();
            sleep(10000);
            $("div.scroll-bar:nth-child(1)").shouldHave(Condition.text("ответ"));
        }
    }



//     @Test
//    public void test_400() {
//    }


}

