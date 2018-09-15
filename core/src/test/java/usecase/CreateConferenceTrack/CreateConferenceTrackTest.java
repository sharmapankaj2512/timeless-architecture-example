package usecase.CreateConferenceTrack;

import domain.model.ConferenceTrack;
import domain.model.ConferenceTrackId;
import domain.model.Talk;
import domain.repository.CreateConferenceTrackRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateConferenceTrackTest {
    private CreateConferenceTrackRepository repository;
    private CreateConferenceTrack usecase;
    private ArgumentCaptor<ConferenceTrack> captor;

    @BeforeEach
    void beforeEach() {
        repository = mock(CreateConferenceTrackRepository.class);
        usecase = new CreateConferenceTrack(repository);
        captor = ArgumentCaptor.forClass(ConferenceTrack.class);
    }

    @Nested
    class GivenConferenceTrack {

        @Nested
        class WhenItHasNoTalks {
            private ConferenceTrackInput input;

            @BeforeEach
            void beforeEach() {
                input = new ConferenceTrackInput(emptyList());
            }

            @Test
            void thenTrackShouldNotBeCreated() {
                Optional<ConferenceTrackId> conferenceTrackId = usecase.execute(input);

                assertThat(conferenceTrackId).isEqualTo(Optional.empty());
            }
        }

        @Nested
        class WhenItHasTalks {
            private TalkInput talk;
            private ConferenceTrackInput input;

            @BeforeEach
            void beforeEach() {
                talk = new TalkInput("DDD meets Use-cases", 10);
                input = new ConferenceTrackInput(singletonList(talk));

                doAnswer(invocation -> ((ConferenceTrack) invocation.getArgument(0)).id())
                        .when(repository).create(any(ConferenceTrack.class));
            }

            @Test
            void thenTrackWithUniqueIdAndTalksIsCreated() {
                Optional<ConferenceTrackId> conferenceTrackId = usecase.execute(input);

                verify(repository, timeout(1)).create(captor.capture());

                ConferenceTrack conferenceTrack = captor.getValue();

                assertThat(conferenceTrackId).isNotEqualTo(Optional.empty());
                assertThat(conferenceTrackId).get().isEqualTo(conferenceTrack.id());
                assertThat(conferenceTrack.talks()).containsExactly(new Talk("DDD meets Use-cases", 10));
            }
        }
    }

}
