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
public class AplicacionAgenda {

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

                    do {
                        System.out.println("introduce dia");
                        dia = teclado.nextInt();
                        System.out.println("introduce mes");
                        mes = teclado.nextInt();
                    } while (!comprobarFecha(dia, mes));

                    agenda.abierta = agenda.buscarPagina(dia, mes);
                    System.out.println("la pagina selecionada " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());

                    do {
                        System.out.println("introduce hora");
                        hora = teclado.nextInt();
                        System.out.println("introduce minutos");
                        minutos = teclado.nextInt();
                        teclado.nextLine();
                    } while (!comprobarHora(hora, minutos));

                    Cita c = agenda.abierta.buscarCita(hora, minutos);

                    if (c == null) {
                        System.out.println("introduce titulo");
                        titulo = teclado.nextLine();
                        System.out.println("introduce texto");
                        texto = teclado.nextLine();

                        cita = new Cita(hora, minutos, titulo, texto);

                        agenda.abierta.anadirCita(cita);
                        agenda.abierta.leerPagina();
                    } else {
                        System.out.println("La fecha ya está en uso");
                    }
                    agenda.abierta.leerPagina();
                    break;

                case 2:
                    do {
                        System.out.println("introduce dia");
                        dia = teclado.nextInt();
                        System.out.println("introduce mes");
                        mes = teclado.nextInt();
                    } while (!comprobarFecha(dia, mes));

                    agenda.abierta = agenda.buscarPagina(dia, mes);
                    System.out.println("la pagina selecionada " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());

                    do {
                        System.out.println("introduce hora");
                        hora = teclado.nextInt();
                        System.out.println("introduce minutos");
                        minutos = teclado.nextInt();
                        teclado.nextLine();
                    } while (!comprobarHora(hora, minutos));

                    c = agenda.abierta.buscarCita(hora, minutos);

                    if (c != null) {
                        agenda.abierta.borrarCita(c);
                    } else {
                        System.out.println("La cita no existe");
                    }
                    agenda.abierta.leerPagina();
                    break;

                case 3:
                    do {
                        System.out.println("introduce dia");
                        dia = teclado.nextInt();
                        System.out.println("introduce mes");
                        mes = teclado.nextInt();
                    } while (!comprobarFecha(dia, mes));

                    agenda.abierta = agenda.buscarPagina(dia, mes);
                    System.out.println("la pagina selecionada " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());

                    do {
                        System.out.println("introduce hora");
                        hora = teclado.nextInt();
                        System.out.println("introduce minutos");
                        minutos = teclado.nextInt();
                        teclado.nextLine();
                    } while (!comprobarHora(hora, minutos));

                    c = agenda.abierta.buscarCita(hora, minutos);

                    if (c != null) {
                        c.leerCita();
                    } else {
                        System.out.println("La cita no existe");
                    }
                    agenda.abierta.leerPagina();
                    break;

                case 4:
                    do {
                        System.out.println("introduce dia");
                        dia = teclado.nextInt();
                        System.out.println("introduce mes");
                        mes = teclado.nextInt();
                    } while (!comprobarFecha(dia, mes));

                    agenda.abierta = agenda.buscarPagina(dia, mes);
                    System.out.println("la pagina selecionada " + agenda.abierta.getDia() + " del mes " + agenda.abierta.getMes());

                    do {
                        System.out.println("introduce hora");
                        hora = teclado.nextInt();
                        System.out.println("introduce minutos");
                        minutos = teclado.nextInt();
                        teclado.nextLine();
                    } while (!comprobarHora(hora, minutos));

                    c = agenda.abierta.buscarCita(hora, minutos);

                    if (c != null) {
                        System.out.println("introduce nuevo texto");
                        String nuevoTexto = teclado.nextLine();
                        c.setTexto(nuevoTexto);
                    }
                    agenda.abierta.leerPagina();
                    break;

                case 0:
                    System.out.println("Salir");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;

            }

        } while (opc != 0);

    }

    public static void menu() {
        System.out.println("1. Añadir cita");
        System.out.println("2. Borrar cita");
        System.out.println("3. Buscar cita");
        System.out.println("4. Modificar el texto de una cita");
        System.out.println("0. Salir");
    }

    public static boolean comprobarFecha(int dia, int mes) {
        if (mes > 0 && mes <= 12) {
            if (dia > 0 && dia <= 31) {
                return true;
            }
        }
        return false;
    }

    public static boolean comprobarHora(int hora, int minutos) {
        if (hora > 0 && hora <= 24) {
            if (minutos > 0 && minutos <= 59) {
                return true;
            }
        }
        return false;
    }
}
