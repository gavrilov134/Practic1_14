/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practic1_14;

import java.util.Scanner;

public class Practic1_14 {

    public static void main(String[] args) {
        System.out.println("Practical task 1.14, Student Evgeny Gavrilov, RIBO-01-22, Variant 3");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number sequence separated by commas: ");
        String input = scanner.nextLine();
        String[] numbers = input.split(",");

        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        Thread maxThread = new Thread(() -> {
            int max = array[0];
            for (int num : array) {
                if (num > max) {
                    max = num;
                }
            }
            System.out.println("Maximum value: " + max);
        });

        Thread minThread = new Thread(() -> {
            int min = array[0];
            for (int num : array) {
                if (num < min) {
                    min = num;
                }
            }
            System.out.println("Minimum value: " + min);
        });

        maxThread.start();
        minThread.start();

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}