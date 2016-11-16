package com.clara;

import java.sql.*;

public class Controller {


    private Database db;

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.setupDatabase();
    }


    void setupDatabase() {

        //Create database
        db = new Database();

        //Create table, and add test data
        db.createTable();

        db.addTestData();

        ResultSet snakeResultSet = null;
        SnakeModel snakeModel;

        try {
            snakeResultSet = db.getAllDataResultSet();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        snakeModel = new SnakeModel(snakeResultSet);

        //Create and show the GUI
        SnakeInfoGUI tableGUI = new SnakeInfoGUI(this, snakeModel);


    }

    void shutdown() {
        db.shutdown();

        System.exit(-1);
    }

}






