/*
package com.kurdestanbootcamp.postemployeeservice.employee_client.grpc;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyGrpcConfiguration {
    @Bean("gEmployeeServiceGrpc")

    ManagedChannel channel(){

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        return channel;
    }

}
*/
