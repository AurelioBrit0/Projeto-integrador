/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 200, unique = true, nullable = false)
    private String nome;
    @Column(length = 200, unique = false, nullable = false)
    private double preco;
    @Column(length = 200, unique = false, nullable = false)
    private double estoque;
    @ManyToOne
    private Marca marca;
    @ManyToOne
    private GrupoProduto grupoproduto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public GrupoProduto getGrupoproduto() {
        return grupoproduto;
    }

    public void setGrupoproduto(GrupoProduto grupoproduto) {
        this.grupoproduto = grupoproduto;
    }

   

  

    
}
