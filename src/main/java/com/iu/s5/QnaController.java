package com.iu.s5;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.qna.QnaDTO;
import com.iu.qna.QnaService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaList")
	public ModelAndView selectList(ListData listData) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.selectList(listData);
		mv.addObject("list", ar);
		mv.addObject("page", listData);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		return mv;
		
	}
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public ModelAndView insert(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String insert2(QnaDTO qnaDTO, RedirectAttributes ra) throws Exception{
		int result = qnaService.insert(qnaDTO);
		String message="Fail";
		if(result>0){
			message="Success";
		}
		ra.addFlashAttribute("message", message);
		return "redirect:./qnaList";
	}

}
