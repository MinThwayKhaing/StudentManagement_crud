package Controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StuTime {

public static String showLocalTime() {
return new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
}
}
