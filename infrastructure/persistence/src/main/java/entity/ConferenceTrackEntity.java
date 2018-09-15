package entity;

import domain.model.ConferenceTrack;
import domain.model.ConferenceTrackId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;
import java.util.stream.Collectors;

@Document
public class ConferenceTrackEntity {
    @Id
    public String id;
    public Set<TalkEntity> talks;

    private ConferenceTrackEntity() { }

    public ConferenceTrackEntity(ConferenceTrack conferenceTrack) {
        id = conferenceTrack.id().value();
        this.talks = conferenceTrack.talks()
                .stream()
                .map(TalkEntity::new)
                .collect(Collectors.toSet());
    }

    public ConferenceTrackId id() {
        return new ConferenceTrackId(id);
    }
}
