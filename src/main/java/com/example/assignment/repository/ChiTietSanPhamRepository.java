package com.example.assignment.repository;

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamRepository {
    public List<ChiTietSanPham> getList() {
        List<ChiTietSanPham> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From ChiTietSanPham", ChiTietSanPham.class);
            list = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public ChiTietSanPham getById(UUID id) {
        ChiTietSanPham chiTietSP = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From ChiTietSanPham where id=:id", ChiTietSanPham.class);
            query.setParameter("id", id);
            chiTietSP = (ChiTietSanPham) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return chiTietSP;
    }

    public Boolean add(ChiTietSanPham ctsp) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ctsp);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean update(ChiTietSanPham ctsp) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ctsp);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean delete(ChiTietSanPham ctsp) {
        Transaction transaction;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<ChiTietSanPham> getByName(String ten) {
        List<ChiTietSanPham> chiTietSP = null;

        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From ChiTietSanPham where ten=:ten", ChiTietSanPham.class);
            query.setParameter("ten", ten);
            chiTietSP = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

}
