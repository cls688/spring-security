package cn.cls.security.handler;

import cn.cls.security.uitl.Result;
import cn.cls.security.uitl.WebUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result result = new Result<>(HttpStatus.UNAUTHORIZED.value(), "用户认证失败请重新登录");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
