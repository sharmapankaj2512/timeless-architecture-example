package spike.controller;

import domain.model.ConferenceTrackId;
import domain.repository.CreateConferenceTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import usecase.CreateConferenceTrack.ConferenceTrackInput;
import usecase.CreateConferenceTrack.CreateConferenceTrack;

import java.util.Optional;

@RestController
public class ConferenceTrackController {

    private final CreateConferenceTrack usecase;

    @Autowired
    public ConferenceTrackController(CreateConferenceTrackRepository repository) {
        usecase = new CreateConferenceTrack(repository);
    }

    @PostMapping("/api/v1/conference-tracks")
    public String create(@RequestBody ConferenceTrackInput input) {
        return usecase.execute(input).map(ConferenceTrackId::value).orElse("");
    }
}
