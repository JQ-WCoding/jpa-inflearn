package com.example.jpainflearn.hellojpa;

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

            /* Identity의 경우는 persist() 시점에 insert를 진행 (원래는 commit일 때, insert 함) => JPA 가 insert 시점에 id 값을 가지고 와서 이미 조회한 상태임 */
            TestMember testMember1 = new TestMember();
            testMember1.setUsername( "HelloJPA1" );

            TestMember testMember2 = new TestMember();
            testMember2.setUsername( "HelloJPA2" );

            TestMember testMember3 = new TestMember();
            testMember3.setUsername( "HelloJPA3" );

            TestMember testMember4 = new TestMember();
            testMember4.setUsername( "HelloJPA4" );

            em.persist( testMember1 );
            em.persist( testMember2 );
            em.persist( testMember3 );
            em.persist( testMember4 );


            // Member member = new Member( 200L, "member200" );
            // em.persist( member );
            //
            // em.flush(); // 강제 호출

            // Member member = em.find( Member.class, 150L );
            // member.setUsername( "AAAA" ); // persist()가 필요없다 => 엔티티와 스냅샷을 비교해서 변경감지 시, update 쿼리를 생성해서 DB에 던진다.

            // em.detach( member ); // JPA 에서 관리하지 않음 update 쿼리가 나가지 않음 (부분적)
            // em.clear(); // 준영속성 상태 (전체 비우기)
            // em.close(); // 컨텍스트를 종료 (이전 까지 내역 전부 X)

            // Member a = new Member( 150L, "A" );
            // Member b = new Member( 160L, "B" );
            //
            // em.persist( a );
            // em.persist( b );
            //
            System.out.println( "------------------기준점---------------------" );

            // // 해당의 경우 DB SELECT문은 한번만 한다 => 1차 캐싱하고 나서
            // Member member1 = em.find( Member.class, 101L );
            // Member member2 = em.find( Member.class, 101L );
            // System.out.println( "Result = " + (member1 == member2) ); // 해당 객체는 동일하다고 판단 (영속성을 보장)


            // // 비영속
            // Member member = new Member();
            // member.setId( 101L );
            // member.setName( "HelloJPA" );
            //
            // // 영속
            // System.out.println( "Before====================" );
            // em.persist( member );
            // System.out.println( "After=====================" );
            //
            //
            // em.find( Member.class, 101L );
            //
            // // 조회 시점이 DB SELECT 구문에서 가져오는게 아니라 1차 캐시에서 가져옴
            // System.out.println( "member.getId() = " + member.getId() );
            // System.out.println( "member.getName() = " + member.getName() );

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
