package com.Aris.Esd_DocumentMov.Service.api;

import com.Aris.Esd_DocumentMov.Service.internal.search.*;
import com.Aris.Esd_DocumentMov.Service.internalService.DocumentMovSearchServiceInternal;
import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;
import com.Aris.Esd_DocumentMov.db.repo.RepoDocumentMov;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/searchServices")
public class DocumentMocSearchServices {

    private Logger logger = LoggerFactory.getLogger("DocumentMocSearchServices");
    @Autowired
    DocumentMovSearchServiceInternal documentMovSearchServiceInternal;

    @Autowired
    RepoDocumentMov repoDocumentMov;

    @GetMapping("/getDocMovByIdDoc/{idDoc}")
    public ResponseSearchListDocumentMov getDocMovByIdDocument(@PathVariable("idDoc") long idDoc){
        logger.info("esd_DocumentMov_idDocument->search->request : {}",idDoc);
        return documentMovSearchServiceInternal.getDocMovByIdDoc(idDoc);
    }

    @GetMapping("/getDocMovByIdEmpTo/{idEmpTo}")
    public ResponseSearchListDocumentMov getDocMovByIdEmpTo(@PathVariable("idEmpTo") long idEmpTo){
        logger.info("esd_DocumentMov_IdEmployeeToo->search->request : {}",idEmpTo);
        return documentMovSearchServiceInternal.getDocMovByIdEmpTo(idEmpTo);
    }

    @GetMapping("/getDocMovByIdEmpFrom/{idEmpFrom}")
    public ResponseSearchListDocumentMov getDocMovByIdEmpFrom(@PathVariable("idEmpFrom") long idEmpFrom){
        logger.info("esd_DocumentMov_idEmployeeFrom->search->request : {}",idEmpFrom);
        return documentMovSearchServiceInternal.getDocMovByIdEmpFrom(idEmpFrom);
    }

    @GetMapping("/getDocMovByIsAccepted/{isAccepted}")
    public ResponseSearchDocumentMov getDocMovByIsAccepted(@PathVariable("isAccepted") int isAccepted){
        logger.info("esd_DocumentMov_IsAccepted->search->request : {}",isAccepted);
        return documentMovSearchServiceInternal.getDocMovByIsAccepted(isAccepted);
    }

    @GetMapping("/getDocMovByIdDocMov/{idDocMov}")
    public ResponseSearchDocumentMov getDocMovByIdDocMov(@PathVariable("idDocMov") long idDocMov){
        logger.info("esd_DocumentMov_idDocumentMov->search->request : {}",idDocMov);
        return documentMovSearchServiceInternal.getDocMovByIdDocMov(idDocMov);
    }

    @GetMapping("/getDocMovByFinishDate/{finishDate}")
    public ResponseSearchListDocumentMov getDocMovByFinishDate(@PathVariable("finishDate") long finishDate){
        logger.info("esd_DocumentMov_finishDate->search->request : {}",finishDate);
        return documentMovSearchServiceInternal.getDocMovByFinishDate(finishDate);
    }

    @GetMapping("/getDocMovByIsMesul/{isMesul}")
    public ResponseSearchListDocumentMov getDocMovByIsMesul(@PathVariable("isMesul") int isMesul){
        logger.info("esd_DocumentMov_isMesul->search->request : {}",isMesul);
        return documentMovSearchServiceInternal.getDocMovByIsMesul(isMesul);
    }

    @GetMapping("/getDocMovByIdDocByIsActive/{idDoc}")
    public ResponseSearchListDocumentMov getDocMovByIdDocByIsActive(@PathVariable("idDoc") long idDoc){
        logger.info("esd_DocumentMov_idDocAndIsVisible->search->request : {}",idDoc);
        return documentMovSearchServiceInternal.getDocMovByidDocByIsActive(idDoc);
    }
    @GetMapping("/documentMov/all")
    public List<DocumentMov> getStudents(){
        Iterator<DocumentMov> iterator= repoDocumentMov.findAll().iterator();
        List<DocumentMov> students=new ArrayList<>();
        while(iterator.hasNext()){
            students.add(iterator.next());
        }
        return students;
    }


}
