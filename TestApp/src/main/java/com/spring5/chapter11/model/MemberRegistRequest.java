package com.spring5.chapter11.model;

public class MemberRegistRequest {
    private String[] favoriteOs;
    private String[] favoriteTools;

    public MemberRegistRequest() {
        favoriteOs = null;
        favoriteTools = null;
    }

    public String[] getFavoriteOs() {
        return favoriteOs;
    }

    public void setFavoriteOs(String[] favoriteOs) {
        this.favoriteOs = favoriteOs;
    }

    public String[] getFavoriteTools() {
        return favoriteTools;
    }

    public void setFavoriteTools(String[] favoriteTools) {
        this.favoriteTools = favoriteTools;
    }
}
