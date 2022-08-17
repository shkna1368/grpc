package com.kurdestanbootcamp.postemployeeservice;

import com.kurdestanbootcamp.postemployeeservice.employee_client.EmployeeClient;
import com.kurdestanbootcamp.postemployeeservice.employee_client.EmployeeDTO;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class Application implements CommandLineRunner {

    @Autowired
    EmployeeClient employeeClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
       Long start=System.currentTimeMillis();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        GEmployeeServiceGrpc.GEmployeeServiceBlockingStub stub
                = GEmployeeServiceGrpc.newBlockingStub(channel);

        EmployeeResponse employeeResponse = stub.getEmployee(EmployeeRequest.newBuilder()
                .setId(1)

                .build());

        System.out.println(employeeResponse);

        channel.shutdown();
     Long end=System.currentTimeMillis();
        System.out.println("End of grpc ="+(end-start));



        Long startRest=System.currentTimeMillis();

        EmployeeDTO employeeDTO=employeeClient.getEmployee(1l);
        System.out.println(employeeDTO);

        Long endRest=System.currentTimeMillis();

        System.out.println("End of rest ="+(endRest-startRest));



    }
}
