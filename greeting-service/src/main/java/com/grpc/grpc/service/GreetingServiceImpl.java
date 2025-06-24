package com.grpc.grpc.service;

import com.grpc.grpc.GreetingRequest;
import com.grpc.grpc.GreetingResponse;
import com.grpc.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received message: " + message);
        GreetingResponse response = GreetingResponse.newBuilder()
                .setMessage("Hello from server").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
