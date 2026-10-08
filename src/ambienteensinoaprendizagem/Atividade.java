
package ambienteensinoaprendizagem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import statusgerais.StatusAtividade;


public class Atividade {
    private String titulo;
    private String descricao;
    private LocalDateTime dataPublicacao;
    private int prazo;
    private LocalDateTime dataFinal;
    private double valor;
    private StatusAtividade status;
    private Turma turma;
    protected List<Entrega> entregas = new ArrayList<>();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public StatusAtividade getStatus() {
        return status;
    }

    public void setStatus(StatusAtividade status) {
        this.status = status;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public List<Entrega> getEntregas(){
        return entregas;
    }
    
    public void encerrar(){
        status = StatusAtividade.ENCERRADA;
    }
}
