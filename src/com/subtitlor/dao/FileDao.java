package com.subtitlor.dao;

import java.util.List;

import com.subtitlor.beans.File;

public interface FileDao {
    void ajouterFile( File file ) throws DaoException;
    List<File> listerFiles() throws DaoException;
}