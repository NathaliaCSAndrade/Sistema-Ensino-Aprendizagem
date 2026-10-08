
package ambienteensinoaprendizagem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import statusgerais.StatusEntrega;


public class Entrega {
    private String meuTrabalho;
    private StatusEntrega status;
    private Avaliacao avaliacao;
    private Atividade atividade;
    private String emailAluno;
    private LocalDateTime dataEntrega;

    public String getMeuTrabalho() {
        return meuTrabalho;
    }

    public void setMeuTrabalho(String meuTrabalho) {
        this.meuTrabalho = meuTrabalho;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public void setEmailAluno(String emailAluno) {
        this.emailAluno = emailAluno;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
    public void registrar(Entrega e){
        dataEntrega = LocalDateTime.now();
        atividade.entregas.add(e);
    }
}
