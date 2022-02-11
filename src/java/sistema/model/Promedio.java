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
public class Promedio {
     private int ID_modalidad;
    private boolean certificado;
    private String Evidencia_certificado;
    private boolean status_tramite;
    private int matricula;

    public Promedio(int ID_modalidad, boolean certificado, String Evidencia_certificado, boolean status_tramite, int matricula) {
        this.ID_modalidad = ID_modalidad;
        this.certificado = certificado;
        this.Evidencia_certificado = Evidencia_certificado;
        this.status_tramite = status_tramite;
        this.matricula = matricula;
    }
    public Promedio() {
    }



    public int getID_modalidad() {
        return ID_modalidad;
    }

    public void setID_modalidad(int ID_modalidad) {
        this.ID_modalidad = ID_modalidad;
    }

    public boolean isCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    public String getEvidencia_certificado() {
        return Evidencia_certificado;
    }

    public void setEvidencia_certificado(String Evidencia_certificado) {
        this.Evidencia_certificado = Evidencia_certificado;
    }

    public boolean isStatus_tramite() {
        return status_tramite;
    }

    public void setStatus_tramite(boolean status_tramite) {
        this.status_tramite = status_tramite;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
}
