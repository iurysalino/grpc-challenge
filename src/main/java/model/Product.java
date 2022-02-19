package model;

import java.util.Objects;

public class Product {

  private long id;
  private String nome;
  private int stock;
  private double price;

  public Product() {
  }

  public Product(long id) {
    this.id = id;
  }

  public Product(long id, String nome, int stock, double price) {
    this.id = id;
    this.nome = nome;
    this.stock = stock;
    this.price = price;
  }

  public Product(String nome, int stock, double price) {
    this.nome = nome;
    this.stock = stock;
    this.price = price;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return id == product.id && stock == product.stock && Double.compare(product.price, price) == 0 &&
        Objects.equals(nome, product.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, stock, price);
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", stock=" + stock +
        ", price=" + price +
        '}';
  }
}
