package domain.repository;

import domain.model.ConferenceTrack;
import domain.model.ConferenceTrackId;

public interface CreateConferenceTrackRepository {
    ConferenceTrackId create(ConferenceTrack conferenceTrack);
}
