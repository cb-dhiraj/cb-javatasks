import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import org.json.simple.*;
import org.apache.commons.csv.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String csv = "/Users/cb-dhiraj/Task/src/week2/day5/src/maininp.csv";
        Reader readerCsv = Files.newBufferedReader(Paths.get(csv));
        JSONParser parser = new JSONParser();
        String jsonFile = "/Users/cb-dhiraj/Task/src/week2/day5/src/config.json";
        Reader reader = new FileReader(jsonFile);
        Object jsonObj = parser.parse(reader);
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("/Users/cb-dhiraj/Task/src/week2/day5/src/output.csv"));
        String Customer_Id = "", Subscription_Id="", Invoice_Number="", Invoice_Date="", Start_Date="", Amount="", Status="", Paid_On="", Next_Retry="", Refunded_Amount="", Recurring="", First_Invoice="", Customer_First_Name="", Customer_Last_Name="", Customer_Email="", Customer_Company="", Tax_Total="";
        CSVParser parseCsv = new CSVParser(readerCsv, CSVFormat.DEFAULT
                .withHeader("Customer Id","Subscription Id","Invoice Number","Invoice Date","Start Date","Amount","Status","Paid On","Next Retry","Refunded Amount","Recurring","First Invoice","Customer First Name","Customer Last Name","Customer Email","Customer Company","Tax Total")
                .withIgnoreHeaderCase()
                .withTrim());
        CSVPrinter addCsv = new CSVPrinter(writer, CSVFormat.DEFAULT
                .withHeader("Customer Id","Subscription Id","Invoice Id","Invoice Date","Start Date","Amount","Status","Paid On","Next Retry","Refunded Amount","Recurring","First Invoice","Customer Details","Tax Total"));
        int i=0;
        for(CSVRecord item : parseCsv){
            if(i>0){
                Customer_Id = item.get("Customer Id");
                Subscription_Id = item.get("Subscription Id");
                Invoice_Number = item.get("Invoice Number");
                Invoice_Date = item.get("Invoice Date");
                Start_Date = item.get("Start Date");
                Amount = item.get("Amount");
                Status = item.get("Status");
                Paid_On = item.get("Paid On");
                Next_Retry = item.get("Next Retry");
                Refunded_Amount = item.get("Refunded Amount");
                Recurring = item.get("Recurring");
                First_Invoice = item.get("First Invoice");
                Customer_First_Name = item.get("Customer First Name");
                Customer_Last_Name = item.get("Customer Last Name");
                Customer_Email = item.get("Customer Email");
                Customer_Company = item.get("Customer Company");
                Tax_Total = item.get("Tax Total");

                try{
                    Invoice_Date = (Invoice_Date.substring(0,10) + " " + Invoice_Date.substring(11,19));
                    Start_Date = (Start_Date.substring(0,10) + " " + Start_Date.substring(11,19));
                    Paid_On = (Paid_On.substring(0,10) + " " + Paid_On.substring(11,19));
                }
                catch (StringIndexOutOfBoundsException x){

                }

                JSONObject jsonObject = (JSONObject) jsonObj;
                jsonObject.put("First Name", Customer_First_Name);
                jsonObject.put("Last Name", Customer_Last_Name);
                jsonObject.put("Email", Customer_Email);
                jsonObject.put("Company", Customer_Company);

                List<String> list = new ArrayList<>();
                list.add(Customer_Id);
                list.add(Subscription_Id);
                list.add(Invoice_Number);
                list.add(Invoice_Date);
                list.add(Start_Date);
                list.add(Amount);
                list.add(Status);
                list.add(Paid_On);
                list.add(Next_Retry);
                list.add(Refunded_Amount);
                list.add(Recurring);
                list.add(First_Invoice);
                list.add(jsonObject.toJSONString());
                list.add(Tax_Total);

                addCsv.printRecord(list);
                addCsv.flush();
            }
            ++i;
        }
    }
}
