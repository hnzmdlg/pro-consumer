package com.ws.service;

import com.ws.bean.Salary;

import java.util.HashMap;
import java.util.List;

public interface SalaryService {

    HashMap<String, Object> salaryanswer(int page, int rows, Salary salary);


    List<Salary> resetlot();
}
