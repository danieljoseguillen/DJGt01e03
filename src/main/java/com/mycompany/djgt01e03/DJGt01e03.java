/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.djgt01e03;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class DJGt01e03 {

    public static void main(String[] args) {
        ArrayList <Persona> person = new ArrayList <Persona>();
        person.add(new Persona("Z604983M","Jorge Salas",22));
        person.add(new Persona("45434347M","Jose Gonzales",14));
        person.add(new Persona("32634745A","Laura Garcia",36));
        person.add(new Persona("15312732C","Habilio",56));
        
        System.out.println("El promedio de edad es de "+calcAvgEdad(person)+" años.");
        System.out.println("La edad de la persona mas mayor es de "+retEdMayor(person)+" años.");
        System.out.println("El nombre de la persona mas mayor es: "+retNomMayor(person));
        System.out.println("La persona de mayor edad:");
        System.out.println(retMayor(person));
        System.out.println("Lista de mayores de edad: ");
        System.out.println(showMayores(person));
        System.out.println("Todas las personas de edad igual o mayor a la media: ");
        System.out.println(showMayOMed(person));
    }

    public static int retIndMayor(ArrayList<Persona> pers) {
        int ed = 0, ind = -1;

        for (Persona per : pers) {
            if (ed < per.getEdad()) {
                ed = per.getEdad();
            }
            ind++;
        }
        return ind;
    }

    public static int retEdMayor(ArrayList<Persona> pers) {
        return pers.get(retIndMayor(pers)).getEdad();
    }

    public static double calcAvgEdad(ArrayList<Persona> pers) {
        int eds = 0;
        for (Persona per : pers) {
            eds = eds+per.getEdad();
        }
        return eds / pers.size();
    }

    public static String retNomMayor(ArrayList<Persona> pers) {
        String name = "";
        try {
            name = pers.get(retIndMayor(pers)).getNombre();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al recuperar los datos de la persona.");
        }
        return name;
    }

    public static String retMayor(ArrayList<Persona> pers) {
        String mayor = "";
        try {
            mayor=pers.get(retIndMayor(pers)).toString();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al recuperar los datos de la persona.");
        }
        return mayor;
    }

    public static String showMayores(ArrayList<Persona> pers) {
        StringBuilder lista = new StringBuilder("");
        for (Persona p : pers) {
            if (p.getEdad() >= 18) {
                lista.append(p.toString()+"\n");
            }
        }
        return lista.toString();
    }

    public static String showMayOMed(ArrayList<Persona> pers) {
        StringBuilder lista = new StringBuilder("");
        for (Persona p : pers) {
            if (p.getEdad() >= calcAvgEdad(pers)) {
                lista.append(p.toString()+"\n");
            }
        }
        return lista.toString();
    }

}
