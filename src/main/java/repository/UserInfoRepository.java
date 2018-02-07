package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import hello.UserInfo2;

@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo2, String> {

	//UserInfo2 insert(UserInfo user);

	UserInfo2 findByEmail(String email);


}
