package repository;

import domain.model.ConferenceTrack;
import domain.model.ConferenceTrackId;
import domain.repository.CreateConferenceTrackRepository;
import entity.ConferenceTrackEntity;
import entity.TalkEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
public interface ConferenceTrackEntityRepository extends
        MongoRepository<ConferenceTrackEntity, String>,
        CreateConferenceTrackRepository {

    default ConferenceTrackId create(ConferenceTrack conferenceTrack) {
        return save(new ConferenceTrackEntity(conferenceTrack)).id();
    }
}
