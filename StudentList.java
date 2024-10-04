import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if(args==null ||args.length!=1){
            System.out.println(Constants.message);
            return;
        }

//		Check arguments
        String readLine=fileReader(Constants.totalList);
        if (args[0].equals(Constants.studentList)) {
            System.out.println(Constants.loading);
            try {
                String strings[] = readLine.split(Constants.splitAt);
                for (String j : strings) {
                    System.out.println(j);
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        } else if (args[0].equals(Constants.randomStudent)) {
            System.out.println(Constants.loading);
            try {
                String strings[] = readLine.split(Constants.splitAt);
                Random random = new Random();
                int studentIndex = random.nextInt(strings.length);
                System.out.println(strings[studentIndex].trim());
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.addStudent)) {
            System.out.println(Constants.loading);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(
                                   new FileWriter(Constants.totalList, true));
                String substring = args[0].substring(1);
                Date date = new Date();
                String date_formate = Constants.dateFormat;
                DateFormat dateFormat = new SimpleDateFormat(date_formate);
                String fd = dateFormat.format(date);
                bufferedWriter.write(Constants.splitAt + substring + Constants.updateList + fd);
                bufferedWriter.close();
            } catch (Exception e) {
            }

            System.out.println(Constants.loaded);
        } else if (args[0].contains(Constants.Present)) {
            System.out.println(Constants.loading);
            try {
                String strings[] = readLine.split(Constants.splitAt);
                boolean done = false;
                String substring = args[0].substring(1);
                for (int idx = 0; idx < strings.length && !done; idx++) {
                    if (strings[idx].trim().equals(substring)) {
                        System.out.println(Constants.student_Found);
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        } else if (args[0].equals(Constants.student_count)) {
            System.out.println(Constants.loading);
            try {
                char charArray[] = readLine.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char elements : charArray) {
                    if (elements == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + Constants.bReader);
            } catch (Exception e) {
            }
            System.out.println(Constants.loaded);
        }
        else{
            System.out.println(Constants.message);
        }
    }
    public static String fileReader(String fileName){
        try{
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(Constants.totalList)));
            return bufferedReader.readLine();
        }
        catch (Exception e){
            return null;
        }
    }
}