package api.utils;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.List;

//Create a function to read logs of todays date from c drive temp folder and write it to an xml file in the same location using libraries for file handling
public class FileAccess {
    public static void main(String[] args) {
        String folderPath = "C:/temp";
        String fileName = "logs.xml";
        
        // Get today's date
        LocalDate today = LocalDate.now();
        
        // Create the file path
        String filePath = folderPath + "/" + fileName;
        
        // Read logs from the temp folder
        List<String> logs = readLogs(folderPath, today);
        
        // Write logs to the XML file
        writeLogsToXml(filePath, logs);
    }
    
    public static List<String> readLogs(String folderPath, LocalDate date) {
        List<String> logs = null;
        
        try {
            // Get the log file path based on the date
            String logFilePath = folderPath + "/logs_" + date.toString() + ".txt";
            
            // Read the logs from the file
            logs = Files.readAllLines(Paths.get(logFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return logs;
    }
    
    public static void writeLogsToXml(String filePath, List<String> logs) {
        try {
            // Create a new XML file
            File xmlFile = new File(filePath);
            
            // Create a FileWriter object to write to the XML file
            FileWriter writer = new FileWriter(xmlFile);
            
            // Write the logs to the XML file
            for (String log : logs) {
                writer.write("<log>" + log + "</log>\n");
            }
            
            // Close the FileWriter
            writer.close();
            
            System.out.println("Logs written to XML file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
