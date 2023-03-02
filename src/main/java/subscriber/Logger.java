package subscriber;

import interfaces.Subscriber;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements Subscriber {
    private String filePath = "/Users/nik/Downloads/Spring2023/OOAD/Assignments/2/OOAD-3.2/OOAD-2023/src/main/java/loggers";
    public void update(SubscriberObject subscriberObject) {
        createLogFile(subscriberObject);
    }

    public void createLogFile(SubscriberObject subscriberObject) {
        //Create a log file
        filePath += "/Logger-" + subscriberObject.getDay() +".txt";

        /*
         * sources
         * 1. https://www.programiz.com/java-programming/examples/create-and-write-to-file
         * 2. https://www.baeldung.com/java-list-to-text-file
         */

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(filePath));
            for (String str : subscriberObject.getLogList()) {
                br.write(str + System.lineSeparator());
            }
            br.close();
        }catch(IOException exception) {
            System.out.println("Unable to write to file due to an exception");
        }
    }

}
