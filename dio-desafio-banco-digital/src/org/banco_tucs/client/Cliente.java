package org.banco_tucs.client;

public class Cliente {

    private String nome;

    

    public Cliente(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    @Override
    public String toString() {
        return  nome;
    }
    
}
