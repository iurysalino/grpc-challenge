package model;

import java.util.Objects;

/**
 * Model Class to Products.
 */
public class Product {

  private long id;
  private String name;
  private int stock;
  private double price;

  public Product() {
  }

  public Product(long id) {
    this.id = id;
  }

  /**
   * <p> Constructor with full params. </p>
   *
   * @param id identification the product.
   * @param name  name of product.
   * @param stock quantity in stock
   * @param price price of product
   */
  public Product(long id, String name, int stock, double price) {
    this.id = id;
    this.name = name;
    this.stock = stock;
    this.price = price;
  }

  /**
   * <p>Constructor not use id.</p>
   *
   * @param name  name of product.
   * @param stock quantity in stock
   * @param price price of product
   */
  public Product(String name, int stock, double price) {
    this.name = name;
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
    return name;
  }

  public void setNome(String name) {
    this.name = name;
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
    return id == product.id && stock == product.stock
        && Double.compare(product.price, price) == 0
        && Objects.equals(name, product.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, stock, price);
  }

  @Override
  public String toString() {
    return "Product{" + "id=" + id + ", name='" + name + '\'' + ", stock=" + stock + ", price="
        + price + '}';
  }
}
