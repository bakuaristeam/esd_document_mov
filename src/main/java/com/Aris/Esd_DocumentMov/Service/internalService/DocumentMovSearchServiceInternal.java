package com.Aris.Esd_DocumentMov.Service.internalService;

import com.Aris.Esd_DocumentMov.Service.internal.search.*;
import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;
import com.Aris.Esd_DocumentMov.db.repo.RepoDocumentMov;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DocumentMovSearchServiceInternal {

    @Autowired
    RepoDocumentMov repoDocumentMov;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResponseSearchListDocumentMov getDocMovByIdEmpFrom(long idEmpFrom){
        List<DocumentMov> listOfidDocument= repoDocumentMov.findByIdEmployeeFromAndIsActive(idEmpFrom,1);
        ResponseSearchListDocumentMov response = new ResponseSearchListDocumentMov();
        try{
        if (listOfidDocument!=null&&listOfidDocument.size()>0){
            response.setListOfDocumentMov(listOfidDocument);
            response.setServerCode(200);
            response.setServerMessage("DocumentMov found");
            logger.info("SearchEmployeeFrom response : {}",response.toString());
        }else {
            response.setListOfDocumentMov(null);
            response.setServerCode(220);
            response.setServerMessage("DocumentMov not found");
        }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }


    public ResponseSearchListDocumentMov getDocMovByIdEmpTo(long idEmpTo){
        List<DocumentMov> listOfidDocument= repoDocumentMov.findByIdEmployeeToAndIsActiveOrderByIdDocumentDesc(idEmpTo,1);
        ResponseSearchListDocumentMov response = new ResponseSearchListDocumentMov();
        try {
            if (listOfidDocument != null&&listOfidDocument.size()>0) {
                response.setListOfDocumentMov(listOfidDocument);
                response.setServerCode(200);
                response.setServerMessage("DocumentMovFound found");
                logger.info("SearchEmployeeTo response : {}", response.toString());
            } else {
                response.setListOfDocumentMov(null);
                response.setServerCode(220);
                response.setServerMessage("DocumentMov  not found");
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }


    public ResponseSearchListDocumentMov getDocMovByIdDoc(long idDoc){
        List<DocumentMov> listOfidDocument= repoDocumentMov.findByIdDocumentAndIsActive(idDoc,1);
        ResponseSearchListDocumentMov response = new ResponseSearchListDocumentMov();
        try {
            if (listOfidDocument != null&&listOfidDocument.size()>0) {
                response.setListOfDocumentMov(listOfidDocument);
                response.setServerCode(200);
                response.setServerMessage("DocumentMov found");
                logger.info("SearchDocumentMov response : {}", response.toString());
            } else {
                response.setListOfDocumentMov(null);
                response.setServerCode(220);
                response.setServerMessage("DocumentMov not found");
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }


    public ResponseSearchDocumentMov getDocMovByIsAccepted(int isAccepted){
        DocumentMov documentMov= repoDocumentMov.findByIsAcceptedAndIsActive(isAccepted,1);
        ResponseSearchDocumentMov response = new ResponseSearchDocumentMov();
        try{
        if (documentMov!=null){
            response.setDocumentMov(documentMov);
            response.setServerCode(200);
            response.setServerMessage("DocumentMov found");
            logger.info("SearchIsAccepted response : {}",response.toString());
        }else {
            response.setDocumentMov(null);
            response.setServerCode(220);
            response.setServerMessage("DocumentMov not found");
        }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }

    public ResponseSearchDocumentMov getDocMovByIdDocMov(long idDocMov){
            DocumentMov documentMov=repoDocumentMov.findByIdDocumentMovAndIsActive(idDocMov,1);
        ResponseSearchDocumentMov response = new ResponseSearchDocumentMov();
        try {
            if (documentMov != null) {
                response.setDocumentMov(documentMov);
                response.setServerCode(200);
                response.setServerMessage("DocumentMov found");
                logger.info("SearchDocumentMov response : {}", response.toString());
            } else {
                response.setDocumentMov(null);
                response.setServerCode(220);
                response.setServerMessage("DocumentMov not found");
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }

    public ResponseSearchListDocumentMov getDocMovByFinishDate(long finishDate){
        List<DocumentMov> listOfdocumentMov=repoDocumentMov.findByFinishDateAndIsActive(finishDate,1);
        ResponseSearchListDocumentMov response = new ResponseSearchListDocumentMov();
        try {
            if (listOfdocumentMov != null&&listOfdocumentMov.size()>0) {
                response.setListOfDocumentMov(listOfdocumentMov);
                response.setServerCode(200);
                response.setServerMessage("DocumentMov found");
            } else {
                response.setListOfDocumentMov(null);
                response.setServerCode(220);
                response.setServerMessage("DocumentMov not found");
                logger.info("SearchDocumentMov response : {}", response.toString());
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }

    public ResponseSearchListDocumentMov getDocMovByIsMesul(int isMesul){
        List<DocumentMov> listOfdocumentMov=repoDocumentMov.findByIsMesulAndIsActive(isMesul,1);
        ResponseSearchListDocumentMov  response = new ResponseSearchListDocumentMov();
        try{
        if (listOfdocumentMov!=null&&listOfdocumentMov.size()>0){
            response.setListOfDocumentMov(listOfdocumentMov);
            response.setServerMessage("DocumentMov found");
            response.setServerCode(200);
            logger.info("SearchDocumentMov response : {}",response.toString());
        }else {
            response.setListOfDocumentMov(null);
            response.setServerCode(220);
            response.setServerMessage("DocumentMov not found");
        }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }


    public ResponseSearchListDocumentMov getDocMovByidDocByIsActive(long idDoc) {
        List<DocumentMov> listOfdocumentMov = repoDocumentMov.findByIdDocumentAndIsActive(idDoc, 1);
        ResponseSearchListDocumentMov response = new ResponseSearchListDocumentMov();
        try {
            if (listOfdocumentMov != null && listOfdocumentMov.size() > 0) {
                response.setListOfDocumentMov(listOfdocumentMov);
                response.setServerMessage("DocumentMov found");
                response.setServerCode(200);
                logger.info("SearchDocumentMov response : {}", response.toString());
            } else {
                response.setServerCode(220);
                response.setListOfDocumentMov(null);
                response.setServerMessage("DocumentMov not found");
            }
        }catch (Exception e){
            response.setServerCode(100);
            response.setServerMessage("error"+e);
            logger.info("error",e);
        }
        return response;
    }



}
