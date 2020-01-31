package Sevices;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeadliftService implements ExerciseAdder{

    @Override
    public void AddExercise(int weight) throws IOException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(FileName(), true);
            fileWriter.write(CurrentDate());
            fileWriter.write(" ");
            fileWriter.write(Integer.toString(weight));
            fileWriter.write("\n");
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
                System.out.println("Record added");
            }
        }

    }
    private String FileName(){
        return "Deadlift.txt";
    }
    private String CurrentDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}
