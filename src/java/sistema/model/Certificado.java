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
public class Certificado {
    private int matricula;
    private boolean fotos;
    private String prueba_fotos;
    private boolean recibo_pago;
    private String prueba_recibopago;
    private boolean constancia_biblioteca;
    private String constancia_bibliotecaPrueba;
    private boolean constancia_noAdeudo;
    private String prueba_constanciaNoadeudo;
    private boolean acta_nacimiento;
    private String prueba_Actanacimiento;
     private String Status_tramite;

    public Certificado() {
    }

    public Certificado(int matricula, boolean fotos, String prueba_fotos, boolean recibo_pago, String prueba_recibopago, boolean constancia_biblioteca, String constancia_bibliotecaPrueba, boolean constancia_noAdeudo, String prueba_constanciaNoadeudo, boolean acta_nacimiento, String prueba_Actanacimiento, String Status_tramite) {
        this.matricula = matricula;
        this.fotos = fotos;
        this.prueba_fotos = prueba_fotos;
        this.recibo_pago = recibo_pago;
        this.prueba_recibopago = prueba_recibopago;
        this.constancia_biblioteca = constancia_biblioteca;
        this.constancia_bibliotecaPrueba = constancia_bibliotecaPrueba;
        this.constancia_noAdeudo = constancia_noAdeudo;
        this.prueba_constanciaNoadeudo = prueba_constanciaNoadeudo;
        this.acta_nacimiento = acta_nacimiento;
        this.prueba_Actanacimiento = prueba_Actanacimiento;
        this.Status_tramite = Status_tramite;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean isFotos() {
        return fotos;
    }

    public void setFotos(boolean fotos) {
        this.fotos = fotos;
    }

    public String getPrueba_fotos() {
        return prueba_fotos;
    }

    public void setPrueba_fotos(String prueba_fotos) {
        this.prueba_fotos = prueba_fotos;
    }

    public boolean isRecibo_pago() {
        return recibo_pago;
    }

    public void setRecibo_pago(boolean recibo_pago) {
        this.recibo_pago = recibo_pago;
    }

    public String getPrueba_recibopago() {
        return prueba_recibopago;
    }

    public void setPrueba_recibopago(String prueba_recibopago) {
        this.prueba_recibopago = prueba_recibopago;
    }

    public boolean isConstancia_biblioteca() {
        return constancia_biblioteca;
    }

    public void setConstancia_biblioteca(boolean constancia_biblioteca) {
        this.constancia_biblioteca = constancia_biblioteca;
    }

    public String getConstancia_bibliotecaPrueba() {
        return constancia_bibliotecaPrueba;
    }

    public void setConstancia_bibliotecaPrueba(String constancia_bibliotecaPrueba) {
        this.constancia_bibliotecaPrueba = constancia_bibliotecaPrueba;
    }

    public boolean isConstancia_noAdeudo() {
        return constancia_noAdeudo;
    }

    public void setConstancia_noAdeudo(boolean constancia_noAdeudo) {
        this.constancia_noAdeudo = constancia_noAdeudo;
    }

    public String getPrueba_constanciaNoadeudo() {
        return prueba_constanciaNoadeudo;
    }

    public void setPrueba_constanciaNoadeudo(String prueba_constanciaNoadeudo) {
        this.prueba_constanciaNoadeudo = prueba_constanciaNoadeudo;
    }

    public boolean isActa_nacimiento() {
        return acta_nacimiento;
    }

    public void setActa_nacimiento(boolean acta_nacimiento) {
        this.acta_nacimiento = acta_nacimiento;
    }

    public String getPrueba_Actanacimiento() {
        return prueba_Actanacimiento;
    }

    public void setPrueba_Actanacimiento(String prueba_Actanacimiento) {
        this.prueba_Actanacimiento = prueba_Actanacimiento;
    }

    public String getStatus_tramite() {
        return Status_tramite;
    }

    public void setStatus_tramite(String Status_tramite) {
        this.Status_tramite = Status_tramite;
    }
     
     
}
