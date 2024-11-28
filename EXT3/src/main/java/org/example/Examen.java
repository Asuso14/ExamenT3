package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void Examen_ex1(){
        Scanner entry = new Scanner(System.in);
        Random ramdom = new Random();

        int N_boals = ramdom.nextInt(10,40)+1; //Aqui declaramos los vectores/matrices/variables que se van a usar para hacer el programa.
        int[] random_vector = new int[N_boals];
        int[][] bingo_table = new int[3][3];
        boolean repeat;
        System.out.println("***BIENVENIDO AL BINGO DEL CASINO CANTABRICO***");
        System.out.println("\n");//Imprimimos por pantalla y despues generamos con el ramdom un valor para cada uno de los huecos creados por N_Bolas

        for (int i=0;i<random_vector.length;i++){

            random_vector[i] = ramdom.nextInt(90)+1;

        }

        do {//Esta parte del codigo lo que hace es que va a recorrer el vector con los numeros random hasta que no quede ninguno repetido, para esto ordena y
            // compara la posicion actual con la siguiente del vector. Si es la ultima posicion no lo comprueba
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
        //Defino las variables/vector que voy a usar para que el usuario ingrese los datos a la matriz.
        String user_chain;
        String [] user_row;

        for (int i = 0;i< bingo_table.length;i++){//Este for se encarga de recorrer las filas de la matriz, el usuario ingresara una cadena.
            // Que tiene un formato especifico, si no ingresa el dato con ese formato sacará del programa.
            System.out.println("Fila: " + (i+1));
            user_chain = entry.next();
            user_row = user_chain.split("-");//Combertimos la cadena en un vector, separado por -.
            if (!user_chain.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")){
                System.out.println("Cerrando programa... Introduce valores con el formato correcto (N-N-N).");
                return;
            }
            for (int j = 0;j< bingo_table[0].length;j++){//Ingresa el vector generado en cada una de las posiciones de cada fila.

                bingo_table[i][j] = Integer.parseInt(user_row[j]);

            }
        }

        for(int[] i : bingo_table){//Con este foreach recorre la matriz, imprimiendo cada posicion de esta.
            for (int j : i){
                System.out.print(j +" ");
            }
            System.out.println();
        }

        int line = 0, char_row;//Declaro las variables para saber que caracter esta bien, y con estos calculo la lineas que estan correctas.
        int[] good_lines = new int [3];

        for (int i = 0;i< bingo_table.length;i++){//recorre las filas de la matriz
            char_row = 0;
            for(int j=0;j< bingo_table[i].length;j++){//recorre las columnas de la matriz.

                for (int row = 0;row<random_vector.length;row++) {//recorremos el vector aleatorio del principio, comparando la posicion actual con la
                    // posicion que guardamos del vector con i y j. Si coincide sumanos 1 a la catidad de caracteres que coinciden en la fila.
                    if (random_vector[row] == bingo_table[i][j]) {
                        char_row++;
                    }
                }
            }
            if (char_row == bingo_table[0].length){
                good_lines[i] = 1;//Si los 3 caracteres estan bien, la linea se marca como bien.
                line++;
            }
        }

        System.out.println("PREMIOS:");
        System.out.println("\n");//Comprueba que lineas estan bien, si las 3 estan bien muestra BINGO, sino cada linea que este bien la va a imprimir. 
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

