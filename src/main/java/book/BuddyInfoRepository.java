package book;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddyInfo", path = "BuddyInfo")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    List<BuddyInfo> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    List<BuddyInfo> findByAddress(@Param("address") String address);
    List<BuddyInfo> findByName(@Param("name") String name);
}
