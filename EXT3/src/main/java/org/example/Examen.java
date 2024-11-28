package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void Examen_ex1(){
        Scanner entry = new Scanner(System.in);
        Random ramdom = new Random();

        int N_boals = ramdom.nextInt(10,40)+1;
        int[] random_vector = new int[N_boals];
        int[][] bingo_table = new int[3][3];
        boolean repeat;
        System.out.println("***BIENVENIDO AL BINGO DEL CASINO CANTABRICO***");
        System.out.println("\n");

        for (int i=0;i<random_vector.length;i++){

            random_vector[i] = ramdom.nextInt(90)+1;

        }

        do {
            repeat = true;
            Arrays.sort(random_vector);
            for (int i = 0;i<random_vector.length;i++){
                if (random_vector.length - 1 != i && random_vector[i] == random_vector[i + 1]){
                    random_vector[i] = ramdom.nextInt(90)+1;
                    repeat = false;
                }
            }

        }while (!repeat);

        System.out.println(random_vector.length + " bolas extraidas hasta ahora " + Arrays.toString( random_vector));

        System.out.println("\n");
        System.out.println("*** Introduce los datos de tu carton ***");

        String user_chain;
        String [] user_row;

        for (int i = 0;i< bingo_table.length;i++){
            System.out.println("Fila: " + (i+1));
            user_chain = entry.next();
            user_row = user_chain.split("-");
            if (!user_chain.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")){
                System.out.println("Cerrando programa... Introduce valores con el formato correcto (N-N-N).");
                return;
            }
            for (int j = 0;j< bingo_table[0].length;j++){

                bingo_table[i][j] = Integer.parseInt(user_row[j]);

            }
        }

        for(int[] i : bingo_table){
            for (int j : i){
                System.out.print(j +" ");
            }
            System.out.println();
        }

        int line = 0, char_row;
        int[] good_lines = new int [3];

        for (int i = 0;i< bingo_table.length;i++){
            char_row = 0;
            for(int j=0;j< bingo_table[i].length;j++){

                for (int row = 0;row<random_vector.length;row++) {
                    if (random_vector[row] == bingo_table[i][j]) {
                        char_row++;
                    }
                }
            }
            if (char_row == bingo_table[0].length){
                good_lines[i] = 1;
                line++;
            }
        }

        System.out.println("PREMIOS:");
        System.out.println("\n");
        if (line == bingo_table.length){
            System.out.println("HAY BINGO!");
        }else {
            System.out.println("No hay BINGO.");
            for (int i = 0; i<good_lines.length;i++) {

                if (good_lines[i] == 1) {
                    System.out.println("Línea " + (i + 1) + " CORRECTA!!");
                }else {
                    System.out.println("Línea " + (i + 1) + " NO");
                }
            }
        }
    }
}

