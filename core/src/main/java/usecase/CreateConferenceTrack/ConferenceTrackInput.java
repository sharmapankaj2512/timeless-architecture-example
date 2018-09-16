package usecase.CreateConferenceTrack;

import java.util.List;

public class ConferenceTrackInput {
    public List<TalkInput> talks;

    public ConferenceTrackInput() { }

    public ConferenceTrackInput(List<TalkInput> talks) {
        this.talks = talks;
    }

    public boolean hasTalks() {
        return talks != null && talks.size() > 0;
    }
}
