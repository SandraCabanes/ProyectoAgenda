/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud07_proyectoagenda;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class UD07_ProyectoAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Calendar fecha;
        Scanner teclado = new Scanner(System.in);
        int opc = 0;
        Agenda agenda;
        Pagina pagina;
        Pagina pagActiva;
        Cita cita;
        int hora, minutos, dia, mes, anyo;
        String texto, titulo;

        System.out.println("Introduce el añi de la nueva agenda");
        anyo = teclado.nextInt();
        agenda = new Agenda(anyo);
        System.out.println("\n\n+**********Citas " + agenda.getAnyo() + "************");

        do {
            menu();
            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    //añadir los metodos para validar que el dia y mes son correctos
                    System.out.println("introduce dia");
                    dia = teclado.nextInt();
                    System.out.println("introduce mes");
                    mes = teclado.nextInt();

                    //aqui
                    agenda.abierta = agenda.buscarPagina(dia, mes);
                    System.out.println("la pagina selecionada " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());

                    break;
                case 2:
                    //añadir metodos para validad hora minuto
                    System.out.println("introduce hora");
                    hora = teclado.nextInt();
                    System.out.println("introduce minutos");
                    minutos = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("introduce titulo");
                    titulo = teclado.nextLine();
                    System.out.println("introduce texto");
                    texto = teclado.nextLine();
                    //validar si no hay ya una activa
                    cita = new Cita(hora, minutos, titulo, texto);

                    agenda.abierta.anadirCita(cita);
                    agenda.abierta.leerPagina();
                    break;
            }
        } while (opc != 8);

    }

    public static void menu() {
        System.out.println("0.Salir");
        System.out.println("1.Crear libreria indiacando el nombre");
        System.out.println("2.Visualizar la informacion de la libreria y de todos sus libros");
        System.out.println("3.insertar un libro ordenadamente en la lista por titulo");
        System.out.println("4.visualizar datos del libro");
        System.out.println("5.buscar un libro por su precio y mostrar su informacion");
        System.out.println("6.modificar el titulo del libro determinadado");
        System.out.println("7.crear una lsta de libros cuyo titulo comientce por la letra que pasa el usuario");
        System.out.println("8.crear una lista de libros ordenada por precio");
        System.out.println("--Introduce opcion--");

    }
}
