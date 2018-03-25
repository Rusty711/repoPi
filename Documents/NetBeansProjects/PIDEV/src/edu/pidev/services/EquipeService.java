/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.services;

import edu.pidev.entities.Equipe;
import edu.pidev.entities.Joueur;
import edu.pidev.utils.BDConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rusty
 */
public class EquipeService {
        public Connection cnx;

    public EquipeService() throws SQLException {
        this.cnx = BDConn.getInstance().getConnection();
    }
    public void AjouterEquipe(Equipe e) throws SQLException
    {
        String requete="insert into Equipe(Nom,Capital,Participations,Continent,Victoires,Entraineur,ClassementFifa,MatchesCM,ButsCM,MatchWins,MatchLosses,MatchDraws,Drapeau,PhotoEquipe,LogoFederation,Groupe,Description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               PreparedStatement pst=cnx.prepareStatement(requete);
                          pst.setString(1,e.getNom());
                          pst.setString(2,e.getCapital());
                          pst.setInt(3,e.getParticipations());
                          pst.setString(4,e.getContinent());
                          pst.setInt(5,e.getVictoires());
                          pst.setString(6,e.getEntraineur());
                          pst.setInt(7,e.getClassementFifa());
                          pst.setInt(8,e.getMatchesCM());
                          pst.setInt(9,e.getButsCM());
                          pst.setInt(10,e.getMatchVictoires());
                          pst.setInt(11,e.getMatchDefaites());
                          pst.setInt(12,e.getMatchNulles());
                          pst.setString(13,e.getDrapeau());
                         
                          pst.setString(14,e.getPhotoEquipe());
                          pst.setString(15,e.getLogoFederation());
                          pst.setString(16,e.getGroupe());
                          pst.setString(17,e.getDescription());
                          
                                     pst.executeUpdate();

                          
    }
    public List<Equipe> afficherEquipe() throws SQLException
    {
          List<Equipe> l=new ArrayList();
            Statement x=cnx.createStatement();
        ResultSet res=x.executeQuery("select * from Equipe");
        while(res.next())
        {
            Equipe e=new Equipe();
                            e.setIdEquipe(res.getInt("IDEquipe"));

            e.setNom(res.getString("Nom"));
            e.setCapital(res.getString("Capital"));
            e.setParticipations(res.getInt("Participations"));
           e.setContinent(res.getString("Continent"));
           e.setVictoires(res.getInt("Victoires"));
           e.setEntraineur(res.getString("Entraineur"));
           e.setClassementFifa(res.getInt("Classementfifa"));
           e.setMatchesCM(res.getInt("MatchesCM"));
           e.setButsCM(res.getInt("ButsCM"));
           e.setMatchVictoires(res.getInt("MatchWins"));
           e.setMatchDefaites(res.getInt("MatchLosses"));
           e.setMatchNulles(res.getInt("MatchDraws"));
           e.setDrapeau(res.getString("Drapeau"));
           e.setPhotoEquipe(res.getString("PhotoEquipe"));
           e.setLogoFederation(res.getString("LogoFederation"));
           e.setGroupe(res.getString("Groupe"));
           e.setDescription(res.getString("Description"));
           l.add(e);
        }
        return l;
    }
    public void supprimerEquipe(String nom) throws SQLException
    {
                    String requet="Delete from Equipe where nom=?";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setString(1,nom);
           pst.executeUpdate();
    }
    public void modifierEquipe(Equipe e) throws SQLException
    {
        String requete="Update equipe set Nom=?,Capital=?,Participations=?,Continent=?,Victoires=?,Entraineur=?,Classementfifa=?,MatchesCM=?,ButsCM=?,MatchWins=?,MatchLosses=?,MatchDraws=?,Drapeau=?,PhotoEquipe=?,LogoFederation=?,Groupe=?,Description=? where IDEquipe=?";
          PreparedStatement pst=cnx.prepareStatement(requete);
                          pst.setString(1,e.getNom());
                          pst.setString(2,e.getCapital());
                          pst.setInt(3,e.getParticipations());
                          pst.setString(4,e.getContinent());
                          pst.setInt(5,e.getVictoires());
                          pst.setString(6,e.getEntraineur());
                          pst.setInt(7,e.getClassementFifa());
                          pst.setInt(8,e.getMatchesCM());
                          pst.setInt(9,e.getButsCM());
                          pst.setInt(10,e.getMatchVictoires());
                          pst.setInt(11,e.getMatchDefaites());
                          pst.setInt(12,e.getMatchNulles());
                          pst.setString(13,e.getDrapeau());
                         
                          pst.setString(14,e.getPhotoEquipe());
                          pst.setString(15,e.getLogoFederation());
                          pst.setString(16,e.getGroupe());
                          pst.setString(17,e.getDescription());
                          pst.setInt(18,e.getIdEquipe());
                          
                                     pst.executeUpdate();
    }
    public Equipe rechercherparNom(String nom) throws SQLException
    {
        String requet="select * from equipe nom=?";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setString(1,nom);
            ResultSet res=pst.executeQuery();
                            Equipe e=new Equipe();

            while (res.next())
            {
                e.setIdEquipe(res.getInt("IDEquipe"));
            
            e.setNom(res.getString("Nom"));
            e.setCapital(res.getString("Capital"));
            e.setParticipations(res.getInt("Participations"));
           e.setContinent(res.getString("Continent"));
           e.setVictoires(res.getInt("Victoires"));
           e.setEntraineur(res.getString("Entraineur"));
           e.setClassementFifa(res.getInt("Classementfifa"));
           e.setMatchesCM(res.getInt("MatchesCM"));
           e.setButsCM(res.getInt("ButsCM"));
           e.setMatchVictoires(res.getInt("MatchWins"));
           e.setMatchDefaites(res.getInt("MatchLosses"));
           e.setMatchNulles(res.getInt("MatchDraws"));
           e.setDrapeau(res.getString("Drapeau"));
           e.setPhotoEquipe(res.getString("PhotoEquipe"));
           e.setLogoFederation(res.getString("LogoFederation"));
           e.setGroupe(res.getString("Groupe"));
           e.setDescription(res.getString("Description"));
            }
            
           return e;
    }
    public int countJoueurs(int id) throws SQLException
    {
        String requet="select count(*) as num from joueur where ID_Equipe=?";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setInt(1,id);
           ResultSet d=pst.executeQuery();
           int num=0;
           while (d.next())
           {
               num=d.getInt("num");
           }
           return num;
    }
    public List<Equipe> EquipeParGroupe(String Groupe) throws SQLException
    {
       List<Equipe> l=new ArrayList();
            Statement x=cnx.createStatement();
       String requete=("select * from Equipe where groupe=?");
                  PreparedStatement pst=cnx.prepareStatement(requete);
              pst.setString(1, Groupe);
              ResultSet res=pst.executeQuery();
                  

        
        while(res.next())
        {
            Equipe e=new Equipe();
                            e.setIdEquipe(res.getInt("IDEquipe"));

            e.setNom(res.getString("Nom"));
            e.setCapital(res.getString("Capital"));
            e.setParticipations(res.getInt("Participations"));
           e.setContinent(res.getString("Continent"));
           e.setVictoires(res.getInt("Victoires"));
           e.setEntraineur(res.getString("Entraineur"));
           e.setClassementFifa(res.getInt("Classementfifa"));
           e.setMatchesCM(res.getInt("MatchesCM"));
           e.setButsCM(res.getInt("ButsCM"));
           e.setMatchVictoires(res.getInt("MatchWins"));
           e.setMatchDefaites(res.getInt("MatchLosses"));
           e.setMatchNulles(res.getInt("MatchDraws"));
           e.setDrapeau(res.getString("Drapeau"));
           e.setPhotoEquipe(res.getString("PhotoEquipe"));
           e.setLogoFederation(res.getString("LogoFederation"));
           e.setGroupe(res.getString("Groupe"));
           e.setDescription(res.getString("Description"));
           l.add(e);
        }
        return l; 
    }

}
