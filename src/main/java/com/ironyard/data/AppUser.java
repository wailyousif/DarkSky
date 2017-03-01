package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wailm.yousif on 2/28/17.
 */

@Entity
public class AppUser
{
    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String password;
    private String displayName;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private List<Hist> hists;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /*
    public List<Hist> getHists() {
        return hists;
    }

    public void setHists(List<Hist> hists) {
        this.hists = hists;
    }
    */
}
