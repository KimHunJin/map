package dxmnd.com.zigbang.java.utils;

/**
 * Created by HunJin on 2017-03-19.
 * 금액을 입력 받으면 단위를 변환하여 문자열로 변환시키는 클래스
 */

public class ChangeMoney {
    public static String changeMoney(int money) {
        if(money >= 10000) {
            return money / 10000 + "억 " + money % 10000 + "만원";
        } else {
            return money + "만원";
        }
    }
}
