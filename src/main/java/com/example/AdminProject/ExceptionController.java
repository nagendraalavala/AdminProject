package com.example.AdminProject;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@EnableWebMvc
@Slf4j
public class ExceptionController extends ResponseEntityExceptionHandler{

    private Logger logger = LoggerFactory.getLogger(ExceptionController.class);

@ExceptionHandler()
public String handleError(HttpServletRequest req, Exception exception)
{
    logger.error("Request " +  req.getRequestURL() + " raised" + exception);

    return "Error";
}

}
