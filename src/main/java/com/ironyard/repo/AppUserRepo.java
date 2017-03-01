package com.ironyard.repo;

import com.ironyard.data.AppUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wailm.yousif on 2/28/17.
 */
public interface AppUserRepo extends CrudRepository<AppUser, Long> {
    public AppUser findByUsernameAndPassword(String username, String password);
}
