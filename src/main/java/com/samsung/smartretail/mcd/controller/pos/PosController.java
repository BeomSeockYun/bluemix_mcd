package com.samsung.smartretail.mcd.controller.pos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.samsung.smartretail.mcd.service.pos.PosService;
import com.samsung.smartretail.mcd.vo.pos.PosVO;

@Controller
public class PosController {

	@Autowired
	private PosService posService;

	@RequestMapping(value="/insertPosData" , method=RequestMethod.POST)
	@ResponseBody
	public String insertPosData(
			//@RequestParam(value="product_name") String product_name,
			//@RequestParam(value="product_price") String product_price,
			//@RequestParam(value="product_count") String product_count
			PosVO posData
			){

		posService.insertPosData(posData);

		return "success";
	}

	@RequestMapping(value="/getPosData")
	@ResponseBody
	public  List<PosVO> getPosData(){
		List<PosVO> posList = posService.getPosData();
		return posList;
	}

	/**
	 * Object returning sample
	 * @return
	 */
	@RequestMapping(value="/getJSONRequest",method=RequestMethod.POST)
	public @ResponseBody String getJSONRequest(@RequestBody List<PosVO> sample){

		System.out.println(sample.get(1).getProduct_count());
		return "TEST";
	}

	/**
	 * Object returning sample
	 * @return
	 */
	@RequestMapping(value="/test.html",method = RequestMethod.GET)
	public String test(){
		System.out.println("TEST");
		return "redirect:/pages/test.html";

	}

}
