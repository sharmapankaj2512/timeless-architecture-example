package domain.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableCollection;

public class ConferenceTrack {
    private ConferenceTrackId id = new ConferenceTrackId();
    private Set<Talk> talks;

    public ConferenceTrack() {
        talks = new HashSet<>();
    }

    private ConferenceTrack(Set<Talk> talks) {
        this.talks = talks;
    }

    public ConferenceTrackId id() {
        return id;
    }

    public Collection<Talk> talks() {
        return unmodifiableCollection(talks);
    }

    public ConferenceTrack add(Set<Talk> talks) {
        return new ConferenceTrack(talks);
    }
}
