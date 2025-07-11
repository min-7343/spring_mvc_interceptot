package kr.co.sist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.sist.interceptors.TestInterceptor;
import kr.co.sist.interceptors.TestInterceptor2;

//설정용 class
@Configuration
//1.WebMvcConfigurer를 구현 
public class IntercepterConfig implements WebMvcConfigurer{
	// application.propertiex에 있는 속성값을  List에 저장
	@Value("${myapp.addPath}")
	List<String> addPathList;
	
	@Value("${myapp.excludePath}")
	List<String> excludePathList;
	// 2. 제작한 Interceptor를 의존성 주입
	@Autowired
	private TestInterceptor ti;

	@Autowired
	private TestInterceptor2 ti2;
	
	/**
	 * 3. 제작된 Intercepteor 가 동작할 URI를 설정하여 등록
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(ti).addPathPatterns("/");
//		registry.addInterceptor(ti).addPathPatterns("/","/hello");
//		registry.addInterceptor(ti).addPathPatterns("/","/hello","/bye");
		//리스트에 경로 설정
//		List<String> list=new ArrayList<String>();
//		list.add("/");
//		list.add("/hello");
//		list.add("/bye");
//		registry.addInterceptor(ti).addPathPatterns(list);
		
		//모든 하위 URI에 대해 동작
//		registry.addInterceptor(ti).addPathPatterns("/**");
		
		//특정 URI에 대해서는 동작하지 않도록 설정
		//- admin의 모든 동작에 intercepter을 하지만 "/admin/hello"에서는 하지 않는다.는 의미
//		registry.addInterceptor(ti).addPathPatterns("/admin/**")
//		.excludePathPatterns("/admin/hello");
		
		//List를 의존성 주입 받아서 사용
//		registry.addInterceptor(ti).addPathPatterns(addPathList);
		
		//excludePath
		registry.addInterceptor(ti).addPathPatterns(addPathList)
		.excludePathPatterns(excludePathList);
		
		//여러개의 Interceptor를 등록 할 수 있다.
//		registry.addInterceptor(ti2).addPathPatterns(addPathList)
//		.excludePathPatterns(excludePathList);
	
	}//addInterceptors
	
	
	
	
}//class
