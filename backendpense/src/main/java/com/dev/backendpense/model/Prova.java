package com.dev.backendpense.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Prova {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinTable(name ="tabeladejuncao", joinColumns = @JoinColumn(name ="provaFk"), inverseJoinColumns=@JoinColumn(name = "questaoFk"))
    private List<Questao>questoes_em_prova;

    @ManyToOne
    @JoinColumn(name ="usuarioProva_id")
    private User usuario_prova;

    //-------------------------------------Get e Set------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Questao> getQuestoes_em_prova() {
        return questoes_em_prova;
    }

    public void setQuestoes_em_prova(List<Questao> questoes_em_prova) {
        this.questoes_em_prova = questoes_em_prova;
    }

    public User getUsuario_prova() {
        return usuario_prova;
    }

    public void setUsuario_prova(User usuario_prova) {
        this.usuario_prova = usuario_prova;
    }
}
