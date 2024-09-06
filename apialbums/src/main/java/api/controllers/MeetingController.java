package api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/meetings")
@Slf4j
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Meeting>> listMeetings(@RequestParam(value = "status") Optional<EStatus> status) {
        return ResponseEntity.ok(meetingService.list(status));
    }

    @GetMapping(value = "/next-planned-dates", produces = "application/json")
    public ResponseEntity<List<LocalDateTime>> getNextPlannedDates() {
        return ResponseEntity.ok(meetingService.nextPlannedDates());
    }

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Meeting> createMeeting(@RequestBody Meeting meeting) {
        Meeting createdMeeting = meetingService.createOrUpdate(meeting);
        return ResponseEntity.ok(createdMeeting);
    }

    @PutMapping(value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Meeting> updateMeeting(@RequestBody Meeting meeting) {
        Meeting updatedMeeting = meetingService.createOrUpdate(meeting);
        return ResponseEntity.ok(updatedMeeting);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Meeting> getMeeting(@PathVariable UUID id) {
        return ResponseEntity.ok(meetingService.get(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteMeeting(@PathVariable UUID id) {
        meetingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/summary", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> getSummary(@PathVariable UUID id) throws IOException {
        InputStream summary = meetingService.getSummary(id);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, String.format("inline; filename=\"%s.md\"", id.toString()));

        return new ResponseEntity<>(
                summary.readAllBytes(),
                responseHeaders,
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/{id}/summary/pdf", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> getSummaryInPDF(@PathVariable UUID id) throws IOException {
        throw new NotImplementedException("This feature is not implemented yet");
    }

}
