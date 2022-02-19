package server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.grpc.ServerBuilder;
import service.SaveProductService;

public class Server {

  public static void main(String[] args) throws InterruptedException, IOException, SQLException {
    int port = 8082;
    System.out.println("Iniciando o servidor gRPC na porta " + port);
    io.grpc.Server server = ServerBuilder.forPort(port)
        .addService(new SaveProductService())
        .build();
    try {
      server.start();
      System.out.println("Servidor inicializado com sucesso na porta: " + port);
      server.awaitTermination();
    } catch (IOException | InterruptedException e) {
      System.out.println("Servidor não conseguiu subir por " + e.getMessage());
    }
  }

}
