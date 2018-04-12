/**
 * @author ssaleh
 *
 * Created date 4 Apr 2018
 */
package net.sh4m.genericjdbc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sh4m.genericjdbc.service.MainService;



@Controller
public class MainController {

	@Autowired 
	private MainService mainService;
	
	@RequestMapping(value = "/testSQL",
            method = RequestMethod.GET, produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Map<String, Object> test()
    {
        
		Map<String, Object> resp = new HashMap<String, Object>() ;
		
		List<Map<String,Object>> result = null;
		//result = mainService.selectAllProject();
		result = mainService.selectTest1();
		resp.put("result", result);
		return resp;
	
    }
}
