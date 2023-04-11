package org.medical.hub.mailAttachment.exceptions;

public class AttachmentDoesNotExistException extends RuntimeException{

    public AttachmentDoesNotExistException(String message) {
        super(message);
    }
}
