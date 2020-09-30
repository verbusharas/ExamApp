package lt.verbus.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "full_name")
    private String fullName;

    private Integer result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_exam")
    private Exam exam;

    public Student(){

    }

    public Student(Long id, String fullName, Integer result, Exam exam) {
        this.id = id;
        this.fullName = fullName;
        this.result = result;
        this.exam = exam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
