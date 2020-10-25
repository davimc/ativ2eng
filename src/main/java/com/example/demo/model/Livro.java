package com.example.demo.model;


import com.example.demo.miscs.interfaces.IOperacao;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String autor, titulo;
    private List<IOperacao> historico;


    public Livro(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
        historico = new ArrayList<>();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<IOperacao> getHistorico() {
        return historico;
    }

    public void setHistorico(List<IOperacao> historico) {
        this.historico = historico;
    }

    public void registra(IOperacao operacao, Usuario usuario)throws IllegalStateException{
        if (historico.isEmpty()||historico.get(historico.size()).disponivelPara(usuario, this))
            historico.add(operacao);
        throw new IllegalStateException("No momento este livro não está disponível");
    }

}
