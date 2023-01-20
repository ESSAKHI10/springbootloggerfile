package com.example.logtestapi.helpers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.logtestapi.ReturnStatement.ResponseData;
import com.example.logtestapi.ReturnStatement.ReturnStatement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
public class ReturnStatementPreparator {
    @Autowired
    private ReturnStatement returnStatement;

    public ReturnStatement prepare(String stateCode, String labelCode) {
        returnStatement.setStatuesCode(stateCode);
        returnStatement.setStatusLabel(labelCode);
        ResponseData responseData = new ResponseData();
        returnStatement.setResponseData(responseData);
        return returnStatement;

    }

    public ReturnStatement prepareSuccess(String stateCode, String labelCode, boolean auth, List data) {
        ResponseData responseData = new ResponseData();
        responseData.setAuth(auth);
        responseData.setData(data);
        returnStatement.setStatuesCode(stateCode);
        returnStatement.setStatusLabel(labelCode);
        returnStatement.setResponseData(responseData);

        return returnStatement;
    }
}
