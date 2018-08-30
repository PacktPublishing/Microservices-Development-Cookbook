package com.packtpub.microservices.ch04.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class MessageServer {
    private final int port;
    private final Server server;

    private MessageServer(int port) throws IOException {
        this(ServerBuilder.forPort(port), port);
    }

    private MessageServer(ServerBuilder<?> serverBuilder, int port) {
        this.port = port;
        this.server = serverBuilder.addService(new MessageService()).build();
    }

    public void start() throws IOException {
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may has been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                MessageServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private static class MessageService extends MessageServiceGrpc.MessageServiceImplBase {
        public void inbox(MessageServiceOuterClass.Username request,
                          StreamObserver<MessageServiceOuterClass.InboxReply> responseObserver) {
            MessageServiceOuterClass.InboxReply reply = MessageServiceOuterClass.InboxReply.newBuilder().addMessages(
                    MessageServiceOuterClass.Message.newBuilder()
                            .setId("1234")
                            .setFromUser("Paul")
                            .setToUser("Veronica")
                            .setBody("hi")
            ).addMessages(
                    MessageServiceOuterClass.Message.newBuilder()
                            .setId("5678")
                            .setFromUser("FooBarUser")
                            .setToUser("Veronica")
                            .setBody("Hello again")
            ).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    public static void main(String[] args) throws Exception {
        MessageServer server = new MessageServer(8989);
        server.start();
        server.blockUntilShutdown();
    }
}
