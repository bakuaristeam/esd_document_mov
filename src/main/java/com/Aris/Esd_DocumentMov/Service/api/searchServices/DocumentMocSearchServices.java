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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public ResponseSearchListDocumentMov getDocMovByIdDocumentIsDelete(@PathVariable("idDoc") long idDoc){
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


    @GetMapping("/setDocReadStatus/{idDocMov}/{isRead}")
    public ResponseSearchDocumentMov setDocReadStatus(@PathVariable("idDocMov") long idDocMov,
                                                      @PathVariable("isRead")int isRead){
        logger.info("esd_DocumentMov_idDocumentMovIsActiveIsDelete->search->request : {}",idDocMov,isRead);
        return documentMovSearchServiceInternal.getDocMovByIdDocMovByIsActiveByIsDelete(idDocMov,isRead);
    }


        @GetMapping("/getDocMovByIdDocByIsActive/{idDoc}")
    public ResponseSearchListDocumentMov getDocMovByIdDocByIsActive(@PathVariable("idDoc") long idDoc){
        logger.info("esd_DocumentMov_idDocAndIsVisible->search->request : {}",idDoc);
        return documentMovSearchServiceInternal.getDocMovByidDocByIsActive(idDoc);
    }

    //docTrayektoriya ucun
    @GetMapping("/getDocMovByIdDocAndByParentId/{idDoc}/{parentId}")
    public ResponseSearchListDocumentMov getDocMovByIdDocAndByIdParent(@PathVariable("idDoc") long idDoc,
                                                                   @PathVariable("parentId")long parentId){

        logger.info("esd_DocumentMov_idDocAndIsVisible->search->request : {}",idDoc+parentId);
        return documentMovSearchServiceInternal.getDocMovByIdDocAndByIdParent(idDoc,parentId);
    }



    //docCombine
    @GetMapping("/getDocMovByIdDocAndIsActiveAndIsDelete/{idDoc}")
    public ResponseSearchListDocumentMov getDocMovByIdDocAndIsActiveAndIsDelete(@PathVariable("idDoc") long idDoc){
        logger.info("esd_DocumentMov_idDocAndIsVisible->search->request : {}",idDoc);
        return documentMovSearchServiceInternal.getDocMovByIdDocAndIsActiveAndIsDelete(idDoc);
    }


    @GetMapping("/getDocMovByIdDocAndIsActiveAndIsDelete/{idDoc}/{idEmpTo}")
    public ResponseSearchListDocumentMov getDocMovByIdDocAndIsActiveAndIsDelete(@PathVariable("idDoc") long idDoc,
                                                                                @PathVariable("idEmpTo")long idEmpTo){
        logger.info("esd_DocumentMov_IdDocAndIsActiveAndIsDelete->search->request : {}",idDoc);
        return documentMovSearchServiceInternal.getDocMovByDocumentAndIdEmployeeToAndIsActiveAndIsDeleted(idDoc,idEmpTo);
    }

    @GetMapping("/setDocMovAccepted/{idDocMov}/{finishedDate}")
    public ResponseSearchDocumentMov setDocMovAccepted(@PathVariable("idDocMov") long idDocMov,
                                                      @PathVariable("finishedDate")long finishDate){
        logger.info("esd_DocumentMov /setDocMovAccepted idDocMov {},finishDate :{}",idDocMov,finishDate);
        return documentMovSearchServiceInternal.setDocMovAccepted(idDocMov,finishDate);
    }

    @GetMapping("/getDocCount/{idEmp}")
    public ResponseDocCount getCount(@PathVariable("idEmp")long idEmp){
        return documentMovSearchServiceInternal.getDocCount(idEmp);
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

    //-----------------------------Deyisiklikler-------------------------------------------------



    @GetMapping("/getDocMovFinishedDoc/{idEmpTo}")
    public ResponseSearchListDocumentMov getDocMovByFinished(@PathVariable("idEmpTo") long idEmpTo){
        logger.info("esd_DocumentMov_IdEmployeeToo->search->request : {}",idEmpTo);
        return documentMovSearchServiceInternal.getDocMovByIdEmpToFinishedDoc(idEmpTo);
    }


    @GetMapping("/getDocMov/{idDocMov}")
    public ResponseSearchDocumentMov setDocMovAccepted(@PathVariable("idDocMov") long idDocMov){
        logger.info("esd_DocumentMov idDocMov {}",idDocMov);
        return documentMovSearchServiceInternal.getDocMov(idDocMov);
    }


    @GetMapping("/getDocMovByAllDocIdEmpTo/{idEmpTo}")
    public ResponseSearchListDocumentMov getDocMovAllByIdEmpTo(@PathVariable("idEmpTo") long idEmpTo){
        logger.info("esd_DocumentMov_IdEmployeeToo->search->request : {}",idEmpTo);
        return documentMovSearchServiceInternal.getDocMovAllDocByIdEmpTo(idEmpTo);
    }

}
