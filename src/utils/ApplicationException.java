/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author juan
 */
public class ApplicationException extends Exception {

    private String code;
    private String technicalMessage;

    public ApplicationException(Throwable cause) {
        super();
        this.code = "0";
        this.technicalMessage = cause.getMessage();
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
        this.code = "0";
        this.technicalMessage = cause.getMessage();
    }

    public ApplicationException(String message, String technicalMessage) {
        super(message);
        this.code = "0";
        this.technicalMessage = technicalMessage;
    }

    public ApplicationException(String code, String message, String technicalMessage) {
        super(message);
        this.code = code;
        this.technicalMessage = technicalMessage;
    }

    public ApplicationException(String code, String message, String technicalMessage, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.technicalMessage = technicalMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the technicalMessage
     */
    public String getTechnicalMessage() {
        return technicalMessage;
    }

    /**
     * @param technicalMessage the technicalMessage to set
     */
    public void setTechnicalMessage(String technicalMessage) {
        this.technicalMessage = technicalMessage;
    }

    public String getFullMessage() {
        String retMessage = this.getMessage();

        if (!(this.technicalMessage.isEmpty() || this.technicalMessage.isBlank())) {
            retMessage = String.format("%s %s %s %s %s", retMessage, System.lineSeparator(), "-".repeat(60), System.lineSeparator(), this.technicalMessage);
        }

        return retMessage;
    }
}
