package com.metacoding.exerciseappserver._core.auth;

import com.metacoding.exerciseappserver.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


@RequiredArgsConstructor
@Configuration
public class LoginUserResolver implements HandlerMethodArgumentResolver{
	private final HttpSession session;
	
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		boolean isAnnotation = parameter.getParameterAnnotation(SessionUser.class) != null;
		boolean isClass = User.class.equals(parameter.getParameterType());
		
		return isAnnotation && isClass;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		User sessionUser = (User) session.getAttribute("sessionUser");
		return sessionUser;
	}
}
