package me.Craviant.main.Database;


import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity(value = "Users", noClassnameStored = true)
public class User {
    @Id
    public int id;
    @Indexed(options = @IndexOptions(unique = true))
    public String uuid;

    @Indexed
    public String username;

    public int ip;

    public long connectionTime;

    @Property("ip_history")
    public List<Integer> iphistory = new ArrayList<>();

    @Property("name_history")
    public List<String> nameHistory = new ArrayList<>();


}
