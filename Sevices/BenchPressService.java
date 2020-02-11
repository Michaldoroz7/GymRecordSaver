package Sevices;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BenchPressService implements ExercisesFunctions {

    @Override
    public void AddExercise(int weight) throws IOException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(FileName(), true);
            fileWriter.write(CurrentDate());
            fileWriter.write(" ");
            fileWriter.write(Integer.toString(weight));
            fileWriter.write(" ");
            fileWriter.write("kg");
            fileWriter.write("\n");
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
                System.out.println("Record added");
            }
        }

    }

    @Override
    public void ShowExerciseRecords() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FileName()));
        String record = bufferedReader.readLine();

        while ((record != null)){
            System.out.println(record);
            record = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    private String FileName(){
        return "BenchPress.txt";
    }
    private String CurrentDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}
