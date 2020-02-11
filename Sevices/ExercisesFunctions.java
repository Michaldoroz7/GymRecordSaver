package Sevices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public interface ExercisesFunctions {

    public void AddExercise(int weight) throws IOException;
    public void ShowExerciseRecords() throws IOException;
}
