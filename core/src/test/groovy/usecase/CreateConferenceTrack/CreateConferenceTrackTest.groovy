package usecase.CreateConferenceTrack

import domain.model.ConferenceTrackId
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat
import static org.mockito.Mockito.mock

class CreateConferenceTrackTest extends Specification {
    private CreateConferenceTrack usecase = mock(CreateConferenceTrack)

    def "Empty Conference Track Scenario"() {
        given: "Empty input list"

        List<ConferenceTrackInput> input = new ArrayList<>()

        when: "CreateConferenceTrack usecase is invoked"

        Optional<ConferenceTrackId> conferenceTrackId = usecase.execute(input)

        then: "Track is not created"

        assertThat(conferenceTrackId).isEqualTo(Optional.empty())
    }

    def "Conference Track Without Any Talks Scenario"() {
        given: "Conference track without any talks"

        List<ConferenceTrackInput> input = [new ConferenceTrackInput()]

        when: "CreateConferenceTrack usecase is invoked"

        Optional<ConferenceTrackId> conferenceTrackId = usecase.execute(input)

        then: "Track is not created"

        assertThat(conferenceTrackId).isEqualTo(Optional.empty())
    }
}
