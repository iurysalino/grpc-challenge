package client;

import static grpc.ProductGrpc.ProductBlockingStub;
import static grpc.ProductGrpc.newBlockingStub;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import grpc.CreateShoppingCartReply;
import grpc.CreateShoppingCartRequest;
import grpc.DeleteProductRequest;
import grpc.DeleteProductResponse;
import grpc.ExportFileReply;
import grpc.ExportFileRequest;
import grpc.FinalizeSaleReply;
import grpc.FinalizeSaleRequest;
import grpc.FindProducts;
import grpc.InsertProductInTheShoppingCartReply;
import grpc.InsertProductInTheShoppingCartRequest;
import grpc.ProductReply;
import grpc.SaveProductReply;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import model.Product;

/**
 * Client class simulation.
 */
public class Client {
  /**
   * Main method to start and execute menu operations.
   */
  public static void main(String[] args) throws IOException {
    ManagedChannel managedChannel =
        ManagedChannelBuilder.forAddress(args[0], Integer.parseInt(args[1])).usePlaintext().build();
    ProductBlockingStub stub = newBlockingStub(managedChannel);
    Properties properties = new Properties();
    FileInputStream fileInputStream;
    try {
      fileInputStream = new FileInputStream("src/main/resources/connection.properties");
      properties.load(fileInputStream);
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

    int menuOption;
    do {
      System.out.println("*************************************************");
      System.out.println("*          Welcome to CHALLENGE 3               *");
      System.out.println("*************************************************");
      System.out.println("*             1) Insert Product                 *");
      System.out.println("*             2) List All Products              *");
      System.out.println("*             3) Find Product By ID             *");
      System.out.println("*             4) Delete Product                 *");
      System.out.println("*             5) Create Shopping Cart           *");
      System.out.println("*             6) Add Product Shopping Cart      *");
      System.out.println("*             7) Export Products                *");
      System.out.println("*             8) Import Products                *");
      System.out.println("*             9) Finalize Sale                  *");
      System.out.println("*             0) Exit                           *");
      System.out.println("*************************************************");
      Scanner scanner = new Scanner(System.in);
      menuOption = Integer.parseInt(scanner.nextLine());
      switch (menuOption) {
        case 0:
          System.out.println("See You Latter!");
          break;
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
                  .setPrice(productPrice).build();
          SaveProductReply saveProductReply = stub.saveProduct(saveProduct);
          System.out.println(saveProductReply.getMessage());
          break;
        case 2:
          FindProducts findProducts = FindProducts.newBuilder().build();
          Iterator<ProductReply> productReplyIterator = stub.listProducts(findProducts);
          while (productReplyIterator.hasNext()) {
            ProductReply productReply = productReplyIterator.next();
            System.out.println(productReply.getId() + " " + productReply.getName() + " "
                + productReply.getStock() + " " + productReply.getPrice());
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
        case 5:
          Scanner scannerToDigitIdClientToCreateShoppingCart = new Scanner(System.in);
          System.out.println("Digit the Client ID: ");
          int idClient = Integer.parseInt(scannerToDigitIdClientToCreateShoppingCart.nextLine());
          CreateShoppingCartRequest createShoppingCartRequest =
              CreateShoppingCartRequest.newBuilder().setId(idClient).build();
          CreateShoppingCartReply createShoppingCartReply =
              stub.createShoppingCart(createShoppingCartRequest);
          System.out.println(createShoppingCartReply.getMessage());
          break;
        case 6:
          Scanner scannerToAddProductInToShoppingCart = new Scanner(System.in);
          System.out.println("Digit the Shopping Cart ID: ");
          int idShoppingCart = Integer.parseInt(scannerToAddProductInToShoppingCart.nextLine());
          System.out.println("Digit the Product ID: ");
          int idProduct = Integer.parseInt(scannerToAddProductInToShoppingCart.nextLine());
          System.out.println("Digit the Quantity of Products you add: ");
          int quantityOfProducts = Integer.parseInt(scannerToAddProductInToShoppingCart.nextLine());
          InsertProductInTheShoppingCartRequest insertProductInTheShoppingCartRequest =
              InsertProductInTheShoppingCartRequest.newBuilder().setIdShoppingCart(idShoppingCart)
                  .setIdProduct(idProduct).setQuantity(quantityOfProducts).build();
          InsertProductInTheShoppingCartReply insertProductInTheShoppingCartReply =
              stub.insertProductInTheShoppingCart(insertProductInTheShoppingCartRequest);
          System.out.println(insertProductInTheShoppingCartReply.getMessage());
          break;
        case 7:
          System.out.println("*************************************************");
          System.out.println("*          Sub Menu Export Procts               *");
          System.out.println("*       Digit a option to file export:          *");
          System.out.println("*************************************************");
          System.out.println("*             1) JSON                           *");
          System.out.println("*             2) Parquet                        *");
          System.out.println("*************************************************");
          int subMenuOption;
          Scanner scannerSubmenu = new Scanner(System.in);
          subMenuOption = Integer.parseInt(scannerSubmenu.nextLine());
          switch (subMenuOption) {
            case 1:
              FileWriter fileWriter;
              ExportFileRequest exportFileRequest = ExportFileRequest.newBuilder()
                  .setFileName(properties.getProperty("PATH_JSON_FILE_WRITER")).build();
              Iterator<ExportFileReply> exportFileReplyIterator =
                  stub.exportProductsToJsonFile(exportFileRequest);
              while (exportFileReplyIterator.hasNext()) {
                ExportFileReply exportFileReply = exportFileReplyIterator.next();
                System.out.println(exportFileReply.getData());
                System.out.println(exportFileReply.getSize());
                fileWriter = new FileWriter(properties.getProperty("PATH_JSON_FILE_WRITER"));
                fileWriter.write(exportFileReply.getData());
                fileWriter.flush();
                fileWriter.close();
              }
              break;
            case 2:
              FindProducts findProductsToExportParquetFile = FindProducts.newBuilder().build();
              Iterator<ProductReply> iteratorToExportParquetFile =
                  stub.listProducts(findProductsToExportParquetFile);
              List<List<String>> dataOrganizerParquetFileFormat = new ArrayList<>();
              while (iteratorToExportParquetFile.hasNext()) {
                ProductReply productReplyToExportParquetFile = iteratorToExportParquetFile.next();
                List<String> parquetFileIten = new ArrayList<>();
                parquetFileIten.add(String.valueOf(productReplyToExportParquetFile.getId()));
                parquetFileIten.add(productReplyToExportParquetFile.getName());
                parquetFileIten.add(String.valueOf(productReplyToExportParquetFile.getStock()));
                parquetFileIten.add(String.valueOf(productReplyToExportParquetFile.getPrice()));
                dataOrganizerParquetFileFormat.add(parquetFileIten);
              }
              System.out.println(dataOrganizerParquetFileFormat);
              break;
            default:
              System.out.println("Inform a menu option valid!");
          }
          break;
        case 8:
          System.out.println("*************************************************");
          System.out.println("*          Sub Menu Import Products             *");
          System.out.println("*       Digit a option to file export:          *");
          System.out.println("*************************************************");
          System.out.println("*             1) JSON                           *");
          System.out.println("*             2) Parquet                        *");
          System.out.println("*************************************************");
          int subMenuReadFileOption;
          Scanner scannerSubmenuReadFile = new Scanner(System.in);
          subMenuReadFileOption = Integer.parseInt(scannerSubmenuReadFile.nextLine());
          switch (subMenuReadFileOption) {
            case 1:
              // create a reader
              Reader reader =
                  Files.newBufferedReader(Paths
                      .get(properties.getProperty("PATH_JSON_FILE_READER")));
              //create ObjectMapper instance
              ObjectMapper objectMapper = new ObjectMapper();
              //read customer.json file into tree model
              JsonNode parser = objectMapper.readTree(reader);
              for (JsonNode pm : parser.path("products")) {
                Product product = new Product();
                product.setName((pm.path("name").asText()));
                product.setStock(Integer.parseInt(String.valueOf(pm.path("stock"))));
                product.setPrice(Double.parseDouble(String.valueOf(pm.path("price"))));
                // save product
                grpc.SaveProductRequest saveProductJsonFileInDataBase =
                    grpc.SaveProductRequest
                        .newBuilder()
                        .setName(product.getName())
                        .setStock(product.getStock())
                        .setPrice((float) product.getPrice())
                        .build();
                SaveProductReply saveJsonFileInDataBaseReply = stub
                    .saveProduct(saveProductJsonFileInDataBase);
                System.out.println(saveJsonFileInDataBaseReply.getMessage());
              }
              //close reader
              reader.close();
              break;
            case 2:
              System.out.println("Import to Parquet");
              break;
            default:
              System.out.println("Inform a menu option valid!");
          }
          break;
        case 9:
          Scanner scannerToDigitIdClientToFinalizeSale = new Scanner(System.in);
          System.out.println("Digit the Client ID: ");
          int idClientFinalizeSale =
              Integer.parseInt(scannerToDigitIdClientToFinalizeSale.nextLine());
          FinalizeSaleRequest finalizeSaleRequest =
              FinalizeSaleRequest
                  .newBuilder()
                  .setIdClient(idClientFinalizeSale)
                  .build();
          FinalizeSaleReply finalizeSaleReply = stub.finalizeSale(finalizeSaleRequest);
          float totalSale = Float.parseFloat(finalizeSaleReply.getMessage());
          System.out.printf("Total Value of You Cart Is: %.2f $ \n", totalSale);
          break;
        default:
          System.out.println("Inform a menu option valid!");
          break;
      }
    } while (menuOption != 0);
  }
}
