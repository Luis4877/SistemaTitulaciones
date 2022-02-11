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

public class Diplomado {
    private int matricula;
 private int certificado;
 private int id_Modalidad;
 private String evidencia_certificado;
 private int BoletaOficial;
 private String EvidenciaBoletaOficial;
 private String status;
 private String observaciones;
 private int fotos;
 private String evidencia_fotos;
 private String modalidad;
 private int Status_tramite;

    public Diplomado(int matricula, int certificado, int id_Modalidad, String evidencia_certificado, int BoletaOficial, String EvidenciaBoletaOficial, String status, String observaciones, int fotos, String evidencia_fotos, String modalidad, int Status_tramite) {
        this.matricula = matricula;
        this.certificado = certificado;
        this.id_Modalidad = id_Modalidad;
        this.evidencia_certificado = evidencia_certificado;
        this.BoletaOficial = BoletaOficial;
        this.EvidenciaBoletaOficial = EvidenciaBoletaOficial;
        this.status = status;
        this.observaciones = observaciones;
        this.fotos = fotos;
        this.evidencia_fotos = evidencia_fotos;
        this.modalidad = modalidad;
        this.Status_tramite = Status_tramite;
    }



    

    public Diplomado() {
    }

    public int getCertificado() {
        return certificado;
    }

    public void setCertificado(int certificado) {
        this.certificado = certificado;
    }

    public String getEvidencia_certificado() {
        return evidencia_certificado;
    }

    public void setEvidencia_certificado(String evidencia_certificado) {
        this.evidencia_certificado = evidencia_certificado;
    }

    public int getBoletaOficial() {
        return BoletaOficial;
    }

    public void setBoletaOficial(int BoletaOficial) {
        this.BoletaOficial = BoletaOficial;
    }

    public String getEvidenciaBoletaOficial() {
        return EvidenciaBoletaOficial;
    }

    public void setEvidenciaBoletaOficial(String EvidenciaBoletaOficial) {
        this.EvidenciaBoletaOficial = EvidenciaBoletaOficial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getFotos() {
        return fotos;
    }

    public void setFotos(int fotos) {
        this.fotos = fotos;
    }

    public String getEvidencia_fotos() {
        return evidencia_fotos;
    }

    public void setEvidencia_fotos(String evidencia_fotos) {
        this.evidencia_fotos = evidencia_fotos;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getStatus_tramite() {
        return Status_tramite;
    }

    public void setStatus_tramite(int Status_tramite) {
        this.Status_tramite = Status_tramite;
    }

    public int getId_Modalidad() {
        return id_Modalidad;
    }

    public void setId_Modalidad(int id_Modalidad) {
        this.id_Modalidad = id_Modalidad;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
