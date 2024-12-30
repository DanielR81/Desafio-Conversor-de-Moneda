package com.alura.cursos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        int opcionDelUsuario;
        String json;
        double valorDeMoneda;
        float cantidaACambiar;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        System.out.println("---------------------------------------------------");
        System.out.println("       Bienvenido a mi conversor de moneda");
        System.out.println("---------------------------------------------------\n");

        while (true) {

            System.out.println("Nesecita elegir una opcion: \n");
            System.out.println("1) Dolares ==> Peso argentino");
            System.out.println("2) Peso argentino ==> Dolares");
            System.out.println("3) Dolares ==> Real Brasileño");
            System.out.println("4) Real Brasileño ==> Dolares");
            System.out.println("5) Dolares ==> Peso colombiano");
            System.out.println("6) Peso colombiano ==> Dolares");
            System.out.println("7) Salir");

            Scanner lectura = new Scanner(System.in);
            opcionDelUsuario = lectura.nextInt();

            if (opcionDelUsuario == 7) {
                break;
            }

            switch (opcionDelUsuario){

                case 1:

                    ConsutaApi miConsulta1 = new ConsutaApi();
                    json =  miConsulta1.consultaMoneda("USD");
                    Moneda miMoneda1 = gson.fromJson(json, Moneda.class);
                    valorDeMoneda = miMoneda1.conversion_rates().get("ARS");

                    System.out.println("Ingrese los dolares a convertir:");
                    Scanner opcion1 = new Scanner(System.in);
                    cantidaACambiar = opcion1.nextFloat();

                    System.out.println("En total son: "
                            + miConsulta1.conversionDeMondeda(valorDeMoneda, cantidaACambiar)
                            + " ARS.\n");
                    break;

                case 2:

                    ConsutaApi miConsulta2 = new ConsutaApi();
                    json =  miConsulta2.consultaMoneda("ARS");
                    Moneda miMoneda2 = gson.fromJson(json, Moneda.class);
                    valorDeMoneda = miMoneda2.conversion_rates().get("USD");

                    System.out.println("Ingrese los pesos argentinos a convetir:");
                    Scanner opcion2 = new Scanner(System.in);
                    cantidaACambiar = opcion2.nextFloat();

                    System.out.println("En total son: "
                            + miConsulta2.conversionDeMondeda(valorDeMoneda, cantidaACambiar)
                            + " USD. \n");
                    break;

                case 3:

                    ConsutaApi miConsulta3 = new ConsutaApi();
                    json =  miConsulta3.consultaMoneda("USD");
                    Moneda miMoneda3 = gson.fromJson(json, Moneda.class);
                    valorDeMoneda = miMoneda3.conversion_rates().get("BRL");

                    System.out.println("Ingrese los dolares a convertir :");
                    Scanner opcion3 = new Scanner(System.in);
                    cantidaACambiar = opcion3.nextFloat();

                    System.out.println("En total son: "
                            + miConsulta3.conversionDeMondeda(valorDeMoneda, cantidaACambiar)
                            + " BRL. \n");
                    break;

                case 4:

                    ConsutaApi miConsulta4 = new ConsutaApi();
                    json =  miConsulta4.consultaMoneda("BRL");
                    Moneda miMoneda4 = gson.fromJson(json, Moneda.class);
                    valorDeMoneda = miMoneda4.conversion_rates().get("USD");

                    System.out.println("Ingrese los reales brasileños a convertir :");
                    Scanner opcion4 = new Scanner(System.in);
                    cantidaACambiar = opcion4.nextFloat();

                    System.out.println("En total son: "
                            + miConsulta4.conversionDeMondeda(valorDeMoneda, cantidaACambiar)
                            + " USD. \n");
                    break;

                case 5:

                    ConsutaApi miConsulta5 = new ConsutaApi();
                    json =  miConsulta5.consultaMoneda("USD");
                    Moneda miMoneda5 = gson.fromJson(json, Moneda.class);
                    valorDeMoneda = miMoneda5.conversion_rates().get("COP");

                    System.out.println("Ingrese los dolares a convertir :");
                    Scanner opcion5 = new Scanner(System.in);
                    cantidaACambiar = opcion5.nextFloat();

                    System.out.println("En total son: "
                            + miConsulta5.conversionDeMondeda(valorDeMoneda, cantidaACambiar)
                            + " COP. \n");
                    break;

                case 6:

                    ConsutaApi miConsulta6 = new ConsutaApi();
                    json =  miConsulta6.consultaMoneda("COP");
                    Moneda miMoneda6 = gson.fromJson(json, Moneda.class);
                    valorDeMoneda = miMoneda6.conversion_rates().get("USD");

                    System.out.println("Ingrese los pesos colombianos a convertir :");
                    Scanner opcion6 = new Scanner(System.in);
                    cantidaACambiar = opcion6.nextFloat();

                    System.out.println("En total son: "
                            + miConsulta6.conversionDeMondeda(valorDeMoneda, cantidaACambiar)
                            + " USD. \n");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }


    }
}
