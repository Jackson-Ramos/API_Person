package br.com.king_dev_jr.projeto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.king_dev_jr.projeto.Math.Operatios;
import br.com.king_dev_jr.projeto.converters.NumberConverter;
import br.com.king_dev_jr.projeto.exceptions.UnsupportedMathOperationException;

@RestController
@RequestMapping()
public class MathController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set numeric value!");
		}
		return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
	}

	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set numeric value");
		}
		return Operatios.soma(numberOne, numberTwo);
	}

	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set numeric value");
		}
		return Operatios.division(numberOne, numberTwo);
	}

	@GetMapping("/average/{numberOne}/{numberTwo}")
	public Double average(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set numeric value");
		}
		return Operatios.average(numberOne, numberTwo);
	}

	@GetMapping("/squereRoot/{number}")
	public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
		if (!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return Operatios.squareRoot(number);
	}

}
