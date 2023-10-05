
package Entidades;

import java.time.LocalDate;


public class Dieta {
  private int idDieta;
    private Paciente paciente;
    private String nombre;
    LocalDate fechaInicio, fechaFinal;
    private double pesoInicial, pesoBuscado, pesoActual;
    private boolean estado;
    
    public Dieta() {
    }

    public Dieta(Paciente paciente, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, double pesoInicial, double pesoBuscado, double pesoActual, boolean estado) {
        this.paciente = paciente;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoBuscado = pesoBuscado;
        this.pesoActual = pesoActual;
        this.estado = estado;
    }

    public Dieta(int idDieta, Paciente paciente, String nombre, LocalDate fechaInicio, LocalDate fechaFinal, double pesoInicial, double pesoBuscado, double pesoActual, boolean estado) {
        this.idDieta = idDieta;
        this.paciente = paciente;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.pesoInicial = pesoInicial;
        this.pesoBuscado = pesoBuscado;
        this.pesoActual = pesoActual;
        this.estado = estado;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(double pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Dieta{" + "paciente=" + paciente + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", pesoInicial=" + pesoInicial + ", pesoBuscado=" + pesoBuscado + ", pesoActual=" + pesoActual + ", estado=" + estado + '}';
    }

}
