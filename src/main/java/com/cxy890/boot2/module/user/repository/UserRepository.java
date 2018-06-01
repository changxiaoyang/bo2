package com.cxy890.boot2.module.user.repository;

import com.cxy890.boot2.module.user.domain.CurrentUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author BD-PC27
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<CurrentUser, Long>, JpaSpecificationExecutor<CurrentUser> {
}
