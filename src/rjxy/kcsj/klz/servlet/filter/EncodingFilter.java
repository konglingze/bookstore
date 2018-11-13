package rjxy.kcsj.klz.servlet.filter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class EncodingFilter implements Filter {
       private String charset = "UTF-8";
       public void init(FilterConfig config)throws ServletException{
    	   if(config.getInitParameter("charset") != null) 
    	   this.charset =config.getInitParameter("charset");//取得初始化参数
    	   
       }
       public void doFilter(ServletRequest request,ServletResponse response,
    		   FilterChain Chain)throws IOException ,ServletException{
    	   request.setCharacterEncoding(charset);//设置统一编码
    	   Chain.doFilter(request, response);
    	   }
       @Override
   	public void destroy() {
   		// TODO 自动生成的方法存根  	
    	   this.charset = null;
   	}
   
}
