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
    } finally {
      server.awaitTermination();
    }
  }
}
