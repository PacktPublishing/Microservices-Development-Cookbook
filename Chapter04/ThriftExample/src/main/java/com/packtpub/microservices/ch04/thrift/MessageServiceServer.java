package com.packtpub.microservices.ch04.thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class MessageServiceServer {
    private TSimpleServer server;

    private void start() throws TTransportException {

        TServerTransport serverTransport = new TServerSocket(9999);
        server = new TSimpleServer(new TServer.Args(serverTransport)
                .processor(new MessageService.Processor<>(new MessageServiceImpl())));
        server.serve();
    }

    private void stop() {
        if (server != null && server.isServing())
            server.stop();
    }

    public static void main(String[] args) {
        MessageServiceServer service = new MessageServiceServer();
        try {
            if (args[1].equals("start"))
                service.start();
            else if (args[2].equals("stop"))
                service.stop();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
