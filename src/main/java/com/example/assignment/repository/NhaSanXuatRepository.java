package com.example.assignment.repository;

import com.example.assignment.entity.NhaSanXuat;
import com.example.assignment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhaSanXuatRepository {
    public List<NhaSanXuat> getList() {
        List<NhaSanXuat> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From NhaSanXuat order by ma ASC", NhaSanXuat.class);
            list = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public NhaSanXuat getById(UUID id) {
        NhaSanXuat nhaSX = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From NhaSanXuat where id=:id", NhaSanXuat.class);
            query.setParameter("id", id);
            nhaSX = (NhaSanXuat) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nhaSX;
    }

    public NhaSanXuat getNhaSxByMa(String ma) {
        NhaSanXuat nhaSX = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From NhaSanXuat where ma=:ma", NhaSanXuat.class);
            query.setParameter("ma", ma);
            nhaSX = (NhaSanXuat) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nhaSX;
    }

    public Boolean add(NhaSanXuat nhaSX) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhaSX);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean update(NhaSanXuat nhaSX) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhaSX);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean delete(NhaSanXuat nhaSX) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhaSX);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<NhaSanXuat> getByName(String ten) {
        List<NhaSanXuat> nhaSX = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From NhaSanXuat where ten=:ten", NhaSanXuat.class);
            query.setParameter("ten", ten);
            nhaSX = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhaSX;
    }

}
