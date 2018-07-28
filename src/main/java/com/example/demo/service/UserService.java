package com.example.demo.service;

import com.example.demo.parser.dto.UserDto;
import com.example.demo.persistence.entity.UserEntity;
import com.example.demo.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

//    @PersistenceContext
//    private EntityManager em;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<UserDto> registerAll(List<UserDto> users){
//        List<UserDto> userDtos = new ArrayList<>();
//        users.forEach(userDto -> {
//            UserEntity entity = userRepository.insertWithNativeQuery(userDto.getId(),userDto.getAboutMe(),
//                    userDto.getAccountId(),userDto.getCreationDate(),
//                    userDto.getDisplayName(),userDto.getDownVotes(),userDto.getLastAccessDate(),
//                    userDto.getLocation(),userDto.getProfileImageUrl(),userDto.getReputation(),
//                    userDto.getUpVotes(),userDto.getViews(),userDto.getWebsiteUrl());
//            userDtos.add(UserDto.mapEntityToDto(entity));
//        });
//        return userDtos;
        return UserDto.mapEntitiesToDtos(userRepository.saveAll(UserDto.mapDtosToEntities(users)));
        /*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        for(int i=0;i<users.size();++i){
            session.save(users.get(i));
            if ( i % 50 == 0 ) { //20, same as the JDBC batch size
                //flush a batch of inserts and release memory:
                session.flush();
                session.clear();
            }
        }
        transaction.commit();
        session.close();
        return UserDto.mapEntitiesToDtos(userRepository.findAll());
*/
         // entityManager
        /*final List<UserEntity> savedEntities = new ArrayList<>();
        int i = 0;
        List<UserEntity> entities = UserDto.mapDtosToEntities(users);
        for (UserEntity t : entities) {
            em.persist(t);
            savedEntities.add(t);
            i++;
            if (i % 5000 == 0) {
                // Flush a batch of inserts and release memory.
                em.flush();
                em.clear();
            }
        }
        return UserDto.mapEntitiesToDtos(savedEntities);
        */
        /*
        Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();


for ( int i=0; i<100000; i++ ) {
Customer customer = new Customer(.....);
session.save(customer);
    if ( i % 20 == 0 ) { //20, same as the JDBC batch size
        //flush a batch of inserts and release memory:
        session.flush();
        session.clear();
    }
}

tx.commit();
session.close();
        * */
    }

    public boolean existsById(Long id){
        return userRepository.existsById(id);
    }

    public UserEntity register(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity getEntityById(Long id){
        return userRepository.getOne(id);
    }

}
