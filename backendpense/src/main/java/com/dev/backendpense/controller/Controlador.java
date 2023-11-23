package com.dev.backendpense.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backendpense.model.Alternativa;
import com.dev.backendpense.model.Questao;
import com.dev.backendpense.model.User;
import com.dev.backendpense.service.Servico;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class Controlador {

     @Autowired
   private Servico servico;

  //metodoBuscar================================================================

  @GetMapping("/listarUsuarios")
  public List<User>listarUsuarios(){
        return servico.listarUsuarios();
  }
    
    @GetMapping("/listarquestoes")
        public List<Questao> listarQuestoes(){
            List<Questao> questoes = servico.listarQuestoes();
            for(Questao questao : questoes){
                System.out.println(questao.toString());
            }
            return questoes;
        }
  @GetMapping("/listarAlternativas")
  public List<Alternativa> listaAlternativas(){
        return servico.listarAlternativas();
    }

    /*@GetMapping("/questoes")
    public ResponseEntity<List<Questao>> listarQuestoes() {
        List<Questao> questoes = (List<Questao>) repositorioQuestoes.findAll();
        return ResponseEntity.ok(questoes);
    }
*/

  //metodoCadastrar=============================================================
   
  @PostMapping("/cadastrarUsuario")
   public User cadastrarUsuario(@RequestBody User user){
       System.out.println(user);
       return servico.cadastrarUsuario(user);   
   }

   @PostMapping("/adicionarQuestao")
   public Questao adicionarQuestao(@RequestBody Questao questao){
     System.out.println(questao);
     return servico.adicionarQuestao(questao);
   }

   @PostMapping("/adicionarAlternativa")
   public Alternativa adicionarAlternativa(@RequestBody Alternativa alternativa){
      System.out.println(alternativa);
      return servico.adicionarAlternativa(alternativa);
   }
  

  //metodoAlterar================================================================
  @PutMapping("/alterarUsuario")
    public User alterarUsuario(@RequestBody User user){
            return servico.alterarUsuario(user);
    }

    @PutMapping("/alterarQuestao")
    public Questao alterarQuestao(@RequestBody Questao questao){
        return servico.alterarQuestao(questao);
    }

    @PutMapping("/alterarAlternativa")
    public Alternativa alterarAlternativa(@RequestBody Alternativa alternativa){
      return servico.alterarAlternativa(alternativa);
    }
  

  //metodoDeletar================================================================

   @DeleteMapping("/deletarUsuario/{id}")
  public ResponseEntity<Void> deletarUsuario(@PathVariable("id")int id){
      servico.deletarUsuario(id);
      return ResponseEntity.ok().build();
  }

  @DeleteMapping("/deletarQuestao/{id}")
  public ResponseEntity<Void> deletarQuestao(@PathVariable("id")int id){
    servico.deletarQuestao(id);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/deletarAlternativa/{id}")
  public ResponseEntity<Void> deletarAlternativa(@PathVariable("id")int id){
    servico.deletarAlternativa(id);
    return ResponseEntity.ok().build();
  }
 
  
}
