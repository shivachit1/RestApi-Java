package com.vertx.restapi;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class App
{
    public static void main( String[] args ) {
      Vertx vertx = Vertx.vertx();

      // Creating Http Server using Vertx
      HttpServer httpsServer = vertx.createHttpServer();
      Router router = Router.router(vertx);

      EmployeeDao employeeDao=new EmployeeDaoImp();

        //-- GET method for getting List of Employees
        // "Path"  /api/employees
      router.get("/api/employees").handler(BodyHandler.create())
              .handler(routingContext -> {
                 HttpServerResponse response = routingContext.response();
                 response.setChunked(true);
                 response.end("List of Employees : "+ employeeDao.getEmployees().toString());
              });

        //-- POST method for creating an Employee
        // "path" /api/employees
        router.post("/api/employees").produces("application/json").handler(BodyHandler.create())
                .handler(routingContext -> {
                    String id = routingContext.request().getParam("id");
                    String name = routingContext.request().getParam("name");
                    String position = routingContext.request().getParam("position");
                    String company = routingContext.request().getParam("company");

                    // using Entity Builder For creating Object
                    final EmployeeEntity employee=EmployeeEntity.builder().setId(id).setName(name).setPosition(position).setCompany(company).build();
                    HttpServerResponse response = routingContext.response();
                    response.setChunked(true);
                    employeeDao.getEmployees().add(employee);
                    response.putHeader("content-type","text/plain");
                    response.setStatusCode(201).end("new Employee added: data after addition "+ employeeDao.getEmployees().toString());

                });

       // Get Method for getting Employee by ID
        // "path" /api/employees/:id
        router.get("/api/employees/:id").handler(BodyHandler.create())
                    .handler(routingContext -> {
                        String id = routingContext.request().getParam("id");
                       for(EmployeeEntity em:employeeDao.getEmployees()){
                           if(em.getId().equals(id)){
                               HttpServerResponse response = routingContext.response();
                               response.putHeader("content-type","text/plain");
                               response.end(em.toString());
                           }

                       }
                });


        // Update employee using ID
        // "Path"  /api/employees/:id
        router.put("/api/employees/:id").handler(BodyHandler.create())
                .handler(routingContext -> {
                    String id = routingContext.request().getParam("id");
                    if(id!=null){
                        for(EmployeeEntity em:employeeDao.getEmployees()){
                            if(em.getId().equals(id)){
                                String name = routingContext.request().getParam("name");
                                String position = routingContext.request().getParam("position");
                                String company = routingContext.request().getParam("company");

                                // using Entity Builder For creating Object
                                final EmployeeEntity employee=EmployeeEntity.builder().setId(id).setName(name).setPosition(position).setCompany(company).build();
                                HttpServerResponse response = routingContext.response();
                                response.setChunked(true);
                                employeeDao.getEmployees().remove(em);
                                employeeDao.getEmployees().add(employee);
                                response.putHeader("content-type","text/plain");
                                response.end("Data Updated : data after updating " + employeeDao.getEmployees() );
                            }

                        }
                    }

                });


        // Delete a Employee Given ID
        // "Path"  /api/employees/:id
        router.delete("/api/employees/:id").handler(BodyHandler.create())
                .handler(routingContext -> {
                    String id = routingContext.request().getParam("id");
                    for(EmployeeEntity em:employeeDao.getEmployees()){
                        if(em.getId().equals(id)){
                         HttpServerResponse response = routingContext.response();
                            response.setChunked(true);
                            employeeDao.getEmployees().remove(em);
                            response.putHeader("content-type","text/plain");
                            response.setStatusCode(204).end("Data Deleted : data after deletion " +employeeDao.getEmployees().toString());
                        }

                    }
                });

        // Running Vertx Server with Port 8080
      httpsServer.requestHandler(router::accept).listen(8080);
    }
}
