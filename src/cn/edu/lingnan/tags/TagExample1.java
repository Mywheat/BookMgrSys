package cn.edu.lingnan.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TagExample1 extends TagSupport{

	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("Hello Java!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public int doEndTag(){
		return EVAL_PAGE;
	}
}
