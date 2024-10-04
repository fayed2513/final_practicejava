import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if(args==null ||args.length!=1){
            System.out.println("Wrong Argument");
            return;
        }

//		Check arguments
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                                                new InputStreamReader(
                                                new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                String strings[] = readLine.split(",");
                for (String j : strings) {
                    System.out.println(j);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                                   new InputStreamReader(
                                   new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
//                System.out.println(readLine);
                String strings[] = readLine.split(",");
                Random random = new Random();
                int studentIndex = random.nextInt(strings.length);
                System.out.println(strings[studentIndex].trim());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                                   new FileWriter("students.txt", true));
                String substring = args[0].substring(1);
                Date date = new Date();
                String date_formate = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(date_formate);
                String fd = dateFormat.format(date);
                bufferedWriter.write(", " + substring + "\nList last updated on " + fd);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                                   new InputStreamReader(
                                   new FileInputStream("students.txt")));
                String readLine = bufferedReader.readLine();
                String strings[] = readLine.split(",");
                boolean done = false;
                String t = args[0].substring(1);
                for (int idx = 0; idx < strings.length && !done; idx++) {
                    if (strings[idx].trim().equals(t)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader bufferedReader = new BufferedReader(
                                   new InputStreamReader(
                                   new FileInputStream("students.txt")));
                String D = bufferedReader.readLine();
                char charArray[] = D.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c : charArray) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(bufferedReader) found ");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
        else{
            System.out.println("Wrong Argument");
        }
    }
}