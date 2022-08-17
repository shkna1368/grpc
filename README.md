# spring boot grpc project
tools for test :</br>
https://github.com/bloomrpc/bloomrpc/releases
for banchmark between rest and grps used apche bench:



ab -n 800 -c 100 -s 500 http://localhost:7070/postemployeeservice/restVSgrpc/grpc/employee/v1/1

ab -n 800 -c 100 -s 500 http://localhost:7070/postemployeeservice/restVSgrpc/rest/employee/v1/1

800 requests with concurrency of 100 for spring rest

