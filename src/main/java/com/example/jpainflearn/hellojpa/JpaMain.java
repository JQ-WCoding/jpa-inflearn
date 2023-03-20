package com.example.jpainflearn.hellojpa;

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
            // 비영속
            Member member = new Member();
            member.setId( 100L );
            member.setName( "HelloJPAA" );

            // 영속
            System.out.println( "Before====================" );
            em.persist( member );
            System.out.println( "After=====================" );


            // Member member = new Member();
            // member.setId( 2L );
            // member.setName( "HelloB" );

            // List<Member> result = em.createQuery( "select m from Member as m ", Member.class )
            //         .setFirstResult( 1 )
            //         .setMaxResults( 10 )
            //         .getResultList();
            //
            // for ( Member member : result ) {
            //     System.out.println( "meber.getName() = " + member.getName() );
            // }
            // Member member = em.find( Member.class, 1L );
            // member.setName( "HelloJPA" );
            // persist 를 할 필요가 없음

            // System.out.println( "memberId = " + member.getId() );
            // System.out.println( "memberName = " + member.getName() );

            // em.persist( member );

            // transcation 커밋 상태일 때, 영속 상태의 객체들이 DB에 접근함
            tx.commit();
        } catch ( Exception e ) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
