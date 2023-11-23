package com.dev.backendpense.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Alternativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String enunciado;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="questao_em_alternativa_id")
    private Questao questao_em_alternativa;

    //-------------------------------------Get e Set------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getEnunciado() {
        return enunciado;
    }
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Questao getQuestao_em_alternativa() {
        return questao_em_alternativa;
    }
    public void setQuestao_em_alternativa(Questao questao_em_alternativa) {
        this.questao_em_alternativa = questao_em_alternativa;
    }
    
}
