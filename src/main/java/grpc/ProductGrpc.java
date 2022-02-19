package grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.sql.SQLException;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.30.0)",
    comments = "Source: Product.proto")
public final class ProductGrpc {

  private ProductGrpc() {}

  public static final String SERVICE_NAME = "Product";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.ProductRequest,
      grpc.ProductRepply> getCallProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CallProduct",
      requestType = grpc.ProductRequest.class,
      responseType = grpc.ProductRepply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.ProductRequest,
      grpc.ProductRepply> getCallProductMethod() {
    io.grpc.MethodDescriptor<grpc.ProductRequest, grpc.ProductRepply> getCallProductMethod;
    if ((getCallProductMethod = ProductGrpc.getCallProductMethod) == null) {
      synchronized (ProductGrpc.class) {
        if ((getCallProductMethod = ProductGrpc.getCallProductMethod) == null) {
          ProductGrpc.getCallProductMethod = getCallProductMethod =
              io.grpc.MethodDescriptor.<grpc.ProductRequest, grpc.ProductRepply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CallProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ProductRepply.getDefaultInstance()))
              .setSchemaDescriptor(new ProductMethodDescriptorSupplier("CallProduct"))
              .build();
        }
      }
    }
    return getCallProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.SaveProductRequest,
      grpc.SaveProductReply> getSaveProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SaveProduct",
      requestType = grpc.SaveProductRequest.class,
      responseType = grpc.SaveProductReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.SaveProductRequest,
      grpc.SaveProductReply> getSaveProductMethod() {
    io.grpc.MethodDescriptor<grpc.SaveProductRequest, grpc.SaveProductReply> getSaveProductMethod;
    if ((getSaveProductMethod = ProductGrpc.getSaveProductMethod) == null) {
      synchronized (ProductGrpc.class) {
        if ((getSaveProductMethod = ProductGrpc.getSaveProductMethod) == null) {
          ProductGrpc.getSaveProductMethod = getSaveProductMethod =
              io.grpc.MethodDescriptor.<grpc.SaveProductRequest, grpc.SaveProductReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SaveProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SaveProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.SaveProductReply.getDefaultInstance()))
              .setSchemaDescriptor(new ProductMethodDescriptorSupplier("SaveProduct"))
              .build();
        }
      }
    }
    return getSaveProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.FindProductById,
      grpc.ProductList> getListProductByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProductById",
      requestType = grpc.FindProductById.class,
      responseType = grpc.ProductList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.FindProductById,
      grpc.ProductList> getListProductByIdMethod() {
    io.grpc.MethodDescriptor<grpc.FindProductById, grpc.ProductList> getListProductByIdMethod;
    if ((getListProductByIdMethod = ProductGrpc.getListProductByIdMethod) == null) {
      synchronized (ProductGrpc.class) {
        if ((getListProductByIdMethod = ProductGrpc.getListProductByIdMethod) == null) {
          ProductGrpc.getListProductByIdMethod = getListProductByIdMethod =
              io.grpc.MethodDescriptor.<grpc.FindProductById, grpc.ProductList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProductById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.FindProductById.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ProductList.getDefaultInstance()))
              .setSchemaDescriptor(new ProductMethodDescriptorSupplier("ListProductById"))
              .build();
        }
      }
    }
    return getListProductByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.FindProducts,
      grpc.ProductList> getListProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProducts",
      requestType = grpc.FindProducts.class,
      responseType = grpc.ProductList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.FindProducts,
      grpc.ProductList> getListProductsMethod() {
    io.grpc.MethodDescriptor<grpc.FindProducts, grpc.ProductList> getListProductsMethod;
    if ((getListProductsMethod = ProductGrpc.getListProductsMethod) == null) {
      synchronized (ProductGrpc.class) {
        if ((getListProductsMethod = ProductGrpc.getListProductsMethod) == null) {
          ProductGrpc.getListProductsMethod = getListProductsMethod =
              io.grpc.MethodDescriptor.<grpc.FindProducts, grpc.ProductList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.FindProducts.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.ProductList.getDefaultInstance()))
              .setSchemaDescriptor(new ProductMethodDescriptorSupplier("ListProducts"))
              .build();
        }
      }
    }
    return getListProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.DeletProductRequest,
      grpc.DeletProductResponse> getDeletProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletProduct",
      requestType = grpc.DeletProductRequest.class,
      responseType = grpc.DeletProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.DeletProductRequest,
      grpc.DeletProductResponse> getDeletProductMethod() {
    io.grpc.MethodDescriptor<grpc.DeletProductRequest, grpc.DeletProductResponse> getDeletProductMethod;
    if ((getDeletProductMethod = ProductGrpc.getDeletProductMethod) == null) {
      synchronized (ProductGrpc.class) {
        if ((getDeletProductMethod = ProductGrpc.getDeletProductMethod) == null) {
          ProductGrpc.getDeletProductMethod = getDeletProductMethod =
              io.grpc.MethodDescriptor.<grpc.DeletProductRequest, grpc.DeletProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DeletProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.DeletProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductMethodDescriptorSupplier("DeletProduct"))
              .build();
        }
      }
    }
    return getDeletProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductStub>() {
        @java.lang.Override
        public ProductStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductStub(channel, callOptions);
        }
      };
    return ProductStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductBlockingStub>() {
        @java.lang.Override
        public ProductBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductBlockingStub(channel, callOptions);
        }
      };
    return ProductBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductFutureStub>() {
        @java.lang.Override
        public ProductFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductFutureStub(channel, callOptions);
        }
      };
    return ProductFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProductImplBase implements io.grpc.BindableService {

    /**
     */
    public void callProduct(grpc.ProductRequest request,
        io.grpc.stub.StreamObserver<grpc.ProductRepply> responseObserver) {
      asyncUnimplementedUnaryCall(getCallProductMethod(), responseObserver);
    }

    /**
     */
    public void saveProduct(grpc.SaveProductRequest request,
        io.grpc.stub.StreamObserver<grpc.SaveProductReply> responseObserver) throws SQLException {
      asyncUnimplementedUnaryCall(getSaveProductMethod(), responseObserver);
    }

    /**
     */
    public void listProductById(grpc.FindProductById request,
        io.grpc.stub.StreamObserver<grpc.ProductList> responseObserver) {
      asyncUnimplementedUnaryCall(getListProductByIdMethod(), responseObserver);
    }

    /**
     */
    public void listProducts(grpc.FindProducts request,
        io.grpc.stub.StreamObserver<grpc.ProductList> responseObserver) {
      asyncUnimplementedUnaryCall(getListProductsMethod(), responseObserver);
    }

    /**
     */
    public void deletProduct(grpc.DeletProductRequest request,
        io.grpc.stub.StreamObserver<grpc.DeletProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeletProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCallProductMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.ProductRequest,
                grpc.ProductRepply>(
                  this, METHODID_CALL_PRODUCT)))
          .addMethod(
            getSaveProductMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.SaveProductRequest,
                grpc.SaveProductReply>(
                  this, METHODID_SAVE_PRODUCT)))
          .addMethod(
            getListProductByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.FindProductById,
                grpc.ProductList>(
                  this, METHODID_LIST_PRODUCT_BY_ID)))
          .addMethod(
            getListProductsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.FindProducts,
                grpc.ProductList>(
                  this, METHODID_LIST_PRODUCTS)))
          .addMethod(
            getDeletProductMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.DeletProductRequest,
                grpc.DeletProductResponse>(
                  this, METHODID_DELET_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class ProductStub extends io.grpc.stub.AbstractAsyncStub<ProductStub> {
    private ProductStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductStub(channel, callOptions);
    }

    /**
     */
    public void callProduct(grpc.ProductRequest request,
        io.grpc.stub.StreamObserver<grpc.ProductRepply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCallProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveProduct(grpc.SaveProductRequest request,
        io.grpc.stub.StreamObserver<grpc.SaveProductReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSaveProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listProductById(grpc.FindProductById request,
        io.grpc.stub.StreamObserver<grpc.ProductList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListProductByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listProducts(grpc.FindProducts request,
        io.grpc.stub.StreamObserver<grpc.ProductList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deletProduct(grpc.DeletProductRequest request,
        io.grpc.stub.StreamObserver<grpc.DeletProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeletProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProductBlockingStub> {
    private ProductBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.ProductRepply callProduct(grpc.ProductRequest request) {
      return blockingUnaryCall(
          getChannel(), getCallProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.SaveProductReply saveProduct(grpc.SaveProductRequest request) {
      return blockingUnaryCall(
          getChannel(), getSaveProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.ProductList listProductById(grpc.FindProductById request) {
      return blockingUnaryCall(
          getChannel(), getListProductByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.ProductList listProducts(grpc.FindProducts request) {
      return blockingUnaryCall(
          getChannel(), getListProductsMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.DeletProductResponse deletProduct(grpc.DeletProductRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeletProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductFutureStub extends io.grpc.stub.AbstractFutureStub<ProductFutureStub> {
    private ProductFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ProductRepply> callProduct(
        grpc.ProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCallProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.SaveProductReply> saveProduct(
        grpc.SaveProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSaveProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ProductList> listProductById(
        grpc.FindProductById request) {
      return futureUnaryCall(
          getChannel().newCall(getListProductByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.ProductList> listProducts(
        grpc.FindProducts request) {
      return futureUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.DeletProductResponse> deletProduct(
        grpc.DeletProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeletProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALL_PRODUCT = 0;
  private static final int METHODID_SAVE_PRODUCT = 1;
  private static final int METHODID_LIST_PRODUCT_BY_ID = 2;
  private static final int METHODID_LIST_PRODUCTS = 3;
  private static final int METHODID_DELET_PRODUCT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALL_PRODUCT:
          serviceImpl.callProduct((grpc.ProductRequest) request,
              (io.grpc.stub.StreamObserver<grpc.ProductRepply>) responseObserver);
          break;
        case METHODID_SAVE_PRODUCT:
          try {
            serviceImpl.saveProduct((SaveProductRequest) request,
                (io.grpc.stub.StreamObserver<SaveProductReply>) responseObserver);
          } catch (SQLException e) {
            e.printStackTrace();
          }
          break;
        case METHODID_LIST_PRODUCT_BY_ID:
          serviceImpl.listProductById((grpc.FindProductById) request,
              (io.grpc.stub.StreamObserver<grpc.ProductList>) responseObserver);
          break;
        case METHODID_LIST_PRODUCTS:
          serviceImpl.listProducts((grpc.FindProducts) request,
              (io.grpc.stub.StreamObserver<grpc.ProductList>) responseObserver);
          break;
        case METHODID_DELET_PRODUCT:
          serviceImpl.deletProduct((grpc.DeletProductRequest) request,
              (io.grpc.stub.StreamObserver<grpc.DeletProductResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.ProductProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Product");
    }
  }

  private static final class ProductFileDescriptorSupplier
      extends ProductBaseDescriptorSupplier {
    ProductFileDescriptorSupplier() {}
  }

  private static final class ProductMethodDescriptorSupplier
      extends ProductBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductFileDescriptorSupplier())
              .addMethod(getCallProductMethod())
              .addMethod(getSaveProductMethod())
              .addMethod(getListProductByIdMethod())
              .addMethod(getListProductsMethod())
              .addMethod(getDeletProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
