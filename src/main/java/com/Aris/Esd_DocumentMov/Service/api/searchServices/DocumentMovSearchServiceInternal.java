package com.Aris.Esd_DocumentMov.Service.api.searchServices;

import com.Aris.Esd_DocumentMov.Service.api.searchServices.internal.ResponseDocCount;
import com.Aris.Esd_DocumentMov.Service.api.searchServices.internal.ResponseSearchDocumentMov;
import com.Aris.Esd_DocumentMov.Service.api.searchServices.internal.ResponseSearchListDocumentMov;
import com.Aris.Esd_DocumentMov.Service.internal.ResponseForDocSend;
import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;
import com.Aris.Esd_DocumentMov.db.repo.RepoDocumentMov;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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


    public ResponseSearchDocumentMov getDocMovByIdDocMovByIsActiveByIsDelete(long idDocMov,int isRead){
        DocumentMov documentMov=repoDocumentMov.findByIdDocumentMovAndIsActiveAndIsDeleted(idDocMov,1,0);
        ResponseSearchDocumentMov response = new ResponseSearchDocumentMov();
        try {
            if (documentMov != null) {
                documentMov.setIsRead(isRead);
                response.setServerCode(200);
                response.setDocumentMov(documentMov);
                repoDocumentMov.save(documentMov);
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




//
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

    public ResponseSearchListDocumentMov getDocMovByIdDoc(long idDoc){
        ResponseSearchListDocumentMov response = new ResponseSearchListDocumentMov();
        try {
            List<DocumentMov> listOfidDocument= repoDocumentMov.findByIdDocumentAndIsDeleted(idDoc,0);
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



    public ResponseSearchListDocumentMov getDocMovByIdDocAndByIdParent(long idDoc,long parentId){
        ResponseSearchListDocumentMov response = new ResponseSearchListDocumentMov();
        try {
            List<DocumentMov> listOfDocumentMov=repoDocumentMov.findByIdDocumentAndParentIdAndIsDeleted(idDoc,parentId,0);
            if (listOfDocumentMov != null&&listOfDocumentMov.size()>0) {
                response.setListOfDocumentMov(listOfDocumentMov);
                response.setServerCode(200);
                response.setServerMessage("DocumentMov  found");
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



    public ResponseSearchListDocumentMov getDocMovByDocumentAndIdEmployeeToAndIsActiveAndIsDeleted(long idDoc,long idEmpTo){
        ResponseSearchListDocumentMov response = new ResponseSearchListDocumentMov();
        try {
            List<DocumentMov> listOfDocumentMov=repoDocumentMov.findByIdDocumentAndIdEmployeeToAndIsActiveAndIsDeleted(idDoc,idEmpTo,1,0);
            if (listOfDocumentMov != null&&listOfDocumentMov.size()>0) {
                response.setServerCode(200);
                response.setListOfDocumentMov(listOfDocumentMov);
                response.setServerMessage("DocumentMov  found");
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


    public ResponseSearchListDocumentMov getDocMovByIdDocAndIsActiveAndIsDelete(long idDoc){
        ResponseSearchListDocumentMov response = new ResponseSearchListDocumentMov();
        try {
            List<DocumentMov> listOfidDocument= repoDocumentMov.findByIdDocumentAndIsActiveAndIsDeleted(idDoc,1,0);
            if (listOfidDocument != null&&listOfidDocument.size()>0) {
                response.setListOfDocumentMov(listOfidDocument);
                response.setServerCode(200);
                logger.info("SearchDocumentMov response : {}", response.toString());
                response.setServerMessage("DocumentMov found");
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




    public ResponseSearchDocumentMov setDocMovAccepted(long finishDate,long idDocMov){
        DocumentMov documentMov=repoDocumentMov.findByIdDocumentMov(idDocMov);
        ResponseSearchDocumentMov response = new ResponseSearchDocumentMov();
        try {
            if (documentMov != null) {
                documentMov.setFinishDate(finishDate);
                documentMov.setIsActive(0);
                documentMov.setIsFinished(1);
                repoDocumentMov.save(documentMov);

                List<DocumentMov> listOfDocMove = repoDocumentMov.findByIdDocumentAndIsActiveAndIsDeleted(documentMov.getIdDocument(), 1, 0);
                for (DocumentMov docMove :
                        listOfDocMove) {
                    docMove.setIsActive(0);
                    repoDocumentMov.save(docMove);
                }

                response.setServerCode(200);
                response.setDocumentMov(documentMov);
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

    public ResponseDocCount getDocCount(long idEmp){
        ResponseDocCount responseDocCount=new ResponseDocCount();

        try {
            responseDocCount.setMySendDocCount(repoDocumentMov.countByIdEmployeeFromAndIsActiveAndIsDeleted(idEmp,1,0));
            responseDocCount.setMyDocsCount(repoDocumentMov.countByIdEmployeeToAndIsActiveAndIsDeleted(idEmp,1,0));

            responseDocCount.setServerCode(200);
            responseDocCount.setServerMessage("Doc Count");
            logger.info("Doc Count idEmpFrom count :{} idEmpTo :{} ",responseDocCount.getMySendDocCount(),responseDocCount.getMySendDocCount());

        }catch (Exception e){
            responseDocCount.setServerCode(100);
            responseDocCount.setServerMessage("error");
            logger.error("error :",e);
        }
        return responseDocCount;

    }



}
