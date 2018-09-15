package entity;

import domain.model.Talk;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

public class TalkEntity {
    public String title;
    public int minutes;

    private TalkEntity() {
    }

    public TalkEntity(Talk talk) {
        title = talk.title();
        minutes = talk.minutes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TalkEntity that = (TalkEntity) o;
        return minutes == that.minutes &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, minutes);
    }
}
