package com.example.Enderecos;

public class Enderecos {
    
    private int id;
    private String endereco;
    private int id_pessoas;

    public Enderecos(int id, String endereco, int id_pessoas) {
        super();
        this.id = id;
        this.endereco=endereco;
        this.id_pessoas=id_pessoas;
    }

    public Enderecos(String endereco, int id_pessoas) {
        this.endereco=endereco;
        this.id_pessoas=id_pessoas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco=endereco;
    }

    public int getIdPessoas(){
        return id_pessoas;
    }

    public void setIdPessoas(int id_pessoas){
        this.id_pessoas=id_pessoas;
    }
}
