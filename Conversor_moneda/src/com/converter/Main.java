package com.converter;

import com.converter.service.CurrencyConverter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        while (true) {
            System.out.println("\n *********************************");
            System.out.println("*          Bienvenido           *");
            System.out.println("*********************************");
            System.out.println("\n Seleccione una opción:");
            System.out.println("1. Convertir de dólar a peso argentino");
            System.out.println("2. Convertir de peso argentino a dólar");
            System.out.println("3. Convertir de dólar a real brasileño");
            System.out.println("4. Convertir de real brasileño a dólar");
            System.out.println("5. Convertir de dólar a peso colombiano");
            System.out.println("6. Convertir de peso colombiano a dólar");
            System.out.println("7. Salir");
            System.out.println("*********************************");

            int option = scanner.nextInt();

            if (option == 7) {
                System.out.println("Saliendo del programa...");
                break;
            }
            System.out.print("___");
            System.out.print("Ingrese la cantidad a convertir: ");


            double amount = scanner.nextDouble();

            switch (option) {
                case 1:
                    converter.convert("USD", "ARS", amount);
                    break;
                case 2:
                    converter.convert("ARS", "USD", amount);
                    break;
                case 3:
                    converter.convert("USD", "BRL", amount);
                    break;
                case 4:
                    converter.convert("BRL", "USD", amount);
                    break;
                case 5:
                    converter.convert("USD", "COP", amount);
                    break;
                case 6:
                    converter.convert("COP", "USD", amount);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        scanner.close();
    }
}
