package com.kurdestanbootcamp.postemployeeservice.post_employee;

import com.kurdestanbootcamp.postemployeeservice.EmployeeRequest;
import com.kurdestanbootcamp.postemployeeservice.EmployeeResponse;
import com.kurdestanbootcamp.postemployeeservice.GEmployeeServiceGrpc;
import com.kurdestanbootcamp.postemployeeservice.employee_client.EmployeeClient;
import com.kurdestanbootcamp.postemployeeservice.employee_client.EmployeeDTO;
import com.kurdestanbootcamp.postemployeeservice.employee_client.grpc.FoobarService;
import io.grpc.ManagedChannel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TestGrpcVSRest implements CommandLineRunner {

    @Autowired
    EmployeeClient employeeClient;
/*    @GrpcClient("gEmployeeServiceGrpc") // <===== gRPC stub is autowired!
    private GEmployeeServiceGrpc.GEmployeeServiceBlockingStub stub;*/


    @Autowired
    FoobarService foobarService;

    @Override
    public void run(String... args) throws Exception {
        Long start=System.currentTimeMillis();
        System.out.println(foobarService.getEmployee(1l));
        for(int i=0;i<100;i++) {

foobarService.getEmployee(1l);

       /*     EmployeeResponse employeeResponse = stub.getEmployee(EmployeeRequest.newBuilder()
                    .setId(1)

                    .build());*/

            //System.out.println(employeeResponse);
        }
        Long end=System.currentTimeMillis();
        System.out.println("End of grpc ="+(end-start));



        Long startRest=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            EmployeeDTO employeeDTO=employeeClient.getEmployee(1l);}
        //  System.out.println(employeeDTO);

        Long endRest=System.currentTimeMillis();

        System.out.println("End of rest ="+(endRest-startRest));


    }
}
