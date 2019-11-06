package com.vertx.restapi;

import java.util.Map;
import java.util.Set;

interface EmployeeDao {
    // Returns a unique identifier
    String getID();
    // Returns the sub-entities of this entity
    Set<EmployeeEntity> getEmployees();
    // Returns a set of key-value data belonging to this entity
    Map<String,String> getData();

}
