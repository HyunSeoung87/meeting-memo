package hyun.meetingmemo.Entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User writer;

    @Setter
    private String title;

    @Setter
    private String place;

    @Setter
    private String attendee;

    @Column(columnDefinition = "text")
    @Setter
    private String text;

    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "note")
    private List<Attachment> attachments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "note")
    private List<Comment> comments;

    public Note(User writer, String title, String place, String attendee, String text, LocalDateTime createdAt) {
        this.writer = writer;
        this.title = title;
        this.place = place;
        this.attendee = attendee;
        this.text = text;
        this.createdAt = createdAt;
    }
}
