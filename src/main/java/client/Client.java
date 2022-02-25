package client;

import static grpc.ProductGrpc.ProductBlockingStub;
import static grpc.ProductGrpc.newBlockingStub;

import grpc.DeleteProductRequest;
import grpc.DeleteProductResponse;
import grpc.ProductReply;
import grpc.SaveProductReply;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Client class simulation.
 */
public class Client {
  /**
   * Main method to start and execute menu operations.
   */
  public static void main(String[] args) {
    ManagedChannel managedChannel =
        ManagedChannelBuilder.forAddress(args[0], Integer.parseInt(args[1])).usePlaintext().build();
    ProductBlockingStub stub = newBlockingStub(managedChannel);

    int menuOption;
    do {
      System.out.println("*************************************************");
      System.out.println("*          Welcome to CHALLENGE 3               *");
      System.out.println("*************************************************");
      System.out.println("*             1) Insert Product                 *");
      System.out.println("*             2) Import Products                *");
      System.out.println("*             3) Export Products                *");
      System.out.println("*             4) List All Products              *");
      System.out.println("*             5) Find Product By ID             *");
      System.out.println("*             6) Delete Product                 *");
      System.out.println("*             7) Add Product Shopping Cart      *");
      System.out.println("*             8) Finalize Sale                  *");
      System.out.println("*             0) Exit                           *");
      System.out.println("*************************************************");
      Scanner scanner = new Scanner(System.in);
      menuOption = Integer.parseInt(scanner.nextLine());
      switch (menuOption) {
        case 1:
          Scanner scannerToDigitInformationAboutSaveProduct = new Scanner(System.in);
          System.out.println("Digit the Product Name: ");
          String productName = scannerToDigitInformationAboutSaveProduct.nextLine();
          System.out.println("Digit the Product Stock: ");
          int productStock = Integer.parseInt(scannerToDigitInformationAboutSaveProduct.nextLine());
          System.out.println("Digit the Product Price: ");
          float productPrice =
              Float.parseFloat(scannerToDigitInformationAboutSaveProduct.nextLine());
          grpc.SaveProductRequest saveProduct =
              grpc.SaveProductRequest.newBuilder().setName(productName).setStock(productStock)
                  .setPrice(productPrice)
                  .build();
          SaveProductReply saveProductReply = stub.saveProduct(saveProduct);
          System.out.println(saveProductReply.getMessage());
          break;
        case 2:
          grpc.FindProducts findProducts = grpc.FindProducts.newBuilder().build();
          Iterator<ProductReply> productReplyIterator = stub.listProducts(findProducts);
          while (productReplyIterator.hasNext()) {
            ProductReply productReply = productReplyIterator.next();
            System.out.println(
                productReply.getId() + " " + productReply.getName() + " "
                    + productReply.getStock() + " "
                    + productReply.getPrice());
          }
          break;
        case 3:
          Scanner scannerToDigitIdAboutFindProduct = new Scanner(System.in);
          System.out.println("Digit the Product ID: ");
          int productIdFind = Integer.parseInt(scannerToDigitIdAboutFindProduct.nextLine());
          grpc.FindProductById findProductById =
              grpc.FindProductById.newBuilder().setId(productIdFind).build();
          ProductReply productReply = stub.listProductById(findProductById);
          System.out.println(
              productReply.getId() + " " + productReply.getName() + " " + productReply.getStock()
                  + " " + productReply.getPrice());
          break;
        case 4:
          Scanner scannerToDigitIdAboutDeleteProduct = new Scanner(System.in);
          System.out.println("Digit the Product ID: ");
          int productIdDelete = Integer.parseInt(scannerToDigitIdAboutDeleteProduct.nextLine());
          DeleteProductRequest deleteProductRequest =
              DeleteProductRequest.newBuilder().setId(productIdDelete).build();
          DeleteProductResponse deleteProductResponse = stub.deleteProduct(deleteProductRequest);
          System.out.println(deleteProductResponse.getMessage());
          break;
        case 0:
          System.out.println("See You Latter!");
          break;
        default:
          System.out.println("Inform a menu option valid!");
          break;
      }
    } while (menuOption != 0);
  }
}
