package com.selenium.vlay.account;

/**
 * Created by Vlay on 01.10.2015.
 */
public class Web_Account {

    private static final String SITE_FIRST_NAME_KEY = "SITE_FIRST_NAME";
    private static final String SITE_LAST_NAME_KEY = "SITE_LAST_NAME";
    private static final String SITE_USER_EMAIL_KEY = "SITE_USER_EMAIL";
    private static final String SITE_USER_PASS_KEY = "SITE_USER_PASS";
    private static final String SITE_USER_NICK_KEY = "SITE_USER_NICK";
    private static final String SITE_URL_KEY = "SITE_URL";

    public final String first_name;
    public final String last_name;
    public final String user_email;
    public final String password;
    public final String nickname;
    public final String site_url;

    public Web_Account(){
        first_name = System.getProperty(SITE_FIRST_NAME_KEY, "testik");
        last_name = System.getProperty(SITE_LAST_NAME_KEY, "big");
        user_email = System.getProperty(SITE_USER_EMAIL_KEY, "testik@mail.ru");
        password = System.getProperty(SITE_USER_PASS_KEY, "qwerty");
        nickname = System.getProperty(SITE_USER_NICK_KEY, "testik");
        site_url = System.getProperty(SITE_URL_KEY, "https://vlay.pythonanywhere.com/ajax_release/");

    }

}
