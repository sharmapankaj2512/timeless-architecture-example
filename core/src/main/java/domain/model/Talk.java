package domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public class Talk {
    private int minutes;
    private String title;

    public Talk(String title, int minutes) {
        setTitle(title);
        setMinutes(minutes);
    }

    private void setTitle(String title) {
        checkArgument(StringUtils.isNotBlank(title));
        this.title = title;
    }

    private void setMinutes(int minutes) {
        checkArgument(minutes >= 0 && minutes <= 59);
        this.minutes = minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Talk talk = (Talk) o;
        return minutes == talk.minutes &&
                Objects.equals(title, talk.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(minutes, title);
    }

    public String title() {
        return title;
    }

    public int minutes() {
        return minutes;
    }
}
