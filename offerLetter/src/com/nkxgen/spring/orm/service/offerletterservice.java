/*
 * package com.nkxgen.spring.orm.service;
 * 
 * import javax.transaction.Transactional;
 * 
 * public class offerletterservice {
 * 
 * @Override public List<String> getAllDocuments() { return candidateDAO.getAllDocuments(); }
 * 
 * @Override
 * 
 * @Transactional public void updateEmploymentOfferDocuments(Eofr employmentOfferModel, OfferModel of) { int eofrId =
 * employmentOfferModel.getEofr_cand_id(); List<String> documentsToBring = of.getDocuments(); List<Inductiondocuments>
 * inductionDocuments = candidateDAO.getInductionDocuments();
 * 
 * int docIndex = 1; for (String document : documentsToBring) { int idtyId = findIdtyIdByTitle(inductionDocuments,
 * document); empoffdocuments documentModel = new empoffdocuments(eofrId, docIndex, idtyId);
 * candidateDAO.saveEmploymentOfferDocument(documentModel); docIndex++; } }
 * 
 * private int findIdtyIdByTitle(List<Inductiondocuments> inductionDocuments, String title) { for (Inductiondocuments
 * document : inductionDocuments) { if (document.getIdtyTitle().equalsIgnoreCase(title)) { return document.getIdtyId();
 * } } return 0; // Return an appropriate default value if the document title is not found } }
 */