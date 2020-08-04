package chek;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Cheking {


    public static String chek(String number, String word) {

        String s[] = $("#dss_reg_number").getValue().split("-");
        String element;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(word)) {
                return element =word;
            }
        }
        return element = "";
    }
}
