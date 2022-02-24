package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import grpc.DeletProductRequest;
import grpc.DeletProductResponse;
import grpc.FindProductById;
import grpc.FindProducts;
import grpc.ProductGrpc;
import grpc.ProductList;
import grpc.SaveProductReply;
import grpc.SaveProductRequest;
import io.grpc.stub.StreamObserver;
import model.Product;

public class ProductService extends ProductGrpc.ProductImplBase {

  private Connection newConnection() throws SQLException, IOException {
    FileInputStream fileInputStream = new FileInputStream("connection.properties");
    Properties properties = new Properties();
    properties.load(fileInputStream);
    return DriverManager.getConnection(properties.getProperty("URL"),
        properties.getProperty("USER"),
        properties.getProperty("PASSWORD"));
  }

  @Override
  public void saveProduct(SaveProductRequest request, StreamObserver<SaveProductReply> responseObserver) {
    SaveProductReply.Builder response = SaveProductReply.newBuilder();
    String caller2 = request.getName();
    int caller3 = (int) request.getStock();
    double caller4 = request.getPrice();

    try (PreparedStatement preparedStatement = newConnection().prepareStatement(
        "INSERT INTO products (name, stock, price) VALUES (?, ?, ?)")) {
      preparedStatement.setString(1, caller2);
      preparedStatement.setInt(2, caller3);
      preparedStatement.setDouble(3, caller4);
      preparedStatement.execute();
      response.setMessage("Sucess");
    } catch (Exception e) {
      response.setMessage("Fail");
    }
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

  @Override
  public void listProducts(FindProducts request, StreamObserver<ProductList> responseObserver)
      throws SQLException, IOException {
    ProductList.Builder response = ProductList.newBuilder();
    Product product = new Product();
    try (PreparedStatement preparedStatement = newConnection().prepareStatement("SELECT * FROM products")) {
      preparedStatement.execute();
      ResultSet resultSet = preparedStatement.getResultSet();
      while (resultSet.next()) {
        product.setId(resultSet.getInt("id"));
        product.setNome(resultSet.getString("name"));
        product.setStock(resultSet.getInt("stock"));
        product.setPrice(resultSet.getDouble("price"));
        System.out.println(product.getId() + " : " + product.getNome());
      }
    }
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

  @Override
  public void listProductById(FindProductById request, StreamObserver<ProductList> responseObserver)
      throws SQLException, IOException {
    ProductList.Builder response = ProductList.newBuilder();
    int caller = request.getId();
    Product product = new Product();
    try (PreparedStatement preparedStatement = newConnection().prepareStatement("SELECT * FROM products WHERE id = ?")) {
      preparedStatement.setLong(1, caller);
      preparedStatement.execute();
      ResultSet resultSet = preparedStatement.getResultSet();
      while (resultSet.next()) {
        product.setId(resultSet.getInt("id"));
        product.setNome(resultSet.getString("name"));
        product.setStock(resultSet.getInt("stock"));
        product.setPrice(resultSet.getDouble("price"));
      }
    }
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

  @Override
  public void deletProduct(DeletProductRequest request, StreamObserver<DeletProductResponse> responseObserver)
      throws IOException, SQLException {
    DeletProductResponse.Builder response = DeletProductResponse.newBuilder();
    int caller = request.getId();
    try (PreparedStatement preparedStatement = newConnection().prepareStatement("DELETE FROM products WHERE id = ?")) {
      preparedStatement.setLong(1, caller);
      preparedStatement.execute();
      response.setMessage("Success");
    }
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }
}
