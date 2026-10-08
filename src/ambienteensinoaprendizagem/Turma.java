
package ambienteensinoaprendizagem;


public class Turma {
    private Long id;
    private String periodo;
    private String turno;
    private Professor professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public Professor getProfessor(){
        return professor;
    }
    
    public void atribuirProfessor(Professor p){
        this.professor = p;
    }
}
