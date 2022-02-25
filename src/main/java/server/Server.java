package server;

import io.grpc.ServerBuilder;
import java.io.IOException;
import service.ProductService;

/**
 * Class to initialize the Server.
 */
public class Server {
  /**
   * Main method of the Class to initialize the Server.
   */
  public static void main(String[] args) throws InterruptedException, IOException {
    int port = Integer.parseInt(args[0]);
    io.grpc.Server server = ServerBuilder.forPort(port).addService(new ProductService()).build();
    try {
      server.start();
    } finally {
      server.awaitTermination();
    }
  }
}
