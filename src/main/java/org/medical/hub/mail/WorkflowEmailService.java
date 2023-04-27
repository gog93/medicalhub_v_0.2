package org.medical.hub.mail;

import java.text.ParseException;
import java.util.Optional;
import java.util.UUID;

public interface WorkflowEmailService {

    /**
     * Save the workflow emails
     *
     * @param workflowId
     * @param request
     * @throws ParseException
     */
    void save(Long workflowId, CreateMailRequest request, UUID uuid) throws ParseException;

    /**
     * Get the mail of workflow
     *
     * @param workflowId
     * @param mailId
     * @return
     */
    UserEmails findMailById(Long workflowId, Long mailId);

    /**
     * Update the workflow emails
     *
     * @param workflowId
     * @param request
     * @throws ParseException
     */
    void update(Long workflowId, Long mailId, CreateMailRequest request, UUID uuid) throws ParseException;

    /**
     * Delete the workflow mail details
     *
     * @param workflowId
     * @param mailId
     * @return
     */
    boolean delete(Long workflowId, Long mailId);

    Optional<UserEmails> findById(Long userEmailId);
}
