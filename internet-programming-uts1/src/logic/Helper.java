package logic;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Helper 
{
    public static String formatPrice(Double price)
    {
        DecimalFormat kursIndonesia = (DecimalFormat)DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(price);
    }
}
