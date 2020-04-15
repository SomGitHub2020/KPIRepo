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
	  
	  @PostConstruct
	    public void init() throws Exception {
	    lstCustomers.add(new Customer(new Long(1), "Jack", 25, new Address("NANTERRE CT", "77471")));
	    lstCustomers.add(new Customer(new Long(2), "Mary", 37, new Address("W NORMA ST", "77009")));
	    lstCustomers.add(new Customer(new Long(3), "Peter", 18, new Address("S NUGENT AVE", "77571")));
	    lstCustomers.add(new Customer(new Long(4), "Amos", 23, new Address("E NAVAHO TRL", "77449")));
	    lstCustomers.add(new Customer(new Long(5), "Craig", 45, new Address("AVE N", "77587")));
	    lstCustomers.add(new Customer(new Long(6), "Aries", 19, new Address("Broadway/Reade St, New York", "10007")));
	    lstCustomers.add(new Customer(new Long(7), "Brice", 39, new Address("Columbus, OH 43215, USA", "43215")));
	    lstCustomers.add(new Customer(new Long(8), "Cage", 24, new Address("Plano, TX 75074", "75074")));
	    lstCustomers.add(new Customer(new Long(9), "Ellen", 41, new Address("Modesto, CA 95354", "95354")));
	    lstCustomers.add(new Customer(new Long(10), "Brice", 32, new Address("Atlanta, GA 30334", "30334")));
	    }
	 
	  @GetMapping
	  public String index() {
	    return "redirect:/customer";
	  }
	  
	  @GetMapping("/customer")
	    public String getCustomer(Model model) {
	        model.addAttribute("customers", lstCustomers);
	        return "customer/display";
	    }
}
