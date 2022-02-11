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
public class Pre_registro {
    private int id;
  private String nivel_academico;
  private String carrera;
  private int matricula;
  private String nacimiento;
  private String curp;
  private String nombre;
  private String paterno;
  private String materno;
  private String sexo;
  private String fecha_nacimiento;
  private String correo;
  boolean status_tramite;

    public Pre_registro() {
    }

    public Pre_registro(int id, String nivel_academico, String carrera, int matricula, String nacimiento, String curp, String nombre, String paterno, String materno, String sexo, String fecha_nacimiento, String correo, boolean status_tramite) {
        this.id = id;
        this.nivel_academico = nivel_academico;
        this.carrera = carrera;
        this.matricula = matricula;
        this.nacimiento = nacimiento;
        this.curp = curp;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.status_tramite = status_tramite;
    }

    public boolean isStatus_tramite() {
        return status_tramite;
    }

    public void setStatus_tramite(boolean status_tramite) {
        this.status_tramite = status_tramite;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
  
  
}
