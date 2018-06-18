package kro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBManager {
    private static String url ;
    private static Properties props;

    static ArrayList<String> cheeseTopping = new ArrayList<>();
    static ArrayList<String> fruitTopping = new ArrayList<>();
    static ArrayList<String> herbSpiceTopping = new ArrayList<>();
    static ArrayList<String> meatTopping = new ArrayList<>();
    static ArrayList<String> nutTopping = new ArrayList<>();
    static ArrayList<String> sauceTopping = new ArrayList<>();
    static ArrayList<String> seafoodTopping = new ArrayList<>();
    static ArrayList<String> spicyTopping = new ArrayList<>();
    static ArrayList<String> vegetableTopping = new ArrayList<>();
    static ArrayList<String> dpBase = new ArrayList<>();
    static ArrayList<String> tcBase = new ArrayList<>();


    public static void init(Properties p) {
        url = p.getProperty("url");
        props = new Properties();
        props.setProperty("user", p.getProperty("user"));
        props.setProperty("password", p.getProperty("password"));
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, props);
    }

    public  static List<String> getSuggestionCheese(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM cheese_topping " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionFruit(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM fruit_topping " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionHerbSpice(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM  herb_spice_topping " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionNut(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM nut_topping " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionSauce(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM sauce_topping " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionSeaFood(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM seafood_topping " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionSpicy(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM spicy_topping " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionVegetable(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM vegetable_topping " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionMeat(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM  meat_topping " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionDPBase(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM  deep_pan_base " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public  static List<String> getSuggestionTCBase(String string){
        ArrayList<String> result = new ArrayList<>();
        string = string+"%";
        try{
            Connection con = connect();
            String query = "SELECT name " +
                    "FROM  thin_crispy_base " +
                    "WHERE name ilike ?";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,string);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name"));
            }
            rs.close();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    private static void insertPizza() {
        try{
            Connection con = connect();
            String query = "INSERT INTO pizza values ('pizza')" ;
            PreparedStatement stm = con.prepareStatement(query);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static void deletePizza() {
        try{
            Connection con = connect();
            String query = "delete from pizza where name like 'pizza'" ;
            PreparedStatement stm = con.prepareStatement(query);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public  static void addToDB(String topping,String table){
        try{
            Connection con = connect();
            String query = "INSERT INTO "+table+" values (?,?)" ;
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,"pizza");
            stm.setString(2,topping);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public  static void purgeDB(String table){
        try{
            Connection con = connect();
            String query = "delete from "+table+" where name_pizza like ?" ;
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,"pizza");
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getCheeseTopping() {
        return cheeseTopping;
    }

    public static ArrayList<String> getFruitTopping() {
        return fruitTopping;
    }

    public static ArrayList<String> getHerbSpiceTopping() {
        return herbSpiceTopping;
    }

    public static ArrayList<String> getMeatTopping() {
        return meatTopping;
    }

    public static ArrayList<String> getNutTopping() {
        return nutTopping;
    }

    public static ArrayList<String> getSauceTopping() {
        return sauceTopping;
    }

    public static ArrayList<String> getSeafoodTopping() {
        return seafoodTopping;
    }

    public static ArrayList<String> getSpicyTopping() {
        return spicyTopping;
    }

    public static ArrayList<String> getVegetableTopping() {
        return vegetableTopping;
    }

    public static ArrayList<String> getTcBase() {
        return tcBase;
    }

    public static ArrayList<String> getDpBase() {
        return dpBase;
    }

    public static void prepareDB() {
        insertPizza();
        for (int i = 0; i < cheeseTopping.size(); i++) {
            addToDB(cheeseTopping.get(i),"has_cheese");
        }
        for (int i = 0; i < fruitTopping.size(); i++) {
            addToDB(fruitTopping.get(i),"has_fruit");
        }
        for (int i = 0; i < meatTopping.size(); i++) {
            addToDB(meatTopping.get(i),"has_meat");
        }
        for (int i = 0; i < nutTopping.size(); i++) {
            addToDB(nutTopping.get(i),"has_nut");
        }
        for (int i = 0; i < sauceTopping.size(); i++) {
            addToDB(sauceTopping.get(i),"has_sauce");
        }
        for (int i = 0; i < seafoodTopping.size(); i++) {
            addToDB(seafoodTopping.get(i),"has_seafood");
        }
        for (int i = 0; i < herbSpiceTopping.size(); i++) {
            addToDB(herbSpiceTopping.get(i),"has_herbspice");
        }
        for (int i = 0; i < spicyTopping.size(); i++) {
            addToDB(spicyTopping.get(i),"has_spicy");
        }
        for (int i = 0; i < vegetableTopping.size(); i++) {
            addToDB(vegetableTopping.get(i),"has_vegetable");
        }
        for (int i = 0; i < tcBase.size(); i++) {
            addToDB(tcBase.get(i),"has_tcb");
        }
        for (int i = 0; i < dpBase.size(); i++) {
            addToDB(dpBase.get(i),"has_dpb");
        }
    }



    public static void clearDB() {
        deletePizza();
        purgeDB("has_cheese");
        purgeDB("has_fruit");
        purgeDB("has_meat");
        purgeDB("has_nut");
        purgeDB("has_sauce");
        purgeDB("has_seafood");
        purgeDB("has_herbspice");
        purgeDB("has_spicy");
        purgeDB("has_vegetable");
        purgeDB("has_tcb");
        purgeDB("has_dpb");
    }
}
