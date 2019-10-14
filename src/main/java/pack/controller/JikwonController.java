package pack.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BuserDto;
import pack.model.JikwonDto;
import pack.model.ListInter;

@Controller
public class JikwonController {
	@Autowired
	@Qualifier("listImpl")
	ListInter listInter;
	
	@RequestMapping("jikwon")
	public ModelAndView selectDataAll(){
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)listInter.selectDataAll();
		for(JikwonDto d : list) {
			String temp = d.getJikwon_ibsail();
			String[] tempArr = temp.split(" ");
			int month = Integer.parseInt(tempArr[1]);
			String quarter = "";
			if(month>=1 && month<=3) {
				quarter = "1분기";
			}else if(month>=4 && month<=6) {
				quarter = "2분기";
			}else if(month>=7 && month<=9) {
				quarter = "3분기";
			}else if(month>=10 && month<=12) {
				quarter = "4분기";
			}else {
				quarter = "";
			}
			d.setJikwon_ibsail(tempArr[0]+" "+quarter);
		}
		return new ModelAndView("list","data",list);
	}
	
	@RequestMapping("searchBuser")
	public ModelAndView selectDataBuser(HttpServletRequest request) {
		String buser_num = request.getParameter("buser_num");
		if(buser_num.equals("all")) {
			return selectDataAll();
		}else {
			ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)listInter.selectDataBuser(buser_num);
			for(JikwonDto d : list) {
				String temp = d.getJikwon_ibsail();
				String[] tempArr = temp.split(" ");
				int month = Integer.parseInt(tempArr[1]);
				String quarter = "";
				if(month>=1 && month<=3) {
					quarter = "1분기";
				}else if(month>=4 && month<=6) {
					quarter = "2분기";
				}else if(month>=7 && month<=9) {
					quarter = "3분기";
				}else if(month>=10 && month<=12) {
					quarter = "4분기";
				}else {
					quarter = "";
				}
				d.setJikwon_ibsail(tempArr[0]+" "+quarter);
			}
			return new ModelAndView("list","data",list);
		}
	}
	
	@RequestMapping("buser")
	public ModelAndView selectBuser(HttpServletRequest request) {
		String buser_num = request.getParameter("num");
		BuserDto dto = listInter.selectBuser(buser_num);
		return new ModelAndView("buser","data",dto);
	}
}
