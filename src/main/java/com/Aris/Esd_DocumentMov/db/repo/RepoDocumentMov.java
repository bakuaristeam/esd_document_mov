package com.Aris.Esd_DocumentMov.db.repo;

import com.Aris.Esd_DocumentMov.db.entities.DocumentMov;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoDocumentMov extends CrudRepository<DocumentMov,Long> {

    DocumentMov findByIdDocumentMovAndIsActive(long idDocMov,int isActive);

    DocumentMov findByIdDocumentMovAndIsDeleted(long idDocMov,int isDelete);

//    List<DocumentMov> findByIdDocumentAndIsActive(long idDoc,int isActive);
    List<DocumentMov> findByIdDocumentAndIsDeleted(long idDoc,int isDelete);

    List<DocumentMov> findByIdEmployeeFromAndIsActive(long idEmpFrom,int isActive);
    List<DocumentMov> findByIdEmployeeToAndIsActiveOrderByIdDocumentDesc(long idEmpTo,int isActive);
    DocumentMov findByIsAcceptedAndIsActive(int isAccepted,int isActive);
    List<DocumentMov>findByFinishDateAndIsActive(long finishDate,int isActive);

    List<DocumentMov>findByIsMesulAndIsActive(int isMesul,int isActive);

    DocumentMov findByIdDocumentAndIsActiveAndIdEmployeeFrom(long idDocument,int isActive,long employeeFrom);

    DocumentMov findByIdDocumentMovAndIsActiveAndIsDeleted(long idDocMov,int isActive,int isDelete);

}
