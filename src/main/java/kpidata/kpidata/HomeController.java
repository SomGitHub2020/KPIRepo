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

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	 List<Customer> lstCustomers = new ArrayList<Customer>();
	 List<Oee> lstOees = new ArrayList<Oee>();
	  
	  @PostConstruct
	    public void init() throws Exception {
	    lstCustomers.add(new Customer("30.5", 27));
	    lstOees.add(new Oee("87.5", "75.2", "91.4"));
	    }
	 
	  @GetMapping
	  public String index() {
	    return "redirect:/customer";
	  }
	  
	  @GetMapping("/customer")
	    public String getCustomer(Model model) {
	        model.addAttribute("customers", lstCustomers);
	        model.addAttribute("oees", lstOees);
	        return "customer/display";
	    }
}
