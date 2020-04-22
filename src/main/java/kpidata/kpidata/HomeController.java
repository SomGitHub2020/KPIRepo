/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package kpidata.kpidata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	  @GetMapping
	  public String index() {
	    return "redirect:/customer";
	  }
	  
	  @GetMapping("/customer")
	    public String getCustomer(Model model) {
		  
		  List<OrderDetail> lstOrderDetails = new ArrayList<OrderDetail>();
		  List<Oee> lstOees = new ArrayList<Oee>();

		  //lstOrderDetails.add(new OrderDetail(String.valueOf(new Random().nextInt(25)), String.valueOf(new Random().nextInt(45))));
		  
		  ShopOrderDetails shopOrderDetails = new ShopOrderDetails();
		  try {
			shopOrderDetails.getOrderQuantities(lstOrderDetails);
			//orderdetail.setOrdernum(new ShopOrderDetails().getOrderData());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  //lstOees.add(new Oee(String.valueOf(new Random().nextInt(95)), String.valueOf(new Random().nextInt(75)), String.valueOf(new Random().nextInt(100))));
		  lstOees.add(new Oee("85", "73", "92"));

		  model.addAttribute("orderdetails", lstOrderDetails);
		  model.addAttribute("oees", lstOees);
		  return "customer/display";
	    }
	  
	  	@PostMapping("/customer")
	  	public void getOrderData(@ModelAttribute OrderDetail orderdetail) {
		  
	  	  try {
			  orderdetail.setOrdernum(new ShopOrderDetails().getOrderData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 
	  	}
	  
	  @PostConstruct
	    public void init() throws Exception {
		 //String ActualQty = Math.random().nextInt;
		  //random.//
		  //String ActualQty = String.valueOf(new Random().nextInt(25));

		  List<OrderDetail> lstOrderDetails = new ArrayList<OrderDetail>();
		  List<Oee> lstOees = new ArrayList<Oee>();

		  ShopOrderDetails shopOrderDetails = new ShopOrderDetails();
		  shopOrderDetails.getOrderQuantities(lstOrderDetails);
		  lstOees.add(new Oee("85", "73", "92"));
	    }
}
