# Simple Rest APIs with Entity using Vertex server, Maven Archetype.

 #### HTTP Methods (Vertex Routing):
	GET     -   '/api/employees'      (get the list of Employees)
	GET     -   '/api/employees/:id'  (get the Employee with given id)
	POST    -   '/api/employees'      (Create an Employee)
	PUT     -   '/api/employees/:id'  (Update employee containing given id)
	DELETE  -   '/api/employees/:id'  (Delete/remove employee containing given id)


Curl Testing on http://localhost:8080 using Terminal: (Example with Payload)

   curl http://localhost:8080/api/employees
     - get the list of Employees
      
   curl http://localhost:8080/api/employees/2
    - get the Employee with given id

   curl -d 'id=3&name=roshan&position=developer&company=rs' http://localhost:8080/api/employees
    - Create an Employee with given data containing id,name,postion,company.
    
   curl -X PUT -d 'id=3&name=roshan&position=developer&company=Microsoft' http://localhost:8080/api/employees/3
   - update an Employee (i.e id=3) with given data containing id,name,postion,company.
   
   curl -X DELETE http://localhost:8080/api/employees/1
    - delete the Employee with given id
    

