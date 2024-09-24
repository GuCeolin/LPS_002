package com.example.LABS2;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rg;
    private String cpf;
    private String nome;
    private String endereco;
    private String profissao;
    private Empregador empregador;
    private Double renda;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empregador> empregadores;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Veiculo> veiculos; // lista de veículos associados ao cliente

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Empregador getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Empregador empregador) {
        this.empregador = empregador;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public List<Empregador> getEmpregadores() {
        return empregadores;
    }

    public Empregador getEntidadeEmpregadora() {
        return empregador;
    }

    public void setEntidadeEmpregadora(Empregador entidadeEmpregadora) {
        this.empregador = entidadeEmpregadora;
    }

    // Getter e Setter para 'rendimento' (alias para 'renda')
    public Double getRendimento() {
        return renda;
    }

    public void setRendimento(Double rendimento) {
        this.renda = rendimento;
    }

    public void setEmpregadores(List<Empregador> empregadores) {
        if (empregadores.size() > 3) {
            throw new IllegalArgumentException("Um cliente pode ter no máximo 3 empregadores.");
        }
        this.empregadores = empregadores;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public boolean isPresent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
    
