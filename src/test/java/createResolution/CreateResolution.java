package createResolution;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.idtm.documino.Buttons;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class CreateResolution {
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
    public static String filial = "Тестовый Филиал";
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



    public static void createRes() {
        sleep(10000);
        Buttons.createResolution();
        // инициатор
//        $("#dsidInitiatorEmpl").setValue("Босс12");
//        $(byText(boss12)).click();
//                исполнитель
        $("#performers").setValue(AUTOTEST_NAME2);
        sleep(1000);
        $(byText(AUTOTEST2)).click();
        // контрольный срок
        $("#period").click();
        sleep(1000);
        $(byText(fastOneDay)).click();
        // описание
        $(byText(inWork)).click();
        // контролер
//        $("div.input-field-container:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > small:nth-child(1)").click();
//        sleep(1000);
//        $("#dsidControllerEmpl").setValue("Директор3");
//        sleep(1000);
//
        if ($("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").is(Condition.visible)) {
            $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").scrollIntoView(true);
        }

        $("div.el-dialog__footer:nth-child(3) > span:nth-child(1) > button:nth-child(2)").click();
    sleep(1000);
    }
   public static void createUnderResolution() {
        //sleep(10000);

        // инициатор
//        $("#dsidInitiatorEmpl").setValue("Босс12");
//        $(byText(boss12)).click();
//                исполнитель
        $("#performers").setValue(AUTOTEST_NAME2);
        sleep(1000);
       if ($(byText(AUTOTEST2)).is(Condition.visible)) {
           $(byText(AUTOTEST2)).click();
       } else if ($(byText("Автотест2 , Сотрудник, Тестовый отдел")).is(Condition.visible)) {
           $(byText("Автотест2 , Сотрудник, Тестовый отдел")).click();
       } else if ($("div.input-field-container:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").is(Condition.visible)) {
           $("div.input-field-container:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)").click();
           $("#query").setValue(AUTOTEST_NAME2);
           sleep(10000);
           if ($(byText(AUTOTEST_NAME2)).is(Condition.visible)) {
               $(byText(AUTOTEST_NAME2)).click();
           } else if ($(byText("ИА-КЭ")).is(Condition.visible)) {
               $(byText("ИА-КЭ")).click();
           } else if ($(byText("Тестовый Филиал")).is(Condition.visible)) {
               $(byText("Тестовый Филиал")).click();
           } else if ($(byText("Тестовый филиал")).is(Condition.visible)) {
               $(byText("Тестовый филиал")).click();
           } else if (($(byText("Сотрудник"))).is(Condition.visible)) {
               ($(byText("Сотрудник"))).click();
           }

           $$(byText("Выбрать")).last().click();
       }

        // контрольный срок
        $("#period").click();
        sleep(1000);
        $(byText(fastOneDay)).click();
        // описание
       if ($(byText(inWork)).is(Condition.visible)) {

           $$(byText(inWork)).last().click();
       } else $("#dssDescription").setValue(inWork);

        sleep(1000);
        // контролер
//        $("div.input-field-container:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > small:nth-child(1)").click();
//        sleep(1000);
//        $("#dsidControllerEmpl").setValue("Директор3");
//        sleep(1000);
//        $(byText(director3)).click();

       $$(byXpath("//*[text()='Сохранить и разослать']/..")).last().click();




    }




}
