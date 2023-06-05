package Audit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class audit {
    private static audit instance;
    PrintWriter writer = null;
    File audit1 = new File("audit.csv");
    public audit(){
        try {
            writer = new PrintWriter(audit1);
            writer.println("Timestamp" + ", " + "Action");
            writer.flush();
        } catch (IOException ex){
            System.out.println("Error");
        }
    }

    public static synchronized audit getInstance() {
        if (instance == null)
            instance = new audit();
        return instance;
    }

    public void makeAudit(String action){
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        writer.print(timestamp + ", ");
        writer.println(action);
        writer.flush();
    }
}
