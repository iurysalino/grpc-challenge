package server;

import java.io.IOException;

import io.grpc.ServerBuilder;
import service.ProductService;

public class Server {
  public static void main(String[] args) throws InterruptedException, IOException {
    int port =  Integer.parseInt(args[0]);
    io.grpc.Server server = ServerBuilder.forPort(port).addService(new ProductService()).build();
    try {
      server.start();
      System.out.println("Servidor inicializado com sucesso na porta: " + port);
      server.awaitTermination();
    } catch (IOException | InterruptedException e) {
      System.out.println("Servidor não conseguiu subir por " + e.getMessage());
    }
  }

}
