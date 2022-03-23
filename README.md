##### order-service 
1 instance on port 8100

##### customer-service 
3 instances with program arguments:
 
--server.port=8081 --instance.id=1

--server.port=8082 --instance.id=2

--server.port=8084 --instance.id=3