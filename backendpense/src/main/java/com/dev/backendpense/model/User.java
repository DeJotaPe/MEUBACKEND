package com.dev.backendpense.model;

import java.util.Collection;
import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity

public class User /*implements UserDetails*/{
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "usuario_prova")
    private List<Prova>provas_do_usuario;

    @OneToMany(mappedBy = "usuario_questao")
    private List<Questao> questoes_do_usuario;

    
    //Get e Set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Prova> getProvas_do_usuario() {
        return provas_do_usuario;
    }
    public void setProvas_do_usuario(List<Prova> provas_do_usuario) {
        this.provas_do_usuario = provas_do_usuario;
    }

    public List<Questao> getQuestoes_do_usuario() {
        return questoes_do_usuario;
    }
    public void setQuestoes_do_usuario(List<Questao> questoes_do_usuario) {
        this.questoes_do_usuario = questoes_do_usuario;
    }

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }
    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }
    @Override
    public String getUsername() {
        return nome;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        
        throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
*/

}
