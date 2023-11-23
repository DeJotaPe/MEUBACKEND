package com.dev.backendpense.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonInclude(Include.NON_EMPTY)
public class Questao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String enunciado;

   
    @OneToMany(mappedBy = "questao_em_alternativa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)    
    private List<Alternativa> listaAlternativas=new ArrayList<>();

    @ManyToMany(mappedBy = "questoes_em_prova")
    private List<Prova> provas_em_questao;

    @ManyToOne
    @JoinColumn(name ="usuario_id")
    private User usuario_questao;
    

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

public List<Alternativa> getListaAlternativas() {
        return listaAlternativas;
    }
    
public void setListaAlternativas(List<Alternativa> listaAlternativas) {
        this.listaAlternativas = listaAlternativas;
    }

public void addAlternativa(Alternativa alternativa){
    alternativa.setQuestao_em_alternativa(this);
    if(this.listaAlternativas == null) this.listaAlternativas = new ArrayList<Alternativa>();
    this.listaAlternativas.add(alternativa);
}

public void fillAlternativa(){
    if(this.listaAlternativas != null){
        for(Alternativa alternativa : listaAlternativas){
            alternativa.setQuestao_em_alternativa(this);
        }
    }
}


public List<Prova> getProvas_em_questao() {
        return provas_em_questao;
    }
public void setProvas_em_questao(List<Prova> provas_em_questao) {
        this.provas_em_questao = provas_em_questao;
    }

public User getUsuario_questao() {
        return usuario_questao;
    }
public void setUsuario_questao(User usuario_questao) {
        this.usuario_questao = usuario_questao;
    }
public String toString(){
    String questao = "{enunciado: "+enunciado + ", alternativas: [";
    for(Alternativa alt : this.listaAlternativas){
        questao += "{alternativa: "+ alt.getEnunciado()+"}, ";
    }
    questao += "]}";
    return questao;
}

}
