/*
 * Copyright (C) 2016 Pivotal Software, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.arsw.myrestaurant.restcontrollers;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import static com.google.inject.Guice.createInjector;
import edu.eci.arsw.myrestaurant.beans.BillCalculator;
import edu.eci.arsw.myrestaurant.beans.impl.BasicBillCalculator;
import edu.eci.arsw.myrestaurant.model.Order;
import edu.eci.arsw.myrestaurant.model.ProductType;
import edu.eci.arsw.myrestaurant.model.RestaurantProduct;
import edu.eci.arsw.myrestaurant.services.RestaurantOrderServicesStub;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hcadavid
 */
@RestController
@RequestMapping(value = "/orders")
public class OrdersAPIController {
    private Gson data;
    private static OrdersAPIController instance= new OrdersAPIController();
    private static Injector injector;
    
    public OrdersAPIController(){
        injector = createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BillCalculator.class).toInstance(BasicBillCalculator);
            }
        });
        
    }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getOrders(){
        try{
            return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }
    
}

 