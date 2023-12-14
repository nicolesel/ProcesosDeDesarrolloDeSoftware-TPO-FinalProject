package Main;

 

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 

import Hotel.ModuloHotel;

 

public class CrearDatosFalsos {
    
    public CrearDatosFalsos() { // Falta crear los objetos
        
        crearClientes();
        crearHabitaciones();
        crearReservas();
    }
    
    
    public void crearClientes(){

 

        String nombre = "Manu";
        String apellido = "Pereiro";
        int dni = 2039589;
        int telefono = 1125207927;
        String email = "manurojo@hotmail.com";
        String usuario = "manupereiro";
        String contraseña = "maradona123";
        String estrategia = "WPP";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
        nombre = "Jorge";
        apellido = "Garcia";
        dni = 2239589;
        telefono = 1125131666;
        email = "jorgegarcia@hotmail.com";
        usuario = "jorgegarcia";
        contraseña = "messi123";
        estrategia = "Email";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
        nombre = "Alejo";
        apellido = "Sanchez";
        dni = 2339589;
        telefono = 1136231415;
        email = "alejosanchez@hotmail.com";
        usuario = "alejosanchez";
        contraseña = "kiko123";
        estrategia = "WPP";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
        nombre = "Pedro";
        apellido = "Petro";
        dni = 2439589;
        telefono = 1123242579;
        email = "pedropetro@hotmail.com";
        usuario = "pedropetro";
        contraseña = "macri345";
        estrategia = "SMS";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
        nombre = "Bauti";
        apellido = "Molina";
        dni = 2539589;
        telefono = 1198765432;
        email = "bautimolina@hotmail.com";
        usuario = "bautimolina";
        contraseña = "sopadefideos";
        estrategia = "WPP";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
        nombre = "Mariano";
        apellido = "Pesce";
        dni = 40674321;
        telefono = 1156437865;
        email = "marianopesce@hotmail.com";
        usuario = "marianopesce";
        contraseña = "milanesadepollo";
        estrategia = "SMS";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
        nombre = "Luis";
        apellido = "Fernandez";
        dni = 12432734;
        telefono = 1176548567;
        email = "luisfernandez@hotmail.com";
        usuario = "luisfernandez";
        contraseña = "fideosconcrema";
        estrategia = "Email";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
        nombre = "Alejo";
        apellido = "Sanchez";
        dni = 2339589;
        telefono = 1136231415;
        email = "alejosanchez@hotmail.com";
        usuario = "alejosanchez";
        contraseña = "empanadasdeatun";
        estrategia = "WPP";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
        nombre = "Hernan";
        apellido = "Picheto";
        dni = 2432189;
        telefono = 1104912579;
        email = "hernanpicheto@hotmail.com";
        usuario = "hernanpicheto";
        contraseña = "pizzajamonymorrones";
        estrategia = "SMS";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
        nombre = "Lisandro";
        apellido = "Delatorre";
        dni = 2539589;
        telefono = 1198765432;
        email = "lisandrodelatorre@hotmail.com";
        usuario = "lisandrodelatorre";
        contraseña = "sushi";
        estrategia = "WPP";

 

        ModuloHotel.getInstancia().crearCliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
        
    }
    
    public void crearHabitaciones() {

 

        int capacidad = 2;
        float precio = 10000;
        String tipo = "normal";
        boolean despertador = false;
        boolean internet = false;
        boolean miniBar = false;
        boolean TV = false;
        List<Boolean> lista = new ArrayList<Boolean>();
        lista.add(despertador);
        lista.add(internet);
        lista.add(miniBar);
        lista.add(TV);
 
        ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista);
 
        capacidad = 4;
        precio = 20000;
        tipo = "suite";
        despertador = true;
        internet = true;
        miniBar = false;
        TV = false;
        List<Boolean> lista1 = new ArrayList<Boolean>();
        lista1.add(despertador);
        lista1.add(internet);
        lista1.add(miniBar);
        lista1.add(TV);
 
        ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista1);
 
        capacidad = 1;
        precio = 5000;
        tipo = "normal";
        despertador = false;
        internet = false;
        miniBar = true;
        TV = true;
        List<Boolean> lista2 = new ArrayList<Boolean>();
        lista2.add(despertador);
        lista2.add(internet);
        lista2.add(miniBar);
        lista2.add(TV);
 
        ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista2);
 
       
        capacidad = 3;
        precio = 9000;
        tipo = "normal";
        despertador = false;
        internet = true;
        miniBar = true;
        TV = false;
        List<Boolean> lista3 = new ArrayList<Boolean>();
        lista3.add(despertador);
        lista3.add(internet);
        lista3.add(miniBar);
        lista3.add(TV);
 
        ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista3);
 
        capacidad = 2;
        precio = 15000;
        tipo = "suite";
        despertador = true;
        internet = true;
        miniBar = true;
        TV = false;
        List<Boolean> lista4 = new ArrayList<Boolean>();
        lista4.add(despertador);
        lista4.add(internet);
        lista4.add(miniBar);
        lista4.add(TV);
 
        ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista4);
 
        capacidad = 5;
        precio = 30000;
        tipo = "normal";
        despertador = false;
        internet = false;
        miniBar = true;
        TV = false;
        List<Boolean> lista5 = new ArrayList<Boolean>();
        lista5.add(despertador);
        lista5.add(internet);
        lista5.add(miniBar);
        lista5.add(TV);
 
        ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista5);
 
        capacidad = 2;
        precio = 7000;
        tipo = "normal";
        despertador = true;
        internet = true;
        miniBar = true;
        TV = true;
        List<Boolean> lista6 = new ArrayList<Boolean>();
        lista6.add(despertador);
        lista6.add(internet);
        lista6.add(miniBar);
        lista6.add(TV);
 
        ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista6);
 
        capacidad = 3;
        precio = 10000;
        tipo = "normal";
        despertador = false;
        internet = false;
        miniBar = false;
        TV = true;
        List<Boolean> lista7 = new ArrayList<Boolean>();
        lista7.add(despertador);
        lista7.add(internet);
        lista7.add(miniBar);
        lista7.add(TV);
 
        ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista7);
 
        capacidad = 3;
        precio = 9000;
        tipo = "normal";
        despertador = false;
        internet = true;
        miniBar = true;
        TV = false;
        List<Boolean> lista8 = new ArrayList<Boolean>();
        lista8.add(despertador);
        lista8.add(internet);
        lista8.add(miniBar);
        lista8.add(TV);
 
        ModuloHotel.getInstancia().crearHabitacion(capacidad, precio, tipo, lista8);

 

    }
    
    public void crearReservas() {

    	    
    	Date fechaIn2 = new Date(2023, 03, 25);
    	Date fechaOut2 = new Date(2023, 05, 27);
    	ModuloHotel.getInstancia().crearReserva(fechaIn2, fechaOut2, ModuloHotel.getInstancia().buscarCliente(2), ModuloHotel.getInstancia().buscarHabitacion(2));
    	ModuloHotel.getInstancia().pagar(1, "EFECTIVO");
    	ModuloHotel.getInstancia().tomar(1);
    	ModuloHotel.getInstancia().terminar(1);
    	
    	
    	Date fechaIn3 = new Date(2023, 11, 20);
    	Date fechaOut3 = new Date(2023, 11, 28); 
    	ModuloHotel.getInstancia().crearReserva(fechaIn3, fechaOut3, ModuloHotel.getInstancia().buscarCliente(3), ModuloHotel.getInstancia().buscarHabitacion(3));
    	ModuloHotel.getInstancia().pagar(2, "EFECTIVO");
    	ModuloHotel.getInstancia().tomar(2);




    	Date fechaIn4 = new Date(2023, 11, 19);
    	Date fechaOut4 = new Date(2023, 11, 23); 
    	ModuloHotel.getInstancia().crearReserva(fechaIn4, fechaOut4, ModuloHotel.getInstancia().buscarCliente(4), ModuloHotel.getInstancia().buscarHabitacion(4));
    	ModuloHotel.getInstancia().pagar(3, "EFECTIVO");
    	ModuloHotel.getInstancia().tomar(3);




    	Date fechaIn5 = new Date(2024, 01, 25);
    	Date fechaOut5 = new Date(2024, 01, 27); 
    	ModuloHotel.getInstancia().crearReserva(fechaIn5, fechaOut5, ModuloHotel.getInstancia().buscarCliente(5), ModuloHotel.getInstancia().buscarHabitacion(5));





    	Date fechaIn6 = new Date(2023, 11, 25);
    	Date fechaOut6 = new Date(2023, 11, 29); 
    	ModuloHotel.getInstancia().crearReserva(fechaIn6, fechaOut6, ModuloHotel.getInstancia().buscarCliente(6), ModuloHotel.getInstancia().buscarHabitacion(6));
    	ModuloHotel.getInstancia().pagar(5, "EFECTIVO");




    	Date fechaIn7 = new Date(2024, 12, 25);
    	Date fechaOut7 = new Date(2024, 01, 01); 
    	ModuloHotel.getInstancia().crearReserva(fechaIn7, fechaOut7, ModuloHotel.getInstancia().buscarCliente(7), ModuloHotel.getInstancia().buscarHabitacion(7));





    	Date fechaIn8 = new Date(2023, 11, 25);
    	Date fechaOut8 = new Date(2023, 12, 24); 
    	ModuloHotel.getInstancia().crearReserva(fechaIn8, fechaOut8, ModuloHotel.getInstancia().buscarCliente(8), ModuloHotel.getInstancia().buscarHabitacion(8));
    	ModuloHotel.getInstancia().pagar(7, "EFECTIVO");




    	Date fechaIn9 = new Date(2023, 11, 25);
    	Date fechaOut9 = new Date(2024, 01, 07); 
    	ModuloHotel.getInstancia().crearReserva(fechaIn9, fechaOut9, ModuloHotel.getInstancia().buscarCliente(9), ModuloHotel.getInstancia().buscarHabitacion(9));
    	ModuloHotel.getInstancia().pagar(8, "EFECTIVO");




    	Date fechaIn10 = new Date(2024, 01, 10);
    	Date fechaOut10 = new Date(2024, 01, 12); 
    	ModuloHotel.getInstancia().crearReserva(fechaIn10, fechaOut10, ModuloHotel.getInstancia().buscarCliente(9), ModuloHotel.getInstancia().buscarHabitacion(9));




    }
    
    
}