
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class CMSModules{
    public static void addData(String IDNo, String lastname, String firstname, String contact, String address){
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter("datafile.txt",true));
            output.write(IDNo+", ");
            output.write(lastname+", ");
            output.write(firstname+", ");
            output.write(contact+", ");
            output.write(address);
            output.newLine();
            output.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void searchData(String searchIDTxt){
        ContactInterface CI = new ContactInterface();
        Boolean chk = true;

        try{
            BufferedReader br = new BufferedReader(new FileReader("datafile.txt"));
            String line = "";

            while((line = br.readLine()) != null) {
                String[] values = line.split (",");
                String tempVal = "";
                if(values[0].equals(searchIDTxt)){
                    CI.setSLName(values[1]);
                    CI.setSFName(values[2]);
                    CI.setSContact(values[3]);
                    CI.setSLocation(values[4] + ".");
                    chk = false;
                    if(values.length > 5) {
                        for(int a = 4; a < values.length; a++){
                            if(a < values.length-1) tempVal += values[a] + ", ";
                            else tempVal += values[a] + ".";
                        }
                        CI.setSLocation(tempVal);
                    }
                    break;
                }
            }
            if(chk) CI.displayError();
        }catch(Exception a) {
            a.getStackTrace();
        }
    }

    public static String[][] displayAll(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("datafile.txt"));    
            String output = br.readLine();
            String line = "";
            String values[]= null;
            String[][] data = new String[20][5];
            int counterrow = 0;

            while ((line = output) != null){
                values = line.split(", ");
                if(values.length > 5) {
                    String tempVal = "";
                    for(int a = 4; a < values.length; a++){
                        if(a < values.length-1) tempVal += values[a] + ", ";
                        else tempVal += values[a] + ".";
                    }
                    data[counterrow][0] = values[0];
                    data[counterrow][1] = values[1];
                    data[counterrow][2] = values[2];
                    data[counterrow][3] = values[3];
                    data[counterrow][4] = tempVal;
                }else{
                    data[counterrow][0] = values[0];
                    data[counterrow][1] = values[1];
                    data[counterrow][2] = values[2];
                    data[counterrow][3] = values[3];
                    data[counterrow][4] = values[4];
                }
                counterrow++;
                output = br.readLine();
            }
            return data;
        }

        catch(Exception e) {
            System.out.println(e);
            e.getStackTrace();
            return null;
        }    
    }

}
