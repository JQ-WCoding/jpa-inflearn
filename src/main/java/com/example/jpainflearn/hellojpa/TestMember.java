package com.example.jpainflearn.hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@SequenceGenerator ( name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ", allocationSize = 50 ) // 시퀀스 전략
@Table(name = "testMemeber")
// @TableGenerator ( name = "MEMBER_SEQ_GENERATOR", table = "MY_SEQUENCES", pkColumnName = "MEMBER_SEQ", allocationSize = 1 ) // 테이블 전략
public class TestMember {

    public TestMember() {
    }

    @Id
    // @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR" )
    private Long id;

    @Column ( name = "name", length = 10 ) // DDL 생성 기능 JPA 실행 로직에는 영향을 주지 않는다.
    private String username;


    // @Column ( updatable = false, nullable = false )
    // private Integer age;
    //
    // @Enumerated ( EnumType.STRING ) // ORDINAL 사용 X -> 기본 int 형으로 저장되서 Enum 의 순서가 변경되면 전혀 의도하지 않은 값이 들어갈 수 있다.
    // private RoleType roleType;
    //
    // @Temporal ( TemporalType.TIMESTAMP )
    // private Date createdDate; // Date 클래스는 과거, 요즘은 LocalDateTime 과 같은 클래스를 사용하면 Temporal 사용 필요 없음
    //
    // @Temporal ( TemporalType.TIMESTAMP )
    // private Date lastModifiedDate;
    //
    // @Lob // varchar 이상
    // private String description;
    //
    // @Transient // 메모리에서만 사용할 컬럼
    // private int temp;
}
