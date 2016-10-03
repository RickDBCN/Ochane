package me.Craviant.main;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import me.Craviant.main.Commands.Hello;
import me.Craviant.main.Commands.StaffChat;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import org.bson.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


import static java.util.Arrays.asList;


public class Ochane extends Plugin implements Listener {
    Logger mongoLogger = Logger.getLogger( "com.mongodb" );

    public void onEnable()
    {
        mongoLogger.setLevel(Level.SEVERE);
        // some fancy initalizing message for this awesome plugin
        getLogger().info("Ochane MAIN initializing..");
        getLogger().info("We will now be creating an awesome MongoDB connection.. lets try!");

        // creating MONGO connection - beta
        MongoClient mongoClient = new MongoClient();

        // Authenticate - not used yet
        MongoClientURI uri = new MongoClientURI("mongodb://superuser:12345678@localhost/?authSource=admin");

        // connect to database
        MongoDatabase db = mongoClient.getDatabase("retard");

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        db.getCollection("restaurants").insertOne(
                new Document("address",
                        new Document()
                                .append("street", "2 Avenue")
                                .append("zipcode", "10075")
                                .append("building", "1480")
                                .append("coord", asList(-73.9557413, 40.7720266)))
                        .append("borough", "Manhattan")
                        .append("cuisine", "Italian")
                        .append("grades", asList(
                                new Document()
                                        .append("date", "2014-10-01T00:00:00Z")
                                        .append("grade", "A")
                                        .append("score", 11),
                                new Document()
                                        .append("date", "2014-01-16T00:00:00Z")
                                        .append("grade", "B")
                                        .append("score", 17)))
                        .append("name", "Vella")
                        .append("restaurant_id", "41704620"));



        // lets load all this crap
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new StaffChat());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Hello());


    }


}