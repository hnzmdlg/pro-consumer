package com.ws.service;

import com.ws.bean.Answer;

import java.util.HashMap;

public interface AnswerrService {

    HashMap<String, Object> queryanswerr(int page, int rows, Answer answer);
}
