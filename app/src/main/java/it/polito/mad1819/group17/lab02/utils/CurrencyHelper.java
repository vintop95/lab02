package it.polito.mad1819.group17.lab02.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyHelper {
    private static PrefHelper prefHelper = PrefHelper.getInstance();
    /////////////////// CURRENCY MGMT ////////////////////////////////
    private static final String PREF_CURRENCY_LANGUAGE = "PREF_CURRENCY_LANGUAGE";
    private static final String PREF_CURRENCY_COUNTRY = "PREF_CURRENCY_COUNTRY";

    private static Locale currentLocale = null;

    public static void setLocaleCurrency(Locale locale) {
        prefHelper.putString(PREF_CURRENCY_LANGUAGE, locale.getLanguage());
        prefHelper.putString(PREF_CURRENCY_COUNTRY, locale.getCountry());
        currentLocale = locale;
    }

    public static Locale getLocaleCurrency() {
        if(currentLocale != null){
            return currentLocale;
        }else{
            String language = prefHelper.getString(
                    PREF_CURRENCY_LANGUAGE, Locale.ITALY.getLanguage());
            String country = prefHelper.getString(
                    PREF_CURRENCY_COUNTRY, Locale.ITALY.getCountry());
            return new Locale(language, country);
        }
    }

    public static String getCurrency(double val){
        NumberFormat currencyFormat =
                NumberFormat.getCurrencyInstance(getLocaleCurrency());
        return currencyFormat.format(val);
    }
    /////////////////////////////////////////////////////////////////
}
