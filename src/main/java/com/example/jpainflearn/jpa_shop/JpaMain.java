package com.example.jpainflearn.jpa_shop;

import antlr.StringUtils;
import com.example.jpainflearn.jpa_shop.domain.Book;
import com.example.jpainflearn.jpa_shop.domain.Member;
import com.example.jpainflearn.jpa_shop.domain.Order;
import com.example.jpainflearn.jpa_shop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "hello" );
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 얻기
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // Book book = new Book();
            // book.setName( "JPA" );
            // book.setAuthor( "LGJ" );
            //
            // em.persist( book );

            // Member member = em.find( Member.class, 1L );
            // // printMemberAndTeam( member );
            //
            // printMember( member );

            Member member1 = new Member();
            member1.setName( "member1" );
            em.persist( member1 );


            Member member2 = new Member();
            member2.setName( "member2" );
            em.persist( member2 );

            em.flush();
            em.clear();

            Member findMember1 = em.find( Member.class, member1.getId() );
            Member findMember2 = em.getReference( Member.class, member2.getId() );

            System.out.println( "findMember1.getTeam().getClass() = " + findMember1.getTeam().getClass() );

            // getReference 로 가져오면 type 비교 시, false
            System.out.println( "findMember1 == findMember2 = " + (findMember1.getClass() == findMember2.getClass()) );
            findMember2.getName();
            System.out.println( "isLoaded = " + emf.getPersistenceUnitUtil()
                    .isLoaded( findMember2 ) ); // proxy 로딩 시점을 확인할 수 있다.

            /*
            Member member = new Member();
            member.setName( "hello" );

            em.persist( member );

            em.flush();
            em.clear();

            Member referenceMember = em.getReference( Member.class, member.getId() ); // 호줄하는 시점에는 DB에 접속하지 않음
            System.out.println( "referenceMember = " + referenceMember.getClass() );
            System.out.println( "referenceMember.getName() = " + referenceMember.getName() ); // 실질적으로 호출할 때, DB에 접속
            */

            // Member findMember = em.find( Member.class, member.getId() );
            // System.out.println( "findMember.getName() = " + findMember.getName() );
            // System.out.println( "findMember.getId() = " + findMember.getId() );

            // Team team = new Team();
            // team.setName( "TeamA" );
            // em.persist( team );
            //
            //
            // Member member = new Member();
            // member.setName( "member1" );
            // member.changeTeam( team ); // member 에 team을 세팅하는 시점에 team에도 member를 세팅
            // member.setTeam( team );
            // team.getMembers()
            //         .add( member ); // 적용불가

            // em.persist( member );

            // team.addMember( member );

            // team.getMembers().add( member );

            // em.flush();
            // em.clear();
            //
            // Team findTeam = em.find( Team.class, team.getId() );
            // List<Member> members = findTeam.getMembers();
            //
            // System.out.println("==============================================");
            // for ( Member m : members ) {
            //     System.out.println( "m.getName() = " + m.getName() );
            // }
            // System.out.println("==============================================");

            // Member findMember = em.find( Member.class, member.getId() );
            // List<Member> members = findMember.getTeam()
            //         .getMembers();
            //
            // for ( Member m : members ) {
            //     System.out.println( "m.getName() = " + m.getName() );
            // }

            // Team findTeam = findMember.getTeam();
            // System.out.println( "findTeam.getName() = " + findTeam.getName() );
            // 객체 지향스럽지 않은 방식

            // Team newTeam = em.find( Team.class, 100L ); // 100id 팀이 있다는 가정
            // findMember.setTeam( newTeam );

            tx.commit();
        } catch ( Exception e ) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }

    private static void printMember(Member member) {
        System.out.println( "member.getName()  = " + member.getName() );
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getName();
        System.out.println( "username = " + username );

        System.out.println( "==============================" );

        Team team = member.getTeam();
        System.out.println( "team.getName() = " + team.getName() );
    }
}