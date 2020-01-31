package com.company;

import Sevices.BenchPressService;
import Sevices.DeadliftService;
import Sevices.SquatService;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        System.out.println("Welcome in Gym Record Saver");
        System.out.println("Which exercise record you want to save ?");
        System.out.println("1 - Bench Press");
        System.out.println("2 - Dead lift");
        System.out.println("3 - Squat");
        int selectedExercise = sc.nextInt();
        System.out.println("Enter your record");
        int weight = sc.nextInt();

        ExerciseSelector(selectedExercise, weight);

    }

    static void ExerciseSelector(int selectedExercise, int weight) throws IOException {

        BenchPressService benchPressService = new BenchPressService();
        DeadliftService deadliftService = new DeadliftService();
        SquatService squatService = new SquatService();

        switch (selectedExercise) {
            case 1:
                benchPressService.AddExercise(weight);
                break;
            case 2:
                deadliftService.AddExercise(weight);
                break;
            case 3:
                squatService.AddExercise(weight);
                break;
            default:
                System.out.println("Something gone wrong");
                break;
        }
    }
}
