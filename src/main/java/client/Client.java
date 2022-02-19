package client;

import grpc.DeletProductRequest;
import grpc.FindProductById;
import grpc.FindProducts;
import grpc.ProductGrpc;
import grpc.SaveProductRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

  public static void main(String[] args) {
    ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("127.0.0.1", 8082).usePlaintext().build();
    ProductGrpc.ProductBlockingStub stub = ProductGrpc.newBlockingStub(managedChannel);

    SaveProductRequest saveProduct = grpc.SaveProductRequest.newBuilder()
        .setId(1)
        .setName("Coca Cola")
        .setStock(250)
        .setPrice(12f)
        .build();
    stub.saveProduct(saveProduct);

    FindProductById findProductById = grpc.FindProductById
        .newBuilder()
        .setId(1)
        .build();
    stub.listProductById(findProductById);

    FindProducts findProducts = grpc.FindProducts.newBuilder().build();
    stub.listProducts(findProducts);

    DeletProductRequest deletProductRequest = grpc.DeletProductRequest
        .newBuilder()
        .setId(4)
        .build();
    stub.deletProduct(deletProductRequest);
  }
}
