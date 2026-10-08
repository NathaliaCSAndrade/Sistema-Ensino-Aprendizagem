
package ambienteensinoaprendizagem;

import java.time.LocalDate;
import statusgerais.StatusMatricula;


public class Matricula {
    private String rgm;
    private LocalDate dataMatricula;
    private StatusMatricula status;
    private Turma turma;
    private Aluno aluno;

    public String getRgm() {
        return rgm;
    }

    public void setRgm(String rgm) {
        this.rgm = rgm;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public StatusMatricula getStatus() {
        return status;
    }

    public void setStatus(StatusMatricula status) {
        this.status = status;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
