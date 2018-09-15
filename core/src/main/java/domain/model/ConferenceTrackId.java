package domain.model;

import java.util.Objects;
import java.util.UUID;

public class ConferenceTrackId {
    private String id;

    public ConferenceTrackId() {
        this.id = UUID.randomUUID().toString();
    }

    public ConferenceTrackId(String id) {
        this.id = id;
    }

    public String value() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceTrackId that = (ConferenceTrackId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
