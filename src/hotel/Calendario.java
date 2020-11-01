package hotel;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.*;


public class Calendario {

	//TE DA LA FECHA ACTUAL
    private static void SimpleDateFormatmethod() {
    	
        Calendar date = Calendar.getInstance();
        SimpleDateFormat dateformatter = new SimpleDateFormat("E dd/MM/yyyy 'a las' hh:mm:ss a zzz");
        System.out.println("La fecha actual en un formato dado: " + dateformatter.format(date.getTime()));
        System.out.println();
    }
    
    //TE DA LA DIFERENCIA ENTRE DOS FECHAS (TE DICE LOS DIAS QUE HAY ENTRE ESAS FECHAS)
    private static void DateDifference() {
        System.out.println("Diferencia entre dos fechas");
        Date startDate1 = new GregorianCalendar(2005, 02, 25, 14, 00).getTime();
        Date endDate1 = new Date();
 
        long diff = endDate1.getTime() - startDate1.getTime();
 
        System.out.println("    Diferencia entre '" + endDate1 + "' y '" + startDate1 + "'");
        System.out.println("    es de " + (diff / (1000L*60L*60L*24L)) + " días.");
    }

 
    public static void main(String[] args) {
        System.out.println();
        SimpleDateFormatmethod();
        DateDifference();
    }
}