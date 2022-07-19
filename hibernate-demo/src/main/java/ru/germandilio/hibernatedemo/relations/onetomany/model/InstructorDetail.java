package ru.germandilio.hibernatedemo.relations.onetomany.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    /**
     * Example of bidirectional one-to-one mapping. This has a dramatic performance impact and also don't support
     * Lazy fetch, so it is better to use @MapsId, to share the same id on the connected instances.
     */
    @ToString.Exclude
    @OneToOne(mappedBy = "detail",
            cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH,  CascadeType.MERGE})
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
}
