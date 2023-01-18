package com.example.logtestapi.Service.Imp;

import org.springframework.stereotype.Service;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.example.logtestapi.Service.ILoginSerivce;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class LoggingServiceImpl implements ILoginSerivce {
    /*
     * choose the logger type
     */

    // Logger logger = LoggerFactory.getLogger("LoggingServiceImpl");

    Logger logger = LogManager.getLogger("LoggingServiceImpl");

    /*
     * this function display the request logger
     */
    @Override
    public void displayReq(HttpServletRequest request, Object body) {
        // StringBuilder reqMessage = new StringBuilder();
        // Map<String, String> parameters = getParameters(request);

        // reqMessage.append("REQUEST ");
        // reqMessage.append("method = [").append(request.getMethod()).append("]");
        // reqMessage.append(" path = [").append(request.getRequestURI()).append("] ");

        // if (!parameters.isEmpty()) {
        // reqMessage.append(" parameters = [").append(parameters).append("] ");
        // }

        // if (!Objects.isNull(body)) {
        // reqMessage.append(" body = [").append(body).append("]");
        // }

        // logger.info("log Request: {}", reqMessage);
    }

    /*
     * this functin display the responde logger
     */
    @Override
    public void displayResp(HttpServletRequest request, HttpServletResponse response, Object body) {
        // request logging

        // StringBuilder reqMessage = new StringBuilder();
        // ContentCachingRequestWrapper requestWrapper = new
        // ContentCachingRequestWrapper(request);

        // String requestBody = getStringValue(requestWrapper.getContentAsByteArray(),
        // request.getCharacterEncoding());
        // Map<String, String> parameters = getParameters(request);

        // reqMessage.append("REQUEST ");
        // reqMessage.append("method = [").append(request.getMethod()).append("]");
        // reqMessage.append(" path = [").append(request.getRequestURI()).append("] ");
        // System.out.println("============ body ---: " + requestBody + " ------");
        // if (!parameters.isEmpty()) {
        // reqMessage.append(" parameters = [").append(parameters).append("] ");
        // }

        // if (requestBody != null && !requestBody.isEmpty()) {
        // reqMessage.append(" body = [").append(requestBody).append("]");
        // }

        // // response logging
        // StringBuilder respMessage = new StringBuilder();
        // Map<String, String> headers = getHeaders(response);
        // respMessage.append("RESPONSE ");
        // respMessage.append(" method = [").append(request.getMethod()).append("]");

        // respMessage.append(" Status = [").append(response.getStatus()).append("]");
        // if (!headers.isEmpty()) {
        // respMessage.append(" ResponseHeaders = [").append(headers).append("]");
        // }
        // respMessage.append(" responseBody = [").append(body).append("]");

        // logger.info("FINISHED PROCESSING : Request {} ; Response: {} ; ", reqMessage,
        // respMessage);
    }

    private Map<String, String> getHeaders(HttpServletResponse response) {
        Map<String, String> headers = new HashMap<>();
        Collection<String> headerMap = response.getHeaderNames();
        System.out.println("---------date ----------");
        for (String str : headerMap) {
            System.out.println(str);
            headers.put(str, response.getHeader(str));
        }
        System.out.println("---------date ----------");
        return headers;
    }

    private Map<String, String> getParameters(HttpServletRequest request) {
        Map<String, String> parameters = new HashMap<>();
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            String paramValue = request.getParameter(paramName);
            parameters.put(paramName, paramValue);
        }
        return parameters;
    }

    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
        try {
            return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

}