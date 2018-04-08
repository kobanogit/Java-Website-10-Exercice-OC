package com.subtitlor.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.subtitlor.beans.BeanException;
import com.subtitlor.beans.File;

public class FileDaoImpl implements FileDao {
    private DaoFactory daoFactory;

    FileDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouterFile(File film) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?, ?);");
//            preparedStatement.setString(1, utilisateur.getNom());
//            preparedStatement.setString(2, utilisateur.getPrenom());

            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }

    }

    @Override
    public List<File> listerFiles() throws DaoException {
        List<File> films = new ArrayList<File>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT nom, prenom FROM noms;");

            while (resultat.next()) {
//                String nom = resultat.getString("nom");
//                String prenom = resultat.getString("prenom");
            			String titre = "";
//
                File film = new File();
                film.setTitle(titre);
//                utilisateur.setNom(nom);
//                utilisateur.setPrenom(prenom);
//
//                films.add(utilisateur);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        } catch (BeanException e) {
            throw new DaoException("Les données de la base sont invalides");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return films;
    }

}