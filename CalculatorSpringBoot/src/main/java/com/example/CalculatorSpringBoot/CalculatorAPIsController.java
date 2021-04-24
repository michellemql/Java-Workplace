package com.example.CalculatorSpringBoot;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.PresentationDirection;

@RestController
public class CalculatorAPIsController {

	@GetMapping("/{num1}/{operator}/{num2}")
	public String add(@PathVariable int num1, @PathVariable int num2, @PathVariable String operator) {
		int result = 0;
		String s = "";
		switch (operator) {
			case "+":
				result = num1 + num2;
				s = "Sum";
				break;
			case "-":
				result = num1 - num2;
				s = "Difference";
				break;
			case "*":
				result = num1 * num2;
				s = "Product";
				break;
			case "/":
				result = num1 / num2;
				s = "Quotient";
				break;
		}
		
		return s + " of two numbers is " + result;
	}
}
