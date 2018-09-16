package usecase.CreateConferenceTrack;

public class TalkInput {
    public String title;
    public int minutes;

    public TalkInput() { }

    public TalkInput(String title, int minutes) {
        this.title = title;
        this.minutes = minutes;
    }
}
