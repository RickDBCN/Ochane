package me.Craviant.main.Database;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;


import java.util.ArrayList;

public class MongoConnect {

    private MongoClient mc;
    private Morphia morphia;
    private Datastore datastore;
    private UserDAO userDAO;


    public MongoConnect(int i)
    {
        mc = new MongoClient();
        morphia = new Morphia();

        morphia.map(User.class);

        datastore = morphia.createDatastore(mc, "retard");
        datastore.ensureIndexes();

        userDAO = new UserDAO(User.class, datastore);

    }
}
