package service;

import grpc.CreateShoppingCartReply;
import grpc.CreateShoppingCartRequest;
import grpc.DeleteProductRequest;
import grpc.DeleteProductResponse;
import grpc.FindProductById;
import grpc.FindProducts;
import grpc.InsertProductInTheShoppingCartReply;
import grpc.InsertProductInTheShoppingCartRequest;
import grpc.ProductGrpc;
import grpc.SaveProductReply;
import grpc.SaveProductRequest;
import io.grpc.stub.StreamObserver;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * This Class is responsible to execute database actions.
 */
public class ProductService extends ProductGrpc.ProductImplBase {

  private Connection newConnection() throws SQLException, IOException {
    FileInputStream fileInputStream =
        new FileInputStream("src/main/resources/connection.properties");
    Properties properties = new Properties();
    properties.load(fileInputStream);
    return DriverManager.getConnection(properties.getProperty("URL"),
        properties.getProperty("USER"), properties.getProperty("PASSWORD"));
  }

  @Override
  public void saveProduct(SaveProductRequest request,
                          StreamObserver<SaveProductReply> responseObserver) {
    SaveProductReply.Builder response = SaveProductReply.newBuilder();
    try (PreparedStatement preparedStatement = newConnection().prepareStatement(
        "INSERT INTO products (name, stock, price) VALUES (?, ?, ?)")) {
      preparedStatement.setString(1, request.getName());
      preparedStatement.setInt(2, (int) request.getStock());
      preparedStatement.setDouble(3, request.getPrice());
      preparedStatement.execute();
      response.setMessage("The Product " + request.getName() + " was registered with success");
      responseObserver.onNext(response.build());
    } catch (SQLException | IOException e) {
      responseObserver.onError(e);
    }
    responseObserver.onCompleted();
  }

  @Override
  public void listProducts(FindProducts request,
                           StreamObserver<grpc.ProductReply> responseObserver) {
    grpc.ProductReply.Builder response = grpc.ProductReply.newBuilder();
    try (PreparedStatement preparedStatement = newConnection().prepareStatement(
        "SELECT * FROM products")) {
      preparedStatement.execute();
      try (ResultSet resultSet = preparedStatement.getResultSet()) {
        while (resultSet.next()) {
          response.setId(resultSet.getInt("id"));
          response.setName(resultSet.getString("name"));
          response.setStock(resultSet.getInt("stock"));
          response.setPrice(resultSet.getFloat("price"));
          responseObserver.onNext(response.build());
        }
      }
    } catch (SQLException | IOException e) {
      responseObserver.onError(e);
    }
    responseObserver.onCompleted();
  }

  @Override
  public void listProductById(FindProductById request,
                              StreamObserver<grpc.ProductReply> responseObserver) {
    grpc.ProductReply.Builder response = grpc.ProductReply.newBuilder();
    try (PreparedStatement preparedStatement = newConnection().prepareStatement(
        "SELECT * FROM products WHERE id = ?")) {
      preparedStatement.setLong(1, request.getId());
      preparedStatement.execute();
      try (ResultSet resultSet = preparedStatement.getResultSet()) {
        while (resultSet.next()) {
          response.setId(resultSet.getInt("id"));
          response.setName(resultSet.getString("name"));
          response.setStock(resultSet.getInt("stock"));
          response.setPrice(resultSet.getFloat("price"));
          responseObserver.onNext(response.build());
        }
      }
    } catch (SQLException | IOException e) {
      responseObserver.onError(e);
    }
    responseObserver.onCompleted();
  }

  @Override
  public void deleteProduct(DeleteProductRequest request,
                            StreamObserver<DeleteProductResponse> responseObserver) {
    DeleteProductResponse.Builder response = DeleteProductResponse.newBuilder();
    try (PreparedStatement preparedStatement = newConnection().prepareStatement(
        "DELETE FROM products WHERE id = ?")) {
      preparedStatement.setLong(1, request.getId());
      preparedStatement.execute();
      response.setMessage("The Product was deleted with success");
    } catch (SQLException | IOException e) {
      responseObserver.onError(e);
    }
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

  @Override
  public void createShoppingCart(CreateShoppingCartRequest request,
                                 StreamObserver<CreateShoppingCartReply> responseObserver) {
    CreateShoppingCartReply.Builder response = CreateShoppingCartReply.newBuilder();
    try (PreparedStatement preparedStatement = newConnection().prepareStatement(
        "INSERT INTO shopping_cart (id_client) VALUES (?)")) {
      preparedStatement.setInt(1, request.getId());
      preparedStatement.execute();
      response.setMessage("The Shopping Cart " + request.getId() + " was registered with success");
      responseObserver.onNext(response.build());
    } catch (SQLException | IOException e) {
      responseObserver.onError(e);
    }
    responseObserver.onCompleted();
  }

  @Override
  public void insertProductInTheShoppingCart(InsertProductInTheShoppingCartRequest request,
                                             StreamObserver<InsertProductInTheShoppingCartReply>
                                                 responseObserver) {
    InsertProductInTheShoppingCartReply.Builder response =
        InsertProductInTheShoppingCartReply.newBuilder();
    try (PreparedStatement preparedStatement = newConnection().prepareStatement(
        "INSERT INTO products_shopping_cart (id_shopping_cart, id_product, quantity) "
            + "VALUES (?, ?, ?)")) {
      preparedStatement.setInt(1, request.getIdShoppingCart());
      preparedStatement.setInt(2, request.getIdProduct());
      preparedStatement.setInt(3, request.getQuantity());
      preparedStatement.execute();
      response.setMessage(request.getQuantity() + " new products added in you shopping cart");
      responseObserver.onNext(response.build());
    } catch (SQLException | IOException e) {
      responseObserver.onError(e);
    }
    responseObserver.onCompleted();
  }
}
