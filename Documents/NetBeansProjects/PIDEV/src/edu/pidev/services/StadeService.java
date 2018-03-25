/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidev.services;

import edu.pidev.entities.Joueur;
import edu.pidev.entities.Stade;
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
public class StadeService {
     public Connection cnx;

    public StadeService() throws SQLException {
        this.cnx = BDConn.getInstance().getConnection();
    }
    public void ajouterStade(Stade s) throws SQLException
    {
       String requete="Insert into Stade(nom,ville,capacite,photostade,Description,Wifi,Toit,Adresse,Surface) values(?,?,?,?,?,?,?,?,?)";
                  PreparedStatement pst=cnx.prepareStatement(requete);
           pst.setString(1,s.getNom());
           pst.setString(2, s.getVille());
           pst.setInt(3, s.getCapacite());
           pst.setString(4, s.getPhotoStade());
           pst.setString(5, s.getDescription());
           pst.setString(6, s.getWifi());
           pst.setString(7, s.getToit());
           pst.setString(8, s.getAdresse());
           pst.setString(9, s.getSurface());
           pst.executeUpdate();
    }
    public List<Stade> afficherStade() throws SQLException
    {
          List<Stade> l=new ArrayList();
            Statement x=cnx.createStatement();
        ResultSet res=x.executeQuery("select * from Stade");
        while(res.next())
        {
            Stade s=new Stade();
            s.setNom(res.getString("Nom"));
            s.setVille(res.getString("ville"));
            s.setCapacite(res.getInt("capacite"));
            s.setPhotoStade(res.getString("photoStade"));
            s.setDescription(res.getString("description"));
            s.setWifi(res.getString("wifi"));
            s.setToit(res.getString("toit"));
            s.setAdresse(res.getString("Adresse"));
            s.setSurface(res.getString("Surface"));
            l.add(s);
        }
        return l;
    }
     public void supprimerStade(String nom) throws SQLException
       {
                      String requet="Delete from Stade where nom=?";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setString(1,nom);
           pst.executeUpdate();
       }
     public void modifierStade(Stade s) throws SQLException
     {
         String requete="Update Stade set nom=?,ville=?,capacite=?,Photostade=?,Description=?,Wifi=?,Toit=?,Adresse=?,Surface=? where ID_Stade=?";
                     PreparedStatement pst=cnx.prepareStatement(requete);
           pst.setString(1,s.getNom());
           pst.setString(2, s.getVille());
           pst.setInt(3, s.getCapacite());
           pst.setString(4, s.getPhotoStade());
           pst.setString(5, s.getDescription());
           pst.setString(6, s.getWifi());
           pst.setString(7, s.getToit());
           pst.setString(8, s.getAdresse());
           pst.setString(9, s.getSurface());
                      pst.setInt(10, s.getIdStade());

                      pst.executeUpdate();

     }
     public Stade rechercherStadeParNom(String nom) throws SQLException
     {
         Stade s=new Stade();
            String requet="select * from Stade where nom=?";
           PreparedStatement pst=cnx.prepareStatement(requet);
           pst.setString(1,nom);
           ResultSet res=pst.executeQuery();
           while (res.next())
           {
               s.setIdStade(res.getInt("ID_Stade"));
               s.setNom(res.getString("Nom"));
            s.setVille(res.getString("ville"));
            s.setCapacite(res.getInt("capacite"));
            s.setPhotoStade(res.getString("photoStade"));
            s.setDescription(res.getString("description"));
            s.setWifi(res.getString("wifi"));
            s.setToit(res.getString("toit"));
            s.setAdresse(res.getString("Adresse"));
            s.setSurface(res.getString("Surface"));
           }
           return s;
     }
}
