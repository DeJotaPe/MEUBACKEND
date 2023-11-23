package com.dev.backendpense.service;

//import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dev.backendpense.model.Alternativa;
import com.dev.backendpense.model.Questao;
import com.dev.backendpense.model.User;
import com.dev.backendpense.repository.RepositorioAlternativas;
import com.dev.backendpense.repository.RepositorioQuestoes;
import com.dev.backendpense.repository.RepositorioUsers;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@Service
public class Servico {
    @Autowired
    private RepositorioUsers repositorioUsers;

    @Autowired
    private RepositorioQuestoes repositorioQuestoes;

    @Autowired
    private RepositorioAlternativas repositorioAlternativas;

    //buscar=============================================================
     public List<User>listarUsuarios(){
        return (List<User>) repositorioUsers.findAll();
     }
    
    public List<Questao>listarQuestoes(){
        return (List<Questao>) repositorioQuestoes.findAll();
        
    }


    
     public List<Alternativa>listarAlternativas(){
        return (List<Alternativa>) repositorioAlternativas.findAll();
    }

      /*public String listarQuestoes() throws JsonProcessingException {
    List<Questao> questoes = (List<Questao>) repositorioQuestoes.findAll();

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonQuestoes = objectMapper.writeValueAsString(questoes);

    return jsonQuestoes;
  }
*/

    //buscar=============================================================

    //cadastro===========================================================
        public User cadastrarUsuario(User user){
            User usernovo = repositorioUsers.save(user);
            return usernovo;
            
        }

        public Questao adicionarQuestao(Questao questao){
            questao.fillAlternativa();
            Questao questaonova = repositorioQuestoes.save(questao);
            return questaonova;
        }

        public Alternativa adicionarAlternativa(Alternativa alternativa){
            Alternativa alternativanova = repositorioAlternativas.save(alternativa);
            return alternativanova;
        }
    //cadastro===========================================================

    //Alterar===========================================================
    public User alterarUsuario(User user){
        return repositorioUsers.save(user);
        
    }

    public Questao alterarQuestao(Questao questao){
        return repositorioQuestoes.save(questao);
    }

    public Alternativa alterarAlternativa(Alternativa alternativas){
        return repositorioAlternativas.save(alternativas);
    }
    //Alterar===========================================================
   
    //excluir===========================================================
    public void deletarUsuario(int id){
        User user = repositorioUsers.findById(id).get();
        repositorioUsers.delete(user);
     }
 
     public void deletarQuestao(int id){
         Questao questao = repositorioQuestoes.findById(id).get();
         repositorioQuestoes.delete(questao);
     }
 
     public void deletarAlternativa(int id){
         Alternativa alternativa = repositorioAlternativas.findById(id).get();
         repositorioAlternativas.delete(alternativa);
     }
    //excluir===========================================================


}
