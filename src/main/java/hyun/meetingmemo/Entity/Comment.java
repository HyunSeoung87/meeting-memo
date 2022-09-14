package hyun.meetingmemo.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "note_id")
    private Note note;

    @Column(columnDefinition = "text")
    @Setter
    private String text;

    private LocalDateTime createdAt;

    public Comment(Note note, User writer, String text, LocalDateTime createdAt) {
        this.note = note;
        this.writer = writer;
        this.text = text;
        this.createdAt = createdAt;
    }

}
