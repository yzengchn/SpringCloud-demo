package com.yzeng.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyFilter extends ZuulFilter{
	private static Logger LOG = LoggerFactory.getLogger(MyFilter.class);
	
	/**
	 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	
	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		LOG.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		String token = request.getParameter("token");
		if(StringUtils.isEmpty(token)) {
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			
			try {
				context.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		LOG.info("ok");
		return null;
	}

	/**
	 * 生命周期过滤类型有以下几种
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * filterOrder：过滤的顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}
	
}
