package usecase.CreateConferenceTrack;

import domain.model.ConferenceTrack;
import domain.model.ConferenceTrackId;
import domain.model.Talk;
import domain.repository.CreateConferenceTrackRepository;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class CreateConferenceTrack {
    private CreateConferenceTrackRepository repository;

    public CreateConferenceTrack(CreateConferenceTrackRepository repository) {
        this.repository = repository;
    }

    public Optional<ConferenceTrackId> execute(ConferenceTrackInput input) {
        if (input.hasTalks()) {
            ConferenceTrack track = new ConferenceTrack();
            track = track.add(talks(input));
            return Optional.of(repository.create(track));
        }
        return Optional.empty();
    }

    private Set<Talk> talks(ConferenceTrackInput input) {
        return input.talks
                .stream()
                .map(t -> new Talk(t.title, t.minutes))
                .collect(toSet());
    }
}
