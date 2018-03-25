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
public class JoueurService {
    public Connection cnx;

    public JoueurService() throws SQLException {
        this.cnx = BDConn.getInstance().getConnection();
    }
        public void ajouterJoueur(Joueur j) throws SQLException
    {
               String requet="Insert into Joueur(nom,prenom,numero,Datedenaissance,LieuNaissance,Taille,Poids,Nationalite,Poste1,Cout,Buts,Selections,ID_Equipe,Participations,Imagejoueur1,ImageJoueur2,ImageJoueur3,ButsMarque,Description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setString(1,j.getNom());
           pst.setString(2,j.getPrenom());
           pst.setInt(3,j.getNumero());
           pst.setDate(4,j.getDateNaissance());
           pst.setString(5,j.getLieuNaissance());
           pst.setInt(6,j.getTaille());
           pst.setInt(7,j.getPoids());
           pst.setString(8,j.getNationalite());
           pst.setString(9,j.getPoste1());
           pst.setInt(10,j.getCout());
           pst.setInt(11,j.getButs());
           pst.setInt(12,j.getSelections());
           pst.setInt(13,j.getIdEquipe().getIdEquipe());
           pst.setInt(14,j.getParticipations());
        
           pst.setString(15,j.getImageJoueur1());
           pst.setString(16,j.getImageJoueur2());
           pst.setString(17,j.getImageJoueur3());
           pst.setInt(18,j.getButsMarque());
           pst.setString(19,j.getDescription());
        
           pst.executeUpdate();
    }
        public List<Joueur> afficherJoueurs() throws SQLException
       {
           List<Joueur> l=new ArrayList();
            Statement x=cnx.createStatement();
        ResultSet res=x.executeQuery("select * from Joueur");
        while (res.next())
        {
            Joueur j=new Joueur();
            j.setNom(res.getString("nom"));
            j.setPrenom(res.getString("Prenom"));
            j.setNumero(res.getInt("Numero"));
            j.setLieuNaissance(res.getString("LieuNaissance"));
            j.setDateNaissance(res.getDate("Datedenaissance"));
            j.setTaille(res.getInt("Taille"));
            j.setPoids(res.getInt("Poids"));
            j.setNationalite(res.getString("Nationalite"));
            j.setPoste1(res.getString("Poste1"));
            j.setCout(res.getInt("Cout"));
            j.setButs(res.getInt("Buts"));
            j.setSelections(res.getInt("Selections"));
            j.setParticipations(res.getInt("Participations"));
            j.setPied(res.getString("Pied"));
            j.setImageJoueur1(res.getString("ImageJoueur1"));
            j.setImageJoueur2(res.getString("ImageJoueur2"));
            j.setImageJoueur3(res.getString("ImageJoueur3"));
j.setDescription(res.getString("Description"));
                Statement d=cnx.createStatement();
        ResultSet p= d.executeQuery("select * from equipe where IDEquipe="+res.getInt("ID_Equipe"));
        Equipe e=new Equipe();
while (p.next())
{
    e.setNom(p.getString("Nom"));
            e.setCapital(p.getString("Capital"));
            e.setParticipations(p.getInt("Participations"));
           e.setContinent(p.getString("Continent"));
           e.setVictoires(p.getInt("Victoires"));
           e.setEntraineur(p.getString("Entraineur"));
           e.setClassementFifa(p.getInt("Classementfifa"));
           e.setMatchesCM(p.getInt("MatchesCM"));
           e.setButsCM(p.getInt("ButsCM"));
           e.setMatchVictoires(p.getInt("MatchWins"));
           e.setMatchDefaites(p.getInt("MatchLosses"));
           e.setMatchNulles(p.getInt("MatchDraws"));
           e.setDrapeau(p.getString("Drapeau"));
           e.setPhotoEquipe(p.getString("PhotoEquipe"));
           e.setLogoFederation(p.getString("LogoFederation"));
           e.setGroupe(p.getString("Groupe"));
           e.setDescription(p.getString("Description"));
}

        j.setIdEquipe(e);
            l.add(j);
            
        }
        return l;
       }
       public void supprimerJoueur(int id) throws SQLException
       {
                      String requet="Delete from joueur where IDJoueur=?";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setInt(1,id);
           pst.executeUpdate();
       }
       public void modifierJoueur(Joueur j) throws SQLException
       {
           String requete="Update Joueur set nom=?,prenom=?,numero=?,Datedenaissance=?,LieuNaissance=?,Taille=?,Poids=?,Nationalite=?,Poste1=?,Cout=?,Buts=?,Selections=?,ID_Equipe=?,Participations=?,Pied=?,ImageJoueur1=?,ImageJoueur2=?,ImageJoueur3=?,ButsMarque=?,Description=? where IDJoueur=?";
                      PreparedStatement pst=cnx.prepareStatement(requete);
                              pst.setString(1,j.getNom());
           pst.setString(2,j.getPrenom());
           pst.setInt(3,j.getNumero());
           pst.setDate(4,j.getDateNaissance());
           pst.setString(5,j.getLieuNaissance());
           pst.setInt(6,j.getTaille());
           pst.setInt(7,j.getPoids());
           pst.setString(8,j.getNationalite());
           pst.setString(9,j.getPoste1());
           pst.setInt(10,j.getCout());
           pst.setInt(11,j.getButs());
           pst.setInt(12,j.getSelections());
           pst.setInt(13,j.getIdEquipe().getIdEquipe());
           pst.setInt(14,j.getParticipations());
           pst.setString(15,j.getPied());
           pst.setString(16,j.getImageJoueur1());
           pst.setString(17,j.getImageJoueur2());
           pst.setString(18,j.getImageJoueur3());
           pst.setInt(19,j.getButsMarque());
           pst.setString(20,j.getDescription());
           pst.setInt(21,j.getIdJoueur());
           pst.executeUpdate();

       }
       public List<Joueur> afficherParEquipe(String nom) throws SQLException
       {
           int id=0;
             List<Equipe> ll=new ArrayList();
            Statement x=cnx.createStatement();
       String requete=("select * from Equipe where nom=?");
                  PreparedStatement pst=cnx.prepareStatement(requete);
              pst.setString(1,nom);
              ResultSet ress=pst.executeQuery();
              while (ress.next())
              {
                  id=ress.getInt("IDEquipe");
              }
              List<Joueur> l=new ArrayList();
       String requet=("select * from Joueur where ID_Equipe=?");
                  PreparedStatement pstt=cnx.prepareStatement(requet);
              pstt.setInt(1,id);
              ResultSet res=pstt.executeQuery();
               while (res.next())
              {
                   Joueur j=new Joueur();
            j.setNom(res.getString("nom"));
            j.setPrenom(res.getString("Prenom"));
            j.setNumero(res.getInt("Numero"));
            j.setLieuNaissance(res.getString("LieuNaissance"));
            j.setDateNaissance(res.getDate("Datedenaissance"));
            j.setTaille(res.getInt("Taille"));
            j.setPoids(res.getInt("Poids"));
            j.setNationalite(res.getString("Nationalite"));
            j.setPoste1(res.getString("Poste1"));
            j.setCout(res.getInt("Cout"));
            j.setButs(res.getInt("Buts"));
            j.setSelections(res.getInt("Selections"));
            j.setParticipations(res.getInt("Participations"));
            j.setPied(res.getString("Pied"));
            j.setImageJoueur1(res.getString("ImageJoueur1"));
            j.setImageJoueur2(res.getString("ImageJoueur2"));
            j.setImageJoueur3(res.getString("ImageJoueur3"));
            j.setDescription(res.getString("Description"));
                          Statement d=cnx.createStatement();
        ResultSet p= d.executeQuery("select * from equipe where IDEquipe="+res.getInt("ID_Equipe"));
        Equipe e=new Equipe();
while (p.next())
{
    e.setNom(p.getString("Nom"));
            e.setCapital(p.getString("Capital"));
            e.setParticipations(p.getInt("Participations"));
           e.setContinent(p.getString("Continent"));
           e.setVictoires(p.getInt("Victoires"));
           e.setEntraineur(p.getString("Entraineur"));
           e.setClassementFifa(p.getInt("Classementfifa"));
           e.setMatchesCM(p.getInt("MatchesCM"));
           e.setButsCM(p.getInt("ButsCM"));
           e.setMatchVictoires(p.getInt("MatchWins"));
           e.setMatchDefaites(p.getInt("MatchLosses"));
           e.setMatchNulles(p.getInt("MatchDraws"));
           e.setDrapeau(p.getString("Drapeau"));
           e.setPhotoEquipe(p.getString("PhotoEquipe"));
           e.setLogoFederation(p.getString("LogoFederation"));
           e.setGroupe(p.getString("Groupe"));
           e.setDescription(p.getString("Description"));
}
j.setIdEquipe(e);
l.add(j);
              }
               return l;
       }
       
    
}
