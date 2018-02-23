package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    static float[][] matriks; // baris x kolom + Konstanta di akhir kolom
    static int sizeMatriks;

    public static void main(String[] args) {
	// write your code here
        File file = new File("C:\\Users\\tommywahyu44\\Documents\\metnum.txt");

        try {

            Scanner sc = new Scanner(file);
            int counter = 0;
            int x = 0,y = 0;
            while (sc.hasNextLine()) {
                int i = sc.nextInt();
                if (counter == 0) {
                    sizeMatriks = i;
                    matriks = new float[sizeMatriks][sizeMatriks+1];
                } else if (counter <= (sizeMatriks*sizeMatriks)){
                    matriks[x][y] = i;
                    if (y != (sizeMatriks-1) ){
                        y++;
                    } else {
                        y = 0; x++;
                    }

                } else {

                    matriks[x][y] = i;
                    x++;
                }
                if (counter == sizeMatriks*sizeMatriks){
                    x = 0;
                    y = 3;
                }

                counter++;
            }
            for (int i=0;i<sizeMatriks;i++){
                for (int j=0;j<sizeMatriks+1;j++){
                    System.out.print(matriks[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            sc.close();
            opeasiBaris(matriks);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

    public static void opeasiBaris (float matriks[][]){
        int operasiDepan = 0;

                while (operasiDepan < sizeMatriks) {
                    float pembagi, pengali;
                    for (int baris = 0; baris < sizeMatriks; baris++) {
                        pembagi = matriks[operasiDepan][operasiDepan];
                        pengali = matriks[baris][operasiDepan] / matriks[operasiDepan][operasiDepan];

                        for (int kolom = 0; kolom < sizeMatriks + 1; kolom++) {
                            if (baris == operasiDepan) {
                                matriks[baris][kolom] /= pembagi;
                            } else matriks[baris][kolom] -= matriks[operasiDepan][kolom] * pengali;
                        }
                    }

                    operasiDepan++;
                    for (int i=0;i<sizeMatriks;i++){
                        for (int j=0;j<sizeMatriks+1;j++){
                            System.out.print(Math.round(matriks[i][j]*100.0)/100.0+" ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }

            }
        }
