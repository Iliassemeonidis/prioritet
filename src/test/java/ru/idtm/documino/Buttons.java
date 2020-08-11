package ru.idtm.documino;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Buttons {
    private final static String REQUISITES = "Реквизиты";
    private final static String SAVE = "Сохранить";
    private final static String DELETE = "Удалить";
    private final static String CONTENT = "Контент";
    private final static String CONSIDERATION = "НА РАССМОТРЕНИЕ";
    private final static String REGISTER = "Зарегистрировать";
    private final static String REVIEW = "На Рассмотрение";
    private final static String IN_RESOLUTION = "На резолюцию";
    private final static String HISTORY = "История";
    private final static String AGREEMENT = "На согласование";
    private final static String REVERT = "Вернуть";
    private final static String BRING_BACK= "Отправить повторно";
    private final static String ALL_TASKS= "Все задания";
    private final static String COMPLETE = "Завершить";
    private final static String REJECT = "Отклонить";
    private final static String REJECT_CONTRAGENT = "Отклонён контрагентом";
    private final static String REJECT_SOCIETY = "Отклонён обществом";
    private final static String FOR_ALL_WHO_ARE_NOT = "Всем, кто не согласовал на текущем этапе";
    private final static String APPROVE = "Согласовать";
    private final static String TO_SING = "На подписание";
    private final static String SING = "Подписать";
    private final static String CREATE_RESOLUTION = "Создать резолюцию";
    private final static String EXECUTE = "Исполнить";
    private final static String PRINT_CART = "Печать карточки";
    private final static String CONTINUE = "Продолжить";
    private final static String SEARCH_ICON = "button.el-tooltip:nth-child(1)";
    private final static String REGISTER_APPROVED = "Зарегистрировать утвержденный";
    private final static String SEARCH = "Искать";
    private final static String MANUAL_REGISTRATION = "Зарегистрировать (ручная регистрация)";
    private final static String APPROVE_SINGIN = "Согласование и подписание";
    private final static String TO_SING_COUTRAGENT = "На подписание контрагентом";
    private final static String SINGED_COUTRAGENT = "Подписан контрагентом";
    private final static String ACCEPT = "Принять";
    private final static String SIGNED_BY_SOCIETY = "Подписан обществом";
    private final static String Recall_for_revision = "Отозвать на доработку";
    private final static String toTheNextStageOfDocumentProcessing = "На следующий этап обработки документа";
    private final static String Accept_the_report = "Принять отчет";
    private final static String  FURTHER = "Далее";
    private final static String COMPLETE_TASKS = "Завершенные задания";
    private final static String  CREATE_ON_RESOLUTION = "Создать подрезолюцию";






    public static void createOnResolution(){ $(byText(CREATE_ON_RESOLUTION)).click(); }
    public static void complete_tasks(){ $(byText(COMPLETE_TASKS)).click(); }
    public static void further(){ $(byText(FURTHER)).click(); }
    public static void accept_the_report(){ $(byText(Accept_the_report)).click(); }
    public static void toTheNextStageOfDocumentProcessing(){ $(byText(toTheNextStageOfDocumentProcessing)).click(); }
    public static void recallForRevision(){ $(byText(Recall_for_revision)).click(); }
    public static void rejectSociety(){ $(byText(REJECT_SOCIETY)).click(); }
    public static void signedBySociety(){ $(byText(SIGNED_BY_SOCIETY)).click(); }
    public static void accept(){ $(byText(ACCEPT)).click(); }
    public static void requisites(){ $(byText(REQUISITES)).click(); }
    public static void singedCoutragent(){ $(byText(SINGED_COUTRAGENT)).click(); }
    public static void toSingCoutragent(){ $(byText(TO_SING_COUTRAGENT)).click(); }
    public static void rejectContragent(){ $(byText(REJECT_CONTRAGENT)).click(); }
    public static void approveSingin(){ $(byText(APPROVE_SINGIN)).click(); }
    public static void manualRegistration(){ $(byText(MANUAL_REGISTRATION)).click(); }
    public static void search(){ $(byText(SEARCH)).click(); }
    public static void inResolution(){ $(byText(IN_RESOLUTION)).click(); }
    public static void registerApproved(){ $(byText(REGISTER_APPROVED)).click(); }
    public static void clickContinue(){ $(byText(CONTINUE)).click(); }
    public static void searchIcon(){ $(SEARCH_ICON).click(); sleep(1000);}
    public static void save(){ $(byText(SAVE)).click(); }
    public static void delete(){ $(byText(DELETE)).click(); }
    public static void content(){ $(byText(CONTENT)).click(); }
    public static void consideration(){
        $(byText(CONSIDERATION)).click();
    }
    public static void register(){ $(byText(REGISTER)).click(); }
    public static void review(){ $(byText(REVIEW)).click(); }
    public static void history(){ $(byText(HISTORY)).click(); }
    public static void agreement(){ $(byText(AGREEMENT)).click(); sleep(1000); }
    public static void revert(){ $(byText(REVERT)).click(); }
    public static void bringBack(){ $(byText(BRING_BACK)).click(); }
    public static void allTasks(){ $(byText(ALL_TASKS)).click(); sleep(1000);}
    public static void complete(){ $(byText(COMPLETE)).click(); sleep(10000);}
    public static void reject(){ $(byText(REJECT)).click(); sleep(1000);}
    public static void forAllWhoAreNot(){ $(byText(FOR_ALL_WHO_ARE_NOT)).click(); sleep(10000);}
    public static void approve(){ $(byText(APPROVE)).click(); sleep(10000);}
    public static void toSing(){ $(byText(TO_SING)).click(); sleep(1000);}
    public static void sing(){ $(byText(SING)).click(); sleep(10000);}
    public static void createResolution(){ $(byText(CREATE_RESOLUTION)).click(); sleep(1000);}
    public static void execute(){ $(byText(EXECUTE)).click(); sleep(10000);}
    public static void printCart(){
        $(byText(PRINT_CART)).click(); sleep(1000);
        $(byText("Печать")).click();
        sleep(10000);
    }


}
