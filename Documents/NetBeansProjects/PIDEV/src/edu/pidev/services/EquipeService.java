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
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

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
                          pst.setInt(8,e.getMatchDefaites()+e.getMatchNulles()+e.getMatchVictoires());
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
    public void supprimerEquipe(int id) throws SQLException
    {
                    String requet="Delete from Equipe where IDEquipe=?";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setInt(1,id);
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
                                           Notifications n=Notifications.create()
                    .title("Modification d'equipe")
                    .text("Modification avec Succes")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);
                    
            n.darkStyle();
            n.show();
    }
    public Equipe rechercherparId(int id) throws SQLException
    {
        String requet="select * from equipe where IDEquipe=?";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setInt(1,id);
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
    public ResultSet moyenneAge() throws SQLException
    {
                    Statement x=cnx.createStatement();
List l=new ArrayList();
        String requete="select avg(extract(year from sysdate())-extract(year from joueur.Datedenaissance)) as age,equipe.Nom as nom from joueur join equipe on joueur.ID_Equipe=equipe.IDEquipe group by ID_Equipe";
        ResultSet res=x.executeQuery(requete);
      return res;
    }
public ResultSet equipeParContinent() throws SQLException
{
     Statement x=cnx.createStatement();
List l=new ArrayList();
String requete="select sum(victoires) as somme,continent from equipe group by continent ";
ResultSet res=x.executeQuery(requete);
 return res;
}
public ResultSet equipepourcentageVictoires() throws SQLException
{
     Statement x=cnx.createStatement();
     String requete="select (MatchWins*100)/matchescm as pour,nom from equipe";
ResultSet res=x.executeQuery(requete);
return res;
}
public ResultSet moyennetaille() throws SQLException 
{
     
                    Statement x=cnx.createStatement();
List l=new ArrayList();
        String requete="select avg(taille) as taille,equipe.Nom as nom from joueur join equipe on joueur.ID_Equipe=equipe.IDEquipe group by ID_Equipe";
        ResultSet res=x.executeQuery(requete);
      return res;
    
}
public ResultSet MoyenneCout() throws SQLException
{                    Statement x=cnx.createStatement();

            String requete="select avg(cout) as cout,equipe.Nom as nom from joueur join equipe on joueur.ID_Equipe=equipe.IDEquipe group by ID_Equipe";
    ResultSet res=x.executeQuery(requete);
      return res;
}
public boolean NomExiste(String nom) throws SQLException
{
    String requete="select * from Equipe where nom=? ";
               PreparedStatement pst=cnx.prepareStatement(requete);
              pst.setString(1,nom);
              ResultSet res=pst.executeQuery();
              return res.isBeforeFirst();
            
}
public boolean classementExiste(int classement) throws SQLException
{
    String requete="select * from Equipe where ClassementFifa=? ";
               PreparedStatement pst=cnx.prepareStatement(requete);
              pst.setInt(1,classement);
              ResultSet res=pst.executeQuery();
              return res.isBeforeFirst();
            
}
public boolean EntraineurExiste(String Entraineur) throws SQLException
{
    String requete="select * from Equipe where entraineur=? ";
               PreparedStatement pst=cnx.prepareStatement(requete);
              pst.setString(1,Entraineur);
              ResultSet res=pst.executeQuery();
              return res.isBeforeFirst();
            
}
public int countJoueur(String Equipe) throws SQLException
{
     String requet="select count(*) as num from joueur inner join equipe on joueur.ID_Equipe=equipe.IDEquipe where equipe.nom=?";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setString(1,Equipe);
           ResultSet d=pst.executeQuery();
           int num=0;
           while (d.next())
           {
               num=d.getInt("num");
           }
           return num;
}


}
