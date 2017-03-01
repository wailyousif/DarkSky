package com.ironyard.repo;

import com.ironyard.data.AppUser;
import com.ironyard.data.Hist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wailm.yousif on 2/28/17.
 */
public interface HistRepo extends PagingAndSortingRepository<Hist, Long> {
    public Page<Hist> findByAppUser(AppUser appUser, Pageable pageable);
}
