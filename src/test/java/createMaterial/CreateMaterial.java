package createMaterial;

import ru.idtm.documino.Buttons;
import ru.idtm.documino.Content;
import ru.idtm.documino.CreateDocument;
import ru.idtm.documino.RequiredFields;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static priority.PriorityTest.GOVERNANCE_DOCUMENTS;

public class CreateMaterial {

    private static final String AUTOTEST2 = "Автотест2 , Сотрудник, Департамент 2";
    private static final String AUTOTEST_NAME2 = "Автотест2";
    private static  final String ORDER_DOC = "Приказ об изменении орг-штатной структуры.docx";

    public static void create(String name) {

        CreateDocument.createGovernanceDocuments(GOVERNANCE_DOCUMENTS, "Материалы", "Материалы заседаний Комитетов");
        Buttons.content();
        sleep(1000);
        Content.contentUpload(ORDER_DOC);
        sleep(1000);
        Buttons.requisites();


        //обязательные поля
        $("#dsid_commitees").click();
        sleep(1000);
        $(byText(name)).click();

        // description

        $("#dss_description").setValue("Материалы заседаний Комитетов");


        // singer

        RequiredFields.singer(AUTOTEST_NAME2, AUTOTEST2, "div.form-item-container:nth-child(15) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)");

        Buttons.save();
        sleep(10000);


        Buttons.registerApproved();
        sleep(10000);

    }
}
