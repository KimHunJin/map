package dxmnd.com.zigbang.java.view;

/**
 * Created by HunJin on 2017-03-09.
 */

public interface Contract {
    interface View {

    }

    interface Presenter {
        void setView(View view);
    }
}
