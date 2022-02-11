/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.model;

/**
 *
 * @author Valdez
 */
public class restricciones {
    private int semestre;
    private boolean cartaPasante;
    private int promedio;
    private int creditos;
    private boolean practicas;
   private boolean servicio;
    public restricciones() {
    }

    public restricciones(int semestre, boolean cartaPasante, int promedio, int creditos, boolean practicas, boolean servicio) {
        this.semestre = semestre;
        this.cartaPasante = cartaPasante;
        this.promedio = promedio;
        this.creditos = creditos;
        this.practicas = practicas;
        this.servicio = servicio;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean isCartaPasante() {
        return cartaPasante;
    }

    public void setCartaPasante(boolean cartaPasante) {
        this.cartaPasante = cartaPasante;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public boolean isPracticas() {
        return practicas;
    }

    public void setPracticas(boolean practicas) {
        this.practicas = practicas;
    }

    public boolean isServicio() {
        return servicio;
    }

    public void setServicio(boolean servicio) {
        this.servicio = servicio;
    }
    
}
