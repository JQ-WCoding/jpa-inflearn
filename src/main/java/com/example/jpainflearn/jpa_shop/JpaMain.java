package com.example.jpainflearn.jpa_shop;

import com.example.jpainflearn.jpa_shop.domain.Member;
import com.example.jpainflearn.jpa_shop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "hello" );
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 얻기
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName( "TeamA" );
            em.persist( team );


            Member member = new Member();
            member.setName( "member1" );
            member.setTeam( team );
            // member.setTeam( team );
            // team.getMembers()
            //         .add( member ); // 적용불가
            em.persist( member );

            em.flush();
            em.clear();

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
}