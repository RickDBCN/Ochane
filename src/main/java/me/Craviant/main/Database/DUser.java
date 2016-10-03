package me.Craviant.main.Database;


import com.mongodb.MongoClient;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DUser {
    private MongoClient mc;
    private Morphia morphia;
    private Datastore datastore;
    private UserDAO userDAO;

    public DUser getUserByPlayer(ProxiedPlayer p) {

        Duser du = userDAO.findOne("uuid", p.getName().toString());
        if (du == null) {

            du = new DUser();
            du.setIp(PlayerUtils.inetAddressAsInteger(p.getAddress().getAddress()));
            du.setUsername(p.getName());
            userDAO.save(du);


        }
        return du;
        //public void saveUser(DUuser user)
        //{
        //   userDAO.save(user);
        // }
    }
}

