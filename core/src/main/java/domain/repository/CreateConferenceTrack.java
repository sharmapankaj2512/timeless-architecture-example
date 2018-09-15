package domain.repository;

import domain.model.ConferenceTrack;
import domain.model.ConferenceTrackId;

public interface CreateConferenceTrack {
    ConferenceTrackId create(ConferenceTrack conferenceTrack);
}
