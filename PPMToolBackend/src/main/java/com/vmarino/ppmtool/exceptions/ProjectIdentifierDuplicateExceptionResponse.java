package com.vmarino.ppmtool.exceptions;

public class ProjectIdentifierDuplicateExceptionResponse {

    private String projectIdentifier;

    public ProjectIdentifierDuplicateExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
