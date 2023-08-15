package weby.kiwi.domain.collection.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import weby.kiwi.domain.word.Word;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name="Collection")
public class Collection {
    @Id
    @GeneratedValue
    @Column(name = "user_id", nullable = false)
    private int user_id; //GeneratedValue로 pk생성 옵션
    @MapsId("user_id") //fk를 pk로

    @OneToMany(mappedBy = "Collection")//한개의 collection에는 여러개의 단어가 연결될 수 있음
    @Column(nullable = true)
    private List<Word> word = new ArrayList<>();

    @Column(nullable = true)
    private int year;

    @Column(nullable = true)
    private int month;

    public Collection(int user_id, List<Word> word, int year, int month) {
        this.user_id = user_id;
        this.word = word;
        this.year = year;
        this.month = month;
    }

    public int getUser_id() {
        return user_id;
    }

    public List<Word> getWord() {
        return word;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }
}
