
package ambienteensinoaprendizagem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import statusgerais.StatusAtividade;
import statusgerais.StatusEntrega;
import statusgerais.StatusMatricula;


public class AmbienteEnsinoAprendizagem {


    public static void main(String[] args) {
        Scanner opcao = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);
        int opc = 9;
        int opt = 9;
        List<Professor> professores = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Matricula> matriculas = new ArrayList<>();
        List<Atividade> atividades = new ArrayList();
        List<Avaliacao> avaliacoes = new ArrayList<>();
        
        while (opc!=0){
            for (Atividade a: atividades){
                if(a.getDataFinal().isBefore(LocalDateTime.now())){
                    a.setStatus(StatusAtividade.ENCERRADA);
                }
            }
            
            System.out.println("===================================================");
            System.out.println("Escolha o numero da opcao desejada:");
            System.out.println("[1] Cadastros");
            System.out.println("[2] Sou professor");
            System.out.println("[3] Sou aluno");
            System.out.println("[0] Sair ");
            System.out.println("===================================================");
            opc = opcao.nextInt();
        
            if (opc==1){
                opt = 9;
                while (opt!=0){
                    System.out.println("===================================================");
                    System.out.println("[1] Cadastrar professor");
                    System.out.println("[2] Cadastrar disciplina");
                    System.out.println("[3] Cadastrar turma");
                    System.out.println("[4] Matricular aluno");
                    System.out.println("[0] Voltar ao menu principal");
                    System.out.println("===================================================");
                    opt = opcao.nextInt();
                    if (opt==1){
                        Professor prof = new Professor();
                        System.out.print("Informe o ID do professor: ");
                        prof.setId(entrada.nextLong());
                        entrada.nextLine();
                        System.out.print("Informe o nome: ");
                        prof.setNome(entrada.nextLine());
                        System.out.print("Informe o CPF: ");
                        prof.setCpf(entrada.nextLine());
                        System.out.print("Informe o Email: ");
                        prof.setEmail(entrada.nextLine());
                        System.out.print("Informe o telefone: ");
                        prof.setTelefone(entrada.nextLine());
                        System.out.print("Informe o registro: ");
                        prof.setRegistro(entrada.nextLine());
                        professores.add(prof);
                    }
                    else if (opt==2){
                        Disciplina disciplina = new Disciplina();
                        System.out.print("Informe o ID da disciplina: ");
                        disciplina.setId(entrada.nextLong());
                        entrada.nextLine();
                        System.out.print("Informe o nome: ");
                        disciplina.setNome(entrada.nextLine());
                        disciplinas.add(disciplina);
                    }
                    else if (opt==3){
                        Turma turma = new Turma();
                        System.out.print("Informe o ID da turma: ");
                        turma.setId(entrada.nextLong());
                        entrada.nextLine();
                        System.out.print("Informe o periodo: ");
                        turma.setPeriodo(entrada.nextLine());
                        System.out.print("Informe o turno: ");
                        turma.setTurno(entrada.nextLine());
                        System.out.print("Informe o nome do professor: ");
                        String nomeProf = entrada.nextLine();
                        boolean profEncontrado = false;
                        for (Professor p: professores){
                            if (p.getNome().equalsIgnoreCase(nomeProf)){
                                profEncontrado = true;
                                turma.atribuirProfessor(p);
                                turmas.add(turma);
                            }
                        }
                        if (profEncontrado==false){
                            System.out.println("ATENCAO! Esse professor nao foi encontrado!");
                        }
                    }
                    else if(opt==4){
                        Aluno aluno = new Aluno();
                        Matricula mat = new Matricula();
                        System.out.print("Informe o ID do aluno: ");
                        aluno.setId(entrada.nextLong());
                        entrada.nextLine();
                        System.out.print("Informe o nome: ");
                        aluno.setNome(entrada.nextLine());
                        System.out.print("Informe o CPF: ");
                        aluno.setCpf(entrada.nextLine());
                        System.out.print("Informe o Email: ");
                        aluno.setEmail(entrada.nextLine());
                        System.out.print("Informe o telefone: ");
                        aluno.setTelefone(entrada.nextLine());
                        System.out.print("Informe o RGM: ");
                        mat.setRgm(entrada.nextLine());
                        System.out.print("Informe o ID da turma: ");
                        Long idTurma = entrada.nextLong();
                        boolean turmaEncontrada = false;
                        for (Turma t: turmas){
                            if (t.getId().equals(idTurma)){
                                turmaEncontrada = true;
                                mat.setTurma(t);
                                mat.setDataMatricula(LocalDate.now());
                                mat.setStatus(StatusMatricula.ATIVA);
                                mat.setAluno(aluno);
                            }
                        }
                        if (turmaEncontrada==false){
                            System.out.println("ATENCAO! Essa turma nao foi encontrada!");
                        }
                        alunos.add(aluno);
                        matriculas.add(mat);
                    }
                }
            }
            else if (opc==2){
                opt = 9;
                while (opt!=0){
                    System.out.println("===================================================");
                    System.out.println("[1] Publicar nova atividade");
                    System.out.println("[2] Avaliar atividade");
                    System.out.println("[0] Voltar ao menu principal");
                    System.out.println("===================================================");
                    opt = opcao.nextInt();
                    if (opt==1){
                        Atividade atividade = new Atividade();
                        System.out.print("Informe o seu Registro: ");
                        String profRegistro = entrada.nextLine();
                        boolean profEncontrado = false;
                        boolean turmaEncontrada = false;
                        for (Professor p: professores){
                            if (p.getRegistro().equals(profRegistro)){
                                profEncontrado = true;
                                System.out.print("Informe o ID da turma: ");
                                Long turmaProf = entrada.nextLong();
                                entrada.nextLine();
                                for (Turma t: turmas){
                                    if (t.getId().equals(turmaProf) && t.getProfessor().getRegistro().equals(profRegistro)){
                                        turmaEncontrada = true;
                                        atividade.setTurma(t);
                                        System.out.println("===================================================");
                                        System.out.println("Seja bem vindo(a)!");
                                        System.out.println("===================================================");
                                        System.out.print("Informe o titulo: ");
                                        atividade.setTitulo(entrada.nextLine());
                                        System.out.print("Descreva a atividade: ");
                                        atividade.setDescricao(entrada.nextLine());
                                        System.out.print("Informe o prazo em numero de dias: ");
                                        int prazo = entrada.nextInt();
                                        atividade.setPrazo(prazo);
                                        System.out.print("Informe o valor: ");
                                        atividade.setValor(entrada.nextDouble());
                                        atividade.setDataPublicacao(LocalDateTime.now());
                                        atividade.setDataFinal(LocalDateTime.now().plusDays(prazo));
                                        atividade.setStatus(StatusAtividade.ABERTA);
                                        atividades.add(atividade);
                                        break;
                                    }
                                }
                                if (turmaEncontrada==false){
                                    System.out.println("ATENCAO! Essa turma nao foi encontrada!");
                                }
                                break;
                            }
                        }
                        if (profEncontrado==false){
                            System.out.println("ATENCAO! Esse professor nao foi encontrado!");
                        }
                    }
                    else if (opt==2){
                        Avaliacao avaliacao = new Avaliacao();
                        System.out.print("Informe o seu Registro: ");
                        String profRegistro = entrada.nextLine();
                        boolean profEncontrado = false;
                        boolean turmaEncontrada = false;
                        boolean emailEncontrado = false;
                        boolean notaValida = false;
                        for (Professor p: professores){
                            if (p.getRegistro().equals(profRegistro)){
                                profEncontrado = true;
                                System.out.print("Informe o ID da turma: ");
                                Long turmaProf = entrada.nextLong();
                                entrada.nextLine();
                                for (Turma t: turmas){
                                    if (t.getId().equals(turmaProf) && t.getProfessor().getRegistro().equals(profRegistro)){
                                        turmaEncontrada = true;
                                        for (Atividade a: atividades){
                                            for (Entrega e: a.getEntregas()){
                                                System.out.println("===================================================");
                                                System.out.println("Entregas: ");
                                                System.out.println(e.getEmailAluno()+ "     " + a.getTitulo());
                                                System.out.println("Digite o email do aluno a ser avaliado: ");
                                                String email = entrada.nextLine();
                                                if (e.getEmailAluno().equalsIgnoreCase(email)){
                                                    emailEncontrado = true;
                                                    System.out.println("Resposta: " + e.getMeuTrabalho());
                                                    System.out.println("===================================================");
                                                    System.out.println("Informe a nota: ");
                                                    double notaProf = entrada.nextDouble();
                                                    if (notaProf<= a.getValor()){
                                                        notaValida = true;
                                                        avaliacao.setNota(notaProf);
                                                        entrada.nextLine();
                                                        System.out.print("Insira um feedback: ");
                                                        avaliacao.setFeedback(entrada.nextLine());
                                                        e.setAvaliacao(avaliacao);
                                                        e.setStatus(StatusEntrega.AVALIADA);
                                                        avaliacoes.add(avaliacao);
                                                        break;
                                                    }
                                                    if (notaValida==false){
                                                        System.out.println("NOTA INVALIDA!");
                                                        System.out.println("Favor digitar uma nota menor ou igual ao valor maximo da atividade.");
                                                    }
                                                }
                                            }
                                            if (emailEncontrado==false){
                                                System.out.println("ATENCAO! Esse email nao existe!");
                                            }
                                        }
                                    }
                                }
                                if (turmaEncontrada==false){
                                    System.out.println("ATENCAO! Essa turma nao foi encontrada!");
                                }
                                break;
                            }
                        }
                        if (profEncontrado==false){
                            System.out.println("ATENCAO! Esse professor nao foi encontrado!");
                        }
                    }
                }
            }
            else if (opc==3){
                opt = 9;
                while (opt!=0){
                    System.out.println("===================================================");
                    System.out.println("[1] Visualizar atividade");
                    System.out.println("[2] Entregar atividade");
                    System.out.println("[3] Visualizar entrega ");
                    System.out.println("[0] Voltar ao menu principal");
                    System.out.println("===================================================");
                    opt = opcao.nextInt();
                    if (opt==1){
                        entrada.nextLine();
                        System.out.print("Informe o seu RGM: ");
                        String rgmAluno = entrada.nextLine();
                        boolean matriculaEncontrada = false;
                        for (Matricula m: matriculas){
                            if (m.getStatus().equals(StatusMatricula.ATIVA) && m.getRgm().equals(rgmAluno)){
                                matriculaEncontrada = true;
                                for (Atividade a: atividades){
                                    if (m.getTurma().equals(a.getTurma())){
                                        System.out.println("===================================================");
                                        System.out.println("Titulo: " + a.getTitulo());
                                        System.out.println("Descricao: " + a.getDescricao());
                                        System.out.println("Data de encerramento: " + a.getDataFinal());
                                        System.out.println("Pontuacao maxima: " + a.getValor());
                                        System.out.println("Status: " + a.getStatus());
                                        System.out.println("===================================================");
                                    }
                                }
                            }
                        }
                        if (matriculaEncontrada==false){
                            System.out.println("ATENCAO! Matricula inexistente ou inativa!");
                        }
                    }
                    else if (opt==2){
                        Entrega entrega = new Entrega();
                        System.out.print("Informe o seu RGM: ");
                        String rgmAluno = entrada.nextLine();
                        boolean matriculaEncontrada = false;
                        boolean tituloEncontrado = false;
                        for (Matricula m: matriculas){
                            if (m.getStatus().equals(StatusMatricula.ATIVA) && m.getRgm().equals(rgmAluno)){
                                matriculaEncontrada = true;
                                for (Atividade a: atividades){
                                    if (m.getTurma().equals(a.getTurma()) && a.getStatus().equals(StatusAtividade.ABERTA)){
                                        System.out.println("Suas atividades ativas: ");
                                        System.out.println("Atividade: " + a.getTitulo());
                                        System.out.println("Digite o titulo da atividade a ser entregue: ");
                                        String tit = entrada.nextLine();
                                        if (a.getTitulo().equalsIgnoreCase(tit)){
                                            tituloEncontrado = true;
                                            System.out.println("===================================================");
                                            System.out.println("Titulo: " + a.getTitulo());
                                            System.out.println("Descricao: " + a.getDescricao());
                                            System.out.println("Data de encerramento: " + a.getDataFinal());
                                            System.out.println("Pontuacao maxima: " + a.getValor());
                                            System.out.println("Status: " + a.getStatus());
                                            System.out.println("===================================================");
                                            System.out.println("Digite suas respostas: ");
                                            entrega.setMeuTrabalho(entrada.nextLine());
                                            entrega.setEmailAluno(m.getAluno().getEmail());
                                            entrega.setAtividade(a);
                                            entrega.setStatus(StatusEntrega.ENTREGUE);
                                            entrega.setDataEntrega(LocalDateTime.now());
                                            entrega.registrar(entrega);
                                        }
                                        if (tituloEncontrado==false){
                                            System.out.println("ATENCAO! Esse titulo nao foi encontrado!");
                                        }
                                    }
                                }
                            }
                        }
                        if (matriculaEncontrada==false){
                            System.out.println("ATENCAO! Matricula inexistente ou inativa!");
                        }
                    }
                    else if(opt==3){
                        System.out.print("Informe o seu RGM: ");
                        String rgmAluno = entrada.nextLine();
                        boolean matriculaEncontrada = false;
                        boolean tituloEncontrado = false;
                        for (Matricula m: matriculas){
                            if (m.getStatus().equals(StatusMatricula.ATIVA) && m.getRgm().equals(rgmAluno)){
                                matriculaEncontrada = true;
                                for (Atividade a: atividades){
                                    for (Entrega e: a.getEntregas()){
                                        if (m.getTurma().equals(a.getTurma())){
                                            System.out.println("===================================================");
                                            System.out.println("Suas entregas: ");
                                            System.out.println("Titulo da atividade: " + a.getTitulo());
                                            System.out.println("Digite o titulo da atividade a ser visualizada: ");
                                            String tit = entrada.nextLine();
                                            if (a.getTitulo().equalsIgnoreCase(tit)){
                                                tituloEncontrado = true;
                                                System.out.println("===================================================");
                                                System.out.println("Titulo da atividade: " + a.getTitulo());
                                                System.out.println("Descricao da atividade: " + a.getDescricao());
                                                System.out.println("Data de entrega: " + a.getDataFinal());
                                                System.out.println("Pontuacao maxima da atividade: " + a.getValor());
                                                System.out.println("Status da atividade: " + a.getStatus());
                                                System.out.println("Status da entrega: " + e.getStatus());
                                                System.out.println("===================================================");
                                                System.out.println("Seu trabalho: " + e.getMeuTrabalho());
                                                if (e.getAvaliacao()!=null){
                                                    System.out.println("Sua pontuacao: " + e.getAvaliacao().getNota());
                                                    System.out.println("Feedback: " + e.getAvaliacao().getFeedback());
                                                }
                                            }
                                            if (tituloEncontrado==false){
                                                System.out.println("ATENCAO! Esse titulo nao foi encontrado!");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (matriculaEncontrada==false){
                            System.out.println("ATENCAO! Matricula inexistente ou inativa!");
                        }
                    }
                }
            }
        }
    }
}

