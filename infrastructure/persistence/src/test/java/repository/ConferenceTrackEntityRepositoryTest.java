package repository;

import domain.model.ConferenceTrack;
import domain.model.ConferenceTrackId;
import domain.model.Talk;
import entity.ConferenceTrackEntity;
import entity.TalkEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Collections.singleton;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConferenceTrackEntityRepositoryTest {

    @Autowired
    ConferenceTrackEntityRepository conferenceTrackEntityRepository;

    @Test
    public void itShouldStoreAndFetchTracks() {
        ConferenceTrack track = new ConferenceTrack();
        Talk talk = new Talk("DDD meets use-case", 10);
        track = track.add(singleton(talk));

        ConferenceTrackId conferenceTrackId = conferenceTrackEntityRepository.create(track);
        ConferenceTrackEntity actual = conferenceTrackEntityRepository.findById(conferenceTrackId.value()).get();

        assertThat(actual.id()).isEqualTo(track.id());
        assertThat(actual.talks).containsExactly(new TalkEntity(talk));
    }
}
