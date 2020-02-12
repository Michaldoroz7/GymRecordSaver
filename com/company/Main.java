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
        int selectedOption = 1;

        while(selectedOption != 3) {


        System.out.println("What you want to do ?");
        System.out.println("1 - Save record");
        System.out.println("2 - Check records");
        System.out.println("3 - Exit");
        selectedOption = sc.nextInt();

            if (selectedOption == 1) {
                System.out.println("Which exercise record you want to save ?");
                System.out.println("1 - Bench Press");
                System.out.println("2 - Dead lift");
                System.out.println("3 - Squat");
                int selectedExercise = sc.nextInt();
                System.out.println("Enter your record");
                int weight = sc.nextInt();
                ExerciseSelector(selectedExercise, weight);
            } else if (selectedOption == 2) {
                ExerciseShower();
            } else if (selectedOption == 3) {
                System.out.println("Bye");
                break;
            }
        }
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

    static void ExerciseShower() throws IOException {
        Scanner sc = new Scanner(System.in);

        BenchPressService benchPressService = new BenchPressService();
        DeadliftService deadliftService = new DeadliftService();
        SquatService squatService = new SquatService();

        System.out.println("Which exercise you want to check? ");
        String selectedExercise = sc.nextLine();

        if(selectedExercise.equals("Bench Press")){
            benchPressService.ShowExerciseRecords();
        } else if (selectedExercise.equals("Squat")){
            squatService.ShowExerciseRecords();
        } else {
            deadliftService.ShowExerciseRecords();
        }

    }
}
